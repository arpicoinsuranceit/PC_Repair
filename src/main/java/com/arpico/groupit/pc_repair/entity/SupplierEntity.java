package com.arpico.groupit.pc_repair.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SUPPLIER")
public class SupplierEntity {

	@Column(name = "SUPPLER_ID")
	private String suplierId;
	
	@Column(name = "SUPPLER_NAME")
	private String suplierName;
	
	private List<AssetEntity> assetEntities;
	
	private List<PartsEntity> partsEntities;
	
	@Id
	public String getSuplierId() {
		return suplierId;
	}

	public void setSuplierId(String suplierId) {
		this.suplierId = suplierId;
	}

	public String getSuplierName() {
		return suplierName;
	}

	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}
	@OneToMany(mappedBy = "supplierEntity", targetEntity = AssetEntity.class)
	@JsonIgnore
	public List<AssetEntity> getAssetEntities() {
		return assetEntities;
	}

	public void setAssetEntities(List<AssetEntity> assetEntities) {
		this.assetEntities = assetEntities;
	}
	@OneToMany(mappedBy = "supplierEntity", targetEntity = PartsEntity.class)
	@JsonIgnore
	public List<PartsEntity> getPartsEntities() {
		return partsEntities;
	}

	public void setPartsEntities(List<PartsEntity> partsEntities) {
		this.partsEntities = partsEntities;
	}

	

}
