package fr.utbm.coursewebapp.entity;

import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Location implements java.io.Serializable {

    private Integer id;
    private String city;
    private Set courseSessions = new HashSet(0);

    public Location() {
    }

    public Location(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Location(Integer id, String city, Set courseSessions) {
        this.id = id;
        this.city = city;
        this.courseSessions = courseSessions;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set getCourseSessions() {
        return this.courseSessions;
    }

    public void setCourseSessions(Set courseSessions) {
        this.courseSessions = courseSessions;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + '}';
    }

}
