/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.repository;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.util.HibernateUtil;
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
            String hql = "from CourseSession cs where cs.course = :code";
            courseSessions = session.createQuery(hql).setParameter("code", code).list();
            //session.getTransaction().commit();
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
    
}
