package com.openu.mmn11.q1;

/**
 *  Represents a bill entry.
 */
public class BillEntry {
    private Item item;
    private int number;

    /**
     * Construct a bill entry with item and number of items
     * @param item - non-null
     * @param number - positive
     */
    public BillEntry(Item item, int number){
        if (null == item) {
            throw new IllegalArgumentException("Please pass non-null Item");
        } else if (number <= 0) {
            throw  new IllegalArgumentException("Only positive number of items is allowed");
        }

        this.item = new Item(item);
        this.number = number;
    }

    /**
     * Construct a bill entry with item name, item price and number of items
     * @param itemName
     * @param itemPrice
     * @param number
     */
    public BillEntry(String itemName, double itemPrice, int number){
        this(new Item(itemName, itemPrice), number);
    }

    /**
     * Copy constructor
     * @param other - non-null
     */
    public BillEntry(BillEntry other){
        this(other.getItem(), other.getNumber());
    }

    /**
     *
     * @return the total price of the bill entry
     */
    public double getTotal(){
        return this.number * item.getPrice();
    }

    /**
     *
     * @return the item
     */
    public Item getItem(){return new Item(item);}

    public int getNumber(){return number;}

    /**
     * String representation of the bill entry
     * @return String representation of the bill entry
     */
    @Override
    public String toString(){
        return String.format("%s %d", item.getName(), number);
    }

    /**
     * Compare two bill entries
     * @param other - non-null
     * @return true if the bill entries are equal, false otherwise
     */
    @Override
    public boolean equals(Object other){
        if (null == other){
            return false;
        } else if (this == other){
            return true;
        } else if (other instanceof BillEntry){
            final BillEntry otherBillEntry = (BillEntry)other;
            return this.item.equals(otherBillEntry.item) && this.number == otherBillEntry.number;
        } else {
            return false;
        }
    }

    /**
     * Hash code of the bill entry
     * @return hash code of the bill entry
     */
    @Override
    public int hashCode(){
        return item.hashCode() + number;
    }
}
