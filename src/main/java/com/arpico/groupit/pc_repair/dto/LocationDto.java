package com.arpico.groupit.pc_repair.dto;

public class LocationDto {

	private String locationId;
	private String locationName;

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

	@Override
	public String toString() {
		return "LocationDto [locationId=" + locationId + ", locationName=" + locationName + "]";
	}

}
