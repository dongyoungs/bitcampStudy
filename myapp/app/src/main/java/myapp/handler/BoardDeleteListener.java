package myapp.handler;

import myapp.dao.BoardDao;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class BoardDeleteListener implements ActionListener {

  BoardDao boardDao;

  public BoardDeleteListener( BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (this.boardDao.delete(prompt.inputInt("번호? ")) == 0) {
      System.out.println("삭제할 회원을 찾지 못했습니다.");
      return;
    }
    System.out.println("삭제완료");
  }


}










