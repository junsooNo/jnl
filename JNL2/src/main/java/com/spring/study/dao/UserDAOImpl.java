package com.spring.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.spring.study.dao.UserDAO.";

	@Override
	public void insertUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+"insertUser",userDTO);
	}

	@Override
	public UserDTO selectOneUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"selectOneUser",userDTO);
	}

	@Override
	public List<UserDTO> selectListUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"selectListUser",userDTO);
	}

	@Override
	public void deleteUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+"deleteUser",userDTO);
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+"updateUser",userDTO);
	}

	@Override
	public int selectCountUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"selectCountUser",userDTO);
	}

}
