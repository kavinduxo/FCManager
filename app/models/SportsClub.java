package models;

import java.io.Serializable;

public abstract class SportsClub implements Comparable<SportsClub>, Serializable {
    private String name;
    private String registrationNo;
    private String location;
    private int clubPopulation;
    private int startYear;
    protected int points;

    //getter methods
    public int getPoints(){
        return points;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getLocation() {
        return location;
    }

    public int getMemberPopulation() {
        return clubPopulation;
    }

    public int getStartYear() {
        return startYear;
    }


    //setter methods
    public abstract void setPoints();

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMemberPopulation(int memberPopulation) {
        this.clubPopulation = memberPopulation;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Override
    public int compareTo(SportsClub sportsClub) {
        if(this.getPoints() > sportsClub.getPoints()){
            return -1;
        }else if (this.getPoints() < sportsClub.getPoints()){
            return 1;
        }else{
            int club1Diff = ((FootballClub) this).getNumberOfGoalsScored() - ((FootballClub) this).getNumberOfGoalsConceded();
            int club2Diff = ((FootballClub) sportsClub).getNumberOfGoalsScored() - ((FootballClub) sportsClub).getNumberOfGoalsConceded();
            if (club1Diff > club2Diff){
                return -1;
            }else {
                return 1;
            }
        }
    }
}
