package nextstep.ladder.src.domain;

public class Calculator {
  private final Ladder ladder;

  private int col;

  public Calculator(Ladder ladder) {
    this.ladder = ladder;
  }

  public int result(int participantNumber) {
    /*
      - 초기좌표 지정
        - x = participantNumber, y = 0
      - 해당 좌표 양옆 어딘가에 다리가 존재하면 x 좌표 이동
      - y 값은 +1
      - y 값이 ladder.length 에 달하면 종료하고 return number
    */
    col = participantNumber;
    ladder.ladder().stream()
      .forEach((floor) -> {
        col = calculateCol(floor, col);
      });
    return col;
  }

  private int calculateCol(Floor floor, int col) {
    if(isBridge(floor, col - 1)) {
      return col - 1;
    } else if(isBridge(floor, col)) {
      return col + 1;
    }
    return col;
  }

  private boolean isBridge(Floor floor, int col) {
    try {
      return floor.floor().get(col).isBridge();
    } catch(ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  // private boolean isMove(boolean isBridge, int col, int maxSize) {
  //   if(col < 0) {
  //     return false;
  //   }
  //   if(col >= maxSize) {
  //     return false;
  //   }
  //   return isBridge;
  // }
}
