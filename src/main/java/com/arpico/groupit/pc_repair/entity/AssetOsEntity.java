package com.arpico.groupit.pc_repair.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET_OPERATING_SYSTEM")
public class AssetOsEntity {
	
	@Column(name = "ASSET_OS_ID")
	private String assetOsId;
	
	@Column(name = "SERIAL_ID")
	private String serialId;
	
	@Column(name = "IS_ENABLED")
	private Integer enabled;
	
	private AssetEntity assetEntity;
	
	private OperatingSystemEntity operatingSystemEntity;

	@Id
	public String getAssetOsId() {
		return assetOsId;
	}

	public void setAssetOsId(String assetOsId) {
		this.assetOsId = assetOsId;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSET_ID")
	public AssetEntity getAssetEntity() {
		return assetEntity;
	}

	public void setAssetEntity(AssetEntity assetEntity) {
		this.assetEntity = assetEntity;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OPERATING_SYSTEM_ID")
	public OperatingSystemEntity getOperatingSystemEntity() {
		return operatingSystemEntity;
	}

	public void setOperatingSystemEntity(OperatingSystemEntity operatingSystemEntity) {
		this.operatingSystemEntity = operatingSystemEntity;
	}
	
	
	

}
