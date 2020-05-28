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
public class Client implements Serializable {
    @Id
    private String regNo;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String category;
    private String BookTitle;
    private String BookCategory;
    private String photo;

    /**
     * @return the regNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * @param regNo the regNo to set
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the BookTitle
     */
    public String getBookTitle() {
        return BookTitle;
    }

    /**
     * @param BookTitle the BookTitle to set
     */
    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    /**
     * @return the BookCategory
     */
    public String getBookCategory() {
        return BookCategory;
    }

    /**
     * @param BookCategory the BookCategory to set
     */
    public void setBookCategory(String BookCategory) {
        this.BookCategory = BookCategory;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String comboGet(){
    StringBuilder s = new StringBuilder();
    s.append(firstName);
    s.append(" ");
    s.append(lastName);
        return s.toString();
    
}
}