/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi.services;

import DAO.rmi.BooksInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class Bs  extends UnicastRemoteObject implements BooksInt{

    public Bs() throws RemoteException {
        super();
    }
    
    
     @Override
    public void insertData(Books b) throws RemoteException {
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
       } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Books> listAllBk() throws RemoteException {
       List<Books>b = null;
        Configuration con = new Configuration().configure();
          StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        SessionFactory sf = con.buildSessionFactory(ssr);
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from Books");
           return q.list();     //To change body of generated methods, choose Tools | Templates.
    }

}
