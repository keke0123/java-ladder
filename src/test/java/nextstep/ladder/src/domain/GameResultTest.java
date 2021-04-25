package nextstep.ladder.src.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class GameResultTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("exception with empty or null")
  public void assureNotEmpty(String results) {
    assertThatThrownBy(() -> {
      GameResult.makeByString(results);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"꽝,sample:2", "꽝,1,2:3"}, delimiter = ':')
  @DisplayName("check number of results")
  public void assureNotEmpty(String results, int numberOfResult) {
    GameResult gameResult = GameResult.makeByString(results);

    assertThat(gameResult.list().size()).isEqualTo(numberOfResult);
  }

  // @ParameterizedTest
  // @CsvSource(value = {"tim,first,ted:5"}, delimiter = ':')
  // @DisplayName("participants names max length")
  // public void calcNamesMaxLength(String users, int max) {
  //   int calcMax = Participants.makeByString(users).maxNameLength();
    
  //   assertThat(calcMax).isEqualTo(max);
  // }
}
