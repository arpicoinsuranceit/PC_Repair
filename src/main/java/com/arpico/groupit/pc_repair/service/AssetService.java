package com.arpico.groupit.pc_repair.service;

import com.arpico.groupit.pc_repair.dto.AssetDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.entity.AssetEntity;

import java.util.List;

public interface AssetService {

    List<AssetDto> getAll() throws Exception;
    
    String save(AssetDto assetDto) throws Exception;

    String delete(String assetId) throws Exception;

    AssetDto get(String assetId) throws Exception;
    
    AssetDto getAssetDto(AssetEntity e, Integer supplier, Integer location, Integer os);

	List<AssetDto> getAllBackups() throws Exception;
	
	List<AssetDto> getAssestBackup() throws Exception;

}
