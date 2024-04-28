package com.springdemo.oop_projekat;

public class Admin {
    private int id;
    private String ime;
    private String prezime;
    private String korisnicko_ime;
    private String lozinka;

    public Admin(int id, String ime, String prezime, String korisnicko_ime, String lozinka){
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
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

    public String getKorisnicko_ime(){
        return korisnicko_ime;
    }

    public String getLozinka(){
        return lozinka;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }


}
