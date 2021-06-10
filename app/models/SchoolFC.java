package models;

public class SchoolFC extends FootballClub{
    private String schoolName;
    private String teacherInCharge;
    private int zonalWins;
    private int zonalMatches;
    private int zonalTitles;
    private int provinceWins;
    private int provinceMatches;
    private int provinceTitles;
    private int nationalWins;
    private int nationalTitles;
    private int nationalMatches;
    private int foreignTours;

    //getter methods
    public String getSchoolName() {
        return schoolName;
    }

    public String getTeacherInCharge() {
        return teacherInCharge;
    }

    public int getZonalWins() {
        return zonalWins;
    }

    public int getZonalMatches() {
        return zonalMatches;
    }

    public int getZonalTitles() {
        return zonalTitles;
    }

    public int getProvinceWins() {
        return provinceWins;
    }

    public int getProvinceMatches() {
        return provinceMatches;
    }

    public int getProvinceTitles() {
        return provinceTitles;
    }

    public int getNationalWins() {
        return nationalWins;
    }

    public int getNationalTitles() {
        return nationalTitles;
    }

    public int getNationalMatches() {
        return nationalMatches;
    }

    public int getForeignTours() {
        return foreignTours;
    }

    // setter methods
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setTeacherInCharge(String teacherInCharge) {
        this.teacherInCharge = teacherInCharge;
    }

    public void setZonalWins(int zonalWins) {
        this.zonalWins = zonalWins;
    }

    public void setZonalMatches(int zonalMatches) {
        this.zonalMatches = zonalMatches;
    }

    public void setZonalTitles(int zonalTitles) {
        this.zonalTitles = zonalTitles;
    }

    public void setProvinceWins(int provinceWins) {
        this.provinceWins = provinceWins;
    }

    public void setProvinceMatches(int provinceMatches) {
        this.provinceMatches = provinceMatches;
    }

    public void setProvinceTitles(int provinceTitles) {
        this.provinceTitles = provinceTitles;
    }

    public void setNationalWins(int nationalWins) {
        this.nationalWins = nationalWins;
    }

    public void setNationalTitles(int nationalTitles) {
        this.nationalTitles = nationalTitles;
    }

    public void setNationalMatches(int nationalMatches) {
        this.nationalMatches = nationalMatches;
    }

    public void setForeignTours(int foreignTours) {
        this.foreignTours = foreignTours;
    }

}
