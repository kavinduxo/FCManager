package services;

import models.DateTime;
import models.FootballClub;
import models.SportsClub;

import java.io.Serializable;

public class MatchAppend implements Serializable {
    private DateTime matchDate;
    private SportsClub winTeam;
    private SportsClub loseTeam;
    private String venue;
    private int hGoals;
    private int aGoals;
    private String sResult;
    private String fResult;
    private String matchVs;

    public String getResult() {
        return sResult;
    }

    public String getMatchVs(){
        return matchVs;
    }

    public String getsResult(){
        return sResult;
    }

    public int gethGoals() {
        return hGoals;
    }

    public void sethGoals(int hGoals) {
        this.hGoals = hGoals;
    }

    public int getaGoals() {
        return aGoals;
    }

    public void setaGoals(int aGoals) {
        this.aGoals = aGoals;
    }

    MatchAppend(DateTime dateTime, SportsClub home, SportsClub away, Boolean draw, SportsClub winTeam){
        setMatchDate(dateTime);
        setVenue(((FootballClub) home).getHomeGround());
        matchVs = home.getName() + " vs " + away.getName();
        if (draw){
            sResult = "Drawn ";
        }else {
            sResult = winTeam.getName() + " Won ";
        }
    }

    public DateTime getMatchDate() {
        return matchDate;
    }

    public String getDateAsString(){
        String sDate = getMatchDate().getDay() + "-" +  getMatchDate().getMonth() + "-" + getMatchDate().getYear();
        return sDate;
    }

    public void setMatchDate(DateTime matchDate) {
        this.matchDate = matchDate;
    }

    public SportsClub getWinTeam() {
        return winTeam;
    }

    public void setWinTeam(SportsClub winTeam) {
        this.winTeam = winTeam;
    }

    public SportsClub getLoseTeam() {
        return loseTeam;
    }

    public void setLoseTeam(SportsClub loseTeam) {
        this.loseTeam = loseTeam;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setsResult(){
        this.fResult = this.sResult + "(" + gethGoals() + "-" + getaGoals() + ")";
        this.sResult = this.fResult;
    }

}

