package com.spring.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.dao.LearnPostDAO;
import com.spring.study.dto.LearnPostDTO;

@Service
public class LearnPostServiceImpl implements LearnPostService {

	@Autowired
	private LearnPostDAO learnPostDAO;
	
	@Override
	public void insertLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		learnPostDAO.insertLearnPost(learnPostDTO);
	}

	@Override
	public LearnPostDTO selectOneLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		return learnPostDAO.selectOneLearnPost(learnPostDTO);
	}

	@Override
	public List<LearnPostDTO> selectListLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		return learnPostDAO.selectListLearnPost(learnPostDTO);
	}

	@Override
	public void deleteLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		learnPostDAO.deleteLearnPost(learnPostDTO);
	}

	@Override
	public void updateLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		learnPostDAO.updateLearnPost(learnPostDTO);
	}

}
