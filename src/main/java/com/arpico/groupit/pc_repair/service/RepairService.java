package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;

public interface RepairService {

	List<RepairSentDto> getSendRepairs() throws Exception;
	
	List<AssetDto> getAllRepaired() throws Exception;

	List<RepairSentDto> getReturnRepairs() throws Exception;

}
