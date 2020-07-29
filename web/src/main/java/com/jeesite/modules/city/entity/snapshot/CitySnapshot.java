/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.city.entity.snapshot;

import com.jeesite.modules.sys.entity.Office;
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
 * 随手拍事件Entity
 * @author chang
 * @version 2020-06-11
 */
@Table(name="city_snapshot", alias="a", columns={
		@Column(name="id", attrName="id", label="事件id", isPK=true),
		@Column(name="user_name", attrName="userName", label="名称", queryType=QueryType.LIKE),
		@Column(name="phone", attrName="phone", label="手机号"),
		@Column(name="pic_url1", attrName="picUrl1", label="图片地址1", isQuery=false),
		@Column(name="pic_url2", attrName="picUrl2", label="图片地址2", isQuery=false),
		@Column(name="pic_url3", attrName="picUrl3", label="图片地址3", isQuery=false),
		@Column(name="pic_url4", attrName="picUrl4", label="图片地址4", isQuery=false),
		@Column(name="pic_url5", attrName="picUrl5", label="图片地址5", isQuery=false),
		@Column(name="description", attrName="description", label="描述", isQuery=false),
		@Column(name="address", attrName="address", label="定位地点", isQuery=false),
		@Column(name="event_status", attrName="eventStatus", label="状态", comment="状态（0未转派 1已转派 2处理中 3完结 ）"),
		@Column(name="result", attrName="result", label="处理结果", isQuery=false),
		@Column(name="office_code", attrName="officeCode", label="部门Id"),
		@Column(name="office_name", attrName="officeName", label="部门名称", isUpdate=false, isQuery=false),
		@Column(name="upload_date", attrName="uploadDate", label="提交日期", isQuery=false),
		@Column(name="send_date", attrName="sendDate", label="发派日期", isQuery=false),
		@Column(name="receive_date", attrName="receiveDate", label="接收日期", isQuery=false),
		@Column(name="finish_date", attrName="finishDate", label="完结日期", isQuery=false),
		@Column(name="uuid", attrName="uuid", label="uuid", isQuery=false),
	},
	joinTable = @JoinTable(
			type = Type.LEFT_JOIN,
			entity = Office.class,
			alias = "o",
			on = "o.office_code=a.office_code",
			attrName = "office",
			columns = {@Column(
					includeEntity = Office.class
			)}
	),
	orderBy="a.id DESC"
)
public class CitySnapshot extends DataEntity<CitySnapshot> {
	
	private static final long serialVersionUID = 1L;
	private String userName;	// 名称
	private String phone;		// 手机号
	private String picUrl1;		// 图片地址1
	private String picUrl2;		// 图片地址2
	private String picUrl3;		// 图片地址3
	private String picUrl4;		// 图片地址4
	private String picUrl5;		// 图片地址5
	private String description;		// 描述
	private String address;		// 定位地点
	private String result;		// 处理结果
	private String officeCode;		// 部门Id
	private String officeName;		// 部门名称
	private Date uploadDate;		// 提交日期
	private Date sendDate;		// 发派日期
	private Date receiveDate;		// 接收日期
	private Date finishDate;		// 完结日期
	private String uuid;			//uuid
	private String eventStatus;  	//事件状态

	private Office office;
	
	public CitySnapshot() {
		this(null);
	}

	public CitySnapshot(String id){
		super(id);
	}

	public Office getOffice() {
		if(this.office==null){
			this.office = new Office(this.officeCode);
		}
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	
	@Length(min=0, max=200, message="名称长度不能超过 200 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=20, message="手机号长度不能超过 20 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=300, message="图片地址1长度不能超过 300 个字符")
	public String getPicUrl1() {
		return picUrl1;
	}

	public void setPicUrl1(String picUrl1) {
		this.picUrl1 = picUrl1;
	}
	
	@Length(min=0, max=300, message="图片地址2长度不能超过 300 个字符")
	public String getPicUrl2() {
		return picUrl2;
	}

	public void setPicUrl2(String picUrl2) {
		this.picUrl2 = picUrl2;
	}
	
	@Length(min=0, max=300, message="图片地址3长度不能超过 300 个字符")
	public String getPicUrl3() {
		return picUrl3;
	}

	public void setPicUrl3(String picUrl3) {
		this.picUrl3 = picUrl3;
	}
	
	@Length(min=0, max=300, message="图片地址4长度不能超过 300 个字符")
	public String getPicUrl4() {
		return picUrl4;
	}

	public void setPicUrl4(String picUrl4) {
		this.picUrl4 = picUrl4;
	}
	
	@Length(min=0, max=300, message="图片地址5长度不能超过 300 个字符")
	public String getPicUrl5() {
		return picUrl5;
	}

	public void setPicUrl5(String picUrl5) {
		this.picUrl5 = picUrl5;
	}
	
	@Length(min=0, max=500, message="描述长度不能超过 500 个字符")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=300, message="定位地点长度不能超过 300 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=255, message="处理结果长度不能超过 255 个字符")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Length(min=0, max=64, message="部门Id长度不能超过 64 个字符")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	@Length(min=0, max=200, message="部门名称长度不能超过 200 个字符")
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	@Override
	public String toString() {
		return "CitySnapshot{" +
				"userName='" + userName + '\'' +
				", phone='" + phone + '\'' +
				", picUrl1='" + picUrl1 + '\'' +
				", picUrl2='" + picUrl2 + '\'' +
				", picUrl3='" + picUrl3 + '\'' +
				", picUrl4='" + picUrl4 + '\'' +
				", picUrl5='" + picUrl5 + '\'' +
				", description='" + description + '\'' +
				", address='" + address + '\'' +
				", result='" + result + '\'' +
				", officeCode='" + officeCode + '\'' +
				", officeName='" + officeName + '\'' +
				", uploadDate=" + uploadDate +
				", sendDate=" + sendDate +
				", receiveDate=" + receiveDate +
				", finishDate=" + finishDate +
				", uuid='" + uuid + '\'' +
				", eventStatus='" + eventStatus + '\'' +
				", office=" + office +
				'}';
	}
}