package myapp.handler;

import myapp.vo.Member;
import util.ActionListener;
import util.BreadcrumbPrompt;

public interface MemberActionsListener extends ActionListener {

  static char inputGender(char gender, BreadcrumbPrompt prompt) {
    String label = "";
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", gender ==  'M' ? "MALE" : "FEMALE");
    }
    while (true) {
      String.format("성별()");
      String title = label +
          "  1. 남자\n" +
          "  2. 여자\n" +
          "> ";
      String menuNo = prompt.inputString(title);// 입력 값을 읽고 난 후 남아 있는 줄바꿈 코드 제거

      switch (menuNo) {
        case "1": {
          return Member.MALE;
        }
        case "2": {
          return Member.FEMALE;
        }
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

}










