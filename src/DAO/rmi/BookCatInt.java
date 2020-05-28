/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi;

import java.rmi.RemoteException;
import java.util.List;
import models.BookCat;

/**
 *
 * @author Memento
 */
public interface BookCatInt {
     public void insertData(BookCat b) throws RemoteException;

    public List<BookCat> listAllBc() throws RemoteException;

}
