/**
 * Aggregate generic pairs of arbitrary objects.
 */
public final class GenericPair<F, S> {
  private final F first;
  private final S second;

  /** Construct a Pair object. */
  public GenericPair(F one, S two) {
    first = one;
    second = two;
  }

  /** @return the first constituent object. */
  public F getFirst() { return first; }

  /** @return the second constituent object. */
  public S getSecond() { return second; }

  /** @return true if the pair of objects are identical. */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof GenericPair<?,?>)) return false;
    GenericPair<?,?> otherPair = (GenericPair<?,?>) other;
    return first.equals(otherPair.first) && second.equals(otherPair.second);
  }

  /** @return a hash code for the aggregate pair. */
  @Override
  public int hashCode() {
    // XORing the hash codes to create a hash code for the pair.
    return first.hashCode() ^ second.hashCode();
  }

  /** @return the textual representation of aggregated objects. */
  @Override
  public String toString() {
    return "[" + first + "," + second + "]";
  }
}