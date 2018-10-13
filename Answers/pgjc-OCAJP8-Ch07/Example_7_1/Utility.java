// File: Utility.java
class Light {                           // (1)
  // Instance fields:
            int     noOfWatts;          // wattage
  private   boolean indicator;          // on or off
  protected String  location;           // placement

  // Static field:
  private static int counter;           // no. of Light objects created

  // No-argument constructor:
  Light() {
    noOfWatts = 50;
    indicator = true;
    location  = "X";
    counter++;
  }

  // Instance methods:
  public  void    switchOn()  { indicator = true; }
  public  void    switchOff() { indicator = false; }
  public  boolean isOn()      { return indicator; }
  private void    printLocation() {
    System.out.println("Location: " + location);
  }

  // Static methods:
  public static void writeCount() {
    System.out.println("Number of lights: " + counter);
  }
  //...
}
//______________________________________________________________________________
class TubeLight extends Light {         // (2) Subclass uses the extends clause.
  // Instance fields:
  private int tubeLength = 54;
  private int colorNo    = 10;

  // Instance methods:
  public int getTubeLength() { return tubeLength; }

  public void printInfo() {
    System.out.println("From the subclass:");
    System.out.println("Tube length: "  + tubeLength);
    System.out.println("Color number: " + colorNo);
    System.out.println("Tube length: "  + getTubeLength());
    System.out.println();
    System.out.println("From the superclass:");
    System.out.println("Wattage: "      + noOfWatts);     // Inherited.
//  System.out.println("Indicator: "    + indicator);     // Not inherited.
    System.out.println("Location: "     + location);      // Inherited.
//  System.out.println("Counter: "   + counter);          // Not inherited.
    switchOn();                                           // Inherited
    switchOff();                                          // Inherited
    System.out.println("Indicator: "    + isOn());        // Inherited.
//  printLocation();                                      // Not inherited.
    writeCount();                                         // Inherited.
  }
  // ...
}
//______________________________________________________________________________
public class Utility {                  // (3)
  public static void main(String[] args) {
    new TubeLight().printInfo();
  }
}