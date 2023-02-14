package mareks.scoreboard;

import mareks.scoreboard.exception.InvalidMatchException;
import mareks.scoreboard.model.Match;
import mareks.scoreboard.model.ScoreBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartNewMatchCaseTest {

    @Test
    void testAddingNewMatch() throws InvalidMatchException {
        // given
        var match = new Match();
        var scoreBoard = new ScoreBoard();
        // when
        scoreBoard.addNewMatch(match);
        //then
        assertEquals(1, scoreBoard.howManyLiveMatches(), "One match expected");
    }

    @Test
    void testStartingValues() {
        // given
        // when
        var match = new Match();
        //then
        assertEquals(0, match.getScoreHomeTeam(), "Expected zero");
        assertEquals(0, match.getScoreAwayTeam(), "Expected zero");
    }
}
