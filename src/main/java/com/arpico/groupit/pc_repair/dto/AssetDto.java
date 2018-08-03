package com.arpico.groupit.pc_repair.dto;

public class AssetDto {

    private String assetId;
    private String description;
    private Double value;
    private String ipAddress;
    private String location;
    private String os;
    private String purchaseDate;
    private String remark;
    private String serialNo;
    private String warranty;
    private String warrantyExp;
    private String supplier;


    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getWarrantyExp() {
		return warrantyExp;
	}

	public void setWarrantyExp(String warrantyExp) {
		this.warrantyExp = warrantyExp;
	}

	public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "AssetDto{" +
                "assetId='" + assetId + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", ipAddress='" + ipAddress + '\'' +
                ", location='" + location + '\'' +
                ", os='" + os + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", remark='" + remark + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", warranty='" + warranty + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }


}
