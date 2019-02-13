package com.arpico.groupit.pc_repair.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpico.groupit.pc_repair.dao.WarrantyClameDao;
import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.service.WarrantyClameService;

@Service
public class warrantyClameServiceImpl implements WarrantyClameService{

	@Autowired
	private WarrantyClameDao warrantyDao;
	
	@Override
	public List<RepairDto> getWrrantyClames() throws Exception {
		
		List<String>param = new ArrayList<>();
		param.add("SNWA");
		List<RepairEntity>repairEntities = warrantyDao.findByStatusIn(param);
		
		List<RepairDto>repairDtos = new ArrayList<>();
		
		repairEntities.forEach(e->{
			repairDtos.add(getRepairDto(e));
		});
		return repairDtos;
	}

	private RepairDto getRepairDto(RepairEntity e) {
		RepairDto dto = new RepairDto();
		AssetDto assetDto = new AssetDto();
		
		dto.setRepairId(e.getRepairId());
		dto.setJobNo(e.getJobNo());
		dto.setPriority(e.getPriority());
		dto.setRemark(e.getRemark());
		dto.setAssetDto(assetDto);
		
		return dto;
	}
}
