package Pharmacy.Branch;

import java.util.ArrayList;

import Pharmacy.PharmacyHandler;
import Pharmacy.Product.Product;

public class BranchHandler {
  static ArrayList<Branch> branchs = PharmacyHandler.branchs;

  public static void addProduct(int branchId,Product p) {
    Branch b = PharmacyHandler.getInstance().checkBranchFound(branchId);
    boolean find = false;
    for(Product product: b.products){
      if(product.getMedicineName().equalsIgnoreCase(p.getMedicineName())){
        product.setPrice(p.getPrice());
        product.setQuantiy(product.getQuantiy()+p.getQuantiy());
        find = true;
      }
    }
    if(!find){
      b.products.add(p);
    }
  }
}
