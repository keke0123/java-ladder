package nextstep.ladder.src.controller;

import nextstep.ladder.src.common.InputView;
import nextstep.ladder.src.common.ResultView;
import nextstep.ladder.src.domain.GameResult;
import nextstep.ladder.src.domain.Ladder;
import nextstep.ladder.src.domain.Participants;

public class LadderController {
  public static void makeLadder() {
    Participants participants = Participants.makeByString(InputView.participants());
    GameResult gameResult = GameResult.makeByString(InputView.gameResult(), participants.numberOfParticipants());
    Ladder ladder = Ladder.makeLadderBySize(InputView.height(), participants.numberOfParticipants() - 1);

    System.out.println("실행결과");

    ResultView.users(participants);
    ResultView.ladder(ladder);
    ResultView.gameResult(gameResult);
  }
}
