package com.ibeetl.admin.console.dao;

import java.util.List;
import java.util.Map;


import org.beetl.sql.core.engine.PageQuery;

import com.ibeetl.admin.core.entity.CoreOrg;
import com.ibeetl.admin.core.entity.CoreUser;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;

@SqlResource("console.org")
public interface OrgConsoleDao extends BaseMapper<CoreOrg> {

    PageResult<CoreOrg> queryByCondition(PageRequest query, @Root Map params);
	PageResult<CoreUser> queryUserByCondition(PageRequest<CoreUser> query,@Root Map params);

}
