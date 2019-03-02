package com.spring.study.util;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JnlUtil {
	public String getJson(Map<String,Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(map);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String filePath() {
		return "D:\\workspace\\JNL2\\src\\main\\webapp\\resources\\upload_image\\";
	}
}
