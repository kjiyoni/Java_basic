package ezen.mvcframework.web.ajax.controller;

import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;
// /ajax/books
public class BookListController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "ajax/books";
		return viewName;
	}
	
	

}
