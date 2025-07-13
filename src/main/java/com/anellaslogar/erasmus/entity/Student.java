package com.anellaslogar.erasmus.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idStudent;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fakultet_id")
    private Fakultet fakultet;

    @Column(name = "supabase_user_id", nullable = false, unique = true)
    private String supabaseUserId;

    public Student() {
    }


    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }


    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }


    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                '}';
    }
    

    public void setSupabaseUserId(String supabaseUserId) {
    }

    public void setIme(String ime) {
    }

    public void setPrezime(String prezime) {
    }
}
