package mareks.scoreboard.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Match  implements Comparable<Match>{

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

    public int getAbsoluteScore() {
        return scoreAwayTeam + scoreHomeTeam;
    }

    public void updateScore(int scoreHomeTeam, int scoreAwayTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreAwayTeam = scoreAwayTeam;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
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

    @Override
    public int compareTo(Match o) {
        if (this.getAbsoluteScore() != o.getAbsoluteScore()) {
            return Integer.compare(o.getAbsoluteScore(), this.getAbsoluteScore());
        } else {
            return o.getStartDateTime().compareTo(this.getStartDateTime());
        }
    }
}
