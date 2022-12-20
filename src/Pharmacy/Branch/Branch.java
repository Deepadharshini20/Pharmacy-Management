package Pharmacy.Branch;

import java.util.ArrayList;

import Pharmacy.Product.Product;

public class Branch {

  private int id;
  static int idCount = 1;
  private String location;
  private String phone;
  public ArrayList<Product> products;

  public Branch( String location, String phone) {
    this.id = idCount++;
    this.location = location;
    this.phone = phone;
    this.products = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public String getLocation() {
    return location;
  }

  public String getPhone() {
    return phone;
  }
}
