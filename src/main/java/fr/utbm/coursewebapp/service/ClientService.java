/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.Client;
import fr.utbm.coursewebapp.repository.HibernateClientDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ClientService {

    public void insertClientService(Client client) throws Exception {
        HibernateClientDAO hcd = new HibernateClientDAO();
        hcd.insertClientHibernate(client);
        
        try {
            hcd.insertClientHibernate(client);
        } catch (Exception ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

}
