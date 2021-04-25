package nextstep.ladder.src.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class FloorTest {
  @ParameterizedTest
  @CsvSource(value = {"3:3"}, delimiter = ':')
  @DisplayName("make by width floor, size check")
  public void construct(int width, int size) {
    Floor floor = Floor.makeByWidth(width);

    assertThat(floor.floor().size()).isEqualTo(size);
  }

  @ParameterizedTest
  @MethodSource("overlapBridgeFloor")
  @DisplayName("bridge overlap exception")
  public void bridgeOverlapException(List<Bridge> floor) {
    assertThatThrownBy(() -> {
      new Floor(floor);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  private static Stream<Arguments> overlapBridgeFloor() {
    return Stream.of(
      Arguments.of(
        Arrays.asList(new Bridge(true), new Bridge(true))
      )
    );
  }  
  
}
