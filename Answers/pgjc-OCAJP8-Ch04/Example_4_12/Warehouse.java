
class Light {
  // Static final variables
  public static final double KWH_PRICE = 3.25;   // (1)
  public static final String MANUFACTURER;       // (2)

  static {                                       // Static initializer block
    MANUFACTURER = "Ozam";                       // (3) Initializes (2)
  }

  // Instance variables
  int noOfWatts;
  final String color;                            // (4)
  final String energyRating;                     // (5)

  {                                              // Instance initializer block
    color = "off white";                         // (6) Initializes (4)
  }

  // Constructor
  Light() {
    energyRating = "A++";                        // (7) Initializes (5)
  }

  // Final instance method                          (8)
  final public void setWatts(int watt) {
    noOfWatts = watt;
  }

  public void setKWH() {
    // KWH_PRICE = 4.10;                 // (9) Not OK. Cannot be changed.
  }
}
//______________________________________________________________________________
class TubeLight extends Light {
  // Final method in superclass cannot be overridden.
  // This method will not compile.
  /*
    @Override
    public void setWatts(int watt) {     // (10) Attempt to override.
         noOfWatts = 2*watt;
    }
   */
}
//______________________________________________________________________________
public class Warehouse {
  public static void main(String[] args) {

    final Light workLight = new Light(); // (11) Final local variable.
    workLight.setWatts(100);             // (12) OK. Changing object state.
//  workLight = new Light();             // (13) Not OK. Changing final reference.

    final Light alarmLight;              // (14) Not initialized.
//  alarmLight.setWatts(200);            // (15) Not OK.

    System.out.println("KWH_PRICE:    " + Light.KWH_PRICE);
    System.out.println("MANUFACTURER: " + Light.MANUFACTURER);
    System.out.println("noOfWatts:    " + workLight.noOfWatts);
    System.out.println("color:        " + workLight.color);
    System.out.println("energyRating: " + workLight.energyRating);
  }
}