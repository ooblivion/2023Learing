package com.ibeetl.admin.console.service;

import com.ibeetl.admin.console.web.query.AuditQuery;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.console.dao.AuditConsoleDao;
import com.ibeetl.admin.core.entity.CoreAudit;
import com.ibeetl.admin.core.service.CoreBaseService;

import java.util.Map;

@Service
@Transactional
public class AuditConsoleService extends CoreBaseService<CoreAudit> {

	@Autowired
	AuditConsoleDao auditConsoleDao;

	/**
	 * 根据条件查询
	 *
	 * @param condition
	 */
	public PageResult<CoreAudit> queryByCondtion(AuditQuery condition) {
		PageRequest pageRequest = condition.getPageRequest();
		Map params = condition.getPageParam();
		PageResult<CoreAudit> ret = auditConsoleDao.queryByCondtion(pageRequest,params);
		queryListAfter(ret.getList());
		return ret;
	}

	

}
