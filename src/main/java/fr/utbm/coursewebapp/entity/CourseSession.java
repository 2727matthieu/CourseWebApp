package fr.utbm.coursewebapp.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class CourseSession implements java.io.Serializable {

    private Integer id;
    private Location location;
    private Date startDate;
    private Date endDate;
    private int max;
    private Set clients = new HashSet(0);
    private Course course;

    public CourseSession() {
    }

    public CourseSession(Integer id, Location location, Date startDate, Date endDate,int max) {
        this.id = id;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
    }

    public CourseSession(Integer id, Location location, Date startDate, Date endDate,int max, Set clients, Course course) {
        this.id = id;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clients = clients;
        this.course = course;
        this.max = max;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

     @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", clients=" + clients + ", max=" + max + '}';
    }

}