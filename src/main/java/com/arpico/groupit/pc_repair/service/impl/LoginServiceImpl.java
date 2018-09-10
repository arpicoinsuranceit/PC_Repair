package com.arpico.groupit.pc_repair.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpico.groupit.pc_repair.client.LoginClient;
import com.arpico.groupit.pc_repair.dto.LoginResponseDto;
import com.arpico.groupit.pc_repair.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginClient client;

	@Override
	public LoginResponseDto login(String userName, String password) throws Exception {
		LoginResponseDto loginResponseDto = client.getLogin(userName, password, "2");
		System.out.println(loginResponseDto.toString());
		
		loginResponseDto.getMenuDtos().forEach(System.out::println);
		
		return loginResponseDto;
	}

}
