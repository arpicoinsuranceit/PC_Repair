package com.arpico.groupit.pc_repair.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "REPAIR_ERROR_DETAILS")
@Entity
public class RepairErrorDetailEntity {

	@Column(name = "REPAIR_ERROR_ID")
	private String repairErrorId;
	
	@Column(name = "IS_ENABLED")
	private Integer enabled;

	private RepairEntity repairEntity;

	private ErrorEntity errorEntity;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Id
	public String getRepairErrorId() {
		return repairErrorId;
	}

	public void setRepairErrorId(String repairErrorId) {
		this.repairErrorId = repairErrorId;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REPAIR_ID")
	public RepairEntity getRepairEntity() {
		return repairEntity;
	}

	public void setRepairEntity(RepairEntity repairEntity) {
		this.repairEntity = repairEntity;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ERROR_ID")
	public ErrorEntity getErrorEntity() {
		return errorEntity;
	}

	public void setErrorEntity(ErrorEntity errorEntity) {
		this.errorEntity = errorEntity;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
