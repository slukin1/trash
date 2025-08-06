package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.h;

public interface f {
    void a(Writer writer, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException;

    void b(StringBuffer stringBuffer, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale);

    void c(Writer writer, h hVar, Locale locale) throws IOException;

    void d(StringBuffer stringBuffer, h hVar, Locale locale);

    int estimatePrintedLength();
}
