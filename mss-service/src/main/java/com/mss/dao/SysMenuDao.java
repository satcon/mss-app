package com.mss.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SysMenuDao {
	
	private SqlSession sqlSession;

	public Integer findMenuCount() {
		return sqlSession.selectOne("countMenu");
	}
	
	public <T> List<T> findAllMenus() {
		return sqlSession.selectList("findAllMenus");
	}
	
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Resource
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

}
