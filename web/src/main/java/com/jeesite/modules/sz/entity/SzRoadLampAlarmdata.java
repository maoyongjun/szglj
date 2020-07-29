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
 * 报警数据Entity
 * @author myj
 * @version 2020-06-30
 */
@Table(name="sz_road_lamp_alarmdata", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="alarmid", attrName="alarmid", label="报警id"),
		@Column(name="cid", attrName="cid", label="警报类目"),
		@Column(name="type", attrName="type", label="警报类型"),
		@Column(name="level", attrName="level", label="警报等级"),
		@Column(name="pid", attrName="pid", label="项目序号", isQuery=false),
		@Column(name="sid", attrName="sid", label="控制柜序号"),
		@Column(name="hid", attrName="hid", label="硬件序号", isQuery=false),
		@Column(name="aname", attrName="aname", label="警报类型名称"),
		@Column(name="sname", attrName="sname", label="控制柜名称"),
		@Column(name="cuid", attrName="cuid", label="集中器UID", isQuery=false),
		@Column(name="ctype", attrName="ctype", label="集中器类型", isQuery=false),
		@Column(name="htype", attrName="htype", label="硬件类型", isQuery=false),
		@Column(name="hname", attrName="hname", label="硬件名称", isQuery=false),
		@Column(name="atype", attrName="atype", label="通道类型", isQuery=false),
		@Column(name="add", attrName="add", label="地址", isQuery=false),
		@Column(name="ch", attrName="ch", label="通道", isQuery=false),
		@Column(name="luid", attrName="luid", label="终端UID", isQuery=false),
		@Column(name="num", attrName="num", label="灯头号", isQuery=false),
		@Column(name="k", attrName="k", label="警报类型", isQuery=false),
		@Column(name="v", attrName="v", label="警报值", isQuery=false),
		@Column(name="r", attrName="r", label="是否解除标识", isQuery=false),
		@Column(name="t", attrName="t", label="最初警报时间", isQuery=false),
		@Column(name="c", attrName="c", label="发起警报次数", isQuery=false),
		@Column(name="ac", attrName="ac", label="所有警报总数", isQuery=false),
		@Column(name="msg", attrName="msg", label="警报信息"),
		@Column(name="note", attrName="note", label="解决方案或备注", isQuery=false),
		@Column(name="sms", attrName="sms", label="是否发送短信", isQuery=false),
		@Column(name="email", attrName="email", label="是否发送邮件", isQuery=false),
		@Column(name="stationalarms", attrName="stationalarms", label="控制柜警报数量", isQuery=false),
		@Column(name="handledate", attrName="handledate", label="解除报警时间"),
	}, orderBy="a.id DESC"
)
public class SzRoadLampAlarmdata extends DataEntity<SzRoadLampAlarmdata> {
	
	private static final long serialVersionUID = 1L;
	private Integer alarmid;		// 报警id
	private Integer cid;		// 警报类目
	private Integer type;		// 警报类型
	private Integer level;		// 警报等级
	private String pid;		// 项目序号
	private String sid;		// 控制柜序号
	private String hid;		// 硬件序号
	private String aname;		// 警报类型名称
	private String sname;		// 控制柜名称
	private String cuid;		// 集中器UID
	private Integer ctype;		// 集中器类型
	private Integer htype;		// 硬件类型
	private String hname;		// 硬件名称
	private Integer atype;		// 通道类型
	private Integer add;		// 地址
	private Integer ch;		// 通道
	private String luid;		// 终端UID
	private Integer num;		// 灯头号
	private Integer k;		// 警报类型
	private String v;		// 警报值
	private String r;		// 是否解除标识
	private Date t;		// 最初警报时间
	private Integer c;		// 发起警报次数
	private Integer ac;		// 所有警报总数
	private String msg;		// 警报信息
	private String note;		// 解决方案或备注
	private String sms;		// 是否发送短信
	private String email;		// 是否发送邮件
	private Integer stationalarms;		// 控制柜警报数量
	private Date handledate;		// 解除报警时间
	
	public SzRoadLampAlarmdata() {
		this(null);
	}

	public SzRoadLampAlarmdata(String id){
		super(id);
	}
	
	public Integer getAlarmid() {
		return alarmid;
	}

	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}
	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@Length(min=0, max=200, message="项目序号长度不能超过 200 个字符")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@Length(min=0, max=200, message="控制柜序号长度不能超过 200 个字符")
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
	@Length(min=0, max=200, message="硬件序号长度不能超过 200 个字符")
	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}
	
	@Length(min=0, max=200, message="警报类型名称长度不能超过 200 个字符")
	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Length(min=0, max=200, message="控制柜名称长度不能超过 200 个字符")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Length(min=0, max=64, message="集中器UID长度不能超过 64 个字符")
	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	
	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	
	public Integer getHtype() {
		return htype;
	}

	public void setHtype(Integer htype) {
		this.htype = htype;
	}
	
	@Length(min=0, max=200, message="硬件名称长度不能超过 200 个字符")
	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}
	
	public Integer getAtype() {
		return atype;
	}

	public void setAtype(Integer atype) {
		this.atype = atype;
	}
	
	public Integer getAdd() {
		return add;
	}

	public void setAdd(Integer add) {
		this.add = add;
	}
	
	public Integer getCh() {
		return ch;
	}

	public void setCh(Integer ch) {
		this.ch = ch;
	}
	
	@Length(min=0, max=64, message="终端UID长度不能超过 64 个字符")
	public String getLuid() {
		return luid;
	}

	public void setLuid(String luid) {
		this.luid = luid;
	}
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Integer getK() {
		return k;
	}

	public void setK(Integer k) {
		this.k = k;
	}
	
	@Length(min=0, max=500, message="警报值长度不能超过 500 个字符")
	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}
	
	@Length(min=0, max=1, message="是否解除标识长度不能超过 1 个字符")
	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getT() {
		return t;
	}

	public void setT(Date t) {
		this.t = t;
	}
	
	public Integer getC() {
		return c;
	}

	public void setC(Integer c) {
		this.c = c;
	}
	
	public Integer getAc() {
		return ac;
	}

	public void setAc(Integer ac) {
		this.ac = ac;
	}
	
	@Length(min=0, max=200, message="警报信息长度不能超过 200 个字符")
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Length(min=0, max=500, message="解决方案或备注长度不能超过 500 个字符")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Length(min=0, max=1, message="是否发送短信长度不能超过 1 个字符")
	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}
	
	@Length(min=0, max=1, message="是否发送邮件长度不能超过 1 个字符")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getStationalarms() {
		return stationalarms;
	}

	public void setStationalarms(Integer stationalarms) {
		this.stationalarms = stationalarms;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getHandledate() {
		return handledate;
	}

	public void setHandledate(Date handledate) {
		this.handledate = handledate;
	}
	
}