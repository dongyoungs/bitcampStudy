package myapp.vo;

public class Member {

  // 모든 인스턴스가 공유하는 값은 스태틱 필드에 보관한다.
  private static int userId = 1;

  // 상수는 스태틱 필드로 정의한다.
  //정보를 다룰 때는 그 정보를 갖고 있는 클래스에 그 기능을 둔다.
  // 필드도 마찬가지이다.
  // GRASP 패턴 : Information Expert
  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  // 인스턴스 필드는 각각 개별적으로 유지해야 하는 값을 저장할 때 사용한다.
  // new 명령을 통해 변수를 Heap 영역에 생성한다.
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  //생성자는 인스턴스를 생성한 후 필드를 초기화시키는 일을 한다.
  // 인스턴스를 사용할 때 문제가 없도록 유효한 값으로 초기화시킨다.
  // 기본 생성자(default constructor)는 개발자가 생성자를 정의하지 않을 때
  // 컴파일러가 추가해주는 생성자다.
  // 물론 개발자가 직접 추가할 수 있다.
  public Member() {
    this.no = userId++;
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

