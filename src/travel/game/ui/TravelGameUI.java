/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travel.game.ui;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLDocument;
import reader.CityReader;

import reader.FileLoader;
/**
 *
 * @author zzxx
 */
public class TravelGameUI extends Thread{
    private int numberOfPlayer;
    private final int mainPaneW = 1200;
    private final int mainPaneH = 900;
    private Insets marginlessInsets;
    
   
    private Button newGameButton;
    private Button aboutButton;
    private Button exitButton;
    private Button loadButton;
    private Button goButton;
    private Button historyButton;
    private Button zoneOneButton;
    private Button zoneTwoButton;
    private Button zoneThreeButton;
    private Button zoneFourButton;
    private Button flightZoneButton;
    private Button saveButton;
    private Button backButtonOne;
    private Button backButtonTwo;
    private Button inGameAboutButton;
    
    private RadioButton playerRadio;
    private RadioButton computerRadio;
    private RadioButton player1Radio;
    private RadioButton computer1Radio;
    private RadioButton player2Radio;
    private RadioButton computer2Radio;
    private RadioButton player3Radio;
    private RadioButton computer3Radio;
    private RadioButton player4Radio;
    private RadioButton computer4Radio;
    private RadioButton player5Radio;
    private RadioButton computer5Radio;
    private RadioButton player6Radio;
    private RadioButton computer6Radio;
    
    
    private BorderPane mainPane;
    private GridPane splashPane;   
    private GridPane selectPlayerPane;
    private GridPane playerPane;
    private GridPane gameMapPane;
    private Pane loadPane;
    private Canvas gameMapCanvas;
    private JEditorPane aboutPane;
    private ScrollPane aboutScrollPane;
    private JEditorPane historyPane;
    private ScrollPane historyScrollPane;
    
    
    private Image flagImage;
    private ImageView flagImageView;
    private Image zoneOneImage;
    private Image zoneTwoImage;
    private Image zoneThreeImage;
    private Image zoneFourImage;
    private ImageView zoneOneImageView;
    private ImageView zoneTwoImageView;
    private ImageView zoneThreeImageView;
    private ImageView zoneFourImageView;
    private Image mapOne;
    private Image mapTwo;
    private Image mapThree;
    private Image mapFour;
    
    
    private VBox splashPaneVbox;
    private VBox rightToolBar;
    private HBox toolBar;
    private HBox inGameToolBar;
    private HBox splashPaneToolBar;
    private VBox cardBox;
    
    private HBox zoneOneTwoBox;
    
    
    
    private ComboBox selectPlayersComboBox;
    private Label text;
    private Label text2;
    private Label text3;
    private Label nameLabel;
    
    private TextField name1Field;
    private TextField name2Field;
    private TextField name3Field;
    private TextField name4Field;
    private TextField name5Field;
    private TextField name6Field;
    
    private Player player;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;
    
    private final ToggleGroup group1;
    private final ToggleGroup group2;
    private final ToggleGroup group3;
    private final ToggleGroup group4;
    private final ToggleGroup group5;
    private final ToggleGroup group6;
    
    private int clickX;
    private int clickY;
    private int currentZone;
    private int totalPlayer;
    private int currentPlayer;
    private int zoneOneCityNum;
    private int zoneTwoCityNum;
    private int zoneThreeCityNum;
    private int zoneFourCityNum;
    
    private ArrayList textFieldList;
    private final ArrayList<Player> players;
    private String[][] zoneOneCityList;
    private String[][] zoneTwoCityList;
    private String[][] zoneThreeCityList;
    private String[][] zoneFourCityList;
    
