/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.entity;

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
 * 餐厨垃圾处理情况Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_environmental_kitchen_waste", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="number", attrName="number", label="编号"),
		@Column(name="charge_in", attrName="chargeIn", label="进料量"),
		@Column(name="charge_out", attrName="chargeOut", label="出料量"),
		@Column(name="processing_capacity", attrName="processingCapacity", label="处理量"),
		@Column(name="company_name", attrName="companyName", label="企业名称", queryType=QueryType.LIKE),
		@Column(name="company_number", attrName="companyNumber", label="企业编号"),
		@Column(name="date", attrName="date", label="日期"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalKitchenWaste extends DataEntity<SzEnvironmentalKitchenWaste> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 编号
	private Double chargeIn;		// 进料量
	private Double chargeOut;		// 出料量
	private Double processingCapacity;		// 处理量
	private String companyName;		// 企业名称
	private String companyNumber;		// 企业编号
	private Date date;		// 日期
	
	public SzEnvironmentalKitchenWaste() {
		this(null);
	}

	public SzEnvironmentalKitchenWaste(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="编号长度不能超过 64 个字符")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Double getChargeIn() {
		return chargeIn;
	}

	public void setChargeIn(Double chargeIn) {
		this.chargeIn = chargeIn;
	}
	
	public Double getChargeOut() {
		return chargeOut;
	}

	public void setChargeOut(Double chargeOut) {
		this.chargeOut = chargeOut;
	}
	
	public Double getProcessingCapacity() {
		return processingCapacity;
	}

	public void setProcessingCapacity(Double processingCapacity) {
		this.processingCapacity = processingCapacity;
	}
	
	@Length(min=0, max=300, message="企业名称长度不能超过 300 个字符")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Length(min=0, max=64, message="企业编号长度不能超过 64 个字符")
	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}