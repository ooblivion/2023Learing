package ${package};

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


import com.ibeetl.admin.core.entity.BaseEntity;
import com.ibeetl.admin.core.util.ValidateConfig;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.SeqID;
import org.beetl.sql.annotation.entity.InsertIgnore;
import org.beetl.sql.annotation.entity.UpdateIgnore;

import com.ibeetl.admin.core.util.ValidateConfig;

import org.beetl.sql.core.TailBean;
import java.math.*;

import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.entity.BaseEntity;




/* 
* ${comment}
* gen by Spring Boot2 Admin ${date(),"yyyy-MM-dd"}
*/
public class ${className} extends BaseEntity{

    @for(attr in attrs){
		@if(!isEmpty(attr.comment)){
    //${attr.comment}
		@}
		@if(attr.isId) {
    \@NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
//\@SeqID(name = ORACLE_CORE_SEQ_NAME)
    \@AutoID	
		@}
		@if(isNotEmpty(attr.dictType)) {
    \@Dict(type="${attr.dictType}")
		@}
		@if(attr.name == "delFlag") {
	/*逻辑删除标志*/
	\@InsertIgnore
	\@LogicDelete(value = 1)
		@}
		@if(attr.name == "version") {
	/*乐观锁版本标志*/
	\@InsertIgnore
	\@Version
		@}

    private ${attr.type} ${attr.name} ;
	
	@}
    public ${className}(){
    }

    @for(attr in attrs){
		@if(!isEmpty(attr.comment)){
    /**${attr.comment}
    *\@return 
    */
		@}
    public ${attr.type} get${attr.methodName}(){
        return  ${attr.name};
    }
		@if(!isEmpty(attr.comment)){
    /**${attr.comment}
    *\@param  ${attr.name}
    */
		@}
    public void set${attr.methodName}(${attr.type} ${attr.name}){
        this.${attr.name} = ${attr.name};
    }

    @}

}
