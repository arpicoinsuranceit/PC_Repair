package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.ErrorEntity;

public interface ErrorDao extends CrudRepository<ErrorEntity, String>{

}
