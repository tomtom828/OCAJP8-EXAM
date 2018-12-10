class Print implements IFunction {
  @Override
  public int evaluate(int i) {
    System.out.print(i + " ");
    return i;
  }
}