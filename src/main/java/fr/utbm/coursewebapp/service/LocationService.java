/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.repository.HibernateLocationDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class LocationService  implements Serializable{

    public List<String> getAllLocationsService() {
        HibernateLocationDAO hld = new HibernateLocationDAO();
        return hld.getAllLocationsHibernate();
    }
}
