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
      GameResult.makeByString(results, 0);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"꽝,sample:2", "꽝,1,2:3"}, delimiter = ':')
  @DisplayName("check number of results")
  public void assureNotEmpty(String results, int numberOfResult) {
    GameResult gameResult = GameResult.makeByString(results, numberOfResult);

    assertThat(gameResult.list().size()).isEqualTo(numberOfResult);
  }

  @ParameterizedTest
  @CsvSource(value = {"꽝,sample:1", "꽝,1,2:5"}, delimiter = ':')
  @DisplayName("result size not equal participants size exception")
  public void checkSize(String results, int numberOfParticipants) {
    assertThatThrownBy(() -> {
      GameResult.makeByString(results, numberOfParticipants);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"꽝,test,10000:5"}, delimiter = ':')
  @DisplayName("result names max length")
  public void calcNamesMaxLength(String result, int max) {
    int calcMax = Participants.makeByString(result).maxNameLength();
    
    assertThat(calcMax).isEqualTo(max);
  }
}
