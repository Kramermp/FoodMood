/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationprofile.model;

import java.util.GregorianCalendar;

/**
 *
 * @author HannahGarthwaite
 */
public class Notification {
    private int id;
    private String name;
    private String description;
    private GregorianCalendar timeIssued;
    private boolean read;

    
    public Notification(int id, String name, String description, GregorianCalendar timeIssued, boolean read){
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
    public GregorianCalendar getTimeIssued() {
        return timeIssued;
    }

    /**
     * @param timeIssued the timeIssued to set
     */
    public void setTimeIssued(GregorianCalendar timeIssued) {
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
