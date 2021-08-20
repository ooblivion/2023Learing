package com.ibeetl.admin.console.dao;


import com.ibeetl.admin.core.entity.CoreMenu;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.Map;

@SqlResource("console.menu")
public interface MenuConsoleDao extends BaseMapper<CoreMenu> {

    /**
     * 根据条件分页查询
     *
     * @param query 查询条件
     */
    PageResult<CoreMenu> queryByCondition(PageRequest query, @Root Map params);


}
