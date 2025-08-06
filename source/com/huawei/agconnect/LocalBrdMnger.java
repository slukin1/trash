package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalBrdMnger {
    private static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final Object M_LOCK = new Object();
    private static LocalBrdMnger mInstance;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<>();

    public static class BroadcastRecord {
        public final Intent intent;
        public final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent intent2, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent2;
            this.receivers = arrayList;
        }
    }

    public static class ReceiverRecord {
        public boolean broadcasting;
        public final IntentFilter filter;
        public final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            return "Receiver{" + this.receiver + " filter=" + this.filter + "}";
        }
    }

    private LocalBrdMnger(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBrdMnger.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r5 >= r4.receivers.size()) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r4.receivers.get(r5).receiver.onReceive(r9.mAppContext, r4.intent);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executePendingBroadcasts() {
        /*
            r9 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r0 = r9.mReceivers
            monitor-enter(r0)
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$BroadcastRecord> r1 = r9.mPendingBroadcasts     // Catch:{ all -> 0x0040 }
            int r1 = r1.size()     // Catch:{ all -> 0x0040 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return
        L_0x000d:
            com.huawei.agconnect.LocalBrdMnger$BroadcastRecord[] r2 = new com.huawei.agconnect.LocalBrdMnger.BroadcastRecord[r1]     // Catch:{ all -> 0x0040 }
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$BroadcastRecord> r3 = r9.mPendingBroadcasts     // Catch:{ all -> 0x0040 }
            r3.toArray(r2)     // Catch:{ all -> 0x0040 }
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$BroadcastRecord> r3 = r9.mPendingBroadcasts     // Catch:{ all -> 0x0040 }
            r3.clear()     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            r0 = 0
            r3 = r0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            r5 = r0
        L_0x0021:
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$ReceiverRecord> r6 = r4.receivers
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x003d
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$ReceiverRecord> r6 = r4.receivers
            java.lang.Object r6 = r6.get(r5)
            com.huawei.agconnect.LocalBrdMnger$ReceiverRecord r6 = (com.huawei.agconnect.LocalBrdMnger.ReceiverRecord) r6
            android.content.BroadcastReceiver r6 = r6.receiver
            android.content.Context r7 = r9.mAppContext
            android.content.Intent r8 = r4.intent
            r6.onReceive(r7, r8)
            int r5 = r5 + 1
            goto L_0x0021
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0040:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.LocalBrdMnger.executePendingBroadcasts():void");
    }

    public static LocalBrdMnger getInstance(Context context) {
        LocalBrdMnger localBrdMnger;
        synchronized (M_LOCK) {
            if (mInstance == null) {
                mInstance = new LocalBrdMnger(context.getApplicationContext());
            }
            localBrdMnger = mInstance;
        }
        return localBrdMnger;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                String action = intentFilter.getAction(i11);
                ArrayList arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r2 = r1.mReceivers
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x00bc }
            android.content.Context r3 = r1.mAppContext     // Catch:{ all -> 0x00bc }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x00bc }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x00bc }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x00bc }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x00bc }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x00bc }
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$ReceiverRecord>> r3 = r1.mActions     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x00bc }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00bc }
            r15 = r3
            java.util.ArrayList r15 = (java.util.ArrayList) r15     // Catch:{ all -> 0x00bc }
            r9 = 0
            if (r15 == 0) goto L_0x00b9
            r3 = 0
            r8 = r3
            r7 = r9
        L_0x0034:
            int r3 = r15.size()     // Catch:{ all -> 0x00bc }
            r6 = 1
            if (r7 >= r3) goto L_0x0089
            java.lang.Object r3 = r15.get(r7)     // Catch:{ all -> 0x00bc }
            r5 = r3
            com.huawei.agconnect.LocalBrdMnger$ReceiverRecord r5 = (com.huawei.agconnect.LocalBrdMnger.ReceiverRecord) r5     // Catch:{ all -> 0x00bc }
            boolean r3 = r5.broadcasting     // Catch:{ all -> 0x00bc }
            if (r3 == 0) goto L_0x0051
            r19 = r7
            r17 = r10
            r18 = r11
            r20 = r12
            r11 = r8
            r12 = r9
            goto L_0x007e
        L_0x0051:
            android.content.IntentFilter r3 = r5.filter     // Catch:{ all -> 0x00bc }
            java.lang.String r16 = "LocalBroadcastManager"
            r4 = r10
            r17 = r10
            r10 = r5
            r5 = r11
            r18 = r11
            r11 = r6
            r6 = r13
            r19 = r7
            r7 = r12
            r11 = r8
            r8 = r14
            r20 = r12
            r12 = r9
            r9 = r16
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00bc }
            if (r3 < 0) goto L_0x007e
            if (r11 != 0) goto L_0x0076
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00bc }
            r8.<init>()     // Catch:{ all -> 0x00bc }
            goto L_0x0077
        L_0x0076:
            r8 = r11
        L_0x0077:
            r8.add(r10)     // Catch:{ all -> 0x00bc }
            r3 = 1
            r10.broadcasting = r3     // Catch:{ all -> 0x00bc }
            goto L_0x007f
        L_0x007e:
            r8 = r11
        L_0x007f:
            int r7 = r19 + 1
            r9 = r12
            r10 = r17
            r11 = r18
            r12 = r20
            goto L_0x0034
        L_0x0089:
            r11 = r8
            r12 = r9
            if (r11 == 0) goto L_0x00ba
            r9 = r12
        L_0x008e:
            int r3 = r11.size()     // Catch:{ all -> 0x00bc }
            if (r9 >= r3) goto L_0x009f
            java.lang.Object r3 = r11.get(r9)     // Catch:{ all -> 0x00bc }
            com.huawei.agconnect.LocalBrdMnger$ReceiverRecord r3 = (com.huawei.agconnect.LocalBrdMnger.ReceiverRecord) r3     // Catch:{ all -> 0x00bc }
            r3.broadcasting = r12     // Catch:{ all -> 0x00bc }
            int r9 = r9 + 1
            goto L_0x008e
        L_0x009f:
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger$BroadcastRecord> r3 = r1.mPendingBroadcasts     // Catch:{ all -> 0x00bc }
            com.huawei.agconnect.LocalBrdMnger$BroadcastRecord r4 = new com.huawei.agconnect.LocalBrdMnger$BroadcastRecord     // Catch:{ all -> 0x00bc }
            r4.<init>(r0, r11)     // Catch:{ all -> 0x00bc }
            r3.add(r4)     // Catch:{ all -> 0x00bc }
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x00bc }
            r3 = 1
            boolean r0 = r0.hasMessages(r3)     // Catch:{ all -> 0x00bc }
            if (r0 != 0) goto L_0x00b7
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x00bc }
            r0.sendEmptyMessage(r3)     // Catch:{ all -> 0x00bc }
        L_0x00b7:
            monitor-exit(r2)     // Catch:{ all -> 0x00bc }
            return r3
        L_0x00b9:
            r12 = r9
        L_0x00ba:
            monitor-exit(r2)     // Catch:{ all -> 0x00bc }
            return r12
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00bc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.LocalBrdMnger.sendBroadcast(android.content.Intent):boolean");
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList remove = this.mReceivers.remove(broadcastReceiver);
            if (remove != null) {
                for (int i11 = 0; i11 < remove.size(); i11++) {
                    IntentFilter intentFilter = (IntentFilter) remove.get(i11);
                    for (int i12 = 0; i12 < intentFilter.countActions(); i12++) {
                        String action = intentFilter.getAction(i12);
                        ArrayList arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            int i13 = 0;
                            while (i13 < arrayList.size()) {
                                if (((ReceiverRecord) arrayList.get(i13)).receiver == broadcastReceiver) {
                                    arrayList.remove(i13);
                                    i13--;
                                }
                                i13++;
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
