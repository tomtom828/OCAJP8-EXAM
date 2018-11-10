public class PrimesForLoop {

  // Finds all primes smaller than 100
  // Note: I am sure there are more elegant ways to do this, but I'll just brute force it...

  private static int NUMBER_LIMIT = 100;

  // Yeah... these are prime... but this is a Java lesson, not a math lesson...
  private static int[] arrayOfDivisors = {2, 3, 5, 7};


  // Return true/false if prime or not, respectively
  private static boolean isPrime(int myNumber) {
    // Test if of the given prime numbers
    for(int i = 0; i <arrayOfDivisors.length; i++) {
      if (myNumber == arrayOfDivisors[i])
        return true;
    }
    // If divisble by any of these numbers, then its not prime
    for(int i = 0; i <arrayOfDivisors.length; i++) {
      if (myNumber % arrayOfDivisors[i] == 0)
        return false;
    }
    // Otherwise, it is prime
    return true;
  }


  // Test for Primes
  public static void main(String[] args) {
    System.out.println("List of prime numbers:");
    for (int i = 1; i < NUMBER_LIMIT; i++) {
      if (isPrime(i))
        System.out.println(i);
    }
  }
  

}