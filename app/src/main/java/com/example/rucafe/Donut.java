package com.example.rucafe;

import java.text.DecimalFormat;

/**
 * This class extends the MenuItem class and represents a donut order, including the type of donut, the flavor, and the amount.
 * @author Luca Vespa, Chinmay Rajanahalli
 */
public class Donut extends MenuItems {

    DecimalFormat df = new DecimalFormat("#.##");
    private int qauntity;
    private String type;
    private String flavor;
    public int itemNum;

    public static final double CAKE_COST = 1.79;
    public static final double DONUT_HOLES_COST = 0.39;
    public static final double YEAST_COST = 1.59;



    /**
     * Constructor for when all parameters are provided.
     * @param type the type of donut
     * @param quantity the amount of donuts in the order
     * @param flavor the flavor of the donut
     * @param itemNum a number used to keep track of separate orders with the same properties
     */
    public Donut(String type, int quantity, String flavor, int itemNum) {
        this.flavor = flavor;
        this.itemNum = itemNum;
        this.qauntity = quantity;
        this.type = type;

    }

    /**
     * Gets the type of donut and returns it as a String.
     * @return the type of donut
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the flavor of the donut and returns it as a String.
     * @return
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Gets the unique number identifier for the donut order and returns it as an integer.
     * @return the item number
     */
    public int getItemNum() {
        return itemNum;
    }

    /**
     * Gets the amount of Donuts in the donut order and returns it as an integer.
     * @return the amount of donuts in the order
     */
    @Override
    public int getQauntity() {
        return qauntity;
    }

    /**
     * Increases the amount of donuts in the order and caps it at 100.
     * @param amount the amount of donuts that are added to the total amount
     */


    /**
     * A version of the toString method meant exclusively for the Ordering Donuts View.
     * @return a string representation of the donut
     */
    public String toStringDonutView() {
        String name;

        switch(type){
            case "Yeast Donuts":
                name = "(Yeast) ";
                break;
            case "Cake Donuts":
                name = "(Cake) ";
                break;
            default:
                name = "(Donut Hole) ";

        }
        return name + flavor;
    }

    /**
     * An override of the toString method.
     * @return a String representation of the Donut order
     */
    @Override
    public String toString() {
        return flavor + " " + type + " (" + qauntity + ") Price: $" + df.format(itemPrice()* qauntity);
    }

    /**
     * An override of the equals method.
     * @param obj an Object expected to be of type Donut
     * @return true if the two Donuts are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Donut)) {
            return false;
        }
        Donut checkDonut = (Donut) obj;
        if(checkDonut.getQauntity() == this.qauntity && checkDonut.getFlavor().equals(this.flavor) && checkDonut.getType().equals(this.type)
                && checkDonut.getItemNum() == this.itemNum) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Calculates the price of an individual donut based on the type of donut.
     * @return the price of an individual donut with the corresponding attributes
     */
    @Override
    public double itemPrice(){
        if (type.equals("Yeast Donuts"))
            return YEAST_COST;

        if (type.equals("Cake Donuts"))
            return CAKE_COST;

        return DONUT_HOLES_COST;
    }


}
