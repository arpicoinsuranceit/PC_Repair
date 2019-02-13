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
	Integer findOnGoingN(String status) throws Exception;
	
    @Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status in ?1")
	Integer findOnGoingP(String status) throws Exception;
    
    @Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status in ?1")
	Integer findOnWarranty(String status) throws Exception;
    
    @Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status in ?1")
	Integer findOnRepair(String status) throws Exception;
    
	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findCompletedH(String status) throws Exception;
	
	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findCompletedB(String status) throws Exception;

	
	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findOnInCommingh(String status) throws Exception;
	
	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findOnInCommingb(String status) throws Exception;

	@Query("SELECT count(r.jobNo) FROM RepairEntity r WHERE r.status = ?1")
	Integer findHold(String status) throws Exception;

	List<RepairEntity> findByStatusNotIn(List<String> param) throws Exception;

}
