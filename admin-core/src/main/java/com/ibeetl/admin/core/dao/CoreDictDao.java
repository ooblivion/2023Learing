package com.ibeetl.admin.core.dao;

import com.ibeetl.admin.core.entity.CoreDict;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.List;
import java.util.Map;

/**
 * 字典DAO接口
 */
@SqlResource("core.coreDict")
public interface CoreDictDao extends BaseMapper<CoreDict> {

    /**
     * 查询某个类型下的字典集合
     *
     * @param type 字典类型
     * @return
     */
    List<CoreDict> findAllList(String type);

    /**
     * 查询字段类型列表
     *
     * @param delFlag 删除标记
     * @return
     */
    List<Map<String, String>> findTypeList(int delFlag);


    /**
     * 根据父节点Id查询子节点数据
     *
     * @param id 父节点id
     * @return
     */
    List<CoreDict> findChildByParent(Long id);

}
