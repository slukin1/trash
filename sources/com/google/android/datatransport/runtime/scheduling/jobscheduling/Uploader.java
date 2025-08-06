package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class Uploader {
    private static final String CLIENT_HEALTH_METRICS_LOG_SOURCE = "GDT_CLIENT_METRICS";
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final ClientHealthMetricsStore clientHealthMetricsStore;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final Clock uptimeClock;
    private final WorkScheduler workScheduler;

    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, @WallTime Clock clock2, @Monotonic Clock clock3, ClientHealthMetricsStore clientHealthMetricsStore2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
        this.uptimeClock = clock3;
        this.clientHealthMetricsStore = clientHealthMetricsStore2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$logAndUpdateState$2(TransportContext transportContext) {
        return Boolean.valueOf(this.eventStore.hasPendingEventsFor(transportContext));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Iterable lambda$logAndUpdateState$3(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$4(Iterable iterable, TransportContext transportContext, long j11) {
        this.eventStore.recordFailure(iterable);
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j11);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$5(Iterable iterable) {
        this.eventStore.recordSuccess(iterable);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$6() {
        this.clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$7(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.clientHealthMetricsStore.recordLogEventDropped((long) ((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$8(TransportContext transportContext, long j11) {
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j11);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$upload$0(TransportContext transportContext, int i11) {
        this.workScheduler.schedule(transportContext, i11 + 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.workScheduler.schedule(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$upload$1(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.eventStore     // Catch:{ SynchronizationException -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.m r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.m     // Catch:{ SynchronizationException -> 0x0026 }
            r2.<init>(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r2)     // Catch:{ SynchronizationException -> 0x0026 }
            boolean r0 = r3.isNetworkAvailable()     // Catch:{ SynchronizationException -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.g     // Catch:{ SynchronizationException -> 0x0026 }
            r1.<init>(r3, r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.logAndUpdateState(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.workScheduler     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.schedule(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.lambda$upload$1(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    public EventInternal createMetricsEvent(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.guard;
        ClientHealthMetricsStore clientHealthMetricsStore2 = this.clientHealthMetricsStore;
        Objects.requireNonNull(clientHealthMetricsStore2);
        return transportBackend.decorate(EventInternal.builder().setEventMillis(this.clock.getTime()).setUptimeMillis(this.uptimeClock.getTime()).setTransportName(CLIENT_HEALTH_METRICS_LOG_SOURCE).setEncodedPayload(new EncodedPayload(Encoding.of("proto"), ((ClientMetrics) synchronizationGuard.runCriticalSection(new l(clientHealthMetricsStore2))).toByteArray())).build());
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse logAndUpdateState(TransportContext transportContext, int i11) {
        BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        long j11 = 0;
        BackendResponse ok2 = BackendResponse.ok(0);
        while (true) {
            long j12 = j11;
            while (((Boolean) this.guard.runCriticalSection(new e(this, transportContext))).booleanValue()) {
                Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(new f(this, transportContext));
                if (!iterable.iterator().hasNext()) {
                    return ok2;
                }
                if (transportBackend == null) {
                    Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                    send = BackendResponse.fatalError();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (PersistedEvent event : iterable) {
                        arrayList.add(event.getEvent());
                    }
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        arrayList.add(createMetricsEvent(transportBackend));
                    }
                    send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
                }
                ok2 = send;
                if (ok2.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.guard.runCriticalSection(new j(this, iterable, transportContext, j12));
                    this.workScheduler.schedule(transportContext, i11 + 1, true);
                    return ok2;
                }
                this.guard.runCriticalSection(new i(this, iterable));
                if (ok2.getStatus() == BackendResponse.Status.OK) {
                    j11 = Math.max(j12, ok2.getNextRequestWaitMillis());
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        this.guard.runCriticalSection(new c(this));
                    }
                } else if (ok2.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    for (PersistedEvent event2 : iterable) {
                        String transportName = event2.getEvent().getTransportName();
                        if (!hashMap.containsKey(transportName)) {
                            hashMap.put(transportName, 1);
                        } else {
                            hashMap.put(transportName, Integer.valueOf(((Integer) hashMap.get(transportName)).intValue() + 1));
                        }
                    }
                    this.guard.runCriticalSection(new k(this, hashMap));
                }
            }
            this.guard.runCriticalSection(new h(this, transportContext, j12));
            return ok2;
        }
    }

    public void upload(TransportContext transportContext, int i11, Runnable runnable) {
        this.executor.execute(new d(this, transportContext, i11, runnable));
    }
}
