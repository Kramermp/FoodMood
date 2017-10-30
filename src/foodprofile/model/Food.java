package foodprofile.model;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Food {
    private int id;
    private String name = "No Name";
    private ArrayList<String> foodCategories = new ArrayList<String>();
    private GregorianCalendar time = new GregorianCalendar();
    private ArrayList<Integer> moods = new ArrayList<Integer>();
    
    /**
     * Default constructor for FoodProfileModel
     */
    public Food(int id, String name, String foodCategory, GregorianCalendar time){
        this.id = id;
        this.name = name;
        this.foodCategories = new ArrayList();
        foodCategories.add(foodCategory);
        this.time = time;
    }
    
    public Food(){
        System.out.println("New Food Created //TODO impelement default constructor");
    }
    
    //TODO: Add other constructors for food
    
    /**
     * @return the id
     */
    public int getID() {
        return id;
    }
    
    //This agruablly should not be included
    /**
     * @param id the id to set
     */
    public void setID(int id) {
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
        if(foodCategories == null || foodCategories.size()==0){
            foodCategories = new ArrayList();
            foodCategories.add("Dairy");
        }
        return foodCategories;
    }

    /**
     * This method sets the categories this food belongs to. A food item may belong to multiple categories.
     * @param foodCategories the foodCategories to set
     */
    public void setFoodCategories(ArrayList<String> foodCategories) {
        this.foodCategories = foodCategories;
    }
    public void setFoodCategory(String foodCategory){
        foodCategories = new ArrayList();
        foodCategories.add(foodCategory);
    }
    
    /**
     * This method adds a food category to a food profile
     * @param foodCategory to add
     */
    public void addFoodCategory(String foodCategory){
        foodCategories.add(foodCategory);
    }
    
    /**
     * Gets the time of the Food as a GregorianCalendar
     * @return the Calendar return
     */
    public GregorianCalendar getTime() {
        return this.time;
    }
    
    /**
     * Sets the time equal to the Provided GregorianCalendar
     * @param time time to be set
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
     * @param toDelete mood to be delete
     */
    public void deleteMood(int toDelete){
        
    }
    
    /**
     * This method returns a mood linked to this food, given its index in the ArrayList of moodIDs
     * @param index mood to be returned
     * @return the mood index
     */
    public int getMood(int index){
        return moods.get(index);
    }
    
    public void deleteFoodCategory(String foodCategory) {
        foodCategories.remove(foodCategory);
    }
    
    public void addMood(Integer mood) {
        moods.add(mood);
    }



}
