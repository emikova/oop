package com.springdemo.oop_projekat;

public class Smjestaj {
    private int id;
    private String  naziv;
    private int broj_zvjezdica;
    private String vrsta_sobe;
    private float cjena_po_nocenju;

    public Smjestaj(int id, String naziv, int broj_zvjezdica, String vrsta_sobe, float cijena_po_nocenju) {
        this.id = id;
        this.naziv = naziv;
        this.broj_zvjezdica = broj_zvjezdica;
        this.vrsta_sobe = vrsta_sobe;
        this.cjena_po_nocenju = cijena_po_nocenju;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_zvjezdica() {
        return broj_zvjezdica;
    }

    public void setBroj_zvjezdica(int broj_zvjezdica) {
        this.broj_zvjezdica = broj_zvjezdica;
    }

    public String getVrsta_sobe() {
        return vrsta_sobe;
    }

    public void setVrsta_sobe(String vrsta_sobe) {
        this.vrsta_sobe = vrsta_sobe;
    }

    public float getCijena_po_nocenju() {
        return cjena_po_nocenju;
    }

    public void setCijena_po_nocenju(float cijena_po_nocenju) {
        this.cjena_po_nocenju = cijena_po_nocenju;
    }

    @Override
    public String toString() {
        return "Smjestaj{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", broj_zvjezdica=" + broj_zvjezdica +
                ", vrsta_sobe='" + vrsta_sobe + '\'' +
                ", cjena_po_nocenju=" + cjena_po_nocenju +
                '}';
    }
}
