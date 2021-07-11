package com.ibeetl.admin.core.dao;

import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Sql;

import com.ibeetl.admin.core.entity.CoreFunction;
import org.beetl.sql.mapper.annotation.SqlResource;

@SqlResource("core.coreFunction")
public interface CoreFunctionDao extends BaseMapper<CoreFunction> {
    @Sql("select * from core_function where code = ?")
    CoreFunction getFunctionByCode(String code);
}
