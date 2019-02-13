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
@Table(name = "BACKUP")
public class BackupEntity {

	@Column(name = "BACKUP_ID")
	private String backupId;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SEND_LOATION")
	private String sendLocation;

	@Column(name = "SEND_DATE")
	private Date sendDate;

	@Column(name = "RETURN_DATE")
	private Date returnDate;

	@Column(name = "HAND_OVER_TO")
	private String handOverTo;

	@Column(name = "STATUS")
	private String status;
	
	private AssetEntity assetEntity;
	private RepairEntity repairEntity;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;
	
	@Column(name = "IS_ENABLED")
	private Integer enabled;

	@Id
	public String getBackupId() {
		return backupId;
	}

	public void setBackupId(String backupId) {
		this.backupId = backupId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSendLocation() {
		return sendLocation;
	}

	public void setSendLocation(String sendLocation) {
		this.sendLocation = sendLocation;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getHandOverTo() {
		return handOverTo;
	}

	public void setHandOverTo(String handOverTo) {
		this.handOverTo = handOverTo;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSET_ID")
	public AssetEntity getAssetEntity() {
		return assetEntity;
	}

	public void setAssetEntity(AssetEntity assetEntity) {
		this.assetEntity = assetEntity;
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

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
