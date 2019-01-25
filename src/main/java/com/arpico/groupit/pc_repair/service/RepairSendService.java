package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairStatusEntity;

public interface RepairSendService {

	List<RepairSentDto> getAll() throws Exception;

	String save(RepairSentDto repairSentDto) throws Exception;

	String delete(String repairSendId) throws Exception;

	RepairSentDto get(String repairSendId) throws Exception;

	String received(String id, String status) throws Exception;

	String addAssignee(String id, String repairId) throws Exception;

	public RepairStatusEntity getRepairStatusEntity(RepairEntity repairEntity, String status) throws Exception;

}
