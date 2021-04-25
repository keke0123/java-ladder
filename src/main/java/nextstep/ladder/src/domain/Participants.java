package nextstep.ladder.src.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
  private static final String DELIMITER = ",";

  private final List<User> participants;

  public Participants(List<User> participants) {
    this.participants = participants;
  }

  public static Participants makeByString(String users) {
    assureNotEmpty(users);
    return new Participants(
      Arrays.stream(users.split(DELIMITER))
        .map(String::trim)
        .map(User::new)
        .collect(Collectors.toList())
    );
  }

  private static void assureNotEmpty(String users) {
    if(users == null || users.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  public int numberOfParticipants() {
    return participants.size();
  }

  public List<User> participants() {
    return participants;
  }

  public int maxNameLength() {
    return participants.stream()
      .map(user -> user.name().length())
      .reduce(0, (max, no) -> biggerNumber(max, no));
  }

  private int biggerNumber(int standardNumber, int targetNumber) {
    if(standardNumber > targetNumber) {
      return standardNumber;
    }
    return targetNumber;
  }
}
