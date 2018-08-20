package com.arpico.groupit.pc_repair.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.LocationDto;
import com.arpico.groupit.pc_repair.dto.PartsDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.AssetLocationEntity;
import com.arpico.groupit.pc_repair.entity.AssetOsEntity;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.AssigneeService;
import com.arpico.groupit.pc_repair.service.ErrorService;
import com.arpico.groupit.pc_repair.service.PartsService;
import com.arpico.groupit.pc_repair.service.RepairService;
import com.arpico.groupit.pc_repair.service.StatusService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;

	@Autowired
	private StatusService statusService;

	@Autowired
	private AssetService assetService;

	@Autowired
	private AssigneeService assigneeService;

	@Autowired
	private ErrorService errorService;

	@Autowired
	private PartsService partsService;

	@Override
	public List<RepairSentDto> getSendRepairs() throws Exception {
		List<String> param = new ArrayList<>();
		param.add(AppConstant.SEND);
		param.add(AppConstant.SEND_REC);
		List<RepairEntity> repairEntities = repairDao.findByStatusIn(param);

		System.out.println("repairEntities : " + repairEntities.size());

		List<RepairSentDto> repairSentDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairSentDtos.add(getRepairSendDto(e));
		});

		System.out.println("repairSentDtos : " + repairSentDtos.size());

		return repairSentDtos;
	}

	private RepairSentDto getRepairSendDto(RepairEntity e) {
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
	public List<RepairReturnDto> getReturnRepairs() throws Exception {
		List<String> param = new ArrayList<>();
		param.add(AppConstant.RETURN);
		param.add(AppConstant.RETURN_REC);
		List<RepairEntity> repairEntities = repairDao.findByStatusIn(param);
		List<RepairReturnDto> repairReturnDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairReturnDtos.add(getRepairReturnDto(e));
		});

		return repairReturnDtos;
	}

	private RepairReturnDto getRepairReturnDto(RepairEntity e) {
		RepairReturnDto repairReturnDto = new RepairReturnDto();
		repairReturnDto.setRepairId(e.getRepairId());
		repairReturnDto.setStatus(e.getStatus());
		repairReturnDto.setAssetId(e.getAssetEntity().getAssetCode());
		repairReturnDto.setSendingMethod(e.getRepairSendEntity().getSendingMethod());
		repairReturnDto.setSendDate(new SimpleDateFormat("yyyy-MM-dd").format(e.getRepairSendEntity().getSendDate()));
		try{
			repairReturnDto.setCourierId(e.getRepairReturnEntity().getCourierId());
			repairReturnDto.setFromLocation(e.getRepairReturnEntity().getFromLocation());
			repairReturnDto.setHandOverTo(e.getRepairReturnEntity().getHandOverTo());
			repairReturnDto.setRepairReturnId(e.getRepairReturnEntity().getRepairReturnId());
		}catch (Exception ex) {
			// TODO: handle exception
		}
		
		return repairReturnDto;
	}

	@Override
	public RepairDto getRepair(String repairId) throws Exception {
		RepairEntity repairEntity = repairDao.findOne(repairId);

		RepairDto repairDto = getRepairDto(repairEntity);

		return repairDto;
	}

	private RepairDto getRepairDto(RepairEntity repairEntity) throws Exception {

		LocationDto locationDto = new LocationDto();
		repairEntity.getAssetEntity().getAssetLocationEntities().forEach(e -> {
			if (e.getEnabled().equals(AppConstant.ENABLE)) {
				locationDto.setLocationId(e.getLocationEntity().getLocationId());
				locationDto.setLocationName(e.getLocationEntity().getLocationName());
			}
		});

		List<ErrorDto> errorDtos = new ArrayList<>();
		repairEntity.getRepairErrorDetailEntities().forEach(e -> {
			if (e.getEnabled().equals(1)) {
				errorDtos.add(errorService.getErrorDto(e.getErrorEntity()));
			}
		});

		List<PartsDto> partsDtos = new ArrayList<>();

		repairEntity.getRepairPartsEntities().forEach(e -> {
			if (e.getEnebled().equals(AppConstant.ENABLE)) {
				partsDtos.add(partsService.getPartsDto(e.getPartsEntity(), 0));
			}
		});

		RepairDto dto = new RepairDto();

		dto.setJobNo(repairEntity.getJobNo());
		dto.setPriority(repairEntity.getPriority());
		dto.setReason(repairEntity.getRepairSendEntity().getReason());
		dto.setRepairId(repairEntity.getRepairId());
		dto.setAssetDto(assetService.getAssetDto(repairEntity.getAssetEntity(), 0, 0, 0));
		dto.setErrorDtos(errorDtos);
		dto.setPartsDtos(partsDtos);
		dto.setLocationDto(locationDto);
		repairEntity.getRepairStatusEntities().forEach(e -> {
			if (e.getEnabled().equals(AppConstant.ENABLE)) {
				try {
					dto.setStatusDto(statusService.getStatusDto(e.getStatusEntity()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		repairEntity.getAssigneeRepairEntities().forEach(e -> {
			if (e.getEnabled().equals(AppConstant.ENABLE)) {
				dto.setAssigneeDto(assigneeService.getAssigneeDto(e.getAssigneeEntity()));
			}
		});

		return dto;
	}

}
