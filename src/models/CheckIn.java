/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Memento
 */
@Entity
public class CheckIn implements Serializable {
    private String borrowedOn;
    private String status;
    private String taker;
    @Id
    private String bookIn;

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the taker
     */
    public String getTaker() {
        return taker;
    }

    /**
     * @param taker the taker to set
     */
    public void setTaker(String taker) {
        this.taker = taker;
    }

    /**
     * @return the bookIn
     */
    public String getBookIn() {
        return bookIn;
    }

    /**
     * @param bookIn the bookIn to set
     */
    public void setBookIn(String bookIn) {
        this.bookIn = bookIn;
    }

    public String getBorrowedOn() {
        return borrowedOn;
    }

    public void setBorrowedOn(String borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    /**
     * @param time the time to set
     */
   
}
