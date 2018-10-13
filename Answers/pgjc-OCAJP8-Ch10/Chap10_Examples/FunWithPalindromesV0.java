import java.util.ArrayList;
import java.util.List;

public class FunWithPalindromesV0 {

  public static void main(String[] args) {
    // Create a list of words:                                              (1)
    List<String> words = new ArrayList<>();
    words.add("Otto"); words.add("ADA"); words.add("Alyla");
    words.add("Bob"); words.add("HannaH"); words.add("Java");
    System.out.println("List of words:                " + words);

    // Call a method to filter the list for palindromes (case sensitive).   (2)
    List<String> palindromes = filterPalindromes(words);
    System.out.println("Case sensitive palindromes:   " + palindromes);

    // Call a method to filter the list for palindromes (case insensitive). (3)
    List<String> palindromesIgnoreCase = filterPalindromesIgnorecase(words);
    System.out.println("Case insensitive palindromes: " + palindromesIgnoreCase);
  }

  /**                                                                       (4)
   * Finds palindromes in a list of words. Uses case sensitive filtering.
   * @param words List of strings
   * @return      List of palindromes found
   */
  public static List<String> filterPalindromes(List<String> words) {
    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (word.equals(new StringBuilder(word).reverse().toString())) {   // (5)
        result.add(word);
      }
    }
    return result;
  }

  /**                                                                       (6)
   * Finds palindromes in a list of words. Uses case insensitive filtering.
   * @param words List of strings
   * @return      List of palindromes found
   */
  public static List<String> filterPalindromesIgnorecase(List<String> words) {
    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (word.equalsIgnoreCase(
                   new StringBuilder(word).reverse().toString())) {      // (7)
        result.add(word);
      }
    }
    return result;
  }
}