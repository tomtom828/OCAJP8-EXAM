public class Palindrome {

  public static boolean isPalindrome(String str) {
    return str.equals(Palindrome.reverse(str));
  }

  public static String reverse(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    return String.valueOf(sb);
  }

  // Test it out
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please pass in args!");
      return;
    }
    System.out.println("Input:   " + args[0]);
    System.out.println("Reverse: " + Palindrome.reverse(args[0]));
    System.out.println("Result:  " + Palindrome.isPalindrome(args[0]));
  }

}