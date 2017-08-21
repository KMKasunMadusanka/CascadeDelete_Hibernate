package com.TestApplication.DB_Entity_Classes;
import javax.persistence.*;



@Entity
public class Student {

    @Id
    private int Id;
    private String Name;
    private  double CGPA;
    private String Address;

    @ManyToOne
    private University unv;


    public int getId() {

        return Id;
    }

    public void setId(int id) {

        Id = id;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {

        Name = name;
    }

    public double getCGPA() {

        return CGPA;
    }

    public void setCGPA(double CGPA) {

        this.CGPA = CGPA;
    }

    public String getAddress() {

        return Address;
    }

    public void setAddress(String address) {

        Address = address;
    }


    public University getUnv() {

        return unv;
    }

    public void setUnv(University unv) {

        this.unv = unv;
    }


   }
