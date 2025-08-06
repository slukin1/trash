package org.joda.time;

import org.joda.time.format.a;

public class IllegalInstantException extends IllegalArgumentException {
    private static final long serialVersionUID = 2858712538216L;

    public IllegalInstantException(String str) {
        super(str);
    }

    private static String createMessage(long j11, String str) {
        String str2;
        String k11 = a.b("yyyy-MM-dd'T'HH:mm:ss.SSS").k(new Instant(j11));
        if (str != null) {
            str2 = " (" + str + ")";
        } else {
            str2 = "";
        }
        return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + k11 + str2;
    }

    public static boolean isIllegalInstant(Throwable th2) {
        if (th2 instanceof IllegalInstantException) {
            return true;
        }
        if (th2.getCause() == null || th2.getCause() == th2) {
            return false;
        }
        return isIllegalInstant(th2.getCause());
    }

    public IllegalInstantException(long j11, String str) {
        super(createMessage(j11, str));
    }
}
