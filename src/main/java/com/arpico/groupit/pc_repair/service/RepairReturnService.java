package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.entity.RepairReturnEntity;

public interface RepairReturnService {
	List<RepairReturnDto> getAll() throws Exception;

    String save(RepairReturnDto repairReturnDto) throws Exception;

    String delete(String repairReturnId) throws Exception;

    RepairReturnDto get(String id) throws Exception;

	String received(String id) throws Exception;
	
	RepairReturnEntity getRepairReturnEntity(RepairReturnDto dto);
}
