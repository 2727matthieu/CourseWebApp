/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.repository.HibernateCourseSessionDAO;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class CourseSessionService {
    
    private List<CourseSession> courseSession;

    public List<CourseSession> getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(List<CourseSession> courseSession) {
        this.courseSession = courseSession;
    }
    
    private void _init() throws Exception {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ex = fc.getExternalContext();
        HttpServletRequest rq = (HttpServletRequest) ex.getRequest();
        courseSession = new CourseService().getAllCourseSessions(rq.getParameter("code"));
        
        
    }
    
    public CourseSession getCourseSessionById(int id) {
        HibernateCourseSessionDAO hcsd = new HibernateCourseSessionDAO();
        return hcsd.getCourseSessionById(id);
    }
    
    
}
