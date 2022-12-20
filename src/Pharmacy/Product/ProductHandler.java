package Pharmacy.Product;

import Pharmacy.Branch.Branch;
import Pharmacy.Branch.BranchHandler;
import Pharmacy.InputValidation;
import Pharmacy.Main;
import Pharmacy.PharmacyHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProductHandler {
  static Scanner in = Main.in;
  public static HashMap<Product, ArrayList<Product>> alternateProduct = new HashMap<>();
  public static ArrayList<Product> products = new ArrayList<>();

  public static void addStock() {
    boolean add = true;
    while (add) {
      System.out.println("Enter the branch id: ");
      int branchId = in.nextInt();
      in.nextLine();
      if (PharmacyHandler.getInstance().checkBranchFound(branchId) != null) {
        System.out.println("Enter the medicine name: ");
        String medicine = in.nextLine();
        System.out.println("Enter the price of this medicine");
        float price = in.nextFloat();
        System.out.println("Enter the quantity: ");
        int quantity = in.nextInt();
        Product p = new Product(medicine, price, quantity);
        products.add(p);
        BranchHandler.addProduct(branchId, p);
        System.out.println("Do u want add the medicine to the branch?\nPress 1: Yess\nPress 2: No ");
        int yesNo = InputValidation.getYesOrNo();
        if (yesNo == 2)
          add = false;
      } else {
        System.out.println("Branch id is not found");
        System.out.println("Enter the valid branch id..");
      }
    }
    System.out.println("\nBranch Id     Medicine        Avaiable Qty     Price");
    for (Branch b : PharmacyHandler.branchs) {
      for (Product p : b.products) {
        System.out.println(
            b.getId() + "             " + p.getMedicineName() + "                " + p.getQuantiy() + "               "
                + p.getPrice() * p.getQuantiy());
      }
    }
  }

  public static void associateAlternate() {
    boolean flag = true;
    while (flag) {
      System.out.println("Enter the product name to associate: ");
      String product = in.nextLine();
      Product p = getProductDetails(product);
      System.out.println("Enter the alternate product: ");
      String alternate = in.nextLine();
      Product alter = getProductDetails(alternate);

      if (!alternateProduct.containsKey(p)) {
        alternateProduct.put(p, new ArrayList<>());
      }
      if(p!=null && alter!=null)
        alternateProduct.get(p).add(alter);
      System.out.println("Do u want add the medicine to the alternate?\nPress 1: Yess\nPress 2: No ");
      int yesNo = InputValidation.getYesOrNo();
      if (yesNo == 2)
        flag = false;
      in.nextLine();
    }
    System.out.println("\nMedicine               Alternate");
    for (Product prod : alternateProduct.keySet()) {
      System.out.print(prod.getMedicineName() + "               ");
      for (Product a : alternateProduct.get(prod)) {
        System.out.print(a.getMedicineName() + "  ");
      }
      System.out.println();
    }
  }

  public static Product getProductDetails(String medicineName) {
    for (Product p : products) {
      if (p.getMedicineName().equalsIgnoreCase(medicineName))
        return p;
    }
    return null;
  }
}
