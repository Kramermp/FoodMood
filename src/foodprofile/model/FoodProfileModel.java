package foodprofile.model;


import java.util.ArrayList;
import java.util.Date;

public class FoodProfileModel {
    private int id;
    private String name;
    private ArrayList<String> foodCategories;
    
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


}
