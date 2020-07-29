/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * api访问记录Entity
 * @author myj
 * @version 2020-05-29
 */
@Table(name="api_log", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="api_code", attrName="apiCode", label="编号"),
		@Column(name="api_name", attrName="apiName", label="名称", queryType=QueryType.LIKE),
		@Column(name="response_code", attrName="responseCode", label="状态码"),
		@Column(name="in_date", attrName="inDate", label="开始时间"),
		@Column(name="out_date", attrName="outDate", label="结束时间"),
		@Column(name="take_time", attrName="takeTime", label="访问毫秒"),
		@Column(name="is_data_pull_status", attrName="isDataPullStatus", label="调用方式"),
		@Column(name="datatype", attrName="datatype", label="数据格式"),
		@Column(name="request_data", attrName="requestData", label="请求数据", isQuery=false),
		@Column(name="response_data", attrName="responseData", label="返回数据", isQuery=false),
	}, orderBy="a.id DESC"
)
public class ApiLog extends DataEntity<ApiLog> {
	
	private static final long serialVersionUID = 1L;
	private String apiCode;		// 编号
	private String apiName;		// 名称
	private Long responseCode;		// 状态码
	private Date inDate;		// 开始时间
	private Date outDate;		// 结束时间
	private Long takeTime;		// 访问毫秒
	private Long isDataPullStatus;		// 调用方式
	private String datatype;		// 数据格式
	private String requestData;		// 请求数据
	private String responseData;		// 返回数据
	
	public ApiLog() {
		this(null);
	}

	public ApiLog(String id){
		super(id);
	}
	
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
	
	public Long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Long responseCode) {
		this.responseCode = responseCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	
	public Long getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Long takeTime) {
		this.takeTime = takeTime;
	}
	
	@NotNull(message="调用方式不能为空")
	public Long getIsDataPullStatus() {
		return isDataPullStatus;
	}

	public void setIsDataPullStatus(Long isDataPullStatus) {
		this.isDataPullStatus = isDataPullStatus;
	}
	
	@NotBlank(message="数据格式不能为空")
	@Length(min=0, max=50, message="数据格式长度不能超过 50 个字符")
	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	
	@Length(min=0, max=8000, message="请求数据长度不能超过 8000 个字符")
	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	
	@Length(min=0, max=8000, message="返回数据长度不能超过 8000 个字符")
	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
}