package ti.exame;

public class Pet{
    private String name;
    private int age;
    private int ownerNif;
    private String species;

    public Pet() {};

    public Pet(String name, int age, int ownerNif, String species) {
        this.name = name;
        this.age = age;
        this.ownerNif = ownerNif;
        this.species = species;
    }
    
    public String getName(){
      return name;
    }

    public int getAge(){
      return age;
    }

    public String getSpecies(){
      return species;
    }

    public int getOwnerNif(){
      return ownerNif;
    }

     public void setName(String name){
      this.name = name;
    }
    public void setAge(int age){
      this.age = age;
    } 
    public void setSpecies(String species){
      this.species = species;
    }
    public void setOwnerNif(int ownerNif){
      this.ownerNif = ownerNif;
    }
}