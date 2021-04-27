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
        if(col - 1 >= 0 && floor.floor().get(col - 1).isBridge()) {
          col = col - 1;
        } else if(col < floor.floor().size() && floor.floor().get(col).isBridge()) {
          col = col + 1;
        }
      });
    // ladder.ladder().stream()
    //   .reduce(0, (floor) -> {})
    return col;
  }

  public int calc(int col, int row) {
    return 0;
  }
}
