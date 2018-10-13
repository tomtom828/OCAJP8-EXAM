import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormattingPatterns {
  static public void main(String[] args) {
    // DateTime to format.
    LocalDateTime dateTime = LocalDateTime.of(1972, 12, 2, 14, 45, 30);

    // Formatting patterns.
    String[] patterns = {
        "dd/MM/uu",
        "u/M/d",
        "d MMMM uuuu",
        "'Anniversary': d MMMM",
        "uuuu.MM.dd",
        "uuuu.MM.dd@hh:mm:ss",
        "uuuu.MMMM.dd hh:mm a",
        "EEE, MMM d'th', ''uu",
        "EEEE d MMMM uuuu",
        "EEE d MMM uuu",
        "EE d MM uu",
        "E d M u",
        "h:m a",
        "hh:mm",
        "HH:mm",
        "HH:mm:ss",
        "'Hour': HH",
        "EEE at hh:mm", // IllegalArgumentException - Unknown pattern letter: t
        "hh::mmm",      // IllegalArgumentException - Too many pattern letters: m
    };

    System.out.println("Formatting date/time (" + dateTime + ")" +
                       " according to different patterns:");
    for (String pattern : patterns) {
      String output;
      try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        output = dateTime.format(formatter);
      } catch (IllegalArgumentException e) {
        output = String.format("%s - %s", e.getClass().getSimpleName(),
                               e.getMessage());
      }
      System.out.printf("%25s  %s%n", pattern, output);
    }
  }
}