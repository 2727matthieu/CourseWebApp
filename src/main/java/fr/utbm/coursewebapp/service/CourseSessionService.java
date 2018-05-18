/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.repository.HibernateCourseDAO;
import fr.utbm.coursewebapp.repository.HibernateCourseSessionDAO;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="courseSessionService")
@ViewScoped
public class CourseSessionService implements Serializable{
    
    private List<CourseSession> courseSession;

    public List<CourseSession> getCourseSession() {
        System.out.println("!!!!!!!!!!!!! 22222 !!!!!!!!!!!!!");
        return courseSession;
    }

    public void setCourseSession(List<CourseSession> courseSession) {
        System.out.println("!!!!!!!!!!!!! 1111 !!!!!!!!!!!!!");
        this.courseSession = courseSession;
        //System.out.println(courseSession.toString());
    }
    
    public CourseSessionService(){
        System.out.println("!!!!!!!!!!!!! TEST !!!!!!!!!!!!!");
        //setCourseSession(getAllCourseSessions(getParameter("code"))); 
    }
    
    public CourseSession getCourseSessionById(int id) {
        HibernateCourseSessionDAO hcsd = new HibernateCourseSessionDAO();
        return hcsd.getCourseSessionById(id);
    }
    
    public List<CourseSession> getAllCourseSessions(String code) {
        HibernateCourseSessionDAO hcsdao = new HibernateCourseSessionDAO();
        return hcsdao.getAllCourseSessions(code);
    }
    public static String getParameter(String parameterName) {
        String parameter = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap()
            .get(parameterName);
        
        return parameter;
    }
    
    
}
