package com.spring.study.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.study.dto.KaKaoAPIDTO;
import com.spring.study.dto.KakaoProperties;
import com.spring.study.dto.KakaoUserInfo;
import com.spring.study.dto.UserDTO;

public class KakaoAPIImpl implements KakaoAPI {
private static final Logger LOGGER = LoggerFactory.getLogger(KakaoAPI.class);
	
	public String getAccessToken(String code) {
		try {
			URL url = new URL("https://kauth.kakao.com/oauth/token");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//connection 설정
			connection.setRequestProperty("Content-Type",ConstantClass.CONTENT_TYPE_DEFAULT);
			connection.setRequestMethod(ConstantClass.METHOD_TYPE_POST);
			connection.setDoOutput(true);
			
			//파라미터 맵 ㅡ> 스트링 ㅡ> 바이트배열 변환
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("grant_type","authorization_code");
			paramMap.put("client_id","64d617d3a9432635af13fadf550649e1");
			paramMap.put("redirect_uri","http://192.168.200.107:8080/study/kakaoSession");
			paramMap.put("code",code);
			
			String paramStr = "";
			int count = 0;
			for(Map.Entry<String,Object> entry : paramMap.entrySet()) {
				if(count!=0) {
					paramStr += "&"+entry.getKey()+"="+entry.getValue();
				}else {
					paramStr += entry.getKey()+"="+entry.getValue();
				}
				count++;
			}
			
			byte[] paramByte = paramStr.toString().getBytes();
			
			//전송
			connection.getOutputStream().write(paramByte);
			
			//받기
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),ConstantClass.CHAR_SET_UTF_8));
			
			String line = "";
			String jsonLine = "";
			
			while((line=br.readLine()) != null) {
				jsonLine += line;
			}
			
			LOGGER.info("json >>>"+jsonLine);
			
			Gson gson = new GsonBuilder().create();
			KaKaoAPIDTO dto = gson.fromJson(jsonLine, KaKaoAPIDTO.class);
			
			
			
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonLine);
			
			JSONObject jsonObj = (JSONObject) obj;
			String accessToken = (String) jsonObj.get("access_token");
			
			LOGGER.info("accessToken >>>"+accessToken);
			
			return accessToken;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2);
		} catch (ParseException e3) {
			e3.printStackTrace();
			throw new RuntimeException(e3);
		}
	}

	@Override
	public UserDTO getUserInfo(String accessToken) {
		try {
			URL url = new URL("https://kapi.kakao.com/v2/user/me");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//connection 설정
			connection.setRequestProperty("Content-Type",ConstantClass.CONTENT_TYPE_UTF_8);
			connection.setRequestMethod(ConstantClass.METHOD_TYPE_POST);
			connection.setRequestProperty("Authorization","Bearer "+accessToken);
			connection.setDoOutput(true);
			
			String paramStr = "";
			
			byte[] paramByte = paramStr.toString().getBytes();
			
			//전송
			connection.getOutputStream().write(paramByte);
			
			//받기
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),ConstantClass.CHAR_SET_UTF_8));
			
			String line = "";
			String jsonLine = "";
			
			while((line=br.readLine()) != null) {
				jsonLine += line;
			}
			
			
			
			
			Gson gson = new GsonBuilder().create();
			KakaoUserInfo userInfo = gson.fromJson(jsonLine, KakaoUserInfo.class);
			
			KakaoProperties properties1 = userInfo.getProperties();
			
			
			
			
			
			LOGGER.info("json >>>"+jsonLine);
			
			UserDTO userDTO = new UserDTO();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonLine);
			
			JSONObject jsonObj = (JSONObject) obj;
			Object id = jsonObj.get("id");
			userDTO.setId(String.valueOf(id));
			
			Object properties = jsonObj.get("properties");
			LOGGER.info("properties >>>"+properties);
			
			//jsonObj 재정의
			jsonObj = (JSONObject) properties;
			String thumbnailImage = (String)jsonObj.get("thumbnail_image");
			
			userDTO.setName((String)jsonObj.get("nickname"));
			userDTO.setProfile_image((String)jsonObj.get("profile_image"));
			userDTO.setToken_kind("kakao");
			return userDTO;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2);
		} catch (ParseException e3) {
			e3.printStackTrace();
			throw new RuntimeException(e3);
		}
	}

	@Override
	public void kakaoLogout(String accessToken) {
		try {
			URL url = new URL("https://kapi.kakao.com/v1/user/logout");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type", ConstantClass.CONTENT_TYPE_DEFAULT);
			connection.setDoOutput(true);
			connection.setRequestMethod(ConstantClass.METHOD_TYPE_POST);
			connection.setRequestProperty("Authorization", "Bearer "+accessToken);
			connection.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),ConstantClass.CHAR_SET_UTF_8));
			
			String line = "";
			
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2);
		}
	}
}
