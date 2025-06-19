import ezen.oop.ams.Account;

/*
 * Call by Value 개념
 */
public class CallByValueExample {
	
	public static int sum(int x, int y) {
		x += 50;
		return x + y;		
	}
	
	public static void doTask(Account account) {
		account.deposit(500000);
	}
	
	public static void main(String[] args) {
		int x = 50, y = 60;
		// Call by Value
		int result = sum(x, y);
		System.out.println(result);
		System.out.println(x);
		
		Account account = new Account("김기정", 1111, 10000);
		// Call by Value
		doTask(account);
		long restMoney = account.getRestMoney();
		System.out.println("현재잔액: " + restMoney);
	}

}
