package com.arpico.groupit.pc_repair.service;

import com.arpico.groupit.pc_repair.dto.AssigneeDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.entity.AssigneeEntity;

import java.util.List;

public interface AssigneeService {

    String save (AssigneeDto assigneeDto) throws Exception;

    List<AssigneeDto> getAll () throws  Exception;

    String delete(String assigneeId) throws  Exception;

    AssigneeDto get(String id) throws  Exception;

    List<NameValueDto> getAllNameValue () throws Exception;
    
    AssigneeDto getAssigneeDto(AssigneeEntity e);
}
