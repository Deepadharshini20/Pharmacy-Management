package Pharmacy.Branch;

public class Purchase {
  private int transcationId;
  static int cnt = 1;
  private int branchId;
  private int customerId;
  private String medicineName;
  private int quantity;
  private float price;
  
  public Purchase(int branchId,int customerId,String medicineName, int quantity, float price) {
    transcationId = cnt++;
    this.branchId = branchId;
    this.customerId = customerId;
    this.medicineName = medicineName;
    this.quantity = quantity;
    this.price = price;
  }

  public int getTranscationId() {
    return transcationId;
  }

  public void setTranscationId(int transcationId) {
    this.transcationId = transcationId;
  }

  public int getBranchId() {
    return branchId;
  }

  public void setBranchId(int branchId) {
    this.branchId = branchId;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getMedicineName() {
    return medicineName;
  }

  public void setMedicineName(String medicineName) {
    this.medicineName = medicineName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
  
}
