package ezen.oop.ams;

import java.util.Scanner;

public class AMS2 {
	
	private static AccountRepository repository = new AccountRepository();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("*****************************************");
		System.out.println("** "+Account.BANK_NAME+"은행 계좌 관리 애플리케이션 **");
		System.out.println("*****************************************");
		
		boolean run = true;
		
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.입금|4.출금|5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 1) {
				// 계좌 생성 및 등록
				createAccount();
			} else if (selectNo == 2) {
				// 계좌목록
			} else if (selectNo == 3) {
				// 입금
			} else if (selectNo == 4) {
				// 출금
			} else if (selectNo == 5) {
				run = false;
			}
		}
		scanner.close();
		System.out.println("계좌관리 애플리케이션을 종료합니다.");
	}
	
	/**
	 * 키보드(표준입력)로부터 계좌정보 입력 받아 계좌생성하기
	 */
	private static void createAccount() {
		System.out.print("예금주명: ");
		String owner = scanner.nextLine();

		System.out.print("비밀번호: ");
		int passwd = Integer.parseInt(scanner.nextLine());
		
		System.out.print("입금액: ");
		long inputMoney = Long.parseLong(scanner.nextLine());
		
		Account account =new Account(owner, passwd, inputMoney);
		
		// AccountRepository에 계좌등록
		repository.addAccount(account);
		System.out.println("※ 계좌 정상 등록 처리되었습니다.");
	}

}








