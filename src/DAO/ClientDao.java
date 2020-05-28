/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Memento
 */
public class ClientDao {
    public ClientDao(){
      
    }
    public void insertData(Client cl){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Configuration conf = new Configuration(); 
         SessionFactory sf = conf.configure().buildSessionFactory(ssr);
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
           ss.persist(cl);
            tx.commit();
     
    }
    
    public List<Client>listAll(){
        List<Client>cl = null;
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from Client");
           return q.list();    
    }
    public void update(Client cl){
     Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        ss.update(cl);
        tx.commit();
        ss.close();
}
    public void deleteClient(Client c){
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        ss.delete(c);
        tx.commit();
        ss.close();
    }
}