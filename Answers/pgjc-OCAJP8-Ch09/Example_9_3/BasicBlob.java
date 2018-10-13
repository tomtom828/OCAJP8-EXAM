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