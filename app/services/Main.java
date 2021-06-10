package services;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import models.ILeagueManager;
import models.InvalidInputException;
import services.PremierLeagueManger;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ILeagueManager premierLeagueManger = new PremierLeagueManger();
        System.out.println("------------------------------------------------------\n\tWelcome..! Premier League Franchise...\n------------------------------------------------------");
        String loop = "yes";
        String menuInput;
        Scanner scanner = new Scanner(System.in);
        while (loop.equals("yes")) {
            System.out.print("To add a Club press 'A'\n"+
                    "To remove a Club press 'R'\n"+
                    "To update a Club press 'U'\n"+
                    "To view the League Stats press 'V'\n"+
                    "To view a Single Club details press 'G'\n" +
                    "To Update a played match press 'M' \n" +
                    "To Save data press 'S' \n" +
                    "To Load data press 'L' \n" +
                    "To Show match History press 'H' \n: ");
            menuInput = scanner.nextLine();
            String temp = "X";
            try{
                temp = menuInput.substring(0, 1).toUpperCase();
            }catch (Exception e){
                System.out.println(e);
            }

            try {
                switch (temp) {
                    case "A":
                        ((PremierLeagueManger) premierLeagueManger).newClubAddToLeague();
                        break;
                    case "R":
                        ((PremierLeagueManger) premierLeagueManger).removeClubFromLeague();
                        break;
                    case "U":
                        ((PremierLeagueManger) premierLeagueManger).updateClubDetails();
                        break;
                    case "V":
                        Runtime runtime = Runtime.getRuntime();
                        String url = "http://localhost:4200/menu";
                        runtime.exec("rundll32 url.dll,FileProtocolHandler "+ url);
                        ((PremierLeagueManger) premierLeagueManger).viewClubStats();
                        break;
                    case "G":
                        ((PremierLeagueManger) premierLeagueManger).getClubStats();
                        break;
                    case "M":
                        ((PremierLeagueManger) premierLeagueManger).updatePlayedMatch();
                        break;
                    case "S":
                        ((PremierLeagueManger) premierLeagueManger).saveToFile();
                        break;
                    case "L":
                        ((PremierLeagueManger) premierLeagueManger).loadFromFile();
                        break;
                    case "H":
                        ((PremierLeagueManger) premierLeagueManger).showMatchHistory();
                        break;
                    case "T":
                        ((PremierLeagueManger) premierLeagueManger).newMatchFromAngular();
                        break;
                    default:
                        throw new InvalidInputException("Invalid Input!!! Try again.");
                }
            }catch (InvalidInputException e){
                System.out.println(e);
            }
            System.out.print("Enter 'n' to Exit\t:");
            String value = scanner.nextLine();
            if(value.toLowerCase().equals("n")){
                ((PremierLeagueManger) premierLeagueManger).saveToFile();
                loop = "no";
            }
            System.out.println("------\n------\n------");
        }
    }
}
