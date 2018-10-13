import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsingArrayList {

  public static void main(String[] args) {

    String[] wordArray = { "level", "Ada", "kayak", "Bob", "Rotator", "Bob" };

    System.out.println("(1) Create an empty list of strings:");
    List<String> strList = new ArrayList<>();
    printListWithIndex(strList);

    System.out.println("\n(2) Add elements to list:");
    for (String str : wordArray) {
      strList.add(str);
      printListWithIndex(strList);
    }
    System.out.println("Insert an element at index 2 in the list:");
    strList.add(2, "Java");
    printListWithIndex(strList);

    System.out.println("\n(3) Replace the element at index 1:");
    String oldElement = strList.set(1, "Naan");
    System.out.println("Element that was replaced: " + oldElement);
    printListWithIndex(strList);

    System.out.println("\n(4) Remove the element at index 0:");
    System.out.println("Element removed: " + strList.remove(0));
    printListWithIndex(strList);

    System.out.println("\n(5) Remove the first occurrence of \"Java\":");
    System.out.println("Element removed: " + strList.remove("Java"));
    printListWithIndex(strList);

    System.out.println("\n(6) Determine the size of the list:");
    System.out.println("The size of the list is " + strList.size());

    System.out.println("\n(7) Determine if the list is empty:");
    boolean result = strList.isEmpty();
    System.out.println("The list " + (result ? "is" : "is not") + " empty.");

    System.out.println("\n(8) Get the element at specific index:");
    System.out.println("First element: " + strList.get(0));
    System.out.println("Last element: " + strList.get(strList.size() - 1));

    System.out.println("\n(9) Compare two lists:");
    List<String> strList2 = new ArrayList<>(strList);
    boolean trueOrFalse = strList.equals(strList2);
    System.out.println("The lists strList and strList2 are"
        + (trueOrFalse ? "" : " not") + " equal.");
    strList2.add(null);
    printListWithIndex(strList2);
    trueOrFalse = strList.equals(strList2);
    System.out.println("The lists strList and strList2 are"
        + (trueOrFalse ? "" : " not") + " equal.");

    System.out.println("\n(10) Membership test:");
    boolean found = strList.contains("Naan");
    String msg = found ? "contains" : "does not contain";
    System.out.println("The list " + msg + " the string \"Naan\".");

    System.out.println("\n(11) Find the index of an element:");
    int pos = strList.indexOf("Bob");
    System.out.println("The index of string \"Bob\" is: " + pos);
    pos = strList.indexOf("BOB");
    System.out.println("The index of string \"BOB\" is: " + pos);
    pos = strList.lastIndexOf("Bob");
    System.out.println("The last index of string \"Bob\" is: " + pos);
    printListWithIndex(strList);

    System.out.println("\n(12) Traversing the list using the for(;;) loop:");
    for (int i = 0; i < strList.size(); i++) {
      System.out.print(i + ":" + strList.get(i) + " ");
    }
    System.out.println();

    System.out.println("\n(13) Traversing the list using the for(:) loop:");
    for (String str : strList) {
      System.out.print(str +  " ");
      // strList.remove(str);        // Throws ConcurrentModificationException.
    }
    System.out.println();

    System.out.println("\n(14) Convert list to array:");
    Object[] objArray = strList.toArray();
    System.out.println("Object[] length: " + objArray.length);
    System.out.print("Length of each string in the Object array: ");
    for (Object obj : objArray) {
      String str = (String) obj; // Cast required.
      System.out.print(str.length() + " ");
    }
    System.out.println();
    String[] strArray = strList.toArray(new String[0]);
    System.out.println("String[] length: " + strArray.length);
    System.out.print("Length of each string in the String array: ");
    for (String str : strArray) {
      System.out.print(str.length() + " ");
    }
    System.out.println();

    System.out.println("\n(15) Sorting a list:");
    List<StringBuilder> sbList = new ArrayList<>();
    for (String str : strArray) {
      sbList.add(new StringBuilder(str));
    }
    // Collections.sort(sbList);                     // Compile-time error!
    System.out.println("Unsorted list: " + strList);
    Collections.sort(strList);
    System.out.println("Sorted list: " + strList);
  }

  /**
   * Print the elements of a list, together with their index:
   * [0:value0, 1:value1, ...]
   * @param list   List to print with index
   */
  public static <E> void printListWithIndex(List<E> list) {            // (16)
    List<String> newList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      newList.add(i + ":" + list.get(i));
    }
    System.out.println(newList);
  }
}