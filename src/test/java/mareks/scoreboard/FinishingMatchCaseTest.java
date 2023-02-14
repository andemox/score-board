package mareks.scoreboard;

import mareks.scoreboard.common.InvalidMatchException;
import mareks.scoreboard.common.Match;
import mareks.scoreboard.common.MatchNotFoundException;
import mareks.scoreboard.common.ScoreBoard;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FinishingMatchCaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinishingMatchCaseTest.class);

    @Test
    void finishMatchTest() throws MatchNotFoundException, InvalidMatchException {
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

    @Test
    void finishMatchNotExistingTest() throws InvalidMatchException {
        // given
        var newMatch = new Match();
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(newMatch);
        Match oldMatch = getMatchNotExisting(scoreBoard);
        try {
            // when
            scoreBoard.deleteMatch(oldMatch);
            fail();
        } catch (MatchNotFoundException | InvalidMatchException e) {
            LOGGER.info("Match Not found = its OK");
        }
        // then
        assertEquals(0, scoreBoard.howManyLiveMatches(), "Expected zero");
    }

    private static Match getMatchNotExisting(ScoreBoard scoreBoard) {
        UUID uuid = UUID.randomUUID();
        assertEquals(1, scoreBoard.howManyLiveMatches(), "Expected one");
        Match oldMatch = null;
        try {
            // when - updating scoreboard
            oldMatch = scoreBoard.getByUUID(uuid);
        } catch (MatchNotFoundException e) {
            LOGGER.info("old match not exists - its OK");
        }
        return oldMatch;
    }
}
