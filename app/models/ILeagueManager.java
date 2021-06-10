package models;

import java.io.IOException;

public interface ILeagueManager {
    int getNumberOfClubs();
    void newClubAddToLeague();
    void removeClubFromLeague() throws InvalidInputException;
    void updateClubDetails() throws InvalidInputException;
    void viewClubStats() throws IOException;
    void getClubStats() throws InvalidInputException;
    void updatePlayedMatch();

}
