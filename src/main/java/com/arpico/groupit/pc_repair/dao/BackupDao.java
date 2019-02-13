package com.arpico.groupit.pc_repair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.BackupEntity;
import com.arpico.groupit.pc_repair.entity.RepairEntity;

public interface BackupDao extends CrudRepository<BackupEntity, String>{

	List<BackupEntity> findAllByEnabled(Integer enabled) throws Exception;
	
	List<BackupEntity> findByStatusIn(List<String> param) throws Exception;
}
