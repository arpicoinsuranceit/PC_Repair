package com.arpico.groupit.pc_repair.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.BackupEntity;

public interface BackupDao extends CrudRepository<BackupEntity, String>{

	List<BackupEntity> findAllByEnabled(Integer enabled) throws Exception;
	
}
