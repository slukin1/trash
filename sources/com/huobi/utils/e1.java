package com.huobi.utils;

public final class e1 {
    public static String a(String str) {
        String str2;
        if (str.equalsIgnoreCase("NAS")) {
            str2 = "/detail/360000048441";
        } else if (str.equalsIgnoreCase("TRX")) {
            str2 = "/detail/360000107761";
        } else if (str.equalsIgnoreCase("LET")) {
            str2 = "/detail/360000114762";
        } else if (str.equalsIgnoreCase("ONT")) {
            str2 = "/detail/360000109562";
        } else if (str.equalsIgnoreCase("18C")) {
            str2 = "/detail/360000178942";
        } else if (str.equalsIgnoreCase("IOST")) {
            str2 = "/detail/360000219041";
        } else if (str.equalsIgnoreCase("SMT")) {
            str2 = "/detail/360000182381";
        } else {
            str2 = str.equalsIgnoreCase("IOTA") ? "/detail/360000051782" : "";
        }
        return b(c1.z(), str2);
    }

    public static String b(String str, String str2) {
        return str + d1.h() + str2;
    }
}
