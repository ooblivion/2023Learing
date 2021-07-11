package com.ibeetl.admin.console.dao;


import com.ibeetl.admin.core.entity.CoreAudit;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.Map;

@SqlResource("console.audit")
public interface AuditConsoleDao extends BaseMapper<CoreAudit> {

    PageResult<CoreAudit> queryByCondtion(PageRequest<CoreAudit> query, @Root Map paras);

}

