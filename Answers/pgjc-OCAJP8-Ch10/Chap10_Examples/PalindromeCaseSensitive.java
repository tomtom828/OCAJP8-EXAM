/** Tests whether a string is a palindrome (case sensitive). */
public class PalindromeCaseSensitive implements StrPredicate {           // (2)
  @Override public boolean test(String str) {
    return str.equals(new StringBuilder(str).reverse().toString());
  }
}