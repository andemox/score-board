package mareks.scoreboard;

import mareks.scoreboard.common.Match;
import mareks.scoreboard.common.ScoreBoard;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinishingMatchCaseTest {

    @Test
    void finishMatchTest() {
        // given
        var newMatch = new Match();
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(newMatch);
        UUID uuid = newMatch.getUUID();
        assertEquals(1, scoreBoard.howManyLiveMatches(), "Expected one");

        // when - updating scoreboard
        Match oldMatch = scoreBoard.getByUUID(uuid);
        scoreBoard.deleteMatch(oldMatch);
        // then
        assertEquals(0, scoreBoard.howManyLiveMatches(), "Expected zero");
    }
}
