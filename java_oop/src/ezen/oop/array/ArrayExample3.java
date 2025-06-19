package ezen.oop.array;

/*
 * 다차원 배열 사용하기
 */
public class ArrayExample3 {

	public static void main(String[] args) {
//		int[][] classes;
//		classes = new int[5][10];
//		classes[0][0] = 80;
//		//..
//		classes[0][9] = 100;
//		classes[4][0] = 99;
//		classes[4][4] = 50;
		
		int[][] classes = { {88, 95, 60, 77, 100, 55, 77}, 
							{85, 90, 60, 77, 100}, 
							{88, 90, 68, 77, 100, 60},
							{88, 90, 60, 90, 100},
							{88, 90, 70, 55, 100}};
		
		for (int i = 0; i < classes.length; i++) {
			System.out.println((i+1) + "반 성적 목록("+classes[i].length+"명)");
			double total = 0, avg = 0;
			for (int j = 0; j < classes[i].length; j++) {
				System.out.print(classes[i][j] + "\t");
				total += classes[i][j];
			}
			avg = total / classes[i].length;
			System.out.println();
			System.out.println((i+1)+ "반 총점 : " + total);
			System.out.println((i+1) + "반 평균 : " + avg);
			System.out.printf((i+1) + "반 평균 : " +  "%7.2f\n", avg);
		}
		
	}

}






