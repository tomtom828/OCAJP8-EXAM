import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DefaultFormattingParsing {
  public static void main(String[] args) {

    System.out.printf("%70s%n", "Default formatting|Default parsing");
    // LocalTime
    LocalTime time = LocalTime.of(12, 30, 15, 99);
    String strTime = time.toString();                 // (1) 12:30:15.000000099
    LocalTime parsedTime = LocalTime.parse(strTime);  // (2)
    System.out.printf("LocalTime: %33s|%s%n", strTime, parsedTime);

    // LocalDate
    LocalDate date = LocalDate.of(2015, 4, 28);
    String strDate = date.toString();                 // 2015-04-28
    LocalDate parsedDate = LocalDate.parse(strDate);
    System.out.printf("LocalDate: %33s|%s%n", strDate, parsedDate);

    // LocalDateTime
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    String strDateTime = dateTime.toString();   // 2015-04-28T12:30:15.000000099
    LocalDateTime parsedDateTime = LocalDateTime.parse(strDateTime);
    System.out.printf("LocalDateTime: %23s|%s%n", strDateTime, parsedDateTime);
  }
}