/* Find all elements in a list that satisfy all predicates. */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterFunSolution {

  public static void main(String[] args) {                               // (1)
    // Create a list of strings:
    String[] strings = { "Cheer up!", "7Up coming up!", null,
                         "Bottoms up!","Get down!", "What's up?" };
    List<String> strList = new ArrayList<>();
    /* WRITE CODE TO POPULATE THE LIST OF STRINGS HERE. */
    for (String str : strings)
      strList.add(str);
    System.out.println(strList);

    // Create a list of predicates.
    List<Predicate<String>> predList = new ArrayList<>();
    /* WRITE CODE TO POPULATE THE LIST OF PREDICATES HERE. */
    predList.add(str -> str != null);
    predList.add(str -> str.toLowerCase().contains("up"));
    predList.add(str -> Character.isLetter(str.charAt(0)));
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
    List<String> resultList = new ArrayList<>();
    for (String str : list) {
      if (andPredicates(str, predicates)) {
        resultList.add(str);
      }
    }
    System.out.println(resultList);
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
    boolean proceed = true;
    for (Predicate<String> p : predicates) {
      proceed = proceed && p.test(str);
      if (!proceed) break;
    }
    return proceed;
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
    Predicate<String> compPred = s -> true;
    for (Predicate<String> p : predicates) {
      compPred = compPred.and(p);
    }
    list.removeIf(compPred.negate());
    System.out.println(list);
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
    Predicate<T> compPred = s -> true;
    for (Predicate<T> p : predicates) {
      compPred = compPred.and(p);
    }
    list.removeIf(compPred.negate());
    System.out.println(list);
  }
}