package com.arpico.groupit.pc_repair.client;

import com.arpico.groupit.pc_repair.dto.LoginResponseDto;

public interface LoginClient {
	
	public LoginResponseDto getLogin (String userName, String password, String subSbu) throws Exception;

}
