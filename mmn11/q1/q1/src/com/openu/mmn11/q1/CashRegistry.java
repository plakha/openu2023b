package com.openu.mmn11.q1;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents cas registry
 */
public class CashRegistry {
    private double balance = 0;
    private List<BillEntry> bill = new ArrayList<>();

    /**
     * construct cash registry with initial balance 0
     */
    public CashRegistry(){
        this(0.0);
    }

    /**
     *
     * @param initialBalance - initial balance
     *  construct cash registry with initial balance 0
     */
    public CashRegistry(double initialBalance){
        this.balance = initialBalance;
    }

    /**
     * Create bill entry with number of items, add to bill return the bill entry
     * @param item - the checked item non-null
     * @param number - number of checked items non-negative
     * @return the bill entry containing the number of items
     */
    public BillEntry checkItem(Item item, int number){
        if (null == item){
            throw new IllegalArgumentException("Please pass non-null item object");
        } else if (number < 0) {
            throw new IllegalArgumentException("Please pass non-negative number value");
        }
        final BillEntry billEntry = new BillEntry(item, number);
        checkItem(billEntry);

        return billEntry;
    }

    /**
     * Create bill entry with number of items, add to bill, return the bill entry
     * @param billEntry - non-null
     * @return the bill entry
     */
    public BillEntry checkItem(BillEntry billEntry){
        if (null == billEntry){
            throw new IllegalArgumentException("Please pass non-null bill entry");
        }
        bill.add(billEntry);

        return billEntry;
    }

    /**
     *
     * @return is the Cash Registry checked out (ready for a new bill)
     */
    public boolean isCheckedOut(){
        return bill.isEmpty();
    }

    /**
     *
     * @return ";"-separated String representation of the current bill entries. Each entry is "Item name;number of items;total for entry"
     */
    @Override
    public String toString(){
        final StringBuilder stringBuilder = new StringBuilder(bill.size() * Item.getAnticipatedItemNameLen());

        for (final BillEntry billEntry : bill) {
            final Item item = billEntry.getItem();
            stringBuilder.append(item.getName() + ";" + billEntry.getNumber() + ";" + billEntry.getTotal() + "\n");
        }

        return stringBuilder.toString();
    }


    /**
     *
     * @return the total that needs to be paid for the bill
     */
    public double getTotal(){
        double total = 0.0;

        for (final BillEntry billEntry : bill) {
            total += billEntry.getTotal();
        }

        return total;
    }

    /**
     * Get payment, return change, empty the bill. In case the payment is not enough - returns the payment to customer.
     * @param cash - the customer gave for the bill. Expected to be greater or equal to the bill's total
     * @return the change or the whole payment
     */
    public double checkOut(double cash) {
        final double change = getChange(cash);

        if (0.0 <= change){
            this.balance += getTotal();
            emptyBill();

            return change;
        } else {
            return cash;
        }
    }

    /**
     *
     * @return the balance in the Cash Registry
     */
    public double getBalance(){
        return balance;
    }

    private double getChange(double cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("Please pass non-negative");
        }
        final double total = getTotal();

        return cash - total;
    }

    private void emptyBill(){bill = new ArrayList<>();}


    /**
     * removes all the entries from the bill without paying
     */
    public void cancelBill(){
        emptyBill();
    }

    @Override
    public boolean equals(Object other){
        if (null == other){
            return false;
        } else if (this == other){
            return true;
        } else if (other instanceof CashRegistry){
            return this.bill.equals(other)
                    && Math.round(this.balance * 100.0) / 100.0
                    == Math.round(((CashRegistry)other).balance * 100.0) / 100.0;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){

        return this.bill.hashCode() + (int)this.balance;
    }
}


