package com.example.rucafe;

import java.util.ArrayList;


/**
 * This class extends the MenuItem class and represents a coffee order, including the size, amount, and any add-ins.
 * @author Luca Vespa, Chinmay Rajanahalli
 */
public class Coffee extends MenuItems {

    public static final double SHORT_PRICE = 1.89;
    public static final double TALL_PRICE = 2.29;
    public static final double GRANDE_PRICE = 2.69;
    public static final double VENTI_PRICE = 3.09;
    public static final double ADD_INS_PRICE = 0.30;

    private String size;
    private ArrayList<String> addOns;
    private int quantity;
    private int itemNum;


    /**
     * Constructor for when all parameters are provided.
     * @param size the size of cup
     * @param addOns an ArrayList of the coffee's add-ins
     * @param quantity the amount of coffees that will be ordered
     * @param itemNum a number used to keep track of separate orders with the same properties
     */
    public Coffee (String size, ArrayList<String> addOns, int quantity, int itemNum) {
        this.size = size;
        this.addOns = addOns;
        this.quantity = quantity;
        this.itemNum = itemNum;
    }

    /**
     * Gets the amount of coffees in the coffee order and returns it as an integer.
     * @return the amount of coffees
     */
    @Override
    public int getQauntity() {
        return quantity;
    }

    /**
     * Gets all the coffee's add-ins as an ArrayList of Strings.
     * @return the ArrayList of the add-ins
     */
    public ArrayList<String> getAddOns() {
        return addOns;
    }

    /**
     * Gets the unique number identifier for the coffee order and returns it as an integer.
     * @return the item number
     */
    public int getItemNum() {
        return itemNum;
    }


    /**
     * Gets the size of the cup as a String.
     * @return the size of the cup
     */
    public String getSize() {
        return size;
    }





    /**
     * Calculates the price of an individual coffee using the size and amount of add-ins.
     * @return the price of an individual coffee with the corresponding attributes
     */
    @Override
    public double itemPrice(){
        double price = 0.0;
        switch(size){
            case "Short":
                price=SHORT_PRICE;
                break;
            case "Tall":
                price=TALL_PRICE;
                break;
            case "Grande":
                price=GRANDE_PRICE;
            case "Venti":
                price=VENTI_PRICE;
                break;
        }
        return price + (ADD_INS_PRICE* addOns.size());
    }

    /**
     * An override of the equals method.
     * @param obj an Object expected to be of type Coffee
     * @return true if the two Coffees are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coffee)) {
            return false;
        }
        Coffee checkCoffee = (Coffee) obj;
        Boolean equalAddIns = checkCoffee.getAddOns().contains(this.addOns) && this.addOns.contains(checkCoffee.getAddOns());
        if(equalAddIns && checkCoffee.getQauntity() == this.quantity && checkCoffee.getSize().equals(this.size) && checkCoffee.getItemNum() == this.itemNum){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * An override of the toString method.
     * @return a String representation of the coffee order
     */
    @Override
    public String toString() {
        String addInsString = "";
        for(int i = 0; i < addOns.size(); i++) {
            addInsString = addInsString + addOns.get(i);
            if (i != addOns.size() - 1)
                addInsString += ", ";

        }

        return getSize() + " Coffee " + addInsString + "(" + getQauntity() + ") " + "Price: $" + String.format("%.2f", itemPrice()*quantity);
    }

}
