package nextstep.ladder.src.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
  @ParameterizedTest
  @MethodSource("ladderNGameResult")
  @DisplayName("GameResult test")
  public void gameResultTest(Ladder ladder, GameResult gameResult) {
    Calculator calculator = new Calculator(ladder);
    int result = calculator.result(2);
    // System.out.println(result);
    
    // assertThat(bridged.isBridge()).isTrue();
    // assertThat(notBridged.isBridge()).isFalse();
  }

  private static Stream<Arguments> ladderNGameResult() {
    return Stream.of(
      /*
        |-----|     |
        |     |-----|
        |     |-----|
      */
      Arguments.of(
        new Ladder(
          Arrays.asList(
            new Floor(Arrays.asList(new Bridge(true), new Bridge(false))),
            new Floor(Arrays.asList(new Bridge(false), new Bridge(true))),
            new Floor(Arrays.asList(new Bridge(false), new Bridge(true)))
          )
        ),
        new GameResult(
          Arrays.asList(new Result("re1"), new Result("re2"), new Result("re3"))
        )
      )
    );
  }  
}
