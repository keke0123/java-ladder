package nextstep.ladder.src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
  private static final String DELIMITER = ",";

  private final List<String> gameResult;

  public GameResult(List<String> gameResult) {
    this.gameResult = gameResult;
  }

  public static GameResult makeByString(String results) {
    assureNotEmpty(results);
    return new GameResult(
      Arrays.stream(results.split(DELIMITER))
        .map(String::trim)
        .collect(Collectors.toList())
    );
  }
  private static void assureNotEmpty(String results) {
    if(results == null || results.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  public List<String> list() {
    return gameResult;
  }
}
