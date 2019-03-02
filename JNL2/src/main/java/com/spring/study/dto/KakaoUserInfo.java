package com.spring.study.dto;

public class KakaoUserInfo {
	private String id;
	private KakaoProperties properties;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public KakaoProperties getProperties() {
		return properties;
	}
	public void setProperties(KakaoProperties properties) {
		this.properties = properties;
	}
}
