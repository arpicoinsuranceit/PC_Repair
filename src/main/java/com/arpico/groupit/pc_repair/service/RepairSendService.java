package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.RepairSentDto;


public interface RepairSendService {

	List<RepairSentDto> getAll() throws Exception;

    String save(RepairSentDto repairSentDto) throws Exception;

    String delete(String repairSendId) throws Exception;

    RepairSentDto get(String repairSendId) throws Exception;

	String received(String id, String status) throws Exception;
	
}
