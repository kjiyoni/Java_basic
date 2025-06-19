package com.ezen.mybatis;

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

import com.ezen.mybatis.domain.board.dto.BoardDTO;
import com.ezen.mybatis.domain.board.mapper.BoardMapper;
import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import com.ezen.mybatis.domain.member.dto.Member;
import com.ezen.mybatis.domain.member.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardMapperTest {
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
	public void findAllTest() {
		System.out.println("==================== 전체 게시판 조회 ========================");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		log.debug("{}", mapper);
		List<BoardDTO> list = mapper.findAll();
		for (BoardDTO boardDTO : list) {
			System.out.println(boardDTO);
		}
	}

	@Test
	@DisplayName("게시판 생성")
	@Disabled
	public void createTest() {
		BoardDTO emp = new BoardDTO();
		emp.setCategory(1);
		emp.setTitle("테스트게시판");
		emp.setDescription("test");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.create(emp);
		log.debug("게시판 생성 완료 {}", emp);
	}

	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}
