package moodprofile.model;

import java.util.GregorianCalendar;

public class MoodProfileModel {
    private int id;
    private String name;
    private int moodScore;
    private GregorianCalendar time = new GregorianCalendar();

    
    /**
     * Default constructor for MoodProfileModel
     */
    public MoodProfileModel(){
        
    }
    
    /**
     * Get the id of the mood
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set or change the id of the mood
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the mood
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set or change the name of the mood
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the Mood Score associated with the mood
     * @return the moodScore
     */
    public int getMoodScore() {
        return moodScore;
    }

    /**
     * Set or change the Mood Score associated with the mood
     * @param moodScore the moodScore to set
     */
    public void setMoodScore(int moodScore) {
        this.moodScore = moodScore;
    }
    
    /**
     * Gets the time of the Mood as a GregorianCalendar
     * @return 
     */
    public GregorianCalendar getTime() {
        return this.time;
    }
    
    /**
     * Sets the time of the Mood equal to the provided GregorianCalendar
     * @param time 
     */
    public void setTime(GregorianCalendar time) {
        this.time = time;
    }
}
