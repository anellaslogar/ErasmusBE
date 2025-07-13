package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.NatjecajDokDTO;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "natjecaj_dokumentacija")
public class NatjecajDok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idNatjecajDok;

    @Column(name = "naziv_natjecaj_dok")
    private String nazivNatDok;

    @Column(name="natjecaj_dok")
    private byte[] natjecajDok;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "natjecaj_id")
    private Natjecaj natjecaj;

    public NatjecajDok() {
    }

    public NatjecajDok(String nazivNatDok, byte[] natjecajDok) {
        this.nazivNatDok = nazivNatDok;
        this.natjecajDok = natjecajDok;
    }

    public Integer getIdNatjecajDok() {
        return idNatjecajDok;
    }

    public void setIdNatjecajDok(Integer idNatjecajDok) {
        this.idNatjecajDok = idNatjecajDok;
    }

    public String getNazivNatDok() {
        return nazivNatDok;
    }

    public void setNazivNatDok(String nazivNatDok) {
        this.nazivNatDok = nazivNatDok;
    }

    public byte[] getNatjecajDok() {
        return natjecajDok;
    }

    public void setNatjecajDok(byte[] natjecajDok) {
        this.natjecajDok = natjecajDok;
    }

    public Natjecaj getNatjecaj() {
        return natjecaj;
    }

    public void setNatjecaj(Natjecaj natjecaj) {
        this.natjecaj = natjecaj;
    }

    @Override
    public String toString() {
        return "NatjecajDok{" +
                "idNatjecajDok=" + idNatjecajDok +
                ", nazivNatDok='" + nazivNatDok +
                '}';
    }
    public NatjecajDokDTO toDTO() {
        return new NatjecajDokDTO(
                idNatjecajDok,
                nazivNatDok,
                natjecajDok);
    }
}
