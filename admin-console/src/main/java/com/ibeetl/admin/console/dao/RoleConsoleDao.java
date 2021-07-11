package com.ibeetl.admin.console.dao;

import java.util.List;
import java.util.Map;


import com.ibeetl.admin.console.web.query.RoleUserQuery;
import com.ibeetl.admin.core.entity.CoreRole;
import com.ibeetl.admin.core.entity.CoreUser;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;

@SqlResource("console.role")
public interface RoleConsoleDao extends BaseMapper<CoreRole> {

    /**
     * 根据条件分页查询
     * @param query 查询条件
     */
    PageResult<CoreRole> queryByCondition(PageRequest query, Map params);

    /**
     * 批量删除角色
     * @param ids 角色id
     */
    void batchDelByIds(List<Long> ids);
    
    void batchDeleteRoleFunction(List<Long> ids);
    void batchDeleteRoleMenu(List<Long> ids);
    void batchDeleteUserRole(List<Long> ids);


	PageResult<CoreUser> queryUser(PageRequest query, @Root Map params);
    


   
}
