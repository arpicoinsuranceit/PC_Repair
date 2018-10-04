package com.arpico.groupit.pc_repair.dto;

public class BackupDto {
	
	private String repairId;
	private String assetId;
	private String remark;
	private String handOver;
	private String sendDate;
	private String returnDate;

	public String getRepairId() {
		return repairId;
	}

	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHandOver() {
		return handOver;
	}

	public void setHandOver(String handOver) {
		this.handOver = handOver;
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

	@Override
	public String toString() {
		return "BackupDto [repairId=" + repairId + ", assetId=" + assetId + ", remark=" + remark + ", handOver="
				+ handOver + ", sendDate=" + sendDate + ", returnDate=" + returnDate + "]";
	}
}
