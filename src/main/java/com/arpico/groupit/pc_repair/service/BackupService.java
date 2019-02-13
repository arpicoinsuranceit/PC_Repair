package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.BackupDto;
import com.arpico.groupit.pc_repair.dto.BackupGridDto;
import com.arpico.groupit.pc_repair.entity.BackupEntity;

public interface BackupService {
	
	List<BackupGridDto> getAll() throws Exception;

	String save(BackupDto backupDto) throws Exception;
	
	boolean delete(String backupId) throws Exception;

	BackupGridDto getBackupGridDto(BackupEntity e) throws Exception;

	String editBackup(BackupDto backupDto)throws Exception;

	BackupDto get(String id)throws Exception;
	
	String received(String id, String status) throws Exception;
	
	List<BackupDto> getRecivedBackup()throws Exception;
}
