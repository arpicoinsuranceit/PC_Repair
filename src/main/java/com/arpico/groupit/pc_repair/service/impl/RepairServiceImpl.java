package com.arpico.groupit.pc_repair.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.AssetLocationEntity;
import com.arpico.groupit.pc_repair.entity.AssetOsEntity;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.service.RepairService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Service
@Transactional
public class RepairServiceImpl implements RepairService{
	
	@Autowired
	private RepairDao repairDao;

	@Override
	public List<RepairSentDto> getSendRepairs() throws Exception {
		List<String> param = new ArrayList<>();
		param.add(AppConstant.SEND);
		param.add(AppConstant.SEND_REC);
		List<RepairEntity> repairEntities = repairDao.findByStatusIn(param);
		List<RepairSentDto> repairSentDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairSentDtos.add(getRepairEntity(e));
		});
		
		return repairSentDtos;
	}

	private RepairSentDto getRepairEntity(RepairEntity e) {
		RepairSentDto repairSentDto = new RepairSentDto();
		repairSentDto.setRepairId(e.getRepairId());
		repairSentDto.setStatus(e.getStatus());
		repairSentDto.setAssetId(e.getAssetEntity().getAssetCode());
		repairSentDto.setSendingMethod(e.getRepairSendEntity().getSendingMethod());
		repairSentDto.setSendDate(new SimpleDateFormat("yyyy-MM-dd").format(e.getRepairSendEntity().getSendDate()));
		repairSentDto.setCourierId(e.getRepairSendEntity().getCourierId());
		repairSentDto.setFromLocation(e.getRepairSendEntity().getFromLocation());
		repairSentDto.setReason(e.getRepairSendEntity().getReason());
		repairSentDto.setRepairSendId(e.getRepairSendEntity().getRepairSendId());
		return repairSentDto;
	}

	@Override
	public List<AssetDto> getAllRepaired() throws Exception {
		List<RepairEntity> repairEntities = repairDao.findByStatus(AppConstant.COMPLETE);
		List<AssetDto> assetDtos = new ArrayList<>();

		repairEntities.forEach(e -> {
			
			AssetDto assetDto = getAssetDto(e.getAssetEntity(), 0, 0, 0);
			assetDto.setRepairId(e.getRepairId());
			assetDtos.add(assetDto);
		});

		return assetDtos;
	}
	
	private AssetDto getAssetDto(AssetEntity e, Integer supplier, Integer location, Integer os) {

		AssetDto assetDto = new AssetDto();

		assetDto.setAssetId(e.getAssetCode());
		assetDto.setDescription(e.getAssetDescription());
		assetDto.setIpAddress(e.getIpAddress());
		if (e.getAssetLocationEntities() != null) {
			for (AssetLocationEntity loc : e.getAssetLocationEntities()) {
				if (loc.getEnabled() == 1) {
					if (location == 0) {
						assetDto.setLocation(loc.getLocationEntity().getLocationName());
					} else {
						assetDto.setLocation(loc.getLocationEntity().getLocationId());
					}
				}
			}

		}

		if (e.getAssetOsEntities() != null) {
			for (AssetOsEntity osEntitie : e.getAssetOsEntities()) {
				if (osEntitie.getEnabled() == 1) {
					if (os == 0) {
						assetDto.setOs(osEntitie.getOperatingSystemEntity().getName());
					} else {
						assetDto.setOs(osEntitie.getOperatingSystemEntity().getOsId());
					}
				}
			}
		}

		assetDto.setPurchaseDate(new SimpleDateFormat("yyyy-MM-dd").format(e.getPurchasdate()));
		if (e.getWarrantyExp() != null) {
			assetDto.setWarrantyExp(new SimpleDateFormat("yyyy-MM-dd").format(e.getWarrantyExp()));
		}
		assetDto.setRemark(e.getRemark());
		assetDto.setSerialNo(e.getSerialNo());
		if (supplier == 0) {
			assetDto.setSupplier(e.getSupplierEntity().getSuplierName());
		} else {
			assetDto.setSupplier(e.getSupplierEntity().getSuplierId());
		}

		assetDto.setValue(e.getAssetValue());
		assetDto.setWarranty(e.getWarrantyPeriod());

		return assetDto;

	}

	@Override
	public List<RepairSentDto> getReturnRepairs() throws Exception {
		List<String> param = new ArrayList<>();
		param.add(AppConstant.RETURN);
		param.add(AppConstant.RETURN_REC);
		List<RepairEntity> repairEntities = repairDao.findByStatusIn(param);
		List<RepairSentDto> repairSentDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairSentDtos.add(getRepairEntity(e));
		});
		
		return repairSentDtos;
	}


}
