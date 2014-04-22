package com.zdph.tender.model;

import java.io.Serializable;

public class Tender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5145907393311995867L;
	//ID
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//项目名称
	private String name;
	//项目状态
	private String station;
	//项目编号
	private String number;
	//报名截止日期
	private long SignTime;
	//开标时间
	private long startTime;
	//截标时间
	private long endTime;
	//项目类型
	private String type;
	//标书费用形式
	private String feeType;
	//标书购买截至日期
	private long purchaseTime;
	//项目介绍
	private String introduction;
	//项目公告文件
	private String file;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public long getSignTime() {
		return SignTime;
	}
	public void setSignTime(long signTime) {
		SignTime = signTime;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public long getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(long purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//招标人
	private String owner;
	//代理机构
	private String agency;
	//联系人
	private String contact;
	//联系电话
	private String telephone;
	//传真
	private String fax;
	//E—MAIL
	private String email;
}
