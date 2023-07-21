package myapp.vo;

import java.io.Serializable;

public class Board implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private int no;
  private String title;
  private String content;
  private String writer;
  private String password;
  private int viewCount;
  private long createdDate;


  public Board() {
    this.createdDate = System.currentTimeMillis();
  }
  //  public Board() {
  //    this.no = boardNo++;
  //    this.createdDate = System.currentTimeMillis();
  //  }
  public Board(int num) {
    this.no = num;
    this.createdDate = System.currentTimeMillis();
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public long getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(long createdDate) {
    this.createdDate = createdDate;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if(this.getClass() != obj.getClass()) {
      return false;
    }
    //위 조건에서 this가 가리키는 인스턴스의 클래스와
    //파라미터 obj가 가리키는 인스턴스의 클래스가
    //같다고 결론이 났기 때문에, obj-->Member 클래스로
    // 형변환 한다.
    Board m = (Board)obj;
    if(this.getNo() != m .getNo()) {
      return false;
    }
    return true;

  }
}
