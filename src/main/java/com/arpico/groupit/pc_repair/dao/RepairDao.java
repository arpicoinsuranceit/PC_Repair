package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.RepairEntity;

public interface RepairDao extends CrudRepository<RepairEntity, String>{

}
