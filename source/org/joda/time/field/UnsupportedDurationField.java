package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class UnsupportedDurationField extends DurationField implements Serializable {
    private static HashMap<DurationFieldType, UnsupportedDurationField> cCache = null;
    private static final long serialVersionUID = -6390301302770925357L;
    private final DurationFieldType iType;

    private UnsupportedDurationField(DurationFieldType durationFieldType) {
        this.iType = durationFieldType;
    }

    public static synchronized UnsupportedDurationField getInstance(DurationFieldType durationFieldType) {
        UnsupportedDurationField unsupportedDurationField;
        synchronized (UnsupportedDurationField.class) {
            HashMap<DurationFieldType, UnsupportedDurationField> hashMap = cCache;
            if (hashMap == null) {
                cCache = new HashMap<>(7);
                unsupportedDurationField = null;
            } else {
                unsupportedDurationField = hashMap.get(durationFieldType);
            }
            if (unsupportedDurationField == null) {
                unsupportedDurationField = new UnsupportedDurationField(durationFieldType);
                cCache.put(durationFieldType, unsupportedDurationField);
            }
        }
        return unsupportedDurationField;
    }

    private Object readResolve() {
        return getInstance(this.iType);
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }

    public long add(long j11, int i11) {
        throw unsupported();
    }

    public int compareTo(DurationField durationField) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsupportedDurationField)) {
            return false;
        }
        UnsupportedDurationField unsupportedDurationField = (UnsupportedDurationField) obj;
        if (unsupportedDurationField.getName() != null) {
            return unsupportedDurationField.getName().equals(getName());
        }
        if (getName() == null) {
            return true;
        }
        return false;
    }

    public int getDifference(long j11, long j12) {
        throw unsupported();
    }

    public long getDifferenceAsLong(long j11, long j12) {
        throw unsupported();
    }

    public long getMillis(int i11) {
        throw unsupported();
    }

    public String getName() {
        return this.iType.getName();
    }

    public final DurationFieldType getType() {
        return this.iType;
    }

    public long getUnitMillis() {
        return 0;
    }

    public int getValue(long j11) {
        throw unsupported();
    }

    public long getValueAsLong(long j11) {
        throw unsupported();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isPrecise() {
        return true;
    }

    public boolean isSupported() {
        return false;
    }

    public String toString() {
        return "UnsupportedDurationField[" + getName() + ']';
    }

    public long add(long j11, long j12) {
        throw unsupported();
    }

    public long getMillis(long j11) {
        throw unsupported();
    }

    public int getValue(long j11, long j12) {
        throw unsupported();
    }

    public long getValueAsLong(long j11, long j12) {
        throw unsupported();
    }

    public long getMillis(int i11, long j11) {
        throw unsupported();
    }

    public long getMillis(long j11, long j12) {
        throw unsupported();
    }
}
