package demo;

public class Player {
    private String name;
    private Integer endurance;
    private Integer sprint;
    private Integer dribble;
    private Integer passing ;
    private Integer shooting;

    public Player(String name,Integer endurance,Integer sprint,Integer dribble,Integer passing,Integer shooting){
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
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

    private void setEndurance(Integer endurance) {
        if(endurance<0||endurance>100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(Integer sprint) {
        if(sprint<0||sprint>100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private  void setDribble(Integer dribble) {
        if(dribble<0||dribble>100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(Integer passing) {
        if(passing<0||passing>100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(Integer shooting) {
        if(shooting<0|shooting>100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }



    public Integer getOverallSkill(){
        return (int)Math.round((this.endurance+this.sprint+this.dribble+this.passing+this.shooting)/5.0);

    }
}
