package org.joda.time.format;

import java.util.Locale;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.c;
import org.joda.time.i;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final p f23266a;

    /* renamed from: b  reason: collision with root package name */
    public final o f23267b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f23268c;

    /* renamed from: d  reason: collision with root package name */
    public final PeriodType f23269d;

    public n(p pVar, o oVar) {
        this.f23266a = pVar;
        this.f23267b = oVar;
        this.f23268c = null;
        this.f23269d = null;
    }

    public final void a() {
        if (this.f23267b == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
    }

    public final void b(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Period must not be null");
        }
    }

    public final void c() {
        if (this.f23266a == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
    }

    public o d() {
        return this.f23267b;
    }

    public p e() {
        return this.f23266a;
    }

    public int f(c cVar, String str, int i11) {
        a();
        b(cVar);
        return d().c(cVar, str, i11, this.f23268c);
    }

    public MutablePeriod g(String str) {
        a();
        MutablePeriod mutablePeriod = new MutablePeriod(0, this.f23269d);
        int c11 = d().c(mutablePeriod, str, 0, this.f23268c);
        if (c11 < 0) {
            c11 = ~c11;
        } else if (c11 >= str.length()) {
            return mutablePeriod;
        }
        throw new IllegalArgumentException(h.h(str, c11));
    }

    public Period h(String str) {
        a();
        return g(str).toPeriod();
    }

    public String i(i iVar) {
        c();
        b(iVar);
        p e11 = e();
        StringBuffer stringBuffer = new StringBuffer(e11.d(iVar, this.f23268c));
        e11.b(stringBuffer, iVar, this.f23268c);
        return stringBuffer.toString();
    }

    public n j(PeriodType periodType) {
        if (periodType == this.f23269d) {
            return this;
        }
        return new n(this.f23266a, this.f23267b, this.f23268c, periodType);
    }

    public n(p pVar, o oVar, Locale locale, PeriodType periodType) {
        this.f23266a = pVar;
        this.f23267b = oVar;
        this.f23268c = locale;
        this.f23269d = periodType;
    }
}
