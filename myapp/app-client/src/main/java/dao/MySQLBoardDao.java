package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import myapp.dao.BoardDao;
import myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {


  Connection con;

  public MySQLBoardDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Board board) {
    try(Statement stmt = con.createStatement()) {
      stmt.executeUpdate(String.format(
          "insert into myapp_board(title,content,writer,password) values ('%s','%s','%s','%s')",
          board.getTitle(),
          board.getContent(),
          board.getWriter(),
          board.getPassword()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }

  @Override
  public List<Board> list() {
    try(Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content,"
                + "writer,password,view_count,created_date "
                + " from myapp_board"
                + " where category=1 "
                + "order by board_no asc")) {
      List<Board> list = new ArrayList<>();
      while (rs.next()) {
        Board b = new Board();
        LocalDateTime d = rs.getTimestamp("created_date").toLocalDateTime();

        b.setNo(rs.getInt("board_no"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriter(rs.getString("writer"));
        b.setPassword(rs.getString("password"));
        b.setViewCount(rs.getInt("view_count"));
        b.setCreatedDate(d.toEpochSecond(ZoneOffset.of("+09:00")) * 1000);
        list.add(b);
      }
      return list;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    try(Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content,"
                + "writer,password,view_count,created_date "
                + " from myapp_board where board_no=" + no
                + " and category=1")) {

      if (rs.next()) {
        Board b = new Board();
        LocalDateTime d = rs.getTimestamp("created_date").toLocalDateTime();

        b.setNo(rs.getInt("board_no"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriter(rs.getString("writer"));
        b.setPassword(rs.getString("password"));
        b.setViewCount(rs.getInt("view_count"));
        b.setCreatedDate(d.toEpochSecond(ZoneOffset.of("+09:00")) * 1000);
        return b;
      }
      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Board board) {
    try(Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update myapp_board set title='%s',content='%s',writer='%s',password='%s' where board_no=%d",
          board.getTitle(),
          board.getContent(),
          board.getWriter(),
          board.getPassword(),
          board.getNo()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try(Statement stmt = con.createStatement()){
      return stmt.executeUpdate("delete from myapp_board where board_no=" + no);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
