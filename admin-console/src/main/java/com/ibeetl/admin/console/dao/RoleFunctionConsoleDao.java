package com.ibeetl.admin.console.dao;

import java.util.List;

import com.ibeetl.admin.console.web.dto.RoleDataAccessFunction;
import com.ibeetl.admin.core.entity.CoreRoleFunction;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Update;

@SqlResource("console.roleFunction")
public interface RoleFunctionConsoleDao extends BaseMapper<CoreRoleFunction> {

	@Update
    void deleteRoleFunction(List<Long> ids);

    List<Long> getFunctionIdByRole(Long roleId);

    List<RoleDataAccessFunction> getQueryFunctionAndRoleData(Long roleId);


}
