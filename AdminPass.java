package vendingMachine;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by james on 20/07/2017.
 */
public class AdminPass {

    public static void display() throws Exception {
        Stage window = new Stage();
        window.resizableProperty().setValue(Boolean.FALSE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Passcode");

        String password = "1905";

        //Labels
        PasswordField passcode = new PasswordField();
        passcode.setPadding(new Insets(10,10,10,10));
        passcode.setAlignment(Pos.CENTER);
        passcode.setPrefWidth(60);

        //Images
        Image delete = new Image(Main.class.getResourceAsStream("img\\delete.png"));
        Image submit = new Image(Main.class.getResourceAsStream("img\\submit.png"));
        Image one = new Image(Main.class.getResourceAsStream("img\\1.png"));
        Image two = new Image(Main.class.getResourceAsStream("img\\2.png"));
        Image three = new Image(Main.class.getResourceAsStream("img\\3.png"));
        Image four = new Image(Main.class.getResourceAsStream("img\\4.png"));
        Image five = new Image(Main.class.getResourceAsStream("\\img\\5.png"));
        Image six = new Image(Main.class.getResourceAsStream("\\img\\6.png"));
        Image seven = new Image(Main.class.getResourceAsStream("\\img\\7.png"));
        Image eight = new Image(Main.class.getResourceAsStream("\\img\\8.png"));
        Image nine = new Image(Main.class.getResourceAsStream("\\img\\9.png"));
        Image zero = new Image(Main.class.getResourceAsStream("\\img\\0.png"));

        ImageView deleteImg = new ImageView();
        ImageView submitImg = new ImageView();
        ImageView zeroImg = new ImageView();
        ImageView oneImg = new ImageView();
        ImageView twoImg = new ImageView();
        ImageView threeImg = new ImageView();
        ImageView fourImg = new ImageView();
        ImageView fiveImg = new ImageView();
        ImageView sixImg = new ImageView();
        ImageView sevenImg = new ImageView();
        ImageView eightImg = new ImageView();
        ImageView nineImg = new ImageView();

        deleteImg.setImage(delete);
        submitImg.setImage(submit);
        zeroImg.setImage(zero);
        oneImg.setImage(one);
        twoImg.setImage(two);
        threeImg.setImage(three);
        fourImg.setImage(four);
        fiveImg.setImage(five);
        sixImg.setImage(six);
        sevenImg.setImage(seven);
        eightImg.setImage(eight);
        nineImg.setImage(nine);

        //Buttons
        Button zeroBtn = new Button();
        zeroBtn.setGraphic(zeroImg);
        Button oneBtn = new Button();
        oneBtn.setGraphic(oneImg);
        Button twoBtn = new Button();
        twoBtn.setGraphic(twoImg);
        Button threeBtn = new Button();
        threeBtn.setGraphic(threeImg);
        Button fourBtn = new Button();
        fourBtn.setGraphic(fourImg);
        Button fiveBtn = new Button();
        fiveBtn.setGraphic(fiveImg);
        Button sixBtn = new Button();
        sixBtn.setGraphic(sixImg);
        Button sevenBtn = new Button();
        sevenBtn.setGraphic(sevenImg);
        Button eightBtn = new Button();
        eightBtn.setGraphic(eightImg);
        Button nineBtn = new Button();
        nineBtn.setGraphic(nineImg);
        Button confirmBtn = new Button();
        confirmBtn.setGraphic(submitImg);
        Button deleteBtn = new Button();
        deleteBtn.setGraphic(deleteImg);

        GridPane passcodeLayout = new GridPane();
        passcodeLayout.addRow(0, oneBtn, twoBtn, threeBtn);
        passcodeLayout.addRow(1, fourBtn, fiveBtn, sixBtn);
        passcodeLayout.addRow(2, sevenBtn, eightBtn, nineBtn);
        passcodeLayout.addRow(3, confirmBtn, zeroBtn, deleteBtn);
        passcodeLayout.setHgap(5);
        passcodeLayout.setVgap(5);
        passcodeLayout.setPadding(new Insets(10));

        zeroBtn.setOnAction(e-> {
            passcode.appendText("0");
        });

        oneBtn.setOnAction(e-> {
            passcode.appendText("1");
        });

        twoBtn.setOnAction(e-> {
            passcode.appendText("2");
        });

        threeBtn.setOnAction(e-> {
            passcode.appendText("3");
        });

        fourBtn.setOnAction(e-> {
            passcode.appendText("4");
        });

        fiveBtn.setOnAction(e-> {
            passcode.appendText("5");
        });

        sixBtn.setOnAction(e-> {
            passcode.appendText("6");
        });

        sevenBtn.setOnAction(e-> {
            passcode.appendText("7");
        });

        eightBtn.setOnAction(e-> {
            passcode.appendText("8");
        });

        nineBtn.setOnAction(e-> {
            passcode.appendText("9");
        });

        deleteBtn.setOnAction(e-> {
            if(passcode.getText().length()>0) {
                passcode.deleteText(passcode.getLength() - 1, passcode.getLength());
            }
        });

        confirmBtn.setOnAction(e-> {
            if(passcode.getText().equals(password)) {
                try {
                    Admin.display();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                window.close();
            }
            else {
                passcode.setText("");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error!");
                alert.setHeaderText("Incorrect passcode");
                alert.setContentText("Please input the correct passcode to access admin features.");
                alert.showAndWait();
            }
        });

        passcode.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                    try {
                        Admin.display();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    window.close();
                }
            }
        });

        GridPane layout = new GridPane();
        layout.addRow(0, passcode);
        layout.addRow(1, passcodeLayout);
        layout.setPadding(new Insets(10,0,10,10));
        layout.setVgap(5);
        layout.setHgap(5);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("vendingMachine/stylesheet.css");
        window.setScene(scene);
        window.showAndWait();

    }


}
