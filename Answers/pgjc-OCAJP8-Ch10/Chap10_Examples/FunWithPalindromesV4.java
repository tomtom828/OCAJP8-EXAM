import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunWithPalindromesV4 {

  private static boolean isCaseSensitivePalindrome(String str) {
    return str.equals(new StringBuilder(str).reverse().toString());
  }

  private static boolean isCaseInsensitivePalindrome(String str) {
    return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
  }

  public static void main(String[] args) {

    // Create a list of words:                                             // (1)
    List<String> words = new ArrayList<>();
    words.add("Otto"); words.add("ADA"); words.add("Alyla");
    words.add("Bob"); words.add("HannaH"); words.add("Java");
    System.out.println("List of words:                   " + words);

    List<String> palindromes1 = filterStrings(words,                       // (2)
        str -> isCaseSensitivePalindrome(str));
    System.out.println("Case sensitive palindromes:      " + palindromes1);

    List<String> palindromes2 = filterStrings(words, str ->                // (3)
        isCaseInsensitivePalindrome(str));
    System.out.println("Case insensitive palindromes:    " + palindromes2);

    Predicate<String> predicate3 = str -> !isCaseSensitivePalindrome(str); // (4)
    List<String> nonPalindromes = filterStrings(words, predicate3);
    System.out.println("Non-palindromes, case sensitive: " + nonPalindromes);

    Predicate<String> predicate4 = str -> str.length() > 3;                // (5)
    List<String> strGT3 = filterStrings(words, predicate4);
    System.out.println("Words with length > 3:           " + strGT3);

    Predicate<String> predicate5 = str ->                                  // (6)
        str.length() > 3 && isCaseSensitivePalindrome(str);
    List<String> palindromesGT3 = filterStrings(words, predicate5);
    System.out.println("Case sensitive palindromes, length > 3: "
                       + palindromesGT3);

    Predicate<String> predicateA = str -> {                                // (7)
      return str.length() > 3 && isCaseSensitivePalindrome(str);
    };
    System.out.println("Case sensitive palindromes, length > 3: "
                        + filterStrings(words, predicateA));

    Predicate<String> predicateB = str -> {                                // (8)
      boolean result1 = str.length() > 3;
      boolean result2 = isCaseSensitivePalindrome(str);
      return  result1 && result2;
    };
    System.out.println("Case sensitive palindromes, length > 3: "
                        + filterStrings(words, predicateB));

    Predicate<String> predicateC = str -> {                                // (9)
      if (str == null || str.equals("") || str.length() <= 3) {
        return false;
      }
      StringBuilder sb = new StringBuilder(str);
      boolean result = str.equals(sb.reverse().toString());
      return result;
    };
    System.out.println("Case sensitive palindromes, length > 3: "
                        + filterStrings(words, predicateC));

    Predicate<String> predicateD = str ->                                  // (10)
        (str == null || str.equals("") || str.length() <= 3)
        ? false: isCaseSensitivePalindrome(str);
    System.out.println("Case sensitive palindromes, length > 3: "
                        + filterStrings(words, predicateD));

    Predicate<String> predicateE = str ->                                  // (11)
        str != null &&  !str.equals("") &&  str.length() > 3
        &&  isCaseSensitivePalindrome(str);
    System.out.println("Case sensitive palindromes, length > 3: "
                      + filterStrings(words, predicateE));

    // Removing elements from a list:
    words.removeIf(str -> str.indexOf('a') > 0);                           // (12)
    System.out.println("List of words, no 'a':      " + words);

    words.removeIf(str -> str.length() > 3);                               // (13)
    System.out.println("List of words, length <= 3: " + words);
  }

  /**
   * Filters a list according to the criteria of the predicate.
   * @param list       List to filter
   * @param predicate  Provides the criteria for filtering the list
   * @return           List of elements that match the criteria
   */
  public static <E> List<E> filterStrings(List<E> list,                    // (14)
                                          Predicate<E> predicate) {
    List<E> result = new ArrayList<>();
    for (E element : list)
      if (predicate.test(element))
        result.add(element);
    return result;
  }
}