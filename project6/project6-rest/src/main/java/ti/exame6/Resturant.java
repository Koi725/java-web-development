package ti.exame6;


public class Resturant{
  private int id ;
  private String customerName;
  private String dish;
  private int quantity;
  private double price;
  private String status;

  public Resturant(){};

  public Resturant(int id, String customerName, String dish, int quantity, double price) {
    this.id = id;
    this.customerName = customerName;
    this.dish = dish;
    this.quantity = quantity;
    this.price = price;
    this.status = "pending";
  }

  public int getId() {
    return id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getDish() {
    return dish;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
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
  public void setDish(String dish) {
    this.dish = dish;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public void setStatus(String status) {
        // Validate that status is one of the allowed values
        if (status.equals("pending") || status.equals("ready") || status.equals("delivered")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status must be pending, ready, or delivered");
        }
    }
  }