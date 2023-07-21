package myapp.handler;

import myapp.dao.BoardDao;
import myapp.vo.Board;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class BoardListListener implements ActionListener {

  BoardDao boardDao;

  public BoardListListener( BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("--------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일");
    System.out.println("--------------------------------------");
    Object[] boardList = boardDao.list().toArray();
    for (Object board : boardList) {
      System.out.printf("%d, %s, %s, %d,"
          + " %tY-%5$tm-%5$td %5$tH:%5$tM:%5$tS\n",
          ((Board)board).getNo(),
          ((Board)board).getTitle(),
          ((Board)board).getWriter(),
          ((Board)board).getViewCount(),
          ((Board)board).getCreatedDate());
    }
  }

}










