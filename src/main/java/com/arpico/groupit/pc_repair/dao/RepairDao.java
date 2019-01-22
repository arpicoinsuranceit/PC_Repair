package com.arpico.groupit.pc_repair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairEntity;

public interface RepairDao extends CrudRepository<RepairEntity, String>{

	List<RepairEntity> findByStatus(String send) throws Exception;

	List<RepairEntity> findByStatusIn(List<String> param) throws Exception;

	List<RepairEntity> findByStatusNotInOrderByPriorityAscCerateDateAsc(List<String> param) throws Exception;

	@Query("SELECT coalesce(max(r.jobNo), 10000) FROM RepairEntity r")
	Integer findOneOrderByJobNo() throws Exception;
	
	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status in ?1")
	Integer findOnGoing(List<String> status) throws Exception;

	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findCompleted(String status) throws Exception;

	
	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findOnInComming(String status) throws Exception;

	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findHold(String status) throws Exception;

	List<RepairEntity> findByStatusNotIn(List<String> param) throws Exception;

}
