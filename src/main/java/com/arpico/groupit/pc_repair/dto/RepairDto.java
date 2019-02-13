package com.arpico.groupit.pc_repair.dto;

import java.util.List;

public class RepairDto {

	private String repairId;
	private Integer jobNo;
	private AssetDto assetDto;
	private LocationDto locationDto;
	private String reason;
	private String priority;
	private AssigneeDto assigneeDto;
	private StatusDto statusDto;
	private String remark;
	private List<ErrorDto> errorDtos;
	private List<PartsDto> partsDtos;


	

	public RepairDto() {
		super();
	}

	


	public RepairDto(String repairId, Integer jobNo, AssetDto assetDto, LocationDto locationDto, String reason,
			String priority, AssigneeDto assigneeDto, StatusDto statusDto, String remark, List<ErrorDto> errorDtos,
			List<PartsDto> partsDtos) {
		super();
		this.repairId = repairId;
		this.jobNo = jobNo;
		this.assetDto = assetDto;
		this.locationDto = locationDto;
		this.reason = reason;
		this.priority = priority;
		this.assigneeDto = assigneeDto;
		this.statusDto = statusDto;
		this.remark = remark;
		this.errorDtos = errorDtos;
		this.partsDtos = partsDtos;
	}




	public String getRepairId() {
		return repairId;
	}



	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}



	public Integer getJobNo() {
		return jobNo;
	}



	public void setJobNo(Integer jobNo) {
		this.jobNo = jobNo;
	}



	public AssetDto getAssetDto() {
		return assetDto;
	}



	public void setAssetDto(AssetDto assetDto) {
		this.assetDto = assetDto;
	}



	public LocationDto getLocationDto() {
		return locationDto;
	}



	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public AssigneeDto getAssigneeDto() {
		return assigneeDto;
	}



	public void setAssigneeDto(AssigneeDto assigneeDto) {
		this.assigneeDto = assigneeDto;
	}



	public StatusDto getStatusDto() {
		return statusDto;
	}



	public void setStatusDto(StatusDto statusDto) {
		this.statusDto = statusDto;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public List<ErrorDto> getErrorDtos() {
		return errorDtos;
	}



	public void setErrorDtos(List<ErrorDto> errorDtos) {
		this.errorDtos = errorDtos;
	}



	public List<PartsDto> getPartsDtos() {
		return partsDtos;
	}



	public void setPartsDtos(List<PartsDto> partsDtos) {
		this.partsDtos = partsDtos;
	}

	@Override
	public String toString() {
		return "RepairDto [repairId=" + repairId + ", jobNo=" + jobNo + ", assetDto=" + assetDto + ", locationDto="
				+ locationDto + ", reason=" + reason + ", priority=" + priority + ", assigneeDto=" + assigneeDto
				+ ", statusDto=" + statusDto + ", errorDtos=" + errorDtos + ", partsDtos=" + partsDtos + "]";
	}

	

}
