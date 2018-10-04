package com.arpico.groupit.pc_repair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.AssetEntity;
import com.arpico.groupit.pc_repair.entity.AssetLocationEntity;
import com.arpico.groupit.pc_repair.entity.LocationEntity;

public interface AssetLocationDao extends CrudRepository<AssetLocationEntity, String>{

	@Modifying
	@Query("update AssetLocationEntity a set a.enabled = ?1 where a.assetEntity = ?2")
	int setDisablePrevious(Integer enable, AssetEntity asset);

	List<AssetLocationEntity> findAllByLocationEntityAndEnabled(LocationEntity locationEntity, Integer enabled);
}
