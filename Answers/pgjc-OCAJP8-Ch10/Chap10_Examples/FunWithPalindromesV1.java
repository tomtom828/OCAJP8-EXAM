import java.util.ArrayList;
import java.util.List;

public class FunWithPalindromesV1 {

  public static void main(String[] args) {
    // Create a list of words:                                             (4)
    List<String> words = new ArrayList<>();
    words.add("Otto"); words.add("ADA"); words.add("Alyla");
    words.add("Bob"); words.add("HannaH"); words.add("Java");
    System.out.println("List of words:                " + words);

    // Use a class to filter for palindromes (case sensitive).             (5)
    List<String> palindromes1 = filterStrings(words,
                                              new PalindromeCaseSensitive());
    System.out.println("Case sensitive palindromes:   " + palindromes1);

    // Use a class to filter for palindromes (case insensitive).           (6)
    List<String> palindromes2 = filterStrings(words,
                                              new PalindromeCaseInsensitive());
    System.out.println("Case insensitive palindromes: " + palindromes2);

    // Use an anonymous class to filter for palindromes (case sensitive).  (7)
    List<String> palindromes3 = filterStrings(words,
        new StrPredicate() {
          @Override
          public boolean test(String str) {
            return str.equals(new StringBuilder(str).reverse().toString());
          }
        }
    );
    System.out.println("Case sensitive palindromes:   " + palindromes3);

    // Use an anonymous class to filter for palindromes (case insensitive). (8)
    List<String> palindromes4 = filterStrings(words,
        new StrPredicate() {
          @Override
          public boolean test(String str) {
            return str.equalsIgnoreCase(
                           new StringBuilder(str).reverse().toString());
          }
        }
    );
    System.out.println("Case insensitive palindromes: " + palindromes4);
  }

  /**
   * Filters a list of strings according to the criteria of the predicate.
   * @param strList    List of strings to filter
   * @param predicate  Provides the criteria for filtering the strings
   * @return           List of strings that match the criteria
   */
  public static List<String> filterStrings(List<String> strList,         // (9)
                                           StrPredicate predicate) {
    List<String> result = new ArrayList<>();
    for (String str : strList) {
      if (predicate.test(str)) {                                         // (10)
        result.add(str);
      }
    }
    return result;
  }
}