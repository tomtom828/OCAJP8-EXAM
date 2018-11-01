package solved;

// Note: Compiles but answer has bad logic

public class Sunlight {
  public static void main(String[] args) {
    // Distance from sun (150 million kilometers)
    int kmFromSun = 150_000_000;

    int lightSpeed = 299_792_458; // meters per second

    // Convert distance to meters.
    long mFromSun = (long) kmFromSun * 1000; // need to cast to long since it was otherwise int * int

    int seconds = (int) (mFromSun / lightSpeed); // need to cast back to int since it was otherwise long * int

    System.out.print("Light will use ");
    printTime(seconds);
    System.out.println(" to travel from the sun to the earth.");
  }

  public static void printTime(int sec) {
    int min = (int) (sec / 60);
    sec = sec - (min * 60);
    System.out.print(min + " minute(s) and " + sec + " seconds.");
  }
}