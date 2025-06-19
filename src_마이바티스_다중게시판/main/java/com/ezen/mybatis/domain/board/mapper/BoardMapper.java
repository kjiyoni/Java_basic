package com.ezen.mybatis.domain.board.mapper;

import java.util.List;

/**
 * board 테이블 관련 명세
 */
public interface BoardMapper {
	/** 신규 게시판 생성 */
	public void create(Board board);
	/** 전체 게시판 목록 반환 */
	public List<Board> findAll();

}
