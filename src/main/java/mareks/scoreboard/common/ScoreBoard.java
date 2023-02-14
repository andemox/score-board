package mareks.scoreboard.common;

import java.util.ArrayList;
import java.util.Collection;

public class ScoreBoard {

    Collection<Match> matchList = new ArrayList<>();
    @SuppressWarnings("unused")
    public void addNewMatch(Match match) {

    }

    public int howManyLiveMatches() {
        return matchList.size();
    }
}
