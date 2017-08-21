package com.TestApplication.DB_Entity_Classes;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class University {

    @Id
    private int UniId;
    private String Name;
    private int Rating;

    @OneToMany(mappedBy = "unv",cascade= CascadeType.REMOVE)
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

    @Override
    public String toString() {
        return "University{" +
                "UniId=" + UniId +
                ", Name='" + Name + '\'' +
                ", Rating=" + Rating +
                ", std=" + std +
                '}';
    }

    public List<Student> getStd() {

        return std;
    }

    public void setStd(List<Student> std) {

        this.std = std;


    }

    public University




    merge(University other) {
        this.UniId = other.UniId == 0 ? this.UniId : other.UniId;
        this.Name = other.Name == null ? this.Name : other.Name;
        this.Rating = other.Rating == 0 ? this.Rating : other.Rating;

       // System.out.println(other.toString());
        return  other;
    }

}
