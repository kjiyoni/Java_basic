package ezen.oop.array;

/*
 * 특정 파일이름을 전달받아 파일내용을 콘솔창에 출력하는 예제
 * java FilePrint xxxx.txt
 */
public class FilePrint {

	public static void main(String[] args) {
		//String[] args = { "xxxx.txt"};
		if(args.length != 1) {
			System.out.println("사용법: java FilePrint <파일명>");
			return;
		}
		
		String fileName = args[0];
		System.out.println("읽어들인 파일 이름: " + fileName);

	}

}
