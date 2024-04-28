package com.springdemo.Controllers;
import com.springdemo.oop_projekat.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.springdemo.oop_projekat.Database.*;

public class AdminScena {
    @FXML
    private Label number_of_admins;
    @FXML
    private Label earned_money;
    @FXML
    private Label number_of_clients;
    @FXML
    private Button add_admin_button;
    @FXML
    private Button home_button;
    @FXML
    private Button add_destination_button;
    @FXML
    private Button see_all_destinations_button;
    @FXML
    private Button cancelled_destinations_button;
    @FXML
    private Button logoutButton;
    @FXML
    private Button add_admin;

    @FXML
    private Button add_destination;

    @FXML
    private AnchorPane add_destination_frame;

    @FXML
    private Button add_excursion;

    @FXML
    private AnchorPane admin_frame;

    @FXML
    private TableView<Admin> admin_table;
    @FXML
    private TableColumn<Admin, Integer> admin_frame_id;

    @FXML
    private TableColumn<Admin, String> admin_frame_name;

    @FXML
    private TableColumn<Admin, String> admin_frame_password;

    @FXML
    private TextField admin_frame_search;

    @FXML
    private TableColumn<Admin, String> admin_frame_surname;

    @FXML
    private TableColumn<Admin, String> admin_frame_username;

    @FXML
    private Button clear_admin;

    @FXML
    private Button clear_destination;

    @FXML
    private Button clear_excursion;

    @FXML
    private Button delete_admin;

    @FXML
    private TextField destination_accommodation;

    @FXML
    private DatePicker destination_departure;

    @FXML
    private TextField destination_destination;

    @FXML
    private AnchorPane destination_frame;

    @FXML
    private AnchorPane all_destinations_frame;

    @FXML
    private TextField destination_name;

    @FXML
    private TextField destination_package;

    @FXML
    private TextField destination_price;

    @FXML
    private TextField destination_rating;

    @FXML
    private DatePicker destination_return;

    @FXML
    private TextField destination_room;

    @FXML
    private TextField destination_transportation;

    @FXML
    private TextField enter_admin_name;

    @FXML
    private TextField enter_admin_surname;

    @FXML
    private TextField enter_admin_username;

    @FXML
    private DatePicker enter_excursion_departure;

    @FXML
    private TextField enter_excursion_destination;

    @FXML
    private TextField enter_excursion_name;

    @FXML
    private TextField enter_excursion_price;

    @FXML
    private AnchorPane excursion_frame;

    @FXML
    private AnchorPane home_earned_money;

    @FXML
    private AnchorPane home_frame;

    @FXML
    private AnchorPane main_frame;

    @FXML
    private AnchorPane home_total_admins;

    @FXML
    private AnchorPane home_total_clients;

    @FXML
    private Button update_admin;

    @FXML
    private Button update_destination;

    @FXML
    private Button update_excursion;
    @FXML
    private Label username;
    @FXML
    private Label name_surname;
    @FXML
    private TableView<Aranzman> destination_table;
    @FXML
    private TableColumn<Aranzman, String> d_table_name;
    @FXML
    private TableColumn<Aranzman, Integer> d_table_id;
    @FXML
    private TableColumn<Aranzman, String> d_table_destination;
    @FXML
    private TableColumn<Aranzman, String> d_table_transportation;
    @FXML
    private TableColumn<Aranzman, LocalDate> d_table_departure;
    @FXML
    private TableColumn<Aranzman, LocalDate> d_table_return;
    @FXML
    private TableColumn<Aranzman, String> d_table_package_price;
    @FXML
    private TableColumn<Aranzman, String> d_table_rating;
    @FXML
    private TableColumn<Aranzman, String> d_table_room;
    @FXML
    private TableColumn<Aranzman, Float> d_table_price_per_night;
    @FXML
    private TableColumn<Aranzman,Integer> d_table_accommodation_id;
    @FXML
    private TextField enter_excursion_transportation;
    @FXML
    private AnchorPane cancelled_destinations_frame;
    @FXML
    private Button cancel_destination;
    @FXML
    private Button add_destination_back;
    @FXML
    private TableView<Aranzman> cancelled_table;
    @FXML
    private TableColumn<Aranzman, Integer> c_table_id;
    @FXML
    private TableColumn<Aranzman, String> c_table_name;
    @FXML
    private TableColumn<Aranzman, String> c_table_destination;
    @FXML
    private TableColumn<Aranzman, String> c_table_transportation;
    @FXML
    private TableColumn<Aranzman, LocalDate> c_table_departure;
    @FXML
    private TableColumn<Aranzman, LocalDate> c_table_return;
    @FXML
    private TableColumn<Aranzman, String> c_table_package_price;
    @FXML
    private TableColumn<Aranzman, Integer> c_table_accommodation_id;
    @FXML
    private TextField change_admin_password;
    @FXML
    private Button change_password;
    @FXML
    private TableView <Klijent> bookedClients;
    @FXML
    private TableColumn<Klijent,Integer> client_id;
    @FXML
    private TableColumn <Klijent, String> client_name;
    @FXML
    private TableColumn <Klijent, String> client_surname;
    @FXML
    private TableView<Rezervacija> balance_table;
    @FXML
    private TableColumn<Rezervacija,Float> balance;



