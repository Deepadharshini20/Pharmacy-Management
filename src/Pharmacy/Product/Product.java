package Pharmacy.Product;

public class Product {
  private float price;
  private int quantiy;
  private String medicineName;
  
  public Product(String medicineName, float price, int quantiy) {
    this.medicineName = medicineName;
    this.price = price;
    this.quantiy = quantiy;
  }
   public String getMedicineName() {
    return medicineName;
  }

  public void setMedicineName(String medicineName) {
    this.medicineName = medicineName;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
  public int getQuantiy() {
    return quantiy;
  }
  public void setQuantiy(int quantiy) {
    this.quantiy = quantiy;
  }
  
}
