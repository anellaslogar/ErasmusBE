package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.KorisnikDTO;
import jakarta.persistence.*;

@Entity
@Table(name="korisnici")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_korisnici")
    private Integer id;

    @Column(name = "email_id")
    private String email;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;

    public Korisnik(String email, String ime, String prezime) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }



    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }

    public KorisnikDTO toDTO() {
        return new KorisnikDTO(
                id,
                ime,
                prezime,
                email);
    }
}
