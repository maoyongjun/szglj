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
 * 污水厂信息Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_environmental_sewage_disposal", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="number", attrName="number", label="编号"),
		@Column(name="water_input", attrName="waterInput", label="进水量"),
		@Column(name="water_output", attrName="waterOutput", label="出水量"),
		@Column(name="water_plant_name", attrName="waterPlantName", label="污水厂名称", queryType=QueryType.LIKE),
		@Column(name="date", attrName="date", label="日期"),
		@Column(name="result", attrName="result", label="监测结果"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalSewageDisposal extends DataEntity<SzEnvironmentalSewageDisposal> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 编号
	private Double waterInput;		// 进水量
	private Double waterOutput;		// 出水量
	private String waterPlantName;		// 污水厂名称
	private Date date;		// 日期
	private String result;		// 监测结果
	
	public SzEnvironmentalSewageDisposal() {
		this(null);
	}

	public SzEnvironmentalSewageDisposal(String id){
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
	
	@Length(min=0, max=255, message="污水厂名称长度不能超过 255 个字符")
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
	
	@Length(min=0, max=1, message="监测结果长度不能超过 1 个字符")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}