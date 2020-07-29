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
 * 试点社区每日厨余垃圾与资源垃圾处置Entity
 * @author myj
 * @version 2020-07-28
 */
@Table(name="sz_environmental_communityupload", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="wjqy_id", attrName="wjqyId", label="id"),
		@Column(name="villageid", attrName="villageid", label="小区ID"),
		@Column(name="trash_dfjz", attrName="trashDfjz", label="低附加值垃圾回收总重"),
		@Column(name="trash_zylj", attrName="trashZylj", label="资源垃圾回收总重"),
		@Column(name="trash_dhlj", attrName="trashDhlj", label="有毒有害垃圾回收总重"),
		@Column(name="creatdate", attrName="creatdate", label="建成时间格式", comment="建成时间格式: yyyy-MM-dd"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalCommunityupload extends DataEntity<SzEnvironmentalCommunityupload> {
	
	private static final long serialVersionUID = 1L;
	private Integer wjqyId;		// id
	private String villageid;		// 小区ID
	private String trashDfjz;		// 低附加值垃圾回收总重
	private String trashZylj;		// 资源垃圾回收总重
	private String trashDhlj;		// 有毒有害垃圾回收总重
	private String creatdate;		// 建成时间格式: yyyy-MM-dd
	
	public SzEnvironmentalCommunityupload() {
		this(null);
	}

	public SzEnvironmentalCommunityupload(String id){
		super(id);
	}
	
	public Integer getWjqyId() {
		return wjqyId;
	}

	public void setWjqyId(Integer wjqyId) {
		this.wjqyId = wjqyId;
	}
	
	@Length(min=0, max=200, message="小区ID长度不能超过 200 个字符")
	public String getVillageid() {
		return villageid;
	}

	public void setVillageid(String villageid) {
		this.villageid = villageid;
	}
	
	@Length(min=0, max=255, message="低附加值垃圾回收总重长度不能超过 255 个字符")
	public String getTrashDfjz() {
		return trashDfjz;
	}

	public void setTrashDfjz(String trashDfjz) {
		this.trashDfjz = trashDfjz;
	}
	
	@Length(min=0, max=255, message="资源垃圾回收总重长度不能超过 255 个字符")
	public String getTrashZylj() {
		return trashZylj;
	}

	public void setTrashZylj(String trashZylj) {
		this.trashZylj = trashZylj;
	}
	
	@Length(min=0, max=255, message="有毒有害垃圾回收总重长度不能超过 255 个字符")
	public String getTrashDhlj() {
		return trashDhlj;
	}

	public void setTrashDhlj(String trashDhlj) {
		this.trashDhlj = trashDhlj;
	}
	
	@Length(min=0, max=255, message="建成时间格式长度不能超过 255 个字符")
	public String getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(String creatdate) {
		this.creatdate = creatdate;
	}
	
}