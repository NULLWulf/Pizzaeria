package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Serializable {

    // Personal Information
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String streetAddress, city, state, zipCode;

    // Order and Calculated Related Data
    private double totalOrderPrice;
    ArrayList<Order> orders = new ArrayList<Order>();

    public void newCustomerMenu(){  // Customer creation menu
        Scanner scanner = new Scanner(System.in);
        boolean profileDone = false;
        int selection = 0;

        while(!profileDone){
            System.out.print("Enter First Name: ");
            this.firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            this.lastName = scanner.nextLine();
            System.out.print("Enter Street Address: ");
            this.streetAddress = scanner.nextLine();
            System.out.print("Enter City: ");
            this.city = scanner.nextLine();
            System.out.print("Enter State: ");
            this.state = scanner.nextLine();
            System.out.print("Enter City: ");
            this.zipCode = scanner.nextLine();
            System.out.print("Enter City: ");

            System.out.println("Is this information correct?");
            displayCustomerInfo();
            System.out.println("Enter 1 for yes, anything else to start over");
            selection = scanner.nextInt();
            if(selection == 1){
                profileDone = true;
            }
        }
        scanner.close();
    }

    public void displayCustomerInfo(){
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Address: " + this.getStreetAddress() + ", " + this.getCity());
        System.out.println("State" + this.getState() + " Zip: " + this.getZipCode());
    }

    public void add(Order order){
        orders.add(order);
        this.totalOrderPrice = order.getTotal();  // function may not be necessary
    }

    // Getters and Setters
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;
    }public double getTotalOrderPrice() {return totalOrderPrice;}
    public void setTotalOrderPrice(double totalOrderPrice) {this.totalOrderPrice = totalOrderPrice;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getStreetAddress() {return streetAddress;}
    public void setStreetAddress(String streetAddress) {this.streetAddress = streetAddress;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
    public void setZipCode(String zipCode) {this.zipCode = zipCode;}
    public String getZipCode() {return zipCode;}
}
