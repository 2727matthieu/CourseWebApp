/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author matbo
 */
@Entity
@Table(name = "COURSE_SESSION")
@NamedQueries({
    @NamedQuery(name = "CourseSession.findAll", query = "SELECT c FROM CourseSession c")})
public class CourseSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAX")
    private int max;
    @JoinColumn(name = "COURSE_CODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Location location;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "courseSession")
    private Set<Client> clients  = new HashSet(0);

    @Transient
    private Integer use;
    @Transient
    private String disable = "false";

    
    public Integer getUse() {
        return use;
    }

    public void setUse(Integer use) {
        this.use = use;
    }
    
    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }
    
    public CourseSession() {
    }

    public CourseSession(Integer id) {
        this.id = id;
    }

    public CourseSession(Integer id, Date startDate, Date endDate, int max) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max + '}';
    }    
}
