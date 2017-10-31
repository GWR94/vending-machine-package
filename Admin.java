package vendingMachine;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static vendingMachine.CoinsInput.df;
import static vendingMachine.SearchFile.*;

/**
 * Created by james on 19/07/2017.
 */
public class Admin {
    public static void display() throws Exception {

        SearchFile searchFile = new SearchFile();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Admin");

        Label currentCoinsLbl = new Label("In Machine: £" + df.format(getCurrentMoney()));
        currentCoinsLbl.setStyle("-fx-font-size: 20px");
        Label addLbl = new Label("Add");
        addLbl.setId("title");
        Label removeLbl = new Label("Remove");
        removeLbl.setId("title");

        //Add Coins Buttons
        Button addTwoPoundBtn = new Button("£2 (" + returnCoin("£2") + ")");
        Button addOnePoundBtn = new Button("£1 (" + returnCoin("£1") + ")");
        Button addFiftyPenceBtn = new Button("50p (" + returnCoin("50p") + ")");
        Button addTwentyPenceBtn = new Button("20p (" + returnCoin("20p") + ")");
        Button addTenPenceBtn = new Button("10p (" + returnCoin("10p") + ")");
        Button addFivePenceBtn = new Button("5p (" + returnCoin("5p") + ")");
        Button addTwoPenceBtn = new Button("2p (" + returnCoin("2p") + ")");
        Button addOnePenceBtn = new Button("1p (" + returnCoin("1p") + ")");
        Button addFiveBtn = new Button("All + 5");
        Button removeAllBtn = new Button("Remove All");
        Button doneBtn = new Button("Done");

        addTwoPoundBtn.setId("coin");
        addOnePoundBtn.setId("coin");
        addFiftyPenceBtn.setId("coin");
        addTwentyPenceBtn.setId("coin");
        addTenPenceBtn.setId("coin");
        addFivePenceBtn.setId("coin");
        addTwoPenceBtn.setId("coin");
        addOnePenceBtn.setId("coin");

        //Remove Coins Buttons
        Button removeTwoPoundBtn = new Button("£2 (" + returnCoin("£2") + ")");
        Button removeOnePoundBtn = new Button("£1 (" + returnCoin("£1") + ")");
        Button removeFiftyPenceBtn = new Button("50p (" + returnCoin("50p") + ")");
        Button removeTwentyPenceBtn = new Button("20p (" + returnCoin("20p") + ")");
        Button removeTenPenceBtn = new Button("10p (" + returnCoin("10p") + ")");
        Button removeFivePenceBtn = new Button("5p (" + returnCoin("5p") + ")");
        Button removeTwoPenceBtn = new Button("2p (" + returnCoin("2p") + ")");
        Button removeOnePenceBtn = new Button("1p (" + returnCoin("1p") + ")");
        removeTwoPoundBtn.setId("coin");
        removeOnePoundBtn.setId("coin");
        removeFiftyPenceBtn.setId("coin");
        removeTwentyPenceBtn.setId("coin");
        removeTenPenceBtn.setId("coin");
        removeFivePenceBtn.setId("coin");
        removeTwoPenceBtn.setId("coin");
        removeOnePenceBtn.setId("coin");

        //Add Coins Action Events
        addTwoPoundBtn.setOnAction(e-> {
            addOneCoin("£2");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwoPoundBtn.setText("£2 (" + returnCoin("£2") +")");
                removeTwoPoundBtn.setText("£2 (" + returnCoin("£2") +")");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addOnePoundBtn.setOnAction(e-> {
            addOneCoin("£1");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
                removeOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addFiftyPenceBtn.setOnAction(e-> {
            addOneCoin("50p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
                removeFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addTwentyPenceBtn.setOnAction(e-> {
            addOneCoin("20p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
                removeTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addTenPenceBtn.setOnAction(e-> {
            addOneCoin("10p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
                removeTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addFivePenceBtn.setOnAction(e-> {
            addOneCoin("5p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
                removeFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addTwoPenceBtn.setOnAction(e-> {
            addOneCoin("2p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
                removeTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addOnePenceBtn.setOnAction(e-> {
            addOneCoin("1p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
                removeOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addFiveBtn.setOnAction(e-> {
            addCoins("£2", 5);
            addCoins("£1", 5);
            addCoins("50p", 5);
            addCoins("20p", 5);
            addCoins("10p", 5);
            addCoins("5p", 5);
            addCoins("2p", 5);
            addCoins("1p", 5);
            try {
                addOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
                removeOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
                addTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
                removeTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
                addFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
                removeFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
                addTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
                removeTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
                addTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
                removeTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
                addFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
                removeFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
                addOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
                removeOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
                addTwoPoundBtn.setText("£2 (" + returnCoin("£2") + ")");
                removeTwoPoundBtn.setText("£2 (" + returnCoin("£2") + ")");
                currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        });

        //Remove Coins Action Events
        removeTwoPoundBtn.setOnAction(e-> {
            removeOneCoin("£2");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwoPoundBtn.setText("£2 (" + returnCoin("£2") +")");
                removeTwoPoundBtn.setText("£2 (" + returnCoin("£2") +")");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        removeOnePoundBtn.setOnAction(e-> {
            removeOneCoin("£1");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
                removeOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        removeFiftyPenceBtn.setOnAction(e-> {
            removeOneCoin("50p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
                removeFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        removeTwentyPenceBtn.setOnAction(e-> {
            removeOneCoin("20p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
                removeTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        removeTenPenceBtn.setOnAction(e-> {
            removeOneCoin("10p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
                removeTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        removeFivePenceBtn.setOnAction(e-> {
            removeOneCoin("5p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
                removeFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        removeTwoPenceBtn.setOnAction(e-> {
            removeOneCoin("2p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
                removeTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        removeOnePenceBtn.setOnAction(e-> {
            removeOneCoin("1p");
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
                removeOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        removeAllBtn.setOnAction(e-> {
            removeAll();
            currentCoinsLbl.setText("In Machine: £" + df.format(getCurrentMoney()));
            try {
                addTwoPoundBtn.setText("£2 (" + returnCoin("£2") + ")");
                removeTwoPoundBtn.setText("£2 (" + returnCoin("£2") + ")");
                addOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
                removeOnePoundBtn.setText("£1 (" + returnCoin("£1") + ")");
                addFiftyPenceBtn.setText("50p (" + returnCoin("50p") + ")");
                removeFiftyPenceBtn.setText("50p (" + returnCoin("5p") + ")");
                addTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
                removeTwentyPenceBtn.setText("20p (" + returnCoin("20p") + ")");
                addTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
                removeTenPenceBtn.setText("10p (" + returnCoin("10p") + ")");
                addFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
                removeFivePenceBtn.setText("5p (" + returnCoin("5p") + ")");
                addTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
                removeTwoPenceBtn.setText("2p (" + returnCoin("2p") + ")");
                addOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
                removeOnePenceBtn.setText("1p (" + returnCoin("1p") + ")");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        doneBtn.setOnAction(e-> {
            window.close();
        });

        GridPane addCoinsLayout = new GridPane();
        addCoinsLayout.add(addLbl,0,0,2,1);
        addCoinsLayout.setHalignment(addLbl, HPos.CENTER);
        addCoinsLayout.addRow(1, addTwoPoundBtn, addOnePoundBtn);
        addCoinsLayout.addRow(2, addFiftyPenceBtn, addTwentyPenceBtn);
        addCoinsLayout.addRow(3, addTenPenceBtn, addFivePenceBtn);
        addCoinsLayout.addRow(4, addTwoPenceBtn, addOnePenceBtn);
        addCoinsLayout.add(addFiveBtn, 0,5,2,1);
        addCoinsLayout.setHalignment(addFiveBtn, HPos.CENTER);
        addCoinsLayout.setVgap(10);
        addCoinsLayout.setHgap(10);
        addCoinsLayout.setPadding(new Insets(5,20,5,20));
        addCoinsLayout.setAlignment(Pos.CENTER);

        GridPane removeCoinsLayout = new GridPane();
        removeCoinsLayout.add(removeLbl, 0,0,2,1);
        removeCoinsLayout.setHalignment(removeLbl, HPos.CENTER);
        removeCoinsLayout.addRow(1, removeTwoPoundBtn, removeOnePoundBtn);
        removeCoinsLayout.addRow(2, removeFiftyPenceBtn, removeTwentyPenceBtn);
        removeCoinsLayout.addRow(3, removeTenPenceBtn, removeFivePenceBtn);
        removeCoinsLayout.addRow(4, removeTwoPenceBtn, removeOnePenceBtn);
        removeCoinsLayout.add(removeAllBtn, 0,5,2,1);
        removeCoinsLayout.setHalignment(removeAllBtn, HPos.CENTER);
        removeCoinsLayout.setVgap(10);
        removeCoinsLayout.setHgap(10);
        removeCoinsLayout.setPadding(new Insets(10,20,10,20));
        removeCoinsLayout.setAlignment(Pos.CENTER);

        GridPane layout = new GridPane();
        layout.add(currentCoinsLbl, 0,0,2,1);
        layout.setHalignment(currentCoinsLbl, HPos.CENTER);
        layout.add(addCoinsLayout, 0,1,1,1);
        layout.add(removeCoinsLayout, 1,1,1,1);
        layout.add(doneBtn, 0,2,2,1);
        layout.setHalignment(doneBtn, HPos.CENTER);
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("vendingMachine/stylesheet.css");
        window.setScene(scene);
        window.showAndWait();

    }

}
