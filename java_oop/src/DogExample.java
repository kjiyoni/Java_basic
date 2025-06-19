/*
 * 애플리케이션(Main) 클래스
 */
public class DogExample {

	public static void main(String[] args) {
		
		// 위치상 지역변수, 기본데이터타입
		int age = 50;
		
		// 메모리상에 Dog 인스턴스 생성
		// 위치상 지역변수, 레퍼런스데이터타입
		Dog dog;
		// 디폴트 생성자 호출을 이용한 인스턴스 생성
		dog = new Dog();
		System.out.println(dog.getName());
		System.out.println(dog.getType());
		System.out.println(dog.getAge());
		
		// 인스턴스의 속성(상태) 변경
//		dog.name = "루니";
//		dog.type = "비숑";
//		dog.age = 8;
		dog.setName("루니");
		dog.setType("비숑");
		dog.setAge(8);
		
		dog = new Dog("루니", "비숑", 8);
		
		System.out.println(dog.getName());
		System.out.println(dog.getType());
		System.out.println(dog.getAge());
		dog.bark();
		
		/*
		Dog dog2 = new Dog();
		dog2.name = "복돌이";
		dog2.type = "믹스";
		dog2.age = 16;
		dog2.eat();	
		
		Dog dog3 = new Dog("메리", "진도개");
		System.out.println(dog3.name);
		System.out.println(dog3.type);
		System.out.println(dog3.age);
		*/

	}

}








