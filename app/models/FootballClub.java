package models;


public class FootballClub extends SportsClub {
    private String abbreviation;
    private String clubManager;
    private double netWorth;
    private String homeGround;
    private String mainSponsor;
    private int numberOfWins = 0;
    private int numberOfDrawn = 0;
    private int numberOfLost = 0;
    private int numberOfMatches = 0;
    private int numberOfGoalsConceded;
    private int numberOfGoalsScored;

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getNumberOfDrawn() {
        return numberOfDrawn;
    }

    //constructors
    public FootballClub(){
    }

    public FootballClub(String abbreviation, String clubManager, String homeGround, String mainSponsor){
        setAbbreviation(abbreviation);
        setClubManager(clubManager);
        setHomeGround(homeGround);
        setMainSponsor(mainSponsor);
    }

    //getter methods
    public String getAbbreviation(){
        return abbreviation;
    }

    public String getClubManager() {
        return clubManager;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public String getMainSponsor() {
        return mainSponsor;
    }

    public double getWinAccuracy() {
        return (((double) numberOfWins) / ((double) numberOfMatches)) * 100;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getNumberOfGoalsConceded() {
        return numberOfGoalsConceded;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public int getNumberOfLost() {
        return numberOfLost;
    }
    public int getGoalDiff(){
        return getNumberOfGoalsScored() - getNumberOfGoalsConceded();
    }

    //setter methods
    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public void setClubManager(String clubManager) {
        this.clubManager = clubManager;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    public void setMainSponsor(String mainSponsor) {
        this.mainSponsor = mainSponsor;
    }

    public void setNumberOfWins() {
        this.numberOfWins++;
    }

    public void setNumberOfMatches() {
        this.numberOfMatches ++;
    }

    public void setNumberOfGoalsConceded(int numberOfGoalsConceded) {
        this.numberOfGoalsConceded += numberOfGoalsConceded;
    }
    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored += numberOfGoalsScored;
    }

    public void setNumberOfDrawn() {
        this.numberOfDrawn++;
    }

    public void setNumberOfLost(){
        this.numberOfLost++;
    }
    @Override
    public void setPoints() {
        points = getNumberOfWins() * 2 + getNumberOfDrawn();
    }

}
