package com.TestApplication.DB_Entity_Classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmkmadusanka on 8/16/2017.
 */

@Entity
public class University {

    @Id
   // @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private int UniId;
    private String Name;
    private int Rating;
    @OneToMany(mappedBy = "unv",cascade= CascadeType.ALL)
    private List<Student> std = new ArrayList<Student>();

    public int getUniId() {
        return UniId;
    }

    public void setUniId(int uniId) {
        UniId = uniId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public List<Student> getStd() {
        return std;
    }

    public void setStd(List<Student> std) {
        this.std = std;
    }


}
