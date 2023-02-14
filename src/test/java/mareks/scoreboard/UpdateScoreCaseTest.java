package mareks.scoreboard;

import mareks.scoreboard.common.Match;
import mareks.scoreboard.common.ScoreBoard;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateScoreCaseTest {

    @Test
    void testUpdatingMatch() {
        var newMatch = new Match();

        // adding match to scoreboard
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(newMatch);
        UUID uuid = newMatch.getUUID();

        // get match
        Match oldMatch = scoreBoard.getByUUID(uuid);
        oldMatch.updateScore(2, 1);
        scoreBoard.updateMatch(oldMatch);

        // get results
        Match updatedMatch = scoreBoard.getByUUID(uuid);
        assertEquals(2, updatedMatch.getScoreHomeTeam(), "Expected 2");
        assertEquals(1, updatedMatch.getScoreAwayTeam(), "Expected 1");
    }
}
