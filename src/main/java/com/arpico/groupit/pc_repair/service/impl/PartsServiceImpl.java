package com.arpico.groupit.pc_repair.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.PartsDao;
import com.arpico.groupit.pc_repair.dao.SupplierDao;
import com.arpico.groupit.pc_repair.dto.PartsDto;
import com.arpico.groupit.pc_repair.entity.PartsEntity;
import com.arpico.groupit.pc_repair.service.PartsService;

@Service
@Transactional
public class PartsServiceImpl implements PartsService {

	@Autowired
	private PartsDao partsDao;

	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public List<PartsDto> getAll() throws Exception {
		List<PartsEntity> partsEntities = (List<PartsEntity>) partsDao.findAll();

		List<PartsDto> partsDtos = new ArrayList<>();

		partsEntities.forEach(e -> {
			partsDtos.add(getPartsDto(e, 0));
		});

		return partsDtos;
	}

	private PartsDto getPartsDto(PartsEntity e, Integer supplier) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		PartsDto dto = new PartsDto();
		dto.setPartId(e.getPartId());
		dto.setPartName(e.getPartName());
		dto.setPurchaseDate(e.getPartName());
		dto.setPurchaseDate(dateFormat.format(e.getPurchaseDate()));
		dto.setRemark(e.getRemark());
		dto.setSerialId(e.getSerialId());
		dto.setValue(e.getPartValue());
		dto.setWarrentyExp(dateFormat.format(e.getWarrantyExp()));
		dto.setWarrentyPeriod(e.getWarrentyPeriod());
		if (supplier == 0) {
			dto.setSupplier(e.getSupplierEntity().getSuplierName());
		} else {
			dto.setSupplier(e.getSupplierEntity().getSuplierId());
		}
		return dto;
	}

	@Override
	public String save(PartsDto partsDto) throws Exception {
		PartsEntity partsEntity = getPartsEntity(partsDto);
		
		if(partsDao.save(partsEntity)!= null) {
			return "201";
		}
		
		return "204";
	}

	private PartsEntity getPartsEntity(PartsDto partsDto) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		PartsEntity partsEntity = new PartsEntity();
		partsEntity.setCreateDate(new Date());
		partsEntity.setModifyDate(new Date());
		partsEntity.setPartId(partsDto.getPartId());
		partsEntity.setPartName(partsDto.getPartName());
		partsEntity.setPartValue(partsDto.getValue());
		partsEntity.setPurchaseDate(dateFormat.parse(partsDto.getPurchaseDate()));
		partsEntity.setRemark(partsDto.getRemark());
		partsEntity.setSerialId(partsDto.getSerialId());
		partsEntity.setSupplierEntity(supplierDao.findOne(partsDto.getSupplier()));
		partsEntity.setWarrantyExp(dateFormat.parse(partsDto.getWarrentyExp()));
		partsEntity.setWarrentyPeriod(partsDto.getWarrentyPeriod());
		return partsEntity;
	}

	@Override
	public String delete(String partId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartsDto get(String partId) throws Exception {
		PartsEntity entity = partsDao.findOne(partId);
		
		return getPartsDto(entity, 1);
	}

}
