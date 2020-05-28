/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.rmi;

import java.rmi.RemoteException;
import models.Loging;

/**
 *
 * @author Memento
 */
public interface LogInt {
    public void saveLogInfo(Loging l)throws RemoteException;
}
