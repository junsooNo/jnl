package com.spring.study.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.study.dto.UserDTO;

public interface UserService {
	public void insertUser(UserDTO userDTO) throws SQLException;
	public UserDTO selectOneUser(UserDTO userDTO);
	public List<UserDTO> selectListUser(UserDTO userDTO);
	public void deleteUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public int selectCountUser(UserDTO userDTO);
}
