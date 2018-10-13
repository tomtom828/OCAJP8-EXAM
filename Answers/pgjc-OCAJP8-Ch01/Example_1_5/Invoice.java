// File: Invoice.java
public class Invoice {
  public static void main(String[] args) {
    System.out.printf("Secure Data Inc.       ");                     // (1)
    System.out.printf("%02d/%02d/%04d, %02d:%02d%n%n",                // (2)
                       2, 13, 2016, 11, 5);
    System.out.printf("%-20s%7s%9s%8s%n",                             // (3)
                      "Item", "Price", "Quantity", "Amount");

    int quantity = 4;
    double price = 120.25, amount = quantity*price, total = amount;
    String itemFormat = "%-20s%7.2f%9d%8.2f%n";                       // (4)
    System.out.printf(itemFormat,
                      "FlashDrive, 250GB", price, quantity, amount);  // (5)
    quantity = 2;
    price = 455.0; amount = quantity*price; total = total + amount;
    System.out.printf(itemFormat,
                      "Ultra HD, 4TB", price, quantity, amount);      // (6)
    quantity = 1;
    price = 8.50; amount = quantity*price; total = total + amount;
    System.out.printf(itemFormat,
                      "USB 3.0 cable", price, quantity, amount);      // (7)

    System.out.printf("%-36s%8.2f%n", "Total:", total);               // (8)
  }
}