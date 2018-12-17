public final class Pair {

  private final int num;
  private final String str;
    
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (! (obj instanceof Pair)) return false;
    if (this.hashCode() == obj.hashCode()) return true;
    return false;
  }

  @Override
  public String toString() {
    return "{" + this.num + ", " + this.str + "}";
  }

  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }


  // Constructor
  public Pair(int num, String str) {
    this.num = num;
    this.str = str;
  }

  // Test it out
  public static void main(String[] args) {
    Pair test1 = new Pair(1, "one");
    Pair test2 = new Pair(1, "one");
    Pair test3 = new Pair(3, "three");
    System.out.println(test1.toString());
    System.out.println(test1.hashCode());
    System.out.println(test1.equals(test2));
    System.out.println(test2.equals("{1, one}"));
    System.out.println(test3.toString());
    System.out.println(test3.equals(test1));
  }

}