    public void close() {
        System.exit(0);
    }

    public void setUsername(String usernameLogin) {
        username.setText(usernameLogin);
    }

    public void setNameSurname() throws IOException {
        ArrayList<Admin> admini = Database.getAdmin();

        for (Admin admin : admini) {
            if (username.getText().equals(admin.getKorisnicko_ime())) {
                name_surname.setText(admin.getIme() + " " + admin.getPrezime());
            }
        }


    }

    public void logout() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = HelloApplication.stage;
                stage.setOpacity(1);
                stage.setTitle("Login");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void switchForm(ActionEvent event) throws IOException {
        if (event.getSource() == home_button) {
            home_frame.setVisible(true);
            admin_frame.setVisible(false);
            add_destination_frame.setVisible(false);
            all_destinations_frame.setVisible(false);
            main_frame.setVisible(false);
            cancelled_destinations_frame.setVisible(false);
        } else if (event.getSource() == add_admin_button) {
            home_frame.setVisible(false);
            admin_frame.setVisible(true);
            add_destination_frame.setVisible(false);
            all_destinations_frame.setVisible(false);
            main_frame.setVisible(false);
            cancelled_destinations_frame.setVisible(false);

        } else if (event.getSource() == add_destination_button) {
            home_frame.setVisible(false);
            admin_frame.setVisible(false);
            add_destination_frame.setVisible(true);
            all_destinations_frame.setVisible(false);
            main_frame.setVisible(false);
            cancelled_destinations_frame.setVisible(false);
        } else if (event.getSource() == see_all_destinations_button) {
            home_frame.setVisible(false);
            admin_frame.setVisible(false);
            add_destination_frame.setVisible(false);
            all_destinations_frame.setVisible(true);
            main_frame.setVisible(false);
            cancelled_destinations_frame.setVisible(false);
            showDestinations();
        }else if(event.getSource() == cancelled_destinations_button){
            home_frame.setVisible(false);
            admin_frame.setVisible(false);
            add_destination_frame.setVisible(false);
            all_destinations_frame.setVisible(false);
            main_frame.setVisible(false);
            cancelled_destinations_frame.setVisible(true);
            showCancelledDestinations();
        }
    }

