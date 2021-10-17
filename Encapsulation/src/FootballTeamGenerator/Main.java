package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// must to fix ! 33/100
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String input = buff.readLine();

        List<Team> teams = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");

            switch (tokens[0]) {
                case "Team":
                    try {
                        Team team = new Team(tokens[1]);
                        teams.add(team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                    break;
                case "Add":
                    String teamName = tokens[1];
                    String playerName = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);

                    boolean isTeam = false;
                    for (Team team : teams) {
                        if(team.getName().equals(teamName)){
                            isTeam = true;
                            break;
                        }
                    }

                    if (!isTeam) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }

                    boolean isAdded = false;
                    try {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        players.add(player);
                        for (Team team : teams) {
                            if (team.getName().equals(teamName)) {
                                isAdded = true;
                                team.addPlayer(player);
                            }
                        }
                        if (!isAdded) {
                            System.out.println("Team "+teamName+" does not exist.");
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }

                    break;
                case "Remove":
                    teamName = tokens[1];
                    playerName = tokens[2];

                    boolean isTeamPre = false;
                    for (Team team : teams) {
                        if(team.getName().equals(teamName)){
                            isTeamPre = true;
                            break;
                        }
                    }

                    if (!isTeamPre) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }

                    Player player = null;
                    for (Player currentPlayer : players) {
                        if (currentPlayer.getName().equals(playerName)) {
                            player = currentPlayer;
                        }
                    }
                    if (player == null) {
                        System.out.printf("Player %s is not in %s team.%n",playerName,teamName);
                        break;
                    }

                    try {
                        for (Team team : teams) {
                            if (team.getName().equals(teamName)) {
                                team.removePlayer(player);
                            }
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }

                    break;
                case "Rating":
                    teamName = tokens[1];
                    boolean isExist = false;
                    for (Team team : teams) {
                        if (team.getName().equals(teamName)) {
                            System.out.printf("%s - %d",teamName,team.getRating());
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }
                    break;

                default: break;
            }
            input = buff.readLine();
        }
    }
}
