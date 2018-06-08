/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.repository.HibernateCourseSessionDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="courseSessionService")
@ViewScoped
public class CourseSessionService implements Serializable{
    
    private List<CourseSession> courseSession;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public List<CourseSession> getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(List<CourseSession> courseSession) {
        this.courseSession = courseSession;
    }
    
    public CourseSessionService(){
        init();
    }
    private synchronized void init() {
        code = getParameter("code");
        setCourseSession(getAllCourseSessions(getCode()));
        for (CourseSession cs : courseSession) {
            cs.setUse(cs.getClients().size());
            if (cs.getClients().size()<=cs.getMax()){
                cs.setDisable("true");
            }
        }
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
