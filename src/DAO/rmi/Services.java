/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi;

import forms.Checking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import models.BookCat;
import models.Books;
import models.CheckIn;
import models.Client;
import models.Loging;
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
public class Services extends UnicastRemoteObject implements  ClientInt,CheckInt,LogInt,BookCatInt,BooksInt{

    public Services() throws RemoteException {
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

    @Override
    public void savetData(CheckIn chk) throws RemoteException {
          Configuration conf = new Configuration(); 
         SessionFactory sf = conf.configure().buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = null;
       try{
           tx = ss.beginTransaction();
           ss.persist(chk);
           tx.commit();
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
           
        ss.close();
       } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportData(JTable t, File f) throws IOException, RemoteException {
        try {
            Checking check = new Checking();
            TableModel model = check.checkTable.getModel();
            FileWriter out = new FileWriter(f);
            try (BufferedWriter bw = new BufferedWriter(out)) {
                for(int i =0;i<model.getColumnCount();i++){
                    bw.write(model.getColumnName(i)+"\t");
                }
                bw.write("\n");
                for(int i=0;i<model.getRowCount();i++){
                    for(int j =0;j<model.getColumnCount();j++){
                        bw.write(model.getValueAt(i, j).toString()+" ");
                    }
                    bw.newLine();
                }
                bw.close();
            } //To change body of generated methods, choose Tools | Templates.  catch (NotBoundException ex) {
           
        } catch (NotBoundException e) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, e);
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CheckIn> getAll() throws RemoteException {
        List<CheckIn>cl = null;
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from CheckIn");
           return q.list();   //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertData(Client cl) throws RemoteException {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Configuration conf = new Configuration(); 
         SessionFactory sf = conf.configure().buildSessionFactory(ssr);
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

    @Override
    public void saveLogInfo(Loging l) throws RemoteException {
        Configuration con = new Configuration().configure();
       SessionFactory sf = con.buildSessionFactory();
       Session ss = sf.openSession();
       Transaction tx = ss.beginTransaction();
       ss.save(l);
       tx.commit();
       ss.close(); //To change body of generated methods, choose Tools | Templates.
    }
    

}
