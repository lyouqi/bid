package com.zdph.tender.model;

import java.io.Serializable;
/**
 * 检索结果实体
 */
public class TenderInformation implements Serializable {

	private static final long serialVersionUID = -4900665690145949771L;

	// 主键(页面展示链接明细时使用)
	private String ecpId;

	// 招标名称
	private String ecpName;

	// 招标地点
	private String ecpAddress;

	// 招标编号
	private String ecpCode;

	// 招标开始时间
	private Long ecpStart;

	// 招标截止时间
	private Long ecpEnd;

	// 招标内容
	private String ecpContent;

	// 项目状态
	private String ecpState;

	// 附件名称
	private String fileName;

	// 附件存储路径
	private String filePath;

	// 附件大小
	private String fileSize;

	// 附件创建时间
	private Long fileCreateDate;

	// 附件内容
	private String fileContent;

	public String getEcpId() {
		return ecpId;
	}

	public void setEcpId(String ecpId) {
		this.ecpId = ecpId;
	}

	public String getEcpName() {
		return ecpName;
	}

	public void setEcpName(String ecpName) {
		this.ecpName = ecpName;
	}

	public String getEcpAddress() {
		return ecpAddress;
	}

	public void setEcpAddress(String ecpAddress) {
		this.ecpAddress = ecpAddress;
	}

	public String getEcpCode() {
		return ecpCode;
	}

	public void setEcpCode(String ecpCode) {
		this.ecpCode = ecpCode;
	}

	public Long getEcpStart() {
		return ecpStart;
	}

	public void setEcpStart(Long ecpStart) {
		this.ecpStart = ecpStart;
	}

	public Long getEcpEnd() {
		return ecpEnd;
	}

	public void setEcpEnd(Long ecpEnd) {
		this.ecpEnd = ecpEnd;
	}

	public String getEcpContent() {
		return ecpContent;
	}

	public void setEcpContent(String ecpContent) {
		this.ecpContent = ecpContent;
	}

	public String getEcpState() {
		return ecpState;
	}

	public void setEcpState(String ecpState) {
		this.ecpState = ecpState;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Long getFileCreateDate() {
		return fileCreateDate;
	}

	public void setFileCreateDate(Long fileCreateDate) {
		this.fileCreateDate = fileCreateDate;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
}
