/*
 * 작성일 : 2024년 5월 31일
 * 작성자 : 컴퓨터소프트웨어공학부 202095061 유재현
 * 설명 :  문제: Animal 클래스를 작성하세요
 * 			이 클래스는 다음과 같은 필드를 가집니다.
 * 			protected String name
 * 			protected int age
 * 		
 * 			Animal 클래스는 다음과 같은 메소드를 가집니다.
 * 			기본 생성자 : 이름을 "", 나이를 0으로 초기화합니다
 * 			매개변수 생성자 : 이름과 나이를 입력받아 초기화합니다
 * 			
 * 			printInfo() 메소드 : 동물의 이름과 나이를 출력합니다
 * 
 * 			---------------
 * 			Animal 클래스를 상속하는 Dog 클래스를 작성하세요
 * 			이 클래스는 다음과 같은 필드를 추가로 가집니다.
 * 			private String breed
 * 			
 * 			Dog 클래스는 다음과 같은 메소드를 가집니다.
 * 			기본 생성자 : 부모 클래스의 기본 생성자를 호출하고, breed를 ""으로 초기화합니다.
 * 			매개변수 생성자 : 이름, 나이, 품종을 입력받아 초기화합니다.
 * 
 * 			printInfo() 메소드 : 부모 클래스의 printInfo() 메소드를 호출하고, 품종을 추가로 출력합니다.
 * 
 * 			------------------
 * 			
 * 			AnimalTest1 클래스
 * 			main 메소드 : 강아지 이름과 나이, 품종을 입력 받습니다.
 * 			Dog 클래스로부터 객체를 생성하여 결과를 출력하세요
 * 
 * 			
 * 			[출력결과]
 * 			강아지 이름을 입력하세요 : 모카
 * 			강아지 나이를 입력하세요 : 3
 * 			강아지 품종을 입력하세요 : 말티즈
 * 
 * 			Name = 모카, Age = 3, 품종 = 말티즈
 */

import java.util.Scanner;
class Animal{
	protected String name;
	protected int age;
	
	public Animal() {
		this.name = "";
		this.age = 0;
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("Name : " + name + ", Age : " + age);
		// System.out.print("Name : " + name + ", Age : " + age);
	}
}

// 상속
class Dog extends Animal{
	
	private String breed;
	
	// 매개변수가 없는 생성자.
	public Dog() {
		// 상위 클래스의 기본생성자 호출 ( 쓰지 않아도 하위 기본생성자를 호출하면 상위 기본생성자 호출된다 )
		super();
		
		this.breed = "";
	}
	public Dog(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.breed = breed;
	}
	
	@Override
	public void printInfo() {
		// super.printInfo();
		//System.out.println(", 품종 : " + breed);
		System.out.println("강아지 이름 : " + name + ", 나이 : " + age + ", 품종 : " + breed);
	}
	
}
public class AnimalTest1 {

	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("강아지 이름 입력 : ");
		String name = stdIn.next();
		System.out.print("강아지 나이 입력 : ");
		int age = stdIn.nextInt();
		System.out.print("강아지 품종 입력 : ");
		String breed = stdIn.next();

		Dog dog = new Dog(name, age, breed);
		
		dog.printInfo();
	}

}
