package com.arpico.groupit.pc_repair.service;

import com.arpico.groupit.pc_repair.dto.LoginResponseDto;

public interface LoginService {
	
	public LoginResponseDto login(String userName, String password) throws Exception;

}
