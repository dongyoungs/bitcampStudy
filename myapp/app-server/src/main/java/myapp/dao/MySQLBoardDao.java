package myapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {


  SqlSessionFactory sqlSessionFactory;

  public MySQLBoardDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Board board) {
    board.setCategory(board.getCategory());
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("myapp.dao.BoardDao.insert",board);
  }

  /*
   select
     b.board_no,
     b.title,
     b.content,
     b.writer,
     b.view_count,
     b.created_date,
     m.member_no,
     m.name
   from
     myapp_board b inner join myapp_member m on b.writer=m.member_no
   where
     category=1
    order by
      board_no asc;
   */

  @Override
  public List<Board> findAll(int category) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList("myapp.dao.BoardDao.findAll", category);

  }


  @Override
  public Board findBy(int category, int no) {

    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("categoryNo", category);
    paramMap.put("boardNo",no);

    return sqlSession.selectOne("myapp.dao.BoardDao.findBy", paramMap);

  }


  @Override
  public int update(Board board) {
    board.setCategory(board.getCategory());
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("myapp.dao.BoardDao.update",board);
  }

  @Override
  public int delete(Board board) {
    board.setCategory(board.getCategory());
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("myapp.dao.BoardDao.delete",board);
  }

  @Override
  public int updateCount(Board board) {
    board.setCategory(board.getCategory());
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("myapp.dao.BoardDao.updateCount",board);
  }

}
