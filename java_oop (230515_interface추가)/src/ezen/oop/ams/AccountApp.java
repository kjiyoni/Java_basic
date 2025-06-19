package ezen.oop.ams;

/**
 * 1차원 배열을 이용한 계좌 목록 관리
 */
public class AccountApp {

	public static void main(String[] args) {
		Account[] accounts = new Account[100];
		
		int index = 0;
//		새로운 계좌 등록(개설)
		Account account = new Account("김기정", 1111, 100000);
		accounts[index++] = account;
		
		Account account2 = new Account("이희영", 1111, 1000000);
		accounts[index++] = account2;
		
		Account account3 = new Account("강소영", 1111, 10000000);
		accounts[index++] = account3;
		
		System.out.println("---- 전체계좌 조회 -----");
//		전체계좌 목록 조회
		for (int i = 0; i < index; i++) {
			accounts[i].printInfo();			
		}
		
		System.out.println("---- 계좌 번호 검색 결과 -----");
		
//		계좌번호로 계좌 검색
		String searchName = "1001";
		for (int i = 0; i < index; i++) {
			if(accounts[i].getAccountNum().equals(searchName)) {
				accounts[i].printInfo();
			}
		}
		
	}

}














