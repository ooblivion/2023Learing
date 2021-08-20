package com.ibeetl.admin.core.dao;


import com.ibeetl.admin.core.entity.CoreMenu;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Update;

import java.util.List;

@SqlResource("core.coreMenu")
public interface CoreMenuDao extends BaseMapper<CoreMenu> {

    void queryByCondtion(PageRequest query);

    @Update
    void clearMenuFunction(List<Long> functionIds);

    List<CoreMenu> allMenuWithURL();

}
