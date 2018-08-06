package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairStatusEntity;

public interface RepairStatusDao extends CrudRepository<RepairStatusEntity, String>{

}
