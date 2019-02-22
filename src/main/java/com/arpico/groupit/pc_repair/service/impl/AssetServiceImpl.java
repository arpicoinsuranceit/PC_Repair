package com.arpico.groupit.pc_repair.service.impl;

import com.arpico.groupit.pc_repair.dao.AssetDao;
import com.arpico.groupit.pc_repair.dao.AssetLocationDao;
import com.arpico.groupit.pc_repair.dao.AssetOsDao;
import com.arpico.groupit.pc_repair.dao.LocationDao;
import com.arpico.groupit.pc_repair.dao.OperatingSystemDao;
import com.arpico.groupit.pc_repair.dao.SupplierDao;
import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.AssetLocationEntity;
import com.arpico.groupit.pc_repair.entity.AssetOsEntity;
import com.arpico.groupit.pc_repair.entity.LocationEntity;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.util.AppConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetDao assetDao;

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private OperatingSystemDao operatingSystemDao;

	@Autowired
	private AssetOsDao assetOsDao;

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private AssetLocationDao assetLocationDao;

	@Override
	public List<AssetDto> getAll() throws Exception {

		List<AssetEntity> assetEntities = (List<AssetEntity>) assetDao.findAll();
		

		List<AssetDto> assetDtos = new ArrayList<>();

		assetEntities.forEach(e -> {
			assetDtos.add(getAssetDto(e, 0, 0, 0));
		});

		return assetDtos;
	}

	@Override
	public String save(AssetDto assetDto) throws Exception {
		AssetEntity assetEntity = getAssetEntity(assetDto);
		AssetOsEntity assetOsEntity = getAssetOsEntity(assetEntity, assetDto);
		AssetLocationEntity assetLocationEntity = getLocationEntity(assetEntity, assetDto);

		assetLocationDao.setDisablePrevious(AppConstant.DISABLE, assetEntity);
		assetOsDao.setDisablePrevious(AppConstant.DISABLE, assetEntity);
		if (assetDao.save(assetEntity) != null) {
			if (assetOsEntity != null) {
				assetOsDao.save(assetOsEntity);
			}
			if (assetLocationEntity != null) {
				assetLocationDao.save(assetLocationEntity);
			}
			return "201";
		}
		return "204";
	}

	@Override
	public String delete(String assetId) throws Exception {
		assetDao.delete(assetId);
		return "201";
	}

	@Override
	public AssetDto get(String assetId) throws Exception {
		AssetEntity assetEntity = assetDao.findOne(assetId);
		return getAssetDto(assetEntity, 1, 1, 1);
	}

	@Override
	public AssetDto getAssetDto(AssetEntity e, Integer supplier, Integer location, Integer os) {

		AssetDto assetDto = new AssetDto();

		assetDto.setAssetId(e.getAssetCode());
		assetDto.setDescription(e.getAssetDescription());
		assetDto.setIpAddress(e.getIpAddress());
		if (e.getAssetLocationEntities() != null) {
			for (AssetLocationEntity loc : e.getAssetLocationEntities()) {
				if (loc.getEnabled() == 1) {
					if (location == 0) {
						assetDto.setLocation(loc.getLocationEntity().getLocationName());
					} else {
						assetDto.setLocation(loc.getLocationEntity().getLocationId());
					}
				}
			}

		}

		if (e.getAssetOsEntities() != null) {
			for (AssetOsEntity osEntitie : e.getAssetOsEntities()) {
				if (osEntitie.getEnabled() == 1) {
					if (os == 0) {
						assetDto.setOs(osEntitie.getOperatingSystemEntity().getName());
					} else {
						assetDto.setOs(osEntitie.getOperatingSystemEntity().getOsId());
					}
				}
			}
		}

		assetDto.setPurchaseDate(new SimpleDateFormat("yyyy-MM-dd").format(e.getPurchasdate()));
		if (e.getWarrantyExp() != null) {
			assetDto.setWarrantyExp(new SimpleDateFormat("yyyy-MM-dd").format(e.getWarrantyExp()));
		}
		assetDto.setRemark(e.getRemark());
		assetDto.setSerialNo(e.getSerialNo());
		if (supplier == 0) {
			assetDto.setSupplier(e.getSupplierEntity().getSuplierName());
		} else {
			assetDto.setSupplier(e.getSupplierEntity().getSuplierId());
		}

		e.getRepairEntities().forEach(repeair->{
			assetDto.setRepairId(repeair.getRepairId());
		});
		assetDto.setValue(e.getAssetValue());
		assetDto.setWarranty(e.getWarrantyPeriod());

		return assetDto;

	}

	private AssetEntity getAssetEntity(AssetDto assetDto) throws ParseException {
		AssetEntity assetEntity = new AssetEntity();

		assetEntity.setAssetCode(assetDto.getAssetId());
		assetEntity.setAssetDescription(assetDto.getDescription());
		assetEntity.setAssetValue(assetDto.getValue());
		assetEntity.setCerateDate(new Date());
		assetEntity.setIpAddress(assetDto.getIpAddress());
		assetEntity.setModifydate(new Date());
		assetEntity.setPurchasdate(new SimpleDateFormat("yyyy-MM-dd").parse(assetDto.getPurchaseDate()));
		assetEntity.setRemark(assetDto.getRemark());
		assetEntity.setSerialNo(assetDto.getSerialNo());
		assetEntity.setWarrantyPeriod(assetDto.getWarranty());
		assetEntity.setWarrantyExp(new SimpleDateFormat("yyyy-MM-dd").parse(assetDto.getWarrantyExp()));
		assetEntity.setSupplierEntity(supplierDao.findOne(assetDto.getSupplier()));
		return assetEntity;
	}

	private AssetLocationEntity getLocationEntity(AssetEntity assetEntity, AssetDto assetDto) {
		AssetLocationEntity assetLocationEntity = new AssetLocationEntity();
		assetLocationEntity.setAssetEntity(assetEntity);
		assetLocationEntity.setAssetLoationId(UUID.randomUUID().toString());
		assetLocationEntity.setEnabled(AppConstant.ENABLE);
		assetLocationEntity.setLocationEntity(locationDao.findOne(assetDto.getLocation()));

		return assetLocationEntity;
	}

	private AssetOsEntity getAssetOsEntity(AssetEntity assetEntity, AssetDto assetDto) {
		AssetOsEntity assetOsEntity = new AssetOsEntity();
		assetOsEntity.setAssetEntity(assetEntity);
		assetOsEntity.setAssetOsId(UUID.randomUUID().toString());
		assetOsEntity.setOperatingSystemEntity(operatingSystemDao.findOne(assetDto.getOs()));
		assetOsEntity.setEnabled(AppConstant.ENABLE);
		return assetOsEntity;
	}

	@Override
	public List<AssetDto> getAllBackups() throws Exception {

		LocationEntity locationEntity = locationDao.findOne("HO");

		List<AssetLocationEntity> assetLocationEntities = assetLocationDao
				.findAllByLocationEntityAndEnabled(locationEntity, 1);

		List<AssetDto> assetDtos = new ArrayList<>();

		assetLocationEntities.forEach(e -> {
				assetDtos.add(getAssetDto(e.getAssetEntity(), 0, 0, 0));
		});
		
		
		return assetDtos;
	}

	@Override
	public List<AssetDto> getAssestBackup() throws Exception {
		
		List<AssetEntity> assetEntities = (List<AssetEntity>) assetDao.findAll();
		
		List<AssetDto> assestDtos = new ArrayList<>();
		
		assetEntities.forEach(e->{
			assestDtos.add(getAssestDto(e));
		});
		return assestDtos;
	}
	
	private AssetDto getAssestDto(AssetEntity e) {
		
			AssetDto assetDto = new AssetDto();
			
			assetDto.setAssetId(e.getAssetCode());
			
		
		return assetDto;
	}

}
