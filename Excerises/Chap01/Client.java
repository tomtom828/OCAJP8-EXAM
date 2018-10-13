// File: Client.java
public class Client extends PrintableCharStack {
  

  // Instance method
  public void printStackElementsBwd() {
    while (!this.isEmpty()) {
      System.out.print(this.pop());
    }
  }


  // Constructor
  public Client(int capacity) { 
    super(capacity);
  }


  // Entry Point
  public static void main(String[] args) {

    // Create a string to push on the stack:
    String str = "!no tis ot nuf era skcatS";
    int length = str.length();


    // TT: New Object
    Client client = new Client(length);

    // TT: Push the string char by char onto the stack:
    for (int i = 0; i < length; i++) {
      client.push(str.charAt(i));
    }

    // Print Fwd
    System.out.print("Original string: ");
    client.printStackElements();

    // Print Bwd
    System.out.print("Reversed string: ");
    client.printStackElementsBwd();

    System.out.println();
    
  }
}