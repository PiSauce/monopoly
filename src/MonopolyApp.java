import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.ListIterator;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
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

public class MonopolyApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Landmark> route = new ArrayList<Landmark>();
		
		Label welcomeLabel = new Label("WELCOME TO MONOPOLY!");
		Button startTheGame = new Button("Start The Game");
		Button addAPlayer = new Button("Add A Player");
		welcomeLabel.setFont(new Font("Arial", 50));
		startTheGame.setFont(new Font("Arial", 30));
		addAPlayer.setFont(new Font("Arial", 30));
		startTheGame.setDisable(true);
		VBox welcomeVBox = new VBox(30);
		welcomeVBox.getChildren().addAll(welcomeLabel, startTheGame, addAPlayer);
		welcomeVBox.setAlignment(Pos.CENTER);
		Scene welcomeScene = new Scene(welcomeVBox);
		
		GridPane addAPlayerPanel = new GridPane();
		RowConstraints tokenRowConstraints = new RowConstraints();
		RowConstraints usernameRowConstraints = new RowConstraints();
		ColumnConstraints tokenColumnConstraints = new ColumnConstraints();
		tokenRowConstraints.setPercentHeight(35);
		usernameRowConstraints.setPercentHeight(15);
		tokenColumnConstraints.setPercentWidth(25);
		addAPlayerPanel.getRowConstraints().add(tokenRowConstraints);
		addAPlayerPanel.getRowConstraints().add(tokenRowConstraints);
		addAPlayerPanel.getRowConstraints().add(usernameRowConstraints);
		addAPlayerPanel.getRowConstraints().add(usernameRowConstraints);
		for(int j = 0; j < 4; j++) {
			addAPlayerPanel.getColumnConstraints().add(tokenColumnConstraints);
		}
		ToggleGroup group = new ToggleGroup();
		String[] tokens = {"Batman", "Captain America", "Flash", "Green Lantern", "Hulk", "Iron Man", "Robocop", "Spider-man"};
		for(int j = 0; j < 8; j++) {
			Image tempImage = new Image("Tokens/" + tokens[j] + ".jpg");
			RadioButton tempButton = new RadioButton(tokens[j]);
			ImageView tempImageView = new ImageView(tempImage);
			tempImageView.setFitWidth(150);
			tempImageView.setFitHeight(150);
			tempButton.setGraphic(tempImageView);
			tempButton.setContentDisplay(ContentDisplay.TOP);
			tempButton.setToggleGroup(group);
			addAPlayerPanel.add(tempButton, j%4, j/4);
		}
		Label usernameLabel = new Label("Please select a token and enter your username:");
		usernameLabel.setFont(new Font("Arial", 20));
		TextField usernameField = new TextField();
		HBox usernameBox = new HBox(10);
		usernameBox.getChildren().addAll(usernameLabel, usernameField);
		usernameBox.setAlignment(Pos.CENTER);
		addAPlayerPanel.add(usernameBox, 0, 2, 4, 1);
		Button confirmAddingAPlayer = new Button("Confirm");
		Button cancelAddingAPlayer = new Button("Cancel");
		confirmAddingAPlayer.setFont(new Font("Arial", 20));
		cancelAddingAPlayer.setFont(new Font("Arial", 20));
		confirmAddingAPlayer.setDisable(true);
		HBox confirmAddingAPlayerBox = new HBox(40);
		confirmAddingAPlayerBox.getChildren().addAll(confirmAddingAPlayer, cancelAddingAPlayer);
		confirmAddingAPlayerBox.setAlignment(Pos.CENTER);
		addAPlayerPanel.add(confirmAddingAPlayerBox, 0, 3, 4, 1);
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
			tempLabel.setWrapText(true);
			tempPane.getChildren().add(tempLabel);
			board.add(tempPane, indexToSubscript(index)[0], indexToSubscript(index)[1]);
		}
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Button rollTheDice = new Button("Roll the dice");
        board.add(dice1.getFaceIcon(), 1, 7, 2, 2);
        GridPane.setHalignment(dice1.getFaceIcon(), HPos.CENTER);
		GridPane.setValignment(dice1.getFaceIcon(), VPos.CENTER);
        board.add(dice2.getFaceIcon(), 3, 7, 2, 2);
        GridPane.setHalignment(dice2.getFaceIcon(), HPos.CENTER);
		GridPane.setValignment(dice2.getFaceIcon(), VPos.CENTER);
		board.add(rollTheDice, 1, 9, 4, 1);
		GridPane.setHalignment(rollTheDice, HPos.CENTER);
		GridPane.setValignment(rollTheDice, VPos.CENTER);
		rollTheDice.setDisable(true);
		StackPane playerStatusPane = new StackPane();
		playerStatusPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		playerStatusPane.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
		Label playerStatusLabel = new Label();
		playerStatusLabel.setFont(new Font("Arial", 20));
		playerStatusPane.getChildren().add(playerStatusLabel);
		StackPane.setAlignment(playerStatusLabel, Pos.TOP_LEFT);
		board.add(playerStatusPane, 6, 1, 4, 3);
		board.setGridLinesVisible(false);
		Scene gameScene = new Scene(board);
		
		primaryStage.setHeight(700);
		primaryStage.setWidth(700);
		primaryStage.setTitle("MONOPOLY");
		primaryStage.setScene(welcomeScene);
		primaryStage.setOnHidden(e -> Platform.exit());
		primaryStage.show();
		
		Label startTheTurnMessage = new Label();
		startTheTurnMessage.setFont(new Font("Arial", 20));
		startTheTurnMessage.setWrapText(true);
		ImageView startTheTurnLandmark = new ImageView(new Image("Logo/Logo.jpg"));
		startTheTurnLandmark.setPreserveRatio(false);
		startTheTurnLandmark.setFitWidth(300);
		startTheTurnLandmark.setFitHeight(300);
		Button startTheTurnButton = new Button("Start The Turn");
		startTheTurnButton.setFont(new Font("Arial", 20));
		VBox startTheTurnVBox = new VBox(30);
		startTheTurnVBox.getChildren().addAll(startTheTurnMessage, startTheTurnLandmark, startTheTurnButton);
		startTheTurnVBox.setAlignment(Pos.CENTER);
		Scene startTheTurnScene = new Scene(startTheTurnVBox);
		
		Label inJailMessage = new Label();
		inJailMessage.setFont(new Font("Arial", 20));
		inJailMessage.setWrapText(true);
		ImageView inJailLandmark = new ImageView(new Image("Landmarks/10.jpg"));
		inJailLandmark.setPreserveRatio(false);
		inJailLandmark.setFitWidth(300);
		inJailLandmark.setFitHeight(300);
		Button rollOutOfJail = new Button("Roll The Dice");
		Button payTheFine = new Button("Pay The Fine of $50");
		Button useGetOutOfJailFreeCard = new Button("Use Get Out Of Jail Free Card");
		Button turnToNextPlayer = new Button("Turn To Next Player");
		rollOutOfJail.setFont(new Font("Arial", 20));
		payTheFine.setFont(new Font("Arial", 20));
		useGetOutOfJailFreeCard.setFont(new Font("Arial", 20));
		turnToNextPlayer.setFont(new Font("Arial", 20));
		useGetOutOfJailFreeCard.setDisable(true);
		VBox inJailVBox = new VBox(10);
		inJailVBox.getChildren().addAll(inJailMessage, inJailLandmark, rollOutOfJail, payTheFine, useGetOutOfJailFreeCard, turnToNextPlayer);
		inJailVBox.setAlignment(Pos.CENTER);
		Scene inJailScene = new Scene(inJailVBox);
		
		Label requiredActionMessage = new Label();
		requiredActionMessage.setFont(new Font("Arial", 20));
		requiredActionMessage.setWrapText(true);
		ImageView requiredActionLandmark = new ImageView(new Image("Logo/Logo.jpg"));
		requiredActionLandmark.setPreserveRatio(false);
		requiredActionLandmark.setFitWidth(300);
		requiredActionLandmark.setFitHeight(300);
		Button purchase = new Button("Purchase");
		Button auction = new Button("Auction");
		Button next = new Button("Next");
		purchase.setFont(new Font("Arial", 20));
		auction.setFont(new Font("Arial", 20));
		next.setFont(new Font("Arial", 20));
		HBox requiredActionHBox = new HBox(40);
		requiredActionHBox.getChildren().addAll(purchase, auction, next);
		requiredActionHBox.setAlignment(Pos.CENTER);
		VBox requiredActionVBox = new VBox(30);
		requiredActionVBox.getChildren().addAll(requiredActionMessage, requiredActionLandmark, requiredActionHBox);
		requiredActionVBox.setAlignment(Pos.CENTER);
		Scene requiredActionScene = new Scene(requiredActionVBox);
		
		Label optionalActionMessage = new Label();
		optionalActionMessage.setFont(new Font("Arial", 20));
		optionalActionMessage.setWrapText(true);
		ImageView optionalActionLandmark = new ImageView(new Image("Logo/Logo.jpg"));
		optionalActionLandmark.setPreserveRatio(false);
		optionalActionLandmark.setFitWidth(300);
		optionalActionLandmark.setFitHeight(300);
		ComboBox<String> optionalActionComboBox = new ComboBox<>();
		ComboBox<String> optionComboBox = new ComboBox<>();
		optionalActionComboBox.setPromptText("Please select an option");
		optionalActionComboBox.getItems().addAll("Buy a property from another player", 
				"Sell a property to another player", 
				"Buy a house or hotel", 
				"Sell a house or hotel", 
				"Mortgage a property", 
				"Unmortgage a property");
		Button confirmTheAction = new Button("Confirm The Action");
		Button finishTheTurn = new Button("Finish The Turn");
		confirmTheAction.setFont(new Font("Arial", 20));
		finishTheTurn.setFont(new Font("Arial", 20));
		HBox optionalActionHBox = new HBox(40);
		optionalActionHBox.getChildren().addAll(confirmTheAction, finishTheTurn);
		optionalActionHBox.setAlignment(Pos.CENTER);
		VBox optionalActionVBox = new VBox(30);
		optionalActionVBox.getChildren().addAll(optionalActionMessage, optionalActionLandmark, optionalActionComboBox, optionComboBox, optionalActionHBox);
		optionalActionVBox.setAlignment(Pos.CENTER);
		Scene optionalActionScene = new Scene(optionalActionVBox);
		
		Stage secondaryStage = new Stage();
		secondaryStage.setHeight(600);
		secondaryStage.setWidth(600);
		secondaryStage.setTitle("ACTIONS");
		secondaryStage.setScene(startTheTurnScene);
		secondaryStage.close();
		
		startTheGame.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	primaryStage.setScene(gameScene);
		    	for(Player aPlayer: players) {
		    		board.add(aPlayer.getToken(), 10, 10);
		    		setOrientation(aPlayer, aPlayer.getID());
		    		playerStatusLabel.setText(playerStatusLabel.getText() + aPlayer.getUsername() + ": " + aPlayer.getMoney() + "\n");
		    	}
		    	startTheTurnMessage.setText("Hello " + players.get(0).getUsername() + ", please roll the dice.");
		    	secondaryStage.setScene(startTheTurnScene);
				secondaryStage.show();
		    }
		});
		
		addAPlayer.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	primaryStage.setScene(addAPlayerScene);
		    }
		});
		
		group.selectedToggleProperty().addListener((observableToggles, previousToggle, currentToggle) -> {
		    if (currentToggle.isSelected()) {
		    	confirmAddingAPlayer.setDisable(false);
		    }
		});
		
		confirmAddingAPlayer.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	players.add(new Player(usernameField.getText(), players.size(), ((ImageView) ((RadioButton) group.getSelectedToggle()).getGraphic())));
		    	((RadioButton) group.getSelectedToggle()).setDisable(true);
		    	usernameField.clear();
		    	confirmAddingAPlayer.setDisable(true);
		    	if (players.size() > 1) {
		    		startTheGame.setDisable(false);
		    	}
		    	if (players.size() == 8) {
		    		addAPlayer.setDisable(true);
		    	}
		    	primaryStage.setScene(welcomeScene);
		    }
		});
		
		cancelAddingAPlayer.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	primaryStage.setScene(welcomeScene);
		    }
		});
		
		startTheTurnButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	rollTheDice.setDisable(false);
		    }
		});
		
		rollTheDice.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {		    	
		    	Player currentPlayer = players.get(players.get(0).getCurrentPlayerIndex());
		    	dice1.setNumber();
		    	dice2.setNumber();
		    	if(dice1.getNumber() == dice2.getNumber()) {
		    		dice1.addDoubleNumber();
		    	}
		    	dice1.setFaceIcon();
		    	dice2.setFaceIcon();
		    	board.add(dice1.getFaceIcon(), 1, 7, 2, 2);
		        GridPane.setHalignment(dice1.getFaceIcon(), HPos.CENTER);
				GridPane.setValignment(dice1.getFaceIcon(), VPos.CENTER);
		        board.add(dice2.getFaceIcon(), 3, 7, 2, 2);
		        GridPane.setHalignment(dice2.getFaceIcon(), HPos.CENTER);
				GridPane.setValignment(dice2.getFaceIcon(), VPos.CENTER);
		    	rollTheDice.setDisable(true);
		    	if((currentPlayer.getInJailNumber() == 0 || currentPlayer.getInJailNumber() == 1) && dice1.getNumber() != dice2.getNumber()) {
		    		currentPlayer.addInJailNumber();
		    		inJailMessage.setText("Hello " + currentPlayer.getUsername() + ", you have to wait for next turn to get out of jail.");
	    			rollOutOfJail.setDisable(true);
	    			payTheFine.setDisable(true);
	    			useGetOutOfJailFreeCard.setDisable(true);
	    			turnToNextPlayer.setDisable(false);
	    			secondaryStage.setScene(inJailScene);
		    	}
		    	else if(currentPlayer.getInJailNumber() == -1 && dice1.getDoubleNumber() == 3) {
		    		currentPlayer.setPosition(10);
	    			currentPlayer.addInJailNumber();
	    			board.getChildren().remove(currentPlayer.getToken());
					board.add(currentPlayer.getToken(), indexToSubscript(currentPlayer.getPosition())[0], indexToSubscript(currentPlayer.getPosition())[1]);
					setOrientation(currentPlayer, currentPlayer.getID());
	    			requiredActionMessage.setText("Hello " + currentPlayer.getUsername() + ", you have rolled three doubles and been sent to jail.");
	    			requiredActionLandmark.setImage(new Image("Landmarks/" + currentPlayer.getPosition() + ".jpg"));
		    		requiredActionLandmark.setPreserveRatio(false);
		    		requiredActionLandmark.setFitWidth(300);
		    		requiredActionLandmark.setFitHeight(300);
		    		purchase.setDisable(true);
					auction.setDisable(true);
					next.setDisable(false);
		    	}
		    	else {
		    		currentPlayer.moveForward(dice1.getNumber() + dice2.getNumber());
		    		board.getChildren().remove(currentPlayer.getToken());
					board.add(currentPlayer.getToken(), indexToSubscript(currentPlayer.getPosition())[0], indexToSubscript(currentPlayer.getPosition())[1]);
					setOrientation(currentPlayer, currentPlayer.getID());
					requiredActionLandmark.setImage(new Image("Landmarks/" + currentPlayer.getPosition() + ".jpg"));
		    		requiredActionLandmark.setPreserveRatio(false);
		    		requiredActionLandmark.setFitWidth(300);
		    		requiredActionLandmark.setFitHeight(300);
		    		purchase.setDisable(true);
					auction.setDisable(true);
					next.setDisable(false);
					if(currentPlayer.getInJailNumber() == 0 || currentPlayer.getInJailNumber() == 1) {
						currentPlayer.setInJailNumber();
						currentPlayer.setJustOutOfJail(true);
						requiredActionMessage.setText("Hello " + currentPlayer.getUsername() + ", you have rolled a double and been out of jail now, and ");
		    		}
		    		else if(currentPlayer.getInJailNumber() == 2) {
		    			currentPlayer.reduceMoney(50);
		    			currentPlayer.setInJailNumber();
		    			currentPlayer.setJustOutOfJail(true);
		    			requiredActionMessage.setText("Hello " + currentPlayer.getUsername() + ", you have paid a fine of $50 and been out of jail now, and ");
		    		}
		    		else {
		    			requiredActionMessage.setText("Hello " + currentPlayer.getUsername() + ", ");
		    		}
		    		switch(currentPlayer.getPosition()) {
		    		case 0:
		    		case 2:
		    		case 7:
		    		case 10:
		    		case 17:
		    		case 20:
		    		case 22:
		    		case 33:
		    		case 36:
		    			requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + route.get(currentPlayer.getPosition()).getDescription());
		    			break;
		    		case 30:
		    			requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + route.get(currentPlayer.getPosition()).getDescription() + ", and been sent to jail.");
		    			currentPlayer.setPosition(10);
		    			currentPlayer.addInJailNumber();
		    			board.getChildren().remove(currentPlayer.getToken());
						board.add(currentPlayer.getToken(), indexToSubscript(currentPlayer.getPosition())[0], indexToSubscript(currentPlayer.getPosition())[1]);
						setOrientation(currentPlayer, currentPlayer.getID());
		    			break;
		    		case 4:
		    		case 38:
		    			currentPlayer.reduceMoney(((TaxSpace) route.get(currentPlayer.getPosition())).getPenalties());
		    			requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + route.get(currentPlayer.getPosition()).getDescription() + ", and paid the labeled tax.");
		    			break;
		    		default:
		    			if(route.get(currentPlayer.getPosition()).getOwnerID() == -1) {
		    				requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on an unowned property, " + route.get(currentPlayer.getPosition()).getDescription());
			    			purchase.setDisable(false);
							auction.setDisable(true);
							next.setDisable(false);
		    			}
		    			else if(route.get(currentPlayer.getPosition()).getOwnerID() != currentPlayer.getID()) {
		    				for(Player aPlayer: players) {
		    					if(route.get(currentPlayer.getPosition()).getOwnerID() == aPlayer.getID()) {
		    						if(route.get(currentPlayer.getPosition()).getMortgaged()) {
		    							requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on a mortgaged property " + route.get(currentPlayer.getPosition()).getDescription() + " owned by " + aPlayer.getUsername() + ", and do not need to pay the rent.");
		    						}
		    						else if(route.get(currentPlayer.getPosition()) instanceof Railroad) {
		    							Railroad tempRailroad = (Railroad) route.get(currentPlayer.getPosition());
		    							ArrayList<Integer> tempRailroadIDs = aPlayer.getPropertyIDs();
		    							tempRailroadIDs.retainAll(getArrayList(tempRailroad.getGroupLocations(currentPlayer.getPosition())));
		    							currentPlayer.reduceMoney(tempRailroad.getRents() [tempRailroadIDs.size() - 1]);
		    							aPlayer.addMoney(tempRailroad.getRents() [tempRailroadIDs.size() - 1]);
		    							requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + tempRailroad.getDescription() + " owned by " + aPlayer.getUsername() + " who have " + tempRailroadIDs.size() + " railroads, and paid $" + tempRailroad.getRents()[tempRailroadIDs.size() - 1] + ".");
		    						}	
		    						else if(route.get(currentPlayer.getPosition()) instanceof ColorGroup) {
		    							ColorGroup tempColorGroup = (ColorGroup) route.get(currentPlayer.getPosition());
		    							int tempRent = tempColorGroup.getRents() [tempColorGroup.getBuildingNumber()];
		    							if(tempColorGroup.getBuildingNumber() == 0 && tempColorGroup.getGroupOwnerID(currentPlayer.getPosition()) == currentPlayer.getID()) {
		    								tempRent *= 2;
		    							}
		    							currentPlayer.reduceMoney(tempRent);
		    							aPlayer.addMoney(tempRent);
		    							requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + tempColorGroup.getDescription() + " with " + (tempColorGroup.getBuildingNumber() == 5? "a hotel" : tempColorGroup.getBuildingNumber() + " house(s)") + " owned by " + aPlayer.getUsername() + ", and paid $" + tempRent + ".");
		    						}
		    						else {
		    							Utility tempUtility = (Utility) route.get(currentPlayer.getPosition());
		    							ArrayList<Integer> tempUtilityIDs = aPlayer.getPropertyIDs();
		    							tempUtilityIDs.retainAll(getArrayList(tempUtility.getGroupLocations(currentPlayer.getPosition())));
		    							int tempRent = (tempUtilityIDs.size() == 1? 4 * (dice1.getNumber() + dice2.getNumber()) : 10 * (dice1.getNumber() + dice2.getNumber()));
		    							currentPlayer.reduceMoney(tempRent);
		    							aPlayer.addMoney(tempRent);
		    							requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + tempUtility.getDescription() + " owned by " + aPlayer.getUsername() + " who have " + tempUtilityIDs.size() + " utilities, and paid $" + tempRent + ".");
		    						}
		    						break;
		    					}
		    				}
		    				requiredActionLandmark.setImage(new Image("Properties/" + currentPlayer.getPosition() + ".jpg"));
				    		requiredActionLandmark.setPreserveRatio(false);
				    		requiredActionLandmark.setFitWidth(300);
				    		requiredActionLandmark.setFitHeight(300);
		    			}
		    			else {
		    				requiredActionMessage.setText(requiredActionMessage.getText() + "you have landed on " + route.get(currentPlayer.getPosition()).getDescription() + " owned by yourself.");
		    			}
		    			break;
		    		}
		    		playerStatusLabel.setText("");
		    		for(Player aPlayer: players) {
			    		playerStatusLabel.setText(playerStatusLabel.getText() + aPlayer.getUsername() + ": " + aPlayer.getMoney() + "\n");
			    	}
		    		secondaryStage.setScene(requiredActionScene);
		    	}	
		    }
		});
		
		rollOutOfJail.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	rollTheDice.setDisable(false);
		    }
		});
		
		payTheFine.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	Player currentPlayer = players.get(players.get(0).getCurrentPlayerIndex());
		    	currentPlayer.reduceMoney(50);
		    	currentPlayer.setInJailNumber();
		    	currentPlayer.setJustOutOfJail(true);
		    	playerStatusLabel.setText("");
	    		for(Player aPlayer: players) {
		    		playerStatusLabel.setText(playerStatusLabel.getText() + aPlayer.getUsername() + ": " + aPlayer.getMoney() + "\n");
		    	}
		    	startTheTurnMessage.setText("Hello " + currentPlayer.getUsername() + ", please roll the dice.");
		    	secondaryStage.setScene(startTheTurnScene);
		    }
		});
		
		turnToNextPlayer.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	players.get(0).setNextPlayerIndex(players.size());
		    	dice1.setDoubleNumber();
		    	startTheTurnMessage.setText("Hello " + players.get(players.get(0).getCurrentPlayerIndex()).getUsername() + ", please roll the dice.");
		    	secondaryStage.setScene(startTheTurnScene);
		    }
		});
		
		purchase.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	Player currentPlayer = players.get(players.get(0).getCurrentPlayerIndex());
		    	Landmark tempLandmark = route.get(currentPlayer.getPosition());
		    	currentPlayer.reduceMoney(tempLandmark.getPrice());
		    	currentPlayer.addPropertyID(currentPlayer.getPosition());
		    	tempLandmark.setOwnerID(currentPlayer.getID());
		    	if(getArrayList(tempLandmark.getGroupLocations(currentPlayer.getPosition())).stream().filter(tempindex -> route.get(tempindex).getOwnerID() != currentPlayer.getID()).collect(Collectors.toList()).size() == 0) {
		    		tempLandmark.setGroupOwnerID(currentPlayer.getPosition(), currentPlayer.getID());
		    	};
		    	playerStatusLabel.setText("");
	    		for(Player aPlayer: players) {
		    		playerStatusLabel.setText(playerStatusLabel.getText() + aPlayer.getUsername() + ": " + aPlayer.getMoney() + "\n");
		    	}
		    	requiredActionMessage.setText("Hello " + currentPlayer.getUsername() + ", you have purchased " + tempLandmark.getDescription() + ".");
		    	purchase.setDisable(true);
		    }
		});
		
		next.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	optionalActionMessage.setText("Hello " + players.get(players.get(0).getCurrentPlayerIndex()).getUsername() + ", please select an option and/or finish the turn.");
		    	confirmTheAction.setDisable(true);
		    	finishTheTurn.setDisable(false);
		    	secondaryStage.setScene(optionalActionScene);
		    }
		});
		
		finishTheTurn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	if(players.get(players.get(0).getCurrentPlayerIndex()).getInJailNumber() == -1 && players.get(players.get(0).getCurrentPlayerIndex()).getJustOutOfJail() == false && dice1.getNumber() == dice2.getNumber()) {
		    		startTheTurnMessage.setText("Hello " + players.get(players.get(0).getCurrentPlayerIndex()).getUsername() + ", please roll the dice.");
			    	secondaryStage.setScene(startTheTurnScene);
		    	}
		    	else {
		    		players.get(0).setNextPlayerIndex(players.size());
			    	dice1.setDoubleNumber();
			    	if(players.get(players.get(0).getCurrentPlayerIndex()).getInJailNumber() > -1) {
			    		inJailMessage.setText("Hello " + players.get(players.get(0).getCurrentPlayerIndex()).getUsername() + ", you are in jail and please select an option to get out of jail.");
		    			rollOutOfJail.setDisable(false);
		    			payTheFine.setDisable(false);
		    			useGetOutOfJailFreeCard.setDisable(true);
		    			turnToNextPlayer.setDisable(true);
		    			secondaryStage.setScene(inJailScene);
			    	}
			    	else {
			    		startTheTurnMessage.setText("Hello " + players.get(players.get(0).getCurrentPlayerIndex()).getUsername() + ", please roll the dice.");
				    	secondaryStage.setScene(startTheTurnScene);
			    	}
		    	}
		    }
		});
	}
	
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

	public Landmark getLandmark(int anIndex) {
		Landmark tempLandmark = new Landmark("", Color.GRAY, new ImageView(new Image("Logo/Logo.jpg")));
		switch(anIndex) {
		case 0:
			tempLandmark = new Landmark("GO", Color.GRAY, new ImageView(new Image("Landmarks/0.jpg")));
			break;
		case 1:
			tempLandmark = new ColorGroup("MEDITERRANEAN AVENUE", Color.BROWN, new ImageView(new Image("Landmarks/1.jpg")), 60, 50, new int[] {2, 10, 30, 90, 160, 250});
			break;
		case 2:
			tempLandmark = new Landmark("COMMUNITY CHEST", Color.GRAY, new ImageView(new Image("Landmarks/2.jpg")));
			break;
		case 3:
			tempLandmark = new ColorGroup("BALTIC AVENUE", Color.BROWN, new ImageView(new Image("Landmarks/3.jpg")), 60, 50, new int[] {4, 20, 60, 180, 320, 450});
			break;
		case 4:
			tempLandmark = new TaxSpace("INCOME TAX", Color.GRAY, new ImageView(new Image("Landmarks/4.jpg")), 200);
			break;
		case 5:
			tempLandmark = new Railroad("READING RAILROAD", Color.GRAY, new ImageView(new Image("Landmarks/5.jpg")));
			break;
		case 6:
			tempLandmark = new ColorGroup("ORIENTAL AVENUE", Color.LIGHTBLUE, new ImageView(new Image("Landmarks/6.jpg")), 100, 50, new int[] {6, 30, 90, 270, 400, 550});
			break;
		case 7:
			tempLandmark = new Landmark("CHANCE", Color.GRAY, new ImageView(new Image("Landmarks/7.jpg")));
			break;
		case 8:
			tempLandmark = new ColorGroup("VERMONT AVENUE", Color.LIGHTBLUE, new ImageView(new Image("Landmarks/8.jpg")), 100, 50, new int[] {6, 30, 90, 270, 400, 550});
			break;
		case 9:
			tempLandmark = new ColorGroup("CONNECTICUT AVENUE", Color.LIGHTBLUE, new ImageView(new Image("Landmarks/9.jpg")), 120, 50, new int[] {8, 40, 100, 300, 450, 600});
			break;
		case 10:
			tempLandmark = new Landmark("JUST VISITING JAIL", Color.GRAY, new ImageView(new Image("Landmarks/10.jpg")));
			break;
		case 11:
			tempLandmark = new ColorGroup("ST. CHARLES PLACE", Color.PINK, new ImageView(new Image("Landmarks/11.jpg")), 140, 100, new int[] {10, 50, 150, 450, 625, 750});
			break;
		case 12:
			tempLandmark = new Utility("ELECTRIC COMPANY", Color.GRAY, new ImageView(new Image("Landmarks/12.jpg")));
			break;
		case 13:
			tempLandmark = new ColorGroup("STATES AVENUE", Color.PINK, new ImageView(new Image("Landmarks/13.jpg")), 140, 100, new int[] {10, 50, 150, 450, 625, 750});
			break;
		case 14:
			tempLandmark = new ColorGroup("VIRGINIA AVENUE", Color.PINK, new ImageView(new Image("Landmarks/14.jpg")), 160, 100, new int[] {12, 60, 180, 500, 700, 900});
			break;
		case 15:
			tempLandmark = new Railroad("PENNSYLVANIA RAILROAD", Color.GRAY, new ImageView(new Image("Landmarks/15.jpg")));
			break;
		case 16:
			tempLandmark = new ColorGroup("ST. JAMES PLACE", Color.ORANGE, new ImageView(new Image("Landmarks/16.jpg")), 180, 100, new int[] {14, 70, 200, 550, 750, 950});
			break;
		case 17:
			tempLandmark = new Landmark("COMMUNITY CHEST", Color.GRAY, new ImageView(new Image("Landmarks/17.jpg")));
			break;
		case 18:
			tempLandmark = new ColorGroup("TENNESSEE AVENUE", Color.ORANGE, new ImageView(new Image("Landmarks/18.jpg")), 180, 100, new int[] {14, 70, 200, 550, 750, 950});
			break;
		case 19:
			tempLandmark = new ColorGroup("NEW YORK AVENUE", Color.ORANGE, new ImageView(new Image("Landmarks/19.jpg")), 200, 100, new int[] {16, 80, 220, 600, 800, 1000});
			break;
		case 20:
			tempLandmark = new Landmark("FREE PARKING", Color.GRAY, new ImageView(new Image("Landmarks/20.jpg")));
			break;
		case 21:
			tempLandmark = new ColorGroup("KENTUCKY AVENUE", Color.RED, new ImageView(new Image("Landmarks/21.jpg")), 220, 150, new int[] {18, 90, 250, 700, 875, 1050});
			break;
		case 22:
			tempLandmark = new Landmark("CHANCE", Color.GRAY, new ImageView(new Image("Landmarks/22.jpg")));
			break;
		case 23:
			tempLandmark = new ColorGroup("INDIANA AVENUE", Color.RED, new ImageView(new Image("Landmarks/23.jpg")), 220, 150, new int[] {18, 90, 250, 700, 875, 1050});
			break;
		case 24:
			tempLandmark = new ColorGroup("ILLINOIS AVENUE", Color.RED, new ImageView(new Image("Landmarks/24.jpg")), 240, 150, new int[] {20, 100, 300, 750, 925, 1100});
			break;
		case 25:
			tempLandmark = new Railroad("B. & O. RAILROAD", Color.GRAY, new ImageView(new Image("Landmarks/25.jpg")));
			break;
		case 26:
			tempLandmark = new ColorGroup("ATLANTIC AVENUE", Color.YELLOW, new ImageView(new Image("Landmarks/26.jpg")), 260, 150, new int[] {22, 110, 330, 800, 975, 1150});
			break;
		case 27:
			tempLandmark = new ColorGroup("VENINOR AVENUE", Color.YELLOW, new ImageView(new Image("Landmarks/27.jpg")), 260, 150, new int[] {22, 110, 330, 800, 975, 1150});
			break;
		case 28:
			tempLandmark = new Utility("WATER WORKS", Color.GRAY, new ImageView(new Image("Landmarks/28.jpg")));
			break;
		case 29:
			tempLandmark = new ColorGroup("MARVIN GARDENS", Color.YELLOW, new ImageView(new Image("Landmarks/29.jpg")), 280, 150, new int[] {24, 120, 360, 850, 1025, 1200});
			break;
		case 30:
			tempLandmark = new Landmark("GO TO JAIL", Color.GRAY, new ImageView(new Image("Landmarks/30.jpg")));
			break;
		case 31:
			tempLandmark = new ColorGroup("PACIFIC AVENUE", Color.GREEN, new ImageView(new Image("Landmarks/31.jpg")), 300, 200, new int[] {26, 130, 390, 900, 1100, 1275});
			break;
		case 32:
			tempLandmark = new ColorGroup("NORTH CAROLINA AVENUE", Color.GREEN, new ImageView(new Image("Landmarks/32.jpg")), 300, 200, new int[] {26, 130, 390, 900, 1100, 1275});
			break;
		case 33:
			tempLandmark = new Landmark("COMMUNITY CHEST", Color.GRAY, new ImageView(new Image("Landmarks/33.jpg")));
			break;
		case 34:
			tempLandmark = new ColorGroup("PENNSYLVANIA AVENUE", Color.GREEN, new ImageView(new Image("Landmarks/34.jpg")), 320, 200, new int[] {28, 150, 450, 1000, 1200, 1400});
			break;
		case 35:
			tempLandmark = new Railroad("SHORT LINE", Color.GRAY, new ImageView(new Image("Landmarks/35.jpg")));
			break;
		case 36:
			tempLandmark = new Landmark("CHANCE", Color.GRAY, new ImageView(new Image("Landmarks/36.jpg")));
			break;
		case 37:
			tempLandmark = new ColorGroup("PARK PLACE", Color.DARKBLUE, new ImageView(new Image("Landmarks/37.jpg")), 350, 200, new int[] {35, 175, 500, 1100, 1300, 1500});
			break;
		case 38:
			tempLandmark = new TaxSpace("LUXURY TAX", Color.GRAY, new ImageView(new Image("Landmarks/38.jpg")), 100);
			break;
		case 39:
			tempLandmark = new ColorGroup("BOARDWALK", Color.DARKBLUE, new ImageView(new Image("Landmarks/39.jpg")), 400, 200, new int[] {50, 200, 600, 1400, 170, 2000});
			break;
		default:
			break;
		}
		return tempLandmark;
	}

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
	
	public ArrayList<Integer> getArrayList(int[] anArray) {
		ArrayList<Integer> tempArrayList = new ArrayList<>();
		for(int anInt: anArray) {
			tempArrayList.add(anInt);
		}
		return tempArrayList;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
