package com.arpico.groupit.pc_repair.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupit.pc_repair.entity.LocationEntity;

public interface LocationDao extends CrudRepository<LocationEntity, String>{

}
