import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import java.util.Arrays; // TT

public class FilterFun {

  public static void main(String[] args) {                               // (1)
    // Create a list of strings:
    String[] strings = { "Cheer up!", "7Up coming up!", null,
                         "Bottoms up!","Get down!", "What's up?" };
    List<String> strList = new ArrayList<>();
    /* WRITE CODE TO POPULATE THE LIST OF STRINGS HERE. */
    strList.addAll(Arrays.asList(strings)); // TT
    System.out.println(strList);

    // Create a list of predicates.
    List<Predicate<String>> predList = new ArrayList<>();
    /* WRITE CODE TO POPULATE THE LIST OF PREDICATES HERE. */
    // TT - Check if string is not null
    Predicate<String> p1 = (str) -> !(str == null);
    predList.add(p1);
    // TT - Check if string contains "up", but first ensure string is lowercase
    Predicate<String> p2 = (str) -> str.toLowerCase().contains("up");
    predList.add(p2);
    // TT - Check if 1st char of string is a letter
    Predicate<String> p3 = (str) -> Character.isLetter(str.charAt(0));
    predList.add(p3);
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
    List<String> result = new ArrayList<>(); // TT
    for (String string : list)
      if (andPredicates(string, predicates))
        result.add(string); // TT - append to list if string passes filter
    System.out.println(result); // TT - print filtered list
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
    for (Predicate<String> predicate : predicates) // TT
      if (!predicate.test(str))
        return false; // TT - one of the filters has failed
    return true; // TT - all filters have passed
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
    Predicate<String> otherPred = s -> true; // TT - uses and() use because
    for (Predicate<String> predicate : predicates)
      otherPred = otherPred.and(predicate);
    list.removeIf(otherPred.negate()); // TT - remove entry if it does not match criteria
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
    Predicate<T> otherPred = s -> true; // TT - uses and() use because
    for (Predicate<T> predicate : predicates)
      otherPred = otherPred.and(predicate);
    list.removeIf(otherPred.negate()); // TT - remove entry if it does not match criteria
    System.out.println(list);
  }
}