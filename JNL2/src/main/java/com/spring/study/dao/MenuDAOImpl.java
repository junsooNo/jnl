package com.spring.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.dto.MenuDTO;

@Repository
public class MenuDAOImpl implements MenuDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.spring.study.dao.MenuDAO.";

	@Override
	public void insertMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+"insertMenu",menuDTO);
	}

	@Override
	public MenuDTO selectOneMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"selectOneMenu",menuDTO);
	}

	@Override
	public List<MenuDTO> selectListMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"selectListMenu",menuDTO);
	}

	@Override
	public void deleteMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+"deleteMenu",menuDTO);
	}

	@Override
	public void updateMenu(MenuDTO menuDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+"updateMenu",menuDTO);
	}

}
