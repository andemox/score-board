package mareks.scoreboard.common;

import java.util.UUID;

public class Match {

    UUID uuid;
    int scoreHomeTeam = 0;
    int scoreAwayTeam = 0;

    public Match() {
        uuid = UUID.randomUUID();
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
}
