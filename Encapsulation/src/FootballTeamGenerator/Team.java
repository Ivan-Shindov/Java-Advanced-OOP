package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
            this.players.add(player);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void removePlayer(Player player) {
       if (!this.players.contains(player)) {
            throw new IllegalArgumentException("Player " + player.getName() + " is not in " + this.name +" team.");
        }
       this.players.remove(player);
    }

    public int getRating() {
        double currRate = 0.0;
        for (Player player : players) {
            currRate += player.overallSkillLevel();
        }
        if (currRate == 0) {
            return 0;
        }

        return (int) Math.round(currRate / this.players.size());
    }
}
