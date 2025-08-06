package m20;

import com.engagelab.privates.push.constants.MTPushConstants;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.MutableInterval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.f;
import org.joda.time.field.e;
import org.joda.time.format.b;
import org.joda.time.format.i;
import org.joda.time.g;

public abstract class d implements g {
    public void checkInterval(long j11, long j12) {
        if (j12 < j11) {
            throw new IllegalArgumentException("The end instant must be greater or equal to the start");
        }
    }

    public boolean contains(long j11) {
        return j11 >= getStartMillis() && j11 < getEndMillis();
    }

    public boolean containsNow() {
        return contains(a.b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (getStartMillis() == gVar.getStartMillis() && getEndMillis() == gVar.getEndMillis() && e.a(getChronology(), gVar.getChronology())) {
            return true;
        }
        return false;
    }

    public DateTime getEnd() {
        return new DateTime(getEndMillis(), getChronology());
    }

    public DateTime getStart() {
        return new DateTime(getStartMillis(), getChronology());
    }

    public int hashCode() {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        return ((((MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS + ((int) (startMillis ^ (startMillis >>> 32)))) * 31) + ((int) (endMillis ^ (endMillis >>> 32)))) * 31) + getChronology().hashCode();
    }

    public boolean isAfter(long j11) {
        return getStartMillis() > j11;
    }

    public boolean isAfterNow() {
        return isAfter(a.b());
    }

    public boolean isBefore(long j11) {
        return getEndMillis() <= j11;
    }

    public boolean isBeforeNow() {
        return isBefore(a.b());
    }

    public boolean isEqual(g gVar) {
        return getStartMillis() == gVar.getStartMillis() && getEndMillis() == gVar.getEndMillis();
    }

    public boolean overlaps(g gVar) {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        if (gVar == null) {
            long b11 = a.b();
            if (startMillis >= b11 || b11 >= endMillis) {
                return false;
            }
            return true;
        }
        long startMillis2 = gVar.getStartMillis();
        if (startMillis >= gVar.getEndMillis() || startMillis2 >= endMillis) {
            return false;
        }
        return true;
    }

    public Duration toDuration() {
        long durationMillis = toDurationMillis();
        if (durationMillis == 0) {
            return Duration.ZERO;
        }
        return new Duration(durationMillis);
    }

    public long toDurationMillis() {
        return e.e(getEndMillis(), -getStartMillis());
    }

    public Interval toInterval() {
        return new Interval(getStartMillis(), getEndMillis(), getChronology());
    }

    public MutableInterval toMutableInterval() {
        return new MutableInterval(getStartMillis(), getEndMillis(), getChronology());
    }

    public Period toPeriod() {
        return new Period(getStartMillis(), getEndMillis(), getChronology());
    }

    public String toString() {
        b u11 = i.h().u(getChronology());
        StringBuffer stringBuffer = new StringBuffer(48);
        u11.q(stringBuffer, getStartMillis());
        stringBuffer.append('/');
        u11.q(stringBuffer, getEndMillis());
        return stringBuffer.toString();
    }

    public boolean isAfter(f fVar) {
        if (fVar == null) {
            return isAfterNow();
        }
        return isAfter(fVar.getMillis());
    }

    public boolean isBefore(f fVar) {
        if (fVar == null) {
            return isBeforeNow();
        }
        return isBefore(fVar.getMillis());
    }

    public Period toPeriod(PeriodType periodType) {
        return new Period(getStartMillis(), getEndMillis(), periodType, getChronology());
    }

    public boolean contains(f fVar) {
        if (fVar == null) {
            return containsNow();
        }
        return contains(fVar.getMillis());
    }

    public boolean isAfter(g gVar) {
        long j11;
        if (gVar == null) {
            j11 = a.b();
        } else {
            j11 = gVar.getEndMillis();
        }
        return getStartMillis() >= j11;
    }

    public boolean isBefore(g gVar) {
        if (gVar == null) {
            return isBeforeNow();
        }
        return isBefore(gVar.getStartMillis());
    }

    public boolean contains(g gVar) {
        if (gVar == null) {
            return containsNow();
        }
        long startMillis = gVar.getStartMillis();
        long endMillis = gVar.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        return startMillis2 <= startMillis && startMillis < endMillis2 && endMillis <= endMillis2;
    }
}
