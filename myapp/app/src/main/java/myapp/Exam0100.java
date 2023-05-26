package myapp;

//# 리터럴(literal)
//- 자바 언어로 표현한 값.
//

public class Exam0100 {
  public static void main(String[] args) {
    System.out.println("-------- 정수 리터럴"); // 2 8, 10 , 16 순서
    System.out.println(0b110101); // 2진수   111
    System.out.println(0137);  // 8진수 111
    System.out.println(111);    // 10진수 111
    System.out.println(0x6F);  //16진수 111
    
    System.out.println("-------- 부동소수점 리터럴");
    System.out.println(3.14);
    System.out.println(314E-2);
    System.out.println(0.314E+1);

    System.out.println("-------- 논리 리터럴");
    System.out.println(true);
    System.out.println(false);
    
    System.out.println("-------- 문자 리터럴");
    System.out.println('가');
    System.out.println('\uac00');
    
    
    System.out.println("-------- 문자열 리터럴");
    System.out.println("가시나이까");
    System.out.println("\uac00시나이까");
    System.out.println("\uac00시나이까"); // 문자열에는 하나의 유니코드만 들어가야 하나봄
    System.out.println('\uae4c'); 


  }
}