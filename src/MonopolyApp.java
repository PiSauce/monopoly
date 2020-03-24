//importing the necessary java fx libraries

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


//monopoly app class
public class MonopolyApp extends Application {
	@Override
	public void start(Stage theStage) {
		
		int turn = 0;
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Landmark> route = new ArrayList<Landmark>();
		//creating the welcome label
		Label welcomeLabel = new Label("WELCOME TO MONOPOLY!");
		
		//creating the start the game button
		Button startTheGame = new Button("Start The Game");
		//adding the 'add a player button'
		Button addAPlayer = new Button("Add A Player");
		
		//setting the font type and size for each button 
		welcomeLabel.setFont(new Font("Arial", 50));
		startTheGame.setFont(new Font("Arial", 30));
		addAPlayer.setFont(new Font("Arial", 30));
		
		//starting the game
		startTheGame.setDisable(true);
		VBox vbox = new VBox(30);
		vbox.getChildren().addAll(welcomeLabel, startTheGame, addAPlayer);
		vbox.setAlignment(Pos.CENTER);
		Scene welcomeScene = new Scene(vbox);
		
		GridPane addAPlayerPanel = new GridPane();
		RowConstraints tokenRowConstraints = new RowConstraints();
		RowConstraints usernameRowConstraints = new RowConstraints();
		ColumnConstraints columnConstraints = new ColumnConstraints();
		tokenRowConstraints.setPercentHeight(35);
		usernameRowConstraints.setPercentHeight(15);
		columnConstraints.setPercentWidth(25);
		addAPlayerPanel.getRowConstraints().add(tokenRowConstraints);
		addAPlayerPanel.getRowConstraints().add(tokenRowConstraints);
		addAPlayerPanel.getRowConstraints().add(usernameRowConstraints);
		addAPlayerPanel.getRowConstraints().add(usernameRowConstraints);
		for(int j = 0; j < 4; j++) {
			addAPlayerPanel.getColumnConstraints().add(columnConstraints);
		}
		ToggleGroup group = new ToggleGroup();
		//adds the images for the icons of the game, captain america, green lantern, hulk, etc
		String[] images = {"Batman", "Captain America", "Flash", "Green Lantern", "Hulk", "Iron Man", "Robocop", "Spider-man"};
		for(int j = 0; j < 8; j++) {
			Image tempImage = new Image("Tokens/" + images[j] + ".jpg");
			RadioButton tempButton = new RadioButton(images[j]);
			ImageView tempImageView = new ImageView(tempImage);
			tempImageView.setFitWidth(150);
			tempImageView.setFitHeight(150);
			tempButton.setGraphic(tempImageView);
			tempButton.setContentDisplay(ContentDisplay.TOP);
			tempButton.setToggleGroup(group);
			addAPlayerPanel.add(tempButton, j%4, j/4);
		}
		//prompts for username after player token has been selected
		Label usernameLabel = new Label("Please select a token and enter your username:");
		usernameLabel.setFont(new Font("Arial", 20));
		TextField usernameField = new TextField();
		HBox usernameBox = new HBox(10);
		usernameBox.getChildren().addAll(usernameLabel, usernameField);
		usernameBox.setAlignment(Pos.CENTER);
		addAPlayerPanel.add(usernameBox, 0, 2, 4, 1);
		Button confirm = new Button("Confirm");
		Button cancel = new Button("Cancel");
		confirm.setFont(new Font("Arial", 20));
		cancel.setFont(new Font("Arial", 20));
		confirm.setDisable(true);
		HBox confirmbox = new HBox(40);
		confirmbox.getChildren().addAll(confirm, cancel);
		confirmbox.setAlignment(Pos.CENTER);
		addAPlayerPanel.add(confirmbox, 0, 3, 4, 1);
		Scene addAPlayerScene = new Scene(addAPlayerPanel);
		
		for(int index = 0; index < 40; index++) {
			route.add(getLandmark(index));
		}
		GridPane board = new GridPane();
		RowConstraints borderRows = new RowConstraints();
		RowConstraints inbetweenRows = new RowConstraints();
		ColumnConstraints borderColumns = new ColumnConstraints();
		ColumnConstraints inbetweenColumns = new ColumnConstraints();		
		borderRows.setPercentHeight(14.0);
		inbetweenRows.setPercentHeight(8.0);
		borderColumns.setPercentWidth(14.0);
		inbetweenColumns.setPercentWidth(8.0);
		for (int i = 0; i < 11; i++) {
			if (i == 0 || i == 10) {
				board.getRowConstraints().add(borderRows);
			}
			else {
				board.getRowConstraints().add(inbetweenRows);
			}
		}
		for (int j = 0; j < 11; j++) {
			if (j == 0 || j == 10) {
				board.getColumnConstraints().add(borderColumns);
			}
			else {
				board.getColumnConstraints().add(inbetweenColumns);
			}
		}
		ImageView logo = new ImageView(new Image("Logo/Logo.jpg"));
		logo.setPreserveRatio(true);
		logo.setFitWidth(400);
		board.add(logo, 1, 4, 9, 3);
		GridPane.setHalignment(logo, HPos.CENTER);
		GridPane.setValignment(logo, VPos.CENTER);
        for(int index = 0; index < 40; index++) {
        	StackPane tempPane = new StackPane();
        	tempPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        	tempPane.setBackground(new Background(new BackgroundFill(route.get(index).getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
			Label tempLabel = new Label(route.get(index).getDescription());
			tempLabel.setFont(new Font("Arial", 10));
			tempPane.getChildren().add(tempLabel);
			board.add(tempPane, indexToSubscript(index)[0], indexToSubscript(index)[1]);
		}
        ImageView dice1 = new ImageView(new Image("Dice/6.jpg"));
        ImageView dice2 = new ImageView(new Image("Dice/6.jpg"));
        Button diceRoller = new Button("Roll the dice");
        dice1.setPreserveRatio(false);
        dice1.setFitWidth(100);
        dice1.setFitHeight(100);
        board.add(dice1, 1, 7, 2, 2);
        GridPane.setHalignment(dice1, HPos.CENTER);
		GridPane.setValignment(dice1, VPos.CENTER);
		dice2.setPreserveRatio(false);
        dice2.setFitWidth(100);
        dice2.setFitHeight(100);
        board.add(dice2, 3, 7, 2, 2);
        GridPane.setHalignment(dice2, HPos.CENTER);
		GridPane.setValignment(dice2, VPos.CENTER);
		board.add(diceRoller, 1, 9, 4, 1);
		GridPane.setHalignment(diceRoller, HPos.CENTER);
		GridPane.setValignment(diceRoller, VPos.CENTER);
		Scene gameScene = new Scene(board);
		board.setGridLinesVisible(false);
		
		theStage.setHeight(700);
		theStage.setWidth(700);
		theStage.setTitle("MONOPOLY");
		theStage.setScene(welcomeScene);
		theStage.show();
		
		startTheGame.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	theStage.setScene(gameScene);
		    	for(Player aPlayer: players) {
		    		board.add(aPlayer.getToken(), 10, 10);
		    		setOrientation(aPlayer, aPlayer.getID());
		    	}
		    }
		});
		
		addAPlayer.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	theStage.setScene(addAPlayerScene);
		    }
		});
		
		group.selectedToggleProperty().addListener((observableToggles, previousToggle, currentToggle) -> {
		    if (currentToggle.isSelected()) {
		    	confirm.setDisable(false);
		    }
		});
		//confirms set on action and creates an event handler
		confirm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	if (players.isEmpty()) {
		    		players.add(new Player(usernameField.getText(), 0, ((ImageView) ((RadioButton) group.getSelectedToggle()).getGraphic())));
		    	}
		    	else {
		    		players.add(new Player(usernameField.getText(), players.get(players.size() - 1).getID() + 1, ((ImageView) ((RadioButton) group.getSelectedToggle()).getGraphic())));
		    	}
		    	((RadioButton) group.getSelectedToggle()).setDisable(true);
		    	usernameField.clear();
		    	confirm.setDisable(true);
		    	if (players.size() > 1) {
		    		startTheGame.setDisable(false);
		    	}
		    	if (players.size() == 8) {
		    		addAPlayer.setDisable(true);
		    	}
		    	theStage.setScene(welcomeScene);
		    }
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	theStage.setScene(welcomeScene);
		    }
		});
		
		diceRoller.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	rollDice(dice1, dice2, new Random().nextInt(6)+1, new Random().nextInt(6)+1, players.get(turn), turn);
		    }
		});
	}
	//sets orietation of a player
	public void setOrientation(Player aPlayer, int aID) {
		switch(aID) {
		case 0: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.LEFT);
			GridPane.setValignment(aPlayer.getToken(), VPos.TOP);
			break;
		case 1: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.LEFT);
			GridPane.setValignment(aPlayer.getToken(), VPos.CENTER);
			break;
		case 2: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.LEFT);
			GridPane.setValignment(aPlayer.getToken(), VPos.BOTTOM);
			break;
		case 3: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.CENTER);
			GridPane.setValignment(aPlayer.getToken(), VPos.TOP);
			break;
		case 4: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.CENTER);
			GridPane.setValignment(aPlayer.getToken(), VPos.BOTTOM);
			break;
		case 5: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.RIGHT);
			GridPane.setValignment(aPlayer.getToken(), VPos.TOP);
			break;
		case 6: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.RIGHT);
			GridPane.setValignment(aPlayer.getToken(), VPos.CENTER);
			break;
		case 7: 
			GridPane.setHalignment(aPlayer.getToken(), HPos.RIGHT);
			GridPane.setValignment(aPlayer.getToken(), VPos.BOTTOM);
			break;
		default: 
			break;
	}
	}
	
	//gets the index of a landmark (placement on board) 
	public Landmark getLandmark(int anIndex) {
		Landmark tempLandmark = new Landmark("", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
		switch(anIndex) {
		case 0:
			tempLandmark = new Landmark("GO\n COLLECT\n$200 SALARY\nAS YOU PASS", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 1:
			tempLandmark = new ColorGroup("MEDITER-\nRANEAN\nAVENUE\n$60", Color.BROWN, new ImageView(new Image("Properties/01.jpg")), 60, 50, new int[] {2, 10, 30, 90, 160, 250});
			break;
		case 2:
			tempLandmark = new Landmark("COMMUNITY\nCHEST", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 3:
			tempLandmark = new ColorGroup("BALTIC\nAVENUE\n$60", Color.BROWN, new ImageView(new Image("Properties/03.jpg")), 60, 50, new int[] {4, 20, 60, 180, 320, 450});
			break;
		case 4:
			tempLandmark = new TaxSpace("INCOME\nTAX\nPAY $200", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")), 200);
			break;
		case 5:
			tempLandmark = new Railroad("READING\nRAILROAD\n$200", Color.GRAY, new ImageView(new Image("Properties/05.jpg")));
			break;
		case 6:
			tempLandmark = new ColorGroup("ORIENTAL\nAVENUE\n$100", Color.LIGHTBLUE, new ImageView(new Image("Properties/06.jpg")), 100, 50, new int[] {6, 30, 90, 270, 400, 550});
			break;
		case 7:
			tempLandmark = new Landmark("CHANCE", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 8:
			tempLandmark = new ColorGroup("VERMONT\nAVENUE\n$100", Color.LIGHTBLUE, new ImageView(new Image("Properties/08.jpg")), 100, 50, new int[] {6, 30, 90, 270, 400, 550});
			break;
		case 9:
			tempLandmark = new ColorGroup("CONNECTICUT\nAVENUE\n$120", Color.LIGHTBLUE, new ImageView(new Image("Properties/09.jpg")), 120, 50, new int[] {8, 40, 100, 300, 450, 600});
			break;
		case 10:
			tempLandmark = new Landmark("IN\nJAIL", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 11:
			tempLandmark = new ColorGroup("ST. CHARLES\nPLACE\n$140", Color.PINK, new ImageView(new Image("Properties/11.jpg")), 140, 100, new int[] {10, 50, 150, 450, 625, 750});
			break;
		case 12:
			tempLandmark = new Landmark("ELECTRIC\nCOMPANY\n$150", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 13:
			tempLandmark = new ColorGroup("STATES\nAVENUE\n$140", Color.PINK, new ImageView(new Image("Properties/13.jpg")), 140, 100, new int[] {10, 50, 150, 450, 625, 750});
			break;
		case 14:
			tempLandmark = new ColorGroup("VIRGINIA\nAVENUE\n$160", Color.PINK, new ImageView(new Image("Properties/14.jpg")), 160, 100, new int[] {12, 60, 180, 500, 700, 900});
			break;
		case 15:
			tempLandmark = new Railroad("PENNSYLVANIA\nRAILROAD\n$200", Color.GRAY, new ImageView(new Image("Properties/15.jpg")));
			break;
		case 16:
			tempLandmark = new ColorGroup("ST. JAMES\nPLACE\n$180", Color.ORANGE, new ImageView(new Image("Properties/16.jpg")), 180, 100, new int[] {14, 70, 200, 550, 750, 950});
			break;
		case 17:
			tempLandmark = new Landmark("COMMUNITY\nCHEST", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 18:
			tempLandmark = new ColorGroup("TENNESSEE\nAVENUE\n$180", Color.ORANGE, new ImageView(new Image("Properties/18.jpg")), 180, 100, new int[] {14, 70, 200, 550, 750, 950});
			break;
		case 19:
			tempLandmark = new ColorGroup("NEW YORK\nAVENUE\n$200", Color.ORANGE, new ImageView(new Image("Properties/19.jpg")), 200, 100, new int[] {16, 80, 220, 600, 800, 1000});
			break;
		case 20:
			tempLandmark = new Landmark("FREE\nPARKING", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 21:
			tempLandmark = new ColorGroup("KENTUCKY\nAVENUE\n$220", Color.RED, new ImageView(new Image("Properties/21.jpg")), 220, 150, new int[] {18, 90, 250, 700, 875, 1050});
			break;
		case 22:
			tempLandmark = new Landmark("CHANCE", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 23:
			tempLandmark = new ColorGroup("INDIANA\nAVENUE\n$220", Color.RED, new ImageView(new Image("Properties/23.jpg")), 220, 150, new int[] {18, 90, 250, 700, 875, 1050});
			break;
		case 24:
			tempLandmark = new ColorGroup("ILLINOIS\nAVENUE\n$240", Color.RED, new ImageView(new Image("Properties/24.jpg")), 240, 150, new int[] {20, 100, 300, 750, 925, 1100});
			break;
		case 25:
			tempLandmark = new Railroad("B. & O.\nRAILROAD\n$200", Color.GRAY, new ImageView(new Image("Properties/25.jpg")));
			break;
		case 26:
			tempLandmark = new ColorGroup("ATLANTIC\nAVENUE\n$260", Color.YELLOW, new ImageView(new Image("Properties/26.jpg")), 260, 150, new int[] {22, 110, 330, 800, 975, 1150});
			break;
		case 27:
			tempLandmark = new ColorGroup("VENINOR\nAVENUE\n$260", Color.YELLOW, new ImageView(new Image("Properties/27.jpg")), 260, 150, new int[] {22, 110, 330, 800, 975, 1150});
			break;
		case 28:
			tempLandmark = new Landmark("WATER\nWORKS\n$150", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 29:
			tempLandmark = new ColorGroup("MARVIN\nGARDENS\n$280", Color.YELLOW, new ImageView(new Image("Properties/29.jpg")), 280, 150, new int[] {24, 120, 360, 850, 1025, 1200});
			break;
		case 30:
			tempLandmark = new Landmark("GO TO\nJAIL", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 31:
			tempLandmark = new ColorGroup("PACIFIC\nAVENUE\n$300", Color.GREEN, new ImageView(new Image("Properties/31.jpg")), 300, 200, new int[] {26, 130, 390, 900, 1100, 1275});
			break;
		case 32:
			tempLandmark = new ColorGroup("NORTH\nCAROLINA\nAVENUE\n$300", Color.GREEN, new ImageView(new Image("Properties/32.jpg")), 300, 200, new int[] {26, 130, 390, 900, 1100, 1275});
			break;
		case 33:
			tempLandmark = new Landmark("COMMUNITY\nCHEST", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 34:
			tempLandmark = new ColorGroup("PENNSYLVANIA\nAVENUE\n$320", Color.GREEN, new ImageView(new Image("Properties/34.jpg")), 320, 200, new int[] {28, 150, 450, 1000, 1200, 1400});
			break;
		case 35:
			tempLandmark = new Railroad("SHORT\nLINE\n$200", Color.GRAY, new ImageView(new Image("Properties/35.jpg")));
			break;
		case 36:
			tempLandmark = new Landmark("CHANCE", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 37:
			tempLandmark = new ColorGroup("PARK\nPLACE\n$350", Color.DARKBLUE, new ImageView(new Image("Properties/37.jpg")), 350, 200, new int[] {35, 175, 500, 1100, 1300, 1500});
			break;
		case 38:
			tempLandmark = new Landmark("LUXURY\nTAX\nPAY $100", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
			break;
		case 39:
			tempLandmark = new ColorGroup("BOARDWALK\n$400", Color.DARKBLUE, new ImageView(new Image("Properties/39.jpg")), 400, 200, new int[] {50, 200, 600, 1400, 170, 2000});
			break;
		default:
			break;
		}
		return tempLandmark;
	}
	//index to subscript
	public int[] indexToSubscript(int anIndex) {
		if(anIndex >= 0 && anIndex <= 9) {
			return new int[] {10 - anIndex, 10};
		}
		else if(anIndex >= 10 && anIndex <= 19) {
			return new int[] {0, 20 - anIndex};
		}
		else if(anIndex >= 20 && anIndex <= 29) {
			return new int[] {anIndex - 20, 0};
		}
		else {
			return new int[] {10, anIndex - 30};
		}
	}

	//rolls dice and provides an image view of the roll
	public void rollDice(ImageView firstDice, ImageView secondDice, int firstNumber, int secondNumber, Player aPlayer, int turn) {
		firstDice.setImage(new Image("Dice/" + firstNumber + ".jpg"));
		secondDice.setImage(new Image("Dice/" + secondNumber + ".jpg"));
		aPlayer.moveForward(firstNumber + secondNumber);
		turn++;
	}
	//main function
	public static void main(String[] args) {
		Application.launch(args);
	}
}

//        
//        rollDice.setOnAction(new EventHandler<ActionEvent>() {
//        	@Override
//        	public void handle(ActionEvent e)
//        	{
//        		Random rand = new Random();
//        		int d1 = rand.nextInt(6)+1;
//        		int d2 = rand.nextInt(6)+1;
//        		dice1.setText(Integer.toString(d1));
//        		dice2.setText(Integer.toString(d2));
////        		index += d1+d2;
////        		index = index % 40;
////        		if (index >= 0 && index <= 9) {
////            		board.add(circle, 10 - index, 10);
////            	}
////            	else if (index >= 10 && index <= 19) {
////            		board.add(circle, 0, 20 - index);
////            	}
////            	else if (index >= 20 && index <= 29) {
////            		board.add(circle, index - 20, 0);
////            	}
////            	else {
////            		board.add(circle, 10, index - 30);
////            	}        		
//        	}
//        });


