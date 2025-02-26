package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.NominacijaDokDTO;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dokumenti_nominacije")
public class NominacijaDok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idNominacijaDok;

    @Column(name="naziv_dok_nominacije")
    private String nazivNomDok;

    @Column(name="nominacije_dok")
    private byte[] nominacijeDok;

    @Column(name="datum_objave")
    private Date datumObjave;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "prijava_id")
    private  Prijava prijava;

    public NominacijaDok() {
    }

    public NominacijaDok(String nazivNomDok, byte[] nominacijeDok, Date datumObjave) {
        this.nazivNomDok = nazivNomDok;
        this.nominacijeDok = nominacijeDok;
        this.datumObjave = datumObjave;
    }

    public Integer getIdNominacijaDok() {
        return idNominacijaDok;
    }

    public void setIdNominacijaDok(Integer idNominacijaDok) {
        this.idNominacijaDok = idNominacijaDok;
    }

    public String getNazivNomDok() {
        return nazivNomDok;
    }

    public void setNazivNomDok(String nazivNomDok) {
        this.nazivNomDok = nazivNomDok;
    }

    public byte[] getNominacijeDok() {
        return nominacijeDok;
    }

    public void setNominacijeDok(byte[] nominacijeDok) {
        this.nominacijeDok = nominacijeDok;
    }

    public Date getDatumObjave() {
        return datumObjave;
    }

    public void setDatumObjave(Date datumObjave) {
        this.datumObjave = datumObjave;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }

    @Override
    public String toString() {
        return "NominacijaDok{" +
                "idNominacijaDok=" + idNominacijaDok +
                ", nazivNomDok='" + nazivNomDok + '\'' +
                ", datumObjave=" + datumObjave +
                '}';
    }

    public NominacijaDokDTO toDTO() {
        return new NominacijaDokDTO(
                idNominacijaDok,
                nazivNomDok,
                nominacijeDok,
                datumObjave);
    }
}
