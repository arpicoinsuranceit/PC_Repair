package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.ErrorDto;

public interface ErrorService {

	List<ErrorDto> getAll() throws Exception;

    String save(ErrorDto errorDto) throws Exception;

    String delete(String errorId) throws Exception;

    ErrorDto get(String errorId) throws Exception;
    
}
