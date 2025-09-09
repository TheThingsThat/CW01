package com.example.cw01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.geometry.Insets;
import java.util.List;

public class PersonalInfoManager extends Application {
    // UI COLORS
    private final String CPrimary = "#383E63";
    private final String CPrimaryHov = "#4A507B";
    private final String CBG = "#F7F8FC";
    private final String CSurface = "#FFFFFF";
    private final String CText = "#1E2233";

    // TEXTFIELDS
    private TextField nameField = new TextField();
    private TextField emailField = new TextField();
    private TextField phoneField = new TextField();
    private List<String> contacts = new ArrayList<>();

    // LABELS
    private Label nameLabel = new Label("Name:");
    private Label emailLabel = new Label("Email:");
    private Label phoneLabel = new Label("Phone:");
    private Label titleLabel = new Label("Contact List");
    private Label errorLabel = new Label("Info Error!");
    private Label successLabel = new Label("Success!");

    // BUTTONS
    private Button addButton = new Button("Add Contact");
    private Button clearButton = new Button("Clear Fields");
    private Button displayButton = new Button("Display All");

    // CONTAINERS
    private VBox mainBox = new VBox(10);
    private HBox buttonBox = new HBox(10);
    private GridPane gridPane = new GridPane();
    private VBox card = new VBox(10,gridPane);
    private VBox contactBox = new VBox(10);

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(mainPage(), 520, 560, Color.BLUE);
        scene.setFill(Color.web(CBG));

        primaryStage.setTitle("Personal Info Manager");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // LAMBDA
        addButton.setOnAction(e -> addContact());

        // METHOD REFERENCE
        clearButton.setOnAction(this::onClearClick);

