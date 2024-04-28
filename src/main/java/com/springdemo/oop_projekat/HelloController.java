package com.springdemo.oop_projekat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import javafx.scene.control.PasswordField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;

public class HelloController {

    // Method to set the ArrayList (optional)

    @FXML
    private TextField usernameLogin;
    @FXML
    private PasswordField passwordLogin;
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
    private Label clientUsername;
    @FXML
    private Label clientName;
    @FXML
    private Label clientSurname;


    @FXML
    protected void drugi_prozor() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup_forma.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/yourcompanyname/yourapplicationname/layouts/nameOfYourFxmlFile.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = HelloApplication.stage;
        stage.setOpacity(1);
        stage.setTitle("Sign Up Form");
        stage.setScene(new Scene(root, 700, 700));
        stage.show();

    }

    //registracija (kreiranje novog naloga)
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

    // scena za ulogovanje
    @FXML
    protected void login() throws IOException {
        String username = usernameLogin.getText();
        String password = passwordLogin.getText();
        System.out.println(username + " " + password);
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        ArrayList<Admin> admini = Database.getAdmin();
            String userType = authenticateUser(username, password);

            if (userType != null) {
                if (userType.equals("Klijent")) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("klijent_scena.fxml"));
                    //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/yourcompanyname/yourapplicationname/layouts/nameOfYourFxmlFile.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = HelloApplication.stage;
                    stage.setOpacity(1);
                    stage.setTitle("Sign Up Form");
                    stage.setScene(new Scene(root, 1100, 700));
                    stage.show();


                } else if (userType.equals("Admin")) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin_scena.fxml"));
                    //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/yourcompanyname/yourapplicationname/layouts/nameOfYourFxmlFile.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = HelloApplication.stage;
                    stage.setOpacity(1);
                    stage.setTitle("Sign Up Form");
                    stage.setScene(new Scene(root, 650, 700));
                    stage.show();

                }
            } else {
                accountExistsLabel.setText("The account doesn't exist!");
                accountExistsLabel.setStyle("-fx-prompt-text-fill: red");
                usernameLogin.setStyle("-fx-border-color: red");
                passwordLogin.setStyle("-fx-border-color: red");
            }
    }

    //provjera da li se uloguje kao klijent ili admin
    @FXML
    private String authenticateUser(String username, String password) {
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        ArrayList<Admin> admini = Database.getAdmin();

        for (Klijent klijent : klijenti) {
            if (username.equals(klijent.getKorisnicko_ime()) && password.equals(klijent.getLozinka())) {
                return "Klijent";
            }
        }

        for (Admin admin : admini) {
            if (username.equals(admin.getKorisnicko_ime()) && password.equals(admin.getLozinka())) {
                return "Admin";
            }
        }

        return null;
    }


    @FXML
    protected void naslovna() throws IOException{
        System.out.println("HelloWorld");
    }

}