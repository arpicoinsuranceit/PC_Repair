package com.arpico.groupit.pc_repair.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupit.pc_repair.dao.AssetDao;
import com.arpico.groupit.pc_repair.dao.ErrorDao;
import com.arpico.groupit.pc_repair.dao.PartsDao;
import com.arpico.groupit.pc_repair.dao.RepairDao;
import com.arpico.groupit.pc_repair.dao.RepairErrorDetailsDao;
import com.arpico.groupit.pc_repair.dao.RepairPartsDao;
import com.arpico.groupit.pc_repair.dao.RepairReturnsDao;
import com.arpico.groupit.pc_repair.dao.RepairSendDao;
import com.arpico.groupit.pc_repair.dao.RepairStatusDao;
import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.ErrorDto;
import com.arpico.groupit.pc_repair.dto.LocationDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.dto.PartsDto;
import com.arpico.groupit.pc_repair.dto.RepairBasicsDto;
import com.arpico.groupit.pc_repair.dto.RepairDto;
import com.arpico.groupit.pc_repair.dto.RepairReturnDto;
import com.arpico.groupit.pc_repair.dto.RepairSentDto;
import com.arpico.groupit.pc_repair.dto.StatusDto;
import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.AssetLocationEntity;
import com.arpico.groupit.pc_repair.entity.AssetOsEntity;
import com.arpico.groupit.pc_repair.entity.ErrorEntity;
import com.arpico.groupit.pc_repair.entity.PartsEntity;
import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairErrorDetailEntity;
import com.arpico.groupit.pc_repair.entity.RepairPartsEntity;
import com.arpico.groupit.pc_repair.entity.RepairReturnEntity;
import com.arpico.groupit.pc_repair.entity.RepairStatusEntity;
import com.arpico.groupit.pc_repair.entity.StatusEntity;
import com.arpico.groupit.pc_repair.service.AssetService;
import com.arpico.groupit.pc_repair.service.AssigneeService;
import com.arpico.groupit.pc_repair.service.ErrorService;
import com.arpico.groupit.pc_repair.service.PartsService;
import com.arpico.groupit.pc_repair.service.RepairReturnService;
import com.arpico.groupit.pc_repair.service.RepairSendService;
import com.arpico.groupit.pc_repair.service.RepairService;
import com.arpico.groupit.pc_repair.service.StatusService;
import com.arpico.groupit.pc_repair.util.AppConstant;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly=true)
public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;

	@Autowired
	private StatusService statusService;

	@Autowired
	private AssetService assetService;

	@Autowired
	private AssigneeService assigneeService;

	@Autowired
	private ErrorService errorService;

	@Autowired
	private PartsService partsService;

	@Autowired
	private RepairErrorDetailsDao repairErrorDetailsDao;

	@Autowired
	private ErrorDao errorDao;

	@Autowired
	private RepairStatusDao repairStatusDao;

	@Autowired
	private RepairSendService repairSendService;

	@Autowired
	private RepairPartsDao repairPartsDao;

	@Autowired
	private PartsDao partsDao;

	@Autowired
	private RepairSendDao repairSendDao;
	
	@Autowired
	private AssetDao assestDao;
	
	@Autowired
	private RepairReturnService repairReturnService;
	
	@Autowired
	private RepairReturnsDao repairReturnsDao;

	@Override
	public List<RepairSentDto> getSendRepairs() throws Exception {
		List<String> param = new ArrayList<>();
		param.add(AppConstant.SEND);
		param.add(AppConstant.SEND_REC);
		List<RepairEntity> repairEntities = repairDao.findByStatusIn(param);

		List<RepairSentDto> repairSentDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairSentDtos.add(getRepairSendDto(e));
		});

		return repairSentDtos;
	}

	private RepairSentDto getRepairSendDto(RepairEntity e) {
		RepairSentDto repairSentDto = new RepairSentDto();
		repairSentDto.setRepairId(e.getRepairId());
		repairSentDto.setStatus(e.getStatus());
		repairSentDto.setAssetId(e.getAssetEntity().getAssetCode());
		repairSentDto.setSendingMethod(e.getRepairSendEntity().getSendingMethod());
		repairSentDto.setSendDate(new SimpleDateFormat("yyyy-MM-dd").format(e.getRepairSendEntity().getSendDate()));
		repairSentDto.setCourierId(e.getRepairSendEntity().getCourierId());
		repairSentDto.setFromLocation(e.getRepairSendEntity().getFromLocation());
		repairSentDto.setReason(e.getRepairSendEntity().getReason());
		repairSentDto.setRepairSendId(e.getRepairSendEntity().getRepairSendId());
		return repairSentDto;
	}

	@Override
	public List<AssetDto> getAllRepaired() throws Exception {
		List<RepairEntity> repairEntities = repairDao.findByStatus(AppConstant.COMPLETE);
		List<AssetDto> assetDtos = new ArrayList<>();

		repairEntities.forEach(e -> {

			AssetDto assetDto = getAssetDto(e.getAssetEntity(), 0, 0, 0);
			assetDto.setRepairId(e.getRepairId());
			assetDtos.add(assetDto);
		});

		return assetDtos;
	}

	private AssetDto getAssetDto(AssetEntity e, Integer supplier, Integer location, Integer os) {

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

		assetDto.setValue(e.getAssetValue());
		assetDto.setWarranty(e.getWarrantyPeriod());

		return assetDto;

	}

	
	  @Override 
	  public List<RepairReturnDto> getReturnRepairs() throws Exception {
	  List<String> param = new ArrayList<>();
	  
	  param.add("RETURN_REPAIR");
	  
	  List<RepairReturnEntity>repairReturnEntities = repairReturnsDao.findByStatusIn(param);
	  
		List<RepairReturnDto> repairReturnDtos = new ArrayList<>();
		repairReturnEntities.forEach(e -> {
			repairReturnDtos.add(getRepairReturnDto(e));
		});

		return repairReturnDtos;
		
	  }

	  private  RepairReturnDto getRepairReturn(RepairReturnEntity e){

		RepairReturnDto repairReturnDto = new RepairReturnDto();
		repairReturnDto.setRepairReturnId(e.getRepairReturnId());
		repairReturnDto.setSendingMethod(e.getSendingMethod());
		repairReturnDto.setCourierId(e.getCourierId());
		repairReturnDto.setFromLocation(e.getFromLocation());
		repairReturnDto.setToLocation(e.getToLocation());
		repairReturnDto.setHandOverTo(e.getHandOverTo());
		repairReturnDto.setRemark(e.getRemark());




		return  repairReturnDto;
	  }

	private RepairReturnDto getRepairReturnDto(RepairReturnEntity e) {
		
		RepairEntity repairEntity =repairDao.findOne(e.getRepairEntity().getRepairId());
		
		RepairReturnDto repairReturnDto = new RepairReturnDto();
		
		repairReturnDto.setRepairReturnId(e.getRepairReturnId());
		
		repairReturnDto.setAssetId(repairEntity.getAssetEntity().getAssetCode());
		
		/*
		 * if (repairReturnDto.setRepairId(e.getRepairEntity().getRepairId()) ) {
		 * 
		 * }
		 */
		repairReturnDto.setCourierId(e.getCourierId());
		repairReturnDto.setHandOverTo(e.getHandOverTo());
		repairReturnDto.setRemark(e.getRemark());
		repairReturnDto.setSendingMethod(e.getSendingMethod());
		repairReturnDto.setFromLocation(e.getFromLocation());
		repairReturnDto.setToLocation(e.getToLocation());
		repairReturnDto.setStatus(e.getStatus());
		
		return repairReturnDto;
	}

	@Override
	public RepairDto getRepair(String repairId) throws Exception {
		
		
		RepairEntity repairEntity = repairDao.findOne(repairId);

		RepairDto repairDto = getRepairDto(repairEntity);

		return repairDto;
	}

	
	private RepairDto getRepairDto(RepairEntity repairEntity) throws Exception {

		
		LocationDto locationDto = new LocationDto();
		repairEntity.getAssetEntity().getAssetLocationEntities().forEach(e -> {
			if (e.getEnabled().equals(AppConstant.ENABLE)) {
				locationDto.setLocationId(e.getLocationEntity().getLocationId());
				locationDto.setLocationName(e.getLocationEntity().getLocationName());
			}
		});

		
		List<ErrorDto> errorDtos = new ArrayList<>();
		repairEntity.getRepairErrorDetailEntities().forEach(e -> {
			if (e.getEnabled().equals(1)) {
				errorDtos.add(errorService.getErrorDto(e.getErrorEntity()));
			}
		});

		
		List<PartsDto> partsDtos = new ArrayList<>();
		
		repairEntity.getRepairPartsEntities().forEach(e -> {
			if (e.getEnebled().equals(AppConstant.ENABLE)) {
				try {
					partsDtos.add(partsService.getPartsDto(e.getPartsEntity(), 0));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		RepairDto dto = new RepairDto();

		dto.setJobNo(repairEntity.getJobNo());
		dto.setPriority(repairEntity.getPriority());
		dto.setReason(repairEntity.getRepairSendEntity().getReason());
		dto.setRepairId(repairEntity.getRepairId());
		dto.setAssetDto(assetService.getAssetDto(repairEntity.getAssetEntity(), 0, 0, 0));
		dto.setErrorDtos(errorDtos);
		dto.setPartsDtos(partsDtos);
		dto.setLocationDto(locationDto);
		dto.setRemark(repairEntity.getRemark());
		
		

		
		  repairEntity.getRepairStatusEntities().forEach(e -> { if
		  (e.getEnabled().equals(AppConstant.ENABLE)) {
			  
		  try {
			dto.setStatusDto(statusService.getStatusDto(e.getStatusEntity()));
		} catch (Exception e1) {

		}
		 
		 
		  
		  } 
		  });
		 
		  
		 
		repairEntity.getAssigneeRepairEntities().forEach(e -> {
			
			if (e.getEnabled().equals(AppConstant.ENABLE)) {
				dto.setAssigneeDto(assigneeService.getAssigneeDto(e.getAssigneeEntity()));
			}
		});
		
		
		return dto;
		
	}

	@Override
	public String addBasicDetails(RepairBasicsDto repairBasicsDto, String repairId) throws Exception {

		RepairEntity repairEntity = repairDao.findOne(repairId);
		
		List<RepairErrorDetailEntity> getAllRepearError=(List<RepairErrorDetailEntity>) repairErrorDetailsDao.findAll();

		 repairEntity.setPriority(repairBasicsDto.getPriority());

		

		if (!(repairEntity.getStatus().equals(repairBasicsDto.getStatus()))) {
			
			repairEntity.setStatus(repairBasicsDto.getStatus());

		
			

			RepairStatusEntity repairStatusEntity = repairSendService.getRepairStatusEntity(repairEntity,
					repairBasicsDto.getStatus());

			

			repairStatusDao.save(repairStatusEntity);
		}

		if (repairBasicsDto.getError() != null && repairBasicsDto.getError().trim().length() > 0) {
			for (RepairErrorDetailEntity repairErrorDetailEntity : getAllRepearError) {
				if (repairErrorDetailEntity.getRepairEntity().getRepairId().equals(repairEntity.getRepairId()) && repairErrorDetailEntity.getEnabled().equals(0)) {
					repairErrorDetailsDao.changeEnabled(AppConstant.DISABLE, repairEntity);
				}
			}
			
			
			

			String arr[] = repairBasicsDto.getError().split(",");

			List<RepairErrorDetailEntity> detailEntities = new ArrayList<>();

			for (String errorId : arr) {
				ErrorEntity errorEntity = errorDao.findOne(errorId);
				RepairErrorDetailEntity detailEntity = getRepairErrorDetailsEntity(errorEntity, repairEntity);

				detailEntities.add(detailEntity);
			}

			repairErrorDetailsDao.save(detailEntities);

		}

		if (repairBasicsDto.getRemark() != null && repairBasicsDto.getRemark().trim().length() > 0) {
			repairEntity.setRemark(repairBasicsDto.getRemark());

			if (!repairEntity.getStatus().equals(repairBasicsDto.getStatus())) {
				repairEntity.setStatus(repairBasicsDto.getStatus());
			}

		}

		repairEntity = repairDao.save(repairEntity);

		return "200";
	}

	private RepairErrorDetailEntity getRepairErrorDetailsEntity(ErrorEntity errorEntity, RepairEntity repairEntity) {
		RepairErrorDetailEntity detailEntity = new RepairErrorDetailEntity();
		detailEntity.setCreateDate(new Date());
		detailEntity.setEnabled(AppConstant.ENABLE);
		detailEntity.setErrorEntity(errorEntity);
		detailEntity.setRepairEntity(repairEntity);
		detailEntity.setRepairErrorId(UUID.randomUUID().toString());

		return detailEntity;
	}

	@Override
	public List<RepairDto> getRepairForDashboard() throws Exception {
		
		  List<String> param = new ArrayList<>();
		  
		  param.add("RECB");
		  param.add("RECH");
		  param.add("REPA");
		  param.add("SNNW");
		  param.add("SNSP");
		  param.add("SNTB");
		  param.add("SNTH"); 
		  param.add("SNWA"); 
		  param.add("WAPA");

		
	    List<RepairEntity> entities = (List<RepairEntity>) repairDao.findByStatusNotInOrderByPriorityAscCerateDateAsc(param);
		 
	
		List<RepairDto> dtos = new ArrayList<>();
		
		entities.forEach(e -> {
			try {
				 
				dtos.add(getRepairDto(e));
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		return dtos;
	}

	@Override
	public Map<String, Integer> getHomeValues() throws Exception {
		Map<String, Integer> values = new HashMap<>();
		
		 Integer sntb =  repairDao.findCompletedH("SNTB");
		 Integer snth =  repairDao.findCompletedB("SNTH");
		 
		 Integer recb = repairDao.findOnInCommingh("RECH");
		 Integer rech = repairDao.findOnInCommingb("RECB");
		 
		 Integer snnw = repairDao.findOnGoingN("SNNW");
		 Integer snsp = repairDao.findOnGoingP("SNSP");
		 
		values.put("complete",sntb+snth);
		values.put("hold", repairDao.findHold("WAPA"));
		values.put("repair",repairDao.findOnRepair("REPA")); 
		values.put("incomming", recb+rech);
		values.put("ongoing", snnw+snsp);
		values.put("warranty",repairDao.findOnWarranty("SNWA"));

		return values;
	}

	@Override
	public String addCartDetails(List<String> repairParts, String repairId) throws Exception {

		RepairEntity repairEntity = repairDao.findOne(repairId);
		
		List<RepairPartsEntity> getAll=(List<RepairPartsEntity>) repairPartsDao.findAll();
		
		getAll.forEach(e->{
			if(e.getPartsEntity().equals(repairEntity.getRepairId()) && e.getEnebled().equals("1")) {
				try {
					repairPartsDao.changeEnabled(AppConstant.DISABLE, repairEntity);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		

		List<RepairPartsEntity> entities = new ArrayList<>();

		for (String partId : repairParts) {
			
			entities.add(getRepairPartsEntity(repairEntity, partId));
		}

		if (repairPartsDao.save(entities) != null) {
			return "200";
		}

		return "204";
	}

	private RepairPartsEntity getRepairPartsEntity(RepairEntity repairEntity, String partId) {
		PartsEntity partsEntity = partsDao.findOne(partId);

		RepairPartsEntity repairPartsEntity = new RepairPartsEntity();
		repairPartsEntity.setCreateDate(new Date());
		repairPartsEntity.setEnebled(AppConstant.ENABLE);
		repairPartsEntity.setId(UUID.randomUUID().toString());
		repairPartsEntity.setPartsEntity(partsEntity);
		repairPartsEntity.setRemark("");
		repairPartsEntity.setRepairEntity(repairEntity);

		return repairPartsEntity;
	}

	@Override
	public List<RepairSentDto> getOngoingRepairs() throws Exception {
		List<String> param = new ArrayList<>();
		param.add(AppConstant.SEND);
		param.add(AppConstant.SEND_REC);
		param.add(AppConstant.RETURN);
		param.add(AppConstant.RETURN_REC);
		param.add(AppConstant.COMPLETE);
		List<RepairEntity> repairEntities = repairDao.findByStatusNotIn(param);

		

		List<RepairSentDto> repairSentDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairSentDtos.add(getRepairSendDto(e));
		});

		

		return repairSentDtos;
	}

	@Override
	public List<RepairSentDto> getAllRepairs() throws Exception {
		List<RepairEntity> repairEntities = (List<RepairEntity>) repairDao.findAll();

		List<RepairSentDto> repairSentDtos = new ArrayList<>();
		repairEntities.forEach(e -> {
			repairSentDtos.add(getRepairSendDto(e));
		});

		return repairSentDtos;
	}

	@Override
	public List<RepairDto> getAll() throws Exception {
		
			List<RepairEntity> repairEntities = (List<RepairEntity>) repairDao.findAll();
			
			List<RepairDto>repairDtos= new ArrayList<>();
			
			repairEntities.forEach(e ->{
				repairDtos.add(getRep(e));
			});
			
			
		return repairDtos;
	}

	@Override
	public RepairDto getRep(RepairEntity e) {
		
		RepairDto repairDto = new RepairDto();
		repairDto.setJobNo(e.getJobNo());
		repairDto.setRepairId(e.getRepairId());
		return repairDto;
	}

	@Override
	public RepairDto get(String repairId) throws Exception {
		
		RepairEntity repairEntity = repairDao.findOne(repairId);
		return getRep(repairEntity);
	}

	@Override
	public List<RepairDto> getAllDash() throws Exception {

		 List<RepairEntity> entities = (List<RepairEntity>) repairDao.findAll();
		 
		 List<RepairDto> repairDtos = new ArrayList<>();
		 		
		 entities.forEach(e->{
			 repairDtos.add(getRepairDach(e));
		 });
		
		return repairDtos;
	}
	
	
	private RepairDto getDash(String repairId) {
		RepairEntity repairEntity = repairDao.findOne(repairId);
		return getRepairDach(repairEntity);
	}
	
	  private RepairDto getRepairDach(RepairEntity en) {
	  
		  LocationDto locationDto = new LocationDto();
			en.getAssetEntity().getAssetLocationEntities().forEach(e -> {
				
					locationDto.setLocationId(e.getLocationEntity().getLocationId());
					locationDto.setLocationName(e.getLocationEntity().getLocationName());
				
			});

			
			
		  
	  RepairDto repairDto = new RepairDto();
	  
	  repairDto.setRepairId(en.getRepairId());
	  repairDto.setJobNo(en.getJobNo());
	  repairDto.setReason(en.getRepairSendEntity().getReason());
	  repairDto.setAssetDto(assetService.getAssetDto(en.getAssetEntity(), 0, 0, 0));
	  repairDto.setLocationDto(locationDto);
	  repairDto.setPriority(en.getPriority());
	  
	  
	 
	  return repairDto; 
	  }

	@Override
	public List<RepairDto> getRepair() throws Exception {
		
		List<RepairEntity> entities = (List<RepairEntity>) repairDao.findAll(); 
		
		List<RepairDto> repairDtos = new ArrayList<>();
		
		entities.forEach(e ->{
			repairDtos.add(getRepairEd(e));
		});
		return repairDtos;
	}

	private RepairDto getRepairEd(RepairEntity e) {
		RepairDto dto = new RepairDto();
		
		dto.setRepairId(e.getRepairId());
		dto.setJobNo(e.getJobNo());
		
		return dto;
	}

	@Override
	public List<RepairReturnDto> getToBeRepairs() throws Exception {
		
		List<String>param = new ArrayList<>();
		param.add("COMPLETED");
		
		List<RepairReturnEntity>repairReturnEntities = repairReturnsDao.findByStatusIn(param);
		
		List<RepairReturnDto>repairReturnDtos = new ArrayList<>();
		repairReturnEntities.forEach(e ->{
			repairReturnDtos.add(getRepairReturnDto(e));
		});
		
		return repairReturnDtos;
	}
	
}
