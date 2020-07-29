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
 * 路灯统计Entity
 * @author myj
 * @version 2020-07-03
 */
@Table(name="sz_road_lamp_total", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="key", attrName="key", label="名称"),
		@Column(name="value", attrName="value", label="数值"),
	}, orderBy="a.id DESC"
)
public class SzRoadLampTotal extends DataEntity<SzRoadLampTotal> {
	
	private static final long serialVersionUID = 1L;
	private String key;		// 名称
	private Double value;		// 数值
	
	public SzRoadLampTotal() {
		this(null);
	}

	public SzRoadLampTotal(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="名称长度不能超过 255 个字符")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}