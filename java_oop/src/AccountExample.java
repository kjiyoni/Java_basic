import ezen.oop.ams.Account;

// java AccountExample
public class AccountExample {

	public static void main(String[] args) {
		// 계좌개설
		Account account = new Account();
		//account.accountNum = "1111-2222-3333-4444";
		account.setAccountNum("1111-2222-3333-4444");
		
		//account.accountOwner = "김기정";
		account.setAccountOwner("김기정");
		
		//account.passwd = 1234;
		account.setPasswd(1234);
		//account.restMoney = 10000;
		account.setRestMoney(10000);
		
		// 개설된 계좌의 기능 사용
		if(account.checkPasswd(1111)) {
			long money = account.getRestMoney();
			System.out.println("현재잔액: " + money);
			
			long  restMoney = account.deposit(1000000000L);
			System.out.println("입금 후 잔액 : " + restMoney);
			
			System.out.println("출금 후 잔액 : " + account.withdraw(5000000L));
		} else {
			System.out.println("비밀번호를 확인하세요...");
		}
		
//		스태틱변수는 클래스이름으로 접근 가능하다.
//		Account.bankName = "이젠은행";
		System.out.println(Account.BANK_NAME);
		
		Account a1 = new Account("김기정", 1111, 1000);
		Account a2 = new Account("이기정", 1111, 1000);
		Account a3 = new Account("박기정", 1111, 1000);
		System.out.println(a1.getAccountNum());
		System.out.println(a2.getAccountNum());
		System.out.println(a3.getAccountNum());
		
//		스태틱메소드도 스태틱변수처럼 인스턴스 생성 없이 
//		클래스이름으로 바로 접근하여 사용할 수 있다.
		System.out.println(Account.getAccountId());
		
		

	}

}
