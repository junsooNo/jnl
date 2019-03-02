package com.spring.study.api;

import com.spring.study.dto.UserDTO;

public interface NaverAPI {
	public String getAccessToken(String code, String state);
	public UserDTO getUserInfo(String accessToken);
	public void naverLogout(String accessToken);
}
