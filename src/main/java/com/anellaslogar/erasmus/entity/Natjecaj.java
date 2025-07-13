package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.NatjecajDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="natjecaj")
public class Natjecaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idNatjecaj;

    @Column(name = "naziv_natjecaja")
    private String natjecajNaziv;

    @Column(name = "pocetak_datum")
    private Date pocetak;

    @Column(name = "zavrsetak_datum")
    private Date zavrsetak;

    @Column(name = "ak_godina")
    private String godina;

    public Natjecaj() {
    }

    public Natjecaj(String natjecajNaziv, Date pocetak, Date zavrsetak, String godina) {
        this.natjecajNaziv = natjecajNaziv;
        this.pocetak = pocetak;
        this.zavrsetak = zavrsetak;
        this.godina = godina;
    }

    public Integer getIdNatjecaj() {
        return idNatjecaj;
    }

    public void setIdNatjecaj(Integer idNatjecaj) {
        this.idNatjecaj = idNatjecaj;
    }

    public String getNatjecajNaziv() {
        return natjecajNaziv;
    }

    public void setNatjecajNaziv(String natjecajNaziv) {
        this.natjecajNaziv = natjecajNaziv;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getZavrsetak() {
        return zavrsetak;
    }

    public void setZavrsetak(Date zavrsetak) {
        this.zavrsetak = zavrsetak;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    @Override
    public String toString() {
        return "Natjecaj{" +
                "idNatjecaj=" + idNatjecaj +
                ", natjecajNaziv='" + natjecajNaziv + '\'' +
                ", pocetak=" + pocetak +
                ", zavrsetak=" + zavrsetak +
                ", godina='" + godina + '\'' +
                '}';
    }
    public NatjecajDTO toDTO() {
        return new NatjecajDTO(
                idNatjecaj,
                natjecajNaziv,
                pocetak,
                zavrsetak,
                godina);
    }
}
