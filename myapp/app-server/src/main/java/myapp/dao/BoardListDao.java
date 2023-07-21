package myapp.dao;

import java.util.LinkedList;
import java.util.List;
import myapp.vo.Board;
import util.JsonDataHelper;

public class BoardListDao implements BoardDao{

  LinkedList<Board> list = new LinkedList<>();

  String filename;

  public BoardListDao(String filename) {
    this.filename = filename;
    JsonDataHelper.loadJson(this.filename, list, Board.class);
  }

  @Override
  public void insert(Board board) {
    //데이터 입력할 때 해당 데이터의 식별 번호는 DAO에서 관리
    System.out.println(" BoardListDao 현재번호 : " + Board.boardNo + "  " + board.getNo());
    board.setNo(Board.boardNo++);
    board.setCreatedDate(System.currentTimeMillis());
    this.list.add(board);

    // 데이터를 등록할 때 마다 즉시 파일에 저장한다.
    JsonDataHelper.saveJson(filename,list);

  }

  @Override
  public List<Board> list() {
    // TODO Auto-generated method stub
    return this.list;
  }

  @Override
  public Board findBy(int no) {
    for( int i = 0; i < this.list.size();i++) {
      Board b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  @Override
  public int update(Board board) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == board.getNo()) {
        list.set(i, board);
        JsonDataHelper.saveJson(filename,list);
        return 1;
      }
    }
    return 0;
  }

  @Override
  public int delete(int no) {
    for( int i = 0; i < this.list.size(); i++) {
      Board b = this.list.get(i);
      if (b.getNo() == no) {
        this.list.remove(i);
        JsonDataHelper.saveJson(filename,list);
        return 1;
      }
    }
    return 0;
  }

}
