package jp.co.nile.domains.models.shared;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class NileDateUtils {
  NileDateUtils() {}

  public static Date toDate(LocalDate localDate) {

    return Date.from(
        localDate
            .atStartOfDay(ZoneId.of("Asia/Tokyo"))
            .toInstant());
  }

  public static LocalDate toLocalDate(Date date) {
    return date
        .toInstant()
        .atZone(ZoneId.of("Asia/Tokyo"))
        .toLocalDate();
  }
}
