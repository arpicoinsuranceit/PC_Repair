package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.RepairReturnDto;

public interface RepairReturnService {
	List<RepairReturnDto> getAll() throws Exception;

    String save(RepairReturnDto repairReturnDto) throws Exception;

    String delete(String id) throws Exception;

    RepairReturnDto get(String id) throws Exception;

	String received(String id) throws Exception;
}
