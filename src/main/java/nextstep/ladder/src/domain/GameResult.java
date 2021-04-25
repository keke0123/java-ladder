package nextstep.ladder.src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
  private static final String DELIMITER = ",";

  private final List<Result> gameResult;

  public GameResult(List<Result> gameResult) {
    this.gameResult = gameResult;
  }

  public static GameResult makeByString(String results, int size) {
    assureNotEmpty(results);
    checkSize(results, size);
    return new GameResult(
      Arrays.stream(results.split(DELIMITER))
        .map(String::trim)
        .map(Result::new)
        .collect(Collectors.toList())
    );
  }

  private static void assureNotEmpty(String results) {
    if(results == null || results.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  private static void checkSize(String results, int size) {
    if(results.split(DELIMITER).length != size) {
      throw new IllegalArgumentException("상품의 갯수는 참가자의 수와 같아야 합니다.");
    }
  }

  public List<Result> list() {
    return gameResult;
  }
}
