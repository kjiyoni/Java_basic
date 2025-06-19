/*
 * Label
 */
public class LableExample {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			OUT:    // 레이블 선언, 대문자로 쓰는게 관례
			for (int j = 0; j < 10; j++) {
				System.out.println(i + ", " + j);
				if(j==5) {
//					break;           그냥 브레이크만 쓰면 바깥 블록은 계속 실행됨
					break OUT;     //브레이크 다음에 레이블을 지정하면 레이블 선언되있는 바깥으로 이동하여 끝냄
				}
			}
	 	}
		
		
		
		
		
		
		
		
		
		
	}

}
