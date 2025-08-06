package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i11) {
        if (i11 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i11 == 1) {
            return "MMMM d, y";
        }
        if (i11 == 2) {
            return "MMM d, y";
        }
        if (i11 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i11);
    }

    private static String getDatePartOfDateTimePattern(int i11) {
        if (i11 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i11 == 1) {
            return "MMMM d, yyyy";
        }
        if (i11 == 2) {
            return "MMM d, yyyy";
        }
        if (i11 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i11);
    }

    private static String getTimePartOfDateTimePattern(int i11) {
        if (i11 == 0 || i11 == 1) {
            return "h:mm:ss a z";
        }
        if (i11 == 2) {
            return "h:mm:ss a";
        }
        if (i11 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i11);
    }

    public static DateFormat getUSDateFormat(int i11) {
        return new SimpleDateFormat(getDateFormatPattern(i11), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i11, int i12) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i11) + " " + getTimePartOfDateTimePattern(i12), Locale.US);
    }
}
