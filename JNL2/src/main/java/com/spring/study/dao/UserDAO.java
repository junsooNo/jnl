package com.spring.study.dao;

import java.util.List;

import com.spring.study.dto.UserDTO;

public interface UserDAO {
	public void insertUser(UserDTO UserDTO);
	public UserDTO selectOneUser(UserDTO UserDTO);
	public List<UserDTO> selectListUser(UserDTO UserDTO);
	public void deleteUser(UserDTO UserDTO);
	public void updateUser(UserDTO UserDTO);
	public int selectCountUser(UserDTO userDTO);
}
