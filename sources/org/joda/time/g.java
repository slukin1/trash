package org.joda.time;

public interface g {
    Chronology getChronology();

    DateTime getEnd();

    long getEndMillis();

    DateTime getStart();

    long getStartMillis();

    long toDurationMillis();

    Period toPeriod(PeriodType periodType);
}
