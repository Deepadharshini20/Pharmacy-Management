package Pharmacy;

import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.Scanner;

import Pharmacy.Branch.Branch;

public class PharmacyHandler {
  public static ArrayList<Branch> branchs = new ArrayList<>();
  static PharmacyHandler pharmacyHandler;
  
  public static PharmacyHandler getInstance() {
    if(pharmacyHandler==null)
      pharmacyHandler = new PharmacyHandler();
    return pharmacyHandler;
  }

  public void addBranch() {
    Scanner in = Main.in;
    boolean isWantToAdd = true; 
    while(isWantToAdd){
      String location = InputValidation.getString("Location");
      String phone = InputValidation.getPhoneNumber();
      Branch b = new Branch(location, phone);
      branchs.add(b);
      System.out.println("Do u want to add branch more?\nPress 1: Yess\nPress 2: No ");
      int yesNo = InputValidation.getYesOrNo();
      in.nextLine();
      if(yesNo==2)
        isWantToAdd = false;
    } 
    System.out.println("Branch Id   Branch Location      Phone Number"); 
    for(Branch b : branchs){
      System.out.println(b.getId()+"            "+b.getLocation()+"              "+b.getPhone());
    }
  }
  public Branch checkBranchFound(int id) {
    for(Branch b:branchs){
      if(b.getId()==id)
        return b;
    }
    return null;
  }
}