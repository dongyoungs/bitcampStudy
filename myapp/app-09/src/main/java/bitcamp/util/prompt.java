package bitcamp.util;
import java.util.Scanner;
public class prompt {

  static Scanner scanner = new Scanner(System.in);

  public static String inputString(String inputStr) {
    System.out.print(inputStr);
    return scanner.nextLine();
  }
  public static void close() {
    scanner.close();
  }
}

