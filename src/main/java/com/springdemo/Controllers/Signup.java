package com.springdemo.Controllers;

import com.springdemo.oop_projekat.Database;
import com.springdemo.oop_projekat.HelloApplication;
import com.springdemo.oop_projekat.Klijent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Signup {
    @FXML
    private TextField signupUsername;
    @FXML
    private TextField signupJMBG;
    @FXML
    private TextField signupAccountNumber;
    @FXML
    private TextField signupName;
    @FXML
    private TextField signupSurname;
    @FXML
    private TextField signupPhoneNumber;
    @FXML
    private PasswordField signupPassword;
    @FXML
    private PasswordField signupConfirmPassword;
    @FXML
    private RadioButton showPassword;
    private int id = 3;
    @FXML
    private Label accountExistsLabel;
    @FXML
    private Label signupNameLabel;
    @FXML
    private Label signupSurnameLabel;
    @FXML
    private Label signupPhoneNumberLabel;
    @FXML
    private Label signupJMBGLabel;
    @FXML
    private Label signupAccountNumberLabel;
    @FXML
    private Label signupUsernameLabel;
    @FXML
    private Label signupPasswordLabel;
    @FXML
    private Label signupConfirmPasswordLabel;

    @FXML

    public void back() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = HelloApplication.stage;
        stage.setOpacity(1);
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    protected void vratiNaPrvuScenu() throws IOException {
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        String name = signupName.getText();
        String surname = signupSurname.getText();
        String phoneNumber = signupPhoneNumber.getText();
        String jmbg = signupJMBG.getText();
        String accountNumber = signupAccountNumber.getText();
        String username = signupUsername.getText();
        String password = signupPassword.getText();
        String confirmPassword = signupConfirmPassword.getText();
        boolean isCorrect = true;
        if(name.isEmpty()){
            isCorrect = false;
            signupNameLabel.setText("Enter a name!");
            signupNameLabel.setStyle("-fx-text-fill: red");
            signupName.setStyle("-fx-border-color: red");

        }else {
            isCorrect = true;
            signupName.setStyle("-fx-border-color: none");
            signupNameLabel.setVisible(false);
        }

        if(surname.isEmpty()){
            isCorrect = false;
            signupSurnameLabel.setText("Enter a surname!");
            signupSurnameLabel.setStyle("-fx-text-fill: red");
            signupSurname.setStyle("-fx-border-color: red");

        }else{
            isCorrect = true;
            signupSurnameLabel.setVisible(false);
            signupSurname.setStyle("-fx-border-color: none");
        }

        if(phoneNumber.isEmpty()){
            isCorrect = false;
            signupPhoneNumberLabel.setText("Enter a phone number!");
            signupPhoneNumberLabel.setStyle("-fx-text-fill: red");
            signupPhoneNumber.setStyle("-fx-border-color: red");
        }else{
            isCorrect = true;
            signupPhoneNumberLabel.setVisible(false);
            signupPhoneNumber.setStyle("-fx-border-color: none");
        }

        if(jmbg.isEmpty()){
            isCorrect = false;
            signupJMBGLabel.setText("Enter a SSN!");
            signupJMBGLabel.setStyle("-fx-text-fill: red");
            signupJMBG.setStyle("-fx-border-color: red");
        }else{
            isCorrect = true;
            signupJMBGLabel.setVisible(false);
            signupJMBG.setStyle("-fx-border-color: none");
        }
        if(accountNumber.isEmpty()){
            isCorrect = false;
            signupAccountNumberLabel.setText("Enter an account number!");
            signupAccountNumberLabel.setStyle("-fx-text-fill: red");
            signupAccountNumber.setStyle("-fx-border-color: red");
        }else{
            isCorrect = true;
            signupAccountNumberLabel.setVisible(false);
            signupAccountNumber.setStyle("-fx-border-color: none");
        }

        if(username.isEmpty()){
            isCorrect = false;
            signupUsernameLabel.setText("Enter a username!");
            signupUsernameLabel.setStyle("-fx-text-fill: red");
            signupUsername.setStyle("-fx-border-color: red");
        }else{
            isCorrect = true;
            signupUsernameLabel.setVisible(false);
            signupUsername.setStyle("-fx-border-color: none");
        }

        if(password.isEmpty()){
            isCorrect = false;
            signupPasswordLabel.setText("Enter a password!");
            signupPasswordLabel.setStyle("-fx-text-fill: red");
            signupPassword.setStyle("-fx-border-color: red");
        }else{
            isCorrect = true;
            signupPasswordLabel.setVisible(false);
            signupPassword.setStyle("-fx-border-color: none");
        }

        if(confirmPassword.isEmpty()){
            isCorrect = false;
            signupConfirmPasswordLabel.setText("Enter a password!");
            signupConfirmPasswordLabel.setStyle("-fx-text-fill: red");
            signupConfirmPassword.setStyle("-fx-border-color: red");
        }else{
            isCorrect = true;
            signupConfirmPasswordLabel.setVisible(false);
            signupConfirmPassword.setStyle("-fx-border-color: none");
        }

        if(isCorrect){
            try {
                int bankAccountId = Database.getBankovniRacunId(jmbg, accountNumber);
                if(password.equals(confirmPassword)){
                    if (bankAccountId != -1 ){
                        Database.dodajKlijenta(bankAccountId, name, surname, phoneNumber, jmbg, accountNumber, username, password);
                        signupName.clear();
                        signupSurname.clear();
                        signupPhoneNumber.clear();
                        signupJMBG.clear();
                        signupAccountNumber.clear();
                        signupUsername.clear();
                        signupPassword.clear();
                        signupConfirmPassword.clear();
                        accountExistsLabel.setText("Account added successfully!");
                        accountExistsLabel.setStyle("-fx-text-fill: green");

                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/yourcompanyname/yourapplicationname/layouts/nameOfYourFxmlFile.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = HelloApplication.stage;
                        stage.setOpacity(1);
                        stage.setTitle("Sign Up Form");
                        stage.setScene(new Scene(root, 600, 400));
                        stage.show();

                    }else{
                        accountExistsLabel.setText("Account is either taken or doesn't exist!");
                        accountExistsLabel.setStyle("-fx-text-fill: red");

                    }
                } else {


                    signupConfirmPasswordLabel.setStyle("-fx-text-fill: red");
                    signupConfirmPassword.setStyle("-fx-border-color: red");
                    signupConfirmPasswordLabel.setText("Passwords don't match!");
                    signupConfirmPasswordLabel.setVisible(true);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
