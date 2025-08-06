package org.joda.time.field;

import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.f;
import org.joda.time.h;

public abstract class a {
    public int compareTo(f fVar) {
        if (fVar != null) {
            int i11 = get();
            int i12 = fVar.get(getFieldType());
            if (i11 < i12) {
                return -1;
            }
            return i11 > i12 ? 1 : 0;
        }
        throw new IllegalArgumentException("The instant must not be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (get() == aVar.get() && getFieldType() == aVar.getFieldType() && e.a(getReadablePartial().getChronology(), aVar.getReadablePartial().getChronology())) {
            return true;
        }
        return false;
    }

    public abstract int get();

    public String getAsShortText() {
        return getAsShortText((Locale) null);
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText((Locale) null);
    }

    public DurationField getDurationField() {
        return getField().getDurationField();
    }

    public abstract DateTimeField getField();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getReadablePartial());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public int getMinimumValue() {
        return getField().getMinimumValue(getReadablePartial());
    }

    public int getMinimumValueOverall() {
        return getField().getMinimumValue();
    }

    public String getName() {
        return getField().getName();
    }

    public DurationField getRangeDurationField() {
        return getField().getRangeDurationField();
    }

    public abstract h getReadablePartial();

    public int hashCode() {
        return ((((TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS + get()) * 13) + getFieldType().hashCode()) * 13) + getReadablePartial().getChronology().hashCode();
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getReadablePartial(), get(), locale);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getReadablePartial(), get(), locale);
    }

    public int compareTo(h hVar) {
        if (hVar != null) {
            int i11 = get();
            int i12 = hVar.get(getFieldType());
            if (i11 < i12) {
                return -1;
            }
            return i11 > i12 ? 1 : 0;
        }
        throw new IllegalArgumentException("The instant must not be null");
    }
}
