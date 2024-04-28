package com.springdemo.Controllers;
import com.springdemo.oop_projekat.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CancellationException;
import java.time.temporal.ChronoUnit;


import static com.springdemo.oop_projekat.Database.*;

public class KlijentScena {
    @FXML
    private Button client_destinations_button;
    @FXML
    private Label client_username;
    @FXML
    private Label client_NameSurname;

    @FXML
    private Button reserve;
    @FXML
    private AnchorPane all_destinations_frame;
    @FXML
    private TableView <Aranzman> client_destinations_table;
    @FXML
    private TableColumn <Aranzman, Integer> cdt_id;
    @FXML
    private TableColumn<Aranzman, String> cdt_name;
    @FXML
    private TableColumn<Aranzman, String> cdt_destination;
    @FXML
    private TableColumn<Aranzman, String> cdt_transportation;
    @FXML
    private TableColumn<Aranzman, LocalDate> cdt_departure;
    @FXML
    private TableColumn<Aranzman, LocalDate> cdt_return;
    @FXML
    private TableColumn<Aranzman, String> cdt_package_price;
    @FXML
    private TableView<Smjestaj> accommodation_table;
    @FXML
    private TableColumn<Smjestaj, String> at_accommodation_name;
    @FXML
    private TableColumn<Smjestaj, String> at_room;
    @FXML
    private TableColumn<Smjestaj,Float> at_price_per_night;
    @FXML
    private TableColumn<Smjestaj, Integer> at_rating;
    @FXML
    private AnchorPane first_destination;
    @FXML
    private AnchorPane second_destination;
    @FXML
    private Label name_one;
    @FXML
    private Label name_two;
    @FXML
    private AnchorPane client_home;
    @FXML
    private Button client_home_button;
    @FXML
    private Label client_balance_label;
    @FXML
    private TextField client_password_confirmation;
    @FXML
    private AnchorPane reserved_frame;
    @FXML
    private Button reserved_button;
    @FXML
    private TableView<Aranzman> booked_destinations_table;
    @FXML
    private TableColumn<Aranzman, String> bt_name;
    @FXML
    private TableColumn<Aranzman, String> bt_destination;
    @FXML
    private TableColumn<Aranzman, String> bt_transportation;
    @FXML
    private TableColumn<Aranzman, LocalDate> bt_departure;
    @FXML
    private TableColumn<Aranzman, LocalDate> bt_return;
    @FXML
    private TableColumn<Aranzman,String> bt_package_price;
    @FXML
    private TableColumn<Aranzman,Integer> bt_accommodation_id;
    @FXML
    private TableView<Aranzman> cancelled_destinations_table;
    @FXML
    private TableColumn<Aranzman, Integer> ct_accommodation_id;

    @FXML
    private TableColumn<Aranzman, LocalDate> ct_departure;

    @FXML
    private TableColumn<Aranzman, String> ct_destination;

    @FXML
    private TableColumn<Aranzman, String> ct_name;

    @FXML
    private TableColumn<Aranzman, String> ct_package_price;

    @FXML
    private TableColumn<Aranzman, LocalDate> ct_return;

    @FXML
    private TableColumn<Aranzman, String> ct_transportation;
    @FXML
    private AnchorPane cancelled_frame;
    @FXML
    private Button cancelled_button;
    @FXML
    private DatePicker departure_sort;

    @FXML
    private TextField destination_sort;

    @FXML
    private TextField money_sort;

    @FXML
    private TextField rating_sort;
    @FXML
    private TextField transportation_sort;
    @FXML
    private DatePicker return_sort;
    @FXML
    private TextField room_sort;
    @FXML
    private Label client_spent_money;
    @FXML
    private Label client_debt;
    @FXML
    private Label cancel_message;
    @FXML
    private AnchorPane welcome_frame;
    @FXML
    private TableView<Smjestaj> previous_accommodation;

    @FXML
    private TableView<Aranzman> previous_table;

    @FXML
    private TableColumn<Aranzman, LocalDate> pt_departure;

    @FXML
    private TableColumn<Aranzman, String> pt_destination;

    @FXML
    private TableColumn<Aranzman, Integer> pt_id;

    @FXML
    private TableColumn<Aranzman, String> pt_name;

    @FXML
    private TableColumn<Aranzman,String> pt_package_price;

