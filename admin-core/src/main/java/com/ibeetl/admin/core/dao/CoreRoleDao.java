package com.ibeetl.admin.core.dao;

import com.ibeetl.admin.core.entity.CoreRole;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;


@SqlResource("core.coreRole")
public interface CoreRoleDao extends BaseMapper<CoreRole> {

}
