package com.arpico.groupit.pc_repair.dto;

public class RepairBasicsDto {

	private String status;
	private String error;
	private String remark;
	private String priority;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "RepairBasicsDto [status=" + status + ", error=" + error + ", remark=" + remark + ", priority="
				+ priority + "]";
	}

	

}
