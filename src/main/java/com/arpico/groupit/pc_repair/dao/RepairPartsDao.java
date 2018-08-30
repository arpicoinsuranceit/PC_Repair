package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairPartsEntity;

public interface RepairPartsDao extends CrudRepository<RepairPartsEntity, String>{
	
	@Modifying
	@Query("update RepairPartsEntity a set a.enebled = ?1 where a.repairEntity = ?2")
	Integer changeEnabled(Integer disable, RepairEntity repairEntity) throws Exception;

}
