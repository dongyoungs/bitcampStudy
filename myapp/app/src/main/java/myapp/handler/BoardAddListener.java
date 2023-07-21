package myapp.handler;

import myapp.dao.BoardDao;
import myapp.vo.Board;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class BoardAddListener implements ActionListener{

  BoardDao boardDao;

  public BoardAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));

    this.boardDao.insert(board);
  }

}










