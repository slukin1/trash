package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class TransferStatusUpdater {

    /* renamed from: d  reason: collision with root package name */
    public static final Log f15008d = LogFactory.b(TransferStatusUpdater.class);

    /* renamed from: e  reason: collision with root package name */
    public static final HashSet<TransferState> f15009e = new HashSet<>(Arrays.asList(new TransferState[]{TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT}));

    /* renamed from: f  reason: collision with root package name */
    public static final Map<Integer, List<TransferListener>> f15010f = new ConcurrentHashMap<Integer, List<TransferListener>>() {
    };

    /* renamed from: g  reason: collision with root package name */
    public static TransferDBUtil f15011g;

    /* renamed from: h  reason: collision with root package name */
    public static TransferStatusUpdater f15012h;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, TransferRecord> f15013a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f15014b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public Context f15015c;

    public class TransferProgressListener implements ProgressListener {

        /* renamed from: a  reason: collision with root package name */
        public final TransferRecord f15029a;

        /* renamed from: b  reason: collision with root package name */
        public long f15030b;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.f15029a = transferRecord;
        }

        public synchronized void a(ProgressEvent progressEvent) {
            if (32 == progressEvent.b()) {
                TransferStatusUpdater.f15008d.j("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.f15030b = 0;
            } else {
                long a11 = this.f15030b + progressEvent.a();
                this.f15030b = a11;
                TransferRecord transferRecord = this.f15029a;
                if (a11 > transferRecord.f14985i) {
                    transferRecord.f14985i = a11;
                    TransferStatusUpdater.this.i(transferRecord.f14977a, a11, transferRecord.f14984h, true);
                }
            }
        }
    }

    public TransferStatusUpdater(TransferDBUtil transferDBUtil, Context context) {
        f15011g = transferDBUtil;
        this.f15015c = context;
    }

    public static synchronized TransferStatusUpdater c(Context context) {
        TransferStatusUpdater transferStatusUpdater;
        synchronized (TransferStatusUpdater.class) {
            if (f15012h == null) {
                TransferDBUtil transferDBUtil = new TransferDBUtil(context);
                f15011g = transferDBUtil;
                f15012h = new TransferStatusUpdater(transferDBUtil, context);
            }
            transferStatusUpdater = f15012h;
        }
        return transferStatusUpdater;
    }

    public synchronized void b(TransferRecord transferRecord) {
        this.f15013a.put(Integer.valueOf(transferRecord.f14977a), transferRecord);
    }

    public synchronized TransferRecord d(int i11) {
        return this.f15013a.get(Integer.valueOf(i11));
    }

    public synchronized Map<Integer, TransferRecord> e() {
        return Collections.unmodifiableMap(this.f15013a);
    }

    public synchronized ProgressListener f(int i11) {
        TransferRecord d11;
        d11 = d(i11);
        if (d11 != null) {
            Log log = f15008d;
            log.j("Creating a new progress listener for transfer: " + i11);
        } else {
            Log log2 = f15008d;
            log2.j("TransferStatusUpdater doesn't track the transfer: " + i11);
            throw new IllegalArgumentException("transfer " + i11 + " doesn't exist");
        }
        return new TransferProgressListener(d11);
    }

    public synchronized void g(int i11) {
        TransferRecord f11 = f15011g.f(i11);
        if (f11 != null) {
            String str = f11.f14995s;
            if (new File(str).getName().startsWith("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002")) {
                new File(str).delete();
            }
        }
        S3ClientReference.b(Integer.valueOf(i11));
        f15011g.b(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(final int r6, final java.lang.Exception r7) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, java.util.List<com.amazonaws.mobileconnectors.s3.transferutility.TransferListener>> r0 = f15010f
            monitor-enter(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0035 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0033
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0016
            goto L_0x0033
        L_0x0016:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0035 }
        L_0x001a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0035 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferListener r2 = (com.amazonaws.mobileconnectors.s3.transferutility.TransferListener) r2     // Catch:{ all -> 0x0035 }
            android.os.Handler r3 = r5.f15014b     // Catch:{ all -> 0x0035 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$4 r4 = new com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$4     // Catch:{ all -> 0x0035 }
            r4.<init>(r2, r6, r7)     // Catch:{ all -> 0x0035 }
            r3.post(r4)     // Catch:{ all -> 0x0035 }
            goto L_0x001a
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.h(int, java.lang.Exception):void");
    }

    public synchronized void i(int i11, long j11, long j12, boolean z11) {
        long j13 = j11;
        synchronized (this) {
            TransferRecord transferRecord = this.f15013a.get(Integer.valueOf(i11));
            if (transferRecord != null) {
                transferRecord.f14985i = j13;
                transferRecord.f14984h = j12;
            } else {
                long j14 = j12;
            }
            f15011g.k(i11, j13);
            if (z11) {
                Map<Integer, List<TransferListener>> map = f15010f;
                synchronized (map) {
                    List list = map.get(Integer.valueOf(i11));
                    if (list != null) {
                        if (!list.isEmpty()) {
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                final TransferListener transferListener = (TransferListener) it2.next();
                                final int i12 = i11;
                                final long j15 = j11;
                                Iterator it3 = it2;
                                Handler handler = this.f15014b;
                                AnonymousClass3 r102 = r1;
                                final long j16 = j12;
                                AnonymousClass3 r12 = new Runnable() {
                                    public void run() {
                                        transferListener.a(i12, j15, j16);
                                    }
                                };
                                handler.post(r102);
                                long j17 = j11;
                                it2 = it3;
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void j(final int i11, final TransferState transferState) {
        boolean contains = f15009e.contains(transferState);
        TransferRecord transferRecord = this.f15013a.get(Integer.valueOf(i11));
        if (transferRecord != null) {
            contains |= transferState.equals(transferRecord.f14991o);
            transferRecord.f14991o = transferState;
            if (f15011g.o(transferRecord) == 0) {
                Log log = f15008d;
                log.g("Failed to update the status of transfer " + i11);
            }
        } else if (f15011g.n(i11, transferState) == 0) {
            Log log2 = f15008d;
            log2.g("Failed to update the status of transfer " + i11);
        }
        if (!contains) {
            if (TransferState.COMPLETED.equals(transferState)) {
                g(i11);
            }
            Map<Integer, List<TransferListener>> map = f15010f;
            synchronized (map) {
                List<TransferListener> list = map.get(Integer.valueOf(i11));
                if (list != null && !list.isEmpty()) {
                    for (final TransferListener transferListener : list) {
                        this.f15014b.post(new Runnable() {
                            public void run() {
                                transferListener.c(i11, transferState);
                            }
                        });
                    }
                    if (TransferState.isFinalState(transferState)) {
                        list.clear();
                    }
                }
            }
        }
    }
}
