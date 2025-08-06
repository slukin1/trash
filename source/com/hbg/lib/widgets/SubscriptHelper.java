package com.hbg.lib.widgets;

import com.huobi.store.AppConfigManager;
import java.util.regex.Pattern;

public class SubscriptHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f71611a = Pattern.compile("\\.0{6}\\d*");

    public static int a(String str) {
        int i11 = 6;
        int i12 = 7;
        while (i12 < str.length() && str.charAt(i12) == '0') {
            i11++;
            i12++;
        }
        return i11;
    }

    public static boolean b() {
        return AppConfigManager.h(73, "isOpen", true);
    }
}
