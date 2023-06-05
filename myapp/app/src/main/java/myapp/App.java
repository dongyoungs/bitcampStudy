package myapp;

import myapp.handler.MemberHandler;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 저장한다.

public class App {

  // static 변수는 static 메서드끼리 공유할 수 있다.

  public static void main(String[] args) {
    printTitle();

    // 키보드 스캐너 준비

    // 회원 정보 등록
    while (MemberHandler.available()) {
      MemberHandler.inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    MemberHandler.printMembers();
    Prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------------");
  }

  static boolean promptContinue() {
    String resStr = Prompt.inputString("계속 진행하시겠습니까 ? (Y/n) ");
    if (!resStr.equals("") && !resStr.equalsIgnoreCase("Y")) {
      return false;
    } else {
      return true;
    }
  }

}