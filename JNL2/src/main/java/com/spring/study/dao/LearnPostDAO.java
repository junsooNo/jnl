package com.spring.study.dao;

import java.util.List;

import com.spring.study.dto.LearnPostDTO;

public interface LearnPostDAO {
	public void insertLearnPost(LearnPostDTO learnPostDTO);
	public LearnPostDTO selectOneLearnPost(LearnPostDTO learnPostDTO);
	public List<LearnPostDTO> selectListLearnPost(LearnPostDTO learnPostDTO);
	public void deleteLearnPost(LearnPostDTO learnPostDTO);
	public void updateLearnPost(LearnPostDTO learnPostDTO);
}
