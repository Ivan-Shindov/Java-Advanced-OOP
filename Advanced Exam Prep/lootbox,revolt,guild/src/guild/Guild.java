package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name,int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer (Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = new ArrayList<>();

        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getClazz().equals(clazz)) {
                list.add(player);
                this.roster.remove(player);
                i--;
            }
        }
        Player[] players = new Player[list.size()];

        for (int i = 0; i < list.size(); i++) {
            players[i] = list.get(i);
        }
        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Players in the guild: %s:%n",this.name));
        for (Player player : this.roster) {
            result.append(player.toString()).append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}
