package vendingMachine;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by james on 20/07/2017.
 */
public class CoinsInput {
    static DecimalFormat df = new DecimalFormat("0.00");
    static BigDecimal moneyInMachine = new BigDecimal(0.00).setScale(2,BigDecimal.ROUND_HALF_UP);
    static Map<String, Integer> coinsInput = new HashMap<>();

    public static BigDecimal display() throws Exception {
        Stage window = new Stage();
        window.resizableProperty().setValue(Boolean.FALSE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Coins");

        coinsInput.put("£2", 0);
        coinsInput.put("£1", 0);
        coinsInput.put("50p", 0);
        coinsInput.put("20p", 0);
        coinsInput.put("10p", 0);
        coinsInput.put("5p", 0);
        coinsInput.put("2p", 0);
        coinsInput.put("1p", 0);

        //Labels
        Label instructionLbl = new Label("Please insert money:");
        Label coinsInMachineLbl = new Label("£" + df.format(moneyInMachine));

        //Buttons
        Button twoPoundBtn = new Button("£2");
        Button onePoundBtn = new Button("£1");
        Button fiftyPenceBtn = new Button("50p");
        Button twentyPenceBtn = new Button("20p");
        Button tenPenceBtn = new Button("10p");
        Button fivePenceBtn = new Button("5p");
        Button twoPenceBtn = new Button("2p");
        Button onePenceBtn = new Button("1p");

        Button confirmBtn = new Button("Confirm");
        Button ejectBtn = new Button("Eject");

        //Style Coins
        twoPoundBtn.setId("coins");
        onePoundBtn.setId("coins");
        fiftyPenceBtn.setId("coins");
        twentyPenceBtn.setId("coins");
        tenPenceBtn.setId("coins");
        fivePenceBtn.setId("coins");
        twoPenceBtn.setId("coins");
        onePenceBtn.setId("coins");
        confirmBtn.setId("output");
        ejectBtn.setId("output");

        twoPoundBtn.setOnAction(e -> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(2.00));
            coinsInput.replace("£2", coinsInput.get("£2")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        onePoundBtn.setOnAction(e -> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(1.00));
            coinsInput.replace("£1", coinsInput.get("£1")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        fiftyPenceBtn.setOnAction(e -> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(0.50));
            coinsInput.replace("50p", coinsInput.get("50p")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        twentyPenceBtn.setOnAction(e -> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(0.20));
            coinsInput.replace("20p", coinsInput.get("20p")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        tenPenceBtn.setOnAction(e-> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(0.10));
            coinsInput.replace("10p", coinsInput.get("10p")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        fivePenceBtn.setOnAction(e-> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(0.05));
            coinsInput.replace("5p", coinsInput.get("5p")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        twoPenceBtn.setOnAction(e->{
            moneyInMachine = moneyInMachine.add(new BigDecimal(0.02));
            coinsInput.replace("2p", coinsInput.get("2p")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        onePenceBtn.setOnAction(e-> {
            moneyInMachine = moneyInMachine.add(new BigDecimal(0.01));
            coinsInput.replace("1p", coinsInput.get("1p")+1);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        ejectBtn.setOnAction(e-> {
            moneyInMachine = new BigDecimal(0.00);
            coinsInMachineLbl.setText("£" + df.format(moneyInMachine));
        });

        confirmBtn.setOnAction(e-> {
            if(coinsInput.get("£2") > 0) {
                SearchFile.addCoins("£2", coinsInput.get("£2"));
            }
            if(coinsInput.get("£1") > 0) {
                SearchFile.addCoins("£1", coinsInput.get("£1"));
            }
            if(coinsInput.get("50p") > 0) {
                SearchFile.addCoins("50p", coinsInput.get("50p"));
            }
            if(coinsInput.get("20p") > 0) {
                SearchFile.addCoins("20p", coinsInput.get("20p"));
            }
            if(coinsInput.get("10p") > 0) {
                SearchFile.addCoins("10p", coinsInput.get("10p"));
            }
            if(coinsInput.get("5p") > 0) {
                SearchFile.addCoins("5p", coinsInput.get("5p"));
            }
            if(coinsInput.get("2p") > 0) {
                SearchFile.addCoins("2p", coinsInput.get("2p"));
            }
            if(coinsInput.get("1p") > 0) {
                SearchFile.addCoins("1p", coinsInput.get("1p"));
            }
            window.close();
        });

        HBox moneyLayout = new HBox();
        moneyLayout.getChildren().add(coinsInMachineLbl);
        moneyLayout.setId("money");
        moneyLayout.setAlignment(Pos.CENTER);

        HBox outputButtonsLayout = new HBox(5);
        outputButtonsLayout.getChildren().addAll(confirmBtn, ejectBtn);
        outputButtonsLayout.setAlignment(Pos.CENTER);

        //Layout setup
        GridPane coinsLayout = new GridPane();
        coinsLayout.addRow(1, twoPoundBtn, onePoundBtn);
        coinsLayout.addRow(2, fiftyPenceBtn, twentyPenceBtn);
        coinsLayout.addRow(3, tenPenceBtn, fivePenceBtn);
        coinsLayout.addRow(4, twoPenceBtn, onePenceBtn);
        coinsLayout.setVgap(10);
        coinsLayout.setHgap(10);
        coinsLayout.setPadding(new Insets(5,5,15,5));
        coinsLayout.setAlignment(Pos.CENTER);

        GridPane layout = new GridPane();
        layout.addRow(0, moneyLayout);
        layout.addRow(1, coinsLayout);
        layout.addRow(2, outputButtonsLayout);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("vendingMachine/stylesheet.css");
        window.setScene(scene);
        window.showAndWait();

        return moneyInMachine;
    }


}