        // ANONYMOUS CLASS
        displayButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                displayContacts();
            }
        });

        nameField.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ENTER) addContact();});
        emailField.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ENTER) addContact();});
        phoneField.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ENTER) addContact();});

        nameField.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) clearFields();});
        emailField.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) clearFields();});
        phoneField.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) clearFields();});
    }

    private Region mainPage() {
        mainBox.setFillWidth(true);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(12);
        mainBox.setStyle("-fx-background-color: " + CBG + "; -fx-padding: 20;");

        // DROPDOWN SHADOW EFFECT
        card.setStyle("-fx-background-color: " + CSurface + ";" + "-fx-background-radius: 14;" + "-fx-padding: 16;");
        card.setEffect(new javafx.scene.effect.DropShadow(24, Color.rgb(0,0,0,0.08)));

        buttonBox.setAlignment(Pos.CENTER);

        // GRIDPANE UI
        gridPane.setMinSize(360,250);
        gridPane.setPadding(new Insets(6,6,6,6));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        nameField.setPromptText("First and Last");
        emailField.setPromptText("email@website.com");
        phoneField.setPromptText("Numbers Only");

        // PAGE HEADING UI
        titleLabel.setFont(Font.font("Impact", 22));
        titleLabel.setTextFill(Color.web(CPrimary));

        // LABEL UI
        nameLabel.setTextFill(Color.web(CText));
        emailLabel.setTextFill(Color.web(CText));
        phoneLabel.setTextFill(Color.web(CText));

        // ADD BUTTON INTERACTIONS
        addButton.setOnMouseEntered(e -> {
            addButton.setScaleX(1.1);
            addButton.setScaleY(1.1);
            addButton.setStyle(addButton.getStyle().replace(CPrimary, CPrimaryHov));
        });
        addButton.setOnMouseExited(e ->{
            addButton.setScaleX(1.0);
            addButton.setScaleY(1.0);
            addButton.setStyle(addButton.getStyle().replace(CPrimaryHov, CPrimary));
        });

        // DISPLAY BUTTON INTERACTIONS
        displayButton.setOnMouseEntered(e -> {
            displayButton.setScaleX(1.1);
            displayButton.setScaleY(1.1);
            displayButton.setStyle(displayButton.getStyle().replace(CPrimary, CPrimaryHov));
        });
        displayButton.setOnMouseExited(e ->{
            displayButton.setScaleX(1.0);
            displayButton.setScaleY(1.0);
            displayButton.setStyle(displayButton.getStyle().replace(CPrimaryHov, CPrimary));
        });

        // CLEAR BUTTON INTERACTIONS
        clearButton.setOnMouseEntered(e -> {
            clearButton.setScaleX(1.1);
            clearButton.setScaleY(1.1);
            clearButton.setStyle(clearButton.getStyle().replace(CPrimary, CPrimaryHov));
        });
        clearButton.setOnMouseExited(e ->{
            clearButton.setScaleX(1.0);
            clearButton.setScaleY(1.0);
            clearButton.setStyle(clearButton.getStyle().replace(CPrimaryHov, CPrimary));
        });

        // BUTTON UI
        addButton.setStyle("-fx-background-color:" + CPrimary + "; -fx-text-fill:white; -fx-font-weight:600; -fx-background-radius:12; -fx-padding:8 14;");
        clearButton.setStyle("-fx-background-color:" + CPrimary + "; -fx-text-fill:white; -fx-font-weight:600; -fx-background-radius:12; -fx-padding:8 14;");
        displayButton.setStyle("-fx-background-color:" + CPrimary + "; -fx-text-fill:white; -fx-font-weight:600; -fx-background-radius:12; -fx-padding:8 14;");

        // GRIDPANE STRUCTURE
        gridPane.add(nameLabel,  0, 0);
        gridPane.add(nameField,  1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(phoneLabel, 0, 2);
        gridPane.add(phoneField, 1, 2);

        // STATUS POPUPS
        gridPane.add(errorLabel, 0, 3, 2, 1);
        gridPane.add(successLabel, 0, 3, 2, 1);
        GridPane.setHalignment(errorLabel, HPos.CENTER);
        GridPane.setHalignment(successLabel, HPos.CENTER);

        // BUTTON BOX SETTINGS
        buttonBox.setPadding(new Insets(-150, 0, 0, 0));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(addButton, clearButton, displayButton);

        VBox.setMargin(titleLabel, new Insets(0, 0, 20, 0));

        errorLabel.setVisible(false);
        successLabel.setVisible(false);

        mainBox.getChildren().addAll(titleLabel, card, buttonBox);

        return mainBox;
    }

    private Region contactsPage() {
        contactBox.setAlignment(Pos.CENTER);

        for (String contact : contacts) {
            Label label = new Label(contact);
            contactBox.getChildren().add(label);
        }

        ScrollPane scrollPane = new ScrollPane(contactBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(220);
     //   scrollPane.setStyle("-fx-background: transparent;" + "-fx-background-color: transparent;");

        return scrollPane;
    }

    private void addContact() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        if (testPhone(phone) && testEmail(email) && testBlank(name) && testBlank(phone) && testBlank(email)) {
            String contact = name + " " + email + " " + phone;
            contacts.add(contact);
            errorLabel.setVisible(false);
            successLabel.setVisible(true);
        } else {
            errorLabel.setVisible(true);
            successLabel.setVisible(false);
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");

        nameField.requestFocus();
    }

    private void displayContacts() {
        Region contactPage = contactsPage();

//        if (mainBox.getChildren().size() > 2) {
//            mainBox.getChildren().remove(2);
//        }

        for (int i = 0; i < contacts.size(); i++) {
            Label label = new Label(contacts.get(i));
            label.setTextFill(Color.web(CText));
//        label.setTextFill(Color.color(1, 0, 0));
            contactBox.getChildren().add(label);
        }
        mainBox.getChildren().add(contactPage);
    }

    private boolean testPhone(String phoneString) {
        try {
            int phoneInt = Integer.parseInt(phoneString);
        } catch (NumberFormatException error) {
            return false;
        }
        return true;
    }

    private boolean testEmail(String emailString) {
        if (emailString.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean testBlank(String s) {
        if (s.length() == 0) {
            return false;
        }
        return true;
    }

    private void onClearClick(ActionEvent e) {
        clearFields();
    }
}