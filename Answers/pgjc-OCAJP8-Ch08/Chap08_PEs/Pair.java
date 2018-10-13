/**
 * Aggregate (non-generic) pairs of arbitrary objects.
 */
public final class Pair {
  private final Object first, second;

  /** Construct a Pair object. */
  public Pair(Object one, Object two) {
    first = one;
    second = two;
  }

  /** @return the first constituent object. */
  public Object getFirst() { return first; }

  /** @return the second constituent object. */
  public Object getSecond() { return second; }

  /** @return true if the pair of objects are identical. */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (! (other instanceof Pair)) return false;
    Pair otherPair = (Pair) other;
    return first.equals(otherPair.first) && second.equals(otherPair.second);
  }

  /** @return a hash code for the aggregate pair. */
  @Override
  public int hashCode() {
    // XORing the hash codes to create a hash code for the pair.
    return first.hashCode() ^ second.hashCode();
  }

  /** @return a textual representation of the aggregated object. */
  @Override
  public String toString() {
    return "[" + first + "," + second + "]";
  }
}