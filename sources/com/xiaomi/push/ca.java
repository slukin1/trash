package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

public class ca {

    /* renamed from: a  reason: collision with root package name */
    private static String f51477a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f2590a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f2590a = simpleDateFormat;
        f51477a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gk gkVar = new gk();
        gkVar.d("category_push_stat");
        gkVar.a("push_sdk_stat_channel");
        gkVar.a(1);
        gkVar.b(str);
        gkVar.a(true);
        gkVar.b(System.currentTimeMillis());
        gkVar.g(bo.a(context).a());
        gkVar.e("com.xiaomi.xmsf");
        gkVar.f("");
        gkVar.c("push_stat");
        return gkVar;
    }
}
