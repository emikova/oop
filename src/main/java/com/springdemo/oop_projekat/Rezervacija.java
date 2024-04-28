package com.springdemo.oop_projekat;

public class Rezervacija {
    private int Klijent_id;
    private int Aranzman_id;
    private float ukupna_cijena;
    private float placena_cijena;

    public Rezervacija(int Klijent_id, int Aranzman_id, float ukupna_cijena, float placena_cijena) {
        this.Klijent_id = Klijent_id;
        this.Aranzman_id = Aranzman_id;
        this.ukupna_cijena= ukupna_cijena;
        this.placena_cijena = placena_cijena;
    }

    public int getKlijentId() {
        return Klijent_id;
    }

    public void setKlijentId(int klijentId) {
        this.Klijent_id = klijentId;
    }

    public int getAranzman() {
        return Aranzman_id;
    }

    public void setAranzman(int Aranzman_id) {
        this.Aranzman_id = Aranzman_id;
    }

    public float getUkupnaCijena(){
        return ukupna_cijena;
    }

    public void setUkupnaCijena(float ukupna_cijena) {
        this.ukupna_cijena = ukupna_cijena;
    }

    public float getPlacenaCijena() {
        return placena_cijena;
    }

    public void setPlacenaCijena(float placena_cijena) {
        this.placena_cijena = placena_cijena;
    }

    public float izracunajUkupnuCijenu(Aranzman aranzman, Smjestaj smjestaj, int broj_noci) {
        float cijenaAranzmana = Float.parseFloat(aranzman.getCijena_aranzmana());
        float total = cijenaAranzmana + (broj_noci * smjestaj.getCijena_po_nocenju());
        return total;
    }
}

