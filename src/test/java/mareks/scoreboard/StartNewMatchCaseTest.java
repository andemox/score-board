package mareks.scoreboard;

import mareks.scoreboard.common.Match;
import mareks.scoreboard.common.ScoreBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartNewMatchCaseTest {

    @Test
    void testAddingNewMatch() {
        var match = new Match();
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(match);
        assertEquals(1, scoreBoard.howManyLiveMatches(), "One match expected");
    }

    @Test
    void testStartingValues() {
        var match = new Match();
        assertEquals(0, match.getScoreHomeTeam(), "Expected zero");
        assertEquals(0, match.getScoreAwayTeam(), "Expected zero");
    }
}
