package ti.exame10;

public class Room {
    private int number ;
    private String type ;
    private boolean available ;
    private double pricePerNight;

    public Room(){};

    public Room(int number, String type, boolean available) {
        this.number = number;
        this.type = type;
        this.available = available;
    }
    
    public int getNumber() {
        return number;
    }
    
    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

     public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }
}
