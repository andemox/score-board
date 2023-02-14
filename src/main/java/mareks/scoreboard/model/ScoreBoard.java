package mareks.scoreboard.model;

import mareks.scoreboard.exception.InvalidMatchException;
import mareks.scoreboard.exception.MatchNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ScoreBoard {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScoreBoard.class);

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

    public void show() {
        matchList.gameList().forEach(p -> LOGGER.info(p.toString()));
    }


    public void showSortedByResultAndTime() {
        getGameListSorted().forEach(p -> LOGGER.info(p.toString()));
    }

    public ArrayList<Match> getGameListSorted() {
        final ArrayList<Match> results = matchList.gameList();
        Collections.sort(results);
        return results;
    }

    public void showFormatedByResultAndTime() {
        getGameListSorted().forEach(match -> {
            StringBuilder formatter = prepraringResult(match);
            LOGGER.info(formatter.toString());
        });
    }

    private static StringBuilder prepraringResult(Match p) {
        StringBuilder formatter = new StringBuilder();
        formatter.append(p.getHomeTeamName());
        formatter.append(" ");
        formatter.append(p.getScoreHomeTeam());
        formatter.append(" - ");
        formatter.append(p.getAwayTeamName());
        formatter.append(" ");
        formatter.append(p.getScoreAwayTeam());
        return formatter;
    }
}
