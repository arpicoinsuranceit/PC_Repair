package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.OperatingSystemEntity;

public interface OperatingSystemDao extends CrudRepository<OperatingSystemEntity, String>{

}
