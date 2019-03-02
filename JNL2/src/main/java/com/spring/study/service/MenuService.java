package com.spring.study.service;

import java.util.List;

import com.spring.study.dto.MenuDTO;

public interface MenuService {
	public void insertMenu(MenuDTO menuMenuDTO);
	public MenuDTO selectOneMenu(MenuDTO menuMenuDTO);
	public List<MenuDTO> selectListMenu(MenuDTO menuMenuDTO);
	public void deleteMenu(MenuDTO menuMenuDTO);
	public void updateMenu(MenuDTO menuMenuDTO);
}
