/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.entity.Location;
import fr.utbm.coursewebapp.repository.HibernateLocationDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="locationService")
@ViewScoped
public class LocationService  implements Serializable{

    private List<CourseSession> courseSession;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<CourseSession> getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(List<CourseSession> courseSession) {
        this.courseSession = courseSession;
    }
    
    public List<String> getAllLocationsService() {
        HibernateLocationDAO hld = new HibernateLocationDAO();
        return hld.getAllLocationsHibernate();
    }
    
    public List<CourseSession> getAllCoursesSessionAtLocationService(String location) {
        HibernateLocationDAO locationDAO = new HibernateLocationDAO();
        return locationDAO.getAllCourseSessionsAtLocationHibernate(location);
    }
    
    public LocationService(){
        init();
    }
    private synchronized void init() {
        city = getParameter("city");
        setCourseSession(getAllCoursesSessionAtLocationService(city));
        for (CourseSession cs : courseSession) {
            cs.setUse(cs.getClients().size());
            if (cs.getClients().size()>=cs.getMax()){
                cs.setDisable("true");
            }
        }
    }
    
    public static String getParameter(String parameterName) {
        String parameter = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap()
            .get(parameterName);
        
        return parameter;
    }
}
