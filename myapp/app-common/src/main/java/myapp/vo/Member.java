package myapp.vo;

import java.io.Serializable; // 인터페이스 (직렬화 가능하기위해선 해당 인터페이스 상속)

public class Member implements Serializable {


  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  //  public Member() {
  //    this.no = userId++;
  //  }
  public Member() {}

  public Member(int no) {
    this.no = no;
  }

  // Object의 equals()는 Member 인스턴스를 비교하는데 적합하지 않다.
  // 왜? Object의 equals()는 단순히 인스턴스 주소가 같은지 비교하기 때문이다.
  // 그 인스턴스 안에 저장된 변수들의 값이 같다면
  // 두 인스턴스는 같은 것으로 처리하는 것이다.
  // 그래서 수퍼 클래스의 equals()를 재정의 한다.
  // => 이것을 오버라이딩(overriding)이라 부른다.
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
    Member m = (Member)obj;
    if(this.getNo() != m .getNo()) {
      return false;
    }
    //    if(this.getName() != null &&this.getName() != m .getName()) {
    //      return false;
    //    }
    //    if(this.getEmail() != null &&this.getEmail() != m .getEmail()) {
    //      return false;
    //    }
    //    if(this.getPassword() != null &&this.getPassword() != m .getPassword()) {
    //      return false;
    //    }
    //    if(this.getGender() != m .getGender()) {
    //      return false;
    //    }
    return true;

  }

  // 겟터/셋터는 인스턴스 필드의 값을 설정하고 꺼내는 메서드다.
  // 보통 외부에서 직접 필드에 접근하는 것을 막았을 때, 사용한다.
  public int getNo() {
    return this.no;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }


  public String getPassword() {
    return this.password;
  }

  public char getGender() {
    return this.gender;
  }

  public void setNo(int number) {
    no = number;
  }

  public void setName(String str) {
    name = str;
  }

  public void setEmail(String str) {
    email = str;
  }

  public void setPassword(String str) {
    password = str;
  }

  public void setGender(char gen) {
    gender = gen;
  }

}

