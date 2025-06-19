package ezen.oop.array;

/*
 * 학생정보 추상화/캡슐화
 */
public class Student {
	
	public static final String SCHOOL_NAME = "이젠초등학교";
	
	private int no;
	private String name;
	private int score;
	
	public Student() {}
	
	public Student(int no, String name, int score) {
		this.no = no;
		this.name = name;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
//	학생 모든 정보 출력 기능
	public void printInfo() {
		System.out.println(no + "\t" + name + "\t" + score);
	}
	
}










