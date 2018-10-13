import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterFun {

  public static void main(String[] args) {                               // (1)
    // Create a list of strings:
    String[] strings = { "Cheer up!", "7Up coming up!", null,
                         "Bottoms up!","Get down!", "What's up?" };
    List<String> strList = new ArrayList<>();
    /* WRITE CODE TO POPULATE THE LIST OF STRINGS HERE. */
    System.out.println(strList);

    // Create a list of predicates.
    List<Predicate<String>> predList = new ArrayList<>();
    /* WRITE CODE TO POPULATE THE LIST OF PREDICATES HERE. */
    System.out.println(predList);

    // Apply filtering.
    applyAllPredicates(strList, predList);
    applyAllPredicatesAlt(strList, predList);
    applyAllPredicatesGenAlt(strList, predList);
  }

  /**
   * Prints all the strings in the specified list that satisfy all the
   * predicates in the list of predicates.
   * It uses the andPredicates() method at (3).
   * @param list        List of strings to apply the predicates on
   * @param predicates  List of predicates to apply
   */
  public static void applyAllPredicates(List<String> list,               // (2)
                                        List<Predicate<String>> predicates) {
    /* IMPLEMENT THIS METHOD */
  }

  /**
   * Determines if a string satisfies all the predicates.
   * @param str         String to apply the predicates on
   * @param predicates  List of predicates to apply
   * @return            true only if the string satisfies all the predicates
   */
  public static boolean andPredicates(String str,                        // (3)
                                      List<Predicate<String>> predicates) {
    /* IMPLEMENT THIS METHOD */
  }

  /**
   * Removes all the elements in the specified list that do not satisfy all the
   * predicates in the list of predicates, and prints the remaining elements
   * that do.
   * Uses Predicate.and(), Predicate.negate() and List.removeIf() methods.
   * @param list        List of strings to apply the predicates on
   * @param predicates  List of predicates to apply
   */
  public static void applyAllPredicatesAlt(List<String> list,            // (4)
                                           List<Predicate<String>> predicates) {
    /* IMPLEMENT THIS METHOD */
  }

  /** Generic version.
   * Removes all the elements in the specified list that do not satisfy all the
   * predicates in the list of predicates, and prints the remaining elements
   * that do.
   * Uses Predicate.and(), Predicate.negate() and List.removeIf() methods.
   * @param list        List of elements to apply the predicates on
   * @param predicates  List of predicates to apply
   */
  public static <T> void applyAllPredicatesGenAlt(List<T> list,          // (5)
                                 List<Predicate<T>> predicates) {
    /* IMPLEMENT THIS METHOD */
  }
}