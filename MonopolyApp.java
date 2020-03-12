import java.util.Random;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonopolyApp extends Application {
	
	@Override
	public void start (Stage primaryStage) {
		final int rowCounts = 11;
		final int columnCounts = 11;
		final int positionCounts = 40;
		final double tileHeightPercent = 14.0;
		final double tileWidthPercent = 8.0;
		
		GridPane board = new GridPane();
		
		RowConstraints borderRows = new RowConstraints();
		RowConstraints inbetweenRows = new RowConstraints();
		ColumnConstraints borderColumns = new ColumnConstraints();
		ColumnConstraints inbetweenColumns = new ColumnConstraints();
		
		borderRows.setPercentHeight(tileHeightPercent);
		inbetweenRows.setPercentHeight(tileWidthPercent);
		borderColumns.setPercentWidth(tileHeightPercent);
		inbetweenColumns.setPercentWidth(tileWidthPercent);
		
        for (int i = 0; i < rowCounts; i++) {
        	if (i == 0 || i == rowCounts - 1) {
        		board.getRowConstraints().add(borderRows);
        	}
        	else {
        		board.getRowConstraints().add(inbetweenRows);
        	}
        }
        for (int j = 0; j < columnCounts; j++) {
        	if (j == 0 || j == columnCounts - 1) {
        		board.getColumnConstraints().add(borderColumns);
        	}
        	else {
        		board.getColumnConstraints().add(inbetweenColumns);
        	}
        }
        
        StackPane center = new StackPane();
        center.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        center.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Label logo = new Label("MONOPOLY");
        logo.setFont(new Font("Arial", 60));
        
        center.getChildren().add(logo);
        board.add(center, 1, 1, columnCounts-2, rowCounts-2);
        
        for (int index = 0; index < positionCounts; index++) {
        	if (index >= 0 && index <= 9) {
        		board.add(addTile(index), 10 - index, 10);
        	}
        	else if (index >= 10 && index <= 19) {
        		board.add(addTile(index), 0, 20 - index);
        	}
        	else if (index >= 20 && index <= 29) {
        		board.add(addTile(index), index - 20, 0);
        	}
        	else {
        		board.add(addTile(index), 10, index - 30);
        	}
        } 
        
        Button rollDice = new Button("Roll the dice");
        Label dice1 = new Label("6");
        Label dice2 = new Label("6");
        dice1.setFont(new Font("Arial", 20));
        dice2.setFont(new Font("Arial", 20));
        board.add(rollDice, 2, 8, 2, 1);
        board.add(dice1, 2, 7);
        board.add(dice2, 3, 7);
        
        rollDice.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e)
        	{
        		Random rand = new Random();
        		dice1.setText(Integer.toString(rand.nextInt(6)+1));
        		dice2.setText(Integer.toString(rand.nextInt(6)+1));
        	}
        });
        
        board.setGridLinesVisible(false);
        
        Scene scene = new Scene(board);
        primaryStage.setHeight(700);
        primaryStage.setWidth(700);
        primaryStage.setTitle("MONOPOLY");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public StackPane addTile(int index) {
		StackPane tempPane = new StackPane();
		tempPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Label tempLabel = new Label();
		
		switch(index) {
			case 0:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("GO\n COLLECT\n$200 SALARY\nAS YOU PASS");
				break;
			case 1:
				tempPane.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("MEDITER-\nRANEAN\nAVANUE\n$60");
				break;
			case 2:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("COMMUNITY\nCHEST");
				break;
			case 3:
				tempPane.setBackground(new Background(new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("BALTIC\nAVENUE\n$60");
				break;
			case 4:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("INCOME\nTAX\nPAY $200");
				break;
			case 5:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("READING\nRAILROAD\n$200");
				break;
			case 6:
				tempPane.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("ORIENTAL\nAVENUE\n$100");
				break;
			case 7:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("CHANCE");
				break;
			case 8:
				tempPane.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("VERMONT\nAVENUE\n$100");
				break;
			case 9:
				tempPane.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("CONNECTICUT\nAVENUE\n$120");
				break;
			case 10:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("IN\nJAIL");
				break;
			case 11:
				tempPane.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("ST. CHARLES\nPLACE\n$140");
				break;
			case 12:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("ELECTRIC\nCOMPANY\n$150");
				break;
			case 13:
				tempPane.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("STATES\nAVENUE\n$140");
				break;
			case 14:
				tempPane.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("VIRGINIA\nAVENUE\n$160");
				break;
			case 15:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("PENNSYLVANIA\nRAILROAD\n$200");
				break;
			case 16:
				tempPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("ST. JAMES\nPLACE\n$180");
				break;
			case 17:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("COMMUNITY\nCHEST");
				break;
			case 18:
				tempPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("TENNESSEE\nAVENUE\n$180");
				break;
			case 19:
				tempPane.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("NEW YORK\nAVENUE\n$200");
				break;
			case 20:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("FREE\nPARKING");
				break;
			case 21:
				tempPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("KENTUCKY\nAVENUE\n$220");
				break;
			case 22:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("CHANCE");
				break;
			case 23:
				tempPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("INDIANA\nAVENUE\n$220");
				break;
			case 24:
				tempPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("ILLINOIS\nAVENUE\n$240");
				break;
			case 25:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("B&O\nRAILROAD\n$200");
				break;
			case 26:
				tempPane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("ATLANTIC\nAVENUE\n$260");
				break;
			case 27:
				tempPane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("VENINOR\nAVENUE\n$260");
				break;
			case 28:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("WATER\nWORKS\n$150");
				break;
			case 29:
				tempPane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("MARVIN\nGARDENS\n$280");
				break;
			case 30:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("GO TO\nJAIL");
				break;
			case 31:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("PACIFIC\nAVENUE\n$300");
				break;
			case 32:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("NORTH\nCAROLINA\nAVENUE\n$300");
				break;
			case 33:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("COMMUNITY\nCHEST");
				break;
			case 34:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("PENNSYLVANIA\nAVENUE\n$320");
				break;
			case 35:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("SHORT\nLINE\n$200");
				break;
			case 36:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("CHANCE");
				break;
			case 37:
				tempPane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("PARK\nPLACE\n$350");
				break;
			case 38:
				tempPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("LUXURY\nTAX\nPAY $100");
				break;
			case 39:
				tempPane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				tempLabel = new Label("BOARDWALK\n$400");
				break;
			default:
				break;
		}
		
		tempLabel.setFont(new Font("Arial", 10));
		tempPane.getChildren().add(tempLabel);
		return tempPane;
	}
	
	public static void main(String[] args) {
        Application.launch(args);
    }
}
