package com.tencent.thumbplayer.tcmedia.utils;

import android.content.Context;
import java.util.ArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f49691a = null;

    /* renamed from: b  reason: collision with root package name */
    private a f49692b = null;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f49693c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f49694d = null;

    public c(Context context, String str) {
        this.f49691a = a.a(context, str);
        String str2 = str + "_key";
        this.f49694d = str2;
        a a11 = a.a(context, str2);
        this.f49692b = a11;
        ArrayList<String> arrayList = (ArrayList) a11.b(this.f49694d);
        this.f49693c = arrayList;
        if (arrayList == null) {
            this.f49693c = new ArrayList<>();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object a() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.tencent.thumbplayer.tcmedia.utils.a r0 = r5.f49692b     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = r5.f49694d     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.b(r1)     // Catch:{ all -> 0x0050 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            int r2 = r0.size()     // Catch:{ all -> 0x0050 }
            if (r2 > 0) goto L_0x0015
            goto L_0x004e
        L_0x0015:
            r2 = 0
        L_0x0016:
            int r3 = r0.size()     // Catch:{ all -> 0x0050 }
            if (r2 >= r3) goto L_0x003d
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0050 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0050 }
            if (r4 != 0) goto L_0x003a
            com.tencent.thumbplayer.tcmedia.utils.a r4 = r5.f49691a     // Catch:{ all -> 0x0050 }
            java.lang.Object r3 = r4.b(r3)     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x003a
            if (r1 != 0) goto L_0x0037
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0050 }
            r1.<init>()     // Catch:{ all -> 0x0050 }
        L_0x0037:
            r1.add(r3)     // Catch:{ all -> 0x0050 }
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x003d:
            com.tencent.thumbplayer.tcmedia.utils.a r0 = r5.f49691a     // Catch:{ all -> 0x0050 }
            r0.a()     // Catch:{ all -> 0x0050 }
            com.tencent.thumbplayer.tcmedia.utils.a r0 = r5.f49692b     // Catch:{ all -> 0x0050 }
            r0.a()     // Catch:{ all -> 0x0050 }
            java.util.ArrayList<java.lang.String> r0 = r5.f49693c     // Catch:{ all -> 0x0050 }
            r0.clear()     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            return r1
        L_0x004e:
            monitor-exit(r5)
            return r1
        L_0x0050:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.c.a():java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            com.tencent.thumbplayer.tcmedia.utils.a r0 = r2.f49691a     // Catch:{ all -> 0x002d }
            r0.c(r3)     // Catch:{ all -> 0x002d }
            java.util.ArrayList<java.lang.String> r0 = r2.f49693c     // Catch:{ all -> 0x002d }
            r0.remove(r3)     // Catch:{ all -> 0x002d }
            com.tencent.thumbplayer.tcmedia.utils.a r3 = r2.f49692b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r2.f49694d     // Catch:{ all -> 0x002d }
            r3.c(r0)     // Catch:{ all -> 0x002d }
            java.util.ArrayList<java.lang.String> r3 = r2.f49693c     // Catch:{ all -> 0x002d }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x002b
            com.tencent.thumbplayer.tcmedia.utils.a r3 = r2.f49692b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r2.f49694d     // Catch:{ all -> 0x002d }
            java.util.ArrayList<java.lang.String> r1 = r2.f49693c     // Catch:{ all -> 0x002d }
            r3.a((java.lang.String) r0, (java.io.Serializable) r1)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r2)
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.c.a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r2, java.io.Serializable r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 == 0) goto L_0x0033
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0033
        L_0x000a:
            com.tencent.thumbplayer.tcmedia.utils.a r0 = r1.f49691a     // Catch:{ all -> 0x0030 }
            r0.c(r2)     // Catch:{ all -> 0x0030 }
            com.tencent.thumbplayer.tcmedia.utils.a r0 = r1.f49691a     // Catch:{ all -> 0x0030 }
            r0.a((java.lang.String) r2, (java.io.Serializable) r3)     // Catch:{ all -> 0x0030 }
            java.util.ArrayList<java.lang.String> r3 = r1.f49693c     // Catch:{ all -> 0x0030 }
            r3.remove(r2)     // Catch:{ all -> 0x0030 }
            java.util.ArrayList<java.lang.String> r3 = r1.f49693c     // Catch:{ all -> 0x0030 }
            r3.add(r2)     // Catch:{ all -> 0x0030 }
            com.tencent.thumbplayer.tcmedia.utils.a r2 = r1.f49692b     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = r1.f49694d     // Catch:{ all -> 0x0030 }
            r2.c(r3)     // Catch:{ all -> 0x0030 }
            com.tencent.thumbplayer.tcmedia.utils.a r2 = r1.f49692b     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = r1.f49694d     // Catch:{ all -> 0x0030 }
            java.util.ArrayList<java.lang.String> r0 = r1.f49693c     // Catch:{ all -> 0x0030 }
            r2.a((java.lang.String) r3, (java.io.Serializable) r0)     // Catch:{ all -> 0x0030 }
            monitor-exit(r1)
            return
        L_0x0030:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0033:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.c.a(java.lang.String, java.io.Serializable):void");
    }

    public synchronized Object b(String str) {
        return this.f49691a.b(str);
    }

    public synchronized ArrayList<String> b() {
        return (ArrayList) this.f49693c.clone();
    }

    public synchronized void c() {
        this.f49691a.a();
        this.f49692b.a();
        this.f49693c.clear();
    }
}
