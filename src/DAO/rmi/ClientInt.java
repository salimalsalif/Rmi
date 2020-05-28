/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi;

import java.rmi.RemoteException;
import java.util.List;
import models.Client;

/**
 *
 * @author Memento
 */
public interface ClientInt {
     public void insertData(Client cl)throws RemoteException;
    public List<Client>listAllCl()throws RemoteException;
     public void update(Client cl)throws RemoteException;
 public void deleteClient(Client c)throws RemoteException;
  
  
}
