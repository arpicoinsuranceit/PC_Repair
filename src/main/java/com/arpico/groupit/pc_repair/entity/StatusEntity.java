package com.arpico.groupit.pc_repair.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "STATUS")
@Entity
public class StatusEntity {
	
	@Column(name = "STATUS_ID")
	private String statusId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;
	
	private List<RepairStatusEntity> repairStatusEntities;

	@Id
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

	@OneToMany(mappedBy = "statusEntity", targetEntity = RepairStatusEntity.class)
	@JsonIgnore
	public List<RepairStatusEntity> getRepairStatusEntities() {
		return repairStatusEntities;
	}

	public void setRepairStatusEntities(List<RepairStatusEntity> repairStatusEntities) {
		this.repairStatusEntities = repairStatusEntities;
	}

//	@Override
//	public String toString() {
//		return "StatusEntity [statusId=" + statusId + ", description=" + description + ", createDate=" + createDate
//				+ ", createBy=" + createBy + ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy
//				+ ", repairStatusEntities=" + repairStatusEntities + "]";
//	}
	
	
	
}
