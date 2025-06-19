package com.ezen.mybatis.domain.board.mapper;

import java.sql.Connection;
import java.util.List;

import ezen.shoppingmall.domain.article.dto.Memo;

/**
 * article 테이블 관련 명세
 */
public interface ArticleMapper {
	/** 신규 게시글 등록 */
	public void create(Article);
	
	/** 전체 게시판 목록 반환 */
	public List<Board> findAll();
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환
	public int getCountAll();
	
	// 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환
	public List<Memo> findByAll(Connection connection, int requestPage, int elementSize);

}
