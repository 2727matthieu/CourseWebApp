/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.repository;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class HibernateCourseSessionDAO {
    
    public CourseSession getCourseSessionById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CourseSession as courseSession where courseSession.id=?");
        query.setInteger(0,id);
        CourseSession cs=(CourseSession) query.uniqueResult();
        return cs; 
    }
    
    List<CourseSession> courseSessions;
     
    public List<CourseSession> getAllCourseSessions(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from CourseSession cs where cs.course.code = :code";
            courseSessions = session.createQuery(hql).setParameter("code", code).list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
        return courseSessions;

    }
    
    public List<CourseSession> getAllCoursesSessionsHibernate(String motCle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CourseSession cs where upper(cs.course.title) like  ?");
        query.setString(0, "%" + motCle.toUpperCase() + "%");
        List<CourseSession> listCourse = query.list();
        return listCourse;
    }
    
    public List<CourseSession> getAllCoursesSessionsDate(Date date){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from CourseSession cs where cs.startDate <=  ? and cs.endDate >=  ?");
        query.setParameter(0, date);
        query.setParameter(1, date);
        List<CourseSession> listCourse = query.list();
        
        return listCourse;
    }
    
    public List<CourseSession> getAllCoursesSessionsDateCode(Date date,String code){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from CourseSession cs where cs.startDate <=  ? and cs.endDate >=  ? and upper(cs.course.title) like  ?");
        query.setParameter(0, date);
        query.setParameter(1, date);
        query.setParameter(2, "%" + code.toUpperCase() + "%");
        List<CourseSession> listCourse = query.list();
        
        return listCourse;
    }
    
}
