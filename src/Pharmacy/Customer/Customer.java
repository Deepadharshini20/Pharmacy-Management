package Pharmacy.Customer;

import java.util.ArrayList;

import Pharmacy.Branch.Purchase;

public class Customer {
  private int customerId;
  static int count = 1;
  private String name;
  private String phone;
  public ArrayList<Purchase> details;

  public Customer(String name, String phone) {
    this.customerId = count++;
    this.name = name;
    this.phone = phone;
    details = new ArrayList<>();
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}