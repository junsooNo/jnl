package com.spring.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.dao.MenuDAO;
import com.spring.study.dto.MenuDTO;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public void insertMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		menuDAO.insertMenu(menuDTO);
	}

	@Override
	public MenuDTO selectOneMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		return menuDAO.selectOneMenu(menuDTO);
	}

	@Override
	public List<MenuDTO> selectListMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		return menuDAO.selectListMenu(menuDTO);
	}

	@Override
	public void deleteMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		menuDAO.deleteMenu(menuDTO);
	}

	@Override
	public void updateMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		menuDAO.updateMenu(menuDTO);
	}

}
