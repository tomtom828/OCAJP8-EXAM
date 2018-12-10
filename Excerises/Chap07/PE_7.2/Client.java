class Client {

  // Return array with halved values
  int[] myMethod(IFunction myFunction, int... myValues) {

    int[] myArray = new int[myValues.length];

    for (int i = 0; i < myValues.length; i++)
      myArray[i] = myFunction.evaluate(myValues[i]);

    return myArray;

  }


  public static void main(String[] args) {

    // New Halfer
    Half myHalf = new Half();

    // New Printer
    Print myPrint = new Print();

    // New Client
    Client myClient = new Client();

    // My inputs
    int[] myInputs = {2,4,6,8};
    // Print inputs
    for (int value : myInputs) {
      myPrint.evaluate(value);
    }

    System.out.println("");

    // Generate outputs
    int[] myValues = myClient.myMethod(myHalf, myInputs);
    // Print outputs
    for (int value : myValues) {
      myPrint.evaluate(value);
    }

    System.out.println("");

  }

}