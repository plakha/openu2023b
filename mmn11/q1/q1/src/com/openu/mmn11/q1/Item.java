package com.openu.mmn11.q1;

/**
 * Represents Item in a bill entry
 */
public class Item {

    static private int anticipatedItemNameLen = 10; //this will change as new items are recognized./
    private final String name;
    private final double price;

    /**
     *
     * @param name non-null
     * @param price non-negative
     */
    public Item(String name, double price) {
        if (null == name) {
            throw new IllegalArgumentException("The Item's name should be a non-null String");
        } else if (price < 0) {
            throw new IllegalArgumentException("The Item's price should be non-negative");
        }
        this.name = name;
        this.price = price;

        anticipatedItemNameLen = (anticipatedItemNameLen + name.length()) / 2;
    }

    /**
     * Copy constructor
     * @param other item - non-null
     */
    public Item(Item other){
        if (null == other) {
            throw new IllegalArgumentException("Please pass non-null item");
        }

        this.name = other.name;
        this.price = other.price;
    }

    /**
     *
     * @return the Items price
     */
    public double getPrice(){return this.price;}

    /**
     *
     * @return the items name
     */
    public String getName(){return this.name;}

    /**
     *
     * @return an estimation of item length (can be used for StringBuilder)
     */
    public static int getAnticipatedItemNameLen(){return anticipatedItemNameLen;}

    @Override
    public boolean equals(Object other){
        if (null == other) {
            return false;
        } else if (this == other) {
            return true;
        } else if (other instanceof Item) {
            final Item otherItem = (Item) other;
            return this.name.equals(otherItem.name) && this.price == otherItem.price;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + (int) this.price;
    }

    @Override
    public String toString(){
        return String.format("%s: %.2f", this.name, this.price);
    }
}
