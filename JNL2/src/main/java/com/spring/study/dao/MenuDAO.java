package com.spring.study.dao;

import java.util.List;

import com.spring.study.dto.MenuDTO;

public interface MenuDAO {
	public void insertMenu(MenuDTO menuDTO);
	public MenuDTO selectOneMenu(MenuDTO menuDTO);
	public List<MenuDTO> selectListMenu(MenuDTO menuDTO);
	public void deleteMenu(MenuDTO menuDTO);
	public void updateMenu(MenuDTO menuDTO);
}
