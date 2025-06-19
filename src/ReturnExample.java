/*
 * Return 이동문
 */
public class ReturnExample {

	public static void main(String[] args) {
		System.out.println("자바프로그램 종료됨...");
		
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				//break;
				//continue;
				return;
			}
			System.out.println(i);
	 	}
		System.out.println("자바프로그램 종료됨...");
	}         // return은 여기 대괄호 메소드 바깥으로 이동

}
