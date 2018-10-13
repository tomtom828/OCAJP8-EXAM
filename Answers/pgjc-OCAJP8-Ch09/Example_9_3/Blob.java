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