import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class FormattingParsingDateTime {
  public static void main(String[] args) {
    // Create some date-time formatters:
    DateTimeFormatter[] dtFormatters =                         {          // (1)
        DateTimeFormatter.ISO_LOCAL_DATE_TIME,
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM),
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,
                                              FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,
                                              FormatStyle.MEDIUM),
//      The following two combinations result in a DateTimeException at runtime:
//      DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG),
//      DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
    };
    String[] formatStyles = {"ISO", "SHORT", "MEDIUM",
                             "MEDIUM,SHORT", "SHORT,MEDIUM"};

    // Formatting and parsing a date-time:
    LocalDateTime dateTime = LocalDateTime.of(2015, 12, 1, 14, 15, 30);   // (2)
    int i = 0;
    System.out.printf("%s%31s%38s%n", "Style", "Formatting of date-time|",
                       "Parsing of date-time, date, time");
    for(DateTimeFormatter dtf : dtFormatters)
      try {
        String strDateTime = dateTime.format(dtf);                   // (3)
        LocalDateTime parsedDateTime
                           = LocalDateTime.parse(strDateTime, dtf);  // (4)
        LocalTime parsedTime = LocalTime.parse(strDateTime, dtf);    // (5)
        LocalDate parsedDate = LocalDate.parse(strDateTime, dtf);    // (6)
        System.out.printf("%-12s", formatStyles[i++]);
        System.out.printf("%23s|%22s|%s|%8s%n", strDateTime,
                           parsedDateTime.format(dtf), parsedDate, parsedTime);
      } catch (DateTimeParseException pe) {
        System.out.println(pe);
        return;
      } catch (DateTimeException dte) {
        System.out.println(dte);
        return;
      }
  }
}