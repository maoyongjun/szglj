/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 每日厨余垃圾与资源垃圾处置数据Entity
 * @author myj
 * @version 2020-07-28
 */
@Table(name="sz_environmental_xzzxupload", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="wjqy_id", attrName="wjqyId", label="ID"),
		@Column(name="orgid", attrName="orgid", label="机关单位ID"),
		@Column(name="report_time", attrName="reportTime", label="时间"),
		@Column(name="trash_yblj", attrName="trashYblj", label="一般垃圾上报总重"),
		@Column(name="trash_cylj", attrName="trashCylj", label="餐厨厨余垃圾上报总重"),
		@Column(name="trash_wclj", attrName="trashWclj", label="尾菜垃圾上报总重"),
		@Column(name="trash_zylj", attrName="trashZylj", label="资源垃圾上报总重"),
		@Column(name="trash_dhlj", attrName="trashDhlj", label="有毒有害垃圾上报总重"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalXzzxupload extends DataEntity<SzEnvironmentalXzzxupload> {
	
	private static final long serialVersionUID = 1L;
	private Integer wjqyId;		// ID
	private Integer orgid;		// 机关单位ID
	private Date reportTime;		// 时间
	private Double trashYblj;		// 一般垃圾上报总重
	private Double trashCylj;		// 餐厨厨余垃圾上报总重
	private Double trashWclj;		// 尾菜垃圾上报总重
	private Double trashZylj;		// 资源垃圾上报总重
	private Double trashDhlj;		// 有毒有害垃圾上报总重
	
	public SzEnvironmentalXzzxupload() {
		this(null);
	}

	public SzEnvironmentalXzzxupload(String id){
		super(id);
	}
	
	public Integer getWjqyId() {
		return wjqyId;
	}

	public void setWjqyId(Integer wjqyId) {
		this.wjqyId = wjqyId;
	}
	
	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	
	public Double getTrashYblj() {
		return trashYblj;
	}

	public void setTrashYblj(Double trashYblj) {
		this.trashYblj = trashYblj;
	}
	
	public Double getTrashCylj() {
		return trashCylj;
	}

	public void setTrashCylj(Double trashCylj) {
		this.trashCylj = trashCylj;
	}
	
	public Double getTrashWclj() {
		return trashWclj;
	}

	public void setTrashWclj(Double trashWclj) {
		this.trashWclj = trashWclj;
	}
	
	public Double getTrashZylj() {
		return trashZylj;
	}

	public void setTrashZylj(Double trashZylj) {
		this.trashZylj = trashZylj;
	}
	
	public Double getTrashDhlj() {
		return trashDhlj;
	}

	public void setTrashDhlj(Double trashDhlj) {
		this.trashDhlj = trashDhlj;
	}
	
}