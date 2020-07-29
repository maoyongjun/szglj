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
 * 试点社区信息Entity
 * @author myj
 * @version 2020-07-28
 */
@Table(name="sz_environmental_communitymember", alias="a", columns={
		@Column(name="id", attrName="id", label="ID", isPK=true),
		@Column(name="wjqy_id", attrName="wjqyId", label="id"),
		@Column(name="villagename", attrName="villagename", label="小区名称"),
		@Column(name="province", attrName="province", label="所属省"),
		@Column(name="city", attrName="city", label="所属市"),
		@Column(name="county", attrName="county", label="所属县/区"),
		@Column(name="street", attrName="street", label="所属街道"),
		@Column(name="longitude", attrName="longitude", label="经度"),
		@Column(name="latitudes", attrName="latitudes", label="纬度"),
		@Column(name="creatdate", attrName="creatdate", label="建成时间格式", comment="建成时间格式: yyyy-MM-dd"),
		@Column(name="build_num", attrName="buildNum", label="总栋数"),
		@Column(name="rge_num", attrName="rgeNum", label="总户数"),
		@Column(name="person_num", attrName="personNum", label="总人数"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalCommunitymember extends DataEntity<SzEnvironmentalCommunitymember> {
	
	private static final long serialVersionUID = 1L;
	private Integer wjqyId;		// id
	private String villagename;		// 小区名称
	private String province;		// 所属省
	private String city;		// 所属市
	private String county;		// 所属县/区
	private String street;		// 所属街道
	private String longitude;		// 经度
	private String latitudes;		// 纬度
	private Date creatdate;		// 建成时间格式: yyyy-MM-dd
	private Long buildNum;		// 总栋数
	private Long rgeNum;		// 总户数
	private Long personNum;		// 总人数
	
	public SzEnvironmentalCommunitymember() {
		this(null);
	}

	public SzEnvironmentalCommunitymember(String id){
		super(id);
	}
	
	public Integer getWjqyId() {
		return wjqyId;
	}

	public void setWjqyId(Integer wjqyId) {
		this.wjqyId = wjqyId;
	}
	
	@Length(min=0, max=255, message="小区名称长度不能超过 255 个字符")
	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}
	
	@Length(min=0, max=255, message="所属省长度不能超过 255 个字符")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=255, message="所属市长度不能超过 255 个字符")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=255, message="所属县/区长度不能超过 255 个字符")
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
	@Length(min=0, max=255, message="所属街道长度不能超过 255 个字符")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Length(min=0, max=255, message="经度长度不能超过 255 个字符")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Length(min=0, max=255, message="纬度长度不能超过 255 个字符")
	public String getLatitudes() {
		return latitudes;
	}

	public void setLatitudes(String latitudes) {
		this.latitudes = latitudes;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}
	
	public Long getBuildNum() {
		return buildNum;
	}

	public void setBuildNum(Long buildNum) {
		this.buildNum = buildNum;
	}
	
	public Long getRgeNum() {
		return rgeNum;
	}

	public void setRgeNum(Long rgeNum) {
		this.rgeNum = rgeNum;
	}
	
	public Long getPersonNum() {
		return personNum;
	}

	public void setPersonNum(Long personNum) {
		this.personNum = personNum;
	}
	
}