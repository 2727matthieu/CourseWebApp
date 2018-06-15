/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.repository;

import fr.utbm.coursewebapp.entity.Course;
import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.entity.Location;
import fr.utbm.coursewebapp.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class HibernateCourseDAO {

    public List<Course> getAllCoursesHibernate() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Course");
        List<Course> listCourse = query.list();
        return listCourse;
    }

}
