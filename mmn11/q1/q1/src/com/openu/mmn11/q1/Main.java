package com.openu.mmn11.q1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //generate scan and print to add items to bill  and print the bill
        //Print welcome message
        System.out.println("Dear Cashier, welcome to the Cash Register");
        System.out.println("To start, please enter the initial balance of the cash register or press enter to start with 0");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double initialBalance = 0.0;
        try {
            initialBalance = Double.parseDouble(input);
        } catch( NumberFormatException e) {
            System.err.println("Input passed "+ input);
        }

        CashRegistry cashRegistry = new CashRegistry(initialBalance);

        //cash registry is on
        while (true) {
            if (!cashRegistry.isCheckedOut()) {
                //Print there is an unfinished bill
                System.out.println("There is an unfinished bill, please cancel it or pay it");
                System.out.println("Please type \"pay\" to pay or \"cancel\" to cancel");
                String payCancelInput = scanner.nextLine();
                if (payCancelInput.equals("pay")) {
                    System.out.println("Please enter the amount of money you are paying");
                    double amountPaid = Double.parseDouble(scanner.nextLine());
                    System.out.println("Your change is: " + cashRegistry.checkOut(amountPaid));
                } else if (payCancelInput.equals("cancel")) {
                    System.out.println("Your bill is cancelled");
                    cashRegistry.cancelBill();
                }
                if (!cashRegistry.isCheckedOut()) {
                    //The bill will be cancelled
                    System.out.println("Your bill is cancelled");
                    cashRegistry.cancelBill();
                }

            }

            //Print instructions
            while (true) {
                System.out.println("Please scan items using the following format: <item name> <new line> <price> " +
                        "new line> <number of items>");
                System.out.println("When you are done, please type \"done\"");
                //while input is not "done", scan item name
                String itemName = scanner.nextLine();
                if (itemName.equals("done")) {
                    break;
                }
                //scan price
                double priceOfItems = Double.parseDouble(scanner.nextLine());
                //scan number of items
                int numberOfItems = Integer.parseInt(scanner.nextLine());
                cashRegistry.checkItem(new Item(itemName, priceOfItems), numberOfItems);
            }

            System.out.println("Your bill is:");
            System.out.println(cashRegistry);
            System.out.println("The total is: " + cashRegistry.getTotal());

            System.out.println("Please type \"pay\" to pay or \"cancel\" to cancel");
            String payCancelInput = scanner.nextLine();
            if (payCancelInput.equals("pay")) {
                System.out.println("Please enter the amount of money you are paying");
                double amountPaid = Double.parseDouble(scanner.nextLine());
                System.out.println("Your change is: " + cashRegistry.checkOut(amountPaid));
            } else if (payCancelInput.equals("cancel")) {
                System.out.println("Your bill is cancelled");
                cashRegistry.cancelBill();
            } else {
                System.out.println("Invalid input");
            }

            System.out.println("To exit, type \"exit\"");
            String exitInput = scanner.nextLine();
            if (exitInput.equals("exit")) {
                break;
            }
        }

    }

}
