package com.ibeetl.admin.console.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibeetl.admin.console.web.query.OrgQuery;
import com.ibeetl.admin.console.web.query.OrgUserQuery;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.console.dao.OrgConsoleDao;
import com.ibeetl.admin.core.entity.CoreOrg;
import com.ibeetl.admin.core.entity.CoreUser;
import com.ibeetl.admin.core.rbac.tree.OrgItem;
import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.service.CorePlatformService;
import com.ibeetl.admin.core.util.PlatformException;

/**
 * 
 * @author : xiandafu
 */
@Service
@Transactional
public class OrgConsoleService extends CoreBaseService<CoreOrg> {

    @Autowired
    private OrgConsoleDao orgDao;

    @Autowired
    private CorePlatformService platformService;

    /**
     * 根据条件查询
     * @param query
     */
    public PageResult<CoreOrg> queryByCondition(OrgQuery condition) {
		PageRequest request = condition.getPageRequest();
		Map params = condition.getPageParam();
		PageResult<CoreOrg> pageResult =  orgDao.queryByCondition(request,params);
        List<CoreOrg> list = pageResult.getList();
        queryListAfter(list);
        OrgItem root = platformService.buildOrg();
        //处理父机构名称显示，没有用sql查询是考虑到跨数据库
        for(CoreOrg org:list) {
        	Long parentId = org.getParentOrgId();
        	OrgItem item = root.findChild(parentId);
        	String name = item!=null?item.getName():"";
        	org.set("parentOrgText", name);
        }
        return pageResult;
    }
    
    public PageResult<CoreUser> queryUserByCondition(OrgUserQuery condition) {
    	PageRequest pageRequest = condition.getPageRequest();
    	Map param = condition.getPageParam();
		PageResult<CoreUser> pageResult = orgDao.queryUserByCondition(pageRequest,param);
    	queryListAfter(pageResult.getList());
    	return pageResult;
    }


    /**
     * 获取机构下面的所以机构
     * @param orgId 机构id
     */
    public List<Long> getAllChildIdsByOrgId(Long orgId) {
        if (orgId == null)
            return null;

        OrgItem orgItem = platformService.buildOrg().findChild(orgId);
        if (orgItem == null) {
            return null;
        }
        List<Long> ids = orgItem.findAllChildrenId();
        if (ids == null) {
            ids = new ArrayList<>();
        }
        ids.add(orgId);

        return ids;
    }
    
    @Override
    public boolean deleteById(List<Long> ids) {
    	OrgItem root = platformService.buildOrg();
        //检查子节点
    	
        for (Long id : ids) {
        	OrgItem child = root.findChild(id);
        	if(child.getChildren().size()!=0){
        		throw new PlatformException("不能删除 "+child.getOrg().getName()+",还包含子机构");
        	}
        }
        return super.deleteById(ids);
    }
    


}
