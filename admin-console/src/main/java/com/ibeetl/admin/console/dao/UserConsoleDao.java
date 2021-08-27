package com.ibeetl.admin.console.dao;


import com.ibeetl.admin.core.entity.CoreUser;
import com.ibeetl.admin.core.entity.CoreUserRole;
import com.ibeetl.admin.core.util.enums.GeneralStateEnum;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Update;

import java.util.List;
import java.util.Map;

@SqlResource("console.user")
public interface UserConsoleDao extends BaseMapper<CoreUser> {

    PageResult<CoreUser> queryByCondition(PageRequest<CoreUser> query, @Root Map params);

    @Update
    void batchDelUserByIds(List<Long> ids);

    @Update
    void batchUpdateUserState(List<Long> ids, GeneralStateEnum state);

    List<CoreUserRole> queryUserRole(Long id, Long orgId, Long roleId);

}

