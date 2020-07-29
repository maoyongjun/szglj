/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.entity;

import javax.validation.constraints.NotBlank;

import com.jeesite.modules.bpm.entity.BpmEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * api注册记录Entity
 * @author myj
 * @version 2020-05-29
 */
@Table(name="api_register", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="api_code", attrName="apiCode", label="编号"),
		@Column(name="api_name", attrName="apiName", label="名称", queryType=QueryType.LIKE),
		@Column(name="api_url", attrName="apiUrl", label="地址"),
		@Column(name="api_desc", attrName="apiDesc", label="描述"),
		@Column(name="create_by", attrName="createBy", label="创建人", isUpdate=false, isQuery=false),
		@Column(name="register_time", attrName="registerTime", label="注册时间", isQuery=false),
		@Column(name="update_time", attrName="updateTime", label="修改时间", isQuery=false),
		@Column(name="api_type", attrName="apiType", label="调用方式"),
	}, orderBy="a.id DESC"
)
public class ApiRegister extends BpmEntity<ApiRegister> {
	
	private static final long serialVersionUID = 1L;
	private String apiCode;		// 编号
	private String apiName;		// 名称
	private String apiUrl;		// 地址
	private String apiDesc;		// 描述
	private Date registerTime;		// 注册时间
	private Date updateTime;		// 修改时间
	private Long apiType;		// 调用方式
	
	public ApiRegister() {
		this(null);
	}

	public ApiRegister(String id){
		super(id);
	}
	
	@NotBlank(message="编号不能为空")
	@Length(min=0, max=100, message="编号长度不能超过 100 个字符")
	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}
	
	@Length(min=0, max=200, message="名称长度不能超过 200 个字符")
	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	
	@Length(min=0, max=500, message="地址长度不能超过 500 个字符")
	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	@Length(min=0, max=500, message="描述长度不能超过 500 个字符")
	public String getApiDesc() {
		return apiDesc;
	}

	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Long getApiType() {
		return apiType;
	}

	public void setApiType(Long apiType) {
		this.apiType = apiType;
	}
	
}