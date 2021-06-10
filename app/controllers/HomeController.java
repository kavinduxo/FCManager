package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.FootballClub;
import models.ILeagueManager;
import models.SportsClub;
import play.libs.Json;
import play.mvc.*;
import services.MatchAppend;
import services.PremierLeagueManger;

import java.util.ArrayList;

class SeasonSummary{
    private ArrayList<SportsClub> fClubs = new ArrayList<>();
    SeasonSummary(ArrayList<SportsClub> fClubs){
        setfClubs(fClubs);
    }
    public ArrayList<SportsClub> getfClubs() {
        return fClubs;
    }
    private void setfClubs(ArrayList<SportsClub> fClubs) {
        this.fClubs = fClubs;
        for (int i = 0; i < this.fClubs.size(); i++) {
            for (int j = i+1; j < this.fClubs.size(); j++) {
                if(this.fClubs.get(i).getPoints() < this.fClubs.get(j).getPoints()) {
                    SportsClub temp;
                    temp = this.fClubs.get(i);
                    this.fClubs.set(i, this.fClubs.get(j));
                    this.fClubs.set(j, temp);
                }else if (this.fClubs.get(i).getPoints() == this.fClubs.get(j).getPoints()){
                    if(((FootballClub) this.fClubs.get(i)).getGoalDiff() < ((FootballClub) this.fClubs.get(j)).getGoalDiff()){
                        SportsClub temp;
                        temp = this.fClubs.get(i);
                        this.fClubs.set(i, this.fClubs.get(j));
                        this.fClubs.set(j, temp);
                    }
                }
            }
        }
    }
}

class SeasonSummaryAppend{
    private ArrayList<SportsClub> fClubs = new ArrayList<>();
    private MatchAppend matchAppend;

    SeasonSummaryAppend(ArrayList<SportsClub> fClubs, MatchAppend newMatch){
        setfClubs(fClubs);
        setMatchAppend(newMatch);
    }

    public MatchAppend getMatchAppend() {
        return matchAppend;
    }

    public void setMatchAppend(MatchAppend matchAppend) {
        this.matchAppend = matchAppend;
    }
    public ArrayList<SportsClub> getfClubs() {
        return fClubs;
    }
    private void setfClubs(ArrayList<SportsClub> fClubs) {
        this.fClubs = fClubs;
        for (int i = 0; i < this.fClubs.size(); i++) {
            for (int j = i+1; j < this.fClubs.size(); j++) {
                if(this.fClubs.get(i).getPoints() < this.fClubs.get(j).getPoints()) {
                    SportsClub temp;
                    temp = this.fClubs.get(i);
                    this.fClubs.set(i, this.fClubs.get(j));
                    this.fClubs.set(j, temp);
                }
            }
        }
    }
}

class SeasonSummaryWins{
    private ArrayList<SportsClub> fClubs = new ArrayList<>();
    SeasonSummaryWins(ArrayList<SportsClub> fClubs){
        setfClubs(fClubs);
    }
    public ArrayList<SportsClub> getfClubs() {
        return fClubs;
    }
    private void setfClubs(ArrayList<SportsClub> fClubs) {
        this.fClubs = fClubs;
        for (int i = 0; i < this.fClubs.size(); i++) {
            for (int j = i+1; j < this.fClubs.size(); j++) {
                if(this.fClubs.get(i).getPoints() < this.fClubs.get(j).getPoints()) {
                    SportsClub temp;
                    temp = this.fClubs.get(i);
                    this.fClubs.set(i, this.fClubs.get(j));
                    this.fClubs.set(j, temp);
                }
            }
        }
    }
}

class SeasonSummaryGoals{
    private ArrayList<SportsClub> fClubs = new ArrayList<>();
    SeasonSummaryGoals(ArrayList<SportsClub> fClubs){
        setfClubs(fClubs);
    }
    public ArrayList<SportsClub> getfClubs() {
        return fClubs;
    }
    private void setfClubs(ArrayList<SportsClub> fClubs) {
        this.fClubs = fClubs;
        for (int i = 0; i < this.fClubs.size(); i++) {
            for (int j = i+1; j < this.fClubs.size(); j++) {
                if(((FootballClub) this.fClubs.get(i)).getNumberOfGoalsScored() < ((FootballClub) this.fClubs.get(j)).getNumberOfGoalsScored()) {
                    SportsClub temp;
                    temp = this.fClubs.get(i);
                    this.fClubs.set(i, this.fClubs.get(j));
                    this.fClubs.set(j, temp);
                }
            }
        }
    }
}

class NewMatch{
    public MatchAppend getMatchAppend() {
        return matchAppend;
    }

