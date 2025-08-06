package org.joda.time;

public interface h extends Comparable<h> {
    int get(DateTimeFieldType dateTimeFieldType);

    Chronology getChronology();

    DateTimeField getField(int i11);

    DateTimeFieldType getFieldType(int i11);

    int getValue(int i11);

    boolean isSupported(DateTimeFieldType dateTimeFieldType);

    int size();
}
