package com.arpico.groupit.pc_repair.service.impl;

import com.arpico.groupit.pc_repair.dao.AssigneeDao;
import com.arpico.groupit.pc_repair.dto.AssigneeDto;
import com.arpico.groupit.pc_repair.dto.NameValueDto;
import com.arpico.groupit.pc_repair.entity.AssigneeEntity;
import com.arpico.groupit.pc_repair.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AssigneeServiceImpl implements AssigneeService {

    @Autowired
    private AssigneeDao assigneeDao;

    @Override
    public String save(AssigneeDto assigneeDto) throws Exception {
        AssigneeEntity assigneeEntity = getAssgneeEntity(assigneeDto);

        if(assigneeDao.save(assigneeEntity) != null) {
            return "201";
        }
        return "204";

    }


    @Override
    public List<AssigneeDto> getAll() throws Exception {
        List<AssigneeEntity> assigneeEntities = (List<AssigneeEntity>) assigneeDao.findAll();

        List<AssigneeDto> assigneeDtos = new ArrayList<>();

        assigneeEntities.forEach(e -> {
            assigneeDtos.add(getAssigneeDto(e));
        });

        return assigneeDtos;
    }


    @Override
    public boolean delete(String assigneeId) throws Exception {

        assigneeDao.delete(assigneeId);

        return true;
    }

    @Override
    public AssigneeDto get(String id) throws Exception {
        AssigneeEntity assigneeEntity = assigneeDao.findOne(id);

        return getAssigneeDto(assigneeEntity);
    }

    @Override
    public List<NameValueDto> getAllNameValue() throws Exception {
        return null;
    }

    @Override
    public AssigneeDto getAssigneeDto(AssigneeEntity e) {

        AssigneeDto assigneeDto = new AssigneeDto();
        assigneeDto.setAssigneeId(e.getAssigneeId());
        assigneeDto.setAssigneeName(e.getAssigneeName());

        return assigneeDto;
    }

    private AssigneeEntity getAssgneeEntity(AssigneeDto assigneeDto) {

        AssigneeEntity assigneeEntity = new AssigneeEntity();

        assigneeEntity.setAssigneeId(assigneeDto.getAssigneeId());
        assigneeEntity.setAssigneeName(assigneeDto.getAssigneeName());
        assigneeEntity.setCreateDate(new Date());

        return assigneeEntity;
    }

}
