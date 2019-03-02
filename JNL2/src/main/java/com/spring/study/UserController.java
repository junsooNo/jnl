package com.spring.study;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.api.KakaoAPI;
import com.spring.study.api.NaverAPI;
import com.spring.study.dto.UserDTO;
import com.spring.study.service.UserService;
import com.spring.study.util.JnlUtil;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	public static String access = "";
	@Autowired
	private UserService userService;
	
	@Autowired
	private KakaoAPI kakaoAPI;
	
	@Autowired
	private NaverAPI naverAPI;
	
	@Autowired
	private JnlUtil jnlUtil;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("center","login.jsp");
		return "main";
	}
	
	@RequestMapping(value="kakaoSession",method=RequestMethod.GET)
	public String kakaoSession(String code, HttpSession session, Model model) {
		LOGGER.info(code);
		String accessToken = kakaoAPI.getAccessToken(code);
		access = accessToken;
		UserDTO userDTO = kakaoAPI.getUserInfo(accessToken);
		LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userDTO.getName());
		session.setAttribute("userInfo", userDTO);
		session.setAttribute("accessToken",accessToken);
		return "redirect:main";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute("userInfo");
		LOGGER.info(userDTO.getToken_kind());
		if(userDTO.getToken_kind().equals("kakao")) {
			kakaoAPI.kakaoLogout(session.getAttribute("accessToken").toString());
		}
		session.invalidate();
		return "redirect:main";
	}
	
	@RequestMapping(value="naverSession",method=RequestMethod.GET)
	public String naverSession(String code, String state, HttpSession session) {
		LOGGER.info(code);
		String accessToken = naverAPI.getAccessToken(code,state);
		UserDTO userDTO = naverAPI.getUserInfo(accessToken);
		session.setAttribute("userInfo", userDTO);
		session.setAttribute("accessToken",accessToken);
		return "redirect:main";
	}
	
	@RequestMapping(value="instagramSession")
	public String instagramSession(String code, HttpServletRequest req, String state, HttpSession session) {
		
		LOGGER.info("코드 >>>>>>>>>>>>>>"+code);
		LOGGER.info("상태>>>>>>>>>>>>>>"+state);
		LOGGER.info("Request >>>>>>>>>>>>>>>>>"+req.getParameter("another"));
		LOGGER.info(req.getContentType());
		LOGGER.info("url <>>>>"+req.getRequestURI());
		return "redirect:main";
	}
	
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("center","join.jsp");
		return "main";
	}
	
	@RequestMapping(value="checkId",method=RequestMethod.GET)
	@ResponseBody
	public String checkId(UserDTO userDTO) {
		int count = userService.selectCountUser(userDTO);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result",count);
		return jnlUtil.getJson(map);
	}
	@RequestMapping(value="user",method=RequestMethod.POST)
	@ResponseBody
	public String user(UserDTO userDTO) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			userService.insertUser(userDTO);
		}catch(SQLException e) {
			map.put("result","fail");
		}
		map.put("result","success");
		return jnlUtil.getJson(map);
	}
	
	@RequestMapping(value="loginSession",method=RequestMethod.POST)
	@ResponseBody
	public String loginSession(UserDTO userDTO, HttpSession session) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count = userService.selectCountUser(userDTO);
		if(count>0) {
			map.put("result","success");
			UserDTO dto = userService.selectOneUser(userDTO);
			dto.setToken_kind("jnl2");
			session.setAttribute("userInfo", dto);
		}else {
			map.put("result","fail");
		}
		return jnlUtil.getJson(map);
	}
}
