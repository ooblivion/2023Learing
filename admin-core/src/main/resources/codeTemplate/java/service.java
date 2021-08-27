package ${package};


import ${basePackage}.dao.${entity.name}Dao;
import ${basePackage}.entity.${entity.name};
import ${basePackage}.web.query.${entity.name}Query;


import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.util.PlatformException;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;





/**
 * ${entity.displayName} Service
 */

\@Service
\@Transactional
public class ${entity.name}Service extends CoreBaseService<${entity.name}>{

    \@Autowired private ${entity.name}Dao ${entity.code}Dao;

//    public PageQuery<${entity.name}>queryByCondition(PageQuery query){
//        PageQuery ret =  ${entity.code}Dao.queryByCondition(query);
//        queryListAfter(ret.getList());
//        return ret;
//    }

    public PageResult<${entity.name}> queryByCondition(${entity.name}Query condition) {
        PageRequest pageRequest = condition.getPageRequest();
        Map params = condition.getPageParam();
        PageResult ret = ${entity.code}Dao.queryByCondition(pageRequest, params);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDel${entity.name}(List<Long> ids){
        try {
            ${entity.code}Dao.batchDel${entity.name}ByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除${entity.displayName}失败", e);
        }
    }
}