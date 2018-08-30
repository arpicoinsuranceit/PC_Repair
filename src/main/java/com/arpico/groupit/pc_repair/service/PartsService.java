package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.PartsDto;
import com.arpico.groupit.pc_repair.entity.PartsEntity;

public interface PartsService {
	List<PartsDto> getAll() throws Exception;

	String save(PartsDto partsDto) throws Exception;

	String delete(String partId) throws Exception;

	PartsDto get(String partId) throws Exception;

	PartsDto getPartsDto(PartsEntity e, Integer supplier) throws Exception;

	List<PartsDto> findBySerial(String value) throws Exception;
} 
