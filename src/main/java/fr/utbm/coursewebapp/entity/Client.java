package fr.utbm.coursewebapp.entity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Transient;

@ManagedBean
@ApplicationScoped
public class Client implements java.io.Serializable {

    private Integer id;
    private CourseSession courseSession;
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(Integer id, CourseSession courseSession, String lastname, String firstname, String address, String phone) {
        this.id = id;
        this.courseSession = courseSession;

        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
    }

    public Client(Integer id, CourseSession courseSession, String lastname, String firstname, String address, String phone, String email) {
        this.id = id;
        this.courseSession = courseSession;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CourseSession getCourseSession() {
        return this.courseSession;
    }

    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", courseSession=" + courseSession + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }
    
    @Transient
    public String clear(){
        firstname="";
        lastname="";
        address="";
        phone="";
        email="";
        return "clear";
    }

}
