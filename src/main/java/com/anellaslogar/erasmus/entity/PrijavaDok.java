package com.anellaslogar.erasmus.entity;


import com.anellaslogar.erasmus.entityDTO.PrijavaDokDTO;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "prijava_dokumentacija")
public class PrijavaDok{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPrijavaDok;

    @Column(name="naziv_prijava_dok")
    private String nazivPriDok;

    @Column(name="prijava_dok")
    private byte[] prijavaDok;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "prijava_id")
    private Prijava prijava;


    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "natjecaj_dok_id")
    private NatjecajDok natjecajDok;

    public PrijavaDok() {
    }

    public PrijavaDok(String nazivPriDok, byte[] prijavaDok) {
        this.nazivPriDok = nazivPriDok;
        this.prijavaDok = prijavaDok;
    }

    public Integer getIdPrijavaDok() {
        return idPrijavaDok;
    }

    public void setIdPrijavaDok(Integer id) {
        this.idPrijavaDok = idPrijavaDok;
    }

    public String getNazivPriDok() {
        return nazivPriDok;
    }

    public void setNazivPriDok(String nazivPriDok) {
        this.nazivPriDok = nazivPriDok;
    }

    public byte[] getPrijavaDok() {
        return prijavaDok;
    }

    public void setPrijavaDok(byte[] prijavaDok) {
        this.prijavaDok = prijavaDok;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }

    public NatjecajDok getNatjecajDok() {
        return natjecajDok;
    }

    public void setNatjecajDok(NatjecajDok natjecajDok) {
        this.natjecajDok = natjecajDok;
    }

    @Override
    public String toString() {
        return "PrijavaDok{" +
                "idPrijavaDok=" + idPrijavaDok +
                ", nazivPriDok='" + nazivPriDok + '\'' +
                '}';
    }

    public PrijavaDokDTO toDTO() {
        return new PrijavaDokDTO(
                idPrijavaDok,
                nazivPriDok,
                prijavaDok);
    }
}
