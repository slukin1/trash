package com.hbg.lib.core.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import i6.d;
import java.io.File;
import java.util.UUID;

public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68725a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f68726b;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.DIRECTORY_PICTURES);
        String str = File.separator;
        sb2.append(str);
        sb2.append("hbg");
        f68725a = sb2.toString();
        f68726b = Environment.getExternalStorageDirectory().getAbsolutePath() + str + ".hbg-uuid";
    }

    public static String a() {
        Application b11 = BaseApplication.b();
        String b12 = b(b11);
        if (b12 != null) {
            d.c("UUIDUtilsTag", "生成的UUID:" + b12);
            return b12;
        }
        String uuid = UUID.randomUUID().toString();
        c(b11, uuid);
        d.c("UUIDUtilsTag", "UUIDUtils生成的UUID:" + uuid);
        return uuid;
    }

    public static String b(Context context) {
        String e11 = ConfigPreferences.e("user_config", "huobi_uuid", "");
        if (!TextUtils.isEmpty(e11)) {
            return e11;
        }
        return null;
    }

    public static void c(Context context, String str) {
        ConfigPreferences.m("user_config", "huobi_uuid", str);
    }
}
