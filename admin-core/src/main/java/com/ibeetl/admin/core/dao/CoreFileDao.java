package com.ibeetl.admin.core.dao;

import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Sql;

import com.ibeetl.admin.core.entity.CoreFile;
import org.beetl.sql.mapper.annotation.Update;

public interface  CoreFileDao extends BaseMapper<CoreFile> {
    @Sql("update core_file set biz_type=?,biz_id=? where file_batch_id=?")
	@Update
	void updateBatchIdInfo( String bizType, String bizId,String fileBatchId);
}
