package com.arpico.groupit.pc_repair.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.OperatingSystemDao;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.entity.OperatingSystemEntity;
import com.arpico.groupit.pc_repair.service.OperatingSystemService;

@Service
@Transactional
public class OperatingSystemServiceImpl implements OperatingSystemService{

	@Autowired
	private OperatingSystemDao operatingSystemDao;
	
	@Override
	public List<NameValueDto> getAllNameValue() throws Exception {
		List<OperatingSystemEntity> entities = (List<OperatingSystemEntity>) operatingSystemDao.findAll();
		
		List<NameValueDto> nameValueDtos = new ArrayList<>();
		
		entities.forEach(e -> {
			nameValueDtos.add(getNameVAlueDto(e));
		});
		
		return nameValueDtos;
	}

	private NameValueDto getNameVAlueDto(OperatingSystemEntity e) {
		NameValueDto dto = new NameValueDto();
		dto.setName(e.getName());
		dto.setValue(e.getOsId());
		return dto;
	
	}

}
