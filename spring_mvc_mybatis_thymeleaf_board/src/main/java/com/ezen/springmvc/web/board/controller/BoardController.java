package com.ezen.springmvc.web.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("")
public class BoardController {

	private final BoardService boardService;
	
//	@GetMapping("")
//	public String register(Model model) {
//		return "";
//	}
	
	@GetMapping("")
	public String list(Model model) {
		
		List<BoardDTO> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "index";
	}
	
}
