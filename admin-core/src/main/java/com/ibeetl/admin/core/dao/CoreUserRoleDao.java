package com.ibeetl.admin.core.dao;



import com.ibeetl.admin.core.entity.CoreUserRole;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

@SqlResource("core.coresUserRole")
public interface CoreUserRoleDao extends BaseMapper<CoreUserRole> {


}
