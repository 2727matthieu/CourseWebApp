/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coursewebapp.service;

import fr.utbm.coursewebapp.entity.CourseSession;
import fr.utbm.coursewebapp.repository.HibernateCourseSessionDAO;


public class CourseSessionService {
    public CourseSession getCourseSessionById(int id) {
        HibernateCourseSessionDAO hcsd = new HibernateCourseSessionDAO();
        return hcsd.getCourseSessionById(id);
    }
}
