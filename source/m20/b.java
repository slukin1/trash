package m20;

import com.amazonaws.services.s3.model.InstructionFileId;
import org.joda.convert.ToString;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.e;
import org.joda.time.format.h;

public abstract class b implements e {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        if (getMillis() == ((e) obj).getMillis()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long millis = getMillis();
        return (int) (millis ^ (millis >>> 32));
    }

    public boolean isEqual(e eVar) {
        if (eVar == null) {
            eVar = Duration.ZERO;
        }
        return compareTo(eVar) == 0;
    }

    public boolean isLongerThan(e eVar) {
        if (eVar == null) {
            eVar = Duration.ZERO;
        }
        return compareTo(eVar) > 0;
    }

    public boolean isShorterThan(e eVar) {
        if (eVar == null) {
            eVar = Duration.ZERO;
        }
        return compareTo(eVar) < 0;
    }

    public Duration toDuration() {
        return new Duration(getMillis());
    }

    public Period toPeriod() {
        return new Period(getMillis());
    }

    @ToString
    public String toString() {
        long millis = getMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PT");
        boolean z11 = millis < 0;
        h.f(stringBuffer, millis);
        while (true) {
            int i11 = 3;
            if (stringBuffer.length() >= (z11 ? 7 : 6)) {
                break;
            }
            if (!z11) {
                i11 = 2;
            }
            stringBuffer.insert(i11, "0");
        }
        if ((millis / 1000) * 1000 == millis) {
            stringBuffer.setLength(stringBuffer.length() - 3);
        } else {
            stringBuffer.insert(stringBuffer.length() - 3, InstructionFileId.DOT);
        }
        stringBuffer.append('S');
        return stringBuffer.toString();
    }

    public int compareTo(e eVar) {
        int i11 = (getMillis() > eVar.getMillis() ? 1 : (getMillis() == eVar.getMillis() ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 > 0 ? 1 : 0;
    }
}
