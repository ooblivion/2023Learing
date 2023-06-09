package ${package};

import java.util.List;
import java.util.Map;

import com.ibeetl.admin.core.entity.CoreUser;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Root;
import org.springframework.stereotype.Component;

import  ${basePackage}.entity.*;

/**
 * ${entity.displayName} Dao
 */
\@SqlResource("${entity.system}.${entity.code}")
\@Component
public interface ${entity.name}Dao extends BaseMapper<${entity.name}>{
    public PageResult<${entity.name}> queryByCondition(PageRequest request,\@Root Map params);
    public void batchDel${entity.name}ByIds( List<Long> ids);
}