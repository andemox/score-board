package mareks.scoreboard.model;

public class Team {
    int score;
    String name;

    public Team(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public Team(int score) {
        this.score = score;
        this.name = "UNKNOWN";
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }
}
