package com.tencent.liteav.videobase.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.liteav.base.ContextUtils;
import java.util.ArrayList;
import java.util.HashMap;

public final class d {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f22256f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static d f22257g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f22258a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<b>> f22259b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f22260c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f22261d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f22262e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f22264a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<b> f22265b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.f22264a = intent;
            this.f22265b = arrayList;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f22266a;

        /* renamed from: b  reason: collision with root package name */
        public final BroadcastReceiver f22267b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22268c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22269d;

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f22267b);
            sb2.append(" filter=");
            sb2.append(this.f22266a);
            if (this.f22269d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    private d(Context context) {
        this.f22258a = context;
        this.f22262e = new Handler(context.getMainLooper()) {
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
                r3 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
                if (r3 >= r1) goto L_0x0007;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
                r4 = r2[r3];
                r5 = r4.f22265b.size();
                r6 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
                if (r6 >= r5) goto L_0x0048;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
                r7 = r4.f22265b.get(r6);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
                if (r7.f22269d != false) goto L_0x0045;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
                r7.f22267b.onReceive(r11.f22258a, r4.f22264a);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
                r6 = r6 + 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
                r3 = r3 + 1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r11) {
                /*
                    r10 = this;
                    int r0 = r11.what
                    r1 = 1
                    if (r0 != r1) goto L_0x004e
                    com.tencent.liteav.videobase.utils.d r11 = com.tencent.liteav.videobase.utils.d.this
                L_0x0007:
                    java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.tencent.liteav.videobase.utils.d$b>> r0 = r11.f22259b
                    monitor-enter(r0)
                    java.util.ArrayList<com.tencent.liteav.videobase.utils.d$a> r1 = r11.f22260c     // Catch:{ all -> 0x004b }
                    int r1 = r1.size()     // Catch:{ all -> 0x004b }
                    if (r1 > 0) goto L_0x0014
                    monitor-exit(r0)     // Catch:{ all -> 0x004b }
                    return
                L_0x0014:
                    com.tencent.liteav.videobase.utils.d$a[] r2 = new com.tencent.liteav.videobase.utils.d.a[r1]     // Catch:{ all -> 0x004b }
                    java.util.ArrayList<com.tencent.liteav.videobase.utils.d$a> r3 = r11.f22260c     // Catch:{ all -> 0x004b }
                    r3.toArray(r2)     // Catch:{ all -> 0x004b }
                    java.util.ArrayList<com.tencent.liteav.videobase.utils.d$a> r3 = r11.f22260c     // Catch:{ all -> 0x004b }
                    r3.clear()     // Catch:{ all -> 0x004b }
                    monitor-exit(r0)     // Catch:{ all -> 0x004b }
                    r0 = 0
                    r3 = r0
                L_0x0023:
                    if (r3 >= r1) goto L_0x0007
                    r4 = r2[r3]
                    java.util.ArrayList<com.tencent.liteav.videobase.utils.d$b> r5 = r4.f22265b
                    int r5 = r5.size()
                    r6 = r0
                L_0x002e:
                    if (r6 >= r5) goto L_0x0048
                    java.util.ArrayList<com.tencent.liteav.videobase.utils.d$b> r7 = r4.f22265b
                    java.lang.Object r7 = r7.get(r6)
                    com.tencent.liteav.videobase.utils.d$b r7 = (com.tencent.liteav.videobase.utils.d.b) r7
                    boolean r8 = r7.f22269d
                    if (r8 != 0) goto L_0x0045
                    android.content.BroadcastReceiver r7 = r7.f22267b
                    android.content.Context r8 = r11.f22258a
                    android.content.Intent r9 = r4.f22264a
                    r7.onReceive(r8, r9)
                L_0x0045:
                    int r6 = r6 + 1
                    goto L_0x002e
                L_0x0048:
                    int r3 = r3 + 1
                    goto L_0x0023
                L_0x004b:
                    r11 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x004b }
                    throw r11
                L_0x004e:
                    super.handleMessage(r11)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.utils.d.AnonymousClass1.handleMessage(android.os.Message):void");
            }
        };
    }

    public static d a() {
        d dVar;
        synchronized (f22256f) {
            if (f22257g == null) {
                f22257g = new d(ContextUtils.getApplicationContext());
            }
            dVar = f22257g;
        }
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0156, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0158, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.tencent.liteav.videobase.utils.d$b>> r2 = r1.f22259b
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x015a }
            android.content.Context r3 = r1.f22258a     // Catch:{ all -> 0x015a }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x015a }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x015a }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x015a }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x015a }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x015a }
            int r3 = r22.getFlags()     // Catch:{ all -> 0x015a }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002c
            r16 = 1
            goto L_0x002e
        L_0x002c:
            r16 = 0
        L_0x002e:
            if (r16 == 0) goto L_0x0053
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            java.lang.String r5 = "Resolving type "
            r4.<init>(r5)     // Catch:{ all -> 0x015a }
            r4.append(r11)     // Catch:{ all -> 0x015a }
            java.lang.String r5 = " scheme "
            r4.append(r5)     // Catch:{ all -> 0x015a }
            r4.append(r13)     // Catch:{ all -> 0x015a }
            java.lang.String r5 = " of intent "
            r4.append(r5)     // Catch:{ all -> 0x015a }
            r4.append(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015a }
            com.tencent.liteav.base.util.LiteavLog.v(r3, r4)     // Catch:{ all -> 0x015a }
        L_0x0053:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.tencent.liteav.videobase.utils.d$b>> r3 = r1.f22261d     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x015a }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x015a }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x0157
            if (r16 == 0) goto L_0x0073
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "Action list: "
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x015a }
            com.tencent.liteav.base.util.LiteavLog.v(r3, r4)     // Catch:{ all -> 0x015a }
        L_0x0073:
            r3 = 0
            r7 = r3
            r6 = 0
        L_0x0076:
            int r3 = r8.size()     // Catch:{ all -> 0x015a }
            if (r6 >= r3) goto L_0x0127
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x015a }
            r5 = r3
            com.tencent.liteav.videobase.utils.d$b r5 = (com.tencent.liteav.videobase.utils.d.b) r5     // Catch:{ all -> 0x015a }
            if (r16 == 0) goto L_0x009a
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "Matching against filter "
            r4.<init>(r9)     // Catch:{ all -> 0x015a }
            android.content.IntentFilter r9 = r5.f22266a     // Catch:{ all -> 0x015a }
            r4.append(r9)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015a }
            com.tencent.liteav.base.util.LiteavLog.v(r3, r4)     // Catch:{ all -> 0x015a }
        L_0x009a:
            boolean r3 = r5.f22268c     // Catch:{ all -> 0x015a }
            if (r3 == 0) goto L_0x00b3
            if (r16 == 0) goto L_0x00a7
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "  Filter's target already added"
            com.tencent.liteav.base.util.LiteavLog.v(r3, r4)     // Catch:{ all -> 0x015a }
        L_0x00a7:
            r17 = r6
            r19 = r8
            r18 = r10
            r20 = r11
            r11 = 1
            r10 = r7
            goto L_0x011c
        L_0x00b3:
            android.content.IntentFilter r3 = r5.f22266a     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r17 = r6
            r6 = r13
            r18 = r10
            r10 = r7
            r7 = r12
            r19 = r8
            r8 = r14
            r20 = r11
            r11 = 1
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x015a }
            if (r3 < 0) goto L_0x00f5
            if (r16 == 0) goto L_0x00e6
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            java.lang.String r6 = "  Filter matched!  match=0x"
            r5.<init>(r6)     // Catch:{ all -> 0x015a }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x015a }
            r5.append(r3)     // Catch:{ all -> 0x015a }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x015a }
            com.tencent.liteav.base.util.LiteavLog.v(r4, r3)     // Catch:{ all -> 0x015a }
        L_0x00e6:
            if (r10 != 0) goto L_0x00ee
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x015a }
            r7.<init>()     // Catch:{ all -> 0x015a }
            goto L_0x00ef
        L_0x00ee:
            r7 = r10
        L_0x00ef:
            r7.add(r15)     // Catch:{ all -> 0x015a }
            r15.f22268c = r11     // Catch:{ all -> 0x015a }
            goto L_0x011d
        L_0x00f5:
            if (r16 == 0) goto L_0x011c
            r4 = -4
            if (r3 == r4) goto L_0x010f
            r4 = -3
            if (r3 == r4) goto L_0x010c
            r4 = -2
            if (r3 == r4) goto L_0x0109
            r4 = -1
            if (r3 == r4) goto L_0x0106
            java.lang.String r3 = "unknown reason"
            goto L_0x0111
        L_0x0106:
            java.lang.String r3 = "type"
            goto L_0x0111
        L_0x0109:
            java.lang.String r3 = "data"
            goto L_0x0111
        L_0x010c:
            java.lang.String r3 = "action"
            goto L_0x0111
        L_0x010f:
            java.lang.String r3 = "category"
        L_0x0111:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.String r5 = "  Filter did not match: "
            java.lang.String r3 = r5.concat(r3)     // Catch:{ all -> 0x015a }
            com.tencent.liteav.base.util.LiteavLog.v(r4, r3)     // Catch:{ all -> 0x015a }
        L_0x011c:
            r7 = r10
        L_0x011d:
            int r6 = r17 + 1
            r10 = r18
            r8 = r19
            r11 = r20
            goto L_0x0076
        L_0x0127:
            r10 = r7
            r11 = 1
            if (r10 == 0) goto L_0x0157
            r3 = 0
        L_0x012c:
            int r4 = r10.size()     // Catch:{ all -> 0x015a }
            if (r3 >= r4) goto L_0x013e
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x015a }
            com.tencent.liteav.videobase.utils.d$b r4 = (com.tencent.liteav.videobase.utils.d.b) r4     // Catch:{ all -> 0x015a }
            r5 = 0
            r4.f22268c = r5     // Catch:{ all -> 0x015a }
            int r3 = r3 + 1
            goto L_0x012c
        L_0x013e:
            java.util.ArrayList<com.tencent.liteav.videobase.utils.d$a> r3 = r1.f22260c     // Catch:{ all -> 0x015a }
            com.tencent.liteav.videobase.utils.d$a r4 = new com.tencent.liteav.videobase.utils.d$a     // Catch:{ all -> 0x015a }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x015a }
            r3.add(r4)     // Catch:{ all -> 0x015a }
            android.os.Handler r0 = r1.f22262e     // Catch:{ all -> 0x015a }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0155
            android.os.Handler r0 = r1.f22262e     // Catch:{ all -> 0x015a }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x015a }
        L_0x0155:
            monitor-exit(r2)     // Catch:{ all -> 0x015a }
            return r11
        L_0x0157:
            monitor-exit(r2)     // Catch:{ all -> 0x015a }
            r0 = 0
            return r0
        L_0x015a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x015a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.utils.d.a(android.content.Intent):boolean");
    }
}
