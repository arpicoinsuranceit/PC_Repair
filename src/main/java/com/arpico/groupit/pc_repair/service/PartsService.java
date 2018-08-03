package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.PartsDto;

public interface PartsService {
	List<PartsDto> getAll() throws Exception;

    String save(PartsDto partsDto) throws Exception;

    String delete(String partId) throws Exception;

    PartsDto get(String partId) throws Exception;
}
