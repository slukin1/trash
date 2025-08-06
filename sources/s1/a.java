package s1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f16487f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static a f16488g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f16489a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f16490b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f16491c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<b> f16492d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final Handler f16493e;

    /* renamed from: s1.a$a  reason: collision with other inner class name */
    public class C0100a extends Handler {
        public C0100a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f16495a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<c> f16496b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f16495a = intent;
            this.f16496b = arrayList;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f16497a;

        /* renamed from: b  reason: collision with root package name */
        public final BroadcastReceiver f16498b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16499c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16500d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f16497a = intentFilter;
            this.f16498b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f16498b);
            sb2.append(" filter=");
            sb2.append(this.f16497a);
            if (this.f16500d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a(Context context) {
        this.f16489a = context;
        this.f16493e = new C0100a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f16487f) {
            if (f16488g == null) {
                f16488g = new a(context.getApplicationContext());
            }
            aVar = f16488g;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = r4.f16496b.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r6 >= r5) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r7 = r4.f16496b.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r7.f16500d != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r7.f16498b.onReceive(r10.f16489a, r4.f16495a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<s1.a$c>> r0 = r10.f16490b
            monitor-enter(r0)
            java.util.ArrayList<s1.a$b> r1 = r10.f16492d     // Catch:{ all -> 0x0044 }
            int r1 = r1.size()     // Catch:{ all -> 0x0044 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x000d:
            s1.a$b[] r2 = new s1.a.b[r1]     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<s1.a$b> r3 = r10.f16492d     // Catch:{ all -> 0x0044 }
            r3.toArray(r2)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<s1.a$b> r3 = r10.f16492d     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            r0 = 0
            r3 = r0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<s1.a$c> r5 = r4.f16496b
            int r5 = r5.size()
            r6 = r0
        L_0x0027:
            if (r6 >= r5) goto L_0x0041
            java.util.ArrayList<s1.a$c> r7 = r4.f16496b
            java.lang.Object r7 = r7.get(r6)
            s1.a$c r7 = (s1.a.c) r7
            boolean r8 = r7.f16500d
            if (r8 != 0) goto L_0x003e
            android.content.BroadcastReceiver r7 = r7.f16498b
            android.content.Context r8 = r10.f16489a
            android.content.Intent r9 = r4.f16495a
            r7.onReceive(r8, r9)
        L_0x003e:
            int r6 = r6 + 1
            goto L_0x0027
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.a.a():void");
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f16490b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.f16490b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f16490b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                String action = intentFilter.getAction(i11);
                ArrayList arrayList2 = this.f16491c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f16491c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0171, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0173, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<s1.a$c>> r2 = r1.f16490b
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x0175 }
            android.content.Context r3 = r1.f16489a     // Catch:{ all -> 0x0175 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0175 }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0175 }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x0175 }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x0175 }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x0175 }
            int r3 = r22.getFlags()     // Catch:{ all -> 0x0175 }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002c
            r16 = 1
            goto L_0x002e
        L_0x002c:
            r16 = 0
        L_0x002e:
            if (r16 == 0) goto L_0x0056
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = "Resolving type "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r11)     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = " scheme "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r13)     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = " of intent "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r0)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x0056:
            java.util.HashMap<java.lang.String, java.util.ArrayList<s1.a$c>> r3 = r1.f16491c     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x0175 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0175 }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x0175 }
            if (r8 == 0) goto L_0x0172
            if (r16 == 0) goto L_0x007d
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = "Action list: "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r8)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x007d:
            r3 = 0
            r7 = r3
            r6 = 0
        L_0x0080:
            int r3 = r8.size()     // Catch:{ all -> 0x0175 }
            if (r6 >= r3) goto L_0x0142
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x0175 }
            r5 = r3
            s1.a$c r5 = (s1.a.c) r5     // Catch:{ all -> 0x0175 }
            if (r16 == 0) goto L_0x00a7
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r9 = "Matching against filter "
            r4.append(r9)     // Catch:{ all -> 0x0175 }
            android.content.IntentFilter r9 = r5.f16497a     // Catch:{ all -> 0x0175 }
            r4.append(r9)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x00a7:
            boolean r3 = r5.f16499c     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x00c0
            if (r16 == 0) goto L_0x00b4
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "  Filter's target already added"
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x00b4:
            r17 = r6
            r19 = r8
            r18 = r10
            r20 = r11
            r11 = 1
            r10 = r7
            goto L_0x0137
        L_0x00c0:
            android.content.IntentFilter r3 = r5.f16497a     // Catch:{ all -> 0x0175 }
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
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0175 }
            if (r3 < 0) goto L_0x0105
            if (r16 == 0) goto L_0x00f6
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r5.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r6 = "  Filter matched!  match=0x"
            r5.append(r6)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0175 }
            r5.append(r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0175 }
        L_0x00f6:
            if (r10 != 0) goto L_0x00fe
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0175 }
            r7.<init>()     // Catch:{ all -> 0x0175 }
            goto L_0x00ff
        L_0x00fe:
            r7 = r10
        L_0x00ff:
            r7.add(r15)     // Catch:{ all -> 0x0175 }
            r15.f16499c = r11     // Catch:{ all -> 0x0175 }
            goto L_0x0138
        L_0x0105:
            if (r16 == 0) goto L_0x0137
            r4 = -4
            if (r3 == r4) goto L_0x011f
            r4 = -3
            if (r3 == r4) goto L_0x011c
            r4 = -2
            if (r3 == r4) goto L_0x0119
            r4 = -1
            if (r3 == r4) goto L_0x0116
            java.lang.String r3 = "unknown reason"
            goto L_0x0121
        L_0x0116:
            java.lang.String r3 = "type"
            goto L_0x0121
        L_0x0119:
            java.lang.String r3 = "data"
            goto L_0x0121
        L_0x011c:
            java.lang.String r3 = "action"
            goto L_0x0121
        L_0x011f:
            java.lang.String r3 = "category"
        L_0x0121:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r5.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r6 = "  Filter did not match: "
            r5.append(r6)     // Catch:{ all -> 0x0175 }
            r5.append(r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0175 }
        L_0x0137:
            r7 = r10
        L_0x0138:
            int r6 = r17 + 1
            r10 = r18
            r8 = r19
            r11 = r20
            goto L_0x0080
        L_0x0142:
            r10 = r7
            r11 = 1
            if (r10 == 0) goto L_0x0172
            r3 = 0
        L_0x0147:
            int r4 = r10.size()     // Catch:{ all -> 0x0175 }
            if (r3 >= r4) goto L_0x0159
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0175 }
            s1.a$c r4 = (s1.a.c) r4     // Catch:{ all -> 0x0175 }
            r5 = 0
            r4.f16499c = r5     // Catch:{ all -> 0x0175 }
            int r3 = r3 + 1
            goto L_0x0147
        L_0x0159:
            java.util.ArrayList<s1.a$b> r3 = r1.f16492d     // Catch:{ all -> 0x0175 }
            s1.a$b r4 = new s1.a$b     // Catch:{ all -> 0x0175 }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x0175 }
            r3.add(r4)     // Catch:{ all -> 0x0175 }
            android.os.Handler r0 = r1.f16493e     // Catch:{ all -> 0x0175 }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x0175 }
            if (r0 != 0) goto L_0x0170
            android.os.Handler r0 = r1.f16493e     // Catch:{ all -> 0x0175 }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x0175 }
        L_0x0170:
            monitor-exit(r2)     // Catch:{ all -> 0x0175 }
            return r11
        L_0x0172:
            monitor-exit(r2)     // Catch:{ all -> 0x0175 }
            r0 = 0
            return r0
        L_0x0175:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0175 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.a.d(android.content.Intent):boolean");
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f16490b) {
            ArrayList remove = this.f16490b.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = (c) remove.get(size);
                    cVar.f16500d = true;
                    for (int i11 = 0; i11 < cVar.f16497a.countActions(); i11++) {
                        String action = cVar.f16497a.getAction(i11);
                        ArrayList arrayList = this.f16491c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList.get(size2);
                                if (cVar2.f16498b == broadcastReceiver) {
                                    cVar2.f16500d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f16491c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
