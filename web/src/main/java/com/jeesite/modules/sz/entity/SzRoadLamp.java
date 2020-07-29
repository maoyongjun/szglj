/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 路灯信息Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_road_lamp", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="lampno", attrName="lampno", label="路灯编号"),
		@Column(name="description", attrName="description", label="路灯描述"),
		@Column(name="gis_la", attrName="gisLa", label="经度"),
		@Column(name="gis_lo", attrName="gisLo", label="纬度"),
		@Column(name="status", attrName="status", label="状态", isUpdate=false),
	}, orderBy="a.id DESC"
)
public class SzRoadLamp extends DataEntity<SzRoadLamp> {
	
	private static final long serialVersionUID = 1L;
	private String lampno;		// 路灯编号
	private String description;		// 路灯描述
	private Double gisLa;		// 经度
	private Double gisLo;		// 纬度
	
	public SzRoadLamp() {
		this(null);
	}

	public SzRoadLamp(String id){
		super(id);
	}
	
	@NotBlank(message="路灯编号不能为空")
	@Length(min=0, max=64, message="路灯编号长度不能超过 64 个字符")
	public String getLampno() {
		return lampno;
	}

	public void setLampno(String lampno) {
		this.lampno = lampno;
	}
	
	@Length(min=0, max=500, message="路灯描述长度不能超过 500 个字符")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getGisLa() {
		return gisLa;
	}

	public void setGisLa(Double gisLa) {
		this.gisLa = gisLa;
	}
	
	public Double getGisLo() {
		return gisLo;
	}

	public void setGisLo(Double gisLo) {
		this.gisLo = gisLo;
	}
	
}