    private CityReader cr;
    private FileLoader fr;
    //private GraphicsContext gc;
 
    
    public TravelGameUI() throws IOException{
        group1 = new ToggleGroup();
        group2 = new ToggleGroup();
        group3 = new ToggleGroup();
        group4  =new ToggleGroup();
        group5 = new ToggleGroup();
        group6 = new ToggleGroup();
        initMainPane();
        numberOfPlayer = 6;
        players = new ArrayList<Player>();
        currentZone = 1;
        cr = new CityReader();
        fr = new FileLoader();
        
        
        zoneOneCityList = new String[179][5];
        zoneTwoCityList = new String[179][5];
        zoneThreeCityList = new String[179][5];
        zoneFourCityList = new String[179][5];
        
        zoneOneCityList =Arrays.copyOf(cr.readCity(1),180);
        zoneTwoCityList =Arrays.copyOf(cr.readCity(2),180);
        zoneThreeCityList =Arrays.copyOf(cr.readCity(3),180);
        zoneFourCityList =Arrays.copyOf(cr.readCity(4),180);

        printCityInfor();
    }
    
    public void initMainPane(){
        marginlessInsets = new Insets(5, 5, 5, 5);
        mainPane = new BorderPane();
        mainPane.resize(mainPaneW, mainPaneH);
        mainPane.setPadding(marginlessInsets);
        initSplashScreen();
    }
    
