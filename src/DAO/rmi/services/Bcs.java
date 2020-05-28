/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi.services;

import DAO.rmi.BookCatInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import models.BookCat;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Memento
 */
public class Bcs extends UnicastRemoteObject implements BookCatInt{

    public Bcs() throws RemoteException {
        super();
    }
    
     @Override
     public void insertData(BookCat b) throws RemoteException {
         Configuration conf = new Configuration(); 
         SessionFactory sf = conf.configure().buildSessionFactory();
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
    public List<BookCat> listAllBc() throws RemoteException {
         List<BookCat>b = null;
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from BookCat");
           return q.list();    //To change body of generated methods, choose Tools | Templates.
    }
}
