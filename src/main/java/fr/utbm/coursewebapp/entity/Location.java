package fr.utbm.coursewebapp.entity;

import java.util.HashSet;
import java.util.Set;

public class Location implements java.io.Serializable {

    private short id;
    private String city;
    private Set courseSessions = new HashSet(0);

    public Location() {
    }

    public Location(short id, String city) {
        this.id = id;
        this.city = city;
    }

    public Location(short id, String city, Set courseSessions) {
        this.id = id;
        this.city = city;
        this.courseSessions = courseSessions;
    }

    public short getId() {
        return this.id;
    }

    public void setId(short id) {
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
