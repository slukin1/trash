package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.a;
import org.joda.time.f;
import org.joda.time.h;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final m f23198a;

    /* renamed from: b  reason: collision with root package name */
    public final k f23199b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f23200c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f23201d;

    /* renamed from: e  reason: collision with root package name */
    public final Chronology f23202e;

    /* renamed from: f  reason: collision with root package name */
    public final DateTimeZone f23203f;

    /* renamed from: g  reason: collision with root package name */
    public final Integer f23204g;

    /* renamed from: h  reason: collision with root package name */
    public final int f23205h;

    public b(m mVar, k kVar) {
        this.f23198a = mVar;
        this.f23199b = kVar;
        this.f23200c = null;
        this.f23201d = false;
        this.f23202e = null;
        this.f23203f = null;
        this.f23204g = null;
        this.f23205h = 2000;
    }

    public Locale a() {
        return this.f23200c;
    }

    public c b() {
        return l.b(this.f23199b);
    }

    public k c() {
        return this.f23199b;
    }

    public m d() {
        return this.f23198a;
    }

    public DateTimeZone e() {
        return this.f23203f;
    }

    public DateTime f(String str) {
        k r11 = r();
        Chronology t11 = t((Chronology) null);
        d dVar = new d(0, t11, this.f23200c, this.f23204g, this.f23205h);
        int parseInto = r11.parseInto(dVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long l11 = dVar.l(true, str);
            if (this.f23201d && dVar.p() != null) {
                t11 = t11.withZone(DateTimeZone.forOffsetMillis(dVar.p().intValue()));
            } else if (dVar.r() != null) {
                t11 = t11.withZone(dVar.r());
            }
            DateTime dateTime = new DateTime(l11, t11);
            DateTimeZone dateTimeZone = this.f23203f;
            return dateTimeZone != null ? dateTime.withZone(dateTimeZone) : dateTime;
        }
        throw new IllegalArgumentException(h.h(str, parseInto));
    }

    public LocalDate g(String str) {
        return h(str).toLocalDate();
    }

    public LocalDateTime h(String str) {
        k r11 = r();
        Chronology withUTC = t((Chronology) null).withUTC();
        d dVar = new d(0, withUTC, this.f23200c, this.f23204g, this.f23205h);
        int parseInto = r11.parseInto(dVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long l11 = dVar.l(true, str);
            if (dVar.p() != null) {
                withUTC = withUTC.withZone(DateTimeZone.forOffsetMillis(dVar.p().intValue()));
            } else if (dVar.r() != null) {
                withUTC = withUTC.withZone(dVar.r());
            }
            return new LocalDateTime(l11, withUTC);
        }
        throw new IllegalArgumentException(h.h(str, parseInto));
    }

    public LocalTime i(String str) {
        return h(str).toLocalTime();
    }

    public long j(String str) {
        return new d(0, t(this.f23202e), this.f23200c, this.f23204g, this.f23205h).m(r(), str);
    }

    public String k(f fVar) {
        StringBuilder sb2 = new StringBuilder(s().estimatePrintedLength());
        try {
            o(sb2, fVar);
        } catch (IOException unused) {
        }
        return sb2.toString();
    }

    public String l(h hVar) {
        StringBuilder sb2 = new StringBuilder(s().estimatePrintedLength());
        try {
            p(sb2, hVar);
        } catch (IOException unused) {
        }
        return sb2.toString();
    }

    public void m(Appendable appendable, long j11) throws IOException {
        n(appendable, j11, (Chronology) null);
    }

    public final void n(Appendable appendable, long j11, Chronology chronology) throws IOException {
        long j12 = j11;
        m s11 = s();
        Chronology t11 = t(chronology);
        DateTimeZone zone = t11.getZone();
        int offset = zone.getOffset(j12);
        long j13 = (long) offset;
        long j14 = j12 + j13;
        if ((j12 ^ j14) < 0 && (j13 ^ j12) >= 0) {
            zone = DateTimeZone.UTC;
            offset = 0;
            j14 = j12;
        }
        m mVar = s11;
        Appendable appendable2 = appendable;
        long j15 = j14;
        mVar.printTo(appendable2, j15, t11.withUTC(), offset, zone, this.f23200c);
    }

    public void o(Appendable appendable, f fVar) throws IOException {
        n(appendable, a.h(fVar), a.g(fVar));
    }

    public void p(Appendable appendable, h hVar) throws IOException {
        m s11 = s();
        if (hVar != null) {
            s11.printTo(appendable, hVar, this.f23200c);
            return;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }

    public void q(StringBuffer stringBuffer, long j11) {
        try {
            m(stringBuffer, j11);
        } catch (IOException unused) {
        }
    }

    public final k r() {
        k kVar = this.f23199b;
        if (kVar != null) {
            return kVar;
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    public final m s() {
        m mVar = this.f23198a;
        if (mVar != null) {
            return mVar;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public final Chronology t(Chronology chronology) {
        Chronology c11 = a.c(chronology);
        Chronology chronology2 = this.f23202e;
        if (chronology2 != null) {
            c11 = chronology2;
        }
        DateTimeZone dateTimeZone = this.f23203f;
        return dateTimeZone != null ? c11.withZone(dateTimeZone) : c11;
    }

    public b u(Chronology chronology) {
        if (this.f23202e == chronology) {
            return this;
        }
        return new b(this.f23198a, this.f23199b, this.f23200c, this.f23201d, chronology, this.f23203f, this.f23204g, this.f23205h);
    }

    public b v(Locale locale) {
        if (locale == a() || (locale != null && locale.equals(a()))) {
            return this;
        }
        return new b(this.f23198a, this.f23199b, locale, this.f23201d, this.f23202e, this.f23203f, this.f23204g, this.f23205h);
    }

    public b w() {
        if (this.f23201d) {
            return this;
        }
        return new b(this.f23198a, this.f23199b, this.f23200c, true, this.f23202e, (DateTimeZone) null, this.f23204g, this.f23205h);
    }

    public b x(DateTimeZone dateTimeZone) {
        if (this.f23203f == dateTimeZone) {
            return this;
        }
        return new b(this.f23198a, this.f23199b, this.f23200c, false, this.f23202e, dateTimeZone, this.f23204g, this.f23205h);
    }

    public b y() {
        return x(DateTimeZone.UTC);
    }

    public b(m mVar, k kVar, Locale locale, boolean z11, Chronology chronology, DateTimeZone dateTimeZone, Integer num, int i11) {
        this.f23198a = mVar;
        this.f23199b = kVar;
        this.f23200c = locale;
        this.f23201d = z11;
        this.f23202e = chronology;
        this.f23203f = dateTimeZone;
        this.f23204g = num;
        this.f23205h = i11;
    }
}
