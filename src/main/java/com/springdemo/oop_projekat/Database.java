package com.springdemo.oop_projekat;

import javafx.scene.chart.PieChart;

import javax.security.auth.Destroyable;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
    private static String DB_user = "root";
    private static String DB_password = "";
    private static String connectionUrl;
    private static int port = 3306;
        private static String DB_name = "agencija";

        private static Connection connection;
        public static void DBConnect() throws SQLException /*, ClassNotFoundException*/ {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connectionUrl = "jdbc:mysql://localhost" + ":" + port + "/" + DB_name;
            connection = DriverManager.getConnection(connectionUrl, DB_user, DB_password);
        }


    public static ArrayList<BankovniRacun> getBankovniRacuni() {
        ArrayList<BankovniRacun> bankovniRacuni = new ArrayList<>();
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }

            ResultSet resultSetBanka = null;
            Statement statementBanka = connection.createStatement();
            String SQLQueryBanka = "SELECT * FROM bankovni_racun";
            resultSetBanka = statementBanka.executeQuery(SQLQueryBanka);

            while(resultSetBanka.next()) {
                int id = resultSetBanka.getInt(1);
                String broj_racuna = resultSetBanka.getString(2);
                String jmbg = resultSetBanka.getString(3);
                float stanje = resultSetBanka.getFloat(4);

                BankovniRacun racun = new BankovniRacun(id, broj_racuna, jmbg, stanje);
                bankovniRacuni.add(racun);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankovniRacuni;
    }

    public static ArrayList<Rezervacija> getRezervacije(){
            ArrayList<Rezervacija> rezervacije = new ArrayList<>();
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }

                ResultSet resultSetRezervacija = null;
                Statement statementRezervacija = connection.createStatement();
                String SQLQueryRezervacija = "SELECT * FROM rezervacija";
                resultSetRezervacija = statementRezervacija.executeQuery(SQLQueryRezervacija);

                while(resultSetRezervacija.next()){
                    int id = resultSetRezervacija.getInt(1);
                    int aranzman_id = resultSetRezervacija.getInt(2);
                    float ukupna_cijena = resultSetRezervacija.getFloat(3);
                    float placena_cijena = resultSetRezervacija.getFloat(4);

                    Rezervacija rezervacija = new Rezervacija(id, aranzman_id,ukupna_cijena,placena_cijena);
                    rezervacije.add(rezervacija);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return rezervacije;
    }

    public static ArrayList<Smjestaj> getSmjestaj(){
            ArrayList<Smjestaj> smjestaji = new ArrayList<>();
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }

                ResultSet resultSetSmjestaj = null;
                Statement statementSmjestaji = connection.createStatement();
                String SQLQuerySmjestaj = "SELECT * FROM smjestaj";
                resultSetSmjestaj = statementSmjestaji.executeQuery(SQLQuerySmjestaj);

                while (resultSetSmjestaj.next()){
                    int id = resultSetSmjestaj.getInt(1);
                    String naziv = resultSetSmjestaj.getString(2);
                    int broj_zvjezdica = resultSetSmjestaj.getInt(3);
                    String vrsta_sobe = resultSetSmjestaj.getString(4);
                    float cjena_po_nocenju = resultSetSmjestaj.getFloat(5);

                    Smjestaj smjestaj = new Smjestaj(id,naziv,broj_zvjezdica,vrsta_sobe,cjena_po_nocenju);
                    smjestaji.add(smjestaj);

                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return smjestaji;
    }


    public static ArrayList<Aranzman> getAranzman(){
            ArrayList<Aranzman> aranzmani = new ArrayList<>();
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }

                ResultSet resultSetAranzman = null;
                Statement statementAranzmani = connection.createStatement();
                String SQLQueryAranzman = "SELECT * FROM aranzman";
                resultSetAranzman = statementAranzmani.executeQuery(SQLQueryAranzman);

                while(resultSetAranzman.next()){
                    int id = resultSetAranzman.getInt(1);
                    String naziv_putovanja = resultSetAranzman.getString(2);
                    String destinacija = resultSetAranzman.getString(3);
                    String prevoz = resultSetAranzman.getString(4);
                    LocalDate datum_polaska = resultSetAranzman.getDate(5).toLocalDate();
                    LocalDate datum_dolaska = resultSetAranzman.getDate(6).toLocalDate();
                    float cijena_aranzmanaFloat = resultSetAranzman.getFloat(7);
                    String cijena_aranzmana = String.valueOf(cijena_aranzmanaFloat);
                    int smjestaj_id = resultSetAranzman.getInt(8);

                    Aranzman aranzman = new Aranzman(id,naziv_putovanja,destinacija,prevoz,datum_polaska,datum_dolaska,cijena_aranzmana,smjestaj_id);
                    aranzmani.add(aranzman);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return aranzmani;
    }


    public static ArrayList<Aranzman> getNegativeAranzman(){
        ArrayList<Aranzman> aranzmani = new ArrayList<>();
        try {
            if(connection == null || connection.isClosed()){
                DBConnect();
            }

            ResultSet resultSetAranzman = null;
            Statement statementAranzmani = connection.createStatement();
            String SQLQueryAranzman = "SELECT * FROM aranzman WHERE id < 0";
            resultSetAranzman = statementAranzmani.executeQuery(SQLQueryAranzman);

            while(resultSetAranzman.next()){
                int id = resultSetAranzman.getInt(1);
                String naziv_putovanja = resultSetAranzman.getString(2);
                String destinacija = resultSetAranzman.getString(3);
                String prevoz = resultSetAranzman.getString(4);
                LocalDate datum_polaska = resultSetAranzman.getDate(5).toLocalDate();
                LocalDate datum_dolaska = resultSetAranzman.getDate(6).toLocalDate();
                float cijena_aranzmanaFloat = resultSetAranzman.getFloat(7);
                String cijena_aranzmana = String.valueOf(cijena_aranzmanaFloat);
                int smjestaj_id = resultSetAranzman.getInt(8);

                Aranzman aranzman = new Aranzman(id,naziv_putovanja,destinacija,prevoz,datum_polaska,datum_dolaska,cijena_aranzmana,smjestaj_id);
                aranzmani.add(aranzman);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return aranzmani;
    }

    public static ArrayList<Aranzman> getPositiveAranzman(){
        ArrayList<Aranzman> aranzmani = new ArrayList<>();
        try {
            if(connection == null || connection.isClosed()){
                DBConnect();
            }

            ResultSet resultSetAranzman = null;
            Statement statementAranzmani = connection.createStatement();
            String SQLQueryAranzman = "SELECT * FROM aranzman WHERE id > 0";
            resultSetAranzman = statementAranzmani.executeQuery(SQLQueryAranzman);

            while(resultSetAranzman.next()){
                int id = resultSetAranzman.getInt(1);
                String naziv_putovanja = resultSetAranzman.getString(2);
                String destinacija = resultSetAranzman.getString(3);
                String prevoz = resultSetAranzman.getString(4);
                LocalDate datum_polaska = resultSetAranzman.getDate(5).toLocalDate();
                LocalDate datum_dolaska = resultSetAranzman.getDate(6).toLocalDate();
                float cijena_aranzmanaFloat = resultSetAranzman.getFloat(7);
                String cijena_aranzmana = String.valueOf(cijena_aranzmanaFloat);
                int smjestaj_id = resultSetAranzman.getInt(8);

                Aranzman aranzman = new Aranzman(id,naziv_putovanja,destinacija,prevoz,datum_polaska,datum_dolaska,cijena_aranzmana,smjestaj_id);
                aranzmani.add(aranzman);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return aranzmani;
    }






    public static ArrayList<Klijent> getKlijenti(){
            ArrayList<Klijent> klijenti = new ArrayList<>();
            try {
                if (connection == null || connection.isClosed()) {
                    DBConnect();
                }
                ResultSet resultSetKlijenti = null;
                Statement statementKlijenti = connection.createStatement();
                String SQLQueryKlijenti = "SELECT * FROM klijent";
                resultSetKlijenti = statementKlijenti.executeQuery(SQLQueryKlijenti);

                while(resultSetKlijenti.next()){
                    int id = resultSetKlijenti.getInt(1);
                    String ime = resultSetKlijenti.getString(2);
                    String prezime = resultSetKlijenti.getString(3);
                    String broj_telefona = resultSetKlijenti.getString(4);
                    String jmbg = resultSetKlijenti.getString(5);
                    String broj_racuna = resultSetKlijenti.getString(6);
                    String korisnicko_ime = resultSetKlijenti.getString(7);
                    String lozinka = resultSetKlijenti.getString(8);

                    Klijent klijent = new Klijent(id,ime,prezime,broj_telefona,jmbg,broj_racuna,korisnicko_ime,lozinka);
                    klijenti.add(klijent);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            return klijenti;

    }

    public static void izbrisiEkskurziju(Aranzman aranzman){
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }

                String sqlAranzman = "DELETE FROM aranzman WHERE id = ?";
                PreparedStatement preparedStatementAranzman = connection.prepareStatement(sqlAranzman);
                preparedStatementAranzman.setInt(1,aranzman.getId());
                int rowsAffected = preparedStatementAranzman.executeUpdate();

                if(rowsAffected == 1){
                    System.out.println("Excursion deleted successfully from database.");
                }else {
                    System.out.println("Failed to delete Excursion!");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public static void izbrisiAranzman(Aranzman aranzman, Smjestaj smjestaj){
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }

                String sqlAranzman = "DELETE FROM aranzman WHERE id = ?";
                String sqlSmjestaj = "DELETE FROM smjestaj WHERE id = ?";

                PreparedStatement preparedStatementAranzman = connection.prepareStatement(sqlAranzman);
                PreparedStatement preparedStatementSmjestaj = connection.prepareStatement(sqlSmjestaj);


                preparedStatementAranzman.setInt(1,aranzman.getId());
                int rowsAffectedAranzman= preparedStatementAranzman.executeUpdate();
                preparedStatementSmjestaj.setInt(1,smjestaj.getId());
                int rowsAffectedSmjestaj = preparedStatementSmjestaj.executeUpdate();

                if(rowsAffectedAranzman == 1 && rowsAffectedSmjestaj == 1){
                    System.out.println("Destination deleted from database");
                    System.out.println("Accommodation deleted from database");
                }else{
                    System.out.println("Failed to delete Destination and Accommodation");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public static void izbrisiAdmina(Admin admin){
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }
            String sql = "DELETE FROM admin WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, admin.getId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Admin deleted from database.");
            } else {
                System.out.println("Failed to delete admin from database.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static void dodajRezervaciju(int Klijent_id,int Aranzman_id, float ukupna_cijena, float placena_cijena) {
        try {
            if(connection == null || connection.isClosed()){
                DBConnect();
            }
            String SQLInsertRezervacija = "INSERT INTO rezervacija (Klijent_id, Aranzman_id, ukupna_cijena, placena_cijena)" + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatementRezervacija = connection.prepareStatement(SQLInsertRezervacija, Statement.RETURN_GENERATED_KEYS);

            preparedStatementRezervacija.setInt(1, Klijent_id);
            preparedStatementRezervacija.setInt(2, Aranzman_id);
            preparedStatementRezervacija.setFloat(3, ukupna_cijena);
            preparedStatementRezervacija.setFloat(4, placena_cijena);

            int rowsAffected = preparedStatementRezervacija.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reservation added successfully.");
            } else {
                System.out.println("Failed to add reservation.");
            }

            preparedStatementRezervacija.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dodajAranzman(int id, String naziv_putovanja, String destinacija, String prevoz, LocalDate datum_polaska, LocalDate datum_dolaska, String cijena_aranzmana, int Smjestaj_id){
            try{
                if(connection == null ||connection.isClosed()){
                    DBConnect();
                }

                String SQLInsertAranzman = "INSERT INTO aranzman (id, naziv_putovanja, destinacija, prevoz, datum_polaska, datum_dolaska, cijena_aranzmana, Smjestaj_id)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatementAranzman = connection.prepareStatement(SQLInsertAranzman, Statement.RETURN_GENERATED_KEYS);

                preparedStatementAranzman.setInt(1, id);
                preparedStatementAranzman.setString(2, naziv_putovanja);
                preparedStatementAranzman.setString(3, destinacija);
                preparedStatementAranzman.setString(4, prevoz);
                preparedStatementAranzman.setDate(5, java.sql.Date.valueOf(datum_polaska));
                preparedStatementAranzman.setDate(6, java.sql.Date.valueOf(datum_dolaska));
                preparedStatementAranzman.setString(7, cijena_aranzmana);
                preparedStatementAranzman.setInt(8, Smjestaj_id);

                int rowsAffected = preparedStatementAranzman.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Arrangement added successfully.");
                } else {
                    System.out.println("Failed to add arrangement.");
                }

                preparedStatementAranzman.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
    }


    public static void dodajEkskurziju(int id, String naziv_putovanja, String destinacija, String prevoz, LocalDate datum_polaska,LocalDate datum_dolaska, String cijena_aranzmana){
            try {
                if(connection == null ||connection.isClosed()){
                    DBConnect();
                }

                String SQLInsertEkskurzija = "INSERT INTO aranzman (id, naziv_putovanja, destinacija, prevoz, datum_polaska,datum_dolaska, cijena_aranzmana)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatementEkskurzija = connection.prepareStatement(SQLInsertEkskurzija,Statement.RETURN_GENERATED_KEYS);
                preparedStatementEkskurzija.setInt(1, id);
                preparedStatementEkskurzija.setString(2, naziv_putovanja);
                preparedStatementEkskurzija.setString(3, destinacija);
                preparedStatementEkskurzija.setString(4,prevoz);
                preparedStatementEkskurzija.setDate(5, java.sql.Date.valueOf(datum_polaska));
                preparedStatementEkskurzija.setDate(6, java.sql.Date.valueOf(datum_dolaska));
                preparedStatementEkskurzija.setString(7 ,cijena_aranzmana);

                int rowsAffected = preparedStatementEkskurzija.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Accommodation added successfully.");
                } else {
                    System.out.println("Failed to add accommodation.");
                }

                preparedStatementEkskurzija.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public static void dodajSmjestaj(int id, String naziv, int broj_zvjezdica, String vrsta_sobe, float cjena_po_nocenju){
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }
            String SQlInsertSmjestaj = "INSERT INTO smjestaj (id, naziv, broj_zvjezdica, vrsta_sobe, cjena_po_nocenju)" + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementSmjestaj = connection.prepareStatement(SQlInsertSmjestaj, Statement.RETURN_GENERATED_KEYS);


            preparedStatementSmjestaj.setInt(1, id);
            preparedStatementSmjestaj.setString(2, naziv);
            preparedStatementSmjestaj.setInt(3, broj_zvjezdica);
            preparedStatementSmjestaj.setString(4, vrsta_sobe);
            preparedStatementSmjestaj.setFloat(5, cjena_po_nocenju);

            int rowsAffected = preparedStatementSmjestaj.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Accommodation added successfully.");
            } else {
                System.out.println("Failed to add accommodation.");
            }

            preparedStatementSmjestaj.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Rezervacija> getRezervacija(){
            ArrayList<Rezervacija> rezervacije = new ArrayList<>();
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }

                ResultSet resultSetRezervacija = null;
                Statement statementRezervacija = connection.createStatement();
                String SQLQueryRezervacija = "SELECT * FROM rezervacija";
                resultSetRezervacija = statementRezervacija.executeQuery(SQLQueryRezervacija);

                while (resultSetRezervacija.next()){
                    int Klijent_id = resultSetRezervacija.getInt(1);
                    int Aranzman_id = resultSetRezervacija.getInt(2);
                    float ukupna_cijena = resultSetRezervacija.getFloat(3);
                    float placena_cijena = resultSetRezervacija.getFloat(4);

                    Rezervacija rezervacija = new Rezervacija(Klijent_id,Aranzman_id,ukupna_cijena,placena_cijena);
                    rezervacije.add(rezervacija);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return rezervacije;
    }

    public static ArrayList<Admin> getAdmin(){
            ArrayList<Admin> admini = new ArrayList<>();
            try {
                if (connection == null || connection.isClosed()) {
                    DBConnect();
                }
                ResultSet resultSetAdmin = null;
                Statement statementAdmini = connection.createStatement();
                String SQLQueryAdmini = "SELECT * FROM admin";
                resultSetAdmin = statementAdmini.executeQuery(SQLQueryAdmini);
                while (resultSetAdmin.next()){
                    int id = resultSetAdmin.getInt(1);
                    String ime = resultSetAdmin.getString(2);
                    String prezime = resultSetAdmin.getString(3);
                    String korisnicko_ime = resultSetAdmin.getString(4);
                    String lozinka = resultSetAdmin.getString(5);

                    Admin admin = new Admin(id,ime,prezime,korisnicko_ime,lozinka);
                    admini.add(admin);

                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return admini;
    }



    public static void dodajAdmina(int id, String ime, String prezime, String korisnicko_ime, String lozinka){
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }
            String SQLInsertAdmin = "INSERT INTO admin (id, ime, prezime, korisnicko_ime, lozinka) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementAdmin = connection.prepareStatement(SQLInsertAdmin, Statement.RETURN_GENERATED_KEYS);

            preparedStatementAdmin.setInt(1, id);
            preparedStatementAdmin.setString(2,ime);
            preparedStatementAdmin.setString(3, prezime);
            preparedStatementAdmin.setString(4, korisnicko_ime);
            preparedStatementAdmin.setString(5, "123456");

            int rowsAffected = preparedStatementAdmin.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Client added successfully.");
            } else {
                System.out.println("Failed to add client.");
            }

            preparedStatementAdmin.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static void dodajKlijenta(int id, String ime, String prezime, String broj_telefona, String jmbg, String broj_racuna,
                                     String korisnicko_ime, String lozinka) {
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }


            String SQLInsertClient = "INSERT INTO klijent (id, ime, prezime, broj_telefona, jmbg, broj_racuna, korisnicko_ime, lozinka) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementKlijent = connection.prepareStatement(SQLInsertClient, Statement.RETURN_GENERATED_KEYS);

            preparedStatementKlijent.setInt(1,id);
            preparedStatementKlijent.setString(2, ime);
            preparedStatementKlijent.setString(3, prezime);
            preparedStatementKlijent.setString(4, broj_telefona);
            preparedStatementKlijent.setString(5, jmbg);
            preparedStatementKlijent.setString(6, broj_racuna);
            preparedStatementKlijent.setString(7, korisnicko_ime);
            preparedStatementKlijent.setString(8, lozinka);;

            int rowsAffected = preparedStatementKlijent.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Client added successfully.");
            } else {
                System.out.println("Failed to add client.");
            }

            preparedStatementKlijent.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getBankovniRacunId(String jmbg, String broj_racuna) throws SQLException {
        int bankAccountId = -1;
        String SQLQueryBankAccount = "SELECT id FROM bankovni_racun WHERE jmbg = ? AND broj_racuna = ?";
        PreparedStatement pstmt = connection.prepareStatement(SQLQueryBankAccount);
        pstmt.setString(1, jmbg);
        pstmt.setString(2, broj_racuna);

        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            bankAccountId = resultSet.getInt(1);
        }

        resultSet.close();
        pstmt.close();

        return bankAccountId;
    }

    public static int getSmjestajId() throws SQLException {
        int smjestajId = 0;
        String SQLQuerySmjestaj = "SELECT MAX(id) FROM smjestaj";
        try (PreparedStatement pstmt = connection.prepareStatement(SQLQuerySmjestaj)) {
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    smjestajId = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return smjestajId + 1;
    }


    public static int getAranzmanId() throws SQLException {
        int nextId = 0;
        String query = "SELECT MAX(id) FROM aranzman WHERE id > 0";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int maxId = resultSet.getInt(1);

                    nextId = maxId + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return nextId;
    }

    public static int getNextAvailableNegativeAranzmanId() throws SQLException {
        int nextNegativeId = -1;
        String query = "SELECT MAX(id) FROM aranzman WHERE id < 0";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int minNegativeId = resultSet.getInt(1);

                    nextNegativeId = minNegativeId - 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return nextNegativeId;
    }

    public static boolean uplata(String broj_racuna_klijenta, String broj_racuna_agencije, float iznos) throws SQLException {
        if (connection == null || connection.isClosed()) {
            DBConnect();
        }
        boolean paymentSucceeded = false;

        // Provjera stanja na računu klijenta
        String provjeraUpitKlijent = "SELECT stanje FROM bankovni_racun WHERE broj_racuna = ?";
        PreparedStatement provjeraStatementKlijent = connection.prepareStatement(provjeraUpitKlijent);
        provjeraStatementKlijent.setString(1, broj_racuna_klijenta);
        ResultSet resultSetKlijent = provjeraStatementKlijent.executeQuery();

        String provjeraUpitAgencija = "SELECT stanje FROM bankovni_racun WHERE broj_racuna = ?";
        PreparedStatement provjeraStatementAgencija = connection.prepareStatement(provjeraUpitAgencija);
        provjeraStatementAgencija.setString(1, broj_racuna_agencije);
        ResultSet resultSetAgencija = provjeraStatementAgencija.executeQuery();

        if (resultSetKlijent.next() && resultSetAgencija.next()) {
            float trenutnoStanjeKlijenta = resultSetKlijent.getFloat("stanje");
            float trenutnoStanjeAgencije = resultSetAgencija.getFloat("stanje");

            if (trenutnoStanjeKlijenta >= iznos) {
                float novoStanjeKlijenta = trenutnoStanjeKlijenta - iznos;
                float novoStanjeAgencije = trenutnoStanjeAgencije + iznos;

                String uplataKlijentUpit = "UPDATE bankovni_racun SET stanje = ? WHERE broj_racuna = ?";
                PreparedStatement uplataKlijentStatement = connection.prepareStatement(uplataKlijentUpit);
                uplataKlijentStatement.setFloat(1, novoStanjeKlijenta);
                uplataKlijentStatement.setString(2, broj_racuna_klijenta);
                uplataKlijentStatement.executeUpdate();

                // Ažuriranje stanja na računu agencije
                String uplataAgencijaUpit = "UPDATE bankovni_racun SET stanje = ? WHERE broj_racuna = ?";
                PreparedStatement uplataAgencijaStatement = connection.prepareStatement(uplataAgencijaUpit);
                uplataAgencijaStatement.setFloat(1, novoStanjeAgencije);
                uplataAgencijaStatement.setString(2, broj_racuna_agencije);
                uplataAgencijaStatement.executeUpdate();
                paymentSucceeded = true;

                System.out.println("Uplata uspješno izvršena.");
            } else {
                System.out.println("Klijent nema dovoljno sredstava na računu.");
            }
        } else {
            System.out.println("Nalog sa datim brojem računa nije pronađen.");
        }
        return paymentSucceeded;
    }

    public static void azurirajPlacenuCijenu(int klijentId, int aranzmanId, float novaCijena) throws SQLException {
        if (connection == null || connection.isClosed()) {
            DBConnect();
        }

        String azuriranjeUpit = "UPDATE rezervacija SET placena_cijena = ? WHERE Klijent_id = ? AND Aranzman_id = ?";
        PreparedStatement azuriranjeStatement = connection.prepareStatement(azuriranjeUpit);
        azuriranjeStatement.setFloat(1, novaCijena);
        azuriranjeStatement.setInt(2, klijentId);
        azuriranjeStatement.setInt(3, aranzmanId);

        int rowsAffected = azuriranjeStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Uspješno ažurirana plaćena cijena u tablici rezervacija.");
        } else {
            System.out.println("Nije uspjelo ažuriranje plaćene cijene u tablici rezervacija.");
        }

        azuriranjeStatement.close();
    }



    public static void obrisiRezervacijeZaAranzman(int aranzmanId) {
        try {
            if(connection == null ||connection.isClosed()) {
                DBConnect();
            }
            String deleteRezervacijeQuery = "DELETE FROM rezervacija WHERE Aranzman_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteRezervacijeQuery);
            preparedStatement.setInt(1, aranzmanId);
            preparedStatement.executeUpdate();
            System.out.println("Sve rezervacije za aranžman su uspešno obrisane.");
        } catch (SQLException e) {
            System.err.println("Greška pri brisanju rezervacija za aranžman: " + e.getMessage());
        }
    }




    public static void promijeniPlacenuCijenu(int klijentId, int aranzmanId, double novaPlacenaCijena) {
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }

            String updateQuery = "UPDATE rezervacija SET placena_cijena = ? WHERE Klijent_id = ? AND Aranzman_id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setDouble(1, novaPlacenaCijena);
            updateStatement.setInt(2, klijentId);
            updateStatement.setInt(3, aranzmanId);

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Plaćena cijena uspješno ažurirana.");
            } else {
                System.out.println("Nije uspjelo ažuriranje plaćene cijene.");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void promijeniIdAranzmana(int stariId, int noviId) {
        try {
            if (connection == null || connection.isClosed()) {
                DBConnect();
            }
            String provjeraUpit = "SELECT * FROM aranzman WHERE id = ?";
            PreparedStatement provjeraStatement = connection.prepareStatement(provjeraUpit);
            provjeraStatement.setInt(1, stariId);
            ResultSet resultSet = provjeraStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Aranžman sa ID-om " + stariId + " ne postoji.");
                return;
            }

            String ažuriranjeUpita = "UPDATE aranzman SET id = ? WHERE id = ?";
            PreparedStatement ažuriranjeStatement = connection.prepareStatement(ažuriranjeUpita);
            ažuriranjeStatement.setInt(1, noviId);
            ažuriranjeStatement.setInt(2, stariId);
            int rowsAffected = ažuriranjeStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("ID aranžmana uspješno promijenjen iz " + stariId + " u " + noviId + ".");
            } else {
                System.out.println("Nije uspjelo ažuriranje ID-a aranžmana.");
            }

            ažuriranjeStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void promijeniAdminuSifru(String staraSifra, String novaSifra){
            try {
                if(connection == null || connection.isClosed()){
                    DBConnect();
                }
                String provjeraUpit = "SELECT * FROM admin WHERE lozinka = ?";
                PreparedStatement provjeraStatement = connection.prepareStatement(provjeraUpit);
                provjeraStatement.setString(1, staraSifra);
                ResultSet resultSet = provjeraStatement.executeQuery();

                if (!resultSet.next()) {
                    System.out.println("Admin sa lozinkom " + staraSifra + " ne postoji.");
                    return;
                }

                String ažuriranjeUpita = "UPDATE admin SET lozinka = ? WHERE lozinka = ?";
                PreparedStatement ažuriranjeStatement = connection.prepareStatement(ažuriranjeUpita);
                ažuriranjeStatement.setString(1, novaSifra);
                ažuriranjeStatement.setString(2, staraSifra);
                int rowsAffected = ažuriranjeStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Lozinka admina uspješno promijenjena iz " + staraSifra + " u " + novaSifra + ".");
                } else {
                    System.out.println("Nije uspjelo ažuriranje lozinke admina.");
                }

                ažuriranjeStatement.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public static void main (String[] args) {
            try {
                DBConnect();
                System.out.println("Uspjesno ste se konektovali na bazu:" + connectionUrl);
                ArrayList<BankovniRacun> bankovniRacuni = getBankovniRacuni();

                for(BankovniRacun racuni: bankovniRacuni){
                    System.out.println(racuni);
                }


                ResultSet resultSetAdmin = null;
                Statement statementAdmin = connection.createStatement();
                String SQLQueryAdmin = "SELECT * FROM admin";
                resultSetAdmin = statementAdmin.executeQuery(SQLQueryAdmin);

                // String SQLInsert = "INSERT INTO admin VALUES (2, 'Milos', 'Milosevic', 'milos_milosevic', 'milos123')";
                //statement.executeUpdate(SQLInsert);

                System.out.println("--------------------------------------------");
                while (resultSetAdmin.next()) {
                    String result = resultSetAdmin.getString(1) + ", " + resultSetAdmin.getString(2)
                            + ", " + resultSetAdmin.getString(3) + ", " + resultSetAdmin.getString(4)
                            + ", " + resultSetAdmin.getString(5);
                    System.out.println(result);
                    System.out.println("--------------------------------------------");
                }


                statementAdmin.close();

                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            } //catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            //
        }

    }

