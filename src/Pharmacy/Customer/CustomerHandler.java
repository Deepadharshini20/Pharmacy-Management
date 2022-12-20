package Pharmacy.Customer;

import java.util.ArrayList;

import Pharmacy.InputValidation;

public class CustomerHandler {
  public static ArrayList<Customer> customers = new ArrayList<>();

  public static void addCustomer() {
    boolean add = true;
    while (add) {
      String name = InputValidation.getString("Name");
      String phone = InputValidation.getPhoneNumber();
      Customer c = new Customer(name, phone);
      customers.add(c);
      System.out.println("Do u want to add customer?\nPress 1: Yes\nPress 2: No");
      int yesNo = InputValidation.getYesOrNo();
      if(yesNo==2)
        add = false;
    }
    System.out.println("\nCustomer Id    Customer Name     Phone Number");
    for(Customer c: customers){
      System.out.println(c.getCustomerId()+"             "+c.getName()+"           "+c.getPhone());
    }
  }

  public static Customer getCustomer(int id) {
    for(Customer c: customers){
      if(c.getCustomerId()==id)
        return c;
    }
    return null;
  }
}
