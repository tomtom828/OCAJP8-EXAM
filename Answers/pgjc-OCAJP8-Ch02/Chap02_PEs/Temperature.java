// File: Temperature.java
/* Identifiers and keywords in Java are case-sensitive. Therefore, the
   the name of the public class must match the name of the file, the keywords must
   all be written in lowercase. The name of the String class has an
   uppercase S. The main method must be static and takes an array of
   String objects as an argument. */
public class Temperature {
  public static void main(String[] args) {  // Correct method signature
    double fahrenheit = 62.5;
    // A multiple-line comment, which can span several lines, starts with
    // the character sequence /* and ends with the character sequence */.
    /* Convert */
    double celsius = f2c(fahrenheit);
    // Character literals are enclosed in single quotes,
    // string literals are enclosed in double quotes.
    // Only first character literal is quoted as string to avoid addition.
    // The second char literal is implicitly converted to its string
    // representation, as string concatenation is performed by
    // the last + operator.
    // Java is case-sensitive. The name Celsius should be changed to
    // the variable name celsius.
    System.out.println(fahrenheit + "F" + " = " + celsius + 'C');
  }
  /* Method should be declared static. */
  static double f2c(double fahr) {  // Note parameter type should be double.
    return (fahr - 32.0) * 5.0 / 9.0;
  }
}