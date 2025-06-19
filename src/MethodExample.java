import java.util.Iterator;

/*
 * 메소드(함수) 정의 및 사용
 */
public class MethodExample {

    /*
     * 구구단을 출력하는 메소드 정의
     */
	static void printGugudan() {
		for (int i = 2; i < 10; i++) { 
			for (int j = 1; j < 10; j++) {  
				System.out.print(i + "*" + j + "=" + (i*j) + "\t"); 
			}
			System.out.println(); 
		}
	}   // 하나의 실행코드 블럭(메소드 1개 생성), 계속 재사용하고싶어서, void는 반환할값이 없다는 데이터타입
	
	/*
	 * 단을 입력받아 해당 단을 출력하는 기능
	 */
	static void printDan(int dan) {
		for (int i = 1; i < 10; i++) {
			System.out.print(dan + " * " +i+ " = " + (dan *i) + "\t");
		}
		System.out.println();
	}
	
	/*
	 * 두개의 정수를 전달받아 해당 정수의 합을 반환하는 기능 (반환값이 있는 메소드)
	 */
	static int sum(int x, int y) {   
//		return;
		return x + y;          // 리턴 다음에 결과값인 x+y;가 호출한쪽으로 반환되면서 쫑남
	}
	
	
	public static void main(String[] args) {
		System.out.println("구구단 출력하기");
		// 구구단 출력 메소드 사용(호출)
		printGugudan();    // static을 넣어 오류를 없앴음(나중에 static 개념 이해)
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		printGugudan();    // 필요할 때 호출하면 재사용 가능
		
//		5단 출력
		printDan(5);  // 5를 전달인자(Argument)
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		printDan(7);                      // 리턴타입이 없는 함수 호출
		
//		리턴타입이 있는 함수 호출	
		int x = 500, y = 4545454;
		int result = sum(x, y);           // 새로운 변수에 직접 반환 값 넣고
		System.out.println(result);       // 결과 출력 
		
		System.out.println(sum(5, 10));   // 직접 전달인자 입력 후 반환받아 출력
		
	}

}
