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
@Table(name = "ASSIGNEE")
public class AssigneeEntity {
	
	@Column(name = "ASSIGNEE_ID")
	private String assigneeId;
	
	@Column(name = "ASSIGNEE_NAME")
	private String assigneeName;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;
	
	List<AssigneeRepairEntity> assigneeRepairEntity;

	@Id
	public String getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
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

	@JsonIgnore
	@OneToMany(mappedBy = "assigneeEntity", targetEntity = AssigneeRepairEntity.class)
	public List<AssigneeRepairEntity> getAssigneeRepairEntity() {
		return assigneeRepairEntity;
	}

	public void setAssigneeRepairEntity(List<AssigneeRepairEntity> assigneeRepairEntity) {
		this.assigneeRepairEntity = assigneeRepairEntity;
	}
	
	@Override
	public String toString() {
		return "AssigneeEntity [assigneeId=" + assigneeId + ", assigneeName=" + assigneeName + ", createDate="
				+ createDate + ", createBy=" + createBy + ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy
				+ ", assigneeRepairEntity=" + assigneeRepairEntity + "]";
	}

}
