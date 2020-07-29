/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 供热信息Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_environmental_heating_center", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="number", attrName="number", label="编号"),
		@Column(name="village_name", attrName="villageName", label="小区名称", queryType=QueryType.LIKE),
		@Column(name="heating_area", attrName="heatingArea", label="供热平米"),
		@Column(name="inlet_temperature", attrName="inletTemperature", label="进水温度"),
		@Column(name="outlet_temperature", attrName="outletTemperature", label="出水温度"),
		@Column(name="heating_company", attrName="heatingCompany", label="供热公司"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalHeatingCenter extends DataEntity<SzEnvironmentalHeatingCenter> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 编号
	private String villageName;		// 小区名称
	private Double heatingArea;		// 供热平米
	private Double inletTemperature;		// 进水温度
	private Double outletTemperature;		// 出水温度
	private String heatingCompany;		// 供热公司
	
	public SzEnvironmentalHeatingCenter() {
		this(null);
	}

	public SzEnvironmentalHeatingCenter(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="编号长度不能超过 64 个字符")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Length(min=0, max=300, message="小区名称长度不能超过 300 个字符")
	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
	public Double getHeatingArea() {
		return heatingArea;
	}

	public void setHeatingArea(Double heatingArea) {
		this.heatingArea = heatingArea;
	}
	
	public Double getInletTemperature() {
		return inletTemperature;
	}

	public void setInletTemperature(Double inletTemperature) {
		this.inletTemperature = inletTemperature;
	}
	
	public Double getOutletTemperature() {
		return outletTemperature;
	}

	public void setOutletTemperature(Double outletTemperature) {
		this.outletTemperature = outletTemperature;
	}
	
	@Length(min=0, max=300, message="供热公司长度不能超过 300 个字符")
	public String getHeatingCompany() {
		return heatingCompany;
	}

	public void setHeatingCompany(String heatingCompany) {
		this.heatingCompany = heatingCompany;
	}
	
}