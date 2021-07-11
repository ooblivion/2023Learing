package com.ibeetl.admin.console.dao;


import com.ibeetl.admin.core.entity.CoreFunction;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.Map;

@SqlResource("console.function")
public interface FunctionConsoleDao extends BaseMapper<CoreFunction> {

    /**
     * 根据条件查询
     *
     * @param query
     */
    PageResult<CoreFunction> queryByCondition(PageRequest query, @Root Map params);
}
