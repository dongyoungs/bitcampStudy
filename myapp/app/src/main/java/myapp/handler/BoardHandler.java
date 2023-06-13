package myapp.handler;

import myapp.vo.Board;
import util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] Boards = new Board[MAX_SIZE];
  // static int[] no = new int[MAX_SIZE];
  // static String[] name = new String[MAX_SIZE];
  // static String[] email = new String[MAX_SIZE];
  // static String[] password = new String[MAX_SIZE];
  // static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  //  private int no;
  //  private String title;
  //  private String content;
  //  private String writer;
  //  private String password;
  //  private int viewCount;
  //  private long createdDate;
  public static void inputBoard() {
    Board board = new Board();
    board.setTitle(Prompt.inputString("제목? ")) ;
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setPassword(Prompt.inputString("암호? "));
    board.setNo(userId++);

    // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    Boards[length++] = board;
  }

  public static void printBoards() {
    System.out.println("--------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일");
    System.out.println("--------------------------------------");
    for (int i = 0; i < length; i++) {
      Board board = Boards[i];
      //게시글의 등록일 값을 가져와서 Date 인스턴스에 저장한다.
      System.out.printf("%d, %s, %s, %d,"
          + " %tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getViewCount(),
          board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    //    String BoardNo = Prompt.inputString("번호 ? ");
    //    // 입력 받은 번호를가지고 배열에서 해당 회원을 찾아야 한다.
    //    int num = Integer.parseInt(BoardNo.replaceAll("[^0-9]", ""));
    //    for (int i = 0; i < length; i++) {
    //      Board m = Boards[i];
    //      if (m.getNo() == num) {
    //        // i 번재 회원번호 출력
    //        System.out.printf("이름: %s\n", board.getName());
    //        System.out.printf("이메일: %s\n", board.getEmail());
    //        System.out.printf("성별: %s\n", toGenderString(board.getGender()));
    //        return;
    //      }
    //    }
    //    // 못찾으면 못찾았다고 말해야한다.
    //    System.out.println("말씀하신 회원을 찾지 못했습니다.");
  }

  public static void updateBoard() {
    //    String BoardNo = Prompt.inputString("번호 ? ");
    //    // 입력 받은 번호를가지고 배열에서 해당 회원을 찾아야 한다.
    //    int num = Integer.parseInt(BoardNo.replaceAll("[^0-9]", ""));
    //    for (int i = 0; i < length; i++) {
    //      Board m = Boards[i];
    //      if (m.getNo() == num) {
    //        // i 번재 회원번호 출력
    //        System.out.printf("이름:(%s) ", board.getName());
    //        board.setName(Prompt.inputString(""));
    //        System.out.printf("이메일:(%s) ", board.getEmail());
    //        board.setEmail(Prompt.inputString(""));
    //        board.setPassword(Prompt.inputString("새암호: >"));
    //        System.out.printf("성별: %s\n", toGenderString(board.getGender()));
    //        board.setGender(inputGender(board.getGender()));
    //        return;
    //      }
    //      // 못찾으면 못찾았다고 말해야한다.
    //      System.out.println("말씀하신 회원을 찾지 못했습니다.");
    //    }
  }

  public static boolean available() {
    return BoardHandler.length < BoardHandler.MAX_SIZE;
  }

  static String toGenderString(char gender) {
    return gender == 'M' ? "MALE" : "FEMALE";
  }

  private static char inputGender(char gender) {
    //    String label = "";
    //    if (gender == 0) {
    //      label = "성별?\n";
    //    } else {
    //      label = String.format("성별(%s)?\n", toGenderString(gender));
    //    }
    //    while (true) {
    //      String.format("성별()");
    //      String title = label +
    //          "  1. 남자\n" +
    //          "  2. 여자\n" +
    //          "> ";
    //      String menuNo = Prompt.inputString(title);// 입력 값을 읽고 난 후 남아 있는 줄바꿈 코드 제거
    //
    //      switch (menuNo) {
    //        case "1": {
    //          return board.MALE;
    //        }
    //        case "2": {
    //          return board.FEMALE;
    //        }
    //        default:
    //          System.out.println("무효한 번호입니다.");
    //      }
    //    }
    return '1';
  }

  public static void deleteBoard() {
    String BoardNo = Prompt.inputString("번호 ? ");
    int num = Integer.parseInt(BoardNo.replaceAll("[^0-9]", ""));
    for (int i = 0; i < length; i++) {
      Board m = Boards[i];
      if (m.getNo() == num) {
        // i 이전은 그대로 두고,i는 삭제, i 이후행은 전부 한칸씩 땡겨야함
        for (int j = i; j < length; j++) {
          Boards[i] = Boards[i + 1];
        }
        Boards[--length] = null;
        System.out.println("삭제완료");
        return;
      }
    }
    // 못찾으면 못찾았다고 말해야한다.
    System.out.println("삭제할 회원을 찾지 못했습니다.");
  }

  //  private static int indexof(int BoardNo) {
  //    for (int i = 0; i < length; i++) {
  //      Board m = Boards[i];
  //      if (board.no == BoardNo) {
  //        return i;
  //      }
  //    }
  //  }
}
