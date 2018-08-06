package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.StatusEntity;

public interface StatusDao extends CrudRepository<StatusEntity, String>{

}
