package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.FakultetDTO;
import jakarta.persistence.*;

@Entity
@Table(name="fakulteti")
public class Fakultet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
     private Integer idFakultet;

    @Column(name="naziv_fakulteta")
     private String nazivFakulteta;

    @Column(name="drzava")
     private String drzava;

    @Column(name="adresa_fakulteta")
     private String adresaFakulteta;

    @Column(name="email_kontakt")
     private String emailKontakt;

    public Fakultet() {
    }

    public Fakultet(String nazivFakulteta, String drzava, String adresaFakulteta, String emailKontakt) {
        this.nazivFakulteta = nazivFakulteta;
        this.drzava = drzava;
        this.adresaFakulteta = adresaFakulteta;
        this.emailKontakt = emailKontakt;
    }

    public Integer getId() {
        return idFakultet;
    }

    public void setId(Integer id) {
        this.idFakultet = id;
    }

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getAdresaFakulteta() {
        return adresaFakulteta;
    }

    public void setAdresaFakulteta(String adresaFakulteta) {
        this.adresaFakulteta = adresaFakulteta;
    }

    public String getEmailKontakt() {
        return emailKontakt;
    }

    public void setEmailKontakt(String emailKontakt) {
        this.emailKontakt = emailKontakt;
    }

    @Override
    public String toString() {
        return "Fakultet{" +
                "id=" + idFakultet +
                ", nazivFakulteta='" + nazivFakulteta + '\'' +
                ", drzava='" + drzava + '\'' +
                ", adresaFakulteta='" + adresaFakulteta + '\'' +
                ", emailKontakt='" + emailKontakt + '\'' +
                '}';
    }

    public FakultetDTO toDTO() {
        return new FakultetDTO(
                idFakultet,
                nazivFakulteta,
                drzava,
                adresaFakulteta,
                emailKontakt);
    }

   
}
