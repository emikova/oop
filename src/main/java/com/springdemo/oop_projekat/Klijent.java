package com.springdemo.oop_projekat;

public class Klijent {
    private int id;
    private String ime;
    private String prezime;
    private String broj_telefona;
    private String jmbg;
    private String broj_racuna;
    private String korisnicko_ime;
    private String lozinka;

    public Klijent(int id, String ime, String prezime, String broj_telefona, String jmbg, String broj_racuna, String korisnicko_ime, String lozinka){
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.broj_telefona = broj_telefona;
        this.jmbg = jmbg;
        this.broj_racuna = broj_racuna;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
    }

    public int getId(){
        return id;
    }

    public String getIme(){
        return ime;
    }

    public String getPrezime(){
        return prezime;
    }

    public String getBroj_telefona(){
        return broj_telefona;
    }

    public String getJmbg(){
        return  jmbg;
    }

    public String getBroj_racuna(){
        return broj_racuna;
    }

    public String getKorisnicko_ime(){
        return korisnicko_ime;
    }

    public String getLozinka(){
        return lozinka;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setIme(String ime){
        this.ime = ime;
    }

    public void setPrezime(String prezime){
        this.prezime = prezime;
    }

    public void setBroj_telefona(String broj_telefona){
        this.broj_telefona = broj_telefona;
    }

    public void setJmbg(String jmbg){
        this.jmbg = jmbg;
    }

    public void setBroj_racuna(String broj_racuna){
        this.broj_racuna = broj_racuna;
    }

    public void setKorisnicko_ime(String korisnicko_ime){
        this.korisnicko_ime = korisnicko_ime;
    }

    public void setLozinka(String lozinka){
        this.lozinka = lozinka;
    }
}
