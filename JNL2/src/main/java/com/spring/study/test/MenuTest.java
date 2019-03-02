package com.spring.study.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.study.dto.MenuDTO;
import com.spring.study.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/mybatis-context.xml")
public class MenuTest {
	
	@Autowired
	private MenuService menuService;
	
	private List<MenuDTO> setUpList;
	
	private MenuDTO dto1;
	private MenuDTO dto2;
	@Before
	public void setUp() {
		dto1 = new MenuDTO();
		dto1.setName("활동내역");
		dto1.setParent_menu(4);
		dto1.setMenu_level(2);
		dto1.setReg_id("wnstn212");
		dto1.setUse_yn("Y");
		
		dto2 = new MenuDTO();
		dto2.setName("스터디 방향");
		dto2.setParent_menu(5);
		dto2.setMenu_level(2);
		dto2.setReg_id("wnstn212");
		dto2.setUse_yn("Y");
	}
	
	@Test
	public void insertMenu() {
		menuService.insertMenu(dto2);
	}
}
