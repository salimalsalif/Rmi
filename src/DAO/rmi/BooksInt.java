/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi;

import java.rmi.RemoteException;
import java.util.List;
import models.Books;

/**
 *
 * @author Memento
 */
public interface BooksInt {
     public void insertData(Books b) throws RemoteException;

    public List<Books> listAllBk() throws RemoteException;

}
