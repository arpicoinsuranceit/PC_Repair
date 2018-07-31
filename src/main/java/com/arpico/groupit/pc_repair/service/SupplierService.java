package com.arpico.groupit.pc_repair.service;

import com.arpico.groupit.pc_repair.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    String save (SupplierDto supplierDto) throws Exception;

    List<SupplierDto> getAll () throws  Exception;

    String delete(String supplierId) throws  Exception;

    SupplierDto get(String id) throws  Exception;
}
