package foodprofile.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class FoodProfileModel {
    private int id;
    private String name;
    private ArrayList<String> foodCategories;
    private GregorianCalendar time;
    private ArrayList<Integer> moods;
    
    /**
     * Default constructor for FoodProfileModel
     */
    public FoodProfileModel(){
        
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
     * @return the foodCategories
     */
    public ArrayList<String> getFoodCategories() {
        return foodCategories;
    }

    /**
     * This method sets the categories this food belongs to. A food item may belong to multiple categories.
     * @param foodCategories the foodCategories to set
     */
    public void setFoodCategories(ArrayList<String> foodCategories) {
        this.foodCategories = foodCategories;
    }
    
    /**
     * This method adds a food category to a food profile
     * @param foodCategory to add
     */
    public void addFoodCategory(String foodCategory){
        
    }
    
    /**
     * Gets the time of the Food as a GregorianCalendar
     * @return 
     */
    public GregorianCalendar getTime() {
        return this.time;
    }
    
    /**
     * Sets the time equal to the Provided GregorianCalendar
     * @param time 
     */
    public void setTime(GregorianCalendar time) {
        this.time = time;
    }
    
        /**
     * This method retrieves all moods this food is linked to
     * @return the moods
     */
    public ArrayList<Integer> getMoods() {
        return moods;
    }

    /**
     * This method adds linked moods to this food
     * @param moods the moods to set
     */
    public void setMoods(ArrayList<Integer> moods) {
        this.moods = moods;
    }
        
    /**
     * This method deletes a mood linked to this food
     * @param toDelete 
     */
    public void deleteMood(int toDelete){
        
    }
    
    /**
     * This method returns a mood linked to this food, given its index in the ArrayList of moodIDs
     * @param index
     * @return 
     */
    public int getMood(int index){
        return moods.get(index);
    }



}
