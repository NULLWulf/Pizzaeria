package com.company;

import com.sun.source.tree.NewArrayTree;

import java.io.*;

import static java.lang.System.out;

public class Serializer implements Serializable {

//    private Customer customer;
    String customerFile = "customer.txt";

    public void objectWriter(Customer customer){
        out.println("Saving customer data, please do not close application");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(customerFile));
            out.writeObject(customer);
            out.close();
            System.out.println("Customer data save successful, save to close application");
        } catch (FileNotFoundException e){
            out.println("No Customer File Found, no data has been written");
            e.printStackTrace();
        } catch (IOException e){
            out.println("File Reader error, no customer data has been saved.  See stack trace for details.");
            e.printStackTrace();
        }
    }

    public Customer objectReader(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(customerFile));
            Customer customer = (Customer) in.readObject();
            in.close();
            out.println("Found" + customer.getName() + "'s customer data and imported successfully");
            return customer;
        } catch (FileNotFoundException e){
            out.println("No Customer File Found, please create new customer file");
            out.println("See stack track trace for details");
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
            out.println("File Reader error, no customer data has been imported.  See stack trace for details.");
            out.println("See stack track for details");
            e.printStackTrace();
            return null;

        } catch (ClassNotFoundException e) {
            out.println("File found but does not match imported class, no customer data has been imported");
            out.println("See stack trace for details");
            e.printStackTrace();
            return null;
        }
    }
}
