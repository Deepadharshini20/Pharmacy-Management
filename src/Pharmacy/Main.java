package Pharmacy;

import java.util.Scanner;

import Pharmacy.Branch.Branch;
import Pharmacy.Branch.Purchase;
import Pharmacy.Branch.PurchaseTranscation;
import Pharmacy.Customer.Customer;
import Pharmacy.Customer.CustomerHandler;
import Pharmacy.Product.ProductHandler;

public class Main {

  public static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    initialize();
    System.out.println("--------Welcome To Pharmacy Management--------");
    boolean flag = true;
    while (flag) {
      System.out.println("************************");
      System.out.println("1.Add Branch\n2.Add Stock\n3.Associate Alternate\n4.Add Customer" +
          "\n5.Purchase\n6.Summary Of Purchase\n7.Customer Purchase Summary\n8.Exit");
      System.out.println("************************");
      System.out.println("Enter your choice: ");
      int choice = in.nextInt();
      in.nextLine();
      switch (choice) {
        case 1:
          PharmacyHandler.getInstance().addBranch();
          break;
        case 2:
          ProductHandler.addStock();
          break;
        case 3:
          ProductHandler.associateAlternate();
          break;
        case 4:
          CustomerHandler.addCustomer();
          break;
        case 5:
          PurchaseTranscation.purchase();
          break;
        case 6:
          PurchaseTranscation.summary(PurchaseTranscation.purchases);
          break;
        case 7:
          System.out.println("Enter customer id: ");
          int id = Main.in.nextInt();
          System.out.println("Branch Id  Transcation Medicine  Quantity Price");
          for (Purchase p : PurchaseTranscation.purchases) {
            if (p.getCustomerId() == id) {
              System.out.println(p.getBranchId() + "          " + p.getTranscationId()
                  + "                " +"            " + p.getMedicineName()
                  + "         " + p.getQuantity() + "        " + p.getPrice());
            }
          }
        case 8:
          flag = false;
          break;
        default:
          break;
      }
    }
  }

  public static void initialize() {
    PharmacyHandler.branchs.add(new Branch("Tambaram", "9898989898"));
    PharmacyHandler.branchs.add(new Branch("Anna nagar", "9898989898"));
    PharmacyHandler.branchs.add(new Branch("Velacherry", "9898989898"));
    CustomerHandler.customers.add(new Customer("raj", "9898989898"));
  }
}
