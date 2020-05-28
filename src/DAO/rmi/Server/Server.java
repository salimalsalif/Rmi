/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi.Server;

import DAO.rmi.services.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import org.jboss.logging.Logger;

/**
 *
 * @author Memento
 */
public class Server{

    public Server() throws RemoteException {
        super();
    }
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1300);
            reg.rebind("BookCategory", new Bcs());
             reg.rebind("Books", new Bs());
              reg.rebind("Client", new Cs());
               reg.rebind("Checking", new Chs());
            JOptionPane.showMessageDialog(null, "Server is running");
        } catch (RemoteException e) {
        Logger.getLogger(Server.class.getName()).log(Logger.Level.FATAL, e);
        }
    }
//    @Override
//    public void insertData(BookCat b) throws RemoteException {
//         Configuration conf = new Configuration(); 
//         SessionFactory sf = conf.configure().buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = null;
//       try{
//           tx = ss.beginTransaction();
//           ss.persist(b);
//        }catch(Exception e){
//            if(tx!=null){
//                tx.rollback();
//            }
//        }finally{
//           tx.commit();
//        ss.close();
//       } //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<BookCat> listAllBc() throws RemoteException {
//         List<BookCat>b = null;
//        Configuration con = new Configuration().configure();
//        SessionFactory sf = con.buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//            Query q;
//        q = ss.createQuery("from BookCat");
//           return q.list();    //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void insertData(Books b) throws RemoteException {
//          StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//    Configuration conf = new Configuration(); 
//         SessionFactory sf = conf.configure().buildSessionFactory(ssr);
//        Session ss = sf.openSession();
//        Transaction tx = null;
//       try{
//           tx = ss.beginTransaction();
//           ss.persist(b);
//        }catch(Exception e){
//            if(tx!=null){
//                tx.rollback();
//            }
//        }finally{
//           tx.commit();
//        ss.close();
//       } //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Books> listAllBk() throws RemoteException {
//       List<Books>b = null;
//        Configuration con = new Configuration().configure();
//          StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//        SessionFactory sf = con.buildSessionFactory(ssr);
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//            Query q;
//        q = ss.createQuery("from Books");
//           return q.list();     //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void savetData(CheckIn chk) throws RemoteException {
//          Configuration conf = new Configuration(); 
//         SessionFactory sf = conf.configure().buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = null;
//       try{
//           tx = ss.beginTransaction();
//           ss.persist(chk);
//           tx.commit();
//        }catch(Exception e){
//            if(tx!=null){
//                tx.rollback();
//            }
//        }finally{
//           
//        ss.close();
//       } //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void exportData(JTable t, File f) throws IOException, RemoteException {
//       Checking check = new Checking();
//   TableModel model = check.checkTable.getModel();
//   FileWriter out = new FileWriter(f);
//        try (BufferedWriter bw = new BufferedWriter(out)) {
//            for(int i =0;i<model.getColumnCount();i++){
//                bw.write(model.getColumnName(i)+"\t");
//            }
//            bw.write("\n");
//            for(int i=0;i<model.getRowCount();i++){
//                for(int j =0;j<model.getColumnCount();j++){
//                    bw.write(model.getValueAt(i, j).toString()+" ");
//                }
//                bw.newLine();
//            }   
//        bw.close();
//        } //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<CheckIn> getAll() throws RemoteException {
//        List<CheckIn>cl = null;
//        Configuration con = new Configuration().configure();
//        SessionFactory sf = con.buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//            Query q;
//        q = ss.createQuery("from CheckIn");
//           return q.list();   //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void insertData(Client cl) throws RemoteException {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//    Configuration conf = new Configuration(); 
//         SessionFactory sf = conf.configure().buildSessionFactory(ssr);
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//           ss.persist(cl);
//            tx.commit(); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Client> listAllCl() throws RemoteException {
//         List<Client>cl = null;
//        Configuration con = new Configuration().configure();
//        SessionFactory sf = con.buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//            Query q;
//        q = ss.createQuery("from Client");
//           return q.list();    //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void update(Client cl) throws RemoteException {
//         Configuration con = new Configuration().configure();
//        SessionFactory sf = con.buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//        ss.update(cl);
//        tx.commit();
//        ss.close(); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void deleteClient(Client c) throws RemoteException {
//         Configuration con = new Configuration().configure();
//        SessionFactory sf = con.buildSessionFactory();
//        Session ss = sf.openSession();
//        Transaction tx = ss.beginTransaction();
//        ss.delete(c);
//        tx.commit();
//        ss.close();//To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveLogInfo(Loging l) throws RemoteException {
//        Configuration con = new Configuration().configure();
//       SessionFactory sf = con.buildSessionFactory();
//       Session ss = sf.openSession();
//       Transaction tx = ss.beginTransaction();
//       ss.save(l);
//       tx.commit();
//       ss.close(); //To change body of generated methods, choose Tools | Templates.
//    }
//    

 
}
