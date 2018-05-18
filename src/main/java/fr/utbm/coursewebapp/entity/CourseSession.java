package fr.utbm.coursewebapp.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CourseSession implements java.io.Serializable {

    private short id;
    private Location location;
    private Date startDate;
    private Date endDate;
    private Set clients = new HashSet(0);

    public CourseSession() {
    }

    public CourseSession(short id, Location location, Date startDate, Date endDate) {
        this.id = id;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CourseSession(short id, Location location, Date startDate, Date endDate, Set clients) {
        this.id = id;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clients = clients;
    }

    public short getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set getClients() {
        return this.clients;
    }

    public void setClients(Set clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", clients=" + clients + '}';
    }

}
