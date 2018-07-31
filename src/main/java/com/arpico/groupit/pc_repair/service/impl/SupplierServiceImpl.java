package com.arpico.groupit.pc_repair.service.impl;

import com.arpico.groupit.pc_repair.dao.SupplierDao;
import com.arpico.groupit.pc_repair.dto.SupplierDto;
import com.arpico.groupit.pc_repair.entity.SupplierEntity;
import com.arpico.groupit.pc_repair.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public String save(SupplierDto supplierDto) throws Exception {
        SupplierEntity supplierEntity = getSupplierEntity(supplierDto);

        if(supplierDao.save(supplierEntity)!= null) {
            return "201";
        }
        return "204";
    }

    @Override
    public List<SupplierDto> getAll() throws Exception {
        List<SupplierEntity> supplierEntities = (List<SupplierEntity>) supplierDao.findAll();

        List<SupplierDto> supplierDtos = new ArrayList<>();

        supplierEntities.forEach( e -> {
            supplierDtos.add(getSupplierDto(e));
        });

        return supplierDtos;

    }

    @Override
    public String delete(String supplierId) throws  Exception{
        supplierDao.delete(supplierId);
        return "201";
    }

    @Override
    public SupplierDto get(String id) throws Exception {
        SupplierEntity supplierEntity = supplierDao.findOne(id);
        return getSupplierDto(supplierEntity);
    }

    private SupplierDto getSupplierDto(SupplierEntity e) {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierId(e.getSuplierId());
        supplierDto.setSupplierName(e.getSuplierName());

        return supplierDto;
    }


    private SupplierEntity getSupplierEntity(SupplierDto supplierDto) {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setSuplierId(supplierDto.getSupplierId());
        supplierEntity.setSuplierName(supplierDto.getSupplierName());
        return supplierEntity;
    }


}
