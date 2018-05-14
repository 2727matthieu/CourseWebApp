/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.repository;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ali
 */
public class HibernateCourseSessionDAO {
    
     public CourseSession getCourseSessionById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CourseSession as courseSession where courseSession.id=?");
        query.setInteger(0,id);
        CourseSession cs=(CourseSession) query.uniqueResult();
        return cs;
        
    }
    
}
