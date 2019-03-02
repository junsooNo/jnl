package com.spring.study.service;

import java.util.List;

import com.spring.study.dto.LearnPostDTO;

public interface LearnPostService {
	public void insertLearnPost(LearnPostDTO learnPostDTO);
	public LearnPostDTO selectOneLearnPost(LearnPostDTO learnPostDTO);
	public List<LearnPostDTO> selectListLearnPost(LearnPostDTO learnPostDTO);
	public void deleteLearnPost(LearnPostDTO learnPostDTO);
	public void updateLearnPost(LearnPostDTO learnPostDTO);
}
