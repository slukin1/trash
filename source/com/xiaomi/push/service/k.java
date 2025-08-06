package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.bc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Long> f52557a = new HashMap();

    public static boolean a(byte[] bArr, String str) {
        boolean z11 = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String a11 = bc.a(bArr);
            if (!TextUtils.isEmpty(a11)) {
                Map<String, Long> map = f52557a;
                synchronized (map) {
                    if (map.get(a11 + str) != null) {
                        z11 = true;
                    } else {
                        map.put(a11 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z11;
    }

    private static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = f52557a;
        ArrayList<String> arrayList = new ArrayList<>(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (elapsedRealtime - ((Long) next.getValue()).longValue() > 60000) {
                arrayList.add(next.getKey());
            }
        }
        for (String remove : arrayList) {
            f52557a.remove(remove);
        }
    }
}
