package Pharmacy.Branch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Pharmacy.InputValidation;
import Pharmacy.Main;
import Pharmacy.PharmacyHandler;
import Pharmacy.Customer.CustomerHandler;
import Pharmacy.Product.Product;
import Pharmacy.Product.ProductHandler;

public class PurchaseTranscation {
  static Scanner in = Main.in;
  public static ArrayList<Purchase> purchases = new ArrayList<>();

  public static void purchase() {
    ArrayList<Purchase> purchaseRecent = new ArrayList<>();
    System.out.println("Enter Customer id: ");
    int customerId = in.nextInt();

    if (CustomerHandler.getCustomer(customerId) == null) {
      System.out.println("Customer id is not found");
    } else {
      System.out.println("Enter Branch id: ");
      int branchId = in.nextInt();
      in.nextLine();
      boolean flag = true;
      Branch b = PharmacyHandler.getInstance().checkBranchFound(branchId);
      while (flag) {
        if (b != null) {
          System.out.println("Enter product: ");
          String medicine = in.nextLine();
          System.out.println("enter quantity: ");
          int quantity = in.nextInt();
          // Product productDetails = ProductHandler.getProductDetails(medicine);
          Product p = checkProductThere(b, medicine, quantity);
          if (p != null) {
            Purchase purchase = new Purchase(branchId, customerId, medicine, quantity, p.getPrice() * quantity);
            purchases.add(purchase);
            purchaseRecent.add(purchase);
            for(Product med : b.products){
              if(med.getMedicineName().equalsIgnoreCase(medicine))
                med.setQuantiy(med.getQuantiy()-quantity);
            }
          } else {
            System.out.println("Quantity not avaliable");
            Product pro = checkAlter(b, medicine, quantity);
            if (pro != null) {
              System.out.println("Do u want to purchase " + pro.getMedicineName() + " ?\nPress 1: Yes\nPress 2 : No ");
              int yesNo = InputValidation.getYesOrNo();
              if (yesNo == 1) {
                Purchase purchase = new Purchase(branchId, customerId, pro.getMedicineName(), quantity,
                    pro.getPrice() * quantity);
                purchases.add(purchase);
                purchaseRecent.add(purchase);
                for (Product med : b.products) {
                  if (med.getMedicineName().equalsIgnoreCase(pro.getMedicineName()))
                    med.setQuantiy(med.getQuantiy() - quantity);
                }
                System.out.println(
                    "Purchased " + quantity + " " + pro.getMedicineName() + ".\nPrice = " + pro.getPrice() * quantity);
              }
              in.nextLine();
            } else {
              for (Branch branch : PharmacyHandler.branchs) {
                if (checkProductThere(branch, medicine, quantity) != null) {
                  System.out.println("Quantity not avaiable in this branch.Availabe in Branch " + branch.getId());
                }
              }
            }
          }
          System.out.println("Do u want to continue?\nPress 1: Yes\nPress 2: No");
          int yesNo = InputValidation.getYesOrNo();
          if (yesNo == 2)
            flag = false;
          in.nextLine();
        } else {
          System.out.println("Branch id is not found");
        }
      }
    }
    summary(purchaseRecent);
  }

  public static Product checkProductThere(Branch b, String medicine, int quantity) {
    for (Product p : b.products) {
      if (p.getMedicineName().equalsIgnoreCase(medicine)) {
        if (p.getQuantiy() >= quantity) {
          return p;
        }
      }
    }

    return null;
  }

  public static Product checkAlter(Branch b, String medicine, int quantity) {
    HashMap<Product, ArrayList<Product>> map = ProductHandler.alternateProduct;
    Product product = ProductHandler.getProductDetails(medicine);
    if (map.containsKey(product)) {
      if (checkProductThere(b, product.getMedicineName(), quantity) != null)
        return product;
      for (Product p : map.get(product)) {
        if (checkProductThere(b, p.getMedicineName(), quantity) != null)
          return p;
      }
    } else {
      String getProductKey = null;
      for (Product s : map.keySet()) {
        for (Product p : map.get(s)) {
          if (p.getMedicineName().equalsIgnoreCase(medicine)) {
            getProductKey = s.getMedicineName();
            break;
          }
        }
      }
      return checkAlter(b, getProductKey, quantity);
    }
    return null;
  }
  public static void summary(ArrayList<Purchase> purchased) {
    System.out.println("Branch Id  Transcation Id  Customer Id Medicine  Quantity Price");
    for (Purchase p : purchased) {
      System.out.println(p.getBranchId() + "          " + p.getTranscationId()
          + "                " + p.getCustomerId() + "            " + p.getMedicineName()
          + "         " + p.getQuantity() + "        " + p.getPrice());
    }
  }
}