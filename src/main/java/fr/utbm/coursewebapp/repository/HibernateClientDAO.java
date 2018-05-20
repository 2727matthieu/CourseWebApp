/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.repository;

import fr.utbm.coursewebapp.entity.Client;
import fr.utbm.coursewebapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class HibernateClientDAO {

    public void insertClientHibernate(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(client);
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
    }

}
