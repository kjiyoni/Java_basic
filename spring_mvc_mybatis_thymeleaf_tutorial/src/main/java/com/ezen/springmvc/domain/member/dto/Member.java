package com.ezen.springmvc.domain.member.dto;

import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	@NotBlank(message = "아이디는 필수 입력 항목입니다.")
	@Range(min = 6, max = 12)
	private String id;
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	private String passwd;
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	private String name;
	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	private String email;
	@NotBlank
	private String regdate;
}





