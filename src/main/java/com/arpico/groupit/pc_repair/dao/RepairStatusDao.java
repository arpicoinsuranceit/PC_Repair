package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairStatusEntity;

public interface RepairStatusDao extends CrudRepository<RepairStatusEntity, String>{
	@Modifying
	@Query("update RepairStatusEntity a set a.enabled = 0 where a.repairEntity = ?1")
	int setDisablePrevious(RepairEntity repairEntity);
}
