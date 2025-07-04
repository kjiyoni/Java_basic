package com.ezen.mybatis.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.mybatis.domain.board.dto.ArticleDTO;
import com.ezen.mybatis.domain.common.web.PageParams;

/**
 * article 테이블 관련 명세
 */
public interface ArticleMapper {

	/** 페이징 계산에 필요한 게시글 전체 갯수 반환 */
	public int getCountAll(PageParams pageParams);

	/** 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환 */
	public List<ArticleDTO> findByAll(PageParams pageParams);

	/** 신규 게시글 등록 */
	public void create(ArticleDTO articleDTO);

	/** 게시글 수정 */
	public void updateArticle(ArticleDTO articleDTO);

	/** 게시글 삭제 */
	public boolean removeArticle(@Param("articleId") int articleId, @Param("passwd") String passwd);

	/** 답글 */
	public void reply(ArticleDTO articleDTO);
	
	/** 게시판 상세보기 */
	public List<ArticleDTO> openArticle(int articleId);

}
