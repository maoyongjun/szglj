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
 * 公厕信息Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_environmental_public_toilet", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="number", attrName="number", label="编号"),
		@Column(name="description", attrName="description", label="名称"),
		@Column(name="squatting_position_count", attrName="squattingPositionCount", label="蹲位数量"),
		@Column(name="is_clean", attrName="isClean", label="是否打扫"),
		@Column(name="charge", attrName="charge", label="负责人"),
		@Column(name="phone", attrName="phone", label="联系方式"),
		@Column(name="location", attrName="location", label="详细地址"),
		@Column(name="gis_la", attrName="gisLa", label="经度"),
		@Column(name="gis_lo", attrName="gisLo", label="纬度"),
		@Column(name="photo_url", attrName="photoUrl", label="图片", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="date", attrName="date", label="时间"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalPublicToilet extends DataEntity<SzEnvironmentalPublicToilet> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 编号
	private String description;		// 名称
	private Integer squattingPositionCount;		// 蹲位数量
	private String isClean;		// 是否打扫
	private String charge;		// 负责人
	private String phone;		// 联系方式
	private String location;		// 详细地址
	private Double gisLa;		// 经度
	private Double gisLo;		// 纬度
	private String photoUrl;		// 图片
	private Date date;		// 时间
	
	public SzEnvironmentalPublicToilet() {
		this(null);
	}

	public SzEnvironmentalPublicToilet(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="编号长度不能超过 64 个字符")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Length(min=0, max=300, message="名称长度不能超过 300 个字符")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getSquattingPositionCount() {
		return squattingPositionCount;
	}

	public void setSquattingPositionCount(Integer squattingPositionCount) {
		this.squattingPositionCount = squattingPositionCount;
	}
	
	@Length(min=0, max=1, message="是否打扫长度不能超过 1 个字符")
	public String getIsClean() {
		return isClean;
	}

	public void setIsClean(String isClean) {
		this.isClean = isClean;
	}
	
	@Length(min=0, max=200, message="负责人长度不能超过 200 个字符")
	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	@Length(min=0, max=20, message="联系方式长度不能超过 20 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=300, message="详细地址长度不能超过 300 个字符")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
	
	@Length(min=0, max=300, message="图片长度不能超过 300 个字符")
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}