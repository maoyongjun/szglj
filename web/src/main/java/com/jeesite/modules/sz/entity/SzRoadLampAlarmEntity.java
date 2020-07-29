package com.jeesite.modules.sz.entity;

import java.util.Date;

public class SzRoadLampAlarmEntity {
    private Integer id;
    private Short cid;
    private Short type;
    private Short level;
    private String pid;
    private String sid;
    private String hid;
    private String aname;
    private String sname;
    private String cuid;
    private Short ctype;
    private Short htype;
    private String hname;
    private Short atype;
    private Long add;
    private Long ch;
    private String luid;
    private Short num;
    private Short k;
    private String v;
    private Boolean r;
    private Date t;
    private Long c;
    private Long ac;
    private String msg;
    private String note;
    private Boolean sms;
    private Boolean email;
    private Short stationAlarms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCid() {
        return cid;
    }

    public void setCid(Short cid) {
        this.cid = cid;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public Short getCtype() {
        return ctype;
    }

    public void setCtype(Short ctype) {
        this.ctype = ctype;
    }

    public Short getHtype() {
        return htype;
    }

    public void setHtype(Short htype) {
        this.htype = htype;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Short getAtype() {
        return atype;
    }

    public void setAtype(Short atype) {
        this.atype = atype;
    }

    public Long getAdd() {
        return add;
    }

    public void setAdd(Long add) {
        this.add = add;
    }

    public Long getCh() {
        return ch;
    }

    public void setCh(Long ch) {
        this.ch = ch;
    }

    public String getLuid() {
        return luid;
    }

    public void setLuid(String luid) {
        this.luid = luid;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Short getK() {
        return k;
    }

    public void setK(Short k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Boolean getR() {
        return r;
    }

    public void setR(Boolean r) {
        this.r = r;
    }

    public Date getT() {
        return t;
    }

    public void setT(Date t) {
        this.t = t;
    }

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    public Long getAc() {
        return ac;
    }

    public void setAc(Long ac) {
        this.ac = ac;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getSms() {
        return sms;
    }

    public void setSms(Boolean sms) {
        this.sms = sms;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public Short getStationAlarms() {
        return stationAlarms;
    }

    public void setStationAlarms(Short stationAlarms) {
        this.stationAlarms = stationAlarms;
    }

    @Override
    public String toString() {
        return "SzRoadLampAlarmEntity{" +
                "id=" + id +
                ", cid=" + cid +
                ", type=" + type +
                ", level=" + level +
                ", pid='" + pid + '\'' +
                ", sid='" + sid + '\'' +
                ", hid='" + hid + '\'' +
                ", aname='" + aname + '\'' +
                ", sname='" + sname + '\'' +
                ", cuid='" + cuid + '\'' +
                ", ctype=" + ctype +
                ", htype=" + htype +
                ", hname='" + hname + '\'' +
                ", atype=" + atype +
                ", add=" + add +
                ", ch=" + ch +
                ", luid='" + luid + '\'' +
                ", num=" + num +
                ", k=" + k +
                ", v='" + v + '\'' +
                ", r=" + r +
                ", t=" + t +
                ", c=" + c +
                ", ac=" + ac +
                ", msg='" + msg + '\'' +
                ", note='" + note + '\'' +
                ", sms=" + sms +
                ", email=" + email +
                ", stationAlarms=" + stationAlarms +
                '}';
    }
}
