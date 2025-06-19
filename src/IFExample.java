/*
 * 조건(분기)문 if
 */
public class IFExample {

	public static void main(String[] args) {
		int score = 88;
//		단순 if문
		if(score >= 60) {
			System.out.println("참 잘했어요!"); // 한줄짜리면 {}생략가능하지만, 가독성때문에 무조건 {}써주기!
		}
		
//		if ~ else ~ 
		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		String result = score >= 60 ? "합격" : "불합격"; // 조건삼항연산자 (if else 줄여쓰는 형식)
		System.out.println(result);

//		퀴즈 (홀수 짝수 출력)
		int num = 56;
		if ((num % 2) == 0) {            // num % 2에 ()를 써주는게 좋음! 가독성을 위해서..
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		
//		다중 if문 (조건을 여러번 체크하는 것 ex. 수우미양가 점수 매길 때)
		if (score >= 90) {
			System.out.println("수");
		} else if(score >= 80) {
			System.out.println("우");
		} else if(score >= 70) {
			System.out.println("미");
		} else if(score >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}
		
		
		
	}

}
