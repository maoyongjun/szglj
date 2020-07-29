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
 * 银川市机关单位信息Entity
 * @author myj
 * @version 2020-07-28
 */
@Table(name="sz_environmental_xzzxmember", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="wjqy_id", attrName="wjqyId", label="id"),
		@Column(name="orgname", attrName="orgname", label="单位名称"),
		@Column(name="area", attrName="area", label="所属区域"),
		@Column(name="parentid", attrName="parentid", label="上级单位"),
		@Column(name="contact", attrName="contact", label="联系人"),
		@Column(name="phone", attrName="phone", label="联系电话"),
		@Column(name="company1", attrName="company1", label="一般垃圾回收公司名称"),
		@Column(name="company2", attrName="company2", label="餐厨厨余回收公司名称"),
		@Column(name="company3", attrName="company3", label="尾菜垃圾回收公司名称"),
		@Column(name="company4", attrName="company4", label="资源垃圾回收公司名称"),
		@Column(name="company5", attrName="company5", label="有毒有害回收公司名称"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalXzzxmember extends DataEntity<SzEnvironmentalXzzxmember> {
	
	private static final long serialVersionUID = 1L;
	private Integer wjqyId;		// id
	private String orgname;		// 单位名称
	private String area;		// 所属区域
	private String parentid;		// 上级单位
	private String contact;		// 联系人
	private String phone;		// 联系电话
	private String company1;		// 一般垃圾回收公司名称
	private String company2;		// 餐厨厨余回收公司名称
	private String company3;		// 尾菜垃圾回收公司名称
	private String company4;		// 资源垃圾回收公司名称
	private String company5;		// 有毒有害回收公司名称
	
	public SzEnvironmentalXzzxmember() {
		this(null);
	}

	public SzEnvironmentalXzzxmember(String id){
		super(id);
	}
	
	public Integer getWjqyId() {
		return wjqyId;
	}

	public void setWjqyId(Integer wjqyId) {
		this.wjqyId = wjqyId;
	}
	
	@Length(min=0, max=200, message="单位名称长度不能超过 200 个字符")
	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	@Length(min=0, max=300, message="所属区域长度不能超过 300 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=200, message="上级单位长度不能超过 200 个字符")
	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	
	@Length(min=0, max=500, message="联系人长度不能超过 500 个字符")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Length(min=0, max=500, message="联系电话长度不能超过 500 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=500, message="一般垃圾回收公司名称长度不能超过 500 个字符")
	public String getCompany1() {
		return company1;
	}

	public void setCompany1(String company1) {
		this.company1 = company1;
	}
	
	@Length(min=0, max=500, message="餐厨厨余回收公司名称长度不能超过 500 个字符")
	public String getCompany2() {
		return company2;
	}

	public void setCompany2(String company2) {
		this.company2 = company2;
	}
	
	@Length(min=0, max=500, message="尾菜垃圾回收公司名称长度不能超过 500 个字符")
	public String getCompany3() {
		return company3;
	}

	public void setCompany3(String company3) {
		this.company3 = company3;
	}
	
	@Length(min=0, max=500, message="资源垃圾回收公司名称长度不能超过 500 个字符")
	public String getCompany4() {
		return company4;
	}

	public void setCompany4(String company4) {
		this.company4 = company4;
	}
	
	@Length(min=0, max=500, message="有毒有害回收公司名称长度不能超过 500 个字符")
	public String getCompany5() {
		return company5;
	}

	public void setCompany5(String company5) {
		this.company5 = company5;
	}
	
}