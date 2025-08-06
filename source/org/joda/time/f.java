package org.joda.time;

public interface f extends Comparable<f> {
    int get(DateTimeFieldType dateTimeFieldType);

    Chronology getChronology();

    long getMillis();

    boolean isBefore(f fVar);

    Instant toInstant();
}
