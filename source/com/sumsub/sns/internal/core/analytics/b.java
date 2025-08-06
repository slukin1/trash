package com.sumsub.sns.internal.core.analytics;

import com.sumsub.sns.core.data.model.SNSTrackEvents;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31873a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final long f31874b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public static final long f31875c = 50;

    /* renamed from: d  reason: collision with root package name */
    public static com.sumsub.sns.internal.core.data.source.analythic.a f31876d;

    /* renamed from: e  reason: collision with root package name */
    public static final ArrayList<SNSTrackEvents> f31877e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentHashMap<GlobalStatePayload, String> f31878f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public static final h0 f31879g = i0.a(f1.b(Executors.newSingleThreadExecutor()));

    /* renamed from: h  reason: collision with root package name */
    public static l<? super SNSTrackEvents, Unit> f31880h;

    /* renamed from: i  reason: collision with root package name */
    public static Timer f31881i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f31882j = true;

    @d(c = "com.sumsub.sns.internal.core.analytics.Analytics$flush$1", f = "Analytics.kt", l = {87}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31883a;

        public a(kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31883a;
            if (i11 == 0) {
                k.b(obj);
                if (!b.f31877e.isEmpty()) {
                    List L0 = CollectionsKt___CollectionsKt.L0(b.f31877e);
                    b.f31877e.clear();
                    com.sumsub.sns.internal.core.data.source.analythic.a a11 = b.f31876d;
                    if (a11 != null) {
                        this.f31883a = 1;
                        obj = a11.a(L0, this);
                        if (obj == d11) {
                            return d11;
                        }
                    }
                }
                com.sumsub.sns.internal.log.cacher.d.f34872a.b();
                return Unit.f56620a;
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Boolean bool = (Boolean) obj;
            com.sumsub.sns.internal.log.cacher.d.f34872a.b();
            return Unit.f56620a;
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.analytics.b$b  reason: collision with other inner class name */
    public static final class C0318b extends TimerTask {
        public void run() {
            b.f31873a.e();
        }
    }

    @d(c = "com.sumsub.sns.internal.core.analytics.Analytics$send$1", f = "Analytics.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31884a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSTrackEvents f31885b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f31886c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSTrackEvents sNSTrackEvents, boolean z11, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f31885b = sNSTrackEvents;
            this.f31886c = z11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f31885b, this.f31886c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31884a == 0) {
                k.b(obj);
                try {
                    l<SNSTrackEvents, Unit> g11 = b.f31873a.g();
                    if (g11 != null) {
                        g11.invoke(this.f31885b);
                    }
                } catch (Throwable unused2) {
                }
                b.f31877e.add(this.f31885b);
                if (((long) b.f31877e.size()) >= 50 || this.f31886c) {
                    b.f31873a.e();
                } else {
                    b.f31873a.i();
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void c() {
        f31878f.clear();
    }

    public final void d() {
        Timer timer = f31881i;
        if (timer != null) {
            timer.cancel();
        }
        f31881i = null;
    }

    public final void e() {
        n1 unused = i.d(f31879g, (CoroutineContext) null, (CoroutineStart) null, new a((kotlin.coroutines.c<? super a>) null), 3, (Object) null);
    }

    public final ConcurrentHashMap<GlobalStatePayload, String> f() {
        return f31878f;
    }

    public final l<SNSTrackEvents, Unit> g() {
        return f31880h;
    }

    public final boolean h() {
        return f31882j;
    }

    public final void i() {
        if (f31881i != null) {
            d();
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new C0318b(), 5000, 5000);
        f31881i = timer;
    }

    public final void j() {
        f31880h = null;
        d();
    }

    public final void a(l<? super SNSTrackEvents, Unit> lVar) {
        f31880h = lVar;
    }

    public final void a(boolean z11) {
        if (!z11) {
            f31882j = true;
            f.a(0, 1, (Object) null).a(SdkEvent.TrackingDisabled).a((Map<String, ? extends Object>) MapsKt__MapsKt.h()).a(true);
        }
        f31882j = z11;
    }

    public final void a(SNSTrackEvents sNSTrackEvents, boolean z11) {
        if (f31882j || StringsKt__StringsKt.R(sNSTrackEvents.getActivity(), SdkEvent.TrackingDisabled.getText(), false, 2, (Object) null)) {
            n1 unused = i.d(f31879g, (CoroutineContext) null, (CoroutineStart) null, new c(sNSTrackEvents, z11, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
        }
    }

    public final void a(com.sumsub.sns.internal.core.data.source.analythic.a aVar) {
        f31876d = aVar;
    }

    public final void a(GlobalStatePayload globalStatePayload, String str) {
        f31878f.put(globalStatePayload, str);
    }

    public final void a(GlobalStatePayload globalStatePayload) {
        f31878f.remove(globalStatePayload);
    }
}
