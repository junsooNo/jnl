package com.spring.study.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.dao.UserDAO;
import com.spring.study.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserDTO userDTO) throws SQLException {
		// TODO Auto-generated method stub
		userDAO.insertUser(userDTO);
	}

	@Override
	public UserDTO selectOneUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userDAO.selectOneUser(userDTO);
	}

	@Override
	public List<UserDTO> selectListUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userDAO.selectListUser(userDTO);
	}

	@Override
	public void deleteUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(userDTO);
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		userDAO.updateUser(userDTO);
	}

	@Override
	public int selectCountUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userDAO.selectCountUser(userDTO);
	}

}
