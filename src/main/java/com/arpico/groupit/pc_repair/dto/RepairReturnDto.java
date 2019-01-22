package com.arpico.groupit.pc_repair.dto;

public class RepairReturnDto {

	private String repairId;
	private String assetId;
	private String repairReturnId;
	private String fromLocation;
	private String toLocation;
	private String handOverTo;
	private String remark;
	private String sendingMethod;
	private String courierId;
	private String sendDate;
	private String status;

	public RepairReturnDto() {
	}

	public RepairReturnDto(String repairId, String assetId, String repairReturnId, String fromLocation, String toLocation, String handOverTo, String remark, String sendingMethod, String courierId, String sendDate) {
		this.repairId = repairId;
		this.assetId = assetId;
		this.repairReturnId = repairReturnId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.handOverTo = handOverTo;
		this.remark = remark;
		this.sendingMethod = sendingMethod;
		this.courierId = courierId;
		this.sendDate = sendDate;
	}

	public RepairReturnDto(String repairId, String assetId, String repairReturnId, String fromLocation, String toLocation, String handOverTo, String remark, String sendingMethod, String courierId, String sendDate, String status) {
		this.repairId = repairId;
		this.assetId = assetId;
		this.repairReturnId = repairReturnId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.handOverTo = handOverTo;
		this.remark = remark;
		this.sendingMethod = sendingMethod;
		this.courierId = courierId;
		this.sendDate = sendDate;
		this.status = status;
	}

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

	public String getRepairReturnId() {
		return repairReturnId;
	}

	public void setRepairReturnId(String repairReturnId) {
		this.repairReturnId = repairReturnId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getHandOverTo() {
		return handOverTo;
	}

	public void setHandOverTo(String handOverTo) {
		this.handOverTo = handOverTo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSendingMethod() {
		return sendingMethod;
	}

	public void setSendingMethod(String sendingMethod) {
		this.sendingMethod = sendingMethod;
	}

	public String getCourierId() {
		return courierId;
	}

	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
