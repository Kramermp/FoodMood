package foodprofile.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Food implements Serializable {
    private int id;
    private String name; //eg milk
    private ArrayList<String> foodCategories; //eg Dairy
    private GregorianCalendar time;
    private ArrayList<Integer> moods; //list of id's for moods linked to this mood
    
    /**
     * Creates food given id, name, foodCategory (single category) and time
     * Default constructor for FoodProfileModel
     * @param id
     * @param name
     * @param foodCategory
     * @param time
     */
    public Food(int id, String name, String foodCategory, GregorianCalendar time){
        this.id = id;
        this.name = name;
        this.foodCategories = new ArrayList();
        foodCategories.add(foodCategory);
        moods = new ArrayList();
        this.time = time;
    }
    
    /**
     * Creates food given id, name, foodCategory (single category) and time
     * Default constructor for FoodProfileModel
     * @param name
     * @param foodCategory
     * @param time
     */
    public Food(String name, String foodCategory, GregorianCalendar time){
        this.name = name;
        this.foodCategories = new ArrayList();
        foodCategories.add(foodCategory);
        moods = new ArrayList();
        this.time = time;
    }
    
    /**
     * Creates empty food for easy handling and testing
     */
    public Food(){
        foodCategories = new ArrayList();
        moods = new ArrayList();
        name = "No Name";
    }
    
    
    /**
     * get ID for food
     * @return the id
     */
    public int getID() {
        return id;
    }
 
    /**
     * Returns the name of the food eg Milk
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
    
    /**
     * Sets categories
     * @param foodCategory Sets the list of categories in the food given an arrayList of strings
     */
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
    
    /**
     * Given a food category, removes it from the list of categories
     * @param foodCategory food category to be added
     */
    public void deleteFoodCategory(String foodCategory) {
        foodCategories.remove(foodCategory);
    }
    
    /**
     * Adds the id of a mood to this food
     * @param mood Mood to be added
     */
    public void addMood(Integer mood) {
        moods.add(mood);
    }

    public void printLinkedMoods(){
        System.out.print("\n Moods: ");
        for (int i = 0; i < moods.size(); i++) {
            System.out.print(moods.get(i)+", ");
        }
        System.out.println("\n");
    }
    
    public void setID(int id){
        this.id = id;
    }

}
