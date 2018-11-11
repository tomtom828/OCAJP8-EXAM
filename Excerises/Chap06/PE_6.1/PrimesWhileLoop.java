public class PrimesWhileLoop {

  // Finds all primes smaller than 100
  // Gonna be more clever this time
  // https://en.wikipedia.org/wiki/Primality_test

  private static int NUMBER_LIMIT = 100;

  private static boolean isPrime(int myNumber) {

    // Not 0 or 1
    if (myNumber <= 1)
      return false;

    // Is 2 or 3
    else if (myNumber <= 3)
      return true;

    // Not divisible by 2 or 3
    else if (myNumber % 2 == 0 || myNumber % 3 == 0)
      return false;

    // 6k ± 1 optimization from Wikipedia
    int i = 5;
    while (i*i <= myNumber) {
      // Not Prime
      if (myNumber % i == 0 || myNumber % (i + 2) == 0)
        return false;
      i = i + 6;
    }
    // Otherwise, is Prime
    return true;

  }

  // Test for Primes
  public static void main(String[] args) {
    System.out.println("List of prime numbers:");
    // Loop over all numbers
    int i = 0;
    while (i < NUMBER_LIMIT) {
      if (isPrime(i))
        System.out.println(i);
      i++;
    }
  }

}