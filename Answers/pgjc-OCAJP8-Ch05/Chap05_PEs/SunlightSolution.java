// File: SunlightSolution.java
public class SunlightSolution {
  public static void main(String[] args) {
    // Distance from sun (150 million kilometers)
    /* The max value for int is 2_147_483_647, so using int here will
       work. */
    int kmFromSun = 150_000_000;

    // Again, using int for this value is OK.
    int lightSpeed = 299_792_458; // Meters per second

    // Convert distance to meters.
    /* The result of this equation will not fit in an int.
       So we use a long instead. We need to ensure that the values that
       are multiplied are actually multiplied using long
       data types, and not multiplied as int data types and later
       converted to long. The L suffix on the 1000L integer
       literal ensures this. The value of the variable kmFromSun will
       implicitly be converted from int to long to match the
       data type of the other factor. The conversion can be done
       implicitly by the compiler since the conversion represents
       a widening of the data type. */
    long mFromSun = kmFromSun * 1000L;

    /* We know that the result value will fit in an int.
       However, the narrowing conversion on assignment from long to int
       in this case requires a cast.*/
    int seconds = (int) (mFromSun / lightSpeed);

    System.out.print("Light will use ");
    printTime(seconds);
    System.out.println(" to travel from the sun to the earth.");
  }

  /* No changes necessary in this method. */
  public static void printTime(int sec) {
    int min = sec / 60;
    sec = sec - (min * 60);
    System.out.print(min + " minute(s) and " + sec + " second(s)");
  }
}