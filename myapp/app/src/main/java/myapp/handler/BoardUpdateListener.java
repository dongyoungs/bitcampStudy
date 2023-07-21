package myapp.handler;

import myapp.dao.BoardDao;
import myapp.vo.Board;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class BoardUpdateListener implements ActionListener {

  BoardDao boardDao;

  public BoardUpdateListener( BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    String BoardNo = prompt.inputString("번호 ? ");
    // 입력 받은 번호를가지고 배열에서 해당 회원을 찾아야 한다.
    int num = Integer.parseInt(BoardNo.replaceAll("[^0-9]", ""));
    Board board = this.boardDao.findBy(num);
    if (board == null) {
      System.out.println("말씀하신 회원을 찾지 못했습니다.");
      return;
    }
    if (!prompt.inputString("암호? ").equals(board.getPassword())) {
      System.out.println("암호가 일치하지 않습니다");
      return;
    }
    board.setTitle(prompt.inputString("제목:(%s) ", board.getTitle()));
    board.setContent(prompt.inputString("내용:(%s) ", board.getContent()));
    board.setPassword(prompt.inputString("새암호: >"));

    boardDao.update(board);
  }

}










