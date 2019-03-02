package com.spring.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.study.dto.LearnPostDTO;

@Repository
public class LearnPostDAOImpl implements LearnPostDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.spring.study.dao.LearnPostDAO.";
	
	@Override
	public void insertLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+"insertPost",learnPostDTO);
	}

	@Override
	public LearnPostDTO selectOneLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"selectOnePost",learnPostDTO);
	}

	@Override
	public List<LearnPostDTO> selectListLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"selectListLearnPost",learnPostDTO);
	}

	@Override
	public void deleteLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+"deleteLearnPost",learnPostDTO);
	}

	@Override
	public void updateLearnPost(LearnPostDTO learnPostDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+"updateLearnPost",learnPostDTO);
	}

}
