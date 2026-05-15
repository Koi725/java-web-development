package ti.exame8;

public class Members{
  private String name ;
  private int age;
  private String plan ;

  public Members () {};

  public Members(String name, int age, String plan) {
    this.name = name;
    this.age = age;
    this.plan = plan;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }
}