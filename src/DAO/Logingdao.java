/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import models.Loging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Memento
 */
public class Logingdao {
    public Logingdao(){
        
    }
    public void saveLogInfo(Loging l){
       Configuration con = new Configuration().configure();
       SessionFactory sf = con.buildSessionFactory();
       Session ss = sf.openSession();
       Transaction tx = ss.beginTransaction();
       ss.save(l);
       tx.commit();
       ss.close();
    }
    
}
