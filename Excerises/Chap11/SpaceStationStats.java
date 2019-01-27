import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SpaceStationStats {

  public static void main(String[] args) {
    // Astronaut data
    Astronaut[] astronauts = {
        new Astronaut("Astro Ali",
            LocalDateTime.of(2010, 3, 1, 10, 45), Period.ofMonths(3),
            LocalDate.of(2010, 5, 1)),
        new Astronaut("Laila Lightyear",
            LocalDateTime.of(2015, 2, 1, 17, 0),  Period.ofWeeks(30),
            LocalDate.of(2015, 6, 30)),
        new Astronaut("Orbit Orwell",
            LocalDateTime.of(2014, 3, 1, 20, 20), Period.ofMonths(6),
            LocalDate.of(2014, 9, 1)),
        new Astronaut("Rocket Rogers",
            LocalDateTime.of(2013, 7, 31, 15, 30), Period.ofDays(60),
            LocalDate.of(2013, 9, 30)),
        new Astronaut("Sam Spacey",
            LocalDateTime.of(2009, 1, 1, 12, 15), Period.ofDays(90),
            LocalDate.of(2009, 11, 1)),
    };
    printReport(astronauts);
  }

  /**
   * Method prints statistics about stay on a space station.
   * See the exercise text for the format of the report.
   * @param astronauts The array with astronaut data
   */
  private static void printReport(Astronaut[] astronauts) {
    System.out.println("Name             Arr.Date  Sched.Return"
                       + " Act.Return  Status Act.Stay Sched.Stay Diff");
    String reportFormatStr = "%-16s%10s%12s%12s%8s%6s%10s%9s%n";
    /* IMPLEMENT THE REST OF THE METHOD. */
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    for (Astronaut astronaut : astronauts) {

      String astronautName = astronaut.getAstronautName();
      LocalDateTime arrivalDate = astronaut.getArrivalDateTime();
      LocalDate scheduledReturnDate = astronaut.getScheduledReturnDate();
      LocalDate actualReturnDate = astronaut.getActualReturnDate();
      String status = astronaut.getReturnStatus();
      Period periodOfStay = astronaut.getActualPeriodOfStay();
      Period plannedPeriodOfStay = astronaut.getPlannedPeriodOfStay();
      Period diffPeriodOfStay = astronaut.getDiffPeriodOfStay();

      System.out.printf(reportFormatStr, astronautName, arrivalDate.format(df), scheduledReturnDate.format(df), 
        actualReturnDate.format(df), status, periodOfStay, plannedPeriodOfStay, diffPeriodOfStay);

    }
  }
}