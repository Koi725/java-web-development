package ti.exame7;

public class Order {
  private int id;
  private String customerName;
  private int productId;
  private int quantity;
  private double totalPrice;
  private String status;

  public Order() {}

  public Order(int id, String customerName, int productId, int quantity, double totalPrice, String status) {
    this.id = id;
    this.customerName = customerName;
    this.productId = productId;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
    this.status = status;
  }

  public int getId() {
    return id;
  }
  public String getCustomerName() {
    return customerName;
  }
  public int getProductId() {
    return productId;
  }
  public int getQuantity() {
    return quantity;
  }
  public double getTotalPrice() {
    return totalPrice;
  }
  public String getStatus() {
    return status;
  }

  public void setId(int id) {
    this.id = id;
  }
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  public void setProductId(int productId) {
    this.productId = productId;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
  public void setStatus(String status) {
    this.status = status;
  }
}