package com.arpico.groupit.pc_repair.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ERROR")
public class ErrorEntity {

	@Column(name = "ERROR_ID")
	private String errorId;

	@Column(name = "ERROR_NAME")
	private String errorName;

	@Column(name = "ERROR_DISCRIPTION")
	private String errorDiscription;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;

	private List<RepairErrorDetailEntity> repairErrorEntities;
	
	@Id
	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorDiscription() {
		return errorDiscription;
	}

	public void setErrorDiscription(String errorDiscription) {
		this.errorDiscription = errorDiscription;
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

	@OneToMany(mappedBy = "errorEntity", targetEntity = RepairErrorDetailEntity.class)
	@JsonIgnore
	public List<RepairErrorDetailEntity> getRepairErrorEntities() {
		return repairErrorEntities;
	}

	public void setRepairErrorEntities(List<RepairErrorDetailEntity> repairErrorEntities) {
		this.repairErrorEntities = repairErrorEntities;
	}

	
}
