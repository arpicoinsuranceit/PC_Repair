package com.arpico.groupit.pc_repair.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.StatusDao;
import com.arpico.groupit.pc_repair.dto.StatusDto;
import com.arpico.groupit.pc_repair.entity.StatusEntity;
import com.arpico.groupit.pc_repair.service.StatusService;

@Service
@Transactional
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusDao statusDao;
	
	@Override
	public List<StatusDto> getAll() throws Exception {
		List<StatusEntity> entities = (List<StatusEntity>) statusDao.findAll();
		
		List<StatusDto> dtos =new ArrayList<>();
			
			entities.forEach(e -> {
				dtos.add(getStatusDto(e));
			});
			
		
		return dtos;
	}

	@Override
	public StatusDto getStatusDto(StatusEntity e) {
		
		
		StatusDto dto = new StatusDto();
		
		dto.setCreateBy(e.getCreateBy());
		dto.setCreateDate(e.getCreateDate());
		dto.setDescription(e.getDescription());
		dto.setModifyBy(e.getModifyBy());
		dto.setModifyDate(e.getModifyDate());
		dto.setStatusId(e.getStatusId());
		
		return dto;
	}

}
