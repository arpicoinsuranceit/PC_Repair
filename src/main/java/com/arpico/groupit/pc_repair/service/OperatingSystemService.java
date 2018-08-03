package com.arpico.groupit.pc_repair.service;

import java.util.List;

import com.arpico.groupit.pc_repair.dto.NameValueDto;

public interface OperatingSystemService {
	List<NameValueDto> getAllNameValue () throws Exception;
}
