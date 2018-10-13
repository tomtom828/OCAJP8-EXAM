enum SpiceGrade {                              // (1)
    MILD, MEDIUM_HOT, HOT, SUICIDE;
}

public class SwitchingFun {

  public static void main(String[] args) {
    SpiceGrade spicing = SpiceGrade.HOT;
    switch (spicing) {
      case HOT:                                // (2a) OK!
//    case SpiceGrade.HOT:                     // (2b) Compile-time error!
        System.out.println("Have fun!");
        break;
      case SUICIDE:
        System.out.println("Good luck!");
        break;
      default:                                 // Can only be MILD or MEDIUM_HOT.
        System.out.println("Enjoy you meal!");
    }
  }
}