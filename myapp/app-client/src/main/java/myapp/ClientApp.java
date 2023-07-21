


package myapp;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import dao.MySQLBoardDao;
import dao.MySQLMemberDao;
import myapp.dao.BoardDao;
import myapp.dao.MemberDao;
import myapp.handler.BoardAddListener;
import myapp.handler.BoardDeleteListener;
import myapp.handler.BoardListListener;
import myapp.handler.BoardUpdateListener;
import myapp.handler.BoardViewListener;
import myapp.handler.FooterListener;
import myapp.handler.HeaderListener;
import myapp.handler.HelloListener;
import myapp.handler.MemberAddListener;
import myapp.handler.MemberDeleteListener;
import myapp.handler.MemberListListener;
import myapp.handler.MemberUpdateListener;
import myapp.handler.MemberViewListener;
import util.BreadcrumbPrompt;
import util.Menu;
import util.MenuGroup;

public class ClientApp {

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {

    //DB 커넥션
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://study:1111@localhost:3306/studydb");

    memberDao = new MySQLMemberDao(con);
    boardDao = new MySQLBoardDao(con);
    readingDao = null;
    prepareMenu();
  }

  public static void main(String[] args) throws Exception {
    if (args.length <2) {
      System.out.println("실행 예) java... bitcamp.... 서버주소 포트번포");
    }
    ClientApp app = new ClientApp(args[0],Integer.parseInt(args[1]));
    app.execute();
    app.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() throws UnknownHostException, IOException {

    printTitle();
    mainMenu.execute(prompt);

  }

  public void close() throws IOException {
    prompt.close();
  }



  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberViewListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardViewListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingDao)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingDao)));
    readingMenu.add(new Menu("조회", new BoardViewListener(readingDao)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingDao)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingDao)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }

}







