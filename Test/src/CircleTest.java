/*
 * 작성일 : 2024년 6월 4일
 * 작성자 : 컴퓨터소프트웨어공학부 202095061 유재현
 * 설명 :  문제 : Shape 클래스를 작성하고 이를 상속받는 Circle 클래스를 작성하세요.
 * 		Shape 클래스에는 String color 속성을 추가하고, 이를 설정하는 생성자를 작성합니다.
 * 		Circle 클래스는 Shape 클래스를 상속받고,  double radius 속성을 추가하여 이를
 * 		설정하는 생성자를 작성합니다.
 * 		Circle 클래스에 원의 면적과 둘레를 계산하는 메소드를 작성합니다.
 * 
 * 		사용자로부터 원의 반지름과 색상을 입력받아, 해당 원의 정보를 출력하는 프로그램을 작성하시오.
 * 		
 * 		[출력결과]
 * 		원의 색상을 입력하세요 : 빨강
 * 		원의 반지름을 입력하세요 : 10
 */
import java.util.Scanner;

class Shape{
	String color;
	
	public Shape() {
		this.color = "무색";
	}
	
	public Shape(String color) {
		this.color = color;
	}
	
	public void Cacul() {
		
		System.out.println("원의 색깔은" + color);
	}
	
}

class Circle extends Shape{
	double radius;
	
	public Circle() {
		super();
		this.radius = 0.00;
	}
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public void Cacul() {
		System.out.println("원의 색깔 : " + color);
		System.out.println("원의 반지름 : " + radius);
		System.out.println("원의 둘레 : " + (2 * radius * 3.14));
		System.out.println("원의 넓이 : " + (radius * radius * 3.14));
	}
}

public class CircleTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("색상을 입력하시오 : ");
		String color = stdIn.next();
		System.out.print("반지름을 입력하시오 : ");
		int radius = stdIn.nextInt();
		
		Circle c1 = new Circle();
		c1.Cacul();
		
		Circle c2 = new Circle(color,radius);
		c2.Cacul();

	}

}
