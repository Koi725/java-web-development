package ti.exame9;

public class Collection {
    private String name ;
    private int year ;
    private double rate ;

    public Collection(){};

    public Collection(String name, int year, double rate) {
        this.name = name;
        this.year = year;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}