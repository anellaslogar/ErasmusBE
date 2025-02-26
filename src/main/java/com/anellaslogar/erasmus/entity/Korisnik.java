package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.KorisnikDTO;
import jakarta.persistence.*;

@Entity
@Table(name="korisnici")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKorisnik")
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "lozinka")
    private String lozinka;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fakultet_id")
    private Fakultet fakultet;
    @Column(name = "emailVerified")
    private boolean emailVerified;

    public Korisnik(String email, String lozinka, String s) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", fakultet=" + fakultet +
                ", emailVerified=" + emailVerified +
                '}';
    }

    public KorisnikDTO toDTO() {
        return new KorisnikDTO(
                id,
                lozinka);
    }
}
