package com.tencent.qcloud.tuikit.tuicallengine.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public static Context f48368a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, p> f48369b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f48370c;

    public p(String str, int i11) {
        this.f48370c = f48368a.getSharedPreferences(str, i11);
    }

    public static p a(Context context, String str) {
        boolean z11;
        f48368a = context;
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = true;
                break;
            } else if (!Character.isWhitespace(str.charAt(i11))) {
                z11 = false;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            str = "profile_call_base";
        }
        Map<String, p> map = f48369b;
        p pVar = map.get(str);
        if (pVar == null) {
            synchronized (p.class) {
                pVar = map.get(str);
                if (pVar == null) {
                    pVar = new p(str, 0);
                    map.put(str, pVar);
                }
            }
        }
        return pVar;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f48370c.edit().putString(str, str2).commit();
        }
    }

    public void a() {
        this.f48370c.edit().clear().commit();
    }
}
