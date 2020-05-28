/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import forms.Checking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import models.CheckIn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Memento
 */
public class CheckingDao {
    public  CheckingDao(){
        
    }
    public void savetData(CheckIn chk){
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
       }
    }
     public void exportData(JTable t,File f) throws IOException, RemoteException, NotBoundException{
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
        }
}

    /**
     *
     * @return
     */
    public List<CheckIn>getAll(){
        List<CheckIn>cl = null;
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
            Query q;
        q = ss.createQuery("from CheckIn");
           return q.list();  
          
    }
     
     
}
