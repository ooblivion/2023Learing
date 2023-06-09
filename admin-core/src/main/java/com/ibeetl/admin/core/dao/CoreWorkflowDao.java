package com.ibeetl.admin.core.dao;


import com.ibeetl.admin.core.entity.CoreUser;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.List;

/**
 * 业务侧工作流的基本功能，工作流的一些功能将在业务侧完成，比如选人操作
 *
 * @author lijiazhi
 */
@SqlResource("core.workflow")
public interface CoreWorkflowDao extends BaseMapper {

    /**
     * 根据角色id，机构id查询用户集合
     *
     * @param roleId 角色id
     * @param orgs   机构id
     * @return
     */
    List<CoreUser> queryUsersByRole(Long roleId, List<Long> orgs);
}
