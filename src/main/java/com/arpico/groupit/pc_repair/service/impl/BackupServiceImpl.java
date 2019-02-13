package com.arpico.groupit.pc_repair.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpico.groupit.pc_repair.dao.AssetDao;
import com.arpico.groupit.pc_repair.dao.BackupDao;
import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dao.RepairStatusDao;
import com.arpico.groupit.pc_repair.dto.BackupDto;
import com.arpico.groupit.pc_repair.dto.BackupGridDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
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
	
	@Autowired
	private RepairStatusDao repairStatusDao;

	@Override
	public List<BackupGridDto> getAll() throws Exception {
		List<BackupEntity> backupEntities = backupDao.findAllByEnabled(1);
		List<BackupGridDto> dtos = new ArrayList<>();
		backupEntities.forEach(e -> {
			try {
				dtos.add(getBackupGridDto(e));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		return dtos;

	}

	/*
	 * private BackupGridDto getBackupGridDto(BackupEntity e) {
	 * 
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * BackupGridDto dto = new BackupGridDto();
	 * 
	 * dto.setAssetId(e.getAssetEntity().getAssetCode());
	 * dto.setHandoverTo(e.getHandOverTo()); dto.setRemark(e.getRemark());
	 * dto.setRepairId(e.getRepairEntity().getJobNo());
	 * dto.setReturnDate(simpleDateFormat.format(e.getReturnDate()));
	 * dto.setSendDate(simpleDateFormat.format(e.getSendDate()));
	 * dto.setSendLoc(e.getSendLocation()); dto.setBackupId(e.getBackupId());
	 * 
	 * return dto; }
	 */

	@Override
	public String save(BackupDto backupDto) throws Exception {
		
		RepairDto repairDto = new RepairDto();
		AssetEntity assetEntity = assetDao.findOne(backupDto.getAssetId());
		RepairEntity repairEntity = repairDao.findOne(backupDto.getRepairId());
		
		BackupEntity backupEntity = getBackupEntity(backupDto, assetEntity, repairEntity);
		
		if(backupDao.save(backupEntity) != null){
			
		}
		
		return null;
	}

	@Override
	public boolean delete(String backupId) throws Exception {

		backupDao.delete(backupId);

		return true;
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

	@Override
	public BackupGridDto getBackupGridDto(BackupEntity e) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  
		  BackupGridDto dto = new BackupGridDto();
		  
		  try {
			  dto.setAssetId(e.getAssetEntity().getAssetCode());
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
		  
		/* dto.setAssetId(e.getAssetEntity().getAssetCode()); */
		  dto.setHandoverTo(e.getHandOverTo());
		  dto.setRemark(e.getRemark());
		  try {
			  dto.setRepairId(e.getRepairEntity().getJobNo());
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
		  
		  dto.setReturnDate(simpleDateFormat.format(e.getReturnDate()));
		  dto.setSendDate(simpleDateFormat.format(e.getSendDate()));
		  dto.setSendLoc(e.getSendLocation()); dto.setBackupId(e.getBackupId());
		  
		  
		  return dto;
		 
		
	}

	@Override
	public String editBackup(BackupDto backupDto) throws Exception {
		
		RepairDto repairDto = new RepairDto();
		AssetEntity assetEntity = assetDao.findOne(backupDto.getAssetId());
		RepairEntity repairEntity = repairDao.findOne(backupDto.getRepairId());
		
		BackupEntity backupEntity = getBackupEntity(backupDto, assetEntity, repairEntity);
		
		if(backupDao.save(backupEntity) != null){
			
		}
		
		return "Edit";
	}

	@Override
	public BackupDto get(String id) throws Exception {
		
		BackupEntity backupEntity = backupDao.findOne(id);
		
		return getBackupDto(backupEntity);
	}

	private BackupDto getBackupDto(BackupEntity e) {
		
		BackupDto backupDto = new BackupDto();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		backupDto.setRepairId(e.getRepairEntity().getRepairId());
		backupDto.setAssetId(e.getAssetEntity().getAssetCode());
		
		backupDto.setRemark(e.getRemark());
		backupDto.setSendDate(dateFormat.format(e.getSendDate()));
		backupDto.setReturnDate(dateFormat.format(e.getReturnDate()));
		backupDto.setHandOver(e.getHandOverTo());
		
		return backupDto;
		
	}

	@Override
	public String received(String id, String status) throws Exception {
		
		
		BackupEntity backupEntity = backupDao.findOne(id);
		backupEntity.setStatus("RECIVE");
		
		System.out.println("Backup Entity ==/"+backupEntity.getStatus());
		
		return "RECIVE";
	}

	@Override
	public List<BackupDto> getRecivedBackup() throws Exception {
		
		List<String>param = new ArrayList<>();
		param.add("RECIVE");
		
		List<BackupEntity>backupEntities = backupDao.findByStatusIn(param);
		List<BackupDto> backupDtos = new ArrayList<>();
		
		backupEntities.forEach(e->{
			backupDtos.add(getBackupDto(e));
		});
		return backupDtos;
	}


}
