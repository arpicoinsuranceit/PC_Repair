package com.arpico.groupit.pc_repair.service;

import java.util.List;
import java.util.Map;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.dto.RepairBasicsDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.entity.RepairEntity;

public interface RepairService {
	
	RepairDto getRepair (String repairId) throws Exception;

	List<RepairSentDto> getSendRepairs() throws Exception;
	
	List<AssetDto> getAllRepaired() throws Exception;
	
	RepairDto getRep(RepairEntity e);

	List<RepairReturnDto> getReturnRepairs() throws Exception;

	List<RepairReturnDto>getToBeRepairs()throws Exception;
	
	List<RepairDto>getAll()throws Exception;
	
	RepairDto get(String repairId)throws Exception;
	
	String addBasicDetails(RepairBasicsDto repairBasicsDto, String repairId) throws Exception;

	List<RepairDto> getRepairForDashboard() throws Exception;
	
	List<RepairDto>getAllDash()throws Exception;

	Map<String, Integer> getHomeValues() throws Exception;

	String addCartDetails(List<String> repairParts, String repairId) throws Exception;

	List<RepairSentDto> getOngoingRepairs() throws Exception;

	List<RepairSentDto> getAllRepairs() throws Exception;

	List<RepairDto> getRepair() throws Exception;

}
