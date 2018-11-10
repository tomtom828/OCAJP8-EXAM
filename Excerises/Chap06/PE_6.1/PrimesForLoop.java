import java.util.ArrayList;

public class PrimesForLoop {

  // Finds all primes smaller than 100
  // Note: I am sure there are more elegant ways to do this, but I'll just brute force it...

  private static int NUMBER_LIMIT = 100;

  // Yeah... these are prime... but this is a Java lesson, not a math lesson...
  private static int[] arrayOfDivisors = {2, 3, 5, 7};

  // ArrayList of solved primes
  private static ArrayList<Integer> listOfSolvedPrimes = new ArrayList<Integer>();

  // Return true/false if prime or not, respectively
  private static boolean isPrime(int myNumber) {
    // Zero or One is not prime
    if (myNumber == 0 || myNumber == 1)
      return false;
    // Test if of the given prime numbers
    for(int i = 0; i <arrayOfDivisors.length; i++) {
      if (myNumber == arrayOfDivisors[i]) {
        listOfSolvedPrimes.add(myNumber);
        return true;
      }
    }
    // If divisble by any of these numbers, then its not prime
    for(int i = 0; i <arrayOfDivisors.length; i++) {
      if (myNumber % arrayOfDivisors[i] == 0)
        return false;
    }
    // Cannot be divisible by another prime (i.e. 13*13 = 169)
    for(int i = 0; i < listOfSolvedPrimes.size(); i++) {
      if (myNumber % listOfSolvedPrimes.get(i) == 0)
        return false;
    }
    // Otherwise, it is prime
    listOfSolvedPrimes.add(myNumber);
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