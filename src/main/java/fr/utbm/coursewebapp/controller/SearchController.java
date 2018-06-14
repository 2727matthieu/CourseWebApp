/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.controller;

/**
 *
 * @author matbo
 */
import fr.utbm.coursewebapp.service.CourseSessionService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.icefaces.ace.event.DateSelectEvent;

@ManagedBean(name= SearchController.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class SearchController implements Serializable{
   
    public static final String BEAN_NAME = "search";
    public String getBeanName() { return BEAN_NAME; }

    private Date selectedDate;
    private boolean enabled = true;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void dateSelectListener(DateSelectEvent event) {
        this.selectedDate = event.getDate();
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }
    
    public boolean getEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String redirect(){
        //init();
       String tmp = null;
        if (selectedDate != null){
            tmp = new SimpleDateFormat("yyyy-mm-dd").format(selectedDate);
        }
        if (tmp != null && name == null){
            return "CourseSession.xhtml?date="+ tmp +"&faces-redirect=true";
        }
        if (name != null && tmp == null){
            return "CourseSession.xhtml?scode="+name+"&faces-redirect=true";
        }
        if (name != null && tmp != null){
            return "CourseSession.xhtml?scode="+name+"&date="+ tmp +"&faces-redirect=true";
        }
        return "Course.xhtml?faces-redirect=true";
    }
    
    public static String getParameter(String parameterName) {
        String parameter = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap()
            .get(parameterName);
        
        return parameter;
    }
    
    
}

