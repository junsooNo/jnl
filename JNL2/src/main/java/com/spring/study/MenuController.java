package com.spring.study;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.dto.MenuDTO;
import com.spring.study.service.MenuService;
import com.spring.study.util.JnlUtil;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private JnlUtil jnlUtil;
	
	@RequestMapping(value="menu",method=RequestMethod.GET,produces="application/text; charset=UTF-8")
	@ResponseBody
	public String menu(MenuDTO menuDTO) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<MenuDTO> menuList = menuService.selectListMenu(menuDTO);
		map.put("menuList",menuList);
		return jnlUtil.getJson(map);
	}
}
