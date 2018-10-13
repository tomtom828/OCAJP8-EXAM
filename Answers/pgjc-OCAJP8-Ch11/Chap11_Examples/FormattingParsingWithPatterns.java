import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingParsingWithPatterns {
  public static void main(String[] args) {

    LocalTime time = LocalTime.of(12, 30, 15, 99);
    LocalDate date = LocalDate.of(2015, 4, 28);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    System.out.printf("Time : %s%n", time);
    System.out.printf("Date : %s%n", date);
    System.out.printf("DateTime : %s%n%n", dateTime);

    // Time part
    String timePattern = "HH::mm::ss:SSS";
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
    String strTime = time.format(timeFormatter);                       // (1)
    LocalTime parsedTime = LocalTime.parse(strTime, timeFormatter);    // (2)
    String strTime2 = dateTime.format(timeFormatter);                  // (3)
    System.out.printf("Time pattern: %s%n", timePattern);
    System.out.printf("LocalTime: %s|%s%n",
                       strTime, parsedTime.format(timeFormatter));
    System.out.printf("LocalDateTime (formatted time part): %s%n%n", strTime2);

    // Date part
    String datePattern = "EEEE, uuuu/MMMM/dd";
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);
    String strDate = date.format(dateFormatter);                       // (4)
    LocalDate parsedDate = LocalDate.parse(strDate, dateFormatter);    // (5)
    String strDate2 = dateTime.format(dateFormatter);                  // (6)
    System.out.printf("Date pattern: %s%n", datePattern);
    System.out.printf("LocalDate: %s|%s%n",
                       strDate, parsedDate.format(dateFormatter));
    System.out.printf("LocalDateTime (formatted date part): %s%n%n", strDate2);

    // Date and time parts
    String dtPattern = "EE, HH::mm::ss 'on' uuuu/MM/dd";
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(dtPattern);
    String strDateTime = dateTime.format(dtFormatter);                  // (7)
    LocalDateTime parsedDateTime = LocalDateTime.parse(strDateTime,     // (8)
                                                       dtFormatter);
    LocalDate parsedDate3 = LocalDate.parse(strDateTime, dtFormatter);  // (9)
    LocalTime parsedTime3 = LocalTime.parse(strDateTime, dtFormatter);  // (10)
    System.out.printf("DateTime pattern: %s%n", dtPattern);
    System.out.printf("LocalDateTime: %s|%s%n",
                       strDateTime, parsedDateTime.format(dtFormatter));
    System.out.printf("LocalDate (parsed date part): %s%n",
                       parsedDate3.format(dateFormatter));
    System.out.printf("LocalTime (parsed time part): %s%n",
                       parsedTime3.format(timeFormatter));
  }
}