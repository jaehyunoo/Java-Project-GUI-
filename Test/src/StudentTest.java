/*
 * 작성일 : 2024년 6월 4일
 * 작성자 : 컴퓨터소프트웨어공학부 202095061 유재현
 * 설명 :  문제 : Person 클래스를 작성하세요
 * 		이 클래스는 다음과 같은 속성을 가집니다.
 * 		String name
 * 
 * 		Person 클래스는 다음과 같은 메소드를 가집니다.
 * 		기본 생성자 : 이름을 "홍길동"으로 초기화합니다.
 * 		매개변수 생성자 : 이름을 입력받아 초기화합니다.
 * 		printinfo()메소드 : 사람의 이름을 출력합니다
 * 
 * 		Person 클래스를 상속하는 Student 클래스를 작성하세요.
 * 		이 클래스는 다음과 같은 속성을 추가로 가집니다.
 * 		String major
 * 	
 * 		Student 클래스는 다음과 같은 메소드를 가집니다.
 * 		기본 생성자 : 부모 클래스의 기본 생성자를 호출하고, major를 " 기계공학과 " 로 초기화합니다.
 * 		매개변수 생성자 : 이름과 전공을 입력받아 초기화합니다.
 * 		printInfo() 메소드 : 부모 클래스의 printInfo() 메소드를 호출하고, 전공을 추가로 입력합니다
 */

import java.util.Scanner;
class Person{
	String name;
	
	// 기본생성자 이름 홍길동으로초기화
	public Person() {
		this.name = "홍길동";
	}
	// 매개변수 생성자 입력받은값을 이름으로지정
	public Person(String name) {
		this.name = name;
	}
	
	public void printinfo() {
		System.out.println("이름 : " + this.name);
	}
}

class Students extends Person{
	String major;
	// 기본 생성자 부모(Person) 클래스의 기본생성자를 가져와서 이름을 가져온뒤 major값 기계공학과로 초기화
	public Students() {
		super();
		this.major = "기계공학과";
	}
	// 매개 변수 생성자 Person의 매개변수 생성자의 이름의 값을 불러오고 major값 입력받아 저장
	public Students(String name, String major) {
		this.name = name;
		this.major = major;
	}
	
	// 부모(Person) 클래스의 printinfo()를 오버라이드해서 재정의
	@Override
	public void printinfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("전공 : " + this.major);
	}
}
public class StudentTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("이름을 입력하시오 : ");
		String name = stdIn.next();
		System.out.print("학과을 입력하시오 : ");
		String major = stdIn.next();
		
		// Students의 기본생성자 객체생성
		Students stu1 = new Students();
		stu1.printinfo();
		
		// Students의 매개변수생성자 객체생성
		Students stu2 = new Students(name,major);
		stu2.printinfo();
		
		
		
		
		

	}

}
