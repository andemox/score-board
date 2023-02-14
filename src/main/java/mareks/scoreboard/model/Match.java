package mareks.scoreboard.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Match  implements Comparable<Match>{

    UUID uuid;

    Team homeTeam = new Team(0);

    Team awayTeam = new Team(0);

    public void setupHomeTeam(Team team) {
        this.homeTeam = new Team(team.getName(), team.getScore());
    }

    public void setupAwayTeam(Team team) {
        this.awayTeam = new Team(team.getName(), team.getScore());
    }

    public String getHomeTeamName() {
        return homeTeam.getName();
    }

    public String getAwayTeamName() {
        return awayTeam.getName();
    }

    LocalDateTime startDateTime;

    public Match() {
        uuid = UUID.randomUUID();
        startDateTime = LocalDateTime.now();
    }

    public static Match setup(LocalDateTime startDateTime, int scoreHomeTeam, int scoreAwayTeam) {
        Match match = new Match();
        match.homeTeam = new Team(scoreHomeTeam);
        match.awayTeam = new Team(scoreAwayTeam);
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
        return homeTeam.getScore();
    }

    @SuppressWarnings("unused")
    public int getScoreAwayTeam() {
        return awayTeam.getScore();
    }

    public UUID getUUID() {
        return uuid;
    }

    public int getAbsoluteScore() {
        return getScoreAwayTeam() + getScoreHomeTeam();
    }

    public void updateScore(int scoreHomeTeam, int scoreAwayTeam) {
        this.homeTeam.setScore(scoreHomeTeam);
        this.awayTeam.setScore(scoreAwayTeam);
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
                ", homeTeamName='" + homeTeam + '\'' +
                ", awayTeamName='" + awayTeam + '\'' +
                ", startDateTime=" + startDateTime +
                '}';
    }
}
