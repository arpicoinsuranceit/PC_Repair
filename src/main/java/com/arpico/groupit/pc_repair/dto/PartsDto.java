package com.arpico.groupit.pc_repair.dto;

public class PartsDto {

	private String partId;
	private String partName;
	private String warrentyPeriod;
	private String warrentyExp;
	private String purchaseDate;
	private String serialId;
	private String remark;
	private Double value;
	private String supplier;

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

	public String getWarrentyExp() {
		return warrentyExp;
	}

	public void setWarrentyExp(String warrentyExp) {
		this.warrentyExp = warrentyExp;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

}
