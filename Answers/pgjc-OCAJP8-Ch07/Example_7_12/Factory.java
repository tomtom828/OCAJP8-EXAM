// File: Factory.java
interface IBaseStates {
  String IDLE = "idle";                               // (1)
  String BUSY = "busy";                               // (2)
  String BLOCKED = "blocked";                         // (3)
}
//_______________________________________________________________________________
interface IExtStatesA extends IBaseStates {
  String DISMANTLED = "dismantled";                   // (4)
}
//_______________________________________________________________________________
interface IExtStatesB extends IBaseStates {
  String DISMANTLED = "kaput";                        // (5)
}
//_______________________________________________________________________________
interface IAllStates extends IExtStatesB, IExtStatesA {
  String BLOCKED = "out of order";                    // (6) hides (3)
//String ABSOLETE = BLOCKED + ", " +
//                  DISMANTLED + " and scrapped.";    // (7) Ambiguous
  String ABSOLETE = BLOCKED + ", " +
         IExtStatesB.DISMANTLED + " and scrapped";    // (7a)
}
//_______________________________________________________________________________
public class Factory implements IAllStates {
  public static void main(String[] args) {
//  System.out.println("Machine A is " + DISMANTLED);            // (8) Ambiguous.
    System.out.println("Machine A is " + IExtStatesB.DISMANTLED);// (8a)
    System.out.println("Machine B is " + ABSOLETE);   // (9)  IAllStates.ABSOLETE
    System.out.println("Machine C is " + BLOCKED);    // (10) IAllStates.BLOCKED
    System.out.println("Machine D is " + IBaseStates.BLOCKED); // (11)
    System.out.println("Machine E is " + BUSY);       // (12) Simple name
  }
}