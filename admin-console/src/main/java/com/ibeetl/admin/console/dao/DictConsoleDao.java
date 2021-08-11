package com.ibeetl.admin.console.dao;

import java.util.List;
import java.util.Map;


import com.ibeetl.admin.core.entity.CoreDict;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Update;

/**
 * CoreDict Dao
 */
@SqlResource("console.dict")
public interface DictConsoleDao extends BaseMapper<CoreDict> {
     PageResult<CoreDict> queryByCondition(PageRequest query, @Root Map params);
	 @Update
     void batchDelCoreDictByIds( List<Long> ids);
}