package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.RepairDto;

public interface WarrantyClameService {
	
	List<RepairDto> getWrrantyClames() throws Exception;
	
}
