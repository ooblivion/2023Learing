package com.ibeetl.admin.core.dao;

import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Sql;
import org.beetl.sql.mapper.annotation.SqlResource;

import com.ibeetl.admin.core.entity.CoreRole;


@SqlResource("core.coreRole")
public interface CoreRoleDao extends BaseMapper<CoreRole> {

}
