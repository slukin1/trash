package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class dz {

    /* renamed from: a  reason: collision with root package name */
    private static Vector<Pair<String, Long>> f51671a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f2761a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb2 = new StringBuilder();
        synchronized (f51671a) {
            for (int i11 = 0; i11 < f51671a.size(); i11++) {
                Pair elementAt = f51671a.elementAt(i11);
                sb2.append((String) elementAt.first);
                sb2.append(":");
                sb2.append(elementAt.second);
                if (i11 < f51671a.size() - 1) {
                    sb2.append(";");
                }
            }
            f51671a.clear();
        }
        return sb2.toString();
    }
}
