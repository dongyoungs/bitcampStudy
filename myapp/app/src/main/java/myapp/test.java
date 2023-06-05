package myapp;

import util.Calculator;

public class test {
  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 2 = ?
    // --> 연산자 우선 순위를고려하지 않고 앞에서부터 뒤로 순차적으로 계산
    // Calculator cal = new Calculator();
    Calculator.init(2);
    Calculator.multiple(3);
    Calculator.plus(7); // 13
    Calculator.minus(2); // 11
    Calculator.devide(2); // 5
    System.out.println(Calculator.result);
  }

}
