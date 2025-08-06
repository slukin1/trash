package com.tencent.ugc.videobase.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.liteav.base.ContextUtils;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<b>> mActions = new HashMap<>();
    private final Context mAppContext;
    private final Handler mMainHandler;
    private final ArrayList<a> mPendingBroadcasts = new ArrayList<>();
    private final HashMap<BroadcastReceiver, ArrayList<b>> mReceivers = new HashMap<>();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f50864a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<b> f50865b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.f50864a = intent;
            this.f50865b = arrayList;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f50866a;

        /* renamed from: b  reason: collision with root package name */
        public final BroadcastReceiver f50867b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50868c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f50869d;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f50866a = intentFilter;
            this.f50867b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f50867b);
            sb2.append(" filter=");
            sb2.append(this.f50866a);
            if (this.f50869d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mMainHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance() {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(ContextUtils.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = r4.f50865b.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r6 >= r5) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r7 = r4.f50865b.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r7.f50869d != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r7.f50867b.onReceive(r10.mAppContext, r4.f50864a);
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
    public final void executePendingBroadcasts() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$b>> r0 = r10.mReceivers
            monitor-enter(r0)
            java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$a> r1 = r10.mPendingBroadcasts     // Catch:{ all -> 0x0044 }
            int r1 = r1.size()     // Catch:{ all -> 0x0044 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x000d:
            com.tencent.ugc.videobase.utils.LocalBroadcastManager$a[] r2 = new com.tencent.ugc.videobase.utils.LocalBroadcastManager.a[r1]     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$a> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x0044 }
            r3.toArray(r2)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$a> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            r0 = 0
            r3 = r0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$b> r5 = r4.f50865b
            int r5 = r5.size()
            r6 = r0
        L_0x0027:
            if (r6 >= r5) goto L_0x0041
            java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$b> r7 = r4.f50865b
            java.lang.Object r7 = r7.get(r6)
            com.tencent.ugc.videobase.utils.LocalBroadcastManager$b r7 = (com.tencent.ugc.videobase.utils.LocalBroadcastManager.b) r7
            boolean r8 = r7.f50869d
            if (r8 != 0) goto L_0x003e
            android.content.BroadcastReceiver r7 = r7.f50867b
            android.content.Context r8 = r10.mAppContext
            android.content.Intent r9 = r4.f50864a
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.utils.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public final void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                String action = intentFilter.getAction(i11);
                ArrayList arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0156, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0158, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean sendBroadcast(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$b>> r2 = r1.mReceivers
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x015a }
            android.content.Context r3 = r1.mAppContext     // Catch:{ all -> 0x015a }
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
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$b>> r3 = r1.mActions     // Catch:{ all -> 0x015a }
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
            com.tencent.ugc.videobase.utils.LocalBroadcastManager$b r5 = (com.tencent.ugc.videobase.utils.LocalBroadcastManager.b) r5     // Catch:{ all -> 0x015a }
            if (r16 == 0) goto L_0x009a
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            java.lang.String r9 = "Matching against filter "
            r4.<init>(r9)     // Catch:{ all -> 0x015a }
            android.content.IntentFilter r9 = r5.f50866a     // Catch:{ all -> 0x015a }
            r4.append(r9)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015a }
            com.tencent.liteav.base.util.LiteavLog.v(r3, r4)     // Catch:{ all -> 0x015a }
        L_0x009a:
            boolean r3 = r5.f50868c     // Catch:{ all -> 0x015a }
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
            android.content.IntentFilter r3 = r5.f50866a     // Catch:{ all -> 0x015a }
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
            r15.f50868c = r11     // Catch:{ all -> 0x015a }
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
            com.tencent.ugc.videobase.utils.LocalBroadcastManager$b r4 = (com.tencent.ugc.videobase.utils.LocalBroadcastManager.b) r4     // Catch:{ all -> 0x015a }
            r5 = 0
            r4.f50868c = r5     // Catch:{ all -> 0x015a }
            int r3 = r3 + 1
            goto L_0x012c
        L_0x013e:
            java.util.ArrayList<com.tencent.ugc.videobase.utils.LocalBroadcastManager$a> r3 = r1.mPendingBroadcasts     // Catch:{ all -> 0x015a }
            com.tencent.ugc.videobase.utils.LocalBroadcastManager$a r4 = new com.tencent.ugc.videobase.utils.LocalBroadcastManager$a     // Catch:{ all -> 0x015a }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x015a }
            r3.add(r4)     // Catch:{ all -> 0x015a }
            android.os.Handler r0 = r1.mMainHandler     // Catch:{ all -> 0x015a }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0155
            android.os.Handler r0 = r1.mMainHandler     // Catch:{ all -> 0x015a }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.utils.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList remove = this.mReceivers.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    b bVar = (b) remove.get(size);
                    bVar.f50869d = true;
                    for (int i11 = 0; i11 < bVar.f50866a.countActions(); i11++) {
                        String action = bVar.f50866a.getAction(i11);
                        ArrayList arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = (b) arrayList.get(size2);
                                if (bVar2.f50867b == broadcastReceiver) {
                                    bVar2.f50869d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
