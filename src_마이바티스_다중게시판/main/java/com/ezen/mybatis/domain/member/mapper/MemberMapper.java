package com.ezen.mybatis.domain.member.mapper;
import java.util.List;
import com.ezen.mybatis.domain.member.dto.Member;

/**
 * 데이터 베이스 회원 관리 명세
 *  @author 김기정
 */
public interface MemberMapper {
	
	public boolean create(Member member);
	public Member findByUser(String id, String passwd);
	public List<Member> findByAll();
	public Member findById(String id);
	
	
}