    public void initSplashScreen(){
        splashPane = new GridPane();
        splashPane.setVgap(4);
        splashPane.setHgap(4);
        splashPane.setPadding(new Insets(5,5,5,5));
        
        splashPaneVbox = new VBox();
        splashPaneVbox.setSpacing(10);
        splashPane.setStyle("-fx-background-image: url('file:images/Game.JPG');-fx-background-size: 1200 900");

        newGameButton = new Button("New Game");
        newGameButton.setStyle("-fx-padding: 10;-fx-background-color: lightblue;");
        newGameButton.setOnAction(e->{
            mainPane.getChildren().clear();
                    initPlayerSelectionScreen(numberOfPlayer);
    });
        loadButton = new Button("Load");
        loadButton.setStyle("-fx-padding: 10;-fx-background-color: pink;");
        loadButton.setOnAction(e->{
            mainPane.getChildren().clear();
            initLoad();
        });
        aboutButton = new Button("About");
        aboutButton.setStyle("-fx-padding: 10;-fx-background-color: lightGreen;");
        aboutButton.setOnAction(e->{
            mainPane.getChildren().clear();
            try {
                initAboutPane();
            } catch (IOException ex) {
                Logger.getLogger(TravelGameUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        exitButton = new Button("Exit");
        exitButton.setStyle("-fx-padding: 10;-fx-background-color: white;");
        exitButton.setOnAction(e->{
             System.exit(0);
        });

        newGameButton.resize(75, 75);
        loadButton.resize(75, 75);
        aboutButton.resize(75, 75);
        exitButton.resize(75, 75);
        
        
        splashPaneVbox.getChildren().add(newGameButton);
        splashPaneVbox.getChildren().add(loadButton);
        splashPaneVbox.getChildren().add(aboutButton);
        splashPaneVbox.getChildren().add(exitButton);
        splashPaneVbox.setAlignment(Pos.CENTER);
        splashPane.setAlignment(Pos.BOTTOM_CENTER);
        splashPane.add(splashPaneVbox,0,0);
        
        mainPane.setCenter(splashPane);
        
        
    }
    
    
    
    
    public HBox initToolBar(){
        toolBar = new HBox();
        toolBar.setStyle("-fx-background-image: url('file:images/background.JPG')");
        toolBar.setPadding(marginlessInsets);
        toolBar.setSpacing(10);
        toolBar.setPrefSize(320, 110);
        text = new Label("Number of players:");
        text.setPrefSize(120, 40);
        selectPlayersComboBox = new ComboBox();
        selectPlayersComboBox.getItems().addAll(
        "2","3","4","5","6"
        );
        selectPlayersComboBox.setValue(numberOfPlayer);
        goButton = new Button("GO");
        goButton.setOnAction(e->{
            mainPane.getChildren().clear();
            
            for(int i = 0; i<numberOfPlayer; i++){
                    
                    
                    player = new Player();
                    switch(i){
                        case 0:     player.setName(name1Field.getText());
                        
                            break;
                        case 1:     player.setName(name2Field.getText());
                            break;
                        case 2:     player.setName(name3Field.getText());
                            break;
                        case 3:    player.setName(name4Field.getText());
                            break;
                        case 4:     player.setName(name5Field.getText());
                            break;
                        case 5:     player.setName(name6Field.getText());
                            break;
                            
                    
                    
                    
                    }
                    players.add(player);
            }
            /*
                    
                    player1.setName(name1Field.getText());
            player2.setName(name2Field.getText());
            player3.setName(name3Field.getText());
            player4.setName(name4Field.getText());
            player5.setName(name5Field.getText());
            player6.setName(name6Field.getText());
           /
            try {
                k();
                //this.start();
            } catch (Exception ex) {
                Logger.getLogger(TravelGameUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            */
        initNewGameScreen();
        
        });
        
        
        
        selectPlayersComboBox.setOnAction(e->{
            numberOfPlayer = selectPlayersComboBox.getSelectionModel().getSelectedIndex()+2;
           initPlayerSelectionScreen(numberOfPlayer);
        });
        toolBar.getChildren().add(text);
        toolBar.getChildren().add(selectPlayersComboBox);
        toolBar.getChildren().add(goButton);
       
        toolBar.autosize();
        toolBar.setSpacing(3);
        
        return toolBar;
    }
    
    public Pane createPlayerPane(int i){
         playerPane = new GridPane();
         text = new Label("Player");
         text2 = new Label("Computer");
         text3 = new Label("Name:");
         
         
         playerPane.setPrefSize(396, 386);
         playerPane.setStyle("-fx-border-color:red;-fx-border-width:3;");
         /*
            playerRadio = new RadioButton();
            playerRadio.setToggleGroup(group);
            playerRadio.setSelected(true);
            computerRadio = new RadioButton();
            computerRadio.setToggleGroup(group);
            playerRadio.setSelected(false);
            
            playerRadio.setOnAction(e->{
                if(playerRadio.isSelected())
                {
                    playerRadio.setSelected(true);
                    computerRadio.setSelected(false);
                    
                }
                else
                {
                    playerRadio.setSelected(false);
                    computerRadio.setSelected(true);
                }
            });
            
            computerRadio.setOnAction(e->{
                if(computerRadio.isSelected())
                {
                    playerRadio.setSelected(true);
                    computerRadio.setSelected(false);
                }
                else
                {
                    playerRadio.setSelected(false);
                    computerRadio.setSelected(true);
                }
            });
                 */   

            
            switch(i){
                case 1:            flagImage  = new Image("file:images/flag_black.png");
                                        flagImageView = new ImageView(flagImage);
                                        name1Field=new TextField("Player 1");
                                        playerPane.add(name1Field, 6,5);
                                        player1 = new Player();
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);                                       
                                        player1Radio = new RadioButton();
                                        player1Radio.setToggleGroup(group1);
                                        player1Radio.setSelected(true);
                                        computer1Radio = new RadioButton();
                                        computer1Radio.setToggleGroup(group1);
                                        computer1Radio.setSelected(false);
                                        playerPane.add(player1Radio,4,4);
                                        playerPane.add(computer1Radio,4,5);

                    break;
                case 2:            flagImage  = new Image("file:images/flag_blue.png");
                                        flagImageView = new ImageView(flagImage);
                                        name2Field=new TextField("Player 2");
                                        playerPane.add(name2Field, 6,5);
                                        player2 = new Player();
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);
                                        
                                        player2Radio = new RadioButton();
                                         player2Radio.setToggleGroup(group2);
                                        player2Radio.setSelected(true);
                                         computer2Radio = new RadioButton();
                                         computer2Radio.setToggleGroup(group2);
                                         computer2Radio.setSelected(false);
                                        
                                        playerPane.add(player2Radio,4,4);
                                        playerPane.add(computer2Radio,4,5);
                                         
                    break;
                case 3:            flagImage  = new Image("file:images/flag_green.png");
                                        flagImageView = new ImageView(flagImage);
                                        name3Field=new TextField("Player 3");
                                        playerPane.add(name3Field, 6,5);
                                        player3 = new Player();
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);
                                        
                                         player3Radio = new RadioButton();
                                        player3Radio.setToggleGroup(group3);
                                        player3Radio.setSelected(true);
                                         computer3Radio = new RadioButton();
                                        computer3Radio.setToggleGroup(group3);
                                        computer3Radio.setSelected(false);
                                        playerPane.add(player3Radio,4,4);
                                        playerPane.add(computer3Radio,4,5);
                                        
                    break;
                case 4:            flagImage  = new Image("file:images/flag_red.png");
                                        flagImageView = new ImageView(flagImage);
                                        name4Field=new TextField("Player 4");
                                        playerPane.add(name4Field, 6,5);
                                        player4 = new Player();
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);
                                        player4Radio = new RadioButton();
                                        player4Radio.setToggleGroup(group4);
                                        player4Radio.setSelected(true);
                                        computer4Radio = new RadioButton();
                                        computer4Radio.setToggleGroup(group4);
                                        computer4Radio.setSelected(false);
                                        playerPane.add(player4Radio,4,4);
                                        playerPane.add(computer4Radio,4,5);
                                         
                    break;
                case 5:            flagImage  = new Image("file:images/flag_white.png");
                                        flagImageView = new ImageView(flagImage);
                                        name5Field=new TextField("Player 5");
                                        playerPane.add(name5Field, 6,5);
                                        player5 = new Player();
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);
                                        player5Radio = new RadioButton();
                                         player5Radio.setToggleGroup(group5);
                                        player5Radio.setSelected(true);
                                        computer5Radio = new RadioButton();
                                        computer5Radio.setToggleGroup(group5);
                                        computer5Radio.setSelected(false);
                                        playerPane.add(player5Radio,4,4);
                                        playerPane.add(computer5Radio,4,5);
                                         
                    break;
                case 6:            flagImage  = new Image("file:images/flag_yellow.png");
                                        flagImageView = new ImageView(flagImage);
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);
                                        name6Field=new TextField("Player 6");
                                        playerPane.add(name6Field, 6,5);
                                        player6 = new Player();
                                        flagImageView.setFitHeight(80);
                                        flagImageView.setFitWidth(80);
                                        player6Radio = new RadioButton();
                                        player6Radio.setToggleGroup(group6);
                                        player6Radio.setSelected(true);
                                        computer6Radio = new RadioButton();
                                        computer6Radio.setToggleGroup(group6);
                                        
