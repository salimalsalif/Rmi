/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi.services;

import DAO.rmi.CheckInt;
import DAO.rmi.ClientInt;
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
public class Chs extends UnicastRemoteObject implements CheckInt {

    public Chs() throws RemoteException {
        super();
    }

    @Override
    public void savetData(CheckIn chk) throws RemoteException {
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = null;
        try {
            tx = ss.beginTransaction();
            ss.persist(chk);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {

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
                for (int i = 0; i < model.getColumnCount(); i++) {
                    bw.write(model.getColumnName(i) + "\t");
                }
                bw.write("\n");
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        bw.write(model.getValueAt(i, j).toString() + " ");
                    }
                    bw.newLine();
                }
                bw.close();
                
            }
        }   catch (NotBoundException ex) {
            Logger.getLogger(Chs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @Override
        public List<CheckIn> getAll() throws RemoteException {
            List<CheckIn> cl = null;
            Configuration con = new Configuration().configure();
            SessionFactory sf = con.buildSessionFactory();
            Session ss = sf.openSession();
            Transaction tx = ss.beginTransaction();
            Query q;
            q = ss.createQuery("from CheckIn");
            return q.list();   //To change body of generated methods, choose Tools | Templates.
        }
    }
