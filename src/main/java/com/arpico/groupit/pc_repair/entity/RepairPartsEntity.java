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
@Table(name = "REPAIR_PARTS_ENTITY")
public class RepairPartsEntity {

	@Column(name = "REPAIR_PARTS_ID")
	private String id;
	
	private PartsEntity partsEntity;
	private RepairEntity repairEntity;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "CREATE_BY")
	private String createBy;
	
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;
	
	@Column(name = "MODIFY_BY")
	private String modifyBy;
	
	@Column(name = "REMARK")
	private String remark;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PART_ID")
	public PartsEntity getPartsEntity() {
		return partsEntity;
	}

	public void setPartsEntity(PartsEntity partsEntity) {
		this.partsEntity = partsEntity;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REPAIR_ID")
	public RepairEntity getRepairEntity() {
		return repairEntity;
	}

	public void setRepairEntity(RepairEntity repairEntity) {
		this.repairEntity = repairEntity;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
