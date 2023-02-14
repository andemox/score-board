package mareks.scoreboard;

import mareks.scoreboard.exception.InvalidMatchException;
import mareks.scoreboard.model.Match;
import mareks.scoreboard.exception.MatchNotFoundException;
import mareks.scoreboard.model.ScoreBoard;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateScoreCaseTest {

    final static int expectedScoreHomeTeam = 2;
    final static int expectedScoreAwayTeam = 1;

    @Test
    void testUpdatingMatch() throws MatchNotFoundException, InvalidMatchException {
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

    private static void verify(ScoreBoard scoreBoard, UUID uuid) throws MatchNotFoundException {
        Match updatedMatch = scoreBoard.getByUUID(uuid);
        assertEquals(expectedScoreHomeTeam, updatedMatch.getScoreHomeTeam(), "Check result");
        assertEquals(expectedScoreAwayTeam, updatedMatch.getScoreAwayTeam(), "Check result");
    }
}
