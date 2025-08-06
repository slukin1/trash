package com.hbg.lib.data.main;

import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.p;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;

public class Repo {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String j11 = SP.j("main-services", b(str), "");
        d.c("DataDiffTools", "readLocalString key=" + b(str) + " value.len=" + j11.length());
        return j11;
    }

    public static String b(String str) {
        String uid = BaseModuleConfig.a().a() ? BaseModuleConfig.a().getUid() : "logout";
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + uid + Constants.ACCEPT_TIME_SEPARATOR_SERVER + p.b();
    }

    public static void c(String str, String str2) {
        if (str != null && str2 != null) {
            d.c("DataDiffTools", "writeLocalString key=" + b(str) + " value.len=" + str2.length());
            SP.w("main-services", b(str), str2);
        }
    }
}
