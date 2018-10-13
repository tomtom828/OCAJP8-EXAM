import java.time.LocalDate;

public class TemporalArithmetic {

  public static void main(String[] args) {

    LocalDate date = LocalDate.of(2015, 10, 23);           // (1)
    System.out.println("Date:             " + date);       // 2015-10-23
    date = date.plusMonths(10);                            // (2)
    System.out.println("10 months after:  " + date);       // 2016-08-23
    date = date.plusWeeks(3);                              // (3)
    System.out.println("3 weeks after:    " + date);       // 2016-09-13
    date = date.plusDays(40);                              // (4)
    System.out.println("40 days after:    " + date);       // 2016-10-23

    date = date.minusDays(2);                              // (5)
    System.out.println("2 days before:    " + date);       // 2016-10-21
    date = date.minusWeeks(4);                             // (6)
    System.out.println("4 weeks before:   " + date);       // 2016-09-23
    date = date.minusMonths(11);                           // (7)
    System.out.println("11 months before: " + date);       // 2015-10-23
  }
}