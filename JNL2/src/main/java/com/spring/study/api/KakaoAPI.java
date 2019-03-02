package com.spring.study.api;

import javax.servlet.http.HttpSession;

import com.spring.study.dto.UserDTO;

public interface KakaoAPI {
	
	public String getAccessToken(String code);
	public UserDTO getUserInfo(String accessToken);
	public void kakaoLogout(String accessToken);
}
