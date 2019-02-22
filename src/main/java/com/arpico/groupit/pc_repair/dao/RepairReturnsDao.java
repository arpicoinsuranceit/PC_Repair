package com.arpico.groupit.pc_repair.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairReturnEntity;

public interface RepairReturnsDao extends CrudRepository<RepairReturnEntity, String>{

	List<RepairReturnEntity> findByStatusIn(List<String> param) throws Exception;

}
