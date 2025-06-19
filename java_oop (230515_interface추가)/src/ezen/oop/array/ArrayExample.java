package ezen.oop.array;

public class ArrayExample {

	public static void main(String[] args) {
		//int score1, score, ,,,,,,,,,,
		// 기본타입 배열 선언
		int[] scores;   // Account array;
		
		// 배열 인스턴스(객체) 생성
		scores = new int[30];
		// 배열 원소 접근
		System.out.println(scores[0]);
		scores[0] = 95;
		scores[1] = 50;
		//.......
		scores[26] = 100;
		System.out.println(scores[26]);
		
		double total = 0;
		for(int i = 0; i < scores.length; i++ ) {
			scores[i] = (70 + i);
			System.out.println(scores[i]);
			total += scores[i];	
		}
		
		double avg = total/scores.length;
		
		System.out.println("우리반 점수 총점: " + total);
		System.out.println("우리반 점수 평균: " + avg);

	}

}






