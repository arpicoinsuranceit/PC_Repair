package com.arpico.groupit.pc_repair.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairEntity;

public interface WarrantyClameDao extends CrudRepository<RepairEntity,String>{

	List<RepairEntity> findByStatusIn(List<String> param) throws Exception;
}
