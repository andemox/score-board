package mareks.scoreboard.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Match {

    UUID uuid;
    int scoreHomeTeam = 0;
    int scoreAwayTeam = 0;
    LocalDateTime startDateTime;

    public Match() {
        uuid = UUID.randomUUID();
        startDateTime = LocalDateTime.now();
    }

    public static Match setup(LocalDateTime startDateTime, int scoreHomeTeam, int scoreAwayTeam) {
        Match match = new Match();
        match.scoreHomeTeam = scoreHomeTeam;
        match.scoreAwayTeam = scoreAwayTeam;
        match.startDateTime = startDateTime;
        return match;
    }

    @SuppressWarnings("unused")
    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    @SuppressWarnings("unused")
    public int getScoreAwayTeam() {
        return scoreAwayTeam;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void updateScore(int scoreHomeTeam, int scoreAwayTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreAwayTeam = scoreAwayTeam;
    }

    @Override
    public String toString() {
        return "Match{" +
                "uuid=" + uuid +
                ", scoreHomeTeam=" + scoreHomeTeam +
                ", scoreAwayTeam=" + scoreAwayTeam +
                ", startDateTime=" + startDateTime +
                '}';
    }
}
