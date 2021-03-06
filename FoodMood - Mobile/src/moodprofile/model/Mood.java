package moodprofile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Mood implements Serializable {
    public static final String[] possiblMoods = { "Happy", "Sad", "Sick",
        "Angry", "Upset"};
    private int id;
    private String name;
    private int moodScore;
    private GregorianCalendar time = new GregorianCalendar();
    private ArrayList<Integer> foodIDs = new ArrayList<>();

    
    /**
     * Default constructor for MoodProfileModel
     */
    public Mood(int id){
        this.id = id;
        foodIDs = new ArrayList();
        name = "No Name";
    }
    
    /**
     * 
     * @param id the id
     * @param name the name eg Happy
     * @param time the time entered
     */
    public Mood(int id, String name, int score){
        this.id = id;
        this.name = name;
        this.time = null;
    }
    
    public Mood(String mood, GregorianCalendar time) {
        this.name = mood;
        this.time = time;
    }
    
    /**
     * Get the id of the mood
     * @return the id
     */
    public int getID() {
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
     * @return the calendar
     */
    public GregorianCalendar getTime() {
        if(this.time==null){
            time = new GregorianCalendar();
        }
        return this.time;
    }
    
    /**
     * Sets the time of the Mood equal to the provided GregorianCalendar
     * @param time  the time to be set to
     */
    public void setTime(GregorianCalendar time) {
        this.time = time;
    }
    
    /**
     * returns all foods linked to this mood
     * @return the foodIDs
     */
    public ArrayList<Integer> getFoodIDs() {
        return foodIDs;
    }
    
    /**
     * returns a food linked to this mood given the index.
     * @param index the index of the food to get
     * @return the food's index
     */
    public int getFood(int index){
        return 1;
    }

    /**
     * adds all moods linked to this food
     * @param foodIDs the foodIDs to set
     */
    public void setFoodIDs(ArrayList<Integer> foodIDs) {
        this.foodIDs = foodIDs;
    }
    
    /**
     * deletes a food linked to this mood
     * @param toDelete the index of the food to delete
     */
    public void deleteFood(int toDelete){
        for (int i = 0; i < foodIDs.size(); i++) {
            if(foodIDs.get(i)==toDelete){
                foodIDs.remove(i);
                i--;
            }
        }
    }
    
    /**
     * adds a food linkage to this mood
     * @param toAdd the food to add
     */
    public void addFood(int toAdd){
        if(foodIDs ==null){
            foodIDs = new ArrayList();
        }
        foodIDs.add(toAdd);
    }
    
    public void printLinkedFoods(){
        System.out.print("\nFoods: ");
        for (int i = 0; i < foodIDs.size(); i++) {
            System.out.print(foodIDs.get(i)+", ");
        }
        System.out.println("\n");
    }
}
