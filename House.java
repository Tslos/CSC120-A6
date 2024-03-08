import java.util.ArrayList;
import java.util.Arrays;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors, ArrayList<String> residents, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }
  public String toString() {
    String desc = super.toString();
    // source for inline if statement:
    // https://www.delftstack.com/howto/java/one-line-if-statement-java/
    String elev = this.hasElevator ? "has an elevator" : "does not have an elevator";
    String dining = this.hasDiningRoom ? "has a dining hall" : "does not have a dining hall";
    return "Residence Hall: " + desc + ". It " + elev + " and " + dining + "."; 
  }
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    this.residents.add(name);
  }

  public String moveOut(String name) {
    if (this.residents.contains(name)) {
      this.residents.remove(name);
      return name + " has moved out.";
    } else {
      return name + " could not move out because they do not live in " + this.name;
    }
    
  }

  public boolean isResident(String person) {
    return this.residents.contains(person);
  }


  public static void main(String[] args) {
    // Make some residents
    ArrayList<String> gillettResidents = new ArrayList<String>(Arrays.asList("Nina Wattenberg", "Elm Markert", "Tillie Slosser", "Taylor Agena", "Em Swindell", "Ava Silverman", "Alex Theiss"));
    // Make my house
    House gillett = new House("Gillett House", "47 Elm Street", 5, gillettResidents, true, true);
    System.out.println(gillett);
    // How many residents does it have?
    System.out.println("Gillett has " + gillett.nResidents() + " residents.");
    // Am I a resident?
    System.out.println(gillett.isResident("Tillie Slosser"));
    // The president is graduating this year  - move her out. 
    System.out.println(gillett.moveOut("Nina Wattenberg"));
    // Try to move her out a second time to test the "person not a resident" scenario
    System.out.println(gillett.moveOut("Nina Wattenberg"));
    
  }

}