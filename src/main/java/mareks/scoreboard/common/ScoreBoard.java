package mareks.scoreboard.common;

import java.util.Objects;
import java.util.UUID;

public class ScoreBoard {

    CollectionMatch matchList = new CollectionMatch();

    @SuppressWarnings("unused")
    public void addNewMatch(Match match) throws InvalidMatchException {
        if (Objects.isNull(match)) {
            throw new InvalidMatchException();
        }
        matchList.add(match);
    }

    public int howManyLiveMatches() {
        return matchList.size();
    }

    public Match getByUUID(UUID uuid) throws MatchNotFoundException {
        Match match = matchList.get(uuid);
        if (Objects.isNull(match)) {
            throw new MatchNotFoundException();
        }
        return match;
    }

    public void updateMatch(Match newDataForMatch) throws MatchNotFoundException {
        getByUUID(newDataForMatch.getUUID());
        matchList.updateMatch(newDataForMatch);
    }

    public void deleteMatch(Match oldMatch) throws MatchNotFoundException, InvalidMatchException {
        if (Objects.isNull(oldMatch)) {
            throw new InvalidMatchException();
        }
        Match match = getByUUID(oldMatch.getUUID());
        matchList.deleteMatch(match);
    }
}
