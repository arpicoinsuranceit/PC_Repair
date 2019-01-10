package com.arpico.groupit.pc_repair.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpico.groupit.pc_repair.dao.AssetDao;
import com.arpico.groupit.pc_repair.dao.BackupDao;
import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dto.BackupDto;
import com.arpico.groupit.pc_repair.dto.BackupGridDto;
import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.BackupEntity;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.service.BackupService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Service
@Transactional
public class BackupServiceImpl implements BackupService {

	@Autowired
	private BackupDao backupDao;
	
	@Autowired
	private AssetDao assetDao;
	
	@Autowired
	private RepairDao repairDao;

	@Override
	public List<BackupGridDto> getAll() throws Exception {
		List<BackupEntity> backupEntities = backupDao.findAllByEnabled(1);
		List<BackupGridDto> dtos = new ArrayList<>();
		backupEntities.forEach(e -> {
			dtos.add(getBackupGridDto(e));
		});

		return dtos;

	}

	private BackupGridDto getBackupGridDto(BackupEntity e) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		BackupGridDto dto = new BackupGridDto();

		dto.setAssetId(e.getAssetEntity().getAssetCode());
		dto.setHandoverTo(e.getHandOverTo());
		dto.setRemark(e.getRemark());
		dto.setRepairId(e.getRepairEntity().getJobNo());
		dto.setReturnDate(simpleDateFormat.format(e.getReturnDate()));
		dto.setSendDate(simpleDateFormat.format(e.getSendDate()));
		dto.setSendLoc(e.getSendLocation());
		dto.setBackupId(e.getBackupId());

		return dto;
	}

	@Override
	public String save(BackupDto backupDto) throws Exception {
		AssetEntity assetEntity = assetDao.findOne(backupDto.getAssetId());
		RepairEntity repairEntity = repairDao.findOne(backupDto.getRepairId());
		
		BackupEntity backupEntity = getBackupEntity(backupDto, assetEntity, repairEntity);
		
		if(backupDao.save(backupEntity) != null){
			
		}
		
		return null;
	}

	private BackupEntity getBackupEntity(BackupDto backupDto, AssetEntity assetEntity, RepairEntity repairEntity) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BackupEntity entity = new BackupEntity();
		entity.setAssetEntity(assetEntity);
		entity.setBackupId(UUID.randomUUID().toString());
		entity.setEnabled(1);
		entity.setHandOverTo(backupDto.getHandOver());
		entity.setRemark(backupDto.getRemark());
		entity.setRepairEntity(repairEntity);
		entity.setReturnDate(sdf.parse(backupDto.getReturnDate()));
		entity.setSendDate(sdf.parse(backupDto.getSendDate()));
		entity.setSendLocation("");
		return entity;
	}



}
