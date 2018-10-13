// File: Exercise2.java
package chap07pe2;

interface Function {
  int evaluate(int arg);
}

class Half implements Function {
  @Override public int evaluate(int arg) {
    return arg/2;
  }
}

class Print implements Function {
  @Override public int evaluate(int arg) {
    System.out.println(arg);
    return arg;
  }
}

public class Exercise2 {

  public static int[] applyFunction(Function func, int... arrIn) {
    int length = arrIn.length;
    int[] arrOut = new int[length];
    for (int i = 0; i < length; i++) {
      arrOut[i] = func.evaluate(arrIn[i]);
    }
    return arrOut;
  }

  public static void main(String[] args) {
    // Create a print function.
    Function print = new Print();

    System.out.println("Original values:");
    int[] myArr = applyFunction(print, 2, 4, 6, 8);

    // Halv the array values.
    myArr = applyFunction(new Half(), myArr);

    System.out.println("Halved values:");
    applyFunction(print, myArr);
  }
}