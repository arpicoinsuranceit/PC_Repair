package com.arpico.groupit.pc_repair.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.AssetDao;
import com.arpico.groupit.pc_repair.dao.AssigneeDao;
import com.arpico.groupit.pc_repair.dao.AssigneeRepairDao;
import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dao.RepairReturnsDao;
import com.arpico.groupit.pc_repair.dao.RepairSendDao;
import com.arpico.groupit.pc_repair.dao.RepairStatusDao;
import com.arpico.groupit.pc_repair.dao.StatusDao;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.entity.AssigneeEntity;
import com.arpico.groupit.pc_repair.entity.AssigneeRepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairReturnEntity;
import com.arpico.groupit.pc_repair.entity.RepairSendEntity;
import com.arpico.groupit.pc_repair.entity.RepairStatusEntity;
import com.arpico.groupit.pc_repair.service.RepairSendService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Service
@Transactional
public class RepairSendServiceImpl implements RepairSendService {

	@Autowired
	private RepairSendDao repairSendDao;

	@Autowired
	private RepairDao repairDao;

	@Autowired
	private AssetDao assetDao;

	@Autowired
	private AssigneeDao assigneeDao;

	@Autowired
	private AssigneeRepairDao assigneeRepairDao;

	@Autowired
	private StatusDao statusDao;

	@Autowired
	private RepairStatusDao repairStatusDao;

	@Autowired
	private RepairReturnsDao repairReturnsDao;

	@Override
	public List<RepairSentDto> getAll() throws Exception {
		//
		return null;
	}

	@Override
	public String save(RepairSentDto repairSentDto) throws Exception {
		RepairEntity repairEntity = getRepairEntity(repairSentDto);

		Integer lastJob = repairDao.findOneOrderByJobNo();

		if (lastJob != null) {
			repairEntity.setJobNo(lastJob + 1);
		}else {
			repairEntity.setJobNo(10000);
		}

		RepairSendEntity repairSendEntity = getRepairSendEntity(repairSentDto);
		RepairStatusEntity repairStatusEntity = getRepairStatusEntity(repairEntity, AppConstant.SEND);
		repairEntity.setRepairSendEntity(repairSendEntity);

		if (repairSendDao.save(repairSendEntity) != null && repairDao.save(repairEntity) != null
				&& repairStatusDao.save(repairStatusEntity) != null) {

			return "201";
		}

		return "204";
	}

	@Override
	public RepairStatusEntity getRepairStatusEntity(RepairEntity repairEntity, String status) {
		RepairStatusEntity repairStatusEntity = new RepairStatusEntity();
		repairStatusEntity.setCreateDate(new Date());
		repairStatusEntity.setEnabled(AppConstant.ENABLE);
		repairStatusEntity.setId(UUID.randomUUID().toString());
		repairStatusEntity.setRepairEntity(repairEntity);
		repairStatusEntity.setStatusEntity(statusDao.findOne(status));
		return repairStatusEntity;
	}

	private RepairEntity getRepairEntity(RepairSentDto repairSentDto) throws Exception {
		RepairEntity entity = new RepairEntity();

		entity.setAssetEntity(assetDao.findOne(repairSentDto.getAssetId()));
		entity.setRepairId(UUID.randomUUID().toString());
		entity.setStatus(AppConstant.SEND);

		if (entity.getAssetEntity() != null) {
			return entity;
		} else {
			throw new NullPointerException("Asset Not Found");
		}
	}

	@Override
	public String delete(String repairSendId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RepairSentDto get(String repairSendId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private RepairSendEntity getRepairSendEntity(RepairSentDto dto) {
		RepairSendEntity entity = new RepairSendEntity();

		entity.setCourierId(dto.getCourierId());
		entity.setFromLocation(dto.getFromLocation());
		entity.setReason(dto.getReason());
		entity.setRemark(dto.getRemark());
		entity.setRepairSendId(UUID.randomUUID().toString());
		entity.setSendingMethod(dto.getSendingMethod());
		entity.setToLocation(dto.getToLocation());
		entity.setSendDate(new Date());

		return entity;

	}

	@Override
	public String received(String id, String status) throws Exception {
		RepairEntity repairEntity = repairDao.findOne(id);
		repairStatusDao.setDisablePrevious(repairEntity);

		RepairSendEntity repairSendEntity = repairEntity.getRepairSendEntity();
		RepairReturnEntity repairReturnEntity = repairEntity.getRepairReturnEntity();
		RepairStatusEntity repairStatusEntity = null;
		if (status.equals(AppConstant.RETURN_REC)) {
			repairReturnEntity.setRecivedDate(new Date());
			repairReturnsDao.save(repairReturnEntity);
			repairStatusEntity = getRepairStatusEntity(repairEntity, AppConstant.RETURN_REC);
		} else if (status.equals(AppConstant.SEND_REC)) {
			repairSendEntity.setRecivedDate(new Date());
			repairStatusEntity = getRepairStatusEntity(repairEntity, AppConstant.SEND_REC);
			repairSendDao.save(repairSendEntity);
		}

		repairEntity.setStatus(status);

		if (repairDao.save(repairEntity) != null && repairStatusDao.save(repairStatusEntity) != null) {
			return "201";
		}

		return "204";
	}

	@Override
	public String addAssignee(String id, String repairId) throws Exception {

		System.out.println(id);

		AssigneeEntity assignee = assigneeDao.findOne(id);

		System.out.println(assignee.toString());

		RepairEntity repair = repairDao.findOne(repairId);

		AssigneeRepairEntity assigneeRepairEntity = getAssigneeRepairEntity(assignee, repair);

		if (assigneeRepairDao.save(assigneeRepairEntity) != null) {
			return "200";
		}

		return "204";
	}

	private AssigneeRepairEntity getAssigneeRepairEntity(AssigneeEntity assignee, RepairEntity repair) {
		AssigneeRepairEntity assigneeRepairEntity = new AssigneeRepairEntity();

		assigneeRepairEntity.setAssigneeEntity(assignee);
		assigneeRepairEntity.setAssigneeRepairId(UUID.randomUUID().toString());
		assigneeRepairEntity.setAssignStartTime(new Date());
		assigneeRepairEntity.setCreateDate(new Date());
		assigneeRepairEntity.setEnabled(AppConstant.ENABLE);
		assigneeRepairEntity.setRepairEntity(repair);

		return assigneeRepairEntity;
	}

}
