/*
 * 작성일 : 2024년 6월 4일
 * 작성자 : 컴퓨터소프트웨어공학부 202095061 유재현
 * 
 * 문제 :
 * Rectangle 클래스를 작성하고 이를 상속받는 Square 클래스를 작성하세요.
 * Rectangle 클래스에는 double width와 double height 속성을 추가하고,
 * 이를 설정하는 생성자를 작성합니다.
 * Square 클래스는 Rectangle 클래스를 상속받고, 변의 길이를 설정하는 생성자를 작성합니다.
 * Square 클래스에 면적과 둘레를 계산하는 메소드를 추가합니다.
 * 
 * 사용자로부터 정사각형의 변의 길이를 입력받아, 해당 정사각형의 정보를 출력하는 프로그램을 작성하시오.
 * 
 * 
 */
import java.util.Scanner;
import java.util.ArrayList;	

//Rectangle 클래스는 직사각형의 속성을 정의합니다.
class Rectangle {
 protected double width;
 protected double height;

 // width와 height를 설정하는 생성자
 public Rectangle(double width, double height) {
     this.width = width;
     this.height = height;
 }

 // 면적을 계산하는 메소드
 public double getArea() {
     return width * height;
 }

 // 둘레를 계산하는 메소드
 public double getPerimeter() {
     return 2 * (width + height);
 }
}


//Square 클래스는 Rectangle 클래스를 상속받아 정사각형의 속성을 정의합니다.
class Square extends Rectangle {

 // 변의 길이를 설정하는 생성자
 public Square(double side) {
     super(side, side);
 }

 // 면적을 계산하는 메소드 (Rectangle 클래스의 메소드 사용)
 @Override
 public double getArea() {
     return super.getArea();
 }

 // 둘레를 계산하는 메소드 (Rectangle 클래스의 메소드 사용)
 @Override
 public double getPerimeter() {
     return super.getPerimeter();
 }
}
	
public class SquareTest {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
        ArrayList<Double> inputs = new ArrayList<>();

        System.out.print("도형의 길이를 입력하세요.(입력 종료는 enter입니다.) :");

        // 사용자 입력을 처리하여 배열에 저장
        while (true) {
            String input = stdIn.nextLine();
            if (input.isEmpty()) {
                break; // 입력이 비어 있으면 종료
            }
            else {
                double value = Double.parseDouble(input);
                inputs.add(value); // 입력된 숫자를 배열에 저장
            }
        }

        // 입력 개수에 따라 정사각형 또는 직사각형을 처리
        if (inputs.size() == 1) {
            double side = inputs.get(0);

            Square square = new Square(side);
            System.out.println("정사각형의 넓이 : " + square.getArea());
            System.out.println("정사각형의 둘레 : " + square.getPerimeter());
        } 
        else if (inputs.size() == 2) {
            double width = inputs.get(0);
            double height = inputs.get(1);

            Rectangle rectangle = new Rectangle(width, height);
            System.out.println("직사각형의 넓이 : " + rectangle.getArea());
            System.out.println("직사각형의 둘레 : " + rectangle.getPerimeter());
        } 
        else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}