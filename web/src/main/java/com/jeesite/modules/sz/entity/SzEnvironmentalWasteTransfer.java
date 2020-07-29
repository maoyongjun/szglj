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
 * 垃圾中转站信息Entity
 * @author myj
 * @version 2020-06-10
 */
@Table(name="sz_environmental_waste_transfer", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="number", attrName="number", label="编号"),
		@Column(name="charge_in", attrName="chargeIn", label="进料"),
		@Column(name="charge_out", attrName="chargeOut", label="出料"),
		@Column(name="transfer_name", attrName="transferName", label="中转站名称", queryType=QueryType.LIKE),
		@Column(name="date", attrName="date", label="日期"),
	}, orderBy="a.id DESC"
)
public class SzEnvironmentalWasteTransfer extends DataEntity<SzEnvironmentalWasteTransfer> {
	
	private static final long serialVersionUID = 1L;
	private String number;		// 编号
	private Double chargeIn;		// 进料
	private Double chargeOut;		// 出料
	private String transferName;		// 中转站名称
	private Date date;		// 日期
	
	public SzEnvironmentalWasteTransfer() {
		this(null);
	}

	public SzEnvironmentalWasteTransfer(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="编号长度不能超过 64 个字符")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Double getChargeIn() {
		return chargeIn;
	}

	public void setChargeIn(Double chargeIn) {
		this.chargeIn = chargeIn;
	}
	
	public Double getChargeOut() {
		return chargeOut;
	}

	public void setChargeOut(Double chargeOut) {
		this.chargeOut = chargeOut;
	}
	
	@Length(min=0, max=300, message="中转站名称长度不能超过 300 个字符")
	public String getTransferName() {
		return transferName;
	}

	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}