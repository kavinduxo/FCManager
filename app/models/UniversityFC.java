package models;

public class UniversityFC extends FootballClub{
    private String universityName;
    private int numberOfInterUniWins;
    private int numberOfInterUniTitles;
    private int numberOfInterUniMatches;

    //getter methods
    public String getUniversityName() {
        return universityName;
    }

    public int getNumberOfInterUniWins() {
        return numberOfInterUniWins;
    }

    public int getNumberOfInterUniTitles() {
        return numberOfInterUniTitles;
    }

    public int getNumberOfInterUniMatches() {
        return numberOfInterUniMatches;
    }

    //setter methods
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setNumberOfInterUniWins(int numberOfInterUniWins) {
        this.numberOfInterUniWins = numberOfInterUniWins;
    }

    public void setNumberOfInterUniTitles(int numberOfInterUniTitles) {
        this.numberOfInterUniTitles = numberOfInterUniTitles;
    }

    public void setNumberOfInterUniMatches(int numberOfInterUniMatches) {
        this.numberOfInterUniMatches = numberOfInterUniMatches;
    }

}
