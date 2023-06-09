package test.step15.vo;

// 1) 낱개의 변수 사용
// 2) 낱개의 변수 재사용
// 3) 배열 사용
// 4) 클래스를 이용하여 데이터 타입 정의(중첩클래스: 로컬 중첩클래스)
// 5) 출력 기능을 별도의 메서드로 분리(중첩클래스: 스태틱 중첩클래스)
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) General Respansibility Assignment Software Patterns (GRASP 패턴)
// GRASP 패턴: Information Expert(정보를 갖고있는 클래스가 그 정보를 다룬다)
// 8) 인스턴스 메서드 도입
// 9) 객체 생성이 번거롭고 복잡한 경우 메서드로 분리하는 것이 낫다.(디자인패턴, 팩토리 메서드();
// 10) GRASP 패턴  : Information Expert - createScore에 적용
// 11) 생성자 도입
// 12) 클래스를 유지보수 하기 쉽게 별도 소스파일로 분리하기
// 13) 클래스를 유지보수 하기 쉽게 패키지로 분류 : import,  public
// 14) 외부접근 차단과 값 꺼내기 : private, getter
// 15) 프로그래밍의 일관성을 위해 보통 다른 필드 대해서도 getter로 만들고 사용
public class App {

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    // new Score(String, int, int, int);
    // => Score 설계도에 따라 인스턴스를 생성하라.
    // => 생성한 후 Sring, int, int, int 파라미터 값을 받는 생성자 호출
    // =>이렇게 초기화시킨 인스턴스의 주소를 리턴하라.
    scores[length++] = new Score("홍길동", 100, 100, 100);
    scores[length++] = new Score("임꺽정", 90, 90, 90);
    scores[length++] = new Score("유관순", 80, 80, 80);

    // 변수에 접근 => 국영수 합계를 임의로 조작 가능!
    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }

  }

  static void printScore(Score s) {
    System.out.printf("%s: 합계=%d, 평균=%.1f\n",
        s.getName(), s.getSum(), s.getAver());
  }

}