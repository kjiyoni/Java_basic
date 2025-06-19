package com.ezen.mybatis.domain.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ezen.mybatis.domain.member.dto.Member;

/**
 * 데이터 베이스 회원 관리 명세 (2023-08-08)
 *  @author 이희영
 */
public interface MemberMapper {
	
	public boolean create(Member member);
	public Member findByUser(@Param("id") String id, @Param("passwd") String passwd);
	public List<Member> findByAll();
	public Member findById(String id);
}