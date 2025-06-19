package com.ezen.sample2;

import java.util.Date;

import com.ezen.sample.Lecture;
//import com.ezen.sample.*;

public class PackageExample {

	public static void main(String[] args) {
		Lecture lecture = new Lecture("풀스택");
//		com.ezen.sample.Lecture lecture = new com.ezen.sample.Lecture("풀스택");
		lecture.printName();
		Date today = new Date();
		System.out.println(today.toLocaleString());
		
		// 자바 표준 API의 java.lang는 기본패키지이므로 import 하지 않아도 됨..
		String message;
		
	}

}






