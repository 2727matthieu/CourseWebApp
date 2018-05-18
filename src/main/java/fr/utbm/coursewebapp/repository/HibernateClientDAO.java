/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.repository;

import fr.utbm.coursewebapp.entity.Client;
import fr.utbm.coursewebapp.util.HibernateUtil;
import org.hibernate.Session;


public class HibernateClientDAO {

    public void insertClientHibernate(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(client);
        session.getTransaction().commit();
    }

}
