package ezen.mvcframework.web.ajax.controller;

import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;
// /ajax/books-action
public class BookListActionController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "ajax/books-action";
		// DB 연동 편의상 생략
		//List<Book> list = ???;
		return viewName;
	}
	
	

}
