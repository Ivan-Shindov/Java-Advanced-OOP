package demo;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private Integer ratting;


    public Team(String name){
        setName(name);
        this.players=new ArrayList<>();
        this.ratting=0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty()){
            throw  new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer(Player player){
        if(!players.contains(player)){
            throw new IllegalArgumentException("Player " + player.getName() +" is not in " + this.name+" team.");
        }
        this.players.remove(player);
    }
    public void setRatting(){
        Integer currRating=0;
        for (Player player : this.players) {
            currRating+=player.getOverallSkill();
        }
        if(currRating==0){
            this.ratting=currRating;
        }else {
            currRating = (int) Math.round(currRating / players.size());
            this.ratting = currRating;
        }
    }
    public Integer getRatting(){
        return this.ratting;
    }
}
