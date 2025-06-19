package ezen.oop.interfacee;

public class WeaponExample {

	public static void main(String[] args) {
//		인터페이스는 추상클래스처럼 객체 생성 X
//		그러나 타입선언은 가능하다...
		
//		Weapon weapon = new Gun();
//		weapon.attack();
//		
//		weapon = new Sword();
//		weapon.attack();
//		
//		weapon = new Club();
//		weapon.attack();
		
		Unit unit = new Unit("maine", new Gun());
		unit.offence();
		unit.offence();
		unit.offence();
		unit.offence();
		
		unit.setWeapon(new Sword());
		unit.offence();
		unit.offence();
		unit.offence();
		
		unit.setWeapon(new Club());
		unit.offence();
		unit.offence();
		unit.offence();
		
		
		

	}

}






