/*
 * 조건(분기)문 switch
 */
public class SwitchExample {

	public static void main(String[] args) {
		int num = 7;
		switch (num) {                                         // switch (key)는 num 변수인 15가 들어감
			case 1: System.out.println("1입니다."); break;      // break;는 이동문 = 중괄호(블록)바깥으로 이동하시오라는 뜻, break를 일부러 뺄수도 있음(예제에서 case 2까지 비교하고싶을 시)
			case 2: System.out.println("2입니다."); break;      // if문과 동작원리가 달라 일치하는 값이 발견되도 순차적으로 실행하기때문에 뒤에 break;를 써주어야 함!, default뒤에는 break 쓰지않음
			case 3: System.out.println("3입니다."); break;
			case 4: System.out.println("4입니다."); break;
			case 5: System.out.println("5입니다."); break;
			default: System.out.println("일치하는 값이 없습니다.");
		}
		
		char some = 'a';         // 실수는 오류남, case절에 사용할 수 없음!
		switch (some) {
		case 'a': System.out.println("1입니다.");     
		case 'b': System.out.println("2입니다."); break;     
		case 'c': System.out.println("3입니다."); break;     
		case 'd': System.out.println("4입니다."); break;     
		case 'f': System.out.println("5입니다."); break;     
		default: System.out.println("일치하는 값이 없습니다.");
	    }
		
		System.out.println(95/10);
			

		int score = 88;
		switch (score/10) {    // score에 나누기 연산자 사용해야함
			case 10 :          // System.out.println("수"); 생략가능
			case 9 : System.out.println("수"); break;
			case 8 : System.out.println("우"); break;
			case 7 : System.out.println("미"); break;
			case 6 : System.out.println("양"); break;
			default: System.out.println("가"); break;
		}
		
//		사칙연산자의 결과값을 보여줄 때 (switch문으로 사용하기 좋음)
		int x = 50, y = 30;
		char operator = '+';
		switch (operator) {
			case '+': System.out.println("덧셈 = " + (x + y)); break;   // + - 동등이므로 ()우선순위 지정해주기
			case '-': System.out.println("뺄셈 = " + (x - y)); break;
			case '*': System.out.println("곱셈 = " + (x * y)); break;
			case '/': System.out.println("나눗셈 = " + (x / y)); break;
		}
		
		

		
	}

}
