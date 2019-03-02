package com.spring.study.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.study.dto.UserDTO;
import com.spring.study.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/mybatis-context.xml")
public class UserTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
	
	@Autowired
	private UserService userService;
	
	UserDTO setUserDTO;
	UserDTO joinUserDTO;
	@Before
	public void setUp() {
		setUserDTO = new UserDTO();
		setUserDTO.setId("wnstn212");
		
		joinUserDTO = new UserDTO();
		joinUserDTO.setId("wnstn212");
		joinUserDTO.setPasswd("123");
		joinUserDTO.setName("노준수");
		joinUserDTO.setGender("M");
		joinUserDTO.setEmail("wnstn212@naver.com");
	}
	
	@Test
	public void test() {
		int count = userService.selectCountUser(setUserDTO);
		
		LOGGER.info("userIdCheck >>>> count = "+String.valueOf(count));
	}
	@Test
	public void loginTest() {
		setUserDTO.setPasswd("123");
		int count = userService.selectCountUser(setUserDTO);
		LOGGER.info("loginCheck >>>> count = "+String.valueOf(count));
	}
	
	@Test
	public void joinTest() {
	}
}

