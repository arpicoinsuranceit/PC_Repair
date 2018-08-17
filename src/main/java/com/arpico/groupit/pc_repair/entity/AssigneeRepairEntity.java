package com.arpico.groupit.pc_repair.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSIGNEE_REPAIR")
public class AssigneeRepairEntity {

	@Column(name = "ASSIGNEE_REPAIR_ID")
	private String assigneeRepairId;

	@Column(name = "ASSIGNEE_START_TIME")
	private Date assignStartTime;

	@Column(name = "ASSIGNEE_END_TIME")
	private Date assignEndTime;
	
	@Column(name = "IS_ENABLED")
	private Integer enabled;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;

	private RepairEntity repairEntity;
	private AssigneeEntity assigneeEntity;

	@Id
	public String getAssigneeRepairId() {
		return assigneeRepairId;
	}

	public void setAssigneeRepairId(String assigneeRepairId) {
		this.assigneeRepairId = assigneeRepairId;
	}

	public Date getAssignStartTime() {
		return assignStartTime;
	}

	public void setAssignStartTime(Date assignStartTime) {
		this.assignStartTime = assignStartTime;
	}

	public Date getAssignEndTime() {
		return assignEndTime;
	}

	public void setAssignEndTime(Date assignEndTime) {
		this.assignEndTime = assignEndTime;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REPAIR_ID")
	public RepairEntity getRepairEntity() {
		return repairEntity;
	}

	public void setRepairEntity(RepairEntity repairEntity) {
		this.repairEntity = repairEntity;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSIGNEE_ID")
	public AssigneeEntity getAssigneeEntity() {
		return assigneeEntity;
	}

	public void setAssigneeEntity(AssigneeEntity assigneeEntity) {
		this.assigneeEntity = assigneeEntity;
	}

}
