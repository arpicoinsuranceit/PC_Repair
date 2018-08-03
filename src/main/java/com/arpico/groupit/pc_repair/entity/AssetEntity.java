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


@Entity
@Table(name = "ASSET")
public class AssetEntity {

	@Column(name = "ASSET_CODE")
	private String assetCode;
	
	@Column(name = "ASSET_DESCRIPTION")
	private String assetDescription;
	
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	
	@Column(name = "SERIAL_NO")
	private String serialNo;
	
	@Column(name = "PURCHASE_DATE")
	private Date purchasdate;
	
	@Column(name = "WARRENTY_PERIOD")
	private String warrantyPeriod;
	
	@Column(name = "WARRENTY_EXP_DATE")
	private Date warrantyExp;
	
	@Column(name = "ASSET_VALUE")
	private Double assetValue;
	
	@Column(name = "CREATE_DATE")
	private Date cerateDate;
	
	@Column(name = "MODIFY_DATE")
	private Date modifydate;
	
	@Column(name = "CREATE_BY")
	private String cerateby;
	
	@Column(name = "MODIFY_BY")
	private String modifyby;
	
	@Column(name = "REMARK")
	private String remark;
	
	private SupplierEntity supplierEntity;
	
	private List<RepairEntity> repairEntities;
	
	private List<BackupEntity> backupEntities;
	
	private List<AssetLocationEntity> assetLocationEntities;
	
	private List<AssetOsEntity>  assetOsEntities ;

	@Id
	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Date getPurchasdate() {
		return purchasdate;
	}

	public void setPurchasdate(Date purchasdate) {
		this.purchasdate = purchasdate;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Date getWarrantyExp() {
		return warrantyExp;
	}

	public void setWarrantyExp(Date warrantyExp) {
		this.warrantyExp = warrantyExp;
	}

	public Double getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(Double assetValue) {
		this.assetValue = assetValue;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUPPLIER_ID")
	public SupplierEntity getSupplierEntity() {
		return supplierEntity;
	}

	public void setSupplierEntity(SupplierEntity supplierEntity) {
		this.supplierEntity = supplierEntity;
	}

	@OneToMany(mappedBy = "assetEntity", targetEntity = RepairEntity.class)
	@JsonIgnore
	public List<RepairEntity> getRepairEntities() {
		return repairEntities;
	}

	public void setRepairEntities(List<RepairEntity> repairEntities) {
		this.repairEntities = repairEntities;
	}

	@OneToMany(mappedBy = "assetEntity", targetEntity = BackupEntity.class)
	@JsonIgnore
	public List<BackupEntity> getBackupEntities() {
		return backupEntities;
	}

	public void setBackupEntities(List<BackupEntity> backupEntities) {
		this.backupEntities = backupEntities;
	}

	@OneToMany(mappedBy = "assetEntity", targetEntity = AssetLocationEntity.class)
	@JsonIgnore
	public List<AssetLocationEntity> getAssetLocationEntities() {
		return assetLocationEntities;
	}

	public void setAssetLocationEntities(List<AssetLocationEntity> assetLocationEntities) {
		this.assetLocationEntities = assetLocationEntities;
	}

	@OneToMany(mappedBy = "assetEntity", targetEntity = AssetOsEntity.class)
	@JsonIgnore
	public List<AssetOsEntity> getAssetOsEntities() {
		return assetOsEntities;
	}

	public void setAssetOsEntities(List<AssetOsEntity> assetOsEntities) {
		this.assetOsEntities = assetOsEntities;
	}


	
}
