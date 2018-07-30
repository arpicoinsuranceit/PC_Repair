package com.arpico.groupit.pc_repair.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPAIR_SEND")
public class RepairSendEntity {

	@Column(name = "REPAIR_SEND_ID")
	private String repairSendId;
	
	@Column(name = "FROM_LOCATION")
	private String fromLocation;
	
	@Column(name = "TO_LOCATION")
	private String toLocation;
	
	@Column(name = "RESON")
	private String reason;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "METHOD")
	private String sendingMethod;
	
	@Column(name = "COURIER_ID")
	private String courierId;
	
	private RepairEntity repairEntity;

	@Id
	public String getRepairSendId() {
		return repairSendId;
	}

	public void setRepairSendId(String repairSendId) {
		this.repairSendId = repairSendId;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	@OneToOne(mappedBy = "repairSendEntity", targetEntity = RepairEntity.class)
	public RepairEntity getRepairEntity() {
		return repairEntity;
	}

	public void setRepairEntity(RepairEntity repairEntity) {
		this.repairEntity = repairEntity;
	}

}
