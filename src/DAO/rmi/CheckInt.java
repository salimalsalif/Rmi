/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JTable;
import models.CheckIn;

/**
 *
 * @author Memento
 */
public interface CheckInt {
     public void savetData(CheckIn chk) throws RemoteException;
 public List<CheckIn>getAll()throws RemoteException;
    public void exportData(JTable t, File f) throws IOException, RemoteException;

}
