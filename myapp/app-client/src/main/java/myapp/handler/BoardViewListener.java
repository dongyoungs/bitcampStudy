package myapp.handler;

import myapp.dao.BoardDao;
import myapp.vo.Board;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class BoardViewListener implements ActionListener{

  BoardDao boardDao;

  public BoardViewListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    String BoardNo = prompt.inputString("번호 ? ");
    int num = Integer.parseInt(BoardNo.replaceAll("[^0-9]", ""));
    Board board = boardDao.findBy(num);
    if (board == null) {
      System.out.println("말씀하신 게시글을 찾지 못했습니다.");
      return;
    }
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("조회수: %s\n", board.getViewCount());
    board.setViewCount(board.getViewCount() + 1);
    long now = System.currentTimeMillis();
    // System.out.printf("%d", now);
    // 1시간 : 360만
    // 하루 : 8640만
    long lastTime = now - board.getCreatedDate();
    long year = 31536;

    year = year * 1000000;
    if (lastTime < 3600000) {
      System.out.printf("등록일: %d분 전 \n", lastTime / 60000);
    } else if (lastTime < 86400000) {
      System.out.printf("등록일: %d시간 전 \n", lastTime / 3600000);
    } else if (lastTime < year) {
      System.out.printf("등록일: %d일 전 \n", lastTime / 86400000);
    } else {
      System.out.printf("등록일: %d년 전 \n", lastTime / year);
    }
  }

}










