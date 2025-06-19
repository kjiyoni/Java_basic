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

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import com.ezen.mybatis.domain.member.dto.Member;
import com.ezen.mybatis.domain.member.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberMapperTest {
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
	@Disabled
	public void findAllTest(){
		System.out.println("==================== 전체 고객 조회 ========================");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		log.debug("{}", mapper);
		List<Member> list = mapper.findAll();
		for (Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	@Disabled
	public void findByIdTest(){
		System.out.println("==================== 아이디로 고객 조회 ========================");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		Member member = mapper.findById("bangry");
		log.debug("검색된 고객 : {}", member);
	}
	
	@Test
	public void findByNameTest(){
		log.debug("==================== 이름으로 고객 조회 ========================");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		List<Member> findMembers = mapper.findByName("E");
		findMembers.forEach( member -> {
			log.debug("검색된 고객 : {}", member);
		});
	}
	/*
	@Test
	@DisplayName("사원 등록")
	public void createTest(){
		Employee emp = new Employee();
		emp.setFirstName("JeongHwan");
		emp.setLastName("Hyun");
		emp.setEmail("hjh@gmail.com");
		emp.setPhoneNumber("010.4541.9541");
		emp.setHireDate("2023-01-01");
		emp.setJobId("IT_PROG");
		emp.setSalary(50000);
		emp.setManagerId(150);
		emp.setDepartmentId(60);
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		mapper.create(emp);
		log.debug("사원등록완료 : {}", emp);
	}
	*/
	@AfterEach
	public void destory() {
		sqlSession.close();
	}
}







