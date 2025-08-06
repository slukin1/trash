package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.h;

public class g implements m {

    /* renamed from: b  reason: collision with root package name */
    public final f f23229b;

    public g(f fVar) {
        this.f23229b = fVar;
    }

    public static m a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new g(fVar);
    }

    public int estimatePrintedLength() {
        return this.f23229b.estimatePrintedLength();
    }

    public void printTo(Appendable appendable, long j11, Chronology chronology, int i11, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        Appendable appendable2 = appendable;
        if (appendable2 instanceof StringBuffer) {
            this.f23229b.b((StringBuffer) appendable2, j11, chronology, i11, dateTimeZone, locale);
        }
        if (appendable2 instanceof Writer) {
            this.f23229b.a((Writer) appendable2, j11, chronology, i11, dateTimeZone, locale);
        }
        StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
        this.f23229b.b(stringBuffer, j11, chronology, i11, dateTimeZone, locale);
        appendable.append(stringBuffer);
    }

    public void printTo(Appendable appendable, h hVar, Locale locale) throws IOException {
        if (appendable instanceof StringBuffer) {
            this.f23229b.d((StringBuffer) appendable, hVar, locale);
        }
        if (appendable instanceof Writer) {
            this.f23229b.c((Writer) appendable, hVar, locale);
        }
        StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
        this.f23229b.d(stringBuffer, hVar, locale);
        appendable.append(stringBuffer);
    }
}
