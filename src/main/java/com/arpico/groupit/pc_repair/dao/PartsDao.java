package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.PartsEntity;

public interface PartsDao extends CrudRepository<PartsEntity, String>{

}
