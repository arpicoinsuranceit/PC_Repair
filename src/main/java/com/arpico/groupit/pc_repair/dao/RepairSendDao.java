package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairSendEntity;

public interface RepairSendDao extends CrudRepository<RepairSendEntity, String>{


	/*
	 * @Query("SELECT COUNT(r) FROM RepairSendEntity r WHERE r.repairSendId =?1")
	 * Long findOnGoing(String repairSendId);
	 */
	
	
	
}
