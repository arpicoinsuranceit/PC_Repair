package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairEntity;
import com.arpico.groupit.pc_repair.entity.RepairErrorDetailEntity;

public interface RepairErrorDetailsDao extends CrudRepository<RepairErrorDetailEntity, String>{

	@Modifying
	@Query("update RepairErrorDetailEntity a set a.enabled = ?1 where a.repairEntity = ?2")
	Integer changeEnabled(Integer disable, RepairEntity repairEntity) throws Exception;

}
