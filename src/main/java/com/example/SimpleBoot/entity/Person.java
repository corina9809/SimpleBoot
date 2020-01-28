package com.example.SimpleBoot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String vorname;

    @NotNull
    private String nachname;

    @NotNull
    private Date geburtddatum;

    public Person() {
    }

    public Person(String vorname, String nachname, Date geburtddatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtddatum = geburtddatum;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGeburtddatum() {
        return geburtddatum;
    }

    public void setGeburtddatum(Date geburtddatum) {
        this.geburtddatum = geburtddatum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
