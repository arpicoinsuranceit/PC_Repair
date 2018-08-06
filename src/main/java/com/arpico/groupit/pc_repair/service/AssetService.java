package com.arpico.groupit.pc_repair.service;

import com.arpico.groupit.pc_repair.dto.AssetDto;

import java.util.List;

public interface AssetService {

    List<AssetDto> getAll() throws Exception;
    
    String save(AssetDto assetDto) throws Exception;

    String delete(String assetId) throws Exception;

    AssetDto get(String assetId) throws Exception;
}
