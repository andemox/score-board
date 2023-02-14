package mareks.scoreboard;

import mareks.scoreboard.exception.InvalidMatchException;
import mareks.scoreboard.model.Match;
import mareks.scoreboard.model.ScoreBoard;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetResumeOfGamesInProgressTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetResumeOfGamesInProgressTest.class);

    LocalDateTime setupStartGameForTest(int hour, int minute) {
        return LocalDateTime.of(2023, 2, 14, hour, minute, 0);
    }

    @Test
    public void getResumeOfGameInProgressTest() throws InvalidMatchException {
        // given
        var m1 = Match.setup(setupStartGameForTest(14, 30), 0, 0);
        var m2 = Match.setup(setupStartGameForTest(15, 20), 2, 1);
        var m3 = Match.setup(setupStartGameForTest(12, 15), 3, 3);
        // when
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(m1);
        scoreBoard.addNewMatch(m2);
        scoreBoard.addNewMatch(m3);
        scoreBoard.show();
        // then
        assertEquals(3, scoreBoard.howManyLiveMatches(), "Expected three games");
    }

    @Test
    public void getSortByResultAndTime() throws InvalidMatchException {
        // given
        var m1 = Match.setup(setupStartGameForTest(14, 30), 0, 0);
        var m2 = Match.setup(setupStartGameForTest(15, 20), 2, 1);
        var m3 = Match.setup(setupStartGameForTest(12, 15), 3, 3);
        var m4 = Match.setup(setupStartGameForTest(12, 15), 3, 3);

        // when
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(m1);
        scoreBoard.addNewMatch(m2);
        scoreBoard.addNewMatch(m3);
        scoreBoard.addNewMatch(m4);

        ArrayList<Match> gameListSorted = scoreBoard.getGameListSorted();
        scoreBoard.showSortedByResultAndTime();

        // sorted
        Match sorted1 = gameListSorted.get(0);
        LOGGER.info("sorted1: {}", sorted1);
        LOGGER.info("m1: {}", m1);

        // then
        assertEquals(0, m1.getUUID().compareTo(sorted1.getUUID()), "needs to be");
        assertEquals(4, scoreBoard.howManyLiveMatches(), "Expected four games");
    }
}
