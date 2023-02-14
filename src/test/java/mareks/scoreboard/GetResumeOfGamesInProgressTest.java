package mareks.scoreboard;

import mareks.scoreboard.exception.InvalidMatchException;
import mareks.scoreboard.model.Match;
import mareks.scoreboard.model.ScoreBoard;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetResumeOfGamesInProgressTest {

    LocalDateTime setupStartGameForTest(int hour, int minute) {
        return LocalDateTime.of(2023, 2, 14, hour, minute, 0);
    }

    @Test
    public void getResumeOfGameInProgressTest() throws InvalidMatchException {

        // given
        var m1 = Match.setup(setupStartGameForTest(14, 30), 0 , 0);
        var m2 = Match.setup(setupStartGameForTest(15, 20), 2 , 1);
        var m3 = Match.setup(setupStartGameForTest(12, 15), 3 , 3);

        // when
        var scoreBoard = new ScoreBoard();
        scoreBoard.addNewMatch(m1);
        scoreBoard.addNewMatch(m2);
        scoreBoard.addNewMatch(m3);
        scoreBoard.show();

        // then
        assertEquals(0, scoreBoard.howManyLiveMatches(), "Expected three games");
    }
}