    public void initialize() {
        ArrayList<Admin> admini = Database.getAdmin();

        // ADMIN OBSERVABLE LIST
        ObservableList<Admin> observableAdminList = FXCollections.observableArrayList(admini);
        admin_table.setItems(observableAdminList);
        admin_frame_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        admin_frame_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIme()));
        admin_frame_surname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrezime()));
        admin_frame_username.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKorisnicko_ime()));





    }

    @FXML
    private void deleteAdmin(ActionEvent event) {
        Admin selectedAdmin = admin_table.getSelectionModel().getSelectedItem();
        if (selectedAdmin != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Delete Admin");
            alert.setContentText("Are you sure you want to delete this admin?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                admin_table.getItems().remove(selectedAdmin);
                Database.izbrisiAdmina(selectedAdmin);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select an admin to delete.");
            alert.showAndWait();
        }
    }


    @FXML
    private void addAdmin() {
        ArrayList<Admin> adminList = Database.getAdmin();

        // Convert ArrayList to ObservableList
        ObservableList<Admin> observableAdminList = FXCollections.observableArrayList(adminList);
        String name = enter_admin_name.getText();
        String surname = enter_admin_surname.getText();
        String username = enter_admin_username.getText();
        String password = "12345678";

        int id = Integer.parseInt(generateNextID());

        Admin newAdmin = new Admin(id, name, surname, username, password);

        observableAdminList.add(newAdmin);

        admin_table.setItems(observableAdminList);
        Database.dodajAdmina(id, name, surname, username, password);
        enter_admin_name.clear();
        enter_admin_surname.clear();
        enter_admin_username.clear();
    }

    private String generateNextID() {
        ArrayList<Admin> adminList = Database.getAdmin();
        ObservableList<Admin> observableAdminList = FXCollections.observableArrayList(adminList);
        int maxID = 0;
        for (Admin admin : observableAdminList) {
            int id = admin.getId();
            if (id > maxID) {
                maxID = id;
            }
        }
        return String.valueOf(maxID + 1);
    }


    @FXML
    private void clear() {
        enter_admin_username.clear();
        enter_admin_name.clear();
        enter_admin_surname.clear();
    }

    @FXML
    public void cards() throws IOException {
        ArrayList<Admin> admini = Database.getAdmin();
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        ArrayList<BankovniRacun> bankovniRacuni = Database.getBankovniRacuni();
        int adminCounter = 0;
        int clientCounter = 0;
        float money = 0;
        for (Admin admin : admini) {
            adminCounter++;
        }
        for (Klijent klijent : klijenti) {
            clientCounter++;
        }
        for(BankovniRacun bankovniRacun: bankovniRacuni){
            if(bankovniRacun.getBroj_racuna().equals("1234567887654321")){
                money = bankovniRacun.getStanje();
            }
        }

        number_of_admins.setText(String.valueOf(adminCounter));
        number_of_clients.setText(String.valueOf(clientCounter));
        earned_money.setText(String.valueOf(money));
    }

    @FXML
    public void updateAdmin() throws IOException {
        update_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    cards();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @FXML
    public void searchAdmin() throws IOException {
        ArrayList<Admin> admini = Database.getAdmin();
        ObservableList<Admin> observableAdminList = FXCollections.observableArrayList(admini);
        admin_table.setItems(observableAdminList);
        FilteredList<Admin> filteredData = new FilteredList<>(observableAdminList, p -> true);

        admin_table.setItems(filteredData);

        admin_frame_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(admin -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (admin.getIme().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (admin.getPrezime().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (admin.getKorisnicko_ime().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });
        });
    }


    //jednodnevni izlet
    @FXML
    public void addExcursion() throws IOException, SQLException {
        String name = enter_excursion_name.getText();
        String destination = enter_excursion_destination.getText();
        String transportation = enter_excursion_transportation.getText();
        LocalDate departure = enter_excursion_departure.getValue();
        LocalDate returnDate = enter_excursion_departure.getValue();
        String price = enter_excursion_price.getText();

        int nextAvailableExcursionId = Database.getAranzmanId();
        System.out.println(nextAvailableExcursionId);
        Database.dodajEkskurziju(nextAvailableExcursionId,name, destination, transportation, departure,returnDate,price);

        clearExcursion();
        refreshDestinations();
        showDestinations();

    }



    @FXML
    public void addDestination() throws IOException, SQLException {

        String name = destination_name.getText().trim();
        String destination = destination_destination.getText().trim();
        String transport = destination_transportation.getText().trim();
        LocalDate departure = destination_departure.getValue();
        LocalDate return_date = destination_return.getValue();
        String price = destination_package.getText().trim();

        String accommodation = destination_accommodation.getText().trim();
        String rating = destination_rating.getText().trim();
        int star_rating = Integer.parseInt(rating);
        String room = destination_room.getText().trim();
        String price_text = destination_price.getText().trim();
        float price_per_night = Float.parseFloat(price_text);


        int nextSmjestajId = getSmjestajId();
        int nextAranzmanId = getAranzmanId();
        Smjestaj smjestaj = new Smjestaj(nextSmjestajId, accommodation, star_rating, room, price_per_night);

        Database.dodajSmjestaj(nextSmjestajId, accommodation, star_rating, room, price_per_night);
        Database.dodajAranzman(nextAranzmanId, name, destination, transport, departure, return_date, price, nextSmjestajId);

        clearDestination();
        refreshDestinations();
        showDestinations();
        destination_table.refresh();

    }

    @FXML
    public void refreshDestinations() {
        //active_destinations.clear();
        //displayDestinations();
    }



    @FXML
    private void clearDestination(){
        destination_name.clear();
        destination_destination.clear();
        destination_transportation.clear();
        destination_price.clear();
        destination_package.clear();
        destination_rating.clear();
        destination_accommodation.clear();
        destination_room.clear();
        destination_departure.setValue(null);
        destination_return.setValue(null);
    }

    @FXML
    private void clearExcursion(){
        enter_excursion_price.clear();
        enter_excursion_departure.setValue(null);
        enter_excursion_destination.clear();
        enter_excursion_name.clear();
        enter_excursion_transportation.clear();
    }


    public void showDestinations() throws IOException{
        ArrayList<Aranzman> aranzmani = Database.getPositiveAranzman();

        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(aranzmani);
        destination_table.setItems(observableAranzmanList);
        d_table_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        d_table_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaziv_putovanja()));
        d_table_destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinacija()));
        d_table_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        d_table_departure.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        d_table_return.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        d_table_package_price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCijena_aranzmana()));
        d_table_accommodation_id.setCellValueFactory(cellData -> {
            IntegerProperty value = new SimpleIntegerProperty(cellData.getValue().getSmjestaj());
            return value.asObject();
        });
    }

    @FXML
    public void showClients(ActionEvent event){
        bookedClients.refresh();
        balance_table.refresh();
        ArrayList<BankovniRacun> bankovniRacuni = Database.getBankovniRacuni();
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        Aranzman selectedAranzman = destination_table.getSelectionModel().getSelectedItem();
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        ArrayList<Klijent> bookedClient = new ArrayList<>();
        ArrayList<Rezervacija> payments = new ArrayList<>();

        for(Klijent klijent : klijenti){
            for(Rezervacija rezervacija: rezervacije){
                if(rezervacija.getKlijentId() == klijent.getId() && rezervacija.getAranzman() == selectedAranzman.getId() && rezervacija.getPlacenaCijena() > 0){
                    bookedClient.add(klijent);
                }
            }
        }

        for(BankovniRacun bankovniRacun: bankovniRacuni) {
            for (Klijent klijent : klijenti) {
                for (Rezervacija rezervacija : rezervacije) {
                    if (bankovniRacun.getId() == klijent.getId()) {
                        if (rezervacija.getKlijentId() == klijent.getId() && rezervacija.getAranzman() == selectedAranzman.getId() && rezervacija.getPlacenaCijena() >0) {
                            payments.add(rezervacija);
                            System.out.println(rezervacija.getPlacenaCijena());
                        }
                    }
                }
            }
        }

        ObservableList<Klijent> observableKlijentList = FXCollections.observableArrayList(bookedClient);
        ObservableList<Rezervacija> observableRezervacijaList = FXCollections.observableArrayList(payments);
        bookedClients.setItems(observableKlijentList);
        balance_table.setItems(observableRezervacijaList);
        client_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        client_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIme()));
        client_surname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrezime()));
        balance.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPlacenaCijena()).asObject());


        balance_table.refresh();

    }



    @FXML
    public void deleteDestination(ActionEvent event){
        ArrayList<Smjestaj> smjestaji = Database.getSmjestaj();
        Aranzman selectedAranzman = destination_table.getSelectionModel().getSelectedItem();
        System.out.println(selectedAranzman.getSmjestaj());
        for(Smjestaj smjestaj: smjestaji){
            if(smjestaj.getId() == selectedAranzman.getSmjestaj()){
                if (selectedAranzman != null) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Delete Destination");
                    alert.setContentText("Are you sure you want to delete this destination?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        destination_table.getItems().remove(selectedAranzman);
                        Database.izbrisiAranzman(selectedAranzman,smjestaj);
                        destination_table.refresh();
                        Database.obrisiRezervacijeZaAranzman(selectedAranzman.getId());
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select an Destination to delete.");
                    alert.showAndWait();
                }
            }
        }
        if (selectedAranzman != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Delete Excursion");
            alert.setContentText("Are you sure you want to delete this excursion?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                destination_table.getItems().remove(selectedAranzman);
                Database.izbrisiEkskurziju(selectedAranzman);
                destination_table.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select an Excursion to delete.");
            alert.showAndWait();
        }

    }



    @FXML
    public void cancelDestination(ActionEvent event) throws IOException, SQLException {
        Aranzman selectedAranzman = destination_table.getSelectionModel().getSelectedItem();
        //System.out.println(selectedAranzman);
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        if (selectedAranzman != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Cancel Destination");
            alert.setContentText("Are you sure you want to cancel this destination?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                int nextNegativeId = Database.getNextAvailableNegativeAranzmanId();
                float cijena_aranzmana = Float.parseFloat(selectedAranzman.getCijena_aranzmana());
                for(Rezervacija rezervacija: rezervacije){
                    for(Klijent klijent: klijenti){
                        if(rezervacija.getKlijentId() == klijent.getId() && rezervacija.getAranzman() == selectedAranzman.getId()){
                                float vrati_klijentu = rezervacija.getUkupnaCijena() * 0.5f;
                                System.out.println(vrati_klijentu + " se vraca klijentu ");
                                Database.uplata("1234567887654321", klijent.getBroj_racuna(),vrati_klijentu);
                                System.out.println(nextNegativeId);
                                Database.obrisiRezervacijeZaAranzman(selectedAranzman.getId());
                                Database.promijeniIdAranzmana(selectedAranzman.getId(), nextNegativeId);
                                destination_table.getItems().remove(selectedAranzman);
                                destination_table.refresh();
                                balance_table.refresh();
                                bookedClients.refresh();
                                cards();
                        }else if(rezervacija.getUkupnaCijena() > rezervacija.getPlacenaCijena()){
                                Database.promijeniPlacenuCijenu(klijent.getId(),selectedAranzman.getId(),0);
                                Database.azurirajPlacenuCijenu(klijent.getId(),selectedAranzman.getId(),0);
                                System.out.println(nextNegativeId);
                                Database.obrisiRezervacijeZaAranzman(selectedAranzman.getId());
                                Database.promijeniIdAranzmana(selectedAranzman.getId(), nextNegativeId);
                                destination_table.getItems().remove(selectedAranzman);
                                destination_table.refresh();
                                balance_table.refresh();
                                bookedClients.refresh();
                                cards();
                        }
                    }
                }
            }
        }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select a destination to cancel.");
                alert.showAndWait();

        }
    }





    @FXML
    public void showCancelledDestinations(){

        ArrayList<Aranzman> cancelledDestinations = Database.getNegativeAranzman();
        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(cancelledDestinations);
        cancelled_table.setItems(observableAranzmanList);

        c_table_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        c_table_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaziv_putovanja()));
        c_table_destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinacija()));
        c_table_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        c_table_departure.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        c_table_return.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        c_table_package_price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCijena_aranzmana()));
        c_table_accommodation_id.setCellValueFactory(cellData -> {
            IntegerProperty value = new SimpleIntegerProperty(cellData.getValue().getSmjestaj());
            return value.asObject();
        });

        cancelled_table.refresh();
    }


    @FXML
    public void addDestinationBack() throws SQLException {
        Aranzman selectedAranzman = cancelled_table.getSelectionModel().getSelectedItem();
        if (selectedAranzman != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Add Destination");
            alert.setContentText("Are you sure you want to add this destination?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                int nextPositive= Database.getAranzmanId();
                System.out.println(nextPositive);
                Database.promijeniIdAranzmana(selectedAranzman.getId(), nextPositive);
                destination_table.getItems().add(selectedAranzman);
                destination_table.refresh();
                cancelled_table.getItems().remove(selectedAranzman);
                cancelled_table.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a destination to add.");
            alert.showAndWait();
        }

    }

    @FXML
    public void changeAdminPassword(){
        Admin selectedAdmin = admin_table.getSelectionModel().getSelectedItem();
        String new_password = change_admin_password.getText();
        Database.promijeniAdminuSifru(selectedAdmin.getLozinka(),new_password);

        change_admin_password.clear();
        admin_table.refresh();
        initialize();
    }

    public static void filterUnpaidArrangements(){
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        ArrayList<Aranzman> aranzmani = Database.getPositiveAranzman();

        for(Aranzman aranzman: aranzmani){
            for(Rezervacija rezervacija: rezervacije){
                if(aranzman.getId() == rezervacija.getAranzman()){
                    if(rezervacija.getPlacenaCijena() < rezervacija.getUkupnaCijena()){
                        LocalDate currentDate = LocalDate.now();
                        LocalDate departureDate = aranzman.getDatum_polaska();
                        long daysUntilDeparture = ChronoUnit.DAYS.between(currentDate, departureDate);
                        if(daysUntilDeparture < 14){
                            Database.promijeniPlacenuCijenu(rezervacija.getKlijentId(),aranzman.getId(),0.0);
                            System.out.println("Klijentu je istekla rezervacija!");
                            System.out.println(rezervacija);
                        }
                    }
                }

            }
        }

    }



}
