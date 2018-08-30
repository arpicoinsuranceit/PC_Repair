package com.arpico.groupit.pc_repair.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "REPAIR_STATUS")
@Entity
public class RepairStatusEntity {

	@Column(name = "REPAIR_STATUS_ID")
	private String id;

	@Column(name = "IS_ENABLED")
	private Integer enabled;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	private RepairEntity repairEntity;
	private StatusEntity statusEntity;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@JoinColumn(name = "REPAIR_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	public RepairEntity getRepairEntity() {
		return repairEntity;
	}

	public void setRepairEntity(RepairEntity repairEntity) {
		this.repairEntity = repairEntity;
	}

	@JoinColumn(name = "STATUS_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	public StatusEntity getStatusEntity() {
		return statusEntity;
	}

	public void setStatusEntity(StatusEntity statusEntity) {
		this.statusEntity = statusEntity;
	}

	@Override
	public String toString() {
		return "RepairStatusEntity [id=" + id + ", enabled=" + enabled + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + ", repairEntity=" + repairEntity + ", statusEntity=" + statusEntity + "]";
	}

}
