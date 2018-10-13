import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class UsingTemporals {

  public static void main(String[] args) {
    // Date-Time: 1945-08-06T08:15
    LocalDateTime doomsday = LocalDateTime.of(1945, 8, 6, 8, 15);
    LocalDate date = doomsday.toLocalDate();                   // 1945-08-06
    LocalTime time = doomsday.toLocalTime();                   // 08:15
    System.out.println("Date-Time: " + doomsday);

    // Time: 08:15
    int hour       = time.getHour();                           // 8
    int minute     = time.getMinute();                         // 15
    int second     = time.getSecond();                         // 0
    System.out.println("Time: " + time);
    System.out.println("Hour: " + hour);
    System.out.println("Min:  " + minute);
    System.out.println("Sec:  " + second);

    // Date: 1945-08-06
    int year       = date.getYear();                           // 1945
    int monthValue = date.getMonthValue();                     // 8
    Month month    = date.getMonth();                          // AUGUST
    DayOfWeek dow  = date.getDayOfWeek();                      // MONDAY
    int day        = date.getDayOfMonth();                     // 6
    System.out.println("Date:  " + date);
    System.out.println("Year:  " + year);
    System.out.println("Month value: " + monthValue);
    System.out.println("Month: " + month);
    System.out.println("DoW:   " + dow);
    System.out.println("DoM:   " + day);

    // Ordering
    LocalDate d1 = LocalDate.of(-1004, 3, 1);                  // -1004-03-01
    LocalDate d2 = LocalDate.of(1004, 3, 1);                   // 1004-03-01
    boolean result1 = d1.isBefore(d2);                         // true
    boolean result2 = d2.isAfter(d1);                          // true
    boolean result3 = d1.isAfter(d1);                          // false
    boolean result4 = d1.isEqual(d2);                          // false
    boolean result5 = d1.isEqual(d1);                          // true
    boolean result6 = d2.isLeapYear();                         // true

    System.out.println(d1 + " is before "   + d2 + ": " + result1);
    System.out.println(d2 + " is after "    + d1 + ": " + result2);
    System.out.println(d1 + " is after "    + d1 + ": " + result3);
    System.out.println(d1 + " is equal to " + d2 + ": " + result4);
    System.out.println(d1 + " is equal to " + d1 + ": " + result5);
    System.out.println(d2.getYear() + " is a leap year: " + result6);

    // Absolute adjusters:
    LocalDate date2 = LocalDate.of(2015, 3, 1);
    System.out.println("Date before adjusting: " + date2);     // 2015-03-01
    date2 = date2.withYear(2016).withMonth(2).withDayOfMonth(28);
    System.out.println("Date after adjusting:  " + date2);     // 2016-02-28
  }
}