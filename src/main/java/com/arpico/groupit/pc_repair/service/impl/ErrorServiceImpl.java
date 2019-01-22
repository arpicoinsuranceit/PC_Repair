package com.arpico.groupit.pc_repair.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.ErrorDao;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.entity.ErrorEntity;
import com.arpico.groupit.pc_repair.service.ErrorService;

@Service
@Transactional
public class ErrorServiceImpl implements ErrorService{
	
	@Autowired
	private ErrorDao errorDao;

	@Override
	public List<ErrorDto> getAll() throws Exception {
		List<ErrorEntity> errorEntities = (List<ErrorEntity>) errorDao.findAll();
		
		List<ErrorDto> errorDtos = new ArrayList<>();
		
		errorEntities.forEach(e -> {
			errorDtos.add(getErrorDto(e));
		});
		
		return errorDtos;
	}

	@Override
	public String save(ErrorDto errorDto) throws Exception {
		ErrorEntity entity = getErrorEntity(errorDto);
		
		if(errorDao.save(entity)!= null) {
			return "201";
		}
		
		return "204";
	}

	private ErrorEntity getErrorEntity(ErrorDto errorDto) {
		ErrorEntity entity = new ErrorEntity();
		entity.setErrorId(errorDto.getId());
		entity.setErrorName(errorDto.getName());
		entity.setErrorDiscription(errorDto.getDescription());
		entity.setModifyDate(new Date());
		entity.setCreateDate(new Date());
		return entity;
	}

	@Override
	public String delete(String errorId) throws Exception {
		errorDao.delete(errorId);
		return "Error Deleted";
	}

	@Override
	public ErrorDto get(String errorId) throws Exception {
		ErrorEntity entity = errorDao.findOne(errorId);
		
		return getErrorDto(entity);
	}
	
	@Override
	public ErrorDto getErrorDto(ErrorEntity e) {
		ErrorDto dto = new ErrorDto();
		dto.setId(e.getErrorId());
		dto.setName(e.getErrorName());
		dto.setDescription(e.getErrorDiscription());
		return dto;
	}

}
