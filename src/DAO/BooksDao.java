/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Books;
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
public class BooksDao {
    public BooksDao(){
        
    }
    public void insertData(Books b){
          StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Configuration conf = new Configuration(); 
         SessionFactory sf = conf.configure().buildSessionFactory(ssr);
        Session ss = sf.openSession();
        Transaction tx = null;
       try{
           tx = ss.beginTransaction();
           ss.persist(b);
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
           tx.commit();
        ss.close();
       }
    }
    
    public List<Books>listAll(){
        List<Books>b = null;
        Configuration con = new Configuration().configure();
          StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        SessionFactory sf = con.buildSessionFactory(ssr);
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from Books");
           return q.list();    
    }
    public List<Books>search(){
          List<Books>b = null;
        Configuration con = new Configuration().configure();
          StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        SessionFactory sf = con.buildSessionFactory(ssr);
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from Books where ");
           return q.list();   
    }
}
