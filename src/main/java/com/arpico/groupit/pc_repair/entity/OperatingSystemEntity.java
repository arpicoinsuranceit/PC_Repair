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
@Table(name = "OPERATING_SYSTEM")
public class OperatingSystemEntity {
	
	@Column(name = "OPERATING_SYSTEM_ID")
	private String osId;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "MODIFY_BY")
	private String modifyBy;

	private List<AssetOsEntity> assetOsEntities;
	
	@Id
	public String getOsId() {
		return osId;
	}

	public void setOsId(String osId) {
		this.osId = osId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	@OneToMany(mappedBy = "operatingSystemEntity", targetEntity = AssetOsEntity.class)
	@JsonIgnore
	public List<AssetOsEntity> getAssetOsEntities() {
		return assetOsEntities;
	}

	public void setAssetOsEntities(List<AssetOsEntity> assetOsEntities) {
		this.assetOsEntities = assetOsEntities;
	}
	
	

}
