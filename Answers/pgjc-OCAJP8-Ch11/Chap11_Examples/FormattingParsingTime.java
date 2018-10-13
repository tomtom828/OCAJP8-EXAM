import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class FormattingParsingTime {
  public static void main(String[] args) {
    // Create some time formatters:
    DateTimeFormatter[] timeFormatters =  {                          // (1)
        DateTimeFormatter.ISO_LOCAL_TIME,
        DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM),
//      The following two combinations result in a DateTimeException at runtime:
//      DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
//      DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)
    };
    String[] formatStyles = {"ISO", "SHORT", "MEDIUM", "LONG", "FULL"};

    // Formatting and parsing a time:
    LocalTime time = LocalTime.of(14, 15, 30);                            // (2)
    LocalDateTime dateTime = LocalDateTime.of(2015, 12, 1, 14, 15, 30);   // (3)
    int i = 0;
    System.out.println("Style  Formatting of time, date-time | Parsing of time");
    for(DateTimeFormatter tf : timeFormatters)
      try {
        String strTime = time.format(tf);                            // (4)
        LocalTime parsedTime = LocalTime.parse(strTime, tf);         // (5)
        String strTime2 = dateTime.format(tf);                       // (6)
        System.out.printf("%-7s", formatStyles[i++]);
        System.out.printf("%14s| %14s| %14s%n",
                          strTime, strTime2, parsedTime.format(tf));
      } catch (DateTimeParseException pe) {
        System.out.println(pe);
        return;
      } catch (DateTimeException dte) {
        System.out.println(dte);
        return;
      }
  }
}