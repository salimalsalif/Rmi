/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class BookCatDao {
    public BookCatDao(){
        
    }
    public void insertData(BookCat b){
        
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
       }
    }
    
    public List<BookCat>listAll(){
        List<BookCat>b = null;
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from BookCat");
           return q.list();    
    }
}
