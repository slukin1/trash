package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.g;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ag;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f52433a = new SparseArray<ag.a<String, String, String>>(6) {
        {
            put(1, ag.f52451g);
            put(2, ag.f52450f);
            put(4, ag.f52449e);
            put(8, ag.f52446b);
            put(16, ag.f52447c);
            put(32, ag.f52452h);
        }
    };

    private static int a(String str, int i11) {
        return ag.a(s.a(), str, (String) null, f52433a.get(i11));
    }

    private static Bundle a(String str) {
        return ag.a(s.a(), str, (String) null);
    }

    public static int a(Context context, String str) {
        int i11;
        int i12 = 0;
        if (context == null || TextUtils.isEmpty(str)) {
            b.a("context | packageName must not be null");
            return 0;
        }
        g.b a11 = g.a(context, str, true);
        if (a11 == g.b.ALLOWED) {
            i12 = 1;
        } else if (a11 == g.b.NOT_ALLOWED) {
            i12 = 2;
        }
        int i13 = 32;
        int i14 = 8;
        if (ag.a()) {
            Bundle a12 = a(str);
            ag.a<String, String, String> aVar = ag.f52451g;
            if (a12.containsKey((String) aVar.f52455c)) {
                if (a12.getBoolean((String) aVar.f52455c)) {
                    i14 = 4;
                }
                i12 |= i14;
            }
            ag.a<String, String, String> aVar2 = ag.f52449e;
            if (a12.containsKey((String) aVar2.f52455c)) {
                if (a12.getBoolean((String) aVar2.f52455c)) {
                    i13 = 16;
                }
                i12 |= i13;
            }
            ag.a<String, String, String> aVar3 = ag.f52450f;
            if (a12.containsKey((String) aVar3.f52455c)) {
                i12 |= a12.getBoolean((String) aVar3.f52455c) ? 64 : 128;
            }
            ag.a<String, String, String> aVar4 = ag.f52446b;
            if (a12.containsKey((String) aVar4.f52455c)) {
                i12 |= a12.getBoolean((String) aVar4.f52455c) ? 256 : 512;
            }
            ag.a<String, String, String> aVar5 = ag.f52447c;
            if (a12.containsKey((String) aVar5.f52455c)) {
                i12 |= a12.getBoolean((String) aVar5.f52455c) ? 1024 : 2048;
            }
            ag.a<String, String, String> aVar6 = ag.f52452h;
            if (!a12.containsKey((String) aVar6.f52455c)) {
                return i12;
            }
            return i12 | (a12.getBoolean((String) aVar6.f52455c) ? 4096 : 8192);
        }
        int a13 = a(str, 1);
        if (a13 == 1) {
            i12 |= 4;
        } else if (a13 == 0) {
            i12 |= 8;
        }
        int a14 = a(str, 4);
        if (a14 == 1) {
            i12 |= 16;
        } else if (a14 == 0) {
            i12 |= 32;
        }
        int a15 = a(str, 2);
        if (a15 == 1) {
            i12 |= 64;
        } else if (a15 == 0) {
            i12 |= 128;
        }
        int a16 = a(str, 8);
        if (a16 == 1) {
            i12 |= 256;
        } else if (a16 == 0) {
            i12 |= 512;
        }
        int a17 = a(str, 16);
        if (a17 == 1) {
            i12 |= 1024;
        } else if (a17 == 0) {
            i12 |= 2048;
        }
        int a18 = a(str, 32);
        if (a18 == 1) {
            i11 = i12 | 4096;
        } else if (a18 != 0) {
            return i12;
        } else {
            i11 = i12 | 8192;
        }
        return i11;
    }
}
