package com.arpico.groupit.pc_repair.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REPAIR_RETURN")
public class RepairReturnEntity {

	@Column(name = "REPAIR_RETURN_ID")
	private String repairReturnId;
	
	@Column(name = "FROM_LOCATION")
	private String fromLocation;
	
	@Column(name = "TO_LOCATION")
	private String toLocation;
	
	@Column(name = "METHOD")
	private String sendingMethod;
	
	@Column(name = "COURIER_ID")
	private String courierId;
	
	@Column(name = "HAND_OVER_TO")
	private String handOverTo;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "SEND_DATE")
	private Date sendDate;
	
	@Column(name = "SEND_BY")
	private String sendBy;
	
	@Column(name = "RECEIVED_DATE")
	private Date recivedDate;
	

	@Column(name = "RECEIVED_BY")
	private String recivedBy;
	
	private RepairEntity repairEntity;

	@Id
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

	@OneToOne(mappedBy = "repairReturnEntity" , targetEntity = RepairEntity.class)
	public RepairEntity getRepairEntity() {
		return repairEntity;
	}

	public void setRepairEntity(RepairEntity repairEntity) {
		this.repairEntity = repairEntity;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendBy() {
		return sendBy;
	}

	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}

	public Date getRecivedDate() {
		return recivedDate;
	}

	public void setRecivedDate(Date recivedDate) {
		this.recivedDate = recivedDate;
	}

	public String getRecivedBy() {
		return recivedBy;
	}

	public void setRecivedBy(String recivedBy) {
		this.recivedBy = recivedBy;
	}

}
