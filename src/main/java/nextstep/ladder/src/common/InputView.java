package nextstep.ladder.src.common;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static String participants() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return scanner.nextLine();
  }

  public static String gameResult() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return scanner.nextLine();
  }
  
  public static int height() {
    System.out.println("최대 높이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
  }
}
