package com.ezen.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import com.ezen.mybatis.domain.member.dto.Member;
import com.ezen.mybatis.domain.member.mapper.MemberMapper;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 * MapperTest (2023-08-08)
 * @author 이희영
 */
@Slf4j
public class MemberMapperTest {
	private static final String namespace = "com.ezen.mybatis.domain.member.mapper.MemberMapper";
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
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@Test
	@DisplayName("회원 등록")
	@Disabled
	public void createTest() {
		Member member = Member.builder()
							  .id("heeyeong5")
							  .passwd("1111")
							  .name("이희영")
							  .email("heeeyong5@gmail.com")
							  .build();
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.create(member);
		log.debug("회원등록 완료 : {}", member);
	}
	
	@Test
	@DisplayName("아이디, 비밀번호로 회원 조회")
	public void findByUserTest() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Member member = mapper.findByUser("heeyeong2", "1111");
		log.debug("회원 조회 : {}", member);
	}
	
	@Test
	@DisplayName("전체 회원 조회")
	@Disabled
	public void findByAllTest() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		List<Member> members = mapper.findByAll();
		log.debug("{}", members);
	}
	
	@Test
	@DisplayName("아이디로 회원 조회")
	@Disabled
	public void findByIdTest() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Member member = mapper.findById("heeyeong2");
		log.debug("회원 조회 : {}", member);
	}
	
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}