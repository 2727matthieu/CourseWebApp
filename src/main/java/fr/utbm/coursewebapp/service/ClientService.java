/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.Client;
import fr.utbm.coursewebapp.repository.HibernateClientDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="inscription")
@ViewScoped
public class ClientService implements Serializable{
    
    private Client client = new Client();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public ClientService(){
        init();
    }
    
    private synchronized void init(){
        client.setCourseSession(new CourseSessionService().getCourseSessionById(Integer.parseInt(getParameter("id"))));
    }

    public void insertClientService(Client client) throws Exception {
        HibernateClientDAO hcd = new HibernateClientDAO();
        hcd.insertClientHibernate(client);
    }
    
    public void insertClientService(ActionEvent event){
        HibernateClientDAO hcd = new HibernateClientDAO();
        hcd.insertClientHibernate(client);
        client.clear();
    }
    
    public static String getParameter(String parameterName) {
        String parameter = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap()
            .get(parameterName);
        
        return parameter;
    }
    

}
