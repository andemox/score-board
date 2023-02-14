package mareks.scoreboard;

import mareks.scoreboard.exception.InvalidMatchException;
import mareks.scoreboard.model.Match;
import mareks.scoreboard.model.ScoreBoard;
import mareks.scoreboard.model.Team;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetResumeOfGamesInProgressTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetResumeOfGamesInProgressTest.class);

    LocalDateTime timeHelper(int hour, int minute) {
        return LocalDateTime.of(2023, 2, 14, hour, minute, 0);
    }

    @Test
    public void getResumeOfGameInProgressTest() throws InvalidMatchException {
        // given
        var m1 = Match.setup(timeHelper(14, 30), 0, 0);
        var m2 = Match.setup(timeHelper(15, 20), 2, 1);
        var m3 = Match.setup(timeHelper(12, 15), 3, 3);
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
        var m1 = Match.setup(timeHelper(15, 25), 5, 1);
        var m2 = Match.setup(timeHelper(15, 25), 15, 1);
        var m3 = Match.setup(timeHelper(12, 15), 5, 1);
        var m4 = Match.setup(timeHelper(12, 25), 10, 1);


        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(m1);
        scoreBoard.addNewMatch(m2);
        scoreBoard.addNewMatch(m3);
        scoreBoard.addNewMatch(m4);

        LOGGER.info("\n-- unsorted --");
        scoreBoard.show();

        // when
        ArrayList<Match> gameListSorted = scoreBoard.getGameListSorted();

        LOGGER.info("\n-- sorted --");
        scoreBoard.showSortedByResultAndTime();


        // then
        LOGGER.info("\n-- checking 1 -- check first element");
        LOGGER.info("Comparing gameListSorted.get(3) {}", gameListSorted.get(0));
        assertEquals(0, m2.getUUID().compareTo(gameListSorted.get(0).getUUID()), "needs to be equal");

        LOGGER.info("\n-- checking 2 -- check last element");
        LOGGER.info("Comparing m3: {}", m3);
        LOGGER.info("Comparing gameListSorted.get(3) {}", gameListSorted.get(3));
        assertEquals(0, m3.getUUID().compareTo(gameListSorted.get(3).getUUID()), "needs to be equal");

    }


    @Test
    public void getOrderByScoreAndTimeWithTeamName() throws InvalidMatchException {
        // given
        var m1 = Match.setupFull(timeHelper(15, 25), new Team("Mexico", 0), new Team("Canada", 5));
        var m2 = Match.setupFull(timeHelper(15, 35), new Team("Spain", 10), new Team("Brazil", 2));
        var m3 = Match.setupFull(timeHelper(15, 45), new Team("Germany", 2), new Team("France", 2));
        var m4 = Match.setupFull(timeHelper(15, 55), new Team("Uruguay", 6), new Team("Italy", 6));
        var m5 = Match.setupFull(timeHelper(15, 55), new Team("Argentina", 3), new Team("Australia", 1));
        ScoreBoard scoreBoard = addingToScoreboard(m1, m2, m3, m4, m5);

        LOGGER.info("\n-- unsorted --");
        scoreBoard.show();

        // when
        ArrayList<Match> gameListSorted = scoreBoard.getGameListSorted();

        LOGGER.info("\n-- sorted --");
        scoreBoard.showSortedByResultAndTime();

        // then
        assertEquals(0, m4.getUUID().compareTo(gameListSorted.get(0).getUUID()), "needs to be Uruguay with Italy");
        assertEquals(0, m2.getUUID().compareTo(gameListSorted.get(1).getUUID()), "needs to be Spain with Brazil");
        assertEquals(0, m1.getUUID().compareTo(gameListSorted.get(2).getUUID()), "needs to be Mexico with Canada");
        assertEquals(0, m5.getUUID().compareTo(gameListSorted.get(3).getUUID()), "needs to be Argentina with Australia");
        assertEquals(0, m3.getUUID().compareTo(gameListSorted.get(4).getUUID()), "needs to be Germany with France");
    }

    private static ScoreBoard addingToScoreboard(Match m1, Match m2, Match m3, Match m4, Match m5) throws InvalidMatchException {
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(m1);
        scoreBoard.addNewMatch(m2);
        scoreBoard.addNewMatch(m3);
        scoreBoard.addNewMatch(m4);
        scoreBoard.addNewMatch(m5);
        return scoreBoard;
    }
}
