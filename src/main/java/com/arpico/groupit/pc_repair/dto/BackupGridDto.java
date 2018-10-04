package com.arpico.groupit.pc_repair.dto;

public class BackupGridDto {

	private String backupId;
	private Integer repairId;
	private String assetId;
	private String sendLoc;
	private String sendDate;
	private String returnDate;
	private String remark;
	private String handoverTo;

	public String getBackupId() {
		return backupId;
	}

	public void setBackupId(String backupId) {
		this.backupId = backupId;
	}

	public Integer getRepairId() {
		return repairId;
	}

	public void setRepairId(Integer repairId) {
		this.repairId = repairId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getSendLoc() {
		return sendLoc;
	}

	public void setSendLoc(String sendLoc) {
		this.sendLoc = sendLoc;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHandoverTo() {
		return handoverTo;
	}

	public void setHandoverTo(String handoverTo) {
		this.handoverTo = handoverTo;
	}

	@Override
	public String toString() {
		return "BackupGridDto [backupId=" + backupId + ", repairId=" + repairId + ", assetId=" + assetId + ", sendLoc="
				+ sendLoc + ", sendDate=" + sendDate + ", returnDate=" + returnDate + ", remark=" + remark
				+ ", handoverTo=" + handoverTo + "]";
	}

}
