package com.arpico.groupit.pc_repair.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "PARTS")
@Entity
public class PartsEntity {

	@Column(name = "PART_ID")
	private String partId;
	
	@Column(name = "PART_ANME")
	private String partName;
	
	@Column(name = "WARRENTY_PERIOD")
	private String warrentyPeriod;
	
	@Column(name = "WARRENTY_EXP_DATE")
	private Date warrantyExp;
	
	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "CREATE_BY")
	private String createBy;
	
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;
	
	@Column(name = "MODIFY_BY")
	private String modifyBy;
	
	@Column(name = "SERIAL_ID")
	private String serialId;
	
	@Column(name = "PART_VALUE")
	private Double partValue;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "STATUS")
	private String status;
	
	private SupplierEntity supplierEntity;
	private List<RepairPartsEntity> repairPartsEntities;

	@Id
	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getWarrentyPeriod() {
		return warrentyPeriod;
	}

	public void setWarrentyPeriod(String warrentyPeriod) {
		this.warrentyPeriod = warrentyPeriod;
	}

	public Date getWarrantyExp() {
		return warrantyExp;
	}

	public void setWarrantyExp(Date warrantyExp) {
		this.warrantyExp = warrantyExp;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public Double getPartValue() {
		return partValue;
	}

	public void setPartValue(Double partValue) {
		this.partValue = partValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUPPLIER_ID")
	public SupplierEntity getSupplierEntity() {
		return supplierEntity;
	}

	public void setSupplierEntity(SupplierEntity supplierEntity) {
		this.supplierEntity = supplierEntity;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "partsEntity", targetEntity = RepairPartsEntity.class)
	public List<RepairPartsEntity> getRepairPartsEntities() {
		return repairPartsEntities;
	}

	public void setRepairPartsEntities(List<RepairPartsEntity> repairPartsEntities) {
		this.repairPartsEntities = repairPartsEntities;
	}

	
}
