package com.ezen.mybatis;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.board.dto.ArticleDTO;
import com.ezen.mybatis.domain.board.dto.BoardDTO;
import com.ezen.mybatis.domain.board.mapper.ArticleMapper;
import com.ezen.mybatis.domain.board.mapper.BoardMapper;
import com.ezen.mybatis.domain.common.web.PageParams;
import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import com.ezen.mybatis.domain.member.dto.Member;
import com.ezen.mybatis.domain.member.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArticleMapperTest {
	SqlSession sqlSession;

	@BeforeEach
	public void setUp() {
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession(true);
	}

	
	@Test
	public void getCountAllTest() {
		System.out.println("=====게시글 전체 개수 반환=====");
        PageParams pageParams = new PageParams();
        pageParams.setElementSize(10);  // 페이지에 보여지는 목록 갯수 설정
        pageParams.setPageSize(10);     // 페이지에 보여지는 페이지 갯수 설정
        pageParams.setRequestPage(1);   // 사용자 요청 페이지 설정
        pageParams.setBoardId(10);
        pageParams.setInput("monday");
        pageParams.setType("writer");

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        int count = mapper.getCountAll(pageParams);
        log.debug("게시글 수 : {}", count);
	}
	
	@Test
	@Disabled
	public void findByAllTest() {
		System.out.println("=====게시글 목록 반환=====");
		PageParams pageParams = new PageParams();
		pageParams.setInput("monday");
		pageParams.setBoardId(20);
		pageParams.setType("writer");
		
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		List<ArticleDTO> articleDTO = mapper.findByAll(pageParams);
		articleDTO.forEach( article -> {
			log.debug("검색된 게시글 : {}", article);
		});
	}
	
	   @Test
	   @DisplayName("게시글 등록 테스트")
	   @Disabled
	   void createTest() {
	      ArticleDTO article = ArticleDTO.builder()
	                              .articleId(68)
	                              .boardId(10)
	                              .writer("monday")
	                              .subject("오늘 점심 뭐 먹지")
	                              .content("김기정 선생님과 함께 하는 점심.")
	                              .passwd("1234")
	                              .groupNo(2)
	                              .levelNo(0)
	                              .orderNo(0)
	                              .build();
	      
	      ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
	      mapper.create(article);
	      log.debug("신규글 내용 :{}",article);
	   }
	   
	   @Test
	   @DisplayName("게시글 수정 테스트")
	   @Disabled
	   void updateArticleTest() {
	      ArticleDTO article = ArticleDTO.builder()
	                              .articleId(68)
	                              .subject("오점무")
	                              .build();
	      ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
	      mapper.updateArticle(article);
	   }
	   
	   @Test
	   @DisplayName("게시글 삭제 테스트")
	   @Disabled
	   void removeArticleTest() {
	      ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
	      mapper.removeArticle(68, "1234");
	   }
	   
	   @Test
	   @Disabled
	   void replyTest() {
	      ArticleDTO article = ArticleDTO.builder()
//	                              .articleId(69)  //시퀀스
	                              .boardId(10)
	                              .writer("thursday")
	                              .subject("목요일 댓글 제목입니다.")
	                              .content("목요일 댓글 내용입니다.")
	                              .passwd("1234")
	                              .groupNo(1)
	                              .levelNo(0)
	                              .orderNo(1)
	                              .build();
	      ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
	      mapper.reply(article);
	   }
	   
	   /** 게시글 상세보기 테스트*/
	   @Test
	   @Disabled
	   void openArticleTest() {
	      List<ArticleDTO> opened = null;
	      ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
	      opened = mapper.openArticle(2);
	      assertThat(opened).isNotNull().hasSize(1);   
	    }


	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}
