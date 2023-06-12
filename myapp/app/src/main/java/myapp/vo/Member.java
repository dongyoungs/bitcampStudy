package myapp.vo;

public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

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

