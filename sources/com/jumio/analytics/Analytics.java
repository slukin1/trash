package com.jumio.analytics;

import android.os.SystemClock;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.api.BackendManager;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.util.ConcurrentMutableList;
import com.jumio.core.util.ConcurrentMutableListKt;
import com.sumsub.sns.internal.core.analytics.e;
import fw.a;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import jumio.core.f;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class Analytics implements ApiBinding {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: f  reason: collision with root package name */
    public static final Object f38909f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static Analytics f38910g;

    /* renamed from: h  reason: collision with root package name */
    public static final ConcurrentMutableList<AnalyticsEvent> f38911h = ConcurrentMutableListKt.concurrentMutableListOf();

    /* renamed from: a  reason: collision with root package name */
    public final BackendManager f38912a;

    /* renamed from: b  reason: collision with root package name */
    public final f f38913b;

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledExecutorService f38914c = Executors.newScheduledThreadPool(1);

    /* renamed from: d  reason: collision with root package name */
    public ScheduledFuture<?> f38915d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f38916e = new Object();

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static final void access$setInstance(Companion companion, Analytics analytics) {
            companion.getClass();
            synchronized (Analytics.f38909f) {
                Analytics.f38910g = analytics;
                for (AnalyticsEvent analyticsEvent : Analytics.f38911h) {
                    Analytics access$getInstance$cp = Analytics.f38910g;
                    if (access$getInstance$cp != null) {
                        access$getInstance$cp.add(analyticsEvent);
                    }
                }
                Analytics.f38911h.clear();
                Unit unit = Unit.f56620a;
            }
        }

        public final void add(AnalyticsEvent analyticsEvent) {
            synchronized (Analytics.f38909f) {
                if (Analytics.f38910g == null) {
                    Log.d("Analytics instance is null -> add to buffer");
                    Analytics.f38911h.add(analyticsEvent);
                } else {
                    Analytics access$getInstance$cp = Analytics.f38910g;
                    if (access$getInstance$cp != null) {
                        access$getInstance$cp.add(analyticsEvent);
                        Unit unit = Unit.f56620a;
                    }
                }
            }
        }

        public final void flush() {
            synchronized (Analytics.f38909f) {
                Analytics access$getInstance$cp = Analytics.f38910g;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.flush();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }

    public Analytics(BackendManager backendManager, f fVar) {
        this.f38912a = backendManager;
        this.f38913b = fVar;
        backendManager.addBinding(this);
    }

    public static /* synthetic */ void reporting$default(Analytics analytics, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        analytics.reporting(z11);
    }

    public static /* synthetic */ void start$default(Analytics analytics, boolean z11, long j11, long j12, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            j12 = 0;
        }
        long j13 = j12;
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        analytics.start(z11, j11, j13, i11);
    }

    public final void a() {
        if (this.f38913b.f56189g != 0) {
            ScheduledFuture<?> scheduledFuture = this.f38915d;
            if (!(scheduledFuture != null && !scheduledFuture.isCancelled())) {
                ScheduledExecutorService scheduledExecutorService = this.f38914c;
                a aVar = new a(this);
                long j11 = this.f38913b.f56189g;
                this.f38915d = scheduledExecutorService.scheduleWithFixedDelay(aVar, j11, j11, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void add(AnalyticsEvent analyticsEvent) {
        a();
        analyticsEvent.setSessionId(this.f38913b.f56187e);
        int eventType = analyticsEvent.getEventType();
        if (eventType == 306 || eventType == 307 || eventType == 311 || eventType == 313 || eventType == 316) {
            this.f38913b.f56186d.add(analyticsEvent);
        } else if (this.f38913b.f56191i) {
            LogUtils.INSTANCE.logAnalytics(analyticsEvent);
            synchronized (this.f38916e) {
                this.f38913b.f56185c.add(analyticsEvent);
            }
            f fVar = this.f38913b;
            if (fVar.f56188f != 0 && fVar.f56185c.size() >= this.f38913b.f56188f) {
                flush();
            }
            if (analyticsEvent.getEventType() == 302 && !x.b(analyticsEvent.getPayload().f56344a, "CREATED")) {
                Log.v(e.f31898f, "-- event was SDKLIFECYCLE -> flush() events");
                flush();
            }
        }
    }

    public final void configure$jumio_core_release() {
        synchronized (f38909f) {
            Companion.access$setInstance(Companion, this);
            Unit unit = Unit.f56620a;
        }
    }

    public final void flush() {
        f fVar = this.f38913b;
        if (fVar.f56190h && fVar.f56191i) {
            a(false);
        }
    }

    public final BackendManager getBackendManager$jumio_core_release() {
        return this.f38912a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.AnalyticsCall> r2 = com.jumio.core.api.calls.AnalyticsCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.analytics.Analytics.getBindingClasses():java.lang.Class[]");
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2) {
        if (x.b(apiCallDataModel.getCall(), AnalyticsCall.class)) {
            synchronized (this.f38916e) {
                ArrayList arrayList = (ArrayList) apiCallDataModel.getData().get("DATA_EVENTS");
                if (arrayList != null) {
                    this.f38913b.f56185c.addAll(0, arrayList);
                }
            }
        }
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        x.b(apiCallDataModel.getCall(), AnalyticsCall.class);
    }

    public final void pause() {
        ScheduledFuture<?> scheduledFuture;
        ScheduledFuture<?> scheduledFuture2 = this.f38915d;
        if ((scheduledFuture2 != null && !scheduledFuture2.isCancelled()) && (scheduledFuture = this.f38915d) != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void reporting(boolean z11) {
        BackendManager backendManager = this.f38912a;
        f fVar = this.f38913b;
        backendManager.reporting(fVar.f56186d, fVar.f56183a, fVar.f56184b, z11);
    }

    public final void resume() {
        a();
    }

    public final void start(boolean z11, long j11, long j12, int i11) {
        this.f38913b.a(z11);
        if (!this.f38913b.b() && this.f38913b.c()) {
            f fVar = this.f38913b;
            fVar.a(j11);
            fVar.b(SystemClock.elapsedRealtime());
            fVar.c(j12);
            fVar.a(i11);
            fVar.d();
            UUID a11 = this.f38913b.a();
            Log.d(e.f31898f, "create new session Id: " + a11);
            Log.v(e.f31898f, "start with fixed rate at P=" + j12 + " ms");
            ScheduledFuture<?> scheduledFuture = this.f38915d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            a();
        }
    }

    public final void stop() {
        pause();
        this.f38913b.f56190h = false;
        synchronized (f38909f) {
            Companion.access$setInstance(Companion, (Analytics) null);
            Unit unit = Unit.f56620a;
        }
        a(true);
        this.f38912a.removeBinding(this);
    }

    public static final void a(Analytics analytics) {
        analytics.a(false);
    }

    public final void a(boolean z11) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f38916e) {
            arrayList.addAll(this.f38913b.f56185c);
            this.f38913b.f56185c.clear();
            Unit unit = Unit.f56620a;
        }
        if (arrayList.isEmpty()) {
            Log.v(e.f31898f, "No pending events");
            return;
        }
        try {
            Log.v(e.f31898f, "EventDispatcher.dispatchEvents()");
            BackendManager backendManager = this.f38912a;
            f fVar = this.f38913b;
            backendManager.analytics(arrayList, fVar.f56183a, fVar.f56184b, z11);
        } catch (Exception e11) {
            Log.w(e.f31898f, "Exception while event dispatch", (Throwable) e11);
            synchronized (this.f38916e) {
                this.f38913b.f56185c.addAll(0, arrayList);
            }
        }
    }
}