    @FXML
    private TableColumn<Aranzman, LocalDate> pt_return;


    @FXML
    private TableColumn<Aranzman, String> pt_transportation;
    @FXML
    private Button previous_button;
    @FXML
    private AnchorPane previous_frame;
    @FXML
    private Label warning;



    private Klijent getCurrentClient() {
        String username = client_username.getText();
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        for (Klijent klijent : klijenti) {
            if (klijent.getKorisnicko_ime().equals(username)) {
                return klijent;
            }
        }
        return null;
    }


    public void close() {
        System.exit(0);
    }
    public void logout() throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType>option = alert.showAndWait();
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


    public void setUsername(String usernameLogin) {
        client_username.setText(usernameLogin);
    }
    public void setNameSurname() throws IOException {
        ArrayList<Klijent> klijenti  = Database.getKlijenti();

        for (Klijent klijent : klijenti) {
            if (client_username.getText().equals(klijent.getKorisnicko_ime())) {
                client_NameSurname.setText(klijent.getIme() + " " + klijent.getPrezime());
            }
        }


    }

    public void switchForm(ActionEvent event) throws IOException{
        if(event.getSource() == client_destinations_button){
            all_destinations_frame.setVisible(true);
            client_home.setVisible(false);
            reserved_frame.setVisible(false);
            cancelled_frame.setVisible(false);
            welcome_frame.setVisible(false);
            previous_frame.setVisible(false);

            showDestinations();
        }else if(event.getSource() == client_home_button){
            client_home.setVisible(true);
            all_destinations_frame.setVisible(false);
            reserved_frame.setVisible(false);
            cancelled_frame.setVisible(false);
            welcome_frame.setVisible(false);
            previous_frame.setVisible(false);


            showBalance();
            showSpentMoney();
            showOwedMoney();
        } else if(event.getSource() == reserved_button) {
            all_destinations_frame.setVisible(false);
            client_home.setVisible(false);
            reserved_frame.setVisible(true);
            cancelled_frame.setVisible(false);
            welcome_frame.setVisible(false);
            previous_frame.setVisible(false);


            showBookedDestinations();

            cancel_message.setVisible(false);
        }else if(event.getSource() == cancelled_button){
            all_destinations_frame.setVisible(false);
            client_home.setVisible(false);
            reserved_frame.setVisible(false);
            cancelled_frame.setVisible(true);
            welcome_frame.setVisible(false);
            previous_frame.setVisible(false);

            showCancelledDestinations();
        } else if (event.getSource() == previous_button) {
            all_destinations_frame.setVisible(false);
            client_home.setVisible(false);
            cancelled_frame.setVisible(false);
            welcome_frame.setVisible(false);
            previous_frame.setVisible(true);
            showPreviousArrangements();
        }
    }

    @FXML
    public void showBalance(){
        ArrayList<BankovniRacun> bankovniRacuni = Database.getBankovniRacuni();
        ArrayList<Klijent> klijenti = Database.getKlijenti();
        for(Klijent klijent:klijenti){
            for(BankovniRacun bankovniRacun: bankovniRacuni){
                if(klijent.getKorisnicko_ime().equals(client_username.getText())){
                    if(bankovniRacun.getBroj_racuna().equals(klijent.getBroj_racuna())){
                        client_balance_label.setText(String.valueOf(bankovniRacun.getStanje()));
                    }
                }
            }
        }

    }
    @FXML
    public void showSpentMoney(){
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        float sum_of_spent_money = 0;
        for(Rezervacija rezervacija: rezervacije){
            if(rezervacija.getKlijentId() == getCurrentClient().getId()){
                sum_of_spent_money += rezervacija.getPlacenaCijena();
                System.out.println(sum_of_spent_money);
            }client_spent_money.setText(String.valueOf(sum_of_spent_money));
        }

    }

    @FXML
    public void showOwedMoney(){
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        float owed_money = 0;
        for(Rezervacija rezervacija: rezervacije){
            if(rezervacija.getKlijentId() == getCurrentClient().getId()){
                if(rezervacija.getPlacenaCijena() < rezervacija.getUkupnaCijena() && rezervacija.getPlacenaCijena() != 0){
                    owed_money += rezervacija.getUkupnaCijena() * 0.5f;
                    System.out.println("Owed money: " + owed_money);
                }
            }
        }
        client_debt.setText(String.valueOf(owed_money));
    }
    private LocalDate getDateTwoWeeksFromNow() {
        return LocalDate.now().plusWeeks(2);
    }

