
public class SwitchingOnAString {
  public static final String MEDIUM = "Medium";      // (1)
  public static final String HOT = "Hot";            // (2a)
//public static       String HOT = "Hot";            // (2b) Not ok as case lablel
//public static final String HOT = new String("Hot");// (2c) Not ok as case lablel

  public static void main(String[] args) {
    String spiceLevel = "Medium_Hot";
    switch (spiceLevel) {
      case "Mild":                                   // (3)
      case MEDIUM + "_" + HOT:                       // (4)
        System.out.println("Enjoy your meal!");
        break;
      case HOT:                                      // (5)
        System.out.println("Have fun!");
        break;
      case "Suicide":                                // (6)
        System.out.println("Good luck!");
        break;
      default:
        System.out.println("You being funny?");
    }
  }
}