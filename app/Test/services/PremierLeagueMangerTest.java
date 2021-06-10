package services;

import models.FootballClub;
import models.InvalidInputException;
import models.SportsClub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueMangerTest {


    @Test
    void removeClubFromLeague() throws InvalidInputException {
        ArrayList<SportsClub> fSportsClubs = new ArrayList<>();
        ArrayList<List> summaryArray;
        FileInputStream fileInputStream;
        String result = "";
        try{
            fileInputStream = new FileInputStream("LeagueData.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            summaryArray = (ArrayList<List>) objectInputStream.readObject();
            fSportsClubs = (ArrayList<SportsClub>) summaryArray.get(0);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (ClassNotFoundException | IOException e){
            System.out.println(e);
        }
        String abbreviation = "NCFC";
        int removeCount = 0;
        for (SportsClub footballClub: fSportsClubs) {
            if (abbreviation.equals(((FootballClub) footballClub).getAbbreviation())){
                result = ((FootballClub) footballClub).getAbbreviation() + " - " + footballClub.getName() + " has removed from the PremierLeague.";
                fSportsClubs.remove(footballClub);
                removeCount++;
                break;
            }
        }
        if(removeCount == 0){
            throw new InvalidInputException(abbreviation + " is not in the list...");
        }
        Assertions.assertEquals("NCFC - New Castle FC has removed from the PremierLeague.", result);
    }

    @Test
    void getClubStats() throws IOException, InvalidInputException {
        ArrayList<SportsClub> fSportsClubs = new ArrayList<>();
        ArrayList<List> summaryArray;
        FileInputStream fileInputStream;
        Boolean avaliableData = false;
        try{
            fileInputStream = new FileInputStream("LeagueData.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            summaryArray = (ArrayList<List>) objectInputStream.readObject();
            fSportsClubs = (ArrayList<SportsClub>) summaryArray.get(0);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (EOFException | ClassNotFoundException e){
            System.out.println(e);
        }
        String abb = "MUFC";
        int getCount = 0;
        for (SportsClub footballClub: fSportsClubs){
            FootballClub footballClub1 = ((FootballClub) footballClub);
            if (abb.equals(footballClub1.getAbbreviation())){
                avaliableData = true;
                getCount++;
            }
        }
        if (getCount == 0){
            throw new InvalidInputException(abb + " is not in the list...");
        }
        Assertions.assertEquals(true, avaliableData);
    }
}
