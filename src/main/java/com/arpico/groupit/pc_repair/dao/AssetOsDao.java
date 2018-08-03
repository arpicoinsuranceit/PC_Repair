package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.AssetOsEntity;

public interface AssetOsDao extends CrudRepository<AssetOsEntity, String> {
	@Modifying
	@Query("update AssetOsEntity a set a.enabled = ?1 where a.assetEntity = ?2")
	int setDisablePrevious(Integer enable, AssetEntity asset);
}
