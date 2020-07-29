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
 * 自来水厂信息Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_environmental_water_management", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="number", attrName="number", label="编号"),
		@Column(name="water_input", attrName="waterInput", label="进水量"),
		@Column(name="water_output", attrName="waterOutput", label="出水量"),
		@Column(name="water_plant_name", attrName="waterPlantName", label="水厂名称", queryType=QueryType.LIKE),
		@Column(name="date", attrName="date", label="日期"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalWaterManagement extends DataEntity<SzEnvironmentalWaterManagement> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 编号
	private Double waterInput;		// 进水量
	private Double waterOutput;		// 出水量
	private String waterPlantName;		// 水厂名称
	private Date date;		// 日期
	
	public SzEnvironmentalWaterManagement() {
		this(null);
	}

	public SzEnvironmentalWaterManagement(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="编号长度不能超过 64 个字符")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Double getWaterInput() {
		return waterInput;
	}

	public void setWaterInput(Double waterInput) {
		this.waterInput = waterInput;
	}
	
	public Double getWaterOutput() {
		return waterOutput;
	}

	public void setWaterOutput(Double waterOutput) {
		this.waterOutput = waterOutput;
	}
	
	@Length(min=0, max=300, message="水厂名称长度不能超过 300 个字符")
	public String getWaterPlantName() {
		return waterPlantName;
	}

	public void setWaterPlantName(String waterPlantName) {
		this.waterPlantName = waterPlantName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}