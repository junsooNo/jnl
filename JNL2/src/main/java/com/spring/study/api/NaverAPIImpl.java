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

import com.spring.study.dto.UserDTO;

public class NaverAPIImpl implements NaverAPI {

	@Override
	public String getAccessToken(String code, String state) {
		try {
			System.out.println(code);
			System.out.println(state);
			
			URL url = new URL("https://nid.naver.com/oauth2.0/token");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(ConstantClass.METHOD_TYPE_POST);
			connection.setRequestProperty("Content-Type", ConstantClass.CONTENT_TYPE_DEFAULT);
			connection.setDoOutput(true);
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("client_id","aY9BM1w0R9qFTSRtXioA");
			paramMap.put("code",code);
			paramMap.put("state",state);
			paramMap.put("client_secret","fybi4wmulC");
			paramMap.put("grant_type","authorization_code");
			String paramStr = "";
			int count = 0;
			for(Map.Entry<String, Object> entry : paramMap.entrySet()) {
				if(count!=0) {
					paramStr += "&"+entry.getKey()+"="+entry.getValue();
				}else {
					paramStr += entry.getKey()+"="+entry.getValue();
				}
				count++;
			}
			System.out.println(paramStr);
			//String  asd ="grant_type=authorization_code&client_id=aY9BM1w0R9qFTSRtXioA&client_secret=fybi4wmulC&code="+code+"&state="+state;
			byte[] paramByte = paramStr.toString().getBytes();
			connection.getOutputStream().write(paramByte);
			
			System.out.println(connection.getContentEncoding());
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),ConstantClass.CHAR_SET_UTF_8));
			
			String line = "";
			String jsonLine = "";
			while((line=br.readLine()) != null) {
				jsonLine += line;
			}
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonLine);
			JSONObject jsonObj = (JSONObject) obj;
			
			return (String) jsonObj.get("access_token");
			
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
			URL url = new URL("https://openapi.naver.com/v1/nid/me");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(ConstantClass.METHOD_TYPE_POST);
			connection.setRequestProperty("Authorization", "Bearer "+accessToken);
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", ConstantClass.CONTENT_TYPE_DEFAULT);
			connection.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),ConstantClass.CHAR_SET_UTF_8));
			
			String line = "";
			String jsonLine = "";
			
			while((line=br.readLine()) != null) {
				jsonLine += line;
				System.out.println(line);
			}
			
			UserDTO userDTO = new UserDTO();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonLine);
			JSONObject jsonObj = (JSONObject) obj;
			Object response = jsonObj.get("response");
			jsonObj = (JSONObject) response;
			userDTO.setId((String) jsonObj.get("id"));
			userDTO.setProfile_image((String) jsonObj.get("profile_image"));
			userDTO.setName((String) jsonObj.get("name"));
			userDTO.setEmail((String) jsonObj.get("email"));
			userDTO.setToken_kind("naver");
			
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
	public void naverLogout(String accessToken) {
		// TODO Auto-generated method stub
		
	}

}
