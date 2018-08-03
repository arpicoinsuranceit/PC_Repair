package com.arpico.groupit.pc_repair.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET_LOCATION_DETAILS")
public class AssetLocationEntity {

	@Column(name = "ASSET_LOCATION_ID")
	private String assetLoationId;
	
	private LocationEntity locationEntity;
	
	private AssetEntity assetEntity;
	
	@Column(name = "IS_ENABLED")
	private Integer enabled;

	@Id
	public String getAssetLoationId() {
		return assetLoationId;
	}

	public void setAssetLoationId(String assetLoationId) {
		this.assetLoationId = assetLoationId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID")
	public LocationEntity getLocationEntity() {
		return locationEntity;
	}

	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSET_ID")
	public AssetEntity getAssetEntity() {
		return assetEntity;
	}

	public void setAssetEntity(AssetEntity assetEntity) {
		this.assetEntity = assetEntity;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "AssetLocationEntity [assetLoationId=" + assetLoationId + ", locationEntity=" + locationEntity
				+ ", assetEntity=" + assetEntity + ", enabled=" + enabled + "]";
	}
	
	
	
}
