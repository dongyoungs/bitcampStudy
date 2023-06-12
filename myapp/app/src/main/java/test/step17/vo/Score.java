package test.step17.vo;

public class Score {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

  // 생성자 : 인스턴스를 생성한 직후 호출하는 메서드
  Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  public String getName() {
    return name;
  }

  public void setName(String inputName) {
    this.name = inputName;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int inputKor) {
    this.kor = inputKor;
  }

  public int getEng() {
    return kor;
  }

  public void setEng(int inputEng) {
    this.eng = inputEng;
  }

  public int getMath() {
    return kor;
  }

  public void setMath(int inputMath) {
    this.math = inputMath;
  }

  // getter : private으로 접근이 막힌 변수의 값을 리턴해주는 메서드
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }
}