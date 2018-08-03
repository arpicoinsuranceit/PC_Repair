package com.arpico.groupit.pc_repair.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.LocationDao;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.entity.LocationEntity;
import com.arpico.groupit.pc_repair.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;
	
	@Override
	public List<NameValueDto> getAllNameValue() throws Exception {
		List<LocationEntity> locationEntities = (List<LocationEntity>) locationDao.findAll();
		
		List<NameValueDto> nameValueDtos = new ArrayList<>();
		
		locationEntities.forEach(e -> {
			nameValueDtos.add(getNameValueDto(e));
		});
		
		return nameValueDtos;
	}

	private NameValueDto getNameValueDto(LocationEntity e) {
		NameValueDto nameValueDto = new NameValueDto();
		
		nameValueDto.setName(e.getLocationName());
		nameValueDto.setValue(e.getLocationId());
		
		return nameValueDto;
	}

}
