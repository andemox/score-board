package mareks.scoreboard;

import mareks.scoreboard.common.Match;
import mareks.scoreboard.common.ScoreBoard;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateScoreCaseTest {

    final static int expectedScoreHomeTeam = 2;
    final static int expectedScoreAwayTeam = 1;

    @Test
    void testUpdatingMatch() {
        // given
        var newMatch = new Match();
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(newMatch);
        UUID uuid = newMatch.getUUID();
        // when - updating scoreboard
        Match oldMatch = scoreBoard.getByUUID(uuid);
        oldMatch.updateScore(expectedScoreHomeTeam, expectedScoreAwayTeam);
        scoreBoard.updateMatch(oldMatch);
        // then
        verify(scoreBoard, uuid);
    }

    private static void verify(ScoreBoard scoreBoard, UUID uuid) {
        Match updatedMatch = scoreBoard.getByUUID(uuid);
        assertEquals(expectedScoreHomeTeam, updatedMatch.getScoreHomeTeam(), "Check result");
        assertEquals(expectedScoreAwayTeam, updatedMatch.getScoreAwayTeam(), "Check result");
    }
}
