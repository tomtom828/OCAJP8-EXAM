// File: Exercise1.java
package chap07pe1;

interface Function {
  int evaluate(int arg);
}

class Half implements Function {
  @Override public int evaluate(int arg) {
    return arg/2;
  }
}

public class Exercise1 {

  public static int[] applyFunction(int... arrIn) {
    int length = arrIn.length;
    int[] arrOut = new int[length];
    Function func = new Half();
    for (int i = 0; i < length; i++) {
      arrOut[i] = func.evaluate(arrIn[i]);
    }
    return arrOut;
  }

  public static void main(String[] args) {

    // Halv the values.
    int[] myArr = applyFunction(2, 4, 6, 8);

    System.out.println("Array with values halved by integer division:");
    for (int value : myArr) {
      System.out.println(value);
    }
  }
}