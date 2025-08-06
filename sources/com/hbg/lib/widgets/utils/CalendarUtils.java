package com.hbg.lib.widgets.utils;

import java.util.Calendar;

public class CalendarUtils {
    public static int a(int i11) {
        if (i11 == 0 || Math.abs(i11) > 12) {
            return 0;
        }
        Calendar instance = Calendar.getInstance();
        int i12 = instance.get(6);
        instance.add(2, -i11);
        int i13 = instance.get(6);
        if (i13 >= i12) {
            i12 += 365;
        }
        return i12 - i13;
    }

    public static long b(int i11, int i12, int i13) {
        Calendar instance = Calendar.getInstance();
        instance.set(i11, i12, i13);
        return instance.getTimeInMillis();
    }
}
