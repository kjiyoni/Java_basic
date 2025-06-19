package com.ezen.mybatis.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 쇼핑몰 회원가입 한 회원에 대한 재사용 가능한 컴포넌트
 * @author 현정환
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regDate;
	

}













