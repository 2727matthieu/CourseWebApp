/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.repository.HibernateLocationDAO;
import java.util.List;


public class LocationService {

    public List<String> getAllLocationsService() {
        HibernateLocationDAO hld = new HibernateLocationDAO();
        return hld.getAllLocationsHibernate();
    }
}
