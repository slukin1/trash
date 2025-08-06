package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eh;
import com.xiaomi.push.ei;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class at {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f52522a = new ConcurrentHashMap<>();

    public static class a extends XMPushService.j {
        public a() {
            super(17);
        }

        public String a() {
            return "RecordTimeManager clear";
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m3003a() {
            at.a().a();
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final at f52523a = new at();
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f52524a;

        /* renamed from: b  reason: collision with root package name */
        public long f52525b;

        /* renamed from: c  reason: collision with root package name */
        public long f52526c;

        /* renamed from: d  reason: collision with root package name */
        public long f52527d;

        private c() {
        }

        public long a() {
            long j11 = this.f52526c;
            long j12 = this.f52525b;
            if (j11 > j12) {
                return j11 - j12;
            }
            return 0;
        }

        public long b() {
            long j11 = this.f52527d;
            long j12 = this.f52526c;
            if (j11 > j12) {
                return j11 - j12;
            }
            return 0;
        }
    }

    public static at a() {
        return b.f52523a;
    }

    public void b(String str, long j11) {
        c remove = this.f52522a.remove(str);
        if (remove != null) {
            remove.f52527d = j11;
            a(str, remove);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3002a() {
        if (!this.f52522a.isEmpty()) {
            Iterator<Map.Entry<String, c>> it2 = this.f52522a.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (next == null || next.getValue() == null) {
                    it2.remove();
                } else {
                    c cVar = (c) next.getValue();
                    if (Math.abs(SystemClock.elapsedRealtime() - cVar.f52525b) > 10000) {
                        a((String) next.getKey(), cVar);
                        it2.remove();
                    }
                }
            }
        }
    }

    public void a(String str, long j11, long j12) {
        c cVar = new c();
        cVar.f52524a = j12;
        cVar.f52525b = j11;
        this.f52522a.put(str, cVar);
    }

    public void a(String str, long j11) {
        c cVar = this.f52522a.get(str);
        if (cVar != null) {
            cVar.f52526c = j11;
        }
    }

    private void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("xmsfVC", Long.valueOf(cVar.f52524a));
            hashMap.put("packetId", str);
            hashMap.put("pTime", Long.valueOf(cVar.a()));
            hashMap.put("bTime", Long.valueOf(cVar.b()));
            ei.a().a(new eh("msg_process_time", hashMap));
        }
    }
}
