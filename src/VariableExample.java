class VariableExample {
	public static void main(String[] args) {
		// 변수는 프로그램에서 사용하는 데이터를 저장하기 위한 메모리 공간
		// 변수를 사용하는 목적은 데이터를 재사용하기 위해서
		// 변수 선언 (String: 문자열, int: 정수, double: 실수) (변수에 최초로 값이 대입되면 메모리 할당, 메모리에 값 저장 (변수 초기화))
		String name;
		int age;
		double weight;

		// 변수 초기화
		name = "김지연";
		age = 30;
		weight = 67.8;

		// 변수 사용		
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);

		// 변수의 값 수정(Update)
		name = "홍길동";
		age = 40;
		weight = 68.5;

		System.out.println(name);
		System.out.println(age);

		int age2;
		// 변수에 변수의 값 할당
		age2 = age;
		System.out.println(age2);

		// 변수선언과 할당을 동시에...
		int score = 95;

		int a = 10, b= 20, c= 30, d= 40, e= 50;
		System.out.println(e);

		// 초기화 되지 않은 변수는 사용할 수 없다.
		int x = 100;
		System.out.println(x);

		String firstName = "지연"; // 카멜표기법 권장 (first_name 스네이크 표기법, C언어에서 관례로 많이 사용)
		String lastName = "김";

		// 자바 예약어(키워드)는 변수명으로 사용할 수 없다.
		// int this; 하면 에러남

		String 이름 = "홍길동"; // 변수이름을 한글로 사용할 수 있지만 비권장
		System.out.println(이름);

	}
}
