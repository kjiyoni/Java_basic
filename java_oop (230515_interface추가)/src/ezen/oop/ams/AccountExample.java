package ezen.oop.ams;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account("김기정", 1111, 10000);
//		커맨드창에 출력하든 GUI 출력하든 웹 화면에 출력하게 출력하든 모든 재사용할 수 있다.
		System.out.println(account.toString());
		System.out.println(account);
		
		MinusAccount ma = new MinusAccount("김기정", 1111, 10000, 100000000);
		System.out.println(ma);

	}

}
