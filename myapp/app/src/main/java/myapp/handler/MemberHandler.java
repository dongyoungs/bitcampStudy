package myapp.handler;

import myapp.vo.Member;
import util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  // static int[] no = new int[MAX_SIZE];
  // static String[] name = new String[MAX_SIZE];
  // static String[] email = new String[MAX_SIZE];
  // static String[] password = new String[MAX_SIZE];
  // static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;
  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    Member m = new Member();
    m.setName(Prompt.inputString("이름? ")) ;
    m.setEmail(Prompt.inputString("이메일? "));
    m.setPassword(Prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0));
    m.setNo(userId++);

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배령레 담는다.
    members[length++] = m;
  }

  public static void printMembers() {
    System.out.println("------------------------------");

    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("------------------------------");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호 ? ");
    // 입력 받은 번호를가지고 배열에서 해당 회원을 찾아야 한다.
    int num = Integer.parseInt(memberNo.replaceAll("[^0-9]", ""));
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == num) {
        // i 번재 회원번호 출력
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        return;
      }
    }
    // 못찾으면 못찾았다고 말해야한다.
    System.out.println("말씀하신 회원을 찾지 못했습니다.");
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호 ? ");
    // 입력 받은 번호를가지고 배열에서 해당 회원을 찾아야 한다.
    int num = Integer.parseInt(memberNo.replaceAll("[^0-9]", ""));
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == num) {
        // i 번재 회원번호 출력
        System.out.printf("이름:(%s) ", m.getName());
        m.setName(Prompt.inputString(""));
        System.out.printf("이메일:(%s) ", m.getEmail());
        m.setEmail(Prompt.inputString(""));
        m.setPassword(Prompt.inputString("새암호: >"));
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        m.setGender(inputGender(m.getGender()));
        return;
      }
      // 못찾으면 못찾았다고 말해야한다.
      System.out.println("말씀하신 회원을 찾지 못했습니다.");
    }
  }

  public static boolean available() {
    return MemberHandler.length < MemberHandler.MAX_SIZE;
  }

  static String toGenderString(char gender) {
    return gender == 'M' ? "MALE" : "FEMALE";
  }

  private static char inputGender(char gender) {
    String label = "";
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String.format("성별()");
      String title = label +
          "  1. 남자\n" +
          "  2. 여자\n" +
          "> ";
      String menuNo = Prompt.inputString(title);// 입력 값을 읽고 난 후 남아 있는 줄바꿈 코드 제거

      switch (menuNo) {
        case "1": {
          return MALE;
        }
        case "2": {
          return FEMALE;
        }
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    String memberNo = Prompt.inputString("번호 ? ");
    int num = Integer.parseInt(memberNo.replaceAll("[^0-9]", ""));
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == num) {
        // i 이전은 그대로 두고,i는 삭제, i 이후행은 전부 한칸씩 땡겨야함
        for (int j = i; j < length; j++) {
          members[i] = members[i + 1];
        }
        members[--length] = null;
        System.out.println("삭제완료");
        return;
      }
    }
    // 못찾으면 못찾았다고 말해야한다.
    System.out.println("삭제할 회원을 찾지 못했습니다.");
  }

  // private static int indexof(int memberNo) {
  // for (int i = 0; i < length; i++) {
  // Member m = members[i];
  // if (m.no == memberNo) {
  // return i;
  // }
  // }
  // }
}
