package com.TestApplication.DB_Entity_Classes;

import javax.persistence.Id;

/**
 * Created by kmkmadusanka on 8/16/2017.
 */
public class Computer {

    @Id
    private int ComId;
    private String Type;
    private Student std;

    public int getComId() {
        return ComId;
    }

    public void setComId(int comId) {
        ComId = comId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ComId=" + ComId +
                ", Type='" + Type + '\'' +
                ", std=" + std +
                '}';
    }
}
