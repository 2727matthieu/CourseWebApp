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
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class HibernateLocationDAO {

    public List<String> getAllLocationsHibernate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<String> listCities = new ArrayList<>();
        try {

            Query query = session.createQuery("from Location");
            List<Location> listLocations = query.list();

            Iterator it = listLocations.iterator();
            while (it.hasNext()) {

                Location c = (Location) it.next();
                listCities.add(c.getCity());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listCities;
    }
    
    List<CourseSession> courseSessions;
    
    public List<CourseSession> getAllCourseSessionsAtLocationHibernate(String location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from CourseSession cs where cs.location.city = :location";
            courseSessions = session.createQuery(hql).setParameter("location", location).list();
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
}
