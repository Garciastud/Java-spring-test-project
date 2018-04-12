package com.project.test_webservices.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;



@Entity
@Table(name = "phone")
public class Phone {


    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private int number;




    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pers_id")
    @JsonBackReference
    private Person person;


    public  Phone() {

    }

    public Phone(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}





