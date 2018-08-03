package com.arpico.groupit.pc_repair.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LOCATION")
public class LocationEntity {

	@Column(name = "LOCATION_ID")
	private String locationId;
	
	@Column(name = "LOCATION_NAME")
	private String locationName;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;
	
	private List<AssetLocationEntity> assetLocationEntities;
	
	
	@Id
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	@OneToMany(mappedBy = "locationEntity", targetEntity = AssetLocationEntity.class)
	@JsonIgnore
	public List<AssetLocationEntity> getAssetLocationEntities() {
		return assetLocationEntities;
	}

	public void setAssetLocationEntities(List<AssetLocationEntity> assetLocationEntities) {
		this.assetLocationEntities = assetLocationEntities;
	}
	
	
	
}
