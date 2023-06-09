package com.ibeetl.admin.core.entity;

import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.SeqID;

import java.util.Date;

import javax.validation.constraints.NotNull;



/*
*  用户角色关系
* gen by beetlsql 2016-11-22
*/
public class CoreUserRole extends BaseEntity {


	//@SeqID(name = "ORACLE_CORE_SEQ_NAME")
	@AutoID
    private Long id;
    // 授权机构id
    @NotNull(message = "授权机构不能为空")
    private Long orgId;
    // 授权角色id
    @NotNull(message = "授权角色不能为空")
    private Long roleId;
    // 用户id
    @NotNull(message = "授权用户不能为空")
    private Long userId;

    protected Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
