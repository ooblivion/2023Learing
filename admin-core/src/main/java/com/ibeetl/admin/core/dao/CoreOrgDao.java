package com.ibeetl.admin.core.dao;

import com.ibeetl.admin.core.entity.CoreOrg;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Sql;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.List;

@SqlResource("core.coreOrg")
public interface CoreOrgDao extends BaseMapper<CoreOrg> {

    List<CoreOrg> queryOrgByUser(Long userId);


    List<String> queryAllOrgCode(List<Long> orgIds);

    @Sql("select * from core_org where parent_org_id is null")
    CoreOrg getRoot();


}
