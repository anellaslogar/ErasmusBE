package com.anellaslogar.erasmus.entity;

import com.anellaslogar.erasmus.entityDTO.StudentDTO;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idStudent;

    @Column(name="ime")
    private String ime;

    @Column(name="prezime")
    private String prezime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fakultet_id")
    private Fakultet fakultet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="email_id")
    private Korisnik email;

    public Student() {
    }

    public Student(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
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

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    public Korisnik getEmail() {
        return email;
    }

    public void setEmail(Korisnik email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }
    public StudentDTO toDTO() {
        return new StudentDTO(
                idStudent,
                ime,
                prezime);
    }
}
