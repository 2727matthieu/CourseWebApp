package fr.utbm.coursewebapp.entity;
// Generated 4 avr. 2016 22:24:00 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Location generated by hbm2java
 */
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