package com.arpico.groupit.pc_repair.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.arpico.groupit.pc_repair.client.LoginClient;
import com.arpico.groupit.pc_repair.dto.LoginResponseDto;

@Component
@PropertySource("classpath:custom.properties")
public class LoginClientImpl implements LoginClient {

	@Value("${usernamagement.login.url}")
	private String path;

	@Override
	public LoginResponseDto getLogin(String userName, String password, String subSbu) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userName", userName);
		map.add("password", password);
		map.add("subSbu", subSbu);

		LoginResponseDto results = restTemplate.postForObject(path, map, LoginResponseDto.class);

		return results;
	}

}
