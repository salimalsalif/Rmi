/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi.services;

import DAO.rmi.BooksInt;
import DAO.rmi.ClientInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class Cs extends UnicastRemoteObject implements ClientInt{

    public Cs() throws RemoteException {
        super();
    } 
    
    @Override
    public void insertData(Client cl) throws RemoteException {
        //StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Configuration conf = new Configuration(); 
         SessionFactory sf = conf.configure().buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
           ss.persist(cl);
            tx.commit(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> listAllCl() throws RemoteException {
         List<Client>cl = null;
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from Client");
           return q.list();    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Client cl) throws RemoteException {
         Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        ss.update(cl);
        tx.commit();
        ss.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteClient(Client c) throws RemoteException {
         Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        ss.delete(c);
        tx.commit();
        ss.close();//To change body of generated methods, choose Tools | Templates.
    }

}
