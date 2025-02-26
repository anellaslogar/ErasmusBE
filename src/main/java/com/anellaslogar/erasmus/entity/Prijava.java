package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.PrijavaDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "prijave")
public class Prijava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPrijava;

    @Column(name = "status")
    private String status;

    @Column(name = "smjer")
    private String smjer;

    @Column(name = "pocetak_datum")
    private String pocetak;

    @Column(name = "zavrsetak_datum")
    private String zavrsetak;

    @Column(name = "semestar")
    private String semestar;

    @Column(name = "rezultat_datum")
    private Date rezultatDatum;

    @Column(name = "vrsta_prijave")
    private String vrstaPrijave;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="stud_program_id")
    private StudProgram studProgram;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="natjecaj_id")
    private Natjecaj natjecaj;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Student student;

    public Prijava() {
    }

    public Prijava(String status, String smjer, String pocetak, String zavrsetak, String semestar, Date rezultatDatum, String vrstaPrijave) {
        this.status = status;
        this.smjer = smjer;
        this.pocetak = pocetak;
        this.zavrsetak = zavrsetak;
        this.semestar = semestar;
        this.rezultatDatum = rezultatDatum;
        this.vrstaPrijave = vrstaPrijave;
    }

    public Integer getIdPrijava() {
        return idPrijava;
    }

    public void setIdPrijava(Integer idPrijava) {
        this.idPrijava = idPrijava;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSmjer() {
        return smjer;
    }

    public void setSmjer(String smjer) {
        this.smjer = smjer;
    }

    public String getPocetak() {
        return pocetak;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public String getZavrsetak() {
        return zavrsetak;
    }

    public void setZavrsetak(String zavrsetak) {
        this.zavrsetak = zavrsetak;
    }

    public String getSemestar() {
        return semestar;
    }

    public void setSemestar(String semestar) {
        this.semestar = semestar;
    }

    public Date getRezultatDatum() {
        return rezultatDatum;
    }

    public void setRezultatDatum(Date rezultatDatum) {
        this.rezultatDatum = rezultatDatum;
    }

    public String getVrstaPrijave() {
        return vrstaPrijave;
    }

    public void setVrstaPrijave(String vrstaPrijave) {
        this.vrstaPrijave = vrstaPrijave;
    }

    public StudProgram getStudProgram() {
        return studProgram;
    }

    public void setStudProgram(StudProgram studProgram) {
        this.studProgram = studProgram;
    }

    public Natjecaj getNatjecaj() {
        return natjecaj;
    }

    public void setNatjecaj(Natjecaj natjecaj) {
        this.natjecaj = natjecaj;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Prijava{" +
                "idPrijava=" + idPrijava +
                ", status='" + status + '\'' +
                ", smjer='" + smjer + '\'' +
                ", pocetak='" + pocetak + '\'' +
                ", zavrsetak='" + zavrsetak + '\'' +
                ", semestar='" + semestar + '\'' +
                ", rezultatDatum=" + rezultatDatum +
                ", vrstaPrijave='" + vrstaPrijave + '\'' +
                '}';
    }

    public PrijavaDTO toDTO() {
        return new PrijavaDTO(
                idPrijava,
                status,
                smjer,
                pocetak,
                zavrsetak,
                semestar,
                rezultatDatum,
                vrstaPrijave);
    }
}
