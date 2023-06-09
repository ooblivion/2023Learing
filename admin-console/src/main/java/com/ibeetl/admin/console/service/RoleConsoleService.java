package com.ibeetl.admin.console.service;

import java.util.List;
import java.util.Map;

import com.ibeetl.admin.console.web.query.RoleQuery;
import com.ibeetl.admin.console.web.query.RoleUserQuery;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.console.dao.RoleConsoleDao;
import com.ibeetl.admin.core.entity.CoreRole;
import com.ibeetl.admin.core.entity.CoreUser;
import com.ibeetl.admin.core.rbac.tree.OrgItem;
import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.service.CorePlatformService;
import com.ibeetl.admin.core.util.PlatformException;
import com.ibeetl.admin.core.util.enums.RoleTypeEnum;

@Service
@Transactional
public class RoleConsoleService extends CoreBaseService<CoreRole> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleConsoleService.class);

    @Autowired
    private RoleConsoleDao roleDao;
    
    @Autowired
    @Qualifier("coreSqlManager")
    private SQLManager sqlManager;

    @Autowired
    CorePlatformService platformService;

    /**
     * 获取全部操作角色集合
     * @return
     */
    public List<CoreRole> queryAllPermissionList() {
    	CoreRole template = new CoreRole();
    	template.setType(RoleTypeEnum.ACCESS.getValue());
        return roleDao.template(template);
    }

    /**
     * 根据删标记获取全部角色集合
     * @param delFlagEnum 删除标记
     * @return
     */
    public List<CoreRole> queryAllList() {
        return roleDao.all();
    }

    /**
     * 根据条件查询
     * @param condition
     */
    public PageResult<CoreRole> queryByCondition(RoleQuery condition) {
		PageRequest pageRequest = condition.getPageRequest();
		Map params = condition.getPageParam();
		PageResult<CoreRole> pageResult =  roleDao.queryByCondition(pageRequest,params);
        super.queryListAfter(pageResult.getList());
        return pageResult;
    }

    
    public PageResult<CoreUser> queryRoleUser(RoleUserQuery condition) {
    	OrgItem root = platformService.buildOrg();
    	PageRequest pageRequest = condition.getPageRequest();
    	Map params = condition.getPageParam();
		PageResult<CoreUser>  ret = roleDao.queryUser(pageRequest,params);
    	List<CoreUser> list = ret.getList();
    	//从缓存里取出组织机构名称
    	for(CoreUser user:list) {
    		Long orgId = user.getOrgId();
    		Integer orgId1 = (Integer)user.get("orgId1");
    		user.set("orgIdText", root.findChild(orgId).getName());
    		user.set("orgId1Text", root.findChild((long)orgId1).getName());
    		
    	}
    	//再次处理数据字典
    	this.queryListAfter(list);
    	return ret;
    	 
    }

    /**
     * 根据编号查询
     * @param code 角色编号
     * @return
     */
    public CoreRole queryByCode(String code) {
        CoreRole queryRole = new CoreRole();
        queryRole.setCode(code);
        CoreRole role = roleDao.templateOne(queryRole);
        return role;
    }


    public boolean deleteById(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new PlatformException("删除数据ID不能为空");
        }
        
        roleDao.batchDelByIds(ids);
        roleDao.batchDeleteRoleFunction(ids);
        roleDao.batchDeleteRoleMenu(ids);
        roleDao.batchDeleteUserRole(ids);
        return true;
    }
    
    
   

}
