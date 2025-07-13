package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.StudProgramDTO;
import jakarta.persistence.*;

@Entity
@Table(name="studijski_programi")
public class StudProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idStudProgram;

    @Column(name = "naziv_stud_programa")
    private String nazivStudija;

    @Column(name="vrsta_stud_programa")
    private String vrstaStudija;

    public StudProgram() {
    }

    public StudProgram(String nazivStudija, String vrstaStudija) {
        this.nazivStudija = nazivStudija;
        this.vrstaStudija = vrstaStudija;
    }

    public Integer getIdStudProgram() {
        return idStudProgram;
    }

    public void setIdStudProgram(Integer idStudProgram) {
        this.idStudProgram = idStudProgram;
    }

    public String getNazivStudija() {
        return nazivStudija;
    }

    public void setNazivStudija(String nazivStudija) {
        this.nazivStudija = nazivStudija;
    }

    public String getVrstaStudija() {
        return vrstaStudija;
    }

    public void setVrstaStudija(String vrstaStudija) {
        this.vrstaStudija = vrstaStudija;
    }

    @Override
    public String toString() {
        return "StudProgram{" +
                "idStudProgram=" + idStudProgram +
                ", nazivStudija='" + nazivStudija + '\'' +
                ", vrstaStudija='" + vrstaStudija + '\'' +
                '}';
    }

    public StudProgramDTO toDTO() {
        return new StudProgramDTO(
                idStudProgram,
                nazivStudija,
                vrstaStudija);
    }
}
