package bitcamp.myapp;

import java.util.Scanner;

public class App {
  // static화 하기
  static Scanner scanner = new Scanner(System.in);
  static final int MAX_SIZE = 100;
  static int userId = 1;
  static int length = 0;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    printTitle();

    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(scanner, i, name, email, password, gender, no, userId++);
      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    printMembers(length, no, name, email, gender);

    scanner.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  static void inputMember(Scanner scanner, int i,
      String[] name, String[] email, String[] password, char[] gender, int[] no, int userId) {

    name[i] = prompt("이름? ");
    email[i] = prompt("이메일? ");
    password[i] = prompt("암호? ");

    loop: while (true) {
      String menuNo = prompt("성별: \n" +
          "  1. 남자 \n" +
          "  2. 여자 \n" +
          "> ");

      switch (menuNo) {
        case "1":
          gender[i] = MALE;
          break loop;
        case "2":
          gender[i] = FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    no[i] = userId;
  }

  static boolean promptContinue(Scanner scanner) {
    System.out.print("계속 하시겠습니까?(Y/n) ");
    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers(int length, int[] no, String[] name, String[] email, char[] gender) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
    }
  }

  static String prompt(String inputString) {
    System.out.print(inputString);
    return scanner.nextLine();
  }
}
