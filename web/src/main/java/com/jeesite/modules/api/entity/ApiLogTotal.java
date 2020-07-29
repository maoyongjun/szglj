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

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * api访问次数统计表Entity
 * @author myj
 * @version 2020-05-29
 */
@Table(name="api_log_total", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="api_code", attrName="apiCode", label="编号"),
		@Column(name="api_name", attrName="apiName", label="名称", queryType=QueryType.LIKE),
		@Column(name="success_count", attrName="successCount", label="访问成功次数", isQuery=false),
		@Column(name="fail_count", attrName="failCount", label="访问失败次数", isQuery=false),
		@Column(name="in_date", attrName="inDate", label="访问时间"),
		@Column(name="take_avg_time", attrName="takeAvgTime", label="平均毫秒", isQuery=false),
	}, orderBy="a.id DESC"
)
public class ApiLogTotal extends DataEntity<ApiLogTotal> {
	
	private static final long serialVersionUID = 1L;
	private String apiCode;		// 编号
	private String apiName;		// 名称
	private Long successCount;		// 访问成功次数
	private Long failCount;		// 访问失败次数
	private Date inDate;		// 访问时间
	private Long takeAvgTime;		// 平均毫秒
	
	public ApiLogTotal() {
		this(null);
	}

	public ApiLogTotal(String id){
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
	
	public Long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Long successCount) {
		this.successCount = successCount;
	}
	
	public Long getFailCount() {
		return failCount;
	}

	public void setFailCount(Long failCount) {
		this.failCount = failCount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="访问时间不能为空")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	@NotNull(message="平均毫秒不能为空")
	public Long getTakeAvgTime() {
		return takeAvgTime;
	}

	public void setTakeAvgTime(Long takeAvgTime) {
		this.takeAvgTime = takeAvgTime;
	}
	
	public Date getInDate_gte() {
		return sqlMap.getWhere().getValue("in_date", QueryType.GTE);
	}

	public void setInDate_gte(Date inDate) {
		sqlMap.getWhere().and("in_date", QueryType.GTE, inDate);
	}
	
	public Date getInDate_lte() {
		return sqlMap.getWhere().getValue("in_date", QueryType.LTE);
	}

	public void setInDate_lte(Date inDate) {
		sqlMap.getWhere().and("in_date", QueryType.LTE, inDate);
	}
	
}