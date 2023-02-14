package mareks.scoreboard.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Match  implements Comparable<Match>{

    UUID uuid;
    int scoreHomeTeam = 0;
    int scoreAwayTeam = 0;

    String homeTeamName;

    String awayTeamName;

    public void setupHomeTeam(Team team) {
        this.homeTeamName = team.getName();
        this.scoreHomeTeam = team.getScore();
    }

    public void setupAwayTeam(Team team) {
        this.awayTeamName = team.getName();
        this.scoreAwayTeam = team.getScore();
    }
    
    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

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

    public static Match setupFull(LocalDateTime startDateTime, Team homeTeam, Team awayTeam) {
        Match match = new Match();
        match.startDateTime = startDateTime;
        match.setupHomeTeam(homeTeam);
        match.setupAwayTeam(awayTeam);
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
    public int compareTo(Match o) {
        if (this.getAbsoluteScore() != o.getAbsoluteScore()) {
            return Integer.compare(o.getAbsoluteScore(), this.getAbsoluteScore());
        } else {
            return o.getStartDateTime().compareTo(this.getStartDateTime());
        }
    }

    @Override
    public String toString() {
        return "Match{" +
                "uuid=" + uuid +
                ", scoreHomeTeam=" + scoreHomeTeam +
                ", scoreAwayTeam=" + scoreAwayTeam +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", startDateTime=" + startDateTime +
                '}';
    }
}
