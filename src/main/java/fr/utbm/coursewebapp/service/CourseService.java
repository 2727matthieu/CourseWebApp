/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.Course;
import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.entity.Location;
import fr.utbm.coursewebapp.repository.HibernateCourseDAO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="courseService")
@ApplicationScoped
public class CourseService implements Serializable{

    private List<Course> course;

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse() {
        this.course = getAllCoursesService();
    }
    
    public List<Course> getAllCoursesService() {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getAllCoursesHibernate();
    }

    public List<Course> getAllCoursesService(String motCle) {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getAllCoursesHibernate(motCle);
    }

    public List<Course> getAllCoursesAtLocationService(Location location) {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getAllCoursesAtLocationHibernate(location);
    }

    public List<Course> getAllCoursesAtDateService(Date date) throws Exception {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getAllCoursesAtDateHibernate(date);
    }
    public List<CourseSession> getAllCourseSessions(String code) {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getAllCourseSessions(code);
    }
    public Course getCourseByCode(String code) {
        HibernateCourseDAO hcd = new HibernateCourseDAO();
        return hcd.getCourseByCode(code);
    }
}
