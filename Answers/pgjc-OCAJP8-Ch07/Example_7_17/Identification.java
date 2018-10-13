
public class Identification {
  public static void main(String[] args) {
    Object obj = new Object();
    StackImpl stack = new StackImpl(10);
    SafeStackImpl safeStack = new SafeStackImpl(5);
    IStack iStack;

    String strFormat = "(%d)  %-25s instance of %-25s: %s%n";
    System.out.printf(strFormat, 1,
        null, Object.class,
        null instanceof Object);      // Always false.
    System.out.printf(strFormat, 2,
        null, IStack.class,
        null instanceof IStack);      // Always false.

    System.out.printf(strFormat, 3,
        stack.getClass(), Object.class,
        stack instanceof Object);     // true: instance of subclass of Object.
    System.out.printf(strFormat, 4,
        obj.getClass(), StackImpl.class,
        obj instanceof StackImpl);    // false: Object not subtype of StackImpl.
    System.out.printf(strFormat, 5,
        stack.getClass(), StackImpl.class,
        stack instanceof StackImpl);  // true: instance of StackImpl.
    System.out.printf(strFormat, 6,
        obj.getClass(), IStack.class,
        obj instanceof IStack);       // false: Object does not implement IStack.
    System.out.printf(strFormat, 7,
        safeStack.getClass(), IStack.class,
        safeStack instanceof IStack); // true: SafeStackImpl implements IStack.

    obj = stack;           // No cast required: assigning subclass to superclass.
    System.out.printf(strFormat, 8,
        obj.getClass(), StackImpl.class,
        obj instanceof StackImpl);    // true: instance of StackImpl.
    System.out.printf(strFormat, 9,
        obj.getClass(), IStack.class,
        obj instanceof IStack);       // true: StackImpl implements IStack.
    System.out.printf(strFormat, 10,
        obj.getClass(), String.class,
        obj instanceof String);       // false: No relationship.

    iStack = (IStack) obj; // Cast required: assigning superclass to subclass.
    System.out.printf(strFormat, 11,
        iStack.getClass(), Object.class,
        iStack instanceof Object);    // true: instance of subclass of Object.
    System.out.printf(strFormat, 12,
        iStack.getClass(), StackImpl.class,
        iStack instanceof StackImpl); // true: instance of StackImpl.

    String[] strArray = new String[10];
//  System.out.printf(strFormat, 13,
//      strArray.getClass(), String.class,
//      strArray instanceof String);     // Compile-time error, no relationship.
    System.out.printf(strFormat, 14,
        strArray.getClass(), Object.class,
        strArray instanceof Object);     // true: array subclass of Object.
    System.out.printf(strFormat, 15,
        strArray.getClass(), Object[].class,
        strArray instanceof Object[]);   // true: array subclass of Object[].
    System.out.printf(strFormat, 16,
        strArray[0], Object.class,
        strArray[0] instanceof Object);  // false: strArray[0] is null.
    System.out.printf(strFormat, 17,
        strArray.getClass(), String[].class,
        strArray instanceof String[]);   // true: array of String.

    strArray[0] = "Amoeba strip";
    System.out.printf(strFormat, 18,
        strArray[0].getClass(), String.class,
        strArray[0] instanceof String);  // true: strArray[0] instance of String.
  }
}