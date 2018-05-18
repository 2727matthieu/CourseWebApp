package fr.utbm.coursewebapp.entity;


import java.util.HashSet;
import java.util.Set;

public class Course implements java.io.Serializable {

    private String code;
    private String title;
    private Set courseSessions = new HashSet(0);

    public Course() {
    }

    public Course(String code, String title, String description, String picture) {
        this.code = code;
        this.title = title;
    }

    public Course(String code, String title, String description, String picture, Set courseSessions) {
        this.code = code;
        this.title = title;
        this.courseSessions = courseSessions;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set getCourseSessions() {
        return this.courseSessions;
    }

    public void setCourseSessions(Set courseSessions) {
        this.courseSessions = courseSessions;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + ", courseSessions=" + courseSessions + '}';
    }

}
