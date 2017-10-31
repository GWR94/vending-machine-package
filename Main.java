package vendingMachine;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

import static vendingMachine.CoinsInput.moneyInMachine;


/**
 * Created by HP on 07/07/2017.
 */


public class Main extends Application {
    Stage window;

    private static DecimalFormat df = new DecimalFormat("0.00");
    private static BigDecimal cost = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);

    public void start(Stage primaryStage) throws Exception {

        Stage window = new Stage();
        window.setTitle("vendingMachine.Food Dispenser");

        //Labels
        Label doritosLbl = new Label("Doritos Crisps:");
        Label walkersLbl = new Label("Walkers Crisps:");
        Label sweetsLbl = new Label("Sweets:");
        Label coinsLbl = new Label("Please insert coins: ");
        Label instructionLbl = new Label("Please choose a selection and insert money:");
        Label moneyInMachineLbl = new Label("Coins: £0.00");
        Label costLbl = new Label("Cost: £0.00");
        costLbl.setId("cost");
        moneyInMachineLbl.setId("cost");

        //Buttons
        Button purchaseBtn = new Button("Purchase");
        purchaseBtn.setId("input");
        Button cancelBtn = new Button("Cancel");
        cancelBtn.setId("input");
        Button coinsBtn = new Button("Insert Coins");
        coinsBtn.setId("input");
        Button adminBtn = new Button("-admin-");
        adminBtn.setId("admin");

        //Images
        Image walkers = new Image(Main.class.getResourceAsStream("img\\walkers.png"));
        Image doritos = new Image(Main.class.getResourceAsStream("img\\doritos.png"));
        Image sweets = new Image(Main.class.getResourceAsStream("img\\sweets.png"));
        Image warning = new Image(Main.class.getResourceAsStream("img\\warning.png"));
        ImageView warningImg = new ImageView(warning);
        ImageView walkersImg = new ImageView(walkers);
        walkersImg.setFitWidth(70);
        walkersImg.setFitHeight(70);
        ImageView doritosImg = new ImageView(doritos);
        doritosImg.setFitHeight(70);
        doritosImg.setFitWidth(70);
        ImageView sweetsImg = new ImageView(sweets);
        sweetsImg.setFitWidth(70);
        sweetsImg.setFitHeight(70);

        //Radio Buttons for food selections
        RadioButton walkSaltVingerBtn = new RadioButton("Salt & Vinegar");
        RadioButton walkCheeseOnionBtn = new RadioButton("Cheese & Onion");
        RadioButton walkReadySaltedBtn = new RadioButton("Ready Salted");
        RadioButton dorCoolBtn = new RadioButton("Cool Original");
        RadioButton dorChilliBtn = new RadioButton("Chilli Heatwave");
        RadioButton dorRouletteBtn = new RadioButton("Roulette");
        RadioButton skittlesBtn = new RadioButton("Skittles");
        RadioButton wineGumsBtn = new RadioButton("Wine Gums");
        RadioButton mintsBtn = new RadioButton("Glacier Mints");

        //Creating and setting toggle groups
        ToggleGroup food = new ToggleGroup();
        walkCheeseOnionBtn.setToggleGroup(food);
        walkSaltVingerBtn.setToggleGroup(food);
        walkReadySaltedBtn.setToggleGroup(food);
        dorChilliBtn.setToggleGroup(food);
        dorCoolBtn.setToggleGroup(food);
        dorRouletteBtn.setToggleGroup(food);
        skittlesBtn.setToggleGroup(food);
        wineGumsBtn.setToggleGroup(food);
        mintsBtn.setToggleGroup(food);

        if (SearchFile.lowFunds()) {
            warningImg.setVisible(true);
        } else {
            warningImg.setVisible(false);
        }

        walkCheeseOnionBtn.setOnAction(e -> {
            cost = new BigDecimal(0.75);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        walkReadySaltedBtn.setOnAction(e -> {
            cost = new BigDecimal(0.75);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        walkSaltVingerBtn.setOnAction(e -> {
            cost = new BigDecimal(0.75);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        dorCoolBtn.setOnAction(e -> {
            cost = new BigDecimal(0.80);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        dorRouletteBtn.setOnAction(e -> {
            cost = new BigDecimal(0.80);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        dorChilliBtn.setOnAction(e -> {
            cost = new BigDecimal(0.80);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        skittlesBtn.setOnAction(e -> {
            cost = new BigDecimal(0.60);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        wineGumsBtn.setOnAction(e -> {
            cost = new BigDecimal(0.60);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        mintsBtn.setOnAction(e -> {
            cost = new BigDecimal(0.60);
            costLbl.setText("Cost: £" + df.format(cost));
        });

        coinsBtn.setOnAction(e -> {
            try {
                BigDecimal moneyInMachine = CoinsInput.display();
                moneyInMachineLbl.setText("Coins: £" + df.format(moneyInMachine));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        purchaseBtn.setOnAction(e -> {
            try {
                if (cost.equals(0.00)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Error! Please choose an item to purchase!");
                    alert.setContentText("Please choose an item which you would like to purchase and try again.");
                    alert.showAndWait();
                } else if (moneyInMachine.setScale(2, BigDecimal.ROUND_HALF_UP).subtract(cost.setScale(2, BigDecimal.ROUND_HALF_UP)).compareTo(BigDecimal.ZERO) < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Error! Please insert more coins.");
                    alert.setContentText("You haven't inserted enough money to purchase the item you have selected. Please insert more money and try again.");
                    alert.showAndWait();
                } else if (Calculations.isPossible((int) (moneyInMachine.doubleValue() * 100 - cost.doubleValue() * 100))) {
                    Map<String, Integer> change = Calculations.calculateChange((int) ((moneyInMachine.doubleValue() * 100) - (cost.doubleValue() * 100)));
                    ChangeDisplay.display(change, cost, moneyInMachine);
                    moneyInMachine = new BigDecimal(0.00);
                    moneyInMachineLbl.setText("Coins: £" + df.format(moneyInMachine));
                    if (SearchFile.lowFunds()) {
                        warningImg.setVisible(true);
                    } else {
                        warningImg.setVisible(false);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Error! Not enough coins to give valid change.");
                    alert.setContentText("Please enter the correct amount, or choose a cheaper item to complete the order." +
                            "Extra coins will be input as soon as a member of staff is available.");
                    alert.showAndWait();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        cancelBtn.setOnAction(e -> {
            try {
                Map<String, Integer> changeToReturn = Calculations.calculateChange((int) (moneyInMachine.doubleValue() * 100));
                ReturnFunds.display(changeToReturn, moneyInMachine);
                moneyInMachine = new BigDecimal(0.00);
                moneyInMachineLbl.setText("Coins: £" + df.format(moneyInMachine));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        adminBtn.setOnAction(e -> {
            try {
                AdminPass.display();
                if (SearchFile.lowFunds()) {
                    warningImg.setVisible(true);
                } else {
                    warningImg.setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //Layout setup
        HBox images = new HBox(35);
        images.getChildren().addAll(walkersImg, doritosImg, sweetsImg);
        images.setAlignment(Pos.CENTER);
        images.setPadding(new Insets(10));

        VBox doritosLayout = new VBox(10);
        doritosLayout.getChildren().addAll(dorCoolBtn, dorChilliBtn, dorRouletteBtn);
        doritosLayout.setPadding(new Insets(5));

        VBox walkersLayout = new VBox(10);
        walkersLayout.getChildren().addAll(walkReadySaltedBtn, walkCheeseOnionBtn, walkSaltVingerBtn);
        walkersLayout.setPadding(new Insets(5));

        VBox sweetsLayout = new VBox(10);
        sweetsLayout.getChildren().addAll(skittlesBtn, wineGumsBtn, mintsBtn);
        sweetsLayout.setPadding(new Insets(5));

        HBox buttons = new HBox(10);
        buttons.setPadding(new Insets(5, 20, 5, 20));
        buttons.getChildren().addAll(cancelBtn, purchaseBtn, coinsBtn);
        buttons.setAlignment(Pos.CENTER);

        GridPane selectionLayout = new GridPane();
        selectionLayout.add(images, 0, 0, 3, 1);
        selectionLayout.add(walkersLayout, 0, 1, 1, 1);
        selectionLayout.add(doritosLayout, 1, 1, 1, 1);
        selectionLayout.add(sweetsLayout, 2, 1, 1, 1);
        selectionLayout.setPadding(new Insets(10));

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(40, 40, 20, 40));
        layout.add(costLbl, 0, 0, 1, 1);
        layout.setHalignment(costLbl, HPos.LEFT);
        layout.add(moneyInMachineLbl, 2, 0, 1, 1);
        layout.setHalignment(moneyInMachineLbl, HPos.RIGHT);
        layout.add(selectionLayout, 0, 1, 3, 1);
        layout.add(buttons, 0, 2, 3, 1);
        layout.add(adminBtn, 0, 3, 3, 1);
        layout.add(warningImg, 0, 4, 3, 1);
        layout.setHalignment(adminBtn, HPos.CENTER);
        layout.setHalignment(warningImg, HPos.CENTER);

        layout.setHgap(10);
        layout.setVgap(10);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("vendingMachine/stylesheet.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
