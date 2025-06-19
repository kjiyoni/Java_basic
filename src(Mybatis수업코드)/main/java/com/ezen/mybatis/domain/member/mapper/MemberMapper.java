package com.ezen.mybatis.domain.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.mybatis.domain.member.dto.Member;

/**
 * DB 회원 관리 명세
 * @author 현정환
 *
 */
public interface MemberMapper {

	public boolean create(Member customer);
	public Member findByUser(@Param("id") String id, @Param("passwd") String passwd);
	public List<Member> findAll();
	public Member findById(String id);
	public List<Member> findByName(String name);
}

	



