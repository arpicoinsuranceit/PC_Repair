package com.arpico.groupit.pc_repair.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "REPAIR")
@Entity
public class RepairEntity {
	
	@Column(name = "REPAIR_ID")
	private String RepairId; 
	
	@Column(name = "JOB_NO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jobNo; 
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PRIORITY")
	private String priority;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "CREATE_DATE")
	private Date cerateDate;
	
	@Column(name = "MODIFY_DATE")
	private Date modifydate;
	
	@Column(name = "CREATE_BY")
	private String cerateby;
	
	@Column(name = "MODIFY_BY")
	private String modifyby;
	
	private AssetEntity assetEntity;
	private List<RepairPartsEntity> repairPartsEntities;
	private List<BackupEntity> backupEntities;
	
	private RepairSendEntity repairSendEntity;
	private RepairReturnEntity repairReturnEntity;
	
	private List<AssigneeRepairEntity> assigneeRepairEntities;
	private List<RepairErrorDetailEntity> repairErrorDetailEntities;
	
	private List<RepairStatusEntity> repairStatusEntities;

	@Id
	public String getRepairId() {
		return RepairId;
	}

	public void setRepairId(String repairId) {
		RepairId = repairId;
	}

	public Integer getJobNo() {
		return jobNo;
	}

	public void setJobNo(Integer jobNo) {
		this.jobNo = jobNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCerateDate() {
		return cerateDate;
	}

	public void setCerateDate(Date cerateDate) {
		this.cerateDate = cerateDate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getCerateby() {
		return cerateby;
	}

	public void setCerateby(String cerateby) {
		this.cerateby = cerateby;
	}

	public String getModifyby() {
		return modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSET_ID")
	public AssetEntity getAssetEntity() {
		return assetEntity;
	}

	public void setAssetEntity(AssetEntity assetEntity) {
		this.assetEntity = assetEntity;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "repairEntity", targetEntity = RepairPartsEntity.class)
	public List<RepairPartsEntity> getRepairPartsEntities() {
		return repairPartsEntities;
	}

	public void setRepairPartsEntities(List<RepairPartsEntity> repairPartsEntities) {
		this.repairPartsEntities = repairPartsEntities;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "repairEntity", targetEntity = BackupEntity.class)
	public List<BackupEntity> getBackupEntities() {
		return backupEntities;
	}

	public void setBackupEntities(List<BackupEntity> backupEntities) {
		this.backupEntities = backupEntities;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REPAIR_SEND_ID")
	public RepairSendEntity getRepairSendEntity() {
		return repairSendEntity;
	}

	public void setRepairSendEntity(RepairSendEntity repairSendEntity) {
		this.repairSendEntity = repairSendEntity;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REPAIR_RETURN_ID")
	public RepairReturnEntity getRepairReturnEntity() {
		return repairReturnEntity;
	}

	public void setRepairReturnEntity(RepairReturnEntity repairReturnEntity) {
		this.repairReturnEntity = repairReturnEntity;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "repairEntity", targetEntity = AssigneeRepairEntity.class)
	public List<AssigneeRepairEntity> getAssigneeRepairEntities() {
		return assigneeRepairEntities;
	}

	public void setAssigneeRepairEntities(List<AssigneeRepairEntity> assigneeRepairEntities) {
		this.assigneeRepairEntities = assigneeRepairEntities;
	}
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "repairEntity", targetEntity = RepairErrorDetailEntity.class)
	public List<RepairErrorDetailEntity> getRepairErrorDetailEntities() {
		return repairErrorDetailEntities;
	}

	public void setRepairErrorDetailEntities(List<RepairErrorDetailEntity> repairErrorDetailEntities) {
		this.repairErrorDetailEntities = repairErrorDetailEntities;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "repairEntity", targetEntity = RepairStatusEntity.class)
	public List<RepairStatusEntity> getRepairStatusEntities() {
		return repairStatusEntities;
	}

	public void setRepairStatusEntities(List<RepairStatusEntity> repairStatusEntities) {
		this.repairStatusEntities = repairStatusEntities;
	}



	
}
