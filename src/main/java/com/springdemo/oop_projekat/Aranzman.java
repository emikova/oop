package com.springdemo.oop_projekat;
import java.time.LocalDate;

public class Aranzman {
    private int id;
    private String naziv_putovanja;
    private String destinacija;
    private String prevoz;
    private LocalDate datum_polaska;
    private LocalDate datum_dolaska;
    private String cijena_aranzmana;
    private int smjestaj_id;

    public Aranzman(int id, String naziv_putovanja, String destinacija, String prevoz, LocalDate datum_polaska, LocalDate datum_dolaska, String cijena_aranzmana, int smjestaj_id){
        this.id = id;
        this.naziv_putovanja = naziv_putovanja;
        this.destinacija = destinacija;
        this.prevoz = prevoz;
        this.datum_polaska = datum_polaska;
        this.datum_dolaska = datum_dolaska;
        this.cijena_aranzmana = cijena_aranzmana;
        this.smjestaj_id = smjestaj_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv_putovanja() {
        return naziv_putovanja;
    }

    public void setNaziv_putovanja(String naziv_putovanja) {
        this.naziv_putovanja = naziv_putovanja;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(String destinacija) {
        this.destinacija = destinacija;
    }

    public String getPrevoz() {
        return prevoz;
    }

    public void setPrevoz(String prevoz) {
        this.prevoz = prevoz;
    }

    public LocalDate getDatum_polaska() {
        return datum_polaska;
    }

    public void setDatum_polaska(LocalDate datum_polaska) {
        this.datum_polaska = datum_polaska;
    }

    public LocalDate getDatum_dolaska() {
        return datum_dolaska;
    }

    public void setDatum_dolaska(LocalDate datum_dolaska) {
        this.datum_dolaska = datum_dolaska;
    }

    public String getCijena_aranzmana() {
        return cijena_aranzmana;
    }

    public void setCijena_aranzmana(String cijena_aranzmana) {
        this.cijena_aranzmana = cijena_aranzmana;
    }

    public int getSmjestaj(){
        return smjestaj_id;
    }

    public void setSmjestaj(int smjestaj) {
        this.smjestaj_id = smjestaj_id;
    }

    @Override
    public String toString() {
        return "Aranzman{" +
                "id=" + id +
                ", naziv_putovanja='" + naziv_putovanja + '\'' +
                ", destinacija='" + destinacija + '\'' +
                ", prevoz='" + prevoz + '\'' +
                ", datum_polaska=" + datum_polaska +
                ", datum_dolaska=" + datum_dolaska +
                ", cijena_aranzmana='" + cijena_aranzmana + '\'' +
                ", smjestaj=" + smjestaj_id +
                '}';
    }
}
