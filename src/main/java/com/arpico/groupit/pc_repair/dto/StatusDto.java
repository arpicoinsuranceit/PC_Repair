package com.arpico.groupit.pc_repair.dto;

import java.util.Date;

public class StatusDto {

	private String statusId;
	private String description;
	private Date createDate;
	private String createBy;
	private Date modifyDate;
	private String modifyBy;

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	@Override
	public String toString() {
		return "StatusDto [statusId=" + statusId + ", description=" + description + ", createDate=" + createDate
				+ ", createBy=" + createBy + ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy + "]";
	}

}
