package test3;

class A {
  static int v1 = 1234;
  static {

    v1 = 100;
    System.out.println("A 클래스의 스태틱 블록 실행1!");
  }
  static {
    v1 = 200;
    System.out.println("A 클래스의 스태틱 블록 실행22!");
  }
  static {
    v1 = 300;
    System.out.println("A 클래스의 스태틱 블록 실행333!");
    // System.out.println(v1);
  }
  static int v2;
  static void m1() {}

}

public class Exam01 {
  public static void main(String[] args) {
    A obj;// 이때는 class 로딩을 하지 않는다.

    //A.v1 = 100; // static 변수에 접근할때 클래스 로딩 한다.
    A.m1();// 마찬가지로 static 메서드에 접근할때도 클래스 로딩한다.

    //    A.v1 = 200; // 이때는 이전에 이미 m1() 호출시점에서 클래스 로딩이 되어서. 클래스 로딩을 하지 않는다.
    //
    //    obj = new A(); //인스턴스 생성 시점에도 클래스 호출함
    // Qname  fully - qualified class name ( 프로젝트부터 클래스까지 디렉토리 전부 명시)
    //    try {
    //      Class.forName("test3.A"); // 이렇게도 클래스로딩 이루어짐
    //    } catch (ClassNotFoundException e) {
    //      System.out.println("못찾겠다 꾀꼬리");
    //    }

  }
}


