// File: Finalizers.java
class BasicBlob {                                                    // (1)
  private static int idCounter;
  private static int population;

  protected int blobId;

  BasicBlob() {
    blobId = idCounter++;
    ++population;
  }

  @Override
  protected void finalize() throws Throwable {                       // (2)
    --population;
    super.finalize();
  }

  public static int getPopulation() {
    return population;
  }
}
//______________________________________________________________________________
class Blob extends BasicBlob {                                       // (3)
  private int[] size;

  Blob(int bloatedness) {                                            // (4)
    size = new int[bloatedness];
    System.out.println(blobId + ": Hello");
  }

  @Override
  protected void finalize() throws Throwable {                       // (5)
    System.out.println(blobId + ": Bye");
    super.finalize();
  }
}
//______________________________________________________________________________
public class Finalizers {
  public static void main(String[] args) {                           // (6)
    int blobsRequired, blobSize;
    try {
      blobsRequired = Integer.parseInt(args[0]);
      blobSize      = Integer.parseInt(args[1]);
    } catch(IndexOutOfBoundsException e) {
      System.out.println("Too few program arguments.");
      System.out.println("Usage: Finalizers <number of blobs> <blob size>");
      return;
    } catch(NumberFormatException e) {
      System.out.println("Illegal program argument.");
      System.out.println("Usage: Finalizers <number of blobs> <blob size>");
      return;
    }
    for (int i = 0; i < blobsRequired; ++i) {                        // (7)
      new Blob(blobSize);
    }
    System.out.println(BasicBlob.getPopulation() + " blobs alive");  // (8)
  }
}