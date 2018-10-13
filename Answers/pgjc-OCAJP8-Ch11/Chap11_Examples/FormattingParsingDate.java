import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class FormattingParsingDate {
  public static void main(String[] args) {
    // Create some date formatters:
    DateTimeFormatter[] dateFormatters =                         {   // (1)
        DateTimeFormatter.BASIC_ISO_DATE,
        DateTimeFormatter.ISO_LOCAL_DATE,
        DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM),
        DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
    };
    String[] formatStyles = {"BASIC", "ISO", "SHORT", "MEDIUM", "LONG", "FULL"};

    // Formatting and parsing a date:
    LocalDate date = LocalDate.of(2015, 12, 1);                           // (2)
    LocalDateTime dateTime = LocalDateTime.of(2015, 12, 1, 14, 15, 30);   // (3)
    int i = 0;
    System.out.printf("%s%39s%30s%n", "Style", "Formatting of date, date-time",
                      "| Parsing of date");
    for(DateTimeFormatter df : dateFormatters)
      try {
        String strDate = date.format(df);                            // (4)
        LocalDate parsedDate = LocalDate.parse(strDate, df);         // (5)
        String strDate2 = dateTime.format(df);                       // (6)
        System.out.printf("%-6s", formatStyles[i++]);
        System.out.printf("%25s|%25s|%s%n",
                          strDate, strDate2, parsedDate.format(df));
      } catch (DateTimeParseException pe) {
        System.out.println(pe);
        return;
      } catch (DateTimeException dte) {
        System.out.println(dte);
        return;
      }
  }
}