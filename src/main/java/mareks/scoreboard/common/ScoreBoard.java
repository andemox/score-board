package mareks.scoreboard.common;

import java.util.UUID;

public class ScoreBoard {

    CollectionMatch matchList = new CollectionMatch();

    @SuppressWarnings("unused")
    public void addNewMatch(Match match) {
        matchList.add(match);
    }

    public int howManyLiveMatches() {
        return matchList.size();
    }

    public Match getByUUID(UUID uuid) {
        return matchList.get(uuid);
    }

    public void updateMatch(Match newDataForMatch) {
        matchList.updateMatch(newDataForMatch);
    }
    @SuppressWarnings("unused")
    public void deleteMatch(Match oldMatch) {
        matchList.deleteMatch(oldMatch);
    }
}
