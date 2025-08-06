package com.hbg.lib.common.utils;

import com.huobi.woodpecker.WoodPeckerSDK;
import i6.k;

public class LogAndWoodRecorder {
    public static void a(String str, String str2) {
        k.d(str, str2);
        WoodPeckerSDK.f().g().c(str, str2, "");
    }

    public static void b(String str, String str2) {
        k.f(str, str2);
        WoodPeckerSDK.f().g().c(str, str2, "");
    }

    public static void c(String str, String str2) {
        k.o(str, str2);
        WoodPeckerSDK.f().g().c(str, str2, "");
    }
}
