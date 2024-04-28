package com.springdemo.Controllers;

import com.springdemo.oop_projekat.Admin;
import com.springdemo.oop_projekat.Database;
import com.springdemo.oop_projekat.HelloApplication;
import com.springdemo.oop_projekat.Klijent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



public class Login {
    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextField usernameLogin;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private Label accountExistsLabel;

    public void close(){
        System.exit(0);
    }


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

    @FXML
    protected void login() throws IOException, SQLException {
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
                stage.setScene(new Scene(root, 1500, 700));
                stage.show();

                KlijentScena klijentScenaController = fxmlLoader.getController();
                klijentScenaController.setUsername(username);
                klijentScenaController.setNameSurname();
            } else if (userType.equals("Admin")) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin_scena.fxml"));
                //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/yourcompanyname/yourapplicationname/layouts/nameOfYourFxmlFile.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = HelloApplication.stage;
                stage.setOpacity(1);
                stage.setTitle("Sign Up Form");
                stage.setScene(new Scene(root, 1300, 600));
                stage.show();

                AdminScena adminScenaController = fxmlLoader.getController();
                adminScenaController.setUsername(username);
                adminScenaController.setNameSurname();
                adminScenaController.cards();
                adminScenaController.searchAdmin();
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

}
