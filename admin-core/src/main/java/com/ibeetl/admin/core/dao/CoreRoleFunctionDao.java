package com.ibeetl.admin.core.dao;


import com.ibeetl.admin.core.entity.CoreRoleFunction;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.List;

@SqlResource("core.coreRoleFunction")
public interface CoreRoleFunctionDao extends BaseMapper<CoreRoleFunction> {


    List<CoreRoleFunction> getRoleFunction( Long userId, Long orgId,
                                         String code);

    List<String> getRoleChildrenFunction(Long userId,  Long orgId,
                                          Long parentId);


}
