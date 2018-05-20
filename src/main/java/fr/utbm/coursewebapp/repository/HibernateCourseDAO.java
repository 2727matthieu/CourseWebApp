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

    
    public List<Course> getAllCoursesHibernate(String motCle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Course as course where upper(course.title) like  ?");
        query.setString(0, "%" + motCle.toUpperCase() + "%");
        List<Course> listCourse = query.list();
        return listCourse;
    }

    public List<Course> getAllCoursesAtDateHibernate(Date date) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Course");
        List<Course> listCourse = query.list();

        List<Course> listCourseOK = new ArrayList<>();

        for (Course c : listCourse) {
            for (Iterator it = c.getCourseSessions().iterator(); it.hasNext();) {
                CourseSession cs = (CourseSession) it.next();
                if (date.before(cs.getStartDate())) {
                    int count = 0;
                    for (Course c2 : listCourseOK) {
                        if (c2.equals(c)) {
                            count++;
                        }
                    }

                    if (count == 0) {
                        listCourseOK.add(c);
                    }
                }
            }
        }
        return listCourseOK;
    }

    public Course getCourseByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Course as course where course.code=?");
        query.setString(0, code);
        Course c = (Course) query.uniqueResult();
        return c;
    }

}
