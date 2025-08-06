package org.cybergarage.util;

public final class TimerUtil {
    public static final void a(int i11) {
        try {
            Thread.sleep((long) ((int) (Math.random() * ((double) i11))));
        } catch (Exception unused) {
        }
    }
}
