/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 逐年征收情况Entity
 * @author myj
 * @version 2020-07-11
 */
@Table(name="sz_annual_collection", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="date", attrName="date", label="时间"),
		@Column(name="team", attrName="team", label="队伍"),
		@Column(name="cost", attrName="cost", label="费用"),
	}, orderBy="a.id DESC"
)
public class SzAnnualCollection extends DataEntity<SzAnnualCollection> {
	
	private static final long serialVersionUID = 1L;
	private Date date;		// 时间
	private String team;		// 队伍
	private Integer cost;		// 费用
	
	public SzAnnualCollection() {
		this(null);
	}

	public SzAnnualCollection(String id){
		super(id);
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Length(min=0, max=300, message="队伍长度不能超过 300 个字符")
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}