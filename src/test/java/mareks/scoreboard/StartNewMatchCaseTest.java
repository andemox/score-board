package mareks.scoreboard;

import mareks.scoreboard.common.Match;
import mareks.scoreboard.common.ScoreBoard;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartNewMatchCaseTest {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(StartNewMatchCaseTest.class);

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
