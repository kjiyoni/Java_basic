/*
 * 반복문 for
 */
public class ForExample {

	public static void main(String[] args) {
		for (int index = 0; index < 100; index++) { // int index는 딱 한번 실행되고 조건식,명령문,변수업데이트가 반복됨
			System.out.println("김지연 바보");
		} // for 블록안에서만 유효함

		// 밑for블록안에 index 선언은 위에 for블록과 다른것이므로 선언할 수 있음(만약 for블록 바깥에 index변수정의하면 오류남)
		int result = 0; // 스코프개념, 안에서 바깥은 적용 가능하므로 바깥에 선언해주어야함
		for (int index = 0; index <= 100; index++) {
			result += index;
		}
		System.out.println(result);

//		중첩for문을 이용한 사각형 출력
		for (int i = 0; i < 5; i++) { // 행 반복
			for (int j = 0; j < 5; j++) { // 열 반복, j에서 반복하고 다 실행되고나면 사라지는 스코프개념
				System.out.print('*'); // println은 라인이 바뀌므로 print로 수정 -> 하나로 쭉나열됨(행나눔이 없어서)
			}
			System.out.println(); // 아무조건도 주지않으면 줄바꿈, 개행됨
		}
		
		
		for (int i = 0; i < 10; i++) { // 행반복 
			for (int j = 9; j >= i; j--) {  // 열반복
				System.out.print((j+1) + " "); // 문자열로 지정, ' '문자는 숫자로 인식  
			}
			System.out.println(); 
		}
		
		
//		중첩for문을 활용한 구구단 출력
		for (int i = 2; i < 10; i++) { 
			for (int j = 1; j < 10; j++) {  
				System.out.print(i + "*" + j + "=" + (i*j) + "\t"); 
			}
			System.out.println(); 
		}
		
		
		
		
	}

}
