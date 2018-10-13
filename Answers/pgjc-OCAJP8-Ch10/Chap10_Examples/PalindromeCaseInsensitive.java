/** Tests whether a string is a palindrome (case insensitive). */
public class PalindromeCaseInsensitive implements StrPredicate {         // (3)
  @Override public boolean test(String str) {
    return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
  }
}