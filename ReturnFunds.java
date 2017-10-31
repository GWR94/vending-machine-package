package vendingMachine;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Map;

import static vendingMachine.CoinsInput.df;

/**
 * Created by james on 21/07/2017.
 */
public class ReturnFunds {

    public static void display(Map<String, Integer> change, BigDecimal coins) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Coin Return");
        Label amountLbl = new Label("Returning £" + df.format(coins));
        Label changeLbl = new Label();
        Label anotherLbl = new Label("Would you like to return to selection?");
        anotherLbl.setPadding(new Insets(10));
        changeLbl.setPadding(new Insets(0, 10, 0, 10));
        amountLbl.setPadding(new Insets(10));

        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");


        if (change.containsKey("£2")) {
            changeLbl.setText(changeLbl.getText() + "£2 coins:     " + change.get("£2") + "\n");
        }
        if (change.containsKey("£1")) {
            changeLbl.setText(changeLbl.getText() + "£1 coins:     " + change.get("£1") + "\n");
        }
        if (change.containsKey("50p")) {
            changeLbl.setText(changeLbl.getText() + "50p coins:   " + change.get("50p") + "\n");
        }
        if (change.containsKey("20p")) {
            changeLbl.setText(changeLbl.getText() + "20p coins:   " + change.get("20p") + "\n");
        }
        if (change.containsKey("10p")) {
            changeLbl.setText(changeLbl.getText() + "10p coins:   " + change.get("10p") + "\n");
        }
        if (change.containsKey("5p")) {
            changeLbl.setText(changeLbl.getText() + "5p coins:     " + change.get("5p") + "\n");
        }
        if (change.containsKey("2p")) {
            changeLbl.setText(changeLbl.getText() + "2p coins:     " + change.get("2p") + "\n");
        }
        if (change.containsKey("1p")) {
            changeLbl.setText(changeLbl.getText() + "1p coins:     " + change.get("1p") + "\n");
        }


        boolean another = false;

        yesBtn.setOnAction(e -> window.close());
        noBtn.setOnAction(e -> System.exit(0));

        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(yesBtn, noBtn);
        buttons.setAlignment(Pos.CENTER);

        GridPane layout = new GridPane();
        layout.add(amountLbl, 0, 0, 2, 1);
        layout.add(changeLbl, 0, 1, 2, 1);
        layout.add(anotherLbl, 0, 2, 2, 1);
        layout.add(buttons, 0, 3, 2, 1);
        layout.setPadding(new Insets(20));
        layout.setHalignment(anotherLbl, HPos.CENTER);
        layout.setHalignment(amountLbl, HPos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("vendingMachine/stylesheet.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
