package com.sesami.smart_banking_service.common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    // Formatting patterns (define only as needed)
    public static final DateTimeFormatter OUT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter OUT_TIME_FORMAT = DateTimeFormatter.ofPattern("H:mm:ss");
    public static final DateTimeFormatter OUT_DATETIME_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy H:mm:ss");
    public static final DateTimeFormatter OUT_TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("d/M/yy H:mm:ss.SSS");

    public static final DateTimeFormatter IN_DATE_FORMAT = DateTimeFormatter.ofPattern("d/M/yy");
    public static final DateTimeFormatter IN_TIME_FORMAT = DateTimeFormatter.ofPattern("H:mm:ss");
    public static final DateTimeFormatter IN_DATETIME_FORMAT = DateTimeFormatter.ofPattern("d/M/yy H:mm:ss");
    public static final DateTimeFormatter IN_TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("d/M/yy H:mm:ss.SSS");

    public static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    // Create current LocalDateTime, LocalDate, LocalTime, Instant
    public static LocalDateTime nowDateTime() { return LocalDateTime.now(); }
    public static LocalDate nowDate() { return LocalDate.now(); }
    public static LocalTime nowTime() { return LocalTime.now(); }
    public static Instant nowInstant() { return Instant.now(); }

    // Formatting methods
    public static String format(LocalDate date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }
    public static String format(LocalTime time, DateTimeFormatter formatter) {
        return time.format(formatter);
    }
    public static String format(LocalDateTime dateTime, DateTimeFormatter formatter) {
        return dateTime.format(formatter);
    }
    public static String format(Instant instant, DateTimeFormatter formatter) {
        return formatter.withZone(ZoneId.systemDefault()).format(instant);
    }

    // Parsing methods
    public static LocalDate parseDate(String text, DateTimeFormatter formatter) {
        return LocalDate.parse(text, formatter);
    }
    public static LocalTime parseTime(String text, DateTimeFormatter formatter) {
        return LocalTime.parse(text, formatter);
    }
    public static LocalDateTime parseDateTime(String text, DateTimeFormatter formatter) {
        return LocalDateTime.parse(text, formatter);
    }

    // Difference methods (returns long, can cast to int if needed, beware overflow)
    public static long secondsDiff(LocalDateTime earlier, LocalDateTime later) {
        return ChronoUnit.SECONDS.between(earlier, later);
    }
    public static long minutesDiff(LocalDateTime earlier, LocalDateTime later) {
        return ChronoUnit.MINUTES.between(earlier, later);
    }
    public static long hoursDiff(LocalDateTime earlier, LocalDateTime later) {
        return ChronoUnit.HOURS.between(earlier, later);
    }
    public static long daysDiff(LocalDate earlier, LocalDate later) {
        return ChronoUnit.DAYS.between(earlier, later);
    }

    // Add/subtract periods
    public static LocalDateTime plus(LocalDateTime dateTime, long amount, ChronoUnit unit) {
        return dateTime.plus(amount, unit);
    }
    public static LocalDateTime minus(LocalDateTime dateTime, long amount, ChronoUnit unit) {
        return dateTime.minus(amount, unit);
    }
    public static LocalDate plusDays(LocalDate date, long days) {
        return date.plusDays(days);
    }
    public static LocalDate plusMonths(LocalDate date, long months) {
        return date.plusMonths(months);
    }
    public static LocalDate plusYears(LocalDate date, long years) {
        return date.plusYears(years);
    }

    // Equality checks
    public static boolean dateEquals(LocalDate d1, LocalDate d2) {
        return d1 != null && d2 != null && d1.isEqual(d2);
    }
    public static boolean timeEquals(LocalTime t1, LocalTime t2) {
        return t1 != null && t2 != null && t1.equals(t2);
    }
    public static boolean dateTimeEquals(LocalDateTime dt1, LocalDateTime dt2) {
        return dt1 != null && dt2 != null && dt1.equals(dt2);
    }

    // Convert legacy Date to java.time
    public static LocalDateTime toLocalDateTime(java.util.Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public static LocalDate toLocalDate(java.util.Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static LocalTime toLocalTime(java.util.Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    // Convert java.time to legacy Date (avoid unless necessary)
    public static java.util.Date toDate(LocalDateTime ldt) {
        return java.util.Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

    // Example ISO format with milliseconds
    public static String formatDate_yyyy_MM_dd_T_HH_mm_ss_SSS(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dateTime.format(formatter);
    }

    // Example: Create string from LocalDateTime in custom format
    public static String dateToString(String pattern, LocalDateTime fromDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return fromDate.format(formatter);
    }

    // Example main
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(formatDate_yyyy_MM_dd_T_HH_mm_ss_SSS(now));
        System.out.println(dateToString("ddMMyyyyHHmm", now));
        LocalDate specificDate = LocalDate.of(2025, 3, 18);
        System.out.println(format(specificDate, OUT_DATE_FORMAT));
        
        
        String formattedDate = DateUtil.dateToString("yyyyMMddHHmmss", LocalDateTime.now());
        System.out.println(formattedDate);
        
    }
}