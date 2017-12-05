/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationprofile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author HannahGarthwaite
 */
public class Notification implements Serializable {
    private int id;
    private String name;
    private String description;
    private Date timeIssued;
    private boolean read;

    /**
     * Default constructor
     * @param id id
     * @param name title
     * @param description description
     * @param timeIssued time
     * @param read boolean if it's been read
     */
    public Notification(int id, String name, String description, Date timeIssued, boolean read){
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeIssued = timeIssued;
        this.read = read;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    public String getTimeString(){
        return timeIssued.getMonth()+"/"+timeIssued.getDate()+" "+timeIssued.getHours()+":"+timeIssued.getMinutes();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the timeIssued
     */
    public Date getTimeIssued() {
        return timeIssued;
    }

    /**
     * @param timeIssued the timeIssued to set
     */
    public void setTimeIssued(Date timeIssued) {
        this.timeIssued = timeIssued;
    }

    /**
     * @return the read
     */
    public boolean isRead() {
        return read;
    }

    /**
     * @param read the read to set
     */
    public void setRead(boolean read) {
        this.read = read;
    }
    
}
