package com.ezen.springmvc.web.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.service.MemberService;
import com.ezen.springmvc.web.member.validator.MemberValidator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		Member member = Member.builder().build();
		model.addAttribute("member", member);
		return "member/register";
	}
	
	/*
	@PostMapping("/register")
	public String register(@ModelAttribute Member member, Model model) {
		log.info("회원 등록 정보 : {}", member.toString());
		memberService.register(member);
		//model.addAttribute("member", member);
		return "redirect:/member/"+member.getId();
	}
	*/
	
	/*
	// 회원 데이터 검증 -  #1. 개발자 직접 처리
	@PostMapping("/register")
	public String register(@ModelAttribute Member member, RedirectAttributes redirectAttributes, Model model) {
		// 데이터 검증 실패 메시지 저장을 위한 Map 생성
		Map<String, String> errors = new HashMap<String, String>();
		
		// 폼 필드 데이터 검증(스프링 제공 StringUtils 활용)
		if (!StringUtils.hasText(member.getId())) {
			errors.put("id", "아이디는 필수 입력 항목입니다.");
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				errors.put("id", "아이디는 6 ~ 12자 사이어야 합니다.");
			}
		}

		if (!StringUtils.hasText(member.getPasswd())) {
			errors.put("passwd", "비밀번호는 필수 입력 항목입니다.");
		}

		if (!StringUtils.hasText(member.getName())) {
			errors.put("name", "이름은 필수 입력 항목입니다.");
		}
		if (!StringUtils.hasText(member.getEmail())) {
			errors.put("email", "이메일은 필수 입력 항목입니다.");
		}
		
		// 특정 입력 필드가 아닌 복합적 데이터 검증 시
		// 예) 쇼핑몰 상품 주문 시 (주문갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 10000;
		if(totalPrice < 10000) {
			errors.put("global", "총 주문금액은 10,000원 이상이어야 합니다(현재 주문금액 = "+totalPrice+").");
		}
		// 데이터 검증 실패 시 회원가입 화면으로 Forward
		if (!errors.isEmpty()) {
			model.addAttribute("errors", errors);
			return "member/register";
		}
		
		// 데이터 검증 성공 시 DB 저장 후 상세 페이지로 리다이렉트
		memberService.register(member);
		
		// 회원 가입 후 보여주는 회원 상세 페이지 타이틀과 
		// 회원 정보 조회 시 보여주는 회원 상세 페이지 타이틀을 변경할 수 있도록 status 속성 추가
		redirectAttributes.addFlashAttribute("status", true);
		return "redirect:/member/" + member.getId();
	}
	*/
	
	// 회원 데이터 검증 -  #2. BindingResult 활용
	/*
	@PostMapping("/register")
	public String register(@ModelAttribute Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		// 폼 필드 데이터 검증(스프링 제공 StringUtils 활용)
		if (!StringUtils.hasText(member.getId())) {
			// 검증대상객체명, 검증실패 필드명, 오류 메시지
			// FieldError fieldError = new FieldError("member", "id", "아이디는 필수 입력 항목입니다.");
			FieldError fieldError = new FieldError("member", "id", member.getId(), false, null, null, "아이디는 필수 입력 항목입니다.");

			bindingResult.addError(fieldError);
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				// bindingResult.addError(new FieldError("member", "id", "아이디는 6 ~ 12자 사이어야 합니다."));
				bindingResult.addError(new FieldError("member", "id", member.getId(), false, null, null, "아이디는 6 ~ 12자 사이어야 합니다."));
			}
		}

		if (!StringUtils.hasText(member.getPasswd())) {
			// bindingResult.addError(new FieldError("member", "passwd", "비밀번호는 필수 입력 항목입니다."));
			bindingResult.addError(new FieldError("member", "passwd", member.getPasswd(), false, null, null, "비밀번호는 필수 입력 항목입니다."));
		}

		if (!StringUtils.hasText(member.getName())) {
			// bindingResult.addError(new FieldError("member", "name", "이름은 필수 입력 항목입니다."));
			bindingResult.addError(new FieldError("member", "name", member.getName(), false, null, null,  "이름은 필수 입력 항목입니다."));
		}
		if (!StringUtils.hasText(member.getEmail())) {
			// bindingResult.addError(new FieldError("member", "email", "이메일은 필수 입력 항목입니다."));
			bindingResult.addError(new FieldError("member", "email", member.getEmail(), false, null, null, "이메일은 필수 입력 항목입니다."));
		}
		
		// 특정 입력 필드가 아닌 복합적 데이터 검증 시
		// 예) 쇼핑몰 상품 주문 시 (주문갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 10000;
		if(totalPrice < 10000) {
			// bindingResult.addError(new ObjectError("member", "총 주문금액은 10,000원 이상이어야 합니다(현재 주문금액 = "+totalPrice+")."));
			bindingResult.addError(new ObjectError("member", null, null, "총 주문금액은 10,000원 이상이어야 합니다(현재 주문금액 = "+totalPrice+")."));
		}
		
		// 데이터 검증 실패 시 회원가입 화면으로 Forward
		if (bindingResult.hasErrors()) {
			// model.addAttribute("bindingResult", bindingResult);
			//자동 저장됨.
			return "member/register";
		}
		
		// 데이터 검증 성공 시 DB 저장 후 상세 페이지로 리다이렉트
		memberService.register(member);
		
		// 회원 가입 후 보여주는 회원 상세 페이지 타이틀과 
		// 회원 정보 조회 시 보여주는 회원 상세 페이지 타이틀을 변경할 수 있도록 status 속성 추가
		redirectAttributes.addFlashAttribute("status", true);
		return "redirect:/member/" + member.getId();
	}
	*/
	
	// 회원 데이터 검증 -  #2. BindingResult/오류메시지 파일 활용
	/*
	@PostMapping("/register")
	public String register(@ModelAttribute Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		// 폼 필드 데이터 검증(스프링 제공 StringUtils 활용)
		if (!StringUtils.hasText(member.getId())) {
			// FieldError fieldError = new FieldError("member", "id", member.getId(), false, new String[]{"required.member.id"}, null, null);
			// bindingResult.addError(fieldError);
			bindingResult.rejectValue("id", "required");
			
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				// bindingResult.addError(new FieldError("member", "id", member.getId(), false, new String[] {"range.member.id"}, new Object[] {6,12}, null));
				bindingResult.rejectValue("id", "range", new Object[]{6, 12}, null);
			}
		}

		if (!StringUtils.hasText(member.getPasswd())) {
			// bindingResult.addError(new FieldError("member", "passwd", member.getPasswd(), false, new String[] {"required.member.passwd"}, null, null));
			bindingResult.rejectValue("passwd", "required");
		}

		if (!StringUtils.hasText(member.getName())) {
			//bindingResult.addError(new FieldError("member", "name", member.getName(), false, new String[] {"required.member.name"}, null, null));
			bindingResult.rejectValue("name", "required");
		}
		if (!StringUtils.hasText(member.getEmail())) {
			//bindingResult.addError(new FieldError("member", "email", member.getEmail(), false, new String[] {"required.member.email"}, null, null));
			bindingResult.rejectValue("email", "required");
		}
		
		// 특정 입력 필드가 아닌 복합적 데이터 검증 시
		// 예) 쇼핑몰 상품 주문 시 (주문갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 10000;
		if(totalPrice < 10000) {
			//bindingResult.addError(new ObjectError("member", new String[]{"min.totalprice"}, new Object[]{10000, totalPrice}, null));
			bindingResult.reject("min.totalprice", new Object[]{10000, totalPrice}, null);
		}
		
		// 데이터 검증 실패 시 회원가입 화면으로 Forward
		if (bindingResult.hasErrors()) {
			// model.addAttribute("bindingResult", bindingResult);
			//자동 저장됨.
			return "member/register";
		}
		
		// 데이터 검증 성공 시 DB 저장 후 상세 페이지로 리다이렉트
		memberService.register(member);
		
		// 회원 가입 후 보여주는 회원 상세 페이지 타이틀과 
		// 회원 정보 조회 시 보여주는 회원 상세 페이지 타이틀을 변경할 수 있도록 status 속성 추가
		redirectAttributes.addFlashAttribute("status", true);
		return "redirect:/member/" + member.getId();
	}
	*/
	
	
	/*
	private final MemberValidator memberValidator;
	
	@InitBinder
	public void initDataBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(memberValidator);
	}
	*/
	
	// 회원 데이터 검증 -  #3. 검증 로직 별도 클래스 분리
	/*
	@PostMapping("/register")
	public String register(@Validated @ModelAttribute Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		// 데이터 검증 실패 시 회원가입 화면으로 Forward
		if (bindingResult.hasErrors()) {
			// model.addAttribute("bindingResult", bindingResult);
			//자동 저장됨.
			return "member/register";
		}
		
		// 데이터 검증 성공 시 DB 저장 후 상세 페이지로 리다이렉트
		memberService.register(member);
		
		// 회원 가입 후 보여주는 회원 상세 페이지 타이틀과 
		// 회원 정보 조회 시 보여주는 회원 상세 페이지 타이틀을 변경할 수 있도록 status 속성 추가
		redirectAttributes.addFlashAttribute("status", true);
		return "redirect:/member/" + member.getId();
	}
	*/
	
	// 회원 데이터 검증 -  #3. Bean Validation 사용
	@PostMapping("/register")
	public String register(@Validated @ModelAttribute Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		// 특정 입력 필드가 아닌 복합적 데이터 검증 시
		// 예) 쇼핑몰 상품 주문 시 (주문갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 10000;
		if(totalPrice < 10000) {
			bindingResult.reject("min.totalprice", new Object[]{10000, totalPrice}, null);
		}
		
		// 데이터 검증 실패 시 회원가입 화면으로 Forward
		if (bindingResult.hasErrors()) {
			// model.addAttribute("bindingResult", bindingResult);
			//자동 저장됨.
			return "member/register";
		}
		
		// 데이터 검증 성공 시 DB 저장 후 상세 페이지로 리다이렉트
		memberService.register(member);
		
		// 회원 가입 후 보여주는 회원 상세 페이지 타이틀과 
		// 회원 정보 조회 시 보여주는 회원 상세 페이지 타이틀을 변경할 수 있도록 status 속성 추가
		redirectAttributes.addFlashAttribute("status", true);
		return "redirect:/member/" + member.getId();
	}
	
	
	@GetMapping("/{id}")
	public String read(@PathVariable("id") String id, Model model) {
		log.info("회원 상세 요청");
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);
		return "member/read";
	}
	
	@GetMapping("")
	public String list(Model model) {
		log.info("회원 목록 요청");
		List<Member> list = memberService.getMemberList();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") String id, Model model) {
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);
		return "member/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute Member member, Model model) {
		log.info(member.toString());
		memberService.editMember(member);
		return "redirect:/member/"+member.getId();
	}
}





