package com.arpico.groupit.pc_repair.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dao.RepairReturnsDao;
import com.arpico.groupit.pc_repair.dao.RepairStatusDao;
import com.arpico.groupit.pc_repair.dao.StatusDao;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairReturnEntity;
import com.arpico.groupit.pc_repair.entity.RepairStatusEntity;
import com.arpico.groupit.pc_repair.service.RepairReturnService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Service
@Transactional
public class RepairReturnServiceImpl implements RepairReturnService{

	@Autowired
	private RepairReturnsDao repairReturnsDao;
	
	@Autowired
	private RepairDao repairDao;
	
	@Autowired
	private RepairStatusDao repairStatusDao;
	
	@Autowired
	private StatusDao statusDao;
	
	
	@Override
	public List<RepairReturnDto> getAll() throws Exception {
		
		  /*List<RepairReturnEntity>repairReturnEntities = (List<RepairReturnEntity>) repairReturnsDao.findAll();

		ArrayList<RepairReturnDto>alReturnRepair = new ArrayList<>();

		for (RepairReturnEntity repairReturnEntity:repairReturnEntities) {

			repairReturnEntity.getRepairReturnId();
			repairReturnEntity.get
		}
		  */
		 
		return null;
	}

	@Override
	public String save(RepairReturnDto repairReturnDto) throws Exception {
		
		RepairEntity repairEntity = repairDao.findOne(repairReturnDto.getRepairId());
		
		System.out.println("Return Repaire" + repairReturnDto.getRepairId().toString());
		
		RepairReturnEntity repairReturnEntity = getRepairReturnEntity(repairReturnDto);
		
		RepairStatusEntity statusEntity = getRepairStatusEntity(repairEntity, AppConstant.SEND);
		/*
		 * RepairEntity repairEntity = repairDao.findOne(repairReturnDto.getRepairId());
		 * RepairReturnEntity repairReturnEntity =
		 * getRepairReturnEntity(repairReturnDto); RepairStatusEntity statusEntity =
		 * getRepairStatusEntity(repairEntity, AppConstant.SEND);
		 * 
		 * 
		 * repairEntity.setRepairReturnEntity(repairReturnEntity);
		 * 
		 * List<RepairStatusEntity> repairStatusEntities =
		 * repairEntity.getRepairStatusEntities(); for (RepairStatusEntity
		 * repairStatusEntity : repairStatusEntities) {
		 * repairStatusEntity.setEnabled(AppConstant.DISABLE);
		 * repairStatusEntity.setModifyDate(new Date()); System.out.println("for Loop");
		 * }
		 */
		
		/*
		 * System.out.println("Return Repaire");
		 * 
		 * repairEntity.setRepairReturnEntity(repairReturnEntity);
		 * 
		 * if (repairReturnsDao.save(repairReturnEntity) != null &&
		 * repairDao.save(repairEntity) != null && repairStatusDao.save(statusEntity) !=
		 * null && repairStatusDao.save(repairStatusEntities) != null) {
		 * 
		 * return "201"; }
		 * 
		 * System.out.println("repaire" + repairReturnEntity);
		 * 
		 */
		/* System.out.println("Print"); */
		repairReturnsDao.save(repairReturnEntity);
			
		
		
		/*
		 * RepairEntity repairEntity = repairDao.findOne(repairReturnDto.getRepairId());
		 * RepairReturnEntity repairReturnEntity =
		 * getRepairReturnEntity(repairReturnDto); RepairStatusEntity statusEntity =
		 * getRepairStatusEntity(repairEntity, AppConstant.SEND);
		 * 
		 * 
		 * repairEntity.setRepairReturnEntity(repairReturnEntity);
		 * 
		 * List<RepairStatusEntity> repairStatusEntities =
		 * repairEntity.getRepairStatusEntities(); for (RepairStatusEntity
		 * repairStatusEntity : repairStatusEntities) {
		 * repairStatusEntity.setEnabled(AppConstant.DISABLE);
		 * repairStatusEntity.setModifyDate(new Date()); System.out.println("for Loop");
		 * }
		 */
		
		/*
		 * System.out.println("Return Repaire");
		 * 
		 * repairEntity.setRepairReturnEntity(repairReturnEntity);
		 * 
		 * if (repairReturnsDao.save(repairReturnEntity) != null &&
		 * repairDao.save(repairEntity) != null && repairStatusDao.save(statusEntity) !=
		 * null && repairStatusDao.save(repairStatusEntities) != null) {
		 * 
		 * return "201"; }
		 * 
		 * System.out.println("repaire" + repairReturnEntity);
		 * 
		 */
		/* System.out.println("Print"); */
		return null;
	}

	private RepairStatusEntity getRepairStatusEntity(RepairEntity repairEntity, String status) {
		RepairStatusEntity repairStatusEntity = new RepairStatusEntity();
		repairStatusEntity.setCreateDate(new Date());
		repairStatusEntity.setEnabled(AppConstant.ENABLE);
		repairStatusEntity.setId(UUID.randomUUID().toString());
		repairStatusEntity.setRepairEntity(repairEntity);
		repairStatusEntity.setStatusEntity(statusDao.findOne(status));
		return repairStatusEntity;
	}

	
	 

	@Override
	public String delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RepairReturnDto get(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String received(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public RepairReturnEntity getRepairReturnEntity(RepairReturnDto dto) {
		RepairReturnEntity entity = new RepairReturnEntity();
		
		entity.setCourierId(dto.getCourierId());
		System.out.println("ttttttttttttttttttttttttttttttttttttttttt");
		entity.setFromLocation(dto.getFromLocation());
		entity.setHandOverTo(dto.getHandOverTo());
		entity.setRemark(dto.getRemark());
		entity.setRepairReturnId(UUID.randomUUID().toString());
		entity.setSendingMethod(dto.getSendingMethod());
		entity.setToLocation(dto.getToLocation());
		 entity.setSendDate(new Date());
		System.out.println("entity" + entity.toString());
		return entity;
	}

}
