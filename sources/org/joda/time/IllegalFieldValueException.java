package org.joda.time;

import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;

public class IllegalFieldValueException extends IllegalArgumentException {
    private static final long serialVersionUID = 6305711765985447737L;
    private final DateTimeFieldType iDateTimeFieldType;
    private final DurationFieldType iDurationFieldType;
    private final String iFieldName;
    private final Number iLowerBound;
    private String iMessage;
    private final Number iNumberValue;
    private final String iStringValue;
    private final Number iUpperBound;

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, Number number2, Number number3) {
        super(createMessage(dateTimeFieldType.getName(), number, number2, number3, (String) null));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    private static String createMessage(String str, Number number, Number number2, Number number3, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Value ");
        sb2.append(number);
        sb2.append(" for ");
        sb2.append(str);
        sb2.append(' ');
        if (number2 == null) {
            if (number3 == null) {
                sb2.append("is not supported");
            } else {
                sb2.append("must not be larger than ");
                sb2.append(number3);
            }
        } else if (number3 == null) {
            sb2.append("must not be smaller than ");
            sb2.append(number2);
        } else {
            sb2.append("must be in the range [");
            sb2.append(number2);
            sb2.append(',');
            sb2.append(number3);
            sb2.append(']');
        }
        if (str2 != null) {
            sb2.append(l.f34627b);
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public DateTimeFieldType getDateTimeFieldType() {
        return this.iDateTimeFieldType;
    }

    public DurationFieldType getDurationFieldType() {
        return this.iDurationFieldType;
    }

    public String getFieldName() {
        return this.iFieldName;
    }

    public Number getIllegalNumberValue() {
        return this.iNumberValue;
    }

    public String getIllegalStringValue() {
        return this.iStringValue;
    }

    public String getIllegalValueAsString() {
        String str = this.iStringValue;
        return str == null ? String.valueOf(this.iNumberValue) : str;
    }

    public Number getLowerBound() {
        return this.iLowerBound;
    }

    public String getMessage() {
        return this.iMessage;
    }

    public Number getUpperBound() {
        return this.iUpperBound;
    }

    public void prependMessage(String str) {
        if (this.iMessage == null) {
            this.iMessage = str;
        } else if (str != null) {
            this.iMessage = str + l.f34627b + this.iMessage;
        }
    }

    private static String createMessage(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Value ");
        if (str2 == null) {
            stringBuffer.append(OptionsBridge.NULL_VALUE);
        } else {
            stringBuffer.append('\"');
            stringBuffer.append(str2);
            stringBuffer.append('\"');
        }
        stringBuffer.append(" for ");
        stringBuffer.append(str);
        stringBuffer.append(' ');
        stringBuffer.append("is not supported");
        return stringBuffer.toString();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, String str) {
        super(createMessage(dateTimeFieldType.getName(), number, (Number) null, (Number) null, str));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DurationFieldType durationFieldType, Number number, Number number2, Number number3) {
        super(createMessage(durationFieldType.getName(), number, number2, number3, (String) null));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = durationFieldType;
        this.iFieldName = durationFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(String str, Number number, Number number2, Number number3) {
        super(createMessage(str, number, number2, number3, (String) null));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = null;
        this.iFieldName = str;
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, String str) {
        super(createMessage(dateTimeFieldType.getName(), str));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iStringValue = str;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DurationFieldType durationFieldType, String str) {
        super(createMessage(durationFieldType.getName(), str));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = durationFieldType;
        this.iFieldName = durationFieldType.getName();
        this.iStringValue = str;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(String str, String str2) {
        super(createMessage(str, str2));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = null;
        this.iFieldName = str;
        this.iStringValue = str2;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }
}
