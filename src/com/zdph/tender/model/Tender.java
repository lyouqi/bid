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
	//��Ŀ����
	private String name;
	//��Ŀ״̬
	private String station;
	//��Ŀ���
	private String number;
	//������ֹ����
	private long SignTime;
	//����ʱ��
	private long startTime;
	//�ر�ʱ��
	private long endTime;
	//��Ŀ����
	private String type;
	//���������ʽ
	private String feeType;
	//���鹺���������
	private long purchaseTime;
	//��Ŀ����
	private String introduction;
	//��Ŀ�����ļ�
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
	//�б���
	private String owner;
	//�������
	private String agency;
	//��ϵ��
	private String contact;
	//��ϵ�绰
	private String telephone;
	//����
	private String fax;
	//E��MAIL
	private String email;
}
