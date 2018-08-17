package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;

public interface RepairService {
	
	RepairDto getRepair (String repairId) throws Exception;

	List<RepairSentDto> getSendRepairs() throws Exception;
	
	List<AssetDto> getAllRepaired() throws Exception;

	List<RepairReturnDto> getReturnRepairs() throws Exception;

}