                                        playerPane.add(player6Radio,4,4);
                                        playerPane.add(computer6Radio,4,5);
                                         
                    break;
            }
            

            Label tampLa = new Label();
            tampLa.setGraphic(flagImageView);
            tampLa.setStyle("-fx-border-color:black;");
            playerPane.add(tampLa,2,8);
            //playerPane.add(playerRadio,4,4);
            playerPane.add(text, 5, 4);
            //playerPane.add(computerRadio,4,5);
            playerPane.add(text2,5,5);
            playerPane.add(text3,6,4);
            
            
            
        
        
        return playerPane;
    }
    
    
    public void initPlayerSelectionScreen(int number){
        selectPlayerPane = new GridPane();
        selectPlayerPane.setPrefSize(1190, 890);
        selectPlayerPane.setStyle("-fx-background-image: url('file:images/background.JPG')");
        selectPlayerPane.setStyle("-fx-border-color:green;-fx-border-width: 5;");
        selectPlayerPane.setHgap(0);
        selectPlayerPane.setVgap(0);
        
        textFieldList = new ArrayList();
       
        for(int i = 1; i<=number; i++){
            if(i<=3)
            selectPlayerPane.add(createPlayerPane(i), i, 0);
            else
                selectPlayerPane.add(createPlayerPane(i), i-3, 1);
        }
        mainPane.setTop(initToolBar());
        mainPane.setCenter(selectPlayerPane);
    }
    
    public void initNewGameScreen(){
        
        
        mainPane.setLeft(initCardPane());
        mainPane.setCenter(gameMapPane());
        mainPane.setRight(rightToolBarPane());
        
        for(int i=0; i< numberOfPlayer; i++)
            System.out.println(players.get(i).getName());
        
    }
    
    public VBox initCardPane()
    {
        cardBox = new VBox();
        cardBox.setPrefSize(200, 850);
        cardBox.setStyle( "-fx-border-stylel:solid;-fx-border-width:1pt; -fx-border-color:black;");
        
        return cardBox;
    }
    
    

    
    public void initLoad(){
        loadPane = new Pane();
        loadPane.setPrefSize(1150, 850);
        loadPane.getChildren().add(initSplashToolBar());
        mainPane.setTop(loadPane);
    }

    
    public BorderPane getMainPane(){
        return mainPane;
    }
    
        public Canvas gameMapPaneTwo(){
        gameMapCanvas = new Canvas(856,890);

        //currentZone = play
        mapOne = new Image("file:images/gameplay_DF14.jpg",856,890,false,false);

        gameMapCanvas.getGraphicsContext2D().drawImage(mapOne, 0, 0, 856, 890);
        gameMapCanvas.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        gameMapCanvas.setOnMouseClicked(e->{
        clickX = (int)e.getX();
        clickY= (int)e.getY();
        System.out.println(clickX*1903/856 +": " + gameMapCanvas.getWidth());
        System.out.println(clickY*2585/890+": "+ gameMapCanvas.getHeight());
        
        for(int i = 0; i<zoneTwoCityNum; i++){
                if((clickX*1903/856)>= parseInt(zoneTwoCityList[i][3])-30 && (clickX*1903/856)<= parseInt(zoneTwoCityList[i][3])+30)
                    if((clickY*2585/890)>= parseInt(zoneTwoCityList[i][4])-30 && (clickY*2585/890)<= parseInt(zoneTwoCityList[i][4])+30)
                        System.out.println("YOU CLICK ON CITY :" + zoneTwoCityList[i][0]);
        }
        });

        return gameMapCanvas;
    }
        
        
        
        public Canvas gameMapPaneThree(){
        gameMapCanvas = new Canvas(856,890);

        //currentZone = play
        mapOne = new Image("file:images/gameplay_AC58.jpg",856,890,false,false);

        gameMapCanvas.getGraphicsContext2D().drawImage(mapOne, 0, 0, 856, 890);
        gameMapCanvas.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        gameMapCanvas.setOnMouseClicked(e->{
        clickX = (int)e.getX();
        clickY= (int)e.getY();
        System.out.println(clickX*1985/856 +": " + gameMapCanvas.getWidth());
        System.out.println(clickY*2583/890+": "+ gameMapCanvas.getHeight());
        
        for(int i = 0; i<zoneThreeCityNum; i++){
                if((clickX*1985/856)>= parseInt(zoneThreeCityList[i][3])-30 && (clickX*1985/856)<= parseInt(zoneThreeCityList[i][3])+30)
                    if((clickY*2583/890)>= parseInt(zoneThreeCityList[i][4])-30 && (clickY*2583/890)<= parseInt(zoneThreeCityList[i][4])+30)
                        System.out.println("YOU CLICK ON CITY :" + zoneThreeCityList[i][0]);
        }
        });

        return gameMapCanvas;
    }
            
            
        public Canvas gameMapPaneFour(){
        gameMapCanvas = new Canvas(856,890);

        //currentZone = play
        mapOne = new Image("file:images/gameplay_DF58.jpg",856,890,false,false);

        gameMapCanvas.getGraphicsContext2D().drawImage(mapOne, 0, 0, 856, 890);
        gameMapCanvas.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        gameMapCanvas.setOnMouseClicked(e->{
        clickX = (int)e.getX();
        clickY= (int)e.getY();
        System.out.println(clickX*1927/856 +": " + gameMapCanvas.getWidth());
        System.out.println(clickY*2561/890+": "+ gameMapCanvas.getHeight());
        
        for(int i = 0; i<zoneFourCityNum; i++){
                if((clickX*1927/856)>= parseInt(zoneFourCityList[i][3])-30 && (clickX*1927/856)<= parseInt(zoneFourCityList[i][3])+30)
                    if((clickY*2561/890)>= parseInt(zoneFourCityList[i][4])-30 && (clickY*2561/890)<= parseInt(zoneFourCityList[i][4])+30)
                        System.out.println("YOU CLICK ON CITY :" + zoneFourCityList[i][0]);
        }
        });

        return gameMapCanvas;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public Canvas gameMapPane(){
        gameMapCanvas = new Canvas(856,890);

        //currentZone = play
        mapOne = new Image("file:images/gameplay_AC14.jpg",856,890,false,false);

        gameMapCanvas.getGraphicsContext2D().drawImage(mapOne, 0, 0, 856, 890);
        gameMapCanvas.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        gameMapCanvas.setOnMouseClicked(e->{
        clickX = (int)e.getX();
        clickY= (int)e.getY();
        System.out.println(clickX*2010/856 +": " + gameMapCanvas.getWidth());
        System.out.println(clickY*2569/890+": "+ gameMapCanvas.getHeight());
        
        for(int i = 0; i<zoneOneCityNum; i++){
                if((clickX*2010/856)>= parseInt(zoneOneCityList[i][3])-30 && (clickX*2010/856)<= parseInt(zoneOneCityList[i][3])+30)
                    if((clickY*2569/890)>= parseInt(zoneOneCityList[i][4])-30 && (clickY*2569/890)<= parseInt(zoneOneCityList[i][4])+30)
                        System.out.println("YOU CLICK ON CITY :" + zoneOneCityList[i][0]);
        }
        });

        return gameMapCanvas;
    }
    
    public GridPane gameMapPaneQ(){
        gameMapPane= new GridPane();
        gameMapPane.setPrefSize(850,850);
        gameMapPane.resize(850,850);
        
        //GraphicsContext gc = this.getGraphicsContext2D();
        //gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gameMapPane.setStyle("-fx-background-image: url('file:images/gameplay_AC14.jpg');-fx-background-size: 856 890");
        //gameMapPane.
        gameMapPane.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        gameMapPane.setOnMouseClicked(e->{
            
        clickX = (int)e.getX();
        clickY= (int)e.getY();
        System.out.println(clickX*2010/856+": " + gameMapPane.getWidth());
        System.out.println(clickY*2569/890+": "+ gameMapPane.getHeight());
        System.out.println(parseInt(zoneOneCityList[0][3]));
        System.out.println(parseInt(zoneOneCityList[0][4]));
        System.out.println(zoneOneCityList[0][0]);
        for(int i = 0; i<35; i++){
                if((clickX*2010/856)>= parseInt(zoneOneCityList[i][3])-5 && (clickX*2010/856)<= parseInt(zoneOneCityList[i][3])+5)
                    if((clickY*2569/890)>= parseInt(zoneOneCityList[i][4])-5 && (clickY*2569/890)<= parseInt(zoneOneCityList[i][4])+5)
                        System.out.println("YOU CLICK ON CITY :" + zoneOneCityList[i][0]);
                
                }
            
        });
       // gameMapPane.getChildren().add(gameMapCanvas);
        return gameMapPane;
    }
    
    
    public VBox rightToolBarPane(){
        rightToolBar = new VBox();
        
        rightToolBar.setPrefSize(100,850);
        

        
        historyButton = new Button("History");
        historyButton.setOnAction(e->{
            try {
                initHistoryPane();
            } catch (IOException ex) {
                Logger.getLogger(TravelGameUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        inGameAboutButton = new Button("About");
        inGameAboutButton.setOnAction(e->{
            mainPane.getChildren().clear();
            try {
                initInGameAboutPane();
            } catch (IOException ex) {
                Logger.getLogger(TravelGameUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        zoneOneButton = new Button();
        
        zoneTwoButton = new Button();
        zoneThreeButton  = new Button();
        zoneFourButton = new Button();
        
        flightZoneButton  = new Button("Flight Zone");
        
        saveButton = new Button("Save Game");
        
        
        zoneOneImage = new Image("file:images/zone1.jpg");
        zoneOneImageView = new ImageView(zoneOneImage);
        zoneOneButton.setGraphic(zoneOneImageView);
        zoneOneButton.setOnAction(e->{
             mainPane.setLeft(initCardPane());
             mainPane.setCenter(gameMapPane());
             mainPane.setRight(rightToolBarPane());
        });
        
        zoneTwoImage = new Image("file:images/zone2.jpg");
        zoneTwoImageView = new ImageView(zoneTwoImage);
        zoneTwoButton.setGraphic(zoneTwoImageView);
                zoneTwoButton.setOnAction(e->{
             mainPane.setLeft(initCardPane());
             mainPane.setCenter(gameMapPaneTwo());
             mainPane.setRight(rightToolBarPane());
        });
        
        zoneThreeImage = new Image("file:images/zone3.jpg");
        zoneThreeImageView = new ImageView(zoneThreeImage);
        zoneThreeButton.setGraphic(zoneThreeImageView);
                zoneThreeButton.setOnAction(e->{
             mainPane.setLeft(initCardPane());
             mainPane.setCenter(gameMapPaneThree());
             mainPane.setRight(rightToolBarPane());
        });
        
        zoneFourImage = new Image("file:images/zone4.jpg");
        zoneFourImageView = new ImageView(zoneFourImage);
        zoneFourButton.setGraphic(zoneFourImageView);
                zoneFourButton.setOnAction(e->{
             mainPane.setLeft(initCardPane());
             mainPane.setCenter(gameMapPaneFour());
             mainPane.setRight(rightToolBarPane());
        });
        zoneFourButton.setStyle("-fx-base: lightgray; -fx-background-color : lightgray;");
        rightToolBar.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        rightToolBar.setAlignment(Pos.CENTER);
        
        rightToolBar.getChildren().addAll(historyButton,inGameAboutButton,zoneOneButton,zoneTwoButton,zoneThreeButton,zoneFourButton,flightZoneButton,saveButton);
        return rightToolBar;
    }
    
    
    public void initHistoryPane() throws IOException{
        mainPane.getChildren().clear();
        
        historyPane = new JEditorPane();
        historyPane.setEditable(false);
        historyPane.setContentType("text/html");
        historyPane.setText(fr.getHistoryText());
        //HTMLDocument statsDoc = (HTMLDocument) historyPane.getDocument();
        //docManager.setStatsDoc(statsDoc);
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(historyPane);
        historyScrollPane = new ScrollPane();
        historyScrollPane.setContent(swingNode);
        historyScrollPane.setFitToWidth(true);
        historyScrollPane.setFitToHeight(true);
        mainPane.setTop(initInGameToolBar());
        mainPane.setCenter(historyScrollPane);
    }
    
    public void initInGameAboutPane() throws IOException{
        mainPane.getChildren().clear();
        aboutPane = new JEditorPane();
        aboutPane.setEditable(false);
        aboutPane.setContentType("text/html");
        aboutPane.setText(fr.getAboutText());
        //HTMLDocument statsDoc = (HTMLDocument) historyPane.getDocument();
        //docManager.setStatsDoc(statsDoc);
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(aboutPane);
        aboutScrollPane = new ScrollPane();
        aboutScrollPane.setContent(swingNode);
        aboutScrollPane.setFitToWidth(true);
        aboutScrollPane.setFitToHeight(true);
        mainPane.setTop(initInGameToolBar());
        mainPane.setCenter(aboutScrollPane);
    }
    
    public void initAboutPane() throws IOException{
        mainPane.getChildren().clear();
        aboutPane = new JEditorPane();
        aboutPane.setEditable(false);
        aboutPane.setContentType("text/html");
        aboutPane.setText(fr.getAboutText());
        //HTMLDocument statsDoc = (HTMLDocument) historyPane.getDocument();
        //docManager.setStatsDoc(statsDoc);
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(aboutPane);
        aboutScrollPane = new ScrollPane();
        aboutScrollPane.setContent(swingNode);
        aboutScrollPane.setFitToWidth(true);
        aboutScrollPane.setFitToHeight(true);
        mainPane.setTop(initSplashToolBar());
        mainPane.setCenter(aboutScrollPane);
    }
      
    public HBox initSplashToolBar(){
        backButtonOne = new Button("BACK");
        backButtonOne.setOnAction(e->{
            mainPane.getChildren().clear();
            initSplashScreen();
        });
        splashPaneToolBar = new HBox();
        splashPaneToolBar.setAlignment(Pos.CENTER);
        splashPaneToolBar.getChildren().add(backButtonOne);
        return splashPaneToolBar;
    }
    
    
    
    public HBox initInGameToolBar(){
        backButtonTwo = new Button("BACK");
        backButtonTwo.setOnAction(e->{
            mainPane.getChildren().clear();
            initNewGameScreen();
        });
        inGameToolBar = new HBox();
        inGameToolBar.setAlignment(Pos.CENTER);
        inGameToolBar.getChildren().add(backButtonTwo);
        return inGameToolBar;
    }
    
    public void printCityInfor(){
        int counterI = 0;
        
        while(zoneOneCityList[counterI][0]!=null){
            System.out.println(zoneOneCityList[counterI][0]+ " " +zoneOneCityList[counterI][1] + " " + zoneOneCityList[counterI][2]
            +" " +zoneOneCityList[counterI][3]+" "+zoneOneCityList[counterI][4] );
            counterI++;
            zoneOneCityNum++;
    }
        
        counterI =0;
        while(zoneTwoCityList[counterI][0]!=null){
            System.out.println(zoneTwoCityList[counterI][0]+ " " +zoneTwoCityList[counterI][1] + " " + zoneTwoCityList[counterI][2]
            +" " +zoneTwoCityList[counterI][3]+" "+zoneTwoCityList[counterI][4] );
            counterI++;
            zoneTwoCityNum++;
    }
        counterI =0;
        while(zoneThreeCityList[counterI][0]!=null){
            System.out.println(zoneThreeCityList[counterI][0]+ " " +zoneThreeCityList[counterI][1] + " " + zoneThreeCityList[counterI][2]
            +" " +zoneThreeCityList[counterI][3]+" "+zoneThreeCityList[counterI][4] );
            counterI++;
            zoneThreeCityNum++;
    }
        counterI =0;
        while(zoneFourCityList[counterI][0]!=null){
            System.out.println(zoneFourCityList[counterI][0]+ " " +zoneFourCityList[counterI][1] + " " + zoneFourCityList[counterI][2]
            +" " +zoneFourCityList[counterI][3]+" "+zoneFourCityList[counterI][4] );
            counterI++;
            zoneFourCityNum++;
    }
       
        
        System.out.println(zoneOneCityNum+": "+zoneTwoCityNum+": "+zoneThreeCityNum+": "+zoneFourCityNum);
         System.out.println(zoneTwoCityList[0][0]);
    }
    /*
    protected void k() throws Exception {
        Platform.runLater(new Runnable() {
               @Override public void run() {
                    int i = 0;
                    int j = 9999;
                    while(j>i){
           

            initNewGameScreen();
            try {
                     Thread.sleep(30);
            } catch (InterruptedException ie) {
            }
            i++;
        }
    }
                });
    }
  */
    
    @Override
    public void run(){
        int i = 0;
        int j = 9999;
        while(j>i){
           

            initNewGameScreen();
            try {
                     Thread.sleep(17);
            } catch (InterruptedException ie) {
            }
            i++;
        }
    }
    
    
}
