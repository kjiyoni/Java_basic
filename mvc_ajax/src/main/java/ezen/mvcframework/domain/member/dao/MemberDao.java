package ezen.mvcframework.domain.member.dao;

import java.util.List;

import ezen.mvcframework.domain.member.dto.Member;

/**
 * 데이터 베이스 회원 관리 명세
 *  @author 김기정
 *
 */
public interface MemberDao {
	
	public boolean create(Member member);
	public Member findByUser(String id, String passwd);
	public List<Member> findByAll();
	public boolean findById(String id);
	
	
}
