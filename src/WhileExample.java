/*
 * 반복문 while
 */
public class WhileExample {

	public static void main(String[] args) {
        // while 바깥에서 조건을 만들어주기
		int index = 0;              // 대부분 순서를 나타낼때 index는 0부터 나타냄!
		while (index < 100) {
			System.out.println("김지연 바보!!!");
			index++;              // 인덱스가 1로 바뀌게하여 무한루프 멈추게하기
		}
		
		// System.out.println(1+2+3+4+5+6+7+8+9+10);
		
		int result = 0;
		index = 1;
		while (index <= 100) {
//			result = result + index;
			result += index;
			index++;
		}
		System.out.println("누적합 : " + result);

		
		
//		홀수합, 짝수합 나오게하기		
		int oddSum = 0, evenSum = 0;
		index = 1;
		while (index <= 100) {          
			if( (index % 2) == 0 ) {
					evenSum += index;
				}else {
					oddSum += index;
				}
			
				index++;
		 }
		System.out.println("누적합 : " + result);
		System.out.println("홀수합 : " + oddSum);
		System.out.println("짝수합 : " + evenSum);
	
		
		
//      do while문
		index = 0;	
		do {
			System.out.println("풀스택 웹 개발자과정 화이팅!!!!!!");
			index++;
		} while (index < 100);
			
			
	}

}
