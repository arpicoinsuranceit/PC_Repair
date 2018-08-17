package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.StatusDto;
import com.arpico.groupit.pc_repair.entity.StatusEntity;

public interface StatusService {
	
	List<StatusDto> getAll () throws Exception;
	
	StatusDto getStatusDto(StatusEntity e) throws Exception;

}
