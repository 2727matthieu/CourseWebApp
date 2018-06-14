/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.repository.HibernateCourseSessionDAO;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="courseSessionService")
@ViewScoped
public class CourseSessionService implements Serializable{
    
    private List<CourseSession> courseSession;
    private String code = null;
    private String scode= null;
    private String selectedDate = null;

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }
    
    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

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
        scode = getParameter("scode");
        selectedDate = getParameter("date");
        
        if (code != null) {
            setCourseSession(getAllCourseSessions(getCode()));
            for (CourseSession cs : courseSession) {
                cs.setUse(cs.getClients().size());
                if (cs.getClients().size()>=cs.getMax()){
                    cs.setDisable("true");
                }
            }
        }
        if (scode != null && selectedDate == null) {
            setCourseSession(getAllCourseSessionsByName(getScode()));
            for (CourseSession cs : courseSession) {
                cs.setUse(cs.getClients().size());
                if (cs.getClients().size()>=cs.getMax()){
                    cs.setDisable("true");
                }
            }
        }
        if (selectedDate != null && scode == null) {
            setCourseSession(getAllCourseSessionsByDate(getSelectedDate()));
            for (CourseSession cs : courseSession) {
                cs.setUse(cs.getClients().size());
                if (cs.getClients().size()>=cs.getMax()){
                    cs.setDisable("true");
                }
            }
        }
        if (selectedDate != null && scode != null) {
            setCourseSession(getAllCourseSessionsByDateCode(getSelectedDate(),getScode()));
            for (CourseSession cs : courseSession) {
                cs.setUse(cs.getClients().size());
                if (cs.getClients().size()>=cs.getMax()){
                    cs.setDisable("true");
                }
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
    
    public List<CourseSession> getAllCourseSessionsByName(String code) {
        HibernateCourseSessionDAO hcsdao = new HibernateCourseSessionDAO();
        return hcsdao.getAllCoursesSessionsHibernate(code);
    }
    public List<CourseSession> getAllCourseSessionsByDate(String code) {
        HibernateCourseSessionDAO hcsdao = new HibernateCourseSessionDAO();
        try {
            return hcsdao.getAllCoursesSessionsDate( new SimpleDateFormat("yyyy-mm-dd").parse(code));
        } catch (ParseException ex) {
            Logger.getLogger(CourseSessionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //getAllCourseSessionsByDateCode
    public List<CourseSession> getAllCourseSessionsByDateCode(String date, String code) {
        HibernateCourseSessionDAO hcsdao = new HibernateCourseSessionDAO();
        try {
            return hcsdao.getAllCoursesSessionsDateCode( new SimpleDateFormat("yyyy-mm-dd").parse(date),code);
        } catch (ParseException ex) {
            Logger.getLogger(CourseSessionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public static String getParameter(String parameterName) {
        String parameter = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap()
            .get(parameterName);
        //System.out.println(parameter);
        if (parameter != null)
            return parameter;
        else
            return null;
        
    }
    
    
    
}
