package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.h;

public interface m {
    int estimatePrintedLength();

    void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException;

    void printTo(Appendable appendable, h hVar, Locale locale) throws IOException;
}