    @FXML
    public void showDestinations() {
        ArrayList<Aranzman> aranzmani = Database.getPositiveAranzman();
        System.out.println("Aktivni aranzmani" + aranzmani);
        ArrayList<Aranzman> activeReservations = new ArrayList<>();
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        for (Aranzman aranzman : aranzmani) {
            boolean isReserved = false;
            for (Rezervacija rezervacija : rezervacije) {
                if (rezervacija.getAranzman() == aranzman.getId() && rezervacija.getKlijentId() == getCurrentClient().getId()) {
                    isReserved = true;
                    break;
                }
            }
            if (!isReserved) {
                LocalDate departureDate = aranzman.getDatum_polaska();
                if (departureDate.isAfter(getDateTwoWeeksFromNow()) || departureDate.isEqual(getDateTwoWeeksFromNow())) {
                    activeReservations.add(aranzman); // Add the arrangement if it's not reserved and departure date is 2 weeks or more from now
                }
            }
        }
        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(activeReservations);
        client_destinations_table.setItems(observableAranzmanList);
        cdt_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSmjestaj()).asObject());
        cdt_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaziv_putovanja()));
        cdt_destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinacija()));
        cdt_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        cdt_departure.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        cdt_return.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_dolaska());
            return property;
        });
        cdt_package_price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCijena_aranzmana()));

    }

    @FXML
    public void showMoreInfo() {
        Aranzman selectedAranzman = client_destinations_table.getSelectionModel().getSelectedItem();
        if (selectedAranzman != null) {
            ArrayList<Smjestaj> smjestaji = Database.getSmjestaj();
            ArrayList<Aranzman> aranzmani = Database.getPositiveAranzman();
            ArrayList<Smjestaj> smjestajAranzman = new ArrayList<>();
            boolean isEqual = false;
            for (Smjestaj smjestaj : smjestaji) {
                for (Aranzman aranzman : aranzmani) {
                    if (aranzman.getSmjestaj() == smjestaj.getId()) {
                        if (smjestaj.getId() == selectedAranzman.getSmjestaj()) {
                            smjestajAranzman.add(smjestaj);
                            isEqual = true;
                        }
                    }
                }
            }
            if (isEqual) {
                ObservableList<Smjestaj> observablSmjestajList = FXCollections.observableList(smjestajAranzman);
                accommodation_table.setItems(observablSmjestajList);
                at_accommodation_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaziv()));
                at_room.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVrsta_sobe()));
                at_price_per_night.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCijena_po_nocenju()).asObject());
                at_rating.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getBroj_zvjezdica()).asObject());
            }
        }
    }

    @FXML
    public void bookDestination() {
        Klijent currentClient = getCurrentClient();
        if (currentClient != null) {
            Aranzman selectedAranzman = client_destinations_table.getSelectionModel().getSelectedItem();
            if (selectedAranzman != null) {
                LocalDate currentDate = LocalDate.now();
                LocalDate departureDate = selectedAranzman.getDatum_polaska();
                long daysUntilDeparture = ChronoUnit.DAYS.between(currentDate, departureDate);
                System.out.println("Dana do putovanja ima: " + daysUntilDeparture);
                if (daysUntilDeparture <= 14) {
                    System.out.println("Putovanje je već počelo.");
                } else {
                    ArrayList<BankovniRacun> bankovniRacuni = Database.getBankovniRacuni();
                    for (BankovniRacun bankovniRacun : bankovniRacuni) {
                        if (bankovniRacun.getId() == currentClient.getId()) {
                            float package_price = Float.parseFloat(selectedAranzman.getCijena_aranzmana());
                            System.out.println("Cijena aranzmana: " + package_price);
                            if (bankovniRacun.getStanje() >= package_price && !client_password_confirmation.getText().equals(" ")) {
                                float stanje = bankovniRacun.getStanje();
                                System.out.println("Stanje klijenta:" + stanje);
                                float placena_cijena = stanje - (package_price * 0.5f);
                                System.out.println("Placena cijena je: " + package_price);
                                try {
                                    uplata(currentClient.getBroj_racuna(), "1234567887654321", package_price * 0.5f);
                                    Database.dodajRezervaciju(currentClient.getId(), selectedAranzman.getId(), package_price, package_price * 0.5f);
                                    //Database.klijentRezervacije(selectedAranzman);
                                    client_destinations_table.getItems().remove(selectedAranzman);
                                    client_password_confirmation.clear();
                                    accommodation_table.refresh();

                                    System.out.println("Rezervacija uspješno dodata.");
                                } catch (SQLException e) {
                                    System.out.println("Došlo je do greške prilikom uplate.");
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Nemate dovoljno sredstava na računu.");
                            }
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Niste izabrali destinaciju.");
            }
        } else {
            System.out.println("Nije moguće pronaći trenutnog korisnika.");
        }
        accommodation_table.refresh();
    }

    @FXML
    public void showBookedDestinations(){
        ArrayList<Aranzman> aktivniAranzmani = Database.getPositiveAranzman();
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        Aranzman selectedAranzman = client_destinations_table.getSelectionModel().getSelectedItem();
        ArrayList<Aranzman> bookedAranzman = new ArrayList<>();

        int clientId = getCurrentClient().getId();
        for(Rezervacija rezervacija: rezervacije){
            for(Aranzman aranzman: aktivniAranzmani){

                if(rezervacija.getAranzman() == aranzman.getId() && rezervacija.getKlijentId() == clientId && rezervacija.getPlacenaCijena() != 0.0 ){
                    LocalDate currentDate = LocalDate.now();
                    LocalDate departureDate = aranzman.getDatum_polaska();
                    if( departureDate.isAfter(currentDate)){
                        bookedAranzman.add(aranzman);
                    }


                }
            }
        }
        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(bookedAranzman);
        booked_destinations_table.setItems(observableAranzmanList);
        bt_name.setCellValueFactory(celLData -> new SimpleStringProperty(celLData.getValue().getNaziv_putovanja()));
        bt_destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinacija()));
        bt_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        bt_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        bt_departure.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        bt_return.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_dolaska());
            return property;
        });
        bt_package_price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCijena_aranzmana()));
        bt_accommodation_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSmjestaj()).asObject());


    }
    public ArrayList<Aranzman> cancelledDestinations = new ArrayList<>();


    @FXML
    public void cancelDestination() throws SQLException {
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        Aranzman selectedAranzman = booked_destinations_table.getSelectionModel().getSelectedItem();
        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = selectedAranzman.getDatum_polaska();
        long daysUntilDeparture = ChronoUnit.DAYS.between(currentDate, departureDate);
        System.out.println(selectedAranzman);
        if (daysUntilDeparture >= 14) {
            for (Rezervacija rezervacija : rezervacije) {
                if (rezervacija.getKlijentId() == getCurrentClient().getId() && rezervacija.getAranzman() == selectedAranzman.getId()) {
                    if (rezervacija.getPlacenaCijena() == rezervacija.getUkupnaCijena()) {
                        float refundAmount = Float.parseFloat(selectedAranzman.getCijena_aranzmana());
                        Database.uplata("1234567887654321", getCurrentClient().getBroj_racuna(), refundAmount);
                        Database.promijeniPlacenuCijenu(getCurrentClient().getId(), selectedAranzman.getId(), 0.0);

                        booked_destinations_table.getItems().remove(selectedAranzman);
                        cancelledDestinations.add(selectedAranzman);


                        System.out.println("Destination canceled successfully. Refund of " + refundAmount + " successfully processed.");
                        return; // Exit the loop once the reservation is found and canceled
                    }else if(rezervacija.getUkupnaCijena() > rezervacija.getPlacenaCijena()){
                        float refundAmount = Float.parseFloat(selectedAranzman.getCijena_aranzmana()) * 0.5f;
                        Database.uplata("1234567887654321", getCurrentClient().getBroj_racuna(), refundAmount);
                        Database.promijeniPlacenuCijenu(getCurrentClient().getId(), selectedAranzman.getId(), 0.0);
                        booked_destinations_table.getItems().remove(selectedAranzman);
                        cancelledDestinations.add(selectedAranzman);
                    }
                }
            }
            System.out.println("Resevation cancelled successfully!");
        } else {
            cancel_message.setVisible(true);
            System.out.println("Cancellation is not allowed. It must be done at least two weeks before the departure date.");
        }
    }

    @FXML
    public void showCancelledDestinations(){
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        ArrayList<Aranzman> aranzmani = Database.getAranzman();
        ArrayList<Aranzman> otkazaniAranzmani = new ArrayList<>();
        for(Rezervacija rezervacija: rezervacije){
            for(Aranzman aranzman: aranzmani){
                if(rezervacija.getKlijentId() == getCurrentClient().getId() && rezervacija.getAranzman() == aranzman.getId()){
                    if(rezervacija.getPlacenaCijena() == 0.0){
                        otkazaniAranzmani.add(aranzman);
                    }
                }
            }

        }
        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(otkazaniAranzmani);
        booked_destinations_table.refresh();
        cancelled_destinations_table.setItems(observableAranzmanList);
        ct_name.setCellValueFactory(celLData -> new SimpleStringProperty(celLData.getValue().getNaziv_putovanja()));
        ct_destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinacija()));
        ct_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        ct_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        ct_departure.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        ct_return.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_dolaska());
            return property;
        });
        ct_package_price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCijena_aranzmana()));
        ct_accommodation_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSmjestaj()).asObject());

    }

    @FXML
    public void handleSortButton(ActionEvent event) {
        float novac = money_sort.getText().isEmpty() ? Float.MAX_VALUE : Float.parseFloat(money_sort.getText());
        LocalDate prviDatum = departure_sort.getValue() == null ? LocalDate.MIN : departure_sort.getValue();
        LocalDate drugiDatum = return_sort.getValue() == null ? LocalDate.MAX : return_sort.getValue();
        String vrstaSobe = room_sort.getText();
        String destinacija = destination_sort.getText();
        String prevoz = transportation_sort.getText();
        int ocjena = rating_sort.getText().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(rating_sort.getText());

        filterDestinations(novac, prviDatum, drugiDatum, vrstaSobe, destinacija, prevoz, ocjena);
    }



    private void filterDestinations(float novac, LocalDate prviDatum, LocalDate drugiDatum, String vrstaSobe, String destinacija, String prevoz, int ocjena) {
        ArrayList<Aranzman> aranzmani = Database.getPositiveAranzman();
        ArrayList<Smjestaj> smjestaji = Database.getSmjestaj();
        ArrayList<Aranzman> filteredAranzmani = new ArrayList<>();

        for (Aranzman aranzman : aranzmani) {
            for (Smjestaj smjestaj : smjestaji) {
                if (aranzman.getSmjestaj() == smjestaj.getId()) {
                    if ((novac == Float.MAX_VALUE || Float.parseFloat(aranzman.getCijena_aranzmana()) <= novac) &&
                            (prviDatum == LocalDate.MIN || aranzman.getDatum_polaska().isAfter(prviDatum)) &&
                            (drugiDatum == LocalDate.MAX || aranzman.getDatum_polaska().isBefore(drugiDatum)) &&
                            (vrstaSobe.isEmpty() || smjestaj.getVrsta_sobe().equalsIgnoreCase(vrstaSobe)) &&
                            (destinacija.isEmpty() || aranzman.getDestinacija().equalsIgnoreCase(destinacija)) &&
                            (prevoz.isEmpty() || aranzman.getPrevoz().equalsIgnoreCase(prevoz)) &&
                            (ocjena == Integer.MAX_VALUE || smjestaj.getBroj_zvjezdica() == ocjena)) {
                        filteredAranzmani.add(aranzman);
                        break;
                    }
                }
            }
        }

        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(filteredAranzmani);
        client_destinations_table.setItems(observableAranzmanList);
    }




    @FXML
    public void bookDestinationBack() throws SQLException {
        ArrayList<BankovniRacun> bankovniRacuni = Database.getBankovniRacuni();
        Aranzman selectedAranzman = cancelled_destinations_table.getSelectionModel().getSelectedItem();
        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = selectedAranzman.getDatum_polaska();
        long daysUntilDeparture = ChronoUnit.DAYS.between(currentDate, departureDate);
        float cijena = Float.parseFloat(selectedAranzman.getCijena_aranzmana()) * 0.5f;
        System.out.println(cijena);
        if(daysUntilDeparture >= 14){
            for(BankovniRacun bankovniRacun: bankovniRacuni){
                if(bankovniRacun.getBroj_racuna().equals(getCurrentClient().getBroj_racuna())){
                    Database.uplata(getCurrentClient().getBroj_racuna(),"1234567887654321",cijena);
                    Database.azurirajPlacenuCijenu(getCurrentClient().getId(),selectedAranzman.getId(),cijena);
                    cancelled_destinations_table.getItems().remove(selectedAranzman);
                    cancelledDestinations.remove(selectedAranzman);
                    booked_destinations_table.getItems().add(selectedAranzman);

                }
            }
        }



    }

    public void payOtherHalf() throws SQLException {
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        Aranzman selectedAranzman = booked_destinations_table.getSelectionModel().getSelectedItem();
        ArrayList<BankovniRacun> bankovniRacuni = Database.getBankovniRacuni();
        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = selectedAranzman.getDatum_polaska();
        long daysUntilDeparture = ChronoUnit.DAYS.between(currentDate, departureDate);

        for (Rezervacija rezervacija : rezervacije) {
            if (daysUntilDeparture <= 0) {
                System.out.println("Putovanje već počelo");
                float novaCijena = 0;
                Database.azurirajPlacenuCijenu(getCurrentClient().getId(), selectedAranzman.getId(), novaCijena);
                booked_destinations_table.getItems().remove(selectedAranzman);
                client_destinations_table.getItems().remove(selectedAranzman);
            } else if (rezervacija.getKlijentId() == getCurrentClient().getId()) {
                if (rezervacija.getPlacenaCijena() < rezervacija.getUkupnaCijena()) {
                    float ostatak_uplate = rezervacija.getUkupnaCijena() * 0.5f;
                    System.out.println("Amount to be paid: " + ostatak_uplate);
                    for (BankovniRacun bankovniRacun : bankovniRacuni) {
                        if (bankovniRacun.getBroj_racuna().equals(getCurrentClient().getBroj_racuna())) {
                            boolean paymentSuccessful = Database.uplata(getCurrentClient().getBroj_racuna(), "1234567887654321", ostatak_uplate);
                            if (paymentSuccessful) {
                                float newPaidPrice = rezervacija.getPlacenaCijena() + ostatak_uplate;
                                Database.azurirajPlacenuCijenu(getCurrentClient().getId(), selectedAranzman.getId(), newPaidPrice);
                            } else {
                                System.out.println("Payment failed. Please try again.");
                            }
                        }
                    }
                } else {
                    System.out.println("Already paid half of the total price.");
                }
            }
        }
    }

    public void showPreviousArrangements(){
        ArrayList<Aranzman> aranzmani = Database.getPositiveAranzman();
        ArrayList<Rezervacija> rezervacije = Database.getRezervacije();
        ArrayList<Aranzman> previousArrangements = new ArrayList<>();
        for(Aranzman aranzman: aranzmani){
            for(Rezervacija rezervacija: rezervacije){
                if(aranzman.getId() == rezervacija.getAranzman() && rezervacija.getKlijentId() == getCurrentClient().getId()) {
                    LocalDate currentDate = LocalDate.now();
                    LocalDate departureDate = aranzman.getDatum_polaska();
                    System.out.println(currentDate + " " +  departureDate + " " + rezervacija.getPlacenaCijena() + " " + rezervacija.getUkupnaCijena());
                    System.out.println(departureDate.isBefore(currentDate));
                    System.out.println(rezervacija.getUkupnaCijena() == rezervacija.getPlacenaCijena());
                    if(departureDate.isBefore(currentDate) && rezervacija.getUkupnaCijena() == rezervacija.getPlacenaCijena()){
                        previousArrangements.add(aranzman);
                    }
                }
            }

        }

        System.out.println(previousArrangements);
        ObservableList<Aranzman> observableAranzmanList = FXCollections.observableArrayList(previousArrangements);
        previous_table.setItems(observableAranzmanList);
        pt_id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        pt_name.setCellValueFactory(celLData -> new SimpleStringProperty(celLData.getValue().getNaziv_putovanja()));
        pt_destination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestinacija()));
        pt_transportation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrevoz()));
        pt_departure.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_polaska());
            return property;
        });
        pt_return.setCellValueFactory(cellData -> {
            ObjectProperty<LocalDate> property = new SimpleObjectProperty<>(cellData.getValue().getDatum_dolaska());
            return property;
        });
        pt_package_price.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCijena_aranzmana()));

    }



}


