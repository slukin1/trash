package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Pair<String, byte[]>> f52594a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Map<String, byte[]> f3419a = new HashMap();

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = f3419a;
        synchronized (map) {
            b.a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f52594a) {
            f52594a.add(new Pair(str, bArr));
            if (f52594a.size() > 50) {
                f52594a.remove(0);
            }
        }
    }

    public static void a(XMPushService xMPushService, boolean z11) {
        try {
            Map<String, byte[]> map = f3419a;
            synchronized (map) {
                for (String next : map.keySet()) {
                    b.a("processing pending registration request. " + next);
                    w.a(xMPushService, next, f3419a.get(next));
                    if (z11 && !com.xiaomi.push.t.a()) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception unused) {
                        }
                    }
                }
                f3419a.clear();
            }
        } catch (fj e11) {
            b.d("fail to deal with pending register request. " + e11);
            xMPushService.a(10, (Exception) e11);
        }
    }

    public static void a(Context context, int i11, String str) {
        Map<String, byte[]> map = f3419a;
        synchronized (map) {
            for (String next : map.keySet()) {
                b.a("notify registration error. " + next);
                a(context, next, f3419a.get(next), i11, str);
            }
            f3419a.clear();
        }
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f52594a) {
                arrayList = f52594a;
                f52594a = new ArrayList<>();
            }
            boolean a11 = com.xiaomi.push.t.a();
            Iterator<Pair<String, byte[]>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair next = it2.next();
                w.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!a11) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fj e11) {
            b.d("meet error when process pending message. " + e11);
            xMPushService.a(10, (Exception) e11);
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i11, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i11);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.a(str));
    }
}
