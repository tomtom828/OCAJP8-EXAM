class Client {

  // Return array with halved values
  static int[] myMethod(int... myValues) {

    // Instance of Half
    IFunction myHalf = new Half();

    int[] myArray = new int[myValues.length];

    for (int i = 0; i < myValues.length; i++)
      myArray[i] = myHalf.evaluate(myValues[i]);

    return myArray;

  }


  public static void main(String[] args) {

    // New client
    // Client myClient = new Client();
    int[] myValues = {2,4,6};
    int[] myOutputs = myMethod(myValues);


    // Print results
    for (int value : myOutputs) {
      System.out.println(value);
    }

  }

}