    public void setMatchAppend(MatchAppend matchAppend) {
        this.matchAppend = matchAppend;
    }

    private MatchAppend matchAppend;
    NewMatch(MatchAppend matchAppend){
        setMatchAppend(matchAppend);
    }
}

class SeasonHistory{
    private ArrayList<MatchAppend> history = new ArrayList<>();
    SeasonHistory(ArrayList<MatchAppend> history){
        setHistory(history);
    }
    public ArrayList<MatchAppend> getHistory() {
        return history;
    }
    private void setHistory(ArrayList<MatchAppend> history) {
        this.history = history;
        for (int i = 0; i < this.history.size(); i++) {
            for (int j = i+1; j < this.history.size(); j++) {
                if(this.history.get(i).getMatchDate().getYear() > this.history.get(j).getMatchDate().getYear()) {
                    MatchAppend temp;
                    temp = this.history.get(i);
                    this.history.set(i, this.history.get(j));
                    this.history.set(j, temp);
                }else if ((this.history.get(i).getMatchDate().getYear() == this.history.get(j).getMatchDate().getYear()) && ((this.history.get(i).getMatchDate().getMonth()) > this.history.get(j).getMatchDate().getMonth())){
                    MatchAppend temp;
                    temp = this.history.get(i);
                    this.history.set(i, this.history.get(j));
                    this.history.set(j, temp);
                }else if ((this.history.get(i).getMatchDate().getYear() == this.history.get(j).getMatchDate().getYear()) && ((this.history.get(i).getMatchDate().getMonth()) == this.history.get(j).getMatchDate().getMonth()) && ((this.history.get(i).getMatchDate().getDay()) > this.history.get(j).getMatchDate().getDay())){
                    MatchAppend temp;
                    temp = this.history.get(i);
                    this.history.set(i, this.history.get(j));
                    this.history.set(j, temp);
                }
            }
        }
    }
}

public class HomeController extends Controller {

    public Result postTest() throws Exception {
        ArrayList<SportsClub> fClubs = new ArrayList<>();
        ILeagueManager leagueManager = new PremierLeagueManger();
        ((PremierLeagueManger) leagueManager).loadFromFile();
        ((PremierLeagueManger) leagueManager).newMatchFromAngular();
        ((PremierLeagueManger) leagueManager).saveToFile();
        JsonNode jsonNode = Json.toJson(new SeasonSummary(((PremierLeagueManger) leagueManager).getfSportsClubs()));
        return ok(jsonNode).as("application/json");
    }


    public Result pointsView() throws Exception {
        ILeagueManager leagueManager = new PremierLeagueManger();
        ((PremierLeagueManger) leagueManager).loadFromFile();
        JsonNode jsonNode = Json.toJson(new SeasonSummary(((PremierLeagueManger) leagueManager).getfSportsClubs()));
        return ok(jsonNode).as("application/json");
    }

    public Result winsView() throws Exception {
        ILeagueManager leagueManager = new PremierLeagueManger();
        ((PremierLeagueManger) leagueManager).loadFromFile();
        JsonNode jsonNode = Json.toJson(new SeasonSummaryWins(((PremierLeagueManger) leagueManager).getfSportsClubs()));
        return ok(jsonNode).as("application/json");
    }

    public Result goalsView() throws Exception {
        ILeagueManager leagueManager = new PremierLeagueManger();
        ((PremierLeagueManger) leagueManager).loadFromFile();
        JsonNode jsonNode = Json.toJson(new SeasonSummaryGoals(((PremierLeagueManger) leagueManager).getfSportsClubs()));
        return ok(jsonNode).as("application/json");
    }

    public Result historyView() throws Exception {
        ILeagueManager leagueManager = new PremierLeagueManger();
        ((PremierLeagueManger) leagueManager).loadFromFile();
        JsonNode jsonNode = Json.toJson(new SeasonHistory(((PremierLeagueManger) leagueManager).getMatchHistory()));
        return ok(jsonNode).as("application/json");
    }

    public Result createMatch() throws Exception {
        ArrayList<SportsClub> fClubs = new ArrayList<>();
        ILeagueManager leagueManager = new PremierLeagueManger();
        ((PremierLeagueManger) leagueManager).loadFromFile();
        ((PremierLeagueManger) leagueManager).newMatchFromAngular();
        ((PremierLeagueManger) leagueManager).saveToFile();
        SeasonSummaryAppend seasonSummary = new SeasonSummaryAppend(((PremierLeagueManger) leagueManager).getfSportsClubs(), ((PremierLeagueManger) leagueManager).getNewMatch());
        JsonNode jsonNode = Json.toJson(seasonSummary);
        return ok(jsonNode).as("application/json");
    }

}
