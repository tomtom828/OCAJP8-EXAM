import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/** Class represents statistics about an astronaut. */
public class Astronaut {

  private final String        astronautName;
  private final LocalDateTime arrivalDateTime;
  private final LocalDate     scheduledReturnDate;
  private final Period        actualPeriodOfStay;

  public Astronaut(String name, LocalDateTime arrival, Period period,
                   LocalDate returnDate) {
    astronautName = name;
    arrivalDateTime = arrival;
    actualPeriodOfStay = period;
    scheduledReturnDate = returnDate;
  }

  public String getAstronautName()          { return astronautName; }
  public LocalDateTime getArrivalDateTime() { return arrivalDateTime; }
  public Period getActualPeriodOfStay()     { return actualPeriodOfStay; }
  public LocalDate getScheduledReturnDate() { return scheduledReturnDate; }

  /** @return LocalDate The actual date of return. */
  public LocalDate getActualReturnDate() {
    /* IMPLEMENT THIS METHOD. */
    return arrivalDateTime.toLocalDate().plus(actualPeriodOfStay);
  }

  /**
   * Returns status of the actual return compared to the scheduled return,
   * whether it was on time, delayed or early.
   * @return String Indicating "On time", "Delayed" or "Early".
   */
  public String getReturnStatus() {
    /* IMPLEMENT THIS METHOD. */
    String status = "On time";
    LocalDate actualReturnDate = getActualReturnDate();
    if (scheduledReturnDate.isBefore(actualReturnDate)) {
      status = "Delayed";
    } else if (scheduledReturnDate.isAfter(actualReturnDate)) {
      status = "Early";
    }
    return status;
  }

  /** @return Period The planned stay according to the scheduled return.*/
  public Period getPlannedPeriodOfStay() {
    /* IMPLEMENT THIS METHOD. */
    return Period.between(arrivalDateTime.toLocalDate(), scheduledReturnDate);
  }

  /**
   * @return Period The difference between the actual return date and
   *                the scheduled return date. */
  public Period getDiffPeriodOfStay() {
    /* IMPLEMENT THIS METHOD. */
    return scheduledReturnDate.until(getActualReturnDate());
    // Following code has logical error, as a period has no notion of a date.
    // return actualPeriodOfStay.minus(getPlannedPeriodOfStay());
  }
}