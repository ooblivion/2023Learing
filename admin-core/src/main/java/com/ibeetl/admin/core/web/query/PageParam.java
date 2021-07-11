package com.ibeetl.admin.core.web.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibeetl.admin.core.annotation.Query;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.page.DefaultPageRequest;
import org.beetl.sql.core.page.PageRequest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 子类继承此类获得翻页功能
 * @author lijiazhi
 */
public class PageParam {
    private Integer page = null;
    private Integer limit = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

	@JsonIgnore
	public PageRequest getPageRequest(){
    	if(page==null){
    		return  DefaultPageRequest.of(1L,20);
		}
		return  DefaultPageRequest.of(page,limit);
	}
    @JsonIgnore
    public Map getPageParam()  {
        Field[] fs =this.getClass().getDeclaredFields();
        Map map = new HashMap();
        for(Field f:fs){
            Query query = f.getAnnotation(Query.class);
            if(query==null){
                continue ;
            }
            if (query.fuzzy()) {
                try {
                    if ( f.getType() == String.class) {
                        f.setAccessible(true);
                        Object o = f.get(this);
                        if (o != null && !o.toString().isEmpty()) {
                            map.put(f.getName(),"%"+o.toString()+"%");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else{
            	try{
					Object o = f.get(this);
					map.put(f.getName(),o);
				}  catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
        }

        return map;
    }

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}


}
