/*
 * 자바에서 지원하는 연산자들
 */
public class OperatorExample {

	public static void main(String[] args) {
		int x = 30, y = 5;
		
		// 산술연산자
		System.out.println("합 = " + (x + y));
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y); // 나머지 연산자
		
//		+ 연산자 오버로딩(중복정의)
		System.out.println(10 + 50); // 덧셈기능
		System.out.println("김지연" + "바보"); // 연결기능
		System.out.println(10 + "바보"); // 숫자 10이 문자형으로 변형 후 연결됨
		System.out.println(10 + 30 + "바보"); // 좌에서 우 순서로 10 + 30 먼저 진행 덧셈기능, 40으로 만들어진 후 문자형 연결
		System.out.println("바보" + 10 + 30); // 좌우순서대로 형 변환됨
		System.out.println("바보" + (10 + 30)); // ( ) : 소괄호 우선순위 연산자
		
		
//		복합대입연산자 (+=, -=, *=, /=, %=)
//		x = x + 5;
		x += 5;    
		x -= 5;
		x *= 5;
		System.out.println(x);
		
		x = 10;     // 기존 변수 값을 수정함 (선언x)
		y = 5;
//		비교연산자 (==, !=, >, >=, .....)
		System.out.println(x == y);
		System.out.println(x != y);
		System.out.println(x > y);
		System.out.println(x >= y);
		
		
//		증감연산자 (++,--)
//		x = x +1;
//		x += 1;
		x++;  // 어떠한 변수값에 숫자 1을 증가시키고 싶을 때 사용
		System.out.println(x);
		x--;  // 어떠한 변수값에 숫자 1을 감소시키고 싶을 때 사용
		System.out.println(x);
		
		x = 10;
		System.out.println(x++); //++하기전에 출력되고 있어 10으로 뜸
		System.out.println(++x); //x값을 먼저 증가시켜놓고 출력
		
		x = 30;
		y = 50;
		
		System.out.println(x >=30 && y <=50);
		System.out.println(x < 30 && y <=50);
		System.out.println(x < 30 || y <=50);
		System.out.println(!true);
		
//		조건삼항연산자
		int score = 55;
		String result = score >=60 ? "통과" : "실패";
		System.out.println(result);
		
//		기본데이터타입 형변환
//		자동형변환(Promotion - Up Casting)
		double some = 50.0; 
		
//		강제형변환(Demotion - Down Casting)
		double avg = 85.34567;   // 큰걸 작게 만들어서 연산, 데이터손실발생 염려가있음
		// 소수점 이하는 잘라내고 정수 85만 출력하고 싶을 때 강제형변환 사용
		System.out.println(avg);
		System.out.println((int)avg); // 더블형을 인트타입으로 잘라내서 화면에 출력해주세요 라는 것
		
		int avg2 = (int)avg;   //avg는 int형 avg;는 더블형이라서 동일한 인트형으로 (int) 만들어주기 
		System.out.println(avg2);
		
	}

}








