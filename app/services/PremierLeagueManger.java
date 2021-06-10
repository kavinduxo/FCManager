package services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PremierLeagueManger implements ILeagueManager, Serializable {
    ArrayList<SportsClub> fSportsClubs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    ArrayList<MatchAppend> matchHistory = new ArrayList<>();
    List<List> summaryArray = new ArrayList<List>();
    MatchAppend newMatch;

    /**text variables*/
    String nameTxt = "Enter the club name\t: ";
    String regNoTxt = "Enter the club Registration no\t: ";
    String locTxt = "Enter the Location\t: ";
    String populationTxt = "Enter the club member population\t: ";
    String sYearTxt = "Enter Club Started Year\t: ";
    String abbreviationTxt = "Enter Club Abbreviation\t: ";
    String clubMangerTxt = "Enter Club Manager\t: ";
    String hGroundTxt = "Enter the Home Ground\t: ";
    String mainSponsorTxt = "Enter the main sponsor\t: ";

    /**getters*/
    public ArrayList<SportsClub> getfSportsClubs() {
        return fSportsClubs;
    }
    public ArrayList<MatchAppend> getMatchHistory() {
        return matchHistory;
    }
    public MatchAppend getNewMatch() {
        return newMatch;
    }

    /**setters*/
    public void setNewMatch(MatchAppend newMatch) {
        this.newMatch = newMatch;
    }

    @Override
    public int getNumberOfClubs() {
        return fSportsClubs.size();
    }

    @Override
    public void newClubAddToLeague(){
        String loop1;
        System.out.print(nameTxt);
        String name = sc.nextLine();
        System.out.print(regNoTxt);
        String regNo = sc.nextLine();
        System.out.print(locTxt);
        String location = sc.nextLine();
        System.out.print(populationTxt);
        int memberPopulation = 0;
        do {
            try{
                memberPopulation = Integer.parseInt(sc.nextLine());
                loop1 = "no";
            }catch (NumberFormatException e){
                System.out.print(e + "\nRe-Enter the population\t: ");
                loop1 = "yes";
            }
        }while (loop1.equals("yes"));

        System.out.print(sYearTxt);
        int sYear = 0;
        do {
            try{
                sYear = Integer.parseInt(sc.nextLine());
                loop1 = "no";
            }catch (NumberFormatException e){
                System.out.print(e + "\nRe-Enter the Club Started Year\t: ");
                loop1 = "yes";
            }
        }while (loop1.equals("yes"));

        System.out.print(abbreviationTxt);
        String abbreviation = sc.nextLine().toUpperCase();
        System.out.print(clubMangerTxt);
        String clubManager = sc.nextLine();
        System.out.print(hGroundTxt);
        String homeGround = sc.nextLine();
        System.out.print(mainSponsorTxt);
        String mainSponsor = sc.nextLine();

        SportsClub newFC = new FootballClub(abbreviation, clubManager, homeGround, mainSponsor);
        newFC.setName(name);
        newFC.setRegistrationNo(regNo);
        newFC.setLocation(location);
        newFC.setMemberPopulation(memberPopulation);
        newFC.setStartYear(sYear);
        fSportsClubs.add(newFC);
        System.out.println("Successfully Added..!");
    }

    @Override
    public void removeClubFromLeague() throws InvalidInputException {
        System.out.print(abbreviationTxt);
        String abbreviation = sc.nextLine().toUpperCase();
        int removeCount = 0;
        for (SportsClub footballClub: fSportsClubs) {
            if (abbreviation.equals(((FootballClub) footballClub).getAbbreviation())){
                System.out.println(((FootballClub) footballClub).getAbbreviation() + " - " + footballClub.getName() + " has removed from the PremierLeague.");
                fSportsClubs.remove(footballClub);
                removeCount++;
                break;
            }
        }
        if(removeCount == 0){
            throw new InvalidInputException(abbreviation + " is not in the list...");
        }
    }

    @Override
    public void updateClubDetails() throws InvalidInputException {
        System.out.print(abbreviationTxt);
        String abb = sc.nextLine().toUpperCase();
        int updateCount = 0;
        for (SportsClub footClub: fSportsClubs) {
            if(((FootballClub) footClub).getAbbreviation().equals(abb)){
                System.out.print("To Update Manger enter 'M' \n   Update Sponsor enter 'S'\n   Update Club Wroth enter 'W'\n   Update club population enter 'P'\n: ");
                String input = sc.nextLine();
                String loop2;
                updateCount++;
                switch (input.toUpperCase()){
                    case "M":
                        System.out.print("Enter new Manager Name : ");
                        String manager = sc.nextLine();
                        ((FootballClub) footClub).setClubManager(manager);
                        break;
                    case "S":
                        System.out.print("Enter new Sponsor Name : ");
                        String sponsor = sc.nextLine();
                        ((FootballClub) footClub).setMainSponsor(sponsor);
                        break;
                    case "W":
                        do {
                            try {
                                System.out.print("Enter latest club Wroth : ");
                                double wroth = Double.parseDouble(sc.nextLine());
                                ((FootballClub) footClub).setNetWorth(wroth);
                                loop2 = "no";
                            }catch (NumberFormatException e){
                                System.out.println(e);
                                loop2 = "yes";
                            }
                        }while (loop2.equals("yes"));
                        break;
                    case "P":
                        do {
                            try {
                                System.out.print("Enter latest population : ");
                                int pop = Integer.parseInt(sc.nextLine());
                                footClub.setMemberPopulation(pop);
                                loop2 = "no";
                            }catch (NumberFormatException e){
                                System.out.println(e);
                                loop2 = "yes";
                            }
                        }while (loop2.equals("yes"));
                        break;
                    default:
                        throw new InvalidInputException("Invalid command..!");
                }
                if (updateCount == 0){
                    System.out.println(abb + " is not in the list...");
                }
            }
        }
    }

    @Override
    public void viewClubStats(){
        Collections.sort(fSportsClubs);
        System.out.println("Number of clubs participating : " + getNumberOfClubs() + "\n------------------------------------------------");
        System.out.println("Club Name\t\tRegistration No\t\tStarted Year\t\tPoints\t\tShort Name\t\tSponsor");
        for (SportsClub footballClub: fSportsClubs) {
            System.out.println(footballClub.getName() + "\t\t" +
            footballClub.getRegistrationNo()+ "\t\t\t" +
            footballClub.getStartYear()+ "\t\t\t\t" +
            footballClub.getPoints()+ "\t\t\t" +
            ((FootballClub) footballClub).getAbbreviation()+ "\t\t" +
            ((FootballClub) footballClub).getMainSponsor());
        }
        viewLeagueStatsByGui(fSportsClubs);
    }

    @Override
    public void getClubStats() throws InvalidInputException {
        System.out.print(abbreviationTxt);
        String abb = sc.nextLine().toUpperCase();
        int getCount = 0;
        for (SportsClub footballClub: fSportsClubs){
            FootballClub footballClub1 = ((FootballClub) footballClub);
            if (abb.equals(footballClub1.getAbbreviation())){
                System.out.println("\t"+footballClub.getName() + " - " + (footballClub1.getAbbreviation()));
                System.out.println("Points In the Season\t: " + footballClub.getPoints());
                System.out.println("Club Started Year\t\t: " + footballClub.getStartYear());
                System.out.println("Club Manager\t\t\t: " + footballClub1.getClubManager());
                System.out.println("Location\t\t\t\t: " + footballClub.getLocation());
                System.out.println("Home Ground\t\t\t\t: " + footballClub1.getHomeGround());
                System.out.println("Member Population \t\t: " + footballClub.getMemberPopulation());
                System.out.println("Main Sponsor\t\t\t: " + footballClub1.getMainSponsor());
                System.out.println("Number Of Matches\t\t: " + footballClub1.getNumberOfMatches());
                System.out.println("Number OF Wins\t\t\t: " + footballClub1.getNumberOfWins());
                System.out.println("Number oF Draws\t\t\t: " + footballClub1.getNumberOfDrawn());
                System.out.println("Number oF Lost\t\t\t: " + footballClub1.getNumberOfLost());
                System.out.println("Club Win Accuracy\t\t: " + footballClub1.getWinAccuracy());
                System.out.println("Club Net Wroth\t\t\t: " + footballClub1.getNetWorth());
                getCount++;
            }
        }
        if (getCount == 0){
            throw new InvalidInputException(abb + " is not in the list...");
        }
    }

    @Override
    public void updatePlayedMatch() {
        System.out.println("Enter the Home Team details..");
        System.out.print(abbreviationTxt);
        String abb1 = sc.nextLine().toUpperCase();
        System.out.println("Enter the Away Team details..");
        System.out.print(abbreviationTxt);
        String abb2 = sc.nextLine().toUpperCase();
        matchUpdate(abb1, abb2);
    }

    public void showMatchHistory() {
        for (MatchAppend mo:matchHistory) {
            System.out.println("* Match Date   : " + mo.getMatchDate().getDate());
            System.out.println("  Match Between: " + mo.getMatchVs());
            System.out.println("  Match Result : " + mo.getsResult());
            System.out.println("  Match Venue  : " + mo.getVenue() + "\n");
        }
    }

    public void saveToFile() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("LeagueData.txt");
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        List<List> newSummaryArray = new ArrayList<>();
        newSummaryArray.add(fSportsClubs);
        newSummaryArray.add(matchHistory);
        objectOutputStream.writeObject(newSummaryArray);
        objectOutputStream.close();
        System.out.println("Data has saved successfully...");

    }

    public void loadFromFile() throws Exception {
        FileInputStream fileInputStream;
        try{
            fileInputStream = new FileInputStream("LeagueData.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            summaryArray = (List<List>)objectInputStream.readObject();
            fSportsClubs = (ArrayList<SportsClub>) summaryArray.get(0);
            matchHistory = (ArrayList<MatchAppend>) summaryArray.get(1);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (EOFException e){
            System.out.println(e);
        }
    }

    private void matchUpdate(String abb1, String abb2){
        int count1 = 0;
        int count2 = 0;
        for (SportsClub footClub: fSportsClubs) {
            if(((FootballClub) footClub).getAbbreviation().equals(abb1)){
                count1++;
                for (SportsClub footClub1 : fSportsClubs) {
                    if (((FootballClub) footClub1).getAbbreviation().equals(abb2)){
                        count2++;
                        ((FootballClub) footClub).setNumberOfMatches();
                        ((FootballClub) footClub1).setNumberOfMatches();
                        String clubName = footClub.getName();
                        String clubName1 = footClub1.getName();

                        int day;
                        do {
                            System.out.print("Enter Day\t: ");
                            try{
                                day = Integer.parseInt(sc.nextLine());
                                if (day > 0 && day <= 31){
                                    break;
                                }else {
                                    throw new InvalidDateException("Day should be between 1 and 31");
                                }
                            }catch (NumberFormatException | InvalidDateException e){
                                System.out.println(e);
                            }
                        }while (true);

                        int month;
                        do {
                            System.out.print("Enter Month\t: ");
                            try{
                                month = Integer.parseInt(sc.nextLine());
                                if (month > 0 && month <= 12){
                                    break;
                                }else {
                                    throw new InvalidDateException("Month is not in the range..");
                                }
                            }catch (NumberFormatException | InvalidDateException e){
                                System.out.println(e);
                            }
                        }while (true);

                        int year;
                        do {
                            System.out.print("Enter Year\t: ");
                            try{
                                year = Integer.parseInt(sc.nextLine());
                                if (year > 0 && year <= 2100){
                                    break;
                                }else {
                                    throw new InvalidDateException("Year is not in the range..");
                                }
                            }catch (NumberFormatException | InvalidDateException e){
                                System.out.println(e);
                            }
                        }while (true);

                        DateTime dateTime = new DateTime(day, month, year, 00, 00, 00);
                        MatchAppend matchAppend = null;
                        String winCondition = String.format("If %s won the match enter '1', if %s won the match enter '-1', if drawn the match enter '0'. \n : ",clubName, clubName1);
                        int result;
                        do {
                            System.out.print(winCondition);
                            try{
                                result = Integer.parseInt(sc.nextLine());
                                if (result == 1 || result == -1 || result == 0){
                                    break;
                                }else{
                                    throw new InvalidInputException("Invalid input...");
                                }
                            }catch (NumberFormatException | InvalidInputException e){
                                System.out.println(e);
                            }
                        }while (true);

                        switch (result){
                            case 1:
                                ((FootballClub) footClub).setNumberOfWins();
                                ((FootballClub) footClub1).setNumberOfLost();
                                matchAppend = new MatchAppend(dateTime,footClub, footClub1, false, footClub);
                                matchHistory.add(matchAppend);
                                break;
                            case 0:
                                ((FootballClub) footClub).setNumberOfDrawn();
                                ((FootballClub) footClub1).setNumberOfDrawn();
                                matchAppend = new MatchAppend(dateTime, footClub, footClub1, true, footClub);
                                matchHistory.add(matchAppend);
                                break;
                            case -1:
                                ((FootballClub) footClub1).setNumberOfWins();
                                ((FootballClub) footClub).setNumberOfLost();
                                matchAppend = new MatchAppend(dateTime,footClub, footClub1, false, footClub1);
                                matchHistory.add(matchAppend);
                                break;
                            default:
                                System.out.println("Invalid match result condition has entered..");
                        }
                        String homeGoals = String.format("Enter thr Goals scored by %s: ", clubName);
                        int hGoals;
                        do {
                            System.out.print(homeGoals);
                            try{
                                hGoals = Integer.parseInt(sc.nextLine());
                                if (hGoals >= 0){
                                    break;
                                }else {
                                    throw new NegativeValueException("Should be a positive value..");
                                }
                            }catch(NumberFormatException | NegativeValueException e){
                                System.out.println(e);
                            }
                        }while (true);
                        ((FootballClub) footClub).setNumberOfGoalsScored(hGoals);
                        ((FootballClub) footClub1).setNumberOfGoalsConceded(hGoals);

                        String awayGoals = String.format("Enter thr Goals scored by %s: ", clubName1);
                        int aGoals;
                        do {
                            System.out.print(awayGoals);
                            try{
                                aGoals = Integer.parseInt(sc.nextLine());
                                if (aGoals >= 0){
                                    break;
                                }else {
                                    throw new NegativeValueException("Should be a positive value..");
                                }
                            }catch(NumberFormatException | NegativeValueException e){
                                System.out.println(e);
                            }
                        }while (true);
                        matchAppend.sethGoals(hGoals);
                        matchAppend.setaGoals(aGoals);
                        matchAppend.setsResult();
                        ((FootballClub) footClub1).setNumberOfGoalsScored(aGoals);
                        ((FootballClub) footClub).setNumberOfGoalsConceded(aGoals);

                        footClub.setPoints();
                        footClub1.setPoints();
                    }
                }
            }
        }
        if (count1 == 0){
            System.out.println(abb1 + " is not in the list...");
        }else if (count2 == 0){
            System.out.println(abb2 + " is not in the list...");
        }
    }

    private void viewLeagueStatsByGui(ArrayList<SportsClub> fSportsClubs) {
        Stage stageOne = new Stage();
        TableView<SportsClub> leagueTab;
        BorderPane outPane = new BorderPane();
        Scene subScene;
        stageOne.setTitle("Premier League Stats Table");

        TableColumn<SportsClub, String> clubNameCol = new TableColumn<>("Club Name");
        clubNameCol.setMinWidth(125);
        clubNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<SportsClub, String> clubAbbCol = new TableColumn<>("Abb.");
        clubAbbCol.setMinWidth(75);
        clubAbbCol.setCellValueFactory(new PropertyValueFactory<>("abbreviation"));

        TableColumn<SportsClub, Integer> clubTMatchCol = new TableColumn<>("Total Matches");
        clubTMatchCol.setMinWidth(75);
        clubTMatchCol.setCellValueFactory(new PropertyValueFactory<>("numberOfMatches"));

        TableColumn<SportsClub, Integer> clubWMatchCol = new TableColumn<>("Wins");
        clubWMatchCol.setMinWidth(75);
        clubWMatchCol.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));

        TableColumn<SportsClub, Integer> clubDMatchCol = new TableColumn<>("Drawn");
        clubDMatchCol.setMinWidth(75);
        clubDMatchCol.setCellValueFactory(new PropertyValueFactory<>("numberOfDrawn"));

        TableColumn<SportsClub, Integer> clubLMatchCol = new TableColumn<>("Lost");
        clubLMatchCol.setMinWidth(75);
        clubLMatchCol.setCellValueFactory(new PropertyValueFactory<>("numberOfLost"));

        TableColumn<SportsClub, Integer> clubGScored = new TableColumn<>("GS");
        clubGScored.setMinWidth(50);
        clubGScored.setCellValueFactory(new PropertyValueFactory<>("NumberOfGoalsScored"));

        TableColumn<SportsClub, Integer> clubGCon = new TableColumn<>("GC");
        clubGCon.setMinWidth(50);
        clubGCon.setCellValueFactory(new PropertyValueFactory<>("NumberOfGoalsConceded"));

        TableColumn<SportsClub, Integer> clubGDiff = new TableColumn<>("Goal Diff");
        clubGDiff.setMinWidth(50);
        clubGDiff.setCellValueFactory(new PropertyValueFactory<>("GoalDiff"));

        TableColumn<SportsClub, Integer> clubPointsCol = new TableColumn<>("Points");
        clubPointsCol.setMinWidth(50);
        clubPointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableColumn<SportsClub, Integer> clubWinAccCol = new TableColumn<>("Win%");
        clubWinAccCol.setMinWidth(50);
        clubWinAccCol.setCellValueFactory(new PropertyValueFactory<>("WinAccuracy"));

        leagueTab = new TableView<>();
        ObservableList<SportsClub> footballClubs = FXCollections.observableArrayList();
        for (SportsClub s: fSportsClubs) {
            footballClubs.add(s);
        }
        leagueTab.setItems(footballClubs);
        leagueTab.getColumns().addAll(clubNameCol, clubAbbCol, clubTMatchCol, clubWMatchCol, clubDMatchCol, clubLMatchCol, clubGScored, clubGCon, clubGDiff, clubPointsCol, clubWinAccCol);
        outPane.setCenter(leagueTab);

        Text titleTxt = new Text();
        titleTxt.setFill(Paint.valueOf("#2c5b86"));
        titleTxt.setText("Premier League 2020");
        titleTxt.setStyle("-fx-font: 40 Broadway;");

        Image logoImg = new Image(getClass().getResourceAsStream("Logo.png"));
        ImageView logoView = new ImageView();
        logoView.setImage(logoImg);
        logoView.setFitHeight(100);
        logoView.setFitWidth(100);

        AnchorPane rightPane = new AnchorPane();
        rightPane.setMinWidth(200);

        Button btnNewMatch = new Button("New");
        Tooltip addNewTip = new Tooltip("Add a new Match");
        Tooltip.install(btnNewMatch, addNewTip);

        Button btnHistory = new Button("History");
        Tooltip histTip = new Tooltip("View the season History");
        Tooltip.install(btnHistory, histTip);

        Button btnSearch = new Button("Search");
        Tooltip searTip = new Tooltip("View the season History");
        Tooltip.install(btnSearch, searTip);

        btnNewMatch.setMinSize(70, 30);
        btnHistory.setMinSize(70, 30);
        btnSearch.setMinSize(70, 30);

        RadioButton wins, goals, def;
        ToggleGroup sorts = new ToggleGroup();
        VBox sortSet = new VBox();
        Label lblSort = new Label("Sort By:");
        lblSort.setStyle("-fx-font: 15 Georgia");
        wins = new RadioButton("Club wins");
        wins.setToggleGroup(sorts);
        goals = new RadioButton("Goals scored");
        goals.setToggleGroup(sorts);
        def = new RadioButton("Default");
        def.setToggleGroup(sorts);
        sortSet.getChildren().addAll(lblSort, wins, goals, def);
        Button btnSort = new Button("Sort");
        btnSort.setMinSize(70, 30);

        AnchorPane.setTopAnchor(btnNewMatch, 40.0);
        AnchorPane.setLeftAnchor(btnNewMatch, 40.0);
        AnchorPane.setTopAnchor(btnHistory, 80.0);
        AnchorPane.setLeftAnchor(btnHistory, 40.0);
        AnchorPane.setTopAnchor(btnSearch, 120.0);
        AnchorPane.setLeftAnchor(btnSearch, 40.0);
        AnchorPane.setTopAnchor(sortSet, 160.0);
        AnchorPane.setLeftAnchor(sortSet, 30.0);
        AnchorPane.setTopAnchor(btnSort,240.0);
        AnchorPane.setLeftAnchor(btnSort, 40.0);

        rightPane.getChildren().addAll(btnNewMatch, btnHistory, btnSearch, sortSet, btnSort);
        outPane.setRight(rightPane);

        AnchorPane leftPane = new AnchorPane();
        leftPane.setMinWidth(100);
        outPane.setLeft(leftPane);

        AnchorPane topPane = new AnchorPane();
        AnchorPane.setTopAnchor(titleTxt, 25.0);
        AnchorPane.setLeftAnchor(titleTxt, 400.0);
        AnchorPane.setLeftAnchor(logoView, 85.0);
        topPane.getChildren().addAll(logoView, titleTxt);
        outPane.setTop(topPane);

        subScene = new Scene(outPane);
        stageOne.setScene(subScene);
        btnNewMatch.setOnAction(event -> {
            newMatchFromGui();
            leagueTab.refresh();
        });

        btnSort.setOnAction(event -> {
            sortTable(leagueTab, clubWMatchCol, clubGScored, clubPointsCol, clubGDiff, wins, goals);
        });

        btnHistory.setOnAction(event -> {
            viewMatchHistoryGui(matchHistory);
        });

        btnSearch.setOnAction(event -> {
            searchDialog();
        });
        stageOne.showAndWait();

    }

    private void searchDialog(){
        Dialog<String> searchDialog = new Dialog<>();
        searchDialog.setTitle("Search by date");
        HBox hBox1 = new HBox();
        TextField day = new TextField();
        TextField mon = new TextField();
        TextField year = new TextField();
        day.setMaxWidth(30.0);
        mon.setMaxWidth(30.0);
        year.setMaxWidth(50.0);
        hBox1.getChildren().addAll(day, mon, year);
        hBox1.setSpacing(7.0);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox();
        Label lblDay = new Label("Day");
        Label lblMon = new Label("Month");
        Label lblYear = new Label("Year");
        hBox2.getChildren().addAll(lblDay, lblMon, lblYear);
        hBox2.setSpacing(10.0);
        hBox2.setAlignment(Pos.CENTER);

        Button btnSearch = new Button("Search");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2, btnSearch);
        vBox.setAlignment(Pos.CENTER);

        ButtonType btnClose = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        searchDialog.getDialogPane().getButtonTypes().addAll(btnClose);
        searchDialog.getDialogPane().setContent(vBox);
        btnSearch.setOnAction(event -> {
            ArrayList<MatchAppend> certainHistory = new ArrayList<>();
            for (MatchAppend ma: matchHistory) {
                if (ma.getMatchDate().getDay() == Integer.parseInt(day.getText()) && ma.getMatchDate().getMonth() == Integer.parseInt(mon.getText()) && ma.getMatchDate().getYear() == Integer.parseInt(year.getText())){
                    certainHistory.add(ma);
                }
            }
            viewMatchHistoryGui(certainHistory);
            searchDialog.close();
        });
        searchDialog.showAndWait();
    }

    private void viewMatchHistoryGui(ArrayList<MatchAppend> matchAppend){
        Stage historyStage = new Stage();
        TableView<MatchAppend> histTab;
        BorderPane outPane = new BorderPane();
        Scene subScene;
        historyStage.setTitle("Season History");

        TableColumn<MatchAppend, DateTime> colMatchDate = new TableColumn<>("Match Date");
        colMatchDate.setMinWidth(125);
        colMatchDate.setCellValueFactory(new PropertyValueFactory<>("DateAsString"));

        TableColumn<MatchAppend, String> colMatchBetween = new TableColumn<>("Match VS");
        colMatchBetween.setMinWidth(175);
        colMatchBetween.setCellValueFactory(new PropertyValueFactory<>("MatchVs"));

        TableColumn<MatchAppend, String> colResult = new TableColumn<>("Final Result");
        colResult.setMinWidth(175);
        colResult.setCellValueFactory(new PropertyValueFactory<>("Result"));

        TableColumn<MatchAppend, String> colVenue = new TableColumn<>("Venue");
        colVenue.setMinWidth(125);
        colVenue.setCellValueFactory(new PropertyValueFactory<>("venue"));

        TableColumn<MatchAppend, DateTime> colDate = new TableColumn<>("Date");
        colDate.setMinWidth(125);
        colDate.setVisible(false);
        colDate.setCellValueFactory(new PropertyValueFactory<>("matchDate"));

        histTab = new TableView<>();
        ObservableList<MatchAppend> matches = FXCollections.observableArrayList();
        for (MatchAppend s: matchAppend) {
            matches.add(s);
        }
        histTab.setItems(matches);
        histTab.getColumns().addAll(colMatchDate, colMatchBetween, colResult, colVenue, colDate);
        histTab.getSortOrder().removeAll(colDate);
        histTab.getSortOrder().add(colDate);
        if (histTab.getSortOrder().contains(colDate)) {
            colDate.setSortType(TableColumn.SortType.ASCENDING);
        }
        outPane.setCenter(histTab);
        subScene = new Scene(outPane);
        historyStage.setScene(subScene);
        historyStage.showAndWait();
    }

    private TableView<SportsClub> sortTable(TableView leagueTab, TableColumn<SportsClub, Integer> colWins, TableColumn<SportsClub, Integer> colGoals, TableColumn<SportsClub, Integer> colPoints, TableColumn<SportsClub, Integer> colGDiff, RadioButton rbWin, RadioButton rbGoals){
        if(rbWin.isSelected()){
            leagueTab.getSortOrder().removeAll(colGoals, colPoints, colWins, colGDiff);
            leagueTab.getSortOrder().add(colWins);
            if (leagueTab.getSortOrder().contains(colWins)) {
                colWins.setSortType(TableColumn.SortType.DESCENDING);
            }
        }else if (rbGoals.isSelected()){
            leagueTab.getSortOrder().removeAll(colGoals, colPoints, colWins, colGDiff);
            leagueTab.getSortOrder().add(colGoals);
            if (leagueTab.getSortOrder().contains(colGoals)) {
                colGoals.setSortType(TableColumn.SortType.DESCENDING);
            }
        }else {
            leagueTab.getSortOrder().removeAll(colGoals, colPoints, colWins, colGDiff);
            leagueTab.getSortOrder().add(colPoints);
            if (leagueTab.getSortOrder().contains(colPoints)) {
                colPoints.setSortType(TableColumn.SortType.DESCENDING);
            }
            leagueTab.getSortOrder().add(colGDiff);
            if (leagueTab.getSortOrder().contains(colGDiff)) {
                colGDiff.setSortType(TableColumn.SortType.DESCENDING);
            }
        }
        return  leagueTab;
    }

    public void newMatchFromGui(){
        Random random = new Random();
        int rTeam1 = random.nextInt(fSportsClubs.size());
        int rTeam2;
        do {
            rTeam2 = random.nextInt(fSportsClubs.size());
        }while (rTeam1 == rTeam2);
        int team1Goals = random.nextInt(10);
        int team2Goals = random.nextInt(10);

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add a Match");

        String teamA = fSportsClubs.get(rTeam1).getName();
        String teamB = fSportsClubs.get(rTeam2).getName();
        Label lblTeam1 = new Label(teamA);
        Label lblTeam2 = new Label(teamB);
        Label lblVs    = new Label("VS");
        lblTeam1.setStyle("-fx-font:20 Harrington;");
        lblTeam2.setStyle("-fx-font:20 Harrington;");
        Label lblScore1 = new Label(String.valueOf(team1Goals));
        Label lblScore2 = new Label(String.valueOf(team2Goals));
        lblScore1.setStyle("-fx-font:15 Stencil;");
        lblScore2.setStyle("-fx-font:15 Stencil;");
        Button btnSave = new Button("Save");
        ButtonType btnClose = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(btnClose);

        VBox verticalAlign = new VBox();
        HBox teams = new HBox();
        teams.setAlignment(Pos.CENTER);
        teams.setSpacing(50.0);
        teams.getChildren().addAll(lblTeam1, lblVs, lblTeam2);
        teams.setMinWidth(600.0);
        teams.setMinHeight(50.0);
        lblTeam1.setAlignment(Pos.CENTER);
        lblTeam2.setAlignment(Pos.CENTER);
        lblVs.setAlignment(Pos.CENTER);

        HBox scores = new HBox();
        scores.setAlignment(Pos.CENTER);
        scores.setSpacing(50.0);
        Label lblSpace    = new Label(" - ");
        scores.getChildren().addAll(lblScore1, lblSpace, lblScore2);
        scores.setMinWidth(600.0);
        scores.setMinHeight(20);
        lblScore1.setAlignment(Pos.CENTER);
        lblSpace.setAlignment(Pos.CENTER);
        lblScore2.setAlignment(Pos.CENTER);
        Label lblResult;
        if (team1Goals > team2Goals){
            lblResult = new Label(teamA + " has won the match");
        }else if (team2Goals > team1Goals){
            lblResult = new Label(teamB + " has won the match.");
        }else {
            lblResult = new Label("Match has drawn. Each team will reward by a point.");
        }

        Date today = new Date();
        LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        TextField txtYear = new TextField();
        int year = localDate.getYear();
        txtYear.setText(String.valueOf(year));
        txtYear.setMaxWidth(60.0);
        txtYear.setAlignment(Pos.CENTER);
        txtYear.setDisable(true);

        TextField txtMonth = new TextField();
        int month = localDate.getMonthValue();
        txtMonth.setMaxWidth(40.0);
        txtMonth.setAlignment(Pos.CENTER);
        txtMonth.setText(String.valueOf(month));

        TextField txtDay = new TextField();
        int day = localDate.getDayOfMonth();
        txtDay.setMaxWidth(40.0);
        txtDay.setAlignment(Pos.CENTER);
        txtDay.setText(String.valueOf(day));

        Label lblDate = new Label("Match Date(DD/MM/YYYY)");

        HBox dateBox = new HBox();
        dateBox.getChildren().addAll(txtDay, txtMonth, txtYear, lblDate);
        dateBox.setSpacing(7.0);
        dateBox.setMinHeight(60.0);
        dateBox.setAlignment(Pos.CENTER);

        verticalAlign.setAlignment(Pos.CENTER);

        verticalAlign.getChildren().addAll(teams, scores, lblResult, dateBox, btnSave);
        dialog.getDialogPane().setContent(verticalAlign);
        DateTime dateTime = new DateTime(day, month, year, 00, 00, 00);
        int finalRTeam = rTeam2;
        btnSave.setOnAction(event -> {
            MatchAppend matchAppend;
            if (team1Goals > team2Goals){
                ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfWins();
                ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfLost();
                matchAppend = new MatchAppend(dateTime, fSportsClubs.get(rTeam1), fSportsClubs.get(finalRTeam), false, fSportsClubs.get(rTeam1));
                matchAppend.sethGoals(team1Goals);
                matchAppend.setaGoals(team2Goals);
                matchAppend.setWinTeam(fSportsClubs.get(rTeam1));
            }else if(team2Goals > team1Goals){
                ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfWins();
                ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfLost();
                matchAppend = new MatchAppend(dateTime, fSportsClubs.get(rTeam1), fSportsClubs.get(finalRTeam), false, fSportsClubs.get(finalRTeam));
                matchAppend.sethGoals(team1Goals);
                matchAppend.setaGoals(team2Goals);
            }else{
                ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfDrawn();
                ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfDrawn();
                matchAppend = new MatchAppend(dateTime, fSportsClubs.get(rTeam1), fSportsClubs.get(finalRTeam), true, fSportsClubs.get(finalRTeam));
                matchAppend.sethGoals(team1Goals);
                matchAppend.setaGoals(team2Goals);
                matchAppend.setWinTeam(fSportsClubs.get(finalRTeam));
            }
            matchAppend.setsResult();
            matchHistory.add(matchAppend);

            ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfMatches();
            ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfMatches();
            ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfGoalsScored(team1Goals);
            ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfGoalsConceded(team2Goals);
            ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfGoalsScored(team2Goals);
            ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfGoalsConceded(team1Goals);

            fSportsClubs.get(rTeam1).setPoints();
            fSportsClubs.get(finalRTeam).setPoints();

            dialog.close();
        });
        dialog.showAndWait();
    }

    public void newMatchFromAngular(){
        Random random = new Random();
        int rTeam1 = random.nextInt(2);
        int rTeam2;
        do {
            rTeam2 = random.nextInt(fSportsClubs.size());
        }while (rTeam1 == rTeam2);
        int team1Goals = random.nextInt(10);
        int team2Goals = random.nextInt(10);

        String teamA = fSportsClubs.get(rTeam1).getName();
        String teamB = fSportsClubs.get(rTeam2).getName();

        Date today = new Date();
        LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        DateTime dateTime = new DateTime(day, month, year, 00, 00, 00);
        int finalRTeam = rTeam2;
            MatchAppend matchAppend;
            if (team1Goals > team2Goals){
                ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfWins();
                ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfLost();
                matchAppend = new MatchAppend(dateTime, fSportsClubs.get(rTeam1), fSportsClubs.get(finalRTeam), false, fSportsClubs.get(rTeam1));
                matchAppend.sethGoals(team1Goals);
                matchAppend.setaGoals(team2Goals);
                matchAppend.setWinTeam(fSportsClubs.get(rTeam1));
            }else if(team2Goals > team1Goals){
                ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfWins();
                ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfLost();
                matchAppend = new MatchAppend(dateTime, fSportsClubs.get(rTeam1), fSportsClubs.get(finalRTeam), false, fSportsClubs.get(finalRTeam));
                matchAppend.sethGoals(team1Goals);
                matchAppend.setaGoals(team2Goals);
            }else{
                ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfDrawn();
                ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfDrawn();
                matchAppend = new MatchAppend(dateTime, fSportsClubs.get(rTeam1), fSportsClubs.get(finalRTeam), true, fSportsClubs.get(finalRTeam));
                matchAppend.sethGoals(team1Goals);
                matchAppend.setaGoals(team2Goals);
                matchAppend.setWinTeam(fSportsClubs.get(finalRTeam));
            }
            matchAppend.setsResult();
            matchHistory.add(matchAppend);
            setNewMatch(matchAppend);

            ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfMatches();
            ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfMatches();
            ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfGoalsScored(team1Goals);
            ((FootballClub) fSportsClubs.get(rTeam1)).setNumberOfGoalsConceded(team2Goals);
            ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfGoalsScored(team2Goals);
            ((FootballClub) fSportsClubs.get(finalRTeam)).setNumberOfGoalsConceded(team1Goals);

            fSportsClubs.get(rTeam1).setPoints();
            fSportsClubs.get(finalRTeam).setPoints();

    }
}
