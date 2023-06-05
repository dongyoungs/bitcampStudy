package util;

public class Calculator {
  public static int result;// 스새틱 변수는 기본 값 0으로 초기화된다.

  public static void init(int a) {
    result = a;
  }

  public static void plus(int a) {
    result = result + a;
  }

  public static void minus(int a) {
    result = result - a;
  }

  public static void multiple(int a) {
    result = result * a;
  }

  public static void devide(int a) {
    if (a == 0) {
      System.out.println("0으로 나누시면 안됩니다");
    } else {
      result = result / a;
    }

  }
}
