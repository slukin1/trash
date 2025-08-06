package com.sumsub.sns.internal.prooface.presentation;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.lifecycle.m0;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.sumsub.log.logger.Logger;
import com.sumsub.sns.core.SNSActionResult;
import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.AnswerType;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.e;
import com.sumsub.sns.internal.core.data.model.u;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.domain.h;
import com.sumsub.sns.internal.core.domain.o;
import com.sumsub.sns.internal.fingerprint.Fingerprinter;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.prooface.network.Liveness3dFaceRepository;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class b extends com.sumsub.sns.core.presentation.base.a<i> {

    /* renamed from: q  reason: collision with root package name */
    public static final d f36445q = new d((kotlin.jvm.internal.r) null);

    /* renamed from: r  reason: collision with root package name */
    public static final long f36446r = 250;

    /* renamed from: s  reason: collision with root package name */
    public static final int f36447s = 200;

    /* renamed from: t  reason: collision with root package name */
    public static final int f36448t = 200;

    /* renamed from: u  reason: collision with root package name */
    public static final int f36449u = 100;

    /* renamed from: v  reason: collision with root package name */
    public static final int f36450v = 8000;

    /* renamed from: w  reason: collision with root package name */
    public static final SimpleDateFormat f36451w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: x  reason: collision with root package name */
    public static final int f36452x = 92;

    /* renamed from: y  reason: collision with root package name */
    public static final long f36453y = 2;

    /* renamed from: z  reason: collision with root package name */
    public static final long f36454z = 2;
    public final com.sumsub.sns.internal.core.domain.o A;
    public final DocumentType B;
    public final kotlinx.serialization.json.a C;
    public final com.sumsub.sns.prooface.network.a D;
    public final Liveness3dFaceRepository E;
    public final com.sumsub.sns.internal.core.data.source.settings.b F;
    public final com.sumsub.sns.internal.core.data.source.common.a G;
    public final com.sumsub.sns.internal.core.data.source.dynamic.b H;
    public final Fingerprinter I;
    public boolean J;
    public Timer K;
    public Timer L;
    public final String M;
    public String N = "";
    public final a1<Triple<Bitmap, Size, String>> O = g1.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    public final ExecutorCoroutineDispatcher P;
    public com.sumsub.sns.prooface.data.a Q;
    public boolean R;
    public n1 S;
    public ImageProxy T;
    public boolean U;
    public final kotlin.i V;
    public final q W;
    public int X;
    public int Y;
    public long Z;

    /* renamed from: a0  reason: collision with root package name */
    public long f36455a0;

    /* renamed from: b0  reason: collision with root package name */
    public String f36456b0;

    /* renamed from: c0  reason: collision with root package name */
    public Bitmap f36457c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f36458d0;

    /* renamed from: e0  reason: collision with root package name */
    public final b1<f> f36459e0;

    /* renamed from: f0  reason: collision with root package name */
    public final j1<f> f36460f0;

    /* renamed from: g0  reason: collision with root package name */
    public final b1<g> f36461g0;

    /* renamed from: h0  reason: collision with root package name */
    public final j1<g> f36462h0;

    /* renamed from: i0  reason: collision with root package name */
    public n1 f36463i0;

    /* renamed from: j0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.common.e f36464j0;

    /* renamed from: k0  reason: collision with root package name */
    public final kotlin.i f36465k0;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$1", f = "SNSLiveness3dFaceViewModel.kt", l = {284}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36466a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36467b;

        /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$a$a  reason: collision with other inner class name */
        public static final class C0489a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36468a;

            public C0489a(b bVar) {
                this.f36468a = bVar;
            }

            /* renamed from: a */
            public final Object emit(com.sumsub.sns.prooface.data.h hVar, kotlin.coroutines.c<? super Unit> cVar) {
                this.f36468a.E.a(hVar);
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$1$invokeSuspend$$inlined$transform$1", f = "SNSLiveness3dFaceViewModel.kt", l = {40}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$a$b  reason: collision with other inner class name */
        public static final class C0490b extends SuspendLambda implements d10.p<kotlinx.coroutines.flow.e<? super com.sumsub.sns.prooface.data.h>, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36469a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f36470b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.d f36471c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f36472d;

            /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$a$b$a  reason: collision with other inner class name */
            public static final class C0491a<T> implements kotlinx.coroutines.flow.e {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ kotlinx.coroutines.flow.e<com.sumsub.sns.prooface.data.h> f36473a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f36474b;

                @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$1$invokeSuspend$$inlined$transform$1$1", f = "SNSLiveness3dFaceViewModel.kt", l = {224, 228}, m = "emit")
                /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$a$b$a$a  reason: collision with other inner class name */
                public static final class C0492a extends ContinuationImpl {

                    /* renamed from: a  reason: collision with root package name */
                    public /* synthetic */ Object f36475a;

                    /* renamed from: b  reason: collision with root package name */
                    public int f36476b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ C0491a f36477c;

                    /* renamed from: d  reason: collision with root package name */
                    public Object f36478d;

                    /* renamed from: e  reason: collision with root package name */
                    public Object f36479e;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public C0492a(C0491a aVar, kotlin.coroutines.c cVar) {
                        super(cVar);
                        this.f36477c = aVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f36475a = obj;
                        this.f36476b |= Integer.MIN_VALUE;
                        return this.f36477c.emit(null, this);
                    }
                }

                public C0491a(kotlinx.coroutines.flow.e eVar, b bVar) {
                    this.f36474b = bVar;
                    this.f36473a = eVar;
                }

                /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.sumsub.sns.internal.prooface.presentation.b.a.C0490b.C0491a.C0492a
                        if (r0 == 0) goto L_0x0013
                        r0 = r10
                        com.sumsub.sns.internal.prooface.presentation.b$a$b$a$a r0 = (com.sumsub.sns.internal.prooface.presentation.b.a.C0490b.C0491a.C0492a) r0
                        int r1 = r0.f36476b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f36476b = r1
                        goto L_0x0018
                    L_0x0013:
                        com.sumsub.sns.internal.prooface.presentation.b$a$b$a$a r0 = new com.sumsub.sns.internal.prooface.presentation.b$a$b$a$a
                        r0.<init>(r8, r10)
                    L_0x0018:
                        java.lang.Object r10 = r0.f36475a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r2 = r0.f36476b
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L_0x0040
                        if (r2 == r4) goto L_0x0034
                        if (r2 != r3) goto L_0x002c
                        kotlin.k.b(r10)
                        goto L_0x008c
                    L_0x002c:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L_0x0034:
                        java.lang.Object r9 = r0.f36479e
                        kotlinx.coroutines.flow.e r9 = (kotlinx.coroutines.flow.e) r9
                        java.lang.Object r2 = r0.f36478d
                        com.sumsub.sns.internal.prooface.presentation.b$a$b$a r2 = (com.sumsub.sns.internal.prooface.presentation.b.a.C0490b.C0491a) r2
                        kotlin.k.b(r10)
                        goto L_0x0074
                    L_0x0040:
                        kotlin.k.b(r10)
                        kotlinx.coroutines.flow.e<com.sumsub.sns.prooface.data.h> r10 = r8.f36473a
                        kotlin.Triple r9 = (kotlin.Triple) r9
                        com.sumsub.sns.internal.prooface.presentation.b r2 = r8.f36474b
                        int r2 = r2.X
                        if (r2 == 0) goto L_0x008c
                        com.sumsub.sns.internal.prooface.presentation.b r2 = r8.f36474b
                        java.lang.Object r5 = r9.getFirst()
                        android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                        java.lang.Object r6 = r9.getSecond()
                        android.util.Size r6 = (android.util.Size) r6
                        java.lang.Object r9 = r9.getThird()
                        java.lang.String r9 = (java.lang.String) r9
                        r0.f36478d = r8
                        r0.f36479e = r10
                        r0.f36476b = r4
                        java.lang.Object r9 = r2.a((android.graphics.Bitmap) r5, (android.util.Size) r6, (java.lang.String) r9, (kotlin.coroutines.c<? super com.sumsub.sns.prooface.data.h>) r0)
                        if (r9 != r1) goto L_0x0070
                        return r1
                    L_0x0070:
                        r2 = r8
                        r7 = r10
                        r10 = r9
                        r9 = r7
                    L_0x0074:
                        com.sumsub.sns.prooface.data.h r10 = (com.sumsub.sns.prooface.data.h) r10
                        com.sumsub.sns.internal.prooface.presentation.b r2 = r2.f36474b
                        int r2 = r2.X
                        if (r2 == 0) goto L_0x008c
                        r2 = 0
                        r0.f36478d = r2
                        r0.f36479e = r2
                        r0.f36476b = r3
                        java.lang.Object r9 = r9.emit(r10, r0)
                        if (r9 != r1) goto L_0x008c
                        return r1
                    L_0x008c:
                        kotlin.Unit r9 = kotlin.Unit.f56620a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.a.C0490b.C0491a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0490b(kotlinx.coroutines.flow.d dVar, kotlin.coroutines.c cVar, b bVar) {
                super(2, cVar);
                this.f36471c = dVar;
                this.f36472d = bVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.flow.e<? super com.sumsub.sns.prooface.data.h> eVar, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0490b) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0490b bVar = new C0490b(this.f36471c, cVar, this.f36472d);
                bVar.f36470b = obj;
                return bVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36469a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    kotlinx.coroutines.flow.d dVar = this.f36471c;
                    C0491a aVar = new C0491a((kotlinx.coroutines.flow.e) this.f36470b, this.f36472d);
                    this.f36469a = 1;
                    if (dVar.collect(aVar, this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f36467b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a(this.f36467b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36466a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.flow.d F = kotlinx.coroutines.flow.f.F(new C0490b(this.f36467b.O, (kotlin.coroutines.c) null, this.f36467b));
                C0489a aVar = new C0489a(this.f36467b);
                this.f36466a = 1;
                if (F.collect(aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class a0 extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f36480a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$scheduleSlowConnectionTimer$1$1$run$1", f = "SNSLiveness3dFaceViewModel.kt", l = {761, 759}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f36481a;

            /* renamed from: b  reason: collision with root package name */
            public int f36482b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f36483c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36483c = bVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36483c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                b1 b1Var;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36482b;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    b1Var = this.f36483c.f36461g0;
                    b bVar = this.f36483c;
                    this.f36481a = b1Var;
                    this.f36482b = 1;
                    obj = bVar.a("sns_facescan_hint_processingTakesTooLong", (kotlin.coroutines.c<? super String>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    b1Var = (b1) this.f36481a;
                    kotlin.k.b(obj);
                } else if (i11 == 2) {
                    kotlin.k.b(obj);
                    return Unit.f56620a;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                g.d dVar = new g.d((CharSequence) obj);
                this.f36481a = null;
                this.f36482b = 2;
                if (b1Var.emit(dVar, this) == d11) {
                    return d11;
                }
                return Unit.f56620a;
            }
        }

        public a0(b bVar) {
            this.f36480a = bVar;
        }

        public void run() {
            n1 unused = kotlinx.coroutines.i.d(m0.a(this.f36480a), (CoroutineContext) null, (CoroutineStart) null, new a(this.f36480a, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$2", f = "SNSLiveness3dFaceViewModel.kt", l = {292}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$b  reason: collision with other inner class name */
    public static final class C0493b extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36484a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36485b;

        /* renamed from: c  reason: collision with root package name */
        public int f36486c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f36487d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0493b(b bVar, kotlin.coroutines.c<? super C0493b> cVar) {
            super(2, cVar);
            this.f36487d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0493b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new C0493b(this.f36487d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            b bVar;
            b bVar2;
            b bVar3;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36486c;
            boolean z11 = false;
            if (i11 == 0) {
                kotlin.k.b(obj);
                bVar2 = this.f36487d;
                try {
                    com.sumsub.sns.internal.core.data.source.dynamic.b e11 = bVar2.H;
                    this.f36484a = bVar2;
                    this.f36485b = bVar2;
                    this.f36486c = 1;
                    Object b11 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(e11, false, this, 1, (Object) null);
                    if (b11 == d11) {
                        return d11;
                    }
                    bVar = bVar2;
                    obj = b11;
                    bVar3 = bVar;
                } catch (Exception unused) {
                    bVar = bVar2;
                    bVar.J = z11;
                    return Unit.f56620a;
                }
            } else if (i11 == 1) {
                bVar = (b) this.f36485b;
                bVar3 = (b) this.f36484a;
                try {
                    kotlin.k.b(obj);
                } catch (Exception unused2) {
                    bVar2 = bVar3;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z11 = com.sumsub.sns.internal.core.data.model.f.m((com.sumsub.sns.internal.core.data.model.e) obj);
            bVar.J = z11;
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$startCalibration$1", f = "SNSLiveness3dFaceViewModel.kt", l = {563}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36488a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36489b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f36490c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(b bVar, float f11, kotlin.coroutines.c<? super b0> cVar) {
            super(2, cVar);
            this.f36489b = bVar;
            this.f36490c = f11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b0(this.f36489b, this.f36490c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36488a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f36489b.f36461g0.setValue(new g.c(this.f36490c));
                this.f36488a = 1;
                if (DelayKt.b(250, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f36489b.b(false);
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Calibration finished", (Throwable) null, 4, (Object) null);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$3", f = "SNSLiveness3dFaceViewModel.kt", l = {300}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36492b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$3$1", f = "SNSLiveness3dFaceViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36493a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f36494b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f36495c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36495c = bVar;
            }

            /* renamed from: a */
            public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f36495c, cVar);
                aVar.f36494b = obj;
                return aVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
                r1 = (r1 = (r1 = r13.i()).d()).r();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r0 = r12.f36493a
                    if (r0 != 0) goto L_0x0117
                    kotlin.k.b(r13)
                    java.lang.Object r13 = r12.f36494b
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r13 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r13
                    r0 = 0
                    if (r13 == 0) goto L_0x002a
                    com.sumsub.sns.internal.core.data.source.dynamic.e r1 = r13.i()
                    if (r1 == 0) goto L_0x002a
                    java.lang.Object r1 = r1.d()
                    com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
                    if (r1 == 0) goto L_0x002a
                    com.sumsub.sns.internal.core.data.model.e$a r1 = r1.r()
                    if (r1 == 0) goto L_0x002a
                    java.lang.String r1 = r1.c()
                    goto L_0x002b
                L_0x002a:
                    r1 = r0
                L_0x002b:
                    if (r1 == 0) goto L_0x0030
                    kotlin.Unit r13 = kotlin.Unit.f56620a
                    return r13
                L_0x0030:
                    if (r13 == 0) goto L_0x0114
                    com.sumsub.sns.internal.core.data.source.dynamic.e r1 = r13.j()
                    if (r1 == 0) goto L_0x0114
                    java.lang.Object r1 = r1.d()
                    com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1
                    if (r1 == 0) goto L_0x0114
                    java.util.List r1 = r1.d()
                    if (r1 != 0) goto L_0x0048
                    goto L_0x0114
                L_0x0048:
                    com.sumsub.sns.internal.core.data.source.dynamic.e r13 = r13.g()
                    java.lang.Object r13 = r13.d()
                    com.sumsub.sns.internal.core.data.model.g r13 = (com.sumsub.sns.internal.core.data.model.g) r13
                    if (r13 != 0) goto L_0x0057
                    kotlin.Unit r13 = kotlin.Unit.f56620a
                    return r13
                L_0x0057:
                    boolean r2 = r1.isEmpty()
                    r3 = 2
                    java.lang.String r4 = "SELFIE"
                    r5 = 0
                    if (r2 == 0) goto L_0x0063
                    r6 = r5
                    goto L_0x008a
                L_0x0063:
                    java.util.Iterator r2 = r1.iterator()
                    r6 = r5
                L_0x0068:
                    boolean r7 = r2.hasNext()
                    if (r7 == 0) goto L_0x008a
                    java.lang.Object r7 = r2.next()
                    com.sumsub.sns.internal.core.data.model.Document r7 = (com.sumsub.sns.internal.core.data.model.Document) r7
                    com.sumsub.sns.internal.core.data.model.DocumentType r7 = r7.getType()
                    java.lang.String r7 = r7.c()
                    boolean r7 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r4, r5, r3, r0)
                    if (r7 == 0) goto L_0x0068
                    int r6 = r6 + 1
                    if (r6 >= 0) goto L_0x0068
                    kotlin.collections.CollectionsKt__CollectionsKt.s()
                    goto L_0x0068
                L_0x008a:
                    com.sumsub.sns.internal.core.data.model.m r2 = new com.sumsub.sns.internal.core.data.model.m
                    r2.<init>(r13)
                    java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r1, r2)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.Iterator r13 = r13.iterator()
                L_0x009c:
                    boolean r2 = r13.hasNext()
                    if (r2 == 0) goto L_0x00bb
                    java.lang.Object r2 = r13.next()
                    r7 = r2
                    com.sumsub.sns.internal.core.data.model.Document r7 = (com.sumsub.sns.internal.core.data.model.Document) r7
                    com.sumsub.sns.internal.core.data.model.DocumentType r7 = r7.getType()
                    java.lang.String r7 = r7.c()
                    boolean r7 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r4, r5, r3, r0)
                    if (r7 == 0) goto L_0x009c
                    r1.add(r2)
                    goto L_0x009c
                L_0x00bb:
                    boolean r13 = r1.isEmpty()
                    r2 = 1
                    if (r13 == 0) goto L_0x00c4
                    r1 = r5
                    goto L_0x00f4
                L_0x00c4:
                    java.util.Iterator r13 = r1.iterator()
                    r1 = r5
                L_0x00c9:
                    boolean r3 = r13.hasNext()
                    if (r3 == 0) goto L_0x00f4
                    java.lang.Object r3 = r13.next()
                    com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3
                    boolean r4 = r3.isSubmitted()
                    if (r4 == 0) goto L_0x00e9
                    boolean r4 = r3.isApproved()
                    if (r4 != 0) goto L_0x00e7
                    boolean r3 = r3.isReviewing()
                    if (r3 == 0) goto L_0x00e9
                L_0x00e7:
                    r3 = r2
                    goto L_0x00ea
                L_0x00e9:
                    r3 = r5
                L_0x00ea:
                    if (r3 == 0) goto L_0x00c9
                    int r1 = r1 + 1
                    if (r1 >= 0) goto L_0x00c9
                    kotlin.collections.CollectionsKt__CollectionsKt.s()
                    goto L_0x00c9
                L_0x00f4:
                    if (r1 != r6) goto L_0x00f8
                    r13 = r2
                    goto L_0x00f9
                L_0x00f8:
                    r13 = r5
                L_0x00f9:
                    if (r13 == 0) goto L_0x0111
                    r13 = 4
                    java.lang.String r1 = "Prooface"
                    java.lang.String r3 = "Selfie already submitted, aborting liveness check"
                    com.sumsub.sns.prooface.a.a(r1, r3, r0, r13, r0)
                    com.sumsub.sns.internal.prooface.presentation.b r6 = r12.f36495c
                    com.sumsub.sns.internal.core.common.q$b r7 = new com.sumsub.sns.internal.core.common.q$b
                    r7.<init>(r5, r2, r0)
                    r8 = 0
                    r9 = 0
                    r10 = 6
                    r11 = 0
                    com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r6, (com.sumsub.sns.internal.core.common.q) r7, (java.lang.Object) r8, (java.lang.Long) r9, (int) r10, (java.lang.Object) r11)
                L_0x0111:
                    kotlin.Unit r13 = kotlin.Unit.f56620a
                    return r13
                L_0x0114:
                    kotlin.Unit r13 = kotlin.Unit.f56620a
                    return r13
                L_0x0117:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f36492b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f36492b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36491a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                j1<b.a> b11 = this.f36492b.H.b();
                a aVar = new a(this.f36492b, (kotlin.coroutines.c<? super a>) null);
                this.f36491a = 1;
                if (kotlinx.coroutines.flow.f.i(b11, aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$startCalibration$2", f = "SNSLiveness3dFaceViewModel.kt", l = {571, 573, 575, 577, 579}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36496a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f36498c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f36499d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f36500e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(b bVar, float f11, float f12, float f13, kotlin.coroutines.c<? super c0> cVar) {
            super(2, cVar);
            this.f36497b = bVar;
            this.f36498c = f11;
            this.f36499d = f12;
            this.f36500e = f13;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c0(this.f36497b, this.f36498c, this.f36499d, this.f36500e, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00b9 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f36496a
                r2 = 100
                java.lang.String r4 = "Prooface"
                r5 = 5
                r6 = 3
                r7 = 2
                r8 = 250(0xfa, double:1.235E-321)
                r10 = 0
                r11 = 4
                r12 = 1
                if (r1 == 0) goto L_0x003b
                if (r1 == r12) goto L_0x0037
                if (r1 == r7) goto L_0x0033
                if (r1 == r6) goto L_0x002f
                if (r1 == r11) goto L_0x002b
                if (r1 != r5) goto L_0x0023
                kotlin.k.b(r15)
                goto L_0x00ba
            L_0x0023:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x002b:
                kotlin.k.b(r15)
                goto L_0x0090
            L_0x002f:
                kotlin.k.b(r15)
                goto L_0x008b
            L_0x0033:
                kotlin.k.b(r15)
                goto L_0x0061
            L_0x0037:
                kotlin.k.b(r15)
                goto L_0x005c
            L_0x003b:
                kotlin.k.b(r15)
                java.lang.String r15 = "Calibration started"
                com.sumsub.sns.prooface.a.a(r4, r15, r10, r11, r10)
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                kotlinx.coroutines.flow.b1 r15 = r15.f36461g0
                com.sumsub.sns.internal.prooface.presentation.b$g$a r1 = new com.sumsub.sns.internal.prooface.presentation.b$g$a
                float r13 = r14.f36498c
                r1.<init>(r13)
                r15.setValue(r1)
                r14.f36496a = r12
                java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r8, r14)
                if (r15 != r0) goto L_0x005c
                return r0
            L_0x005c:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                r15.R = r12
            L_0x0061:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                boolean r15 = r15.R
                if (r15 == 0) goto L_0x0072
                r14.f36496a = r7
                java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r2, r14)
                if (r15 != r0) goto L_0x0061
                return r0
            L_0x0072:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                kotlinx.coroutines.flow.b1 r15 = r15.f36461g0
                com.sumsub.sns.internal.prooface.presentation.b$g$a r1 = new com.sumsub.sns.internal.prooface.presentation.b$g$a
                float r7 = r14.f36499d
                r1.<init>(r7)
                r15.setValue(r1)
                r14.f36496a = r6
                java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r8, r14)
                if (r15 != r0) goto L_0x008b
                return r0
            L_0x008b:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                r15.R = r12
            L_0x0090:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                boolean r15 = r15.R
                if (r15 == 0) goto L_0x00a1
                r14.f36496a = r11
                java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r2, r14)
                if (r15 != r0) goto L_0x0090
                return r0
            L_0x00a1:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                kotlinx.coroutines.flow.b1 r15 = r15.f36461g0
                com.sumsub.sns.internal.prooface.presentation.b$g$c r1 = new com.sumsub.sns.internal.prooface.presentation.b$g$c
                float r2 = r14.f36500e
                r1.<init>(r2)
                r15.setValue(r1)
                r14.f36496a = r5
                java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r8, r14)
                if (r15 != r0) goto L_0x00ba
                return r0
            L_0x00ba:
                com.sumsub.sns.internal.prooface.presentation.b r15 = r14.f36497b
                r0 = 0
                r15.b((boolean) r0)
                java.lang.String r15 = "Calibration finished"
                com.sumsub.sns.prooface.a.a(r4, r15, r10, r11, r10)
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.c0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class d {
        public /* synthetic */ d(kotlin.jvm.internal.r rVar) {
            this();
        }

        public d() {
        }
    }

    public static final class e implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.o f36501a;

        public e(com.sumsub.sns.internal.core.data.model.o oVar) {
            this.f36501a = oVar;
        }

        public final com.sumsub.sns.internal.core.data.model.o a() {
            return this.f36501a;
        }

        public final com.sumsub.sns.internal.core.data.model.o b() {
            return this.f36501a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && kotlin.jvm.internal.x.b(this.f36501a, ((e) obj).f36501a);
        }

        public int hashCode() {
            return this.f36501a.hashCode();
        }

        public String toString() {
            return "HandleErrorEvent(error=" + this.f36501a + ')';
        }

        public final e a(com.sumsub.sns.internal.core.data.model.o oVar) {
            return new e(oVar);
        }

        public static /* synthetic */ e a(e eVar, com.sumsub.sns.internal.core.data.model.o oVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                oVar = eVar.f36501a;
            }
            return eVar.a(oVar);
        }
    }

    public static abstract class f implements h {

        public static final class a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final RectF f36502a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f36503b;

            public a(RectF rectF, CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36502a = rectF;
                this.f36503b = charSequence;
            }

            public final a a(RectF rectF, CharSequence charSequence) {
                return new a(rectF, charSequence);
            }

            public final RectF b() {
                return this.f36502a;
            }

            public final CharSequence c() {
                return a();
            }

            public final RectF d() {
                return this.f36502a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return kotlin.jvm.internal.x.b(this.f36502a, aVar.f36502a) && kotlin.jvm.internal.x.b(a(), aVar.a());
            }

            public int hashCode() {
                return (this.f36502a.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
            }

            public String toString() {
                return "FaceRecognized(faceRectangle=" + this.f36502a + ", hint=" + a() + ')';
            }

            public static /* synthetic */ a a(a aVar, RectF rectF, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    rectF = aVar.f36502a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = aVar.a();
                }
                return aVar.a(rectF, charSequence);
            }

            public CharSequence a() {
                return this.f36503b;
            }
        }

        /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$f$b  reason: collision with other inner class name */
        public static final class C0494b extends f {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f36504a;

            public C0494b(CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36504a = charSequence;
            }

            public final C0494b a(CharSequence charSequence) {
                return new C0494b(charSequence);
            }

            public final CharSequence b() {
                return a();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0494b) && kotlin.jvm.internal.x.b(a(), ((C0494b) obj).a());
            }

            public int hashCode() {
                if (a() == null) {
                    return 0;
                }
                return a().hashCode();
            }

            public String toString() {
                return "NoFace(hint=" + a() + ')';
            }

            public static /* synthetic */ C0494b a(C0494b bVar, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = bVar.a();
                }
                return bVar.a(charSequence);
            }

            public CharSequence a() {
                return this.f36504a;
            }
        }

        public static final class c extends f {

            /* renamed from: a  reason: collision with root package name */
            public final RectF f36505a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f36506b;

            public c(RectF rectF, CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36505a = rectF;
                this.f36506b = charSequence;
            }

            public final c a(RectF rectF, CharSequence charSequence) {
                return new c(rectF, charSequence);
            }

            public final RectF b() {
                return this.f36505a;
            }

            public final CharSequence c() {
                return a();
            }

            public final RectF d() {
                return this.f36505a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return kotlin.jvm.internal.x.b(this.f36505a, cVar.f36505a) && kotlin.jvm.internal.x.b(a(), cVar.a());
            }

            public int hashCode() {
                return (this.f36505a.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
            }

            public String toString() {
                return "NotInCapturingBox(faceRectangle=" + this.f36505a + ", hint=" + a() + ')';
            }

            public static /* synthetic */ c a(c cVar, RectF rectF, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    rectF = cVar.f36505a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = cVar.a();
                }
                return cVar.a(rectF, charSequence);
            }

            public CharSequence a() {
                return this.f36506b;
            }
        }

        public static final class d extends f {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f36507a;

            public d(CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36507a = charSequence;
            }

            public final d a(CharSequence charSequence) {
                return new d(charSequence);
            }

            public final CharSequence b() {
                return a();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && kotlin.jvm.internal.x.b(a(), ((d) obj).a());
            }

            public int hashCode() {
                if (a() == null) {
                    return 0;
                }
                return a().hashCode();
            }

            public String toString() {
                return "TooManyFaces(hint=" + a() + ')';
            }

            public static /* synthetic */ d a(d dVar, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = dVar.a();
                }
                return dVar.a(charSequence);
            }

            public CharSequence a() {
                return this.f36507a;
            }
        }

        public /* synthetic */ f(kotlin.jvm.internal.r rVar) {
            this();
        }

        public f() {
        }
    }

    public static abstract class g {

        public static final class a extends g {

            /* renamed from: a  reason: collision with root package name */
            public final float f36508a;

            public a(float f11) {
                super((kotlin.jvm.internal.r) null);
                this.f36508a = f11;
            }

            public final float a() {
                return this.f36508a;
            }

            public final float b() {
                return this.f36508a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.x.b(Float.valueOf(this.f36508a), Float.valueOf(((a) obj).f36508a));
            }

            public int hashCode() {
                return Float.floatToIntBits(this.f36508a);
            }

            public String toString() {
                return "Calibration(value=" + this.f36508a + ')';
            }

            public final a a(float f11) {
                return new a(f11);
            }

            public static /* synthetic */ a a(a aVar, float f11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    f11 = aVar.f36508a;
                }
                return aVar.a(f11);
            }
        }

        /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$g$b  reason: collision with other inner class name */
        public static final class C0495b extends g {

            /* renamed from: a  reason: collision with root package name */
            public final Bitmap f36509a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f36510b;

            public C0495b(Bitmap bitmap, CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36509a = bitmap;
                this.f36510b = charSequence;
            }

            public final Bitmap a() {
                return this.f36509a;
            }

            public final CharSequence b() {
                return this.f36510b;
            }

            public final Bitmap c() {
                return this.f36509a;
            }

            public final CharSequence d() {
                return this.f36510b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0495b)) {
                    return false;
                }
                C0495b bVar = (C0495b) obj;
                return kotlin.jvm.internal.x.b(this.f36509a, bVar.f36509a) && kotlin.jvm.internal.x.b(this.f36510b, bVar.f36510b);
            }

            public int hashCode() {
                Bitmap bitmap = this.f36509a;
                int i11 = 0;
                int hashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
                CharSequence charSequence = this.f36510b;
                if (charSequence != null) {
                    i11 = charSequence.hashCode();
                }
                return hashCode + i11;
            }

            public String toString() {
                return "Completed(blurredLastImage=" + this.f36509a + ", hint=" + this.f36510b + ')';
            }

            public final C0495b a(Bitmap bitmap, CharSequence charSequence) {
                return new C0495b(bitmap, charSequence);
            }

            public static /* synthetic */ C0495b a(C0495b bVar, Bitmap bitmap, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    bitmap = bVar.f36509a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = bVar.f36510b;
                }
                return bVar.a(bitmap, charSequence);
            }
        }

        public static final class c extends g {

            /* renamed from: a  reason: collision with root package name */
            public final float f36511a;

            public c(float f11) {
                super((kotlin.jvm.internal.r) null);
                this.f36511a = f11;
            }

            public final float a() {
                return this.f36511a;
            }

            public final float b() {
                return this.f36511a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && kotlin.jvm.internal.x.b(Float.valueOf(this.f36511a), Float.valueOf(((c) obj).f36511a));
            }

            public int hashCode() {
                return Float.floatToIntBits(this.f36511a);
            }

            public String toString() {
                return "EndCalibration(value=" + this.f36511a + ')';
            }

            public final c a(float f11) {
                return new c(f11);
            }

            public static /* synthetic */ c a(c cVar, float f11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    f11 = cVar.f36511a;
                }
                return cVar.a(f11);
            }
        }

        public static final class d extends g {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f36512a;

            public d(CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36512a = charSequence;
            }

            public final CharSequence a() {
                return this.f36512a;
            }

            public final CharSequence b() {
                return this.f36512a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && kotlin.jvm.internal.x.b(this.f36512a, ((d) obj).f36512a);
            }

            public int hashCode() {
                CharSequence charSequence = this.f36512a;
                if (charSequence == null) {
                    return 0;
                }
                return charSequence.hashCode();
            }

            public String toString() {
                return "LowConnection(hint=" + this.f36512a + ')';
            }

            public final d a(CharSequence charSequence) {
                return new d(charSequence);
            }

            public static /* synthetic */ d a(d dVar, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = dVar.f36512a;
                }
                return dVar.a(charSequence);
            }
        }

        public static final class e extends g {

            /* renamed from: a  reason: collision with root package name */
            public final float f36513a;

            public e(float f11) {
                super((kotlin.jvm.internal.r) null);
                this.f36513a = f11;
            }

            public final float a() {
                return this.f36513a;
            }

            public final float b() {
                return this.f36513a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && kotlin.jvm.internal.x.b(Float.valueOf(this.f36513a), Float.valueOf(((e) obj).f36513a));
            }

            public int hashCode() {
                return Float.floatToIntBits(this.f36513a);
            }

            public String toString() {
                return "Progress(progress=" + this.f36513a + ')';
            }

            public final e a(float f11) {
                return new e(f11);
            }

            public static /* synthetic */ e a(e eVar, float f11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    f11 = eVar.f36513a;
                }
                return eVar.a(f11);
            }
        }

        public static final class f extends g {

            /* renamed from: a  reason: collision with root package name */
            public final com.sumsub.sns.prooface.data.j f36514a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f36515b;

            /* renamed from: c  reason: collision with root package name */
            public final CharSequence f36516c;

            /* renamed from: d  reason: collision with root package name */
            public final CharSequence f36517d;

            public f(com.sumsub.sns.prooface.data.j jVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
                super((kotlin.jvm.internal.r) null);
                this.f36514a = jVar;
                this.f36515b = charSequence;
                this.f36516c = charSequence2;
                this.f36517d = charSequence3;
            }

            public final com.sumsub.sns.prooface.data.j a() {
                return this.f36514a;
            }

            public final CharSequence b() {
                return this.f36515b;
            }

            public final CharSequence c() {
                return this.f36516c;
            }

            public final CharSequence d() {
                return this.f36517d;
            }

            public final CharSequence e() {
                return this.f36515b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                return kotlin.jvm.internal.x.b(this.f36514a, fVar.f36514a) && kotlin.jvm.internal.x.b(this.f36515b, fVar.f36515b) && kotlin.jvm.internal.x.b(this.f36516c, fVar.f36516c) && kotlin.jvm.internal.x.b(this.f36517d, fVar.f36517d);
            }

            public final com.sumsub.sns.prooface.data.j f() {
                return this.f36514a;
            }

            public final CharSequence g() {
                return this.f36517d;
            }

            public final CharSequence h() {
                return this.f36516c;
            }

            public int hashCode() {
                com.sumsub.sns.prooface.data.j jVar = this.f36514a;
                int i11 = 0;
                int hashCode = (jVar == null ? 0 : jVar.hashCode()) * 31;
                CharSequence charSequence = this.f36515b;
                int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
                CharSequence charSequence2 = this.f36516c;
                int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                CharSequence charSequence3 = this.f36517d;
                if (charSequence3 != null) {
                    i11 = charSequence3.hashCode();
                }
                return hashCode3 + i11;
            }

            public String toString() {
                return "SessionResult(session=" + this.f36514a + ", retryText=" + this.f36515b + ", title=" + this.f36516c + ", text=" + this.f36517d + ')';
            }

            public final f a(com.sumsub.sns.prooface.data.j jVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
                return new f(jVar, charSequence, charSequence2, charSequence3);
            }

            public static /* synthetic */ f a(f fVar, com.sumsub.sns.prooface.data.j jVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    jVar = fVar.f36514a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = fVar.f36515b;
                }
                if ((i11 & 4) != 0) {
                    charSequence2 = fVar.f36516c;
                }
                if ((i11 & 8) != 0) {
                    charSequence3 = fVar.f36517d;
                }
                return fVar.a(jVar, charSequence, charSequence2, charSequence3);
            }
        }

        /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$g$g  reason: collision with other inner class name */
        public static final class C0496g extends g {

            /* renamed from: a  reason: collision with root package name */
            public final boolean f36518a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f36519b;

            public C0496g(boolean z11, CharSequence charSequence) {
                super((kotlin.jvm.internal.r) null);
                this.f36518a = z11;
                this.f36519b = charSequence;
            }

            public final boolean a() {
                return this.f36518a;
            }

            public final CharSequence b() {
                return this.f36519b;
            }

            public final boolean c() {
                return this.f36518a;
            }

            public final CharSequence d() {
                return this.f36519b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0496g)) {
                    return false;
                }
                C0496g gVar = (C0496g) obj;
                return this.f36518a == gVar.f36518a && kotlin.jvm.internal.x.b(this.f36519b, gVar.f36519b);
            }

            public int hashCode() {
                boolean z11 = this.f36518a;
                if (z11) {
                    z11 = true;
                }
                int i11 = (z11 ? 1 : 0) * true;
                CharSequence charSequence = this.f36519b;
                return i11 + (charSequence == null ? 0 : charSequence.hashCode());
            }

            public String toString() {
                return "Started(calibrationEnabled=" + this.f36518a + ", hint=" + this.f36519b + ')';
            }

            public final C0496g a(boolean z11, CharSequence charSequence) {
                return new C0496g(z11, charSequence);
            }

            public static /* synthetic */ C0496g a(C0496g gVar, boolean z11, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    z11 = gVar.f36518a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = gVar.f36519b;
                }
                return gVar.a(z11, charSequence);
            }
        }

        public /* synthetic */ g(kotlin.jvm.internal.r rVar) {
            this();
        }

        public g() {
        }
    }

    public interface h {
        CharSequence a();
    }

    public static final class i implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final j f36520a;

        public i() {
            this((j) null, 1, (kotlin.jvm.internal.r) null);
        }

        public final j a() {
            return this.f36520a;
        }

        public final j b() {
            return this.f36520a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && kotlin.jvm.internal.x.b(this.f36520a, ((i) obj).f36520a);
        }

        public int hashCode() {
            j jVar = this.f36520a;
            if (jVar == null) {
                return 0;
            }
            return jVar.hashCode();
        }

        public String toString() {
            return "ViewState(warningDialog=" + this.f36520a + ')';
        }

        public i(j jVar) {
            this.f36520a = jVar;
        }

        public final i a(j jVar) {
            return new i(jVar);
        }

        public static /* synthetic */ i a(i iVar, j jVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                jVar = iVar.f36520a;
            }
            return iVar.a(jVar);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ i(j jVar, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? null : jVar);
        }
    }

    public static final class j {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f36521a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f36522b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f36523c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f36524d;

        public j(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            this.f36521a = charSequence;
            this.f36522b = charSequence2;
            this.f36523c = charSequence3;
            this.f36524d = charSequence4;
        }

        public final CharSequence a() {
            return this.f36521a;
        }

        public final CharSequence b() {
            return this.f36522b;
        }

        public final CharSequence c() {
            return this.f36523c;
        }

        public final CharSequence d() {
            return this.f36524d;
        }

        public final CharSequence e() {
            return this.f36523c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return kotlin.jvm.internal.x.b(this.f36521a, jVar.f36521a) && kotlin.jvm.internal.x.b(this.f36522b, jVar.f36522b) && kotlin.jvm.internal.x.b(this.f36523c, jVar.f36523c) && kotlin.jvm.internal.x.b(this.f36524d, jVar.f36524d);
        }

        public final CharSequence f() {
            return this.f36524d;
        }

        public final CharSequence g() {
            return this.f36522b;
        }

        public final CharSequence h() {
            return this.f36521a;
        }

        public int hashCode() {
            CharSequence charSequence = this.f36521a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f36522b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f36523c;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f36524d;
            if (charSequence4 != null) {
                i11 = charSequence4.hashCode();
            }
            return hashCode3 + i11;
        }

        public String toString() {
            return "WriteSettingsDialog(message=" + this.f36521a + ", buttonPositive=" + this.f36522b + ", buttonNegative=" + this.f36523c + ", buttonNeutral=" + this.f36524d + ')';
        }

        public final j a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            return new j(charSequence, charSequence2, charSequence3, charSequence4);
        }

        public static /* synthetic */ j a(j jVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = jVar.f36521a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = jVar.f36522b;
            }
            if ((i11 & 4) != 0) {
                charSequence3 = jVar.f36523c;
            }
            if ((i11 & 8) != 0) {
                charSequence4 = jVar.f36524d;
            }
            return jVar.a(charSequence, charSequence2, charSequence3, charSequence4);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel", f = "SNSLiveness3dFaceViewModel.kt", l = {698}, m = "encodeSegment")
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36525a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36526b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36527c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36528d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36529e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36530f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36531g;

        /* renamed from: h  reason: collision with root package name */
        public Object f36532h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36533i;

        /* renamed from: j  reason: collision with root package name */
        public Object f36534j;

        /* renamed from: k  reason: collision with root package name */
        public Object f36535k;

        /* renamed from: l  reason: collision with root package name */
        public Object f36536l;

        /* renamed from: m  reason: collision with root package name */
        public Object f36537m;

        /* renamed from: n  reason: collision with root package name */
        public Object f36538n;

        /* renamed from: o  reason: collision with root package name */
        public Object f36539o;

        /* renamed from: p  reason: collision with root package name */
        public int f36540p;

        /* renamed from: q  reason: collision with root package name */
        public long f36541q;

        /* renamed from: r  reason: collision with root package name */
        public /* synthetic */ Object f36542r;

        /* renamed from: s  reason: collision with root package name */
        public final /* synthetic */ b f36543s;

        /* renamed from: t  reason: collision with root package name */
        public int f36544t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(b bVar, kotlin.coroutines.c<? super k> cVar) {
            super(cVar);
            this.f36543s = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36542r = obj;
            this.f36544t |= Integer.MIN_VALUE;
            return this.f36543s.a((Bitmap) null, (Size) null, (String) null, (kotlin.coroutines.c<? super com.sumsub.sns.prooface.data.h>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$enqueueSegment$1", f = "SNSLiveness3dFaceViewModel.kt", l = {664}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36545a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36546b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bitmap f36547c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Size f36548d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f36549e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(b bVar, Bitmap bitmap, Size size, String str, kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
            this.f36546b = bVar;
            this.f36547c = bitmap;
            this.f36548d = size;
            this.f36549e = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l(this.f36546b, this.f36547c, this.f36548d, this.f36549e, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36545a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a1 f11 = this.f36546b.O;
                Triple triple = new Triple(this.f36547c, this.f36548d, this.f36549e);
                this.f36545a = 1;
                if (f11.emit(triple, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class m extends Lambda implements d10.a<h.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f36550a = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final h.b invoke() {
            h.b a11 = com.sumsub.sns.internal.core.domain.h.f33605a.a();
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "detector config: " + a11, (Throwable) null, 4, (Object) null);
            return a11;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$finishWithReason$1", f = "SNSLiveness3dFaceViewModel.kt", l = {853}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36553c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSLivenessReason f36554d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(b bVar, String str, SNSLivenessReason sNSLivenessReason, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f36552b = bVar;
            this.f36553c = str;
            this.f36554d = sNSLivenessReason;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n(this.f36552b, this.f36553c, this.f36554d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36551a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.core.data.source.dynamic.b e11 = this.f36552b.H;
                this.f36551a = 1;
                obj = com.sumsub.sns.internal.core.data.source.dynamic.h.h(e11, false, this, 1, (Object) null);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.internal.core.data.model.e eVar = (com.sumsub.sns.internal.core.data.model.e) ((com.sumsub.sns.internal.core.data.source.dynamic.e) obj).d();
            if (eVar == null) {
                return Unit.f56620a;
            }
            e.a r11 = eVar.r();
            FlowActionType d12 = r11 != null ? r11.d() : null;
            FlowActionType.FaceEnrollment faceEnrollment = FlowActionType.FaceEnrollment.INSTANCE;
            if (kotlin.jvm.internal.x.b(d12, faceEnrollment)) {
                this.f36552b.G.a((SNSSDKState) new SNSSDKState.ActionCompleted(r11.c(), faceEnrollment, this.f36553c, MapsKt__MapsJVMKt.e(kotlin.l.a(Constants.REASON, this.f36554d))));
                obj2 = new u.b(r11.c(), this.f36554d, this.f36553c);
            } else {
                obj2 = new u.c(this.f36554d, this.f36552b.u());
            }
            Object obj3 = obj2;
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "finish: " + obj3, (Throwable) null, 4, (Object) null);
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this.f36552b, (com.sumsub.sns.internal.core.common.q) null, obj3, (Long) null, 5, (Object) null);
            return Unit.f56620a;
        }
    }

    public static final class o extends Lambda implements d10.l<Map<String, ? extends String>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.coroutines.c<Map<String, String>> f36555a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(kotlin.coroutines.c<? super Map<String, String>> cVar) {
            super(1);
            this.f36555a = cVar;
        }

        public final void a(Map<String, String> map) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.a(aVar, Fingerprinter.f34263d, "Fingerprint size: " + map.size(), (Throwable) null, 4, (Object) null);
            kotlin.coroutines.c<Map<String, String>> cVar = this.f36555a;
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(map));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Map) obj);
            return Unit.f56620a;
        }
    }

    public static final class p extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final p f36556a = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final Boolean invoke() {
            Boolean f11 = new com.sumsub.sns.internal.core.common.f().f();
            return Boolean.valueOf(f11 != null ? f11.booleanValue() : false);
        }
    }

    public static final class q implements Liveness3dFaceRepository.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f36557a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$livenessCallback$1$onResult$2", f = "SNSLiveness3dFaceViewModel.kt", l = {159}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f36558a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f36559b;

            /* renamed from: c  reason: collision with root package name */
            public int f36560c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f36561d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f36562e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, boolean z11, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36561d = bVar;
                this.f36562e = z11;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36561d, this.f36562e, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                b1 b1Var;
                boolean z11;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36560c;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    b1Var = this.f36561d.f36461g0;
                    boolean z12 = this.f36562e;
                    b bVar = this.f36561d;
                    this.f36558a = b1Var;
                    this.f36559b = z12;
                    this.f36560c = 1;
                    Object a11 = bVar.a("sns_facescan_hint_facePosition", (kotlin.coroutines.c<? super String>) this);
                    if (a11 == d11) {
                        return d11;
                    }
                    z11 = z12;
                    obj = a11;
                } else if (i11 == 1) {
                    z11 = this.f36559b;
                    b1Var = (b1) this.f36558a;
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b1Var.setValue(new g.C0496g(z11, (CharSequence) obj));
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$livenessCallback$1$onResult$3", f = "SNSLiveness3dFaceViewModel.kt", l = {172}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.prooface.presentation.b$q$b  reason: collision with other inner class name */
        public static final class C0497b extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f36563a;

            /* renamed from: b  reason: collision with root package name */
            public int f36564b;

            /* renamed from: c  reason: collision with root package name */
            public int f36565c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f36566d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0497b(b bVar, kotlin.coroutines.c<? super C0497b> cVar) {
                super(2, cVar);
                this.f36566d = bVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0497b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0497b(this.f36566d, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                b1 b1Var;
                int i11;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i12 = this.f36565c;
                boolean z11 = false;
                if (i12 == 0) {
                    kotlin.k.b(obj);
                    b1Var = this.f36566d.f36461g0;
                    b bVar = this.f36566d;
                    this.f36563a = b1Var;
                    this.f36564b = 0;
                    this.f36565c = 1;
                    obj = bVar.a("sns_facescan_hint_facePosition", (kotlin.coroutines.c<? super String>) this);
                    if (obj == d11) {
                        return d11;
                    }
                    i11 = 0;
                } else if (i12 == 1) {
                    i11 = this.f36564b;
                    b1Var = (b1) this.f36563a;
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CharSequence charSequence = (CharSequence) obj;
                if (i11 != 0) {
                    z11 = true;
                }
                b1Var.setValue(new g.C0496g(z11, charSequence));
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$livenessCallback$1$onResult$4", f = "SNSLiveness3dFaceViewModel.kt", l = {186}, m = "invokeSuspend")
        public static final class c extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f36567a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36568b;

            /* renamed from: c  reason: collision with root package name */
            public int f36569c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f36570d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(b bVar, kotlin.coroutines.c<? super c> cVar) {
                super(2, cVar);
                this.f36570d = bVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new c(this.f36570d, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                b1 b1Var;
                Bitmap bitmap;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36569c;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    b1Var = this.f36570d.f36461g0;
                    Bitmap g11 = this.f36570d.f36457c0;
                    b bVar = this.f36570d;
                    this.f36567a = b1Var;
                    this.f36568b = g11;
                    this.f36569c = 1;
                    Object a11 = bVar.a("sns_facescan_hint_processing", (kotlin.coroutines.c<? super String>) this);
                    if (a11 == d11) {
                        return d11;
                    }
                    bitmap = g11;
                    obj = a11;
                } else if (i11 == 1) {
                    bitmap = (Bitmap) this.f36568b;
                    b1Var = (b1) this.f36567a;
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b1Var.setValue(new g.C0495b(bitmap, (CharSequence) obj));
                return Unit.f56620a;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$livenessCallback$1$onResult$5", f = "SNSLiveness3dFaceViewModel.kt", l = {196, 199, 210, 211, 217}, m = "invokeSuspend")
        public static final class d extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f36571a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36572b;

            /* renamed from: c  reason: collision with root package name */
            public Object f36573c;

            /* renamed from: d  reason: collision with root package name */
            public Object f36574d;

            /* renamed from: e  reason: collision with root package name */
            public int f36575e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f36576f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Liveness3dFaceRepository.LivenessRepositoryResult f36577g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(b bVar, Liveness3dFaceRepository.LivenessRepositoryResult livenessRepositoryResult, kotlin.coroutines.c<? super d> cVar) {
                super(2, cVar);
                this.f36576f = bVar;
                this.f36577g = livenessRepositoryResult;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new d(this.f36576f, this.f36577g, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00cf A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00fe A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff  */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0133 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0134  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    r13 = this;
                    java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r0 = r13.f36575e
                    r7 = 5
                    r8 = 4
                    r9 = 3
                    r1 = 2
                    r10 = 0
                    r11 = 1
                    if (r0 == 0) goto L_0x0064
                    if (r0 == r11) goto L_0x005f
                    if (r0 == r1) goto L_0x005a
                    if (r0 == r9) goto L_0x004c
                    if (r0 == r8) goto L_0x0036
                    if (r0 != r7) goto L_0x002e
                    java.lang.Object r0 = r13.f36574d
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r13.f36573c
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    java.lang.Object r2 = r13.f36572b
                    com.sumsub.sns.prooface.data.j r2 = (com.sumsub.sns.prooface.data.j) r2
                    java.lang.Object r3 = r13.f36571a
                    kotlinx.coroutines.flow.b1 r3 = (kotlinx.coroutines.flow.b1) r3
                    kotlin.k.b(r14)
                    r4 = r14
                    goto L_0x0137
                L_0x002e:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L_0x0036:
                    java.lang.Object r0 = r13.f36573c
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r13.f36572b
                    com.sumsub.sns.prooface.data.j r1 = (com.sumsub.sns.prooface.data.j) r1
                    java.lang.Object r2 = r13.f36571a
                    kotlinx.coroutines.flow.b1 r2 = (kotlinx.coroutines.flow.b1) r2
                    kotlin.k.b(r14)
                    r3 = r14
                    r12 = r1
                    r1 = r0
                    r0 = r2
                    r2 = r12
                    goto L_0x0103
                L_0x004c:
                    java.lang.Object r0 = r13.f36572b
                    com.sumsub.sns.prooface.data.j r0 = (com.sumsub.sns.prooface.data.j) r0
                    java.lang.Object r1 = r13.f36571a
                    kotlinx.coroutines.flow.b1 r1 = (kotlinx.coroutines.flow.b1) r1
                    kotlin.k.b(r14)
                    r2 = r14
                    goto L_0x00d0
                L_0x005a:
                    kotlin.k.b(r14)
                    r0 = r14
                    goto L_0x009e
                L_0x005f:
                    kotlin.k.b(r14)
                    r0 = r14
                    goto L_0x0077
                L_0x0064:
                    kotlin.k.b(r14)
                    com.sumsub.sns.internal.prooface.presentation.b r0 = r13.f36576f
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.H
                    r13.f36575e = r11
                    r2 = 0
                    java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r0, r10, r13, r11, r2)
                    if (r0 != r6) goto L_0x0077
                    return r6
                L_0x0077:
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r0
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                    if (r0 != 0) goto L_0x0084
                    kotlin.Unit r0 = kotlin.Unit.f56620a
                    return r0
                L_0x0084:
                    com.sumsub.sns.internal.core.data.model.e$a r0 = r0.r()
                    if (r0 == 0) goto L_0x00b1
                    com.sumsub.sns.internal.prooface.presentation.b r0 = r13.f36576f
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.H
                    r13.f36575e = r1
                    r1 = 0
                    r2 = 0
                    r4 = 3
                    r5 = 0
                    r3 = r13
                    java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.dynamic.h.a(r0, r1, r2, r3, r4, r5)
                    if (r0 != r6) goto L_0x009e
                    return r6
                L_0x009e:
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r0
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
                    if (r0 == 0) goto L_0x00b1
                    com.sumsub.sns.internal.prooface.presentation.b r1 = r13.f36576f
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult r2 = r13.f36577g
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$g r2 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.g) r2
                    r1.a((com.sumsub.sns.internal.core.data.model.g) r0, (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.g) r2)
                L_0x00b1:
                    com.sumsub.sns.internal.prooface.presentation.b r0 = r13.f36576f
                    kotlinx.coroutines.flow.b1 r1 = r0.f36461g0
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult r0 = r13.f36577g
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$g r0 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.g) r0
                    com.sumsub.sns.prooface.data.j r0 = r0.a()
                    com.sumsub.sns.internal.prooface.presentation.b r2 = r13.f36576f
                    r13.f36571a = r1
                    r13.f36572b = r0
                    r13.f36575e = r9
                    java.lang.String r3 = "sns_facescan_action_retry"
                    java.lang.Object r2 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r13)
                    if (r2 != r6) goto L_0x00d0
                    return r6
                L_0x00d0:
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    com.sumsub.sns.internal.prooface.presentation.b r3 = r13.f36576f
                    kotlin.jvm.internal.d0 r4 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r4 = new java.lang.Object[r11]
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult r5 = r13.f36577g
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$g r5 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.g) r5
                    com.sumsub.sns.prooface.data.j r5 = r5.a()
                    java.lang.String r5 = r3.a((com.sumsub.sns.prooface.data.j) r5)
                    r4[r10] = r5
                    java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r11)
                    java.lang.String r5 = "sns_facescan_result_%s_title"
                    java.lang.String r4 = java.lang.String.format(r5, r4)
                    r13.f36571a = r1
                    r13.f36572b = r0
                    r13.f36573c = r2
                    r13.f36575e = r8
                    java.lang.Object r3 = r3.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r13)
                    if (r3 != r6) goto L_0x00ff
                    return r6
                L_0x00ff:
                    r12 = r2
                    r2 = r0
                    r0 = r1
                    r1 = r12
                L_0x0103:
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    com.sumsub.sns.internal.prooface.presentation.b r4 = r13.f36576f
                    kotlin.jvm.internal.d0 r5 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r5 = new java.lang.Object[r11]
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult r8 = r13.f36577g
                    com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$g r8 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.g) r8
                    com.sumsub.sns.prooface.data.j r8 = r8.a()
                    java.lang.String r8 = r4.a((com.sumsub.sns.prooface.data.j) r8)
                    r5[r10] = r8
                    java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r11)
                    java.lang.String r8 = "sns_facescan_result_%s_text"
                    java.lang.String r5 = java.lang.String.format(r8, r5)
                    r13.f36571a = r0
                    r13.f36572b = r2
                    r13.f36573c = r1
                    r13.f36574d = r3
                    r13.f36575e = r7
                    java.lang.Object r4 = r4.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r13)
                    if (r4 != r6) goto L_0x0134
                    return r6
                L_0x0134:
                    r12 = r3
                    r3 = r0
                    r0 = r12
                L_0x0137:
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    com.sumsub.sns.internal.prooface.presentation.b$g$f r5 = new com.sumsub.sns.internal.prooface.presentation.b$g$f
                    r5.<init>(r2, r1, r0, r4)
                    r3.setValue(r5)
                    kotlin.Unit r0 = kotlin.Unit.f56620a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.q.d.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public q(b bVar) {
            this.f36557a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x002c, code lost:
            r3 = r3.e();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult r10) {
            /*
                r9 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "repository callback "
                r0.append(r1)
                r0.append(r10)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "Prooface"
                r2 = 0
                r3 = 4
                com.sumsub.sns.prooface.a.a(r1, r0, r2, r3, r2)
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r0.p()
                boolean r0 = r10 instanceof com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.f
                r1 = 0
                if (r0 == 0) goto L_0x00a9
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$f r10 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.f) r10
                com.sumsub.sns.prooface.data.j r3 = r10.a()
                if (r3 == 0) goto L_0x0037
                java.lang.Integer r3 = r3.e()
                if (r3 == 0) goto L_0x0037
                int r3 = r3.intValue()
                goto L_0x0038
            L_0x0037:
                r3 = r1
            L_0x0038:
                r0.X = r3
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r3 = 0
                r0.Z = r3
                com.sumsub.sns.prooface.data.j r0 = r10.a()
                if (r0 == 0) goto L_0x005f
                java.lang.String r0 = r0.i()
                if (r0 == 0) goto L_0x005f
                com.sumsub.sns.internal.prooface.presentation.b r3 = r9.f36557a
                com.sumsub.sns.prooface.network.a r4 = r3.D     // Catch:{ Exception -> 0x005b }
                r4.a(r0)     // Catch:{ Exception -> 0x005b }
                r3.f36456b0 = r0     // Catch:{ Exception -> 0x005b }
                goto L_0x005f
            L_0x005b:
                r0 = move-exception
                r3.b((java.lang.Throwable) r0)
            L_0x005f:
                com.sumsub.sns.prooface.data.j r10 = r10.a()
                if (r10 == 0) goto L_0x0070
                java.lang.Boolean r10 = r10.k()
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r10 = kotlin.jvm.internal.x.b(r10, r0)
                goto L_0x0071
            L_0x0070:
                r10 = r1
            L_0x0071:
                r10 = r10 ^ 1
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                if (r10 != 0) goto L_0x0081
                r0.b((boolean) r1)
                com.sumsub.sns.prooface.data.a$b r1 = com.sumsub.sns.prooface.data.a.Companion
                com.sumsub.sns.prooface.data.a r1 = r1.a()
                goto L_0x0090
            L_0x0081:
                com.sumsub.sns.prooface.data.a r1 = new com.sumsub.sns.prooface.data.a
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                r4 = 0
                r6 = 0
                r7 = 4
                r8 = 0
                r3 = r1
                r3.<init>((java.lang.String) r4, (java.util.List) r5, (java.lang.String) r6, (int) r7, (kotlin.jvm.internal.r) r8)
            L_0x0090:
                r0.Q = r1
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                kotlinx.coroutines.h0 r3 = androidx.lifecycle.m0.a(r0)
                com.sumsub.sns.internal.prooface.presentation.b$q$a r6 = new com.sumsub.sns.internal.prooface.presentation.b$q$a
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r6.<init>(r0, r10, r2)
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
                goto L_0x017e
            L_0x00a9:
                boolean r0 = r10 instanceof com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.d
                if (r0 == 0) goto L_0x00e2
                com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$d r10 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.d) r10
                com.sumsub.sns.prooface.data.j r10 = r10.a()
                if (r10 == 0) goto L_0x00ba
                java.lang.String r10 = r10.c()
                goto L_0x00bb
            L_0x00ba:
                r10 = r2
            L_0x00bb:
                com.sumsub.sns.internal.core.data.model.AnswerType r0 = com.sumsub.sns.internal.core.data.model.AnswerType.Yellow
                java.lang.String r0 = r0.getValue()
                boolean r10 = kotlin.jvm.internal.x.b(r10, r0)
                if (r10 == 0) goto L_0x017e
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r10.Y = r1
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                kotlinx.coroutines.h0 r3 = androidx.lifecycle.m0.a(r10)
                com.sumsub.sns.internal.prooface.presentation.b$q$b r6 = new com.sumsub.sns.internal.prooface.presentation.b$q$b
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r6.<init>(r10, r2)
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
                goto L_0x017e
            L_0x00e2:
                boolean r0 = r10 instanceof com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.b
                if (r0 == 0) goto L_0x0106
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r10.X = r1
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r10.b((boolean) r1)
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                kotlinx.coroutines.h0 r3 = androidx.lifecycle.m0.a(r10)
                com.sumsub.sns.internal.prooface.presentation.b$q$c r6 = new com.sumsub.sns.internal.prooface.presentation.b$q$c
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r6.<init>(r10, r2)
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
                goto L_0x017e
            L_0x0106:
                boolean r0 = r10 instanceof com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.g
                if (r0 == 0) goto L_0x0129
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r0.X = r1
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r0.b((boolean) r1)
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                kotlinx.coroutines.h0 r3 = androidx.lifecycle.m0.a(r0)
                com.sumsub.sns.internal.prooface.presentation.b$q$d r6 = new com.sumsub.sns.internal.prooface.presentation.b$q$d
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r6.<init>(r0, r10, r2)
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
                goto L_0x017e
            L_0x0129:
                boolean r0 = r10 instanceof com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.h
                if (r0 != 0) goto L_0x017e
                boolean r0 = r10 instanceof com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.c
                r3 = 2
                if (r0 == 0) goto L_0x0154
                com.sumsub.sns.internal.prooface.presentation.b r0 = r9.f36557a
                r0.X = r1
                com.sumsub.sns.core.data.model.SNSException$Network r0 = new com.sumsub.sns.core.data.model.SNSException$Network
                com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$c r10 = (com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.c) r10
                java.lang.Throwable r10 = r10.a()
                java.lang.Exception r10 = (java.lang.Exception) r10
                r0.<init>(r10)
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                com.sumsub.sns.core.data.model.SNSLivenessReason$NetworkError r1 = new com.sumsub.sns.core.data.model.SNSLivenessReason$NetworkError
                r1.<init>(r0)
                com.sumsub.sns.internal.prooface.presentation.b.a((com.sumsub.sns.internal.prooface.presentation.b) r10, (com.sumsub.sns.core.data.model.SNSLivenessReason) r1, (java.lang.String) r2, (int) r3, (java.lang.Object) r2)
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r10.b((java.lang.Throwable) r0)
                goto L_0x017e
            L_0x0154:
                com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$a r0 = com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.a.f40247a
                boolean r0 = kotlin.jvm.internal.x.b(r10, r0)
                if (r0 == 0) goto L_0x0171
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r10.X = r1
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                com.sumsub.sns.core.data.model.SNSLivenessReason$NetworkError r0 = new com.sumsub.sns.core.data.model.SNSLivenessReason$NetworkError
                java.io.IOException r1 = new java.io.IOException
                r1.<init>()
                r0.<init>(r1)
                com.sumsub.sns.internal.prooface.presentation.b.a((com.sumsub.sns.internal.prooface.presentation.b) r10, (com.sumsub.sns.core.data.model.SNSLivenessReason) r0, (java.lang.String) r2, (int) r3, (java.lang.Object) r2)
                goto L_0x017e
            L_0x0171:
                com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$e r0 = com.sumsub.sns.prooface.network.Liveness3dFaceRepository.LivenessRepositoryResult.e.f40251a
                boolean r10 = kotlin.jvm.internal.x.b(r10, r0)
                if (r10 == 0) goto L_0x017e
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36557a
                r10.X = r1
            L_0x017e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.q.a(com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult):void");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$onCameraPermissionDenied$1", f = "SNSLiveness3dFaceViewModel.kt", l = {799, 800, 801}, m = "invokeSuspend")
    public static final class s extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36582a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36583b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36584c;

        /* renamed from: d  reason: collision with root package name */
        public int f36585d;

        /* renamed from: e  reason: collision with root package name */
        public int f36586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f36587f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(b bVar, kotlin.coroutines.c<? super s> cVar) {
            super(2, cVar);
            this.f36587f = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((s) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s(this.f36587f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f36586e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0047
                if (r1 == r4) goto L_0x003d
                if (r1 == r3) goto L_0x002f
                if (r1 != r2) goto L_0x0027
                int r0 = r9.f36585d
                java.lang.Object r1 = r9.f36584c
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f36583b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r9.f36582a
                com.sumsub.sns.internal.prooface.presentation.b r3 = (com.sumsub.sns.internal.prooface.presentation.b) r3
                kotlin.k.b(r10)
                r7 = r3
                r3 = r1
                r1 = r0
                goto L_0x0093
            L_0x0027:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x002f:
                int r1 = r9.f36585d
                java.lang.Object r3 = r9.f36583b
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r9.f36582a
                com.sumsub.sns.internal.prooface.presentation.b r4 = (com.sumsub.sns.internal.prooface.presentation.b) r4
                kotlin.k.b(r10)
                goto L_0x0077
            L_0x003d:
                int r1 = r9.f36585d
                java.lang.Object r4 = r9.f36582a
                com.sumsub.sns.internal.prooface.presentation.b r4 = (com.sumsub.sns.internal.prooface.presentation.b) r4
                kotlin.k.b(r10)
                goto L_0x005f
            L_0x0047:
                kotlin.k.b(r10)
                com.sumsub.sns.internal.prooface.presentation.b r10 = r9.f36587f
                r1 = 0
                r9.f36582a = r10
                r9.f36585d = r1
                r9.f36586e = r4
                java.lang.String r4 = "sns_alert_lackOfCameraPermissions"
                java.lang.Object r4 = r10.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r4 != r0) goto L_0x005c
                return r0
            L_0x005c:
                r8 = r4
                r4 = r10
                r10 = r8
            L_0x005f:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                com.sumsub.sns.internal.prooface.presentation.b r5 = r9.f36587f
                r9.f36582a = r4
                r9.f36583b = r10
                r9.f36585d = r1
                r9.f36586e = r3
                java.lang.String r3 = "sns_alert_action_settings"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r3 != r0) goto L_0x0074
                return r0
            L_0x0074:
                r8 = r3
                r3 = r10
                r10 = r8
            L_0x0077:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                com.sumsub.sns.internal.prooface.presentation.b r5 = r9.f36587f
                r9.f36582a = r4
                r9.f36583b = r3
                r9.f36584c = r10
                r9.f36585d = r1
                r9.f36586e = r2
                java.lang.String r2 = "sns_alert_action_cancel"
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r2 != r0) goto L_0x008e
                return r0
            L_0x008e:
                r7 = r4
                r8 = r3
                r3 = r10
                r10 = r2
                r2 = r8
            L_0x0093:
                r4 = r10
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                com.sumsub.sns.core.presentation.base.a$n r10 = new com.sumsub.sns.core.presentation.base.a$n
                r5 = 1
                r6 = 0
                r0 = r10
                r0.<init>(r1, r2, r3, r4, r5, r6)
                r7.a((com.sumsub.sns.core.presentation.base.a.j) r10)
                kotlin.Unit r10 = kotlin.Unit.f56620a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.s.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel", f = "SNSLiveness3dFaceViewModel.kt", l = {322}, m = "onPrepare")
    public static final class t extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36588a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f36590c;

        /* renamed from: d  reason: collision with root package name */
        public int f36591d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(b bVar, kotlin.coroutines.c<? super t> cVar) {
            super(cVar);
            this.f36590c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36589b = obj;
            this.f36591d |= Integer.MIN_VALUE;
            return this.f36590c.d((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$onPrepare$2", f = "SNSLiveness3dFaceViewModel.kt", l = {327, 328, 329, 330}, m = "invokeSuspend")
    public static final class u extends SuspendLambda implements d10.p<i, kotlin.coroutines.c<? super i>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36592a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36593b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36594c;

        /* renamed from: d  reason: collision with root package name */
        public int f36595d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f36597f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(b bVar, kotlin.coroutines.c<? super u> cVar) {
            super(2, cVar);
            this.f36597f = bVar;
        }

        /* renamed from: a */
        public final Object invoke(i iVar, kotlin.coroutines.c<? super i> cVar) {
            return ((u) create(iVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            u uVar = new u(this.f36597f, cVar);
            uVar.f36596e = obj;
            return uVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0099 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00b4 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f36595d
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0055
                if (r1 == r5) goto L_0x004d
                if (r1 == r4) goto L_0x0041
                if (r1 == r3) goto L_0x0031
                if (r1 != r2) goto L_0x0029
                java.lang.Object r0 = r7.f36594c
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r7.f36593b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r7.f36592a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r7.f36596e
                com.sumsub.sns.internal.prooface.presentation.b$i r3 = (com.sumsub.sns.internal.prooface.presentation.b.i) r3
                kotlin.k.b(r8)
                goto L_0x00b9
            L_0x0029:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0031:
                java.lang.Object r1 = r7.f36593b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r3 = r7.f36592a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r7.f36596e
                com.sumsub.sns.internal.prooface.presentation.b$i r4 = (com.sumsub.sns.internal.prooface.presentation.b.i) r4
                kotlin.k.b(r8)
                goto L_0x009e
            L_0x0041:
                java.lang.Object r1 = r7.f36592a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r4 = r7.f36596e
                com.sumsub.sns.internal.prooface.presentation.b$i r4 = (com.sumsub.sns.internal.prooface.presentation.b.i) r4
                kotlin.k.b(r8)
                goto L_0x0085
            L_0x004d:
                java.lang.Object r1 = r7.f36596e
                com.sumsub.sns.internal.prooface.presentation.b$i r1 = (com.sumsub.sns.internal.prooface.presentation.b.i) r1
                kotlin.k.b(r8)
                goto L_0x006e
            L_0x0055:
                kotlin.k.b(r8)
                java.lang.Object r8 = r7.f36596e
                com.sumsub.sns.internal.prooface.presentation.b$i r8 = (com.sumsub.sns.internal.prooface.presentation.b.i) r8
                com.sumsub.sns.internal.prooface.presentation.b r1 = r7.f36597f
                r7.f36596e = r8
                r7.f36595d = r5
                java.lang.String r5 = "sns_alert_lackOfSettingsPermissions"
                java.lang.Object r1 = r1.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r1 != r0) goto L_0x006b
                return r0
            L_0x006b:
                r6 = r1
                r1 = r8
                r8 = r6
            L_0x006e:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.prooface.presentation.b r5 = r7.f36597f
                r7.f36596e = r1
                r7.f36592a = r8
                r7.f36595d = r4
                java.lang.String r4 = "sns_alert_action_ok"
                java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r4 != r0) goto L_0x0081
                return r0
            L_0x0081:
                r6 = r1
                r1 = r8
                r8 = r4
                r4 = r6
            L_0x0085:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.prooface.presentation.b r5 = r7.f36597f
                r7.f36596e = r4
                r7.f36592a = r1
                r7.f36593b = r8
                r7.f36595d = r3
                java.lang.String r3 = "sns_alert_action_dont_show"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r3 != r0) goto L_0x009a
                return r0
            L_0x009a:
                r6 = r1
                r1 = r8
                r8 = r3
                r3 = r6
            L_0x009e:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.prooface.presentation.b r5 = r7.f36597f
                r7.f36596e = r4
                r7.f36592a = r3
                r7.f36593b = r1
                r7.f36594c = r8
                r7.f36595d = r2
                java.lang.String r2 = "sns_alert_action_cancel"
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r2 != r0) goto L_0x00b5
                return r0
            L_0x00b5:
                r0 = r8
                r8 = r2
                r2 = r3
                r3 = r4
            L_0x00b9:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.prooface.presentation.b$j r4 = new com.sumsub.sns.internal.prooface.presentation.b$j
                r4.<init>(r2, r1, r0, r8)
                com.sumsub.sns.internal.prooface.presentation.b$i r8 = r3.a(r4)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.u.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class v extends Lambda implements d10.l<o.a, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f36598a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f36599b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(b bVar, d10.a<Unit> aVar) {
            super(1);
            this.f36598a = bVar;
            this.f36599b = aVar;
        }

        public final void a(o.a aVar) {
            this.f36598a.a(aVar);
            this.f36599b.invoke();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((o.a) obj);
            return Unit.f56620a;
        }
    }

    public static final class w extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageProxy f36600a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(ImageProxy imageProxy) {
            super(0);
            this.f36600a = imageProxy;
        }

        public final void a() {
            this.f36600a.close();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class x extends Lambda implements d10.p<Integer, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f36601a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(b bVar) {
            super(2);
            this.f36601a = bVar;
        }

        public final Bitmap a(int i11, int i12) {
            return this.f36601a.f36464j0.a(i11, i12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), ((Number) obj2).intValue());
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.prooface.presentation.SNSLiveness3dFaceViewModel$refuseShowSettingsDialog$1", f = "SNSLiveness3dFaceViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36602a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36603b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(b bVar, kotlin.coroutines.c<? super y> cVar) {
            super(2, cVar);
            this.f36603b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((y) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new y(this.f36603b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36602a == 0) {
                kotlin.k.b(obj);
                this.f36603b.F.d();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class z extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f36604a;

        public z(b bVar) {
            this.f36604a = bVar;
        }

        public void run() {
            this.f36604a.D();
        }
    }

    public b(com.sumsub.sns.internal.core.domain.o oVar, DocumentType documentType, kotlinx.serialization.json.a aVar, com.sumsub.sns.prooface.network.a aVar2, Liveness3dFaceRepository liveness3dFaceRepository, com.sumsub.sns.internal.core.data.source.settings.b bVar, com.sumsub.sns.internal.core.data.source.common.a aVar3, com.sumsub.sns.internal.core.data.source.dynamic.b bVar2, Fingerprinter fingerprinter) {
        super(aVar3, bVar2);
        this.A = oVar;
        this.B = documentType;
        this.C = aVar;
        this.D = aVar2;
        this.E = liveness3dFaceRepository;
        this.F = bVar;
        this.G = aVar3;
        this.H = bVar2;
        this.I = fingerprinter;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("msdk2 / 1.32.1 (Android ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append(") - App ");
        e0 e0Var = e0.f32018a;
        sb2.append(e0Var.getPackageName());
        sb2.append(' ');
        sb2.append(e0Var.getVersionName());
        sb2.append(" / ");
        sb2.append(e0Var.getVersionCode());
        this.M = sb2.toString();
        ExecutorCoroutineDispatcher b11 = f1.b(Executors.newSingleThreadExecutor());
        this.P = b11;
        this.V = LazyKt__LazyJVMKt.a(m.f36550a);
        this.W = new q(this);
        this.Y = Integer.MAX_VALUE;
        this.f36456b0 = "";
        b1<f> a11 = k1.a(null);
        this.f36459e0 = a11;
        this.f36460f0 = a11;
        b1<g> a12 = k1.a(null);
        this.f36461g0 = a12;
        this.f36462h0 = a12;
        this.f36464j0 = new com.sumsub.sns.internal.core.common.e(Bitmap.Config.ARGB_8888);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), b11, (CoroutineStart) null, new a(this, (kotlin.coroutines.c<? super a>) null), 2, (Object) null);
        n1 unused2 = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new C0493b(this, (kotlin.coroutines.c<? super C0493b>) null), 3, (Object) null);
        this.f36463i0 = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new c(this, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
        this.f36465k0 = LazyKt__LazyJVMKt.a(p.f36556a);
    }

    public final void A() {
        b(false);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
    }

    public final void B() {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new y(this, (kotlin.coroutines.c<? super y>) null), 3, (Object) null);
    }

    public final void C() {
        if (this.L == null) {
            Timer timer = new Timer();
            timer.schedule(new z(this), TimeUnit.SECONDS.toMillis(2));
            this.L = timer;
        }
    }

    public final void D() {
        if (this.K == null) {
            Timer timer = new Timer();
            timer.schedule(new a0(this), TimeUnit.SECONDS.toMillis(2));
            this.K = timer;
        }
    }

    public final void E() {
        float f11;
        float f12;
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Stop calibration", (Throwable) null, 4, (Object) null);
        com.sumsub.sns.prooface.data.a aVar = this.Q;
        if (aVar != null) {
            List<com.sumsub.sns.prooface.data.b> j11 = aVar.j();
            if (j11 != null) {
                Iterator<T> it2 = j11.iterator();
                if (it2.hasNext()) {
                    f11 = ((com.sumsub.sns.prooface.data.b) it2.next()).d();
                    while (it2.hasNext()) {
                        f11 = Math.max(f11, ((com.sumsub.sns.prooface.data.b) it2.next()).d());
                    }
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                f11 = 0.0f;
            }
            List<com.sumsub.sns.prooface.data.b> j12 = aVar.j();
            if (j12 != null) {
                Iterator<T> it3 = j12.iterator();
                if (it3.hasNext()) {
                    f12 = ((com.sumsub.sns.prooface.data.b) it3.next()).d();
                    while (it3.hasNext()) {
                        f12 = Math.min(f12, ((com.sumsub.sns.prooface.data.b) it3.next()).d());
                    }
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                f12 = 0.0f;
            }
            aVar.b((f11 <= 0.0f || (f11 - f12) / f11 <= 0.3f) ? "fail" : BaseHbgResponse.STATUS_OK);
        }
    }

    public final void F() {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "stopSession()", (Throwable) null, 4, (Object) null);
        n1 n1Var = this.S;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.A.stop();
        this.E.b();
        this.f36464j0.a();
    }

    public void onCleared() {
        super.onCleared();
        this.T = null;
    }

    public final void p() {
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
        }
        this.L = null;
        Timer timer2 = this.K;
        if (timer2 != null) {
            timer2.cancel();
        }
        this.K = null;
    }

    /* renamed from: q */
    public i e() {
        return new i((j) null, 1, (kotlin.jvm.internal.r) null);
    }

    public final boolean r() {
        return this.F.i();
    }

    public final h.b s() {
        return (h.b) this.V.getValue();
    }

    public final boolean t() {
        return this.f36458d0;
    }

    public final DocumentType u() {
        return this.B;
    }

    public final j1<g> v() {
        return this.f36462h0;
    }

    public final byte[] w() {
        try {
            return com.sumsub.sns.prooface.network.d.f40274a.a(ByteBuffer.wrap(Base64.decode(this.f36456b0, 2)).getLong(0));
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, message, e11);
            b((Throwable) e11);
            return com.sumsub.sns.prooface.network.d.f40274a.a(System.nanoTime());
        }
    }

    public final j1<f> x() {
        return this.f36460f0;
    }

    public final boolean y() {
        return ((Boolean) this.f36465k0.getValue()).booleanValue();
    }

    public final void z() {
        a(this, (SNSLivenessReason) SNSLivenessReason.UserCancelled.INSTANCE, (String) null, 2, (Object) null);
    }

    public final void c(String str) {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "startSession()", (Throwable) null, 4, (Object) null);
        ImageProxy imageProxy = this.T;
        if (imageProxy != null) {
            imageProxy.close();
        }
        if (y()) {
            a(this, (SNSLivenessReason) new SNSLivenessReason.InitializationError(new IllegalArgumentException("Can't run on emulator")), (String) null, 2, (Object) null);
            return;
        }
        b(true);
        this.N = str;
        this.E.a((Liveness3dFaceRepository.a) this.W);
        this.A.start();
        b("Face Detector used: " + this.A.getName());
        this.f36455a0 = System.currentTimeMillis() + ((long) 100);
    }

    public final void d(boolean z11) {
        this.f36458d0 = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.prooface.presentation.b.t
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.prooface.presentation.b$t r0 = (com.sumsub.sns.internal.prooface.presentation.b.t) r0
            int r1 = r0.f36591d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36591d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.prooface.presentation.b$t r0 = new com.sumsub.sns.internal.prooface.presentation.b$t
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f36589b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36591d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f36588a
            com.sumsub.sns.internal.prooface.presentation.b r0 = (com.sumsub.sns.internal.prooface.presentation.b) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f36588a = r4
            r0.f36591d = r3
            java.lang.Object r5 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            r0.b((boolean) r3)
            com.sumsub.sns.internal.prooface.presentation.b$u r5 = new com.sumsub.sns.internal.prooface.presentation.b$u
            r1 = 0
            r5.<init>(r0, r1)
            r2 = 0
            com.sumsub.sns.core.presentation.base.a.a(r0, r2, r5, r3, r1)
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.d(kotlin.coroutines.c):java.lang.Object");
    }

    public final Object e(kotlin.coroutines.c<? super Map<String, String>> cVar) {
        if (com.sumsub.sns.internal.ff.a.f34215a.d().g()) {
            com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, Fingerprinter.f34263d, "Fingerprint is enabled, collecting...", (Throwable) null, 4, (Object) null);
            kotlin.coroutines.f fVar = new kotlin.coroutines.f(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
            this.I.b((d10.l<? super Map<String, String>, Unit>) new o(fVar));
            Object b11 = fVar.b();
            if (b11 == IntrinsicsKt__IntrinsicsKt.d()) {
                kotlin.coroutines.jvm.internal.f.c(cVar);
            }
            return b11;
        }
        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, Fingerprinter.f34263d, "Fingerprint is disabled", (Throwable) null, 4, (Object) null);
        return null;
    }

    public static final class r extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f36578a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f36579b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f36580c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Handler f36581d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(long j11, long j12, d10.a<Unit> aVar, Handler handler) {
            super(0);
            this.f36578a = j11;
            this.f36579b = j12;
            this.f36580c = aVar;
            this.f36581d = handler;
        }

        public final void a() {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f36578a;
            if (elapsedRealtime >= this.f36579b) {
                this.f36580c.invoke();
            } else {
                this.f36581d.postDelayed(new d(this.f36580c), this.f36579b - elapsedRealtime);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }

        public static final void a(d10.a aVar) {
            aVar.invoke();
        }
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "onHandleError " + oVar, (Throwable) null, 4, (Object) null);
        super.b(oVar);
        a((a.j) new e(oVar));
    }

    public final void b(o.a aVar) {
        if (!(this.f36459e0.getValue() instanceof f.a) || !(aVar instanceof o.a.d)) {
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "onResult " + aVar, (Throwable) null, 4, (Object) null);
        }
        if (aVar instanceof o.a.e) {
            this.f36459e0.setValue(new f.C0494b(h().a("sns_facescan_hint_facePosition")));
        } else if (aVar instanceof o.a.g) {
            this.f36459e0.setValue(new f.d(h().a("sns_facescan_hint_facePosition")));
        } else if (aVar instanceof o.a.f) {
            this.f36459e0.setValue(new f.c(((o.a.f) aVar).b(), h().a("sns_facescan_hint_facePosition")));
        } else if (aVar instanceof o.a.C0374a) {
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "FaceDetectorResult: " + ((o.a.C0374a) aVar).b(), (Throwable) null, 4, (Object) null);
        } else if (aVar instanceof o.a.b) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FaceDetectorResult: fatal error ");
            o.a.b bVar = (o.a.b) aVar;
            sb2.append(bVar.b());
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, sb2.toString(), (Throwable) null, 4, (Object) null);
            if (e0.f32018a.isDebug()) {
                a((a.j) new a.q("Error: " + bVar.b().getMessage()));
            }
        } else if (aVar instanceof o.a.c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FaceDetectorResult: ");
            o.a.c cVar = (o.a.c) aVar;
            sb3.append(cVar.b());
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, sb3.toString(), (Throwable) null, 4, (Object) null);
            if (e0.f32018a.isDebug()) {
                a((a.j) new a.q("Error: " + cVar.b().getMessage()));
            }
        } else if (aVar instanceof o.a.d) {
            o.a.d dVar = (o.a.d) aVar;
            this.f36459e0.setValue(new f.a(dVar.b(), h().a("sns_facescan_hint_lookStraight")));
            a(dVar);
        }
    }

    public final boolean c(Bitmap bitmap) {
        if (this.Y > 0 || this.X == 0 || System.currentTimeMillis() - this.f36455a0 < 0) {
            return false;
        }
        a(bitmap, new Size(bitmap.getWidth(), bitmap.getHeight()), "NOT_ALIGNED");
        this.f36455a0 = System.currentTimeMillis() + ((long) 8000);
        return true;
    }

    public final String a(com.sumsub.sns.prooface.data.j jVar) {
        String c11 = jVar != null ? jVar.c() : null;
        AnswerType answerType = AnswerType.Green;
        if (kotlin.jvm.internal.x.b(c11, answerType.getValue())) {
            return answerType.getValue();
        }
        if (!(jVar != null ? kotlin.jvm.internal.x.b(jVar.a(), Boolean.TRUE) : false) || kotlin.jvm.internal.x.b(jVar.c(), answerType.getValue())) {
            return AnswerType.Red.getValue();
        }
        return AnswerType.Yellow.getValue();
    }

    public final void c(boolean z11) {
        if (!z11) {
            b(false);
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
            return;
        }
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new s(this, (kotlin.coroutines.c<? super s>) null), 3, (Object) null);
    }

    public final void a(Exception exc) {
        a(this, (SNSLivenessReason) new SNSLivenessReason.InitializationError(exc), (String) null, 2, (Object) null);
        b((Throwable) exc);
    }

    public final void a(boolean z11, String str) {
        SNSLivenessReason sNSLivenessReason;
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "finishSession()", (Throwable) null, 4, (Object) null);
        if (kotlin.jvm.internal.x.b(str, AnswerType.Green.getValue())) {
            sNSLivenessReason = SNSLivenessReason.VeritifcationSuccessfully.INSTANCE;
        } else if (!kotlin.jvm.internal.x.b(str, AnswerType.Red.getValue()) || !z11) {
            sNSLivenessReason = SNSLivenessReason.UnknownInternalError.INSTANCE;
        } else {
            sNSLivenessReason = SNSLivenessReason.CompletedUnsuccessfullyAllowContinue.INSTANCE;
        }
        a(sNSLivenessReason, str);
    }

    public static /* synthetic */ void a(b bVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        bVar.c(str);
    }

    public final d10.a<Unit> a(long j11, d10.a<Unit> aVar) {
        return new r(SystemClock.elapsedRealtime(), j11, aVar, new Handler(Looper.getMainLooper()));
    }

    public final void a(ImageProxy imageProxy, RectF rectF, float f11) {
        List<com.sumsub.sns.prooface.data.b> j11;
        try {
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Process image", (Throwable) null, 4, (Object) null);
            d10.a<Unit> a11 = a(s().d(), (d10.a<Unit>) new w(imageProxy));
            if (!this.E.c()) {
                com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Liveness session is not yet connected, skipping frame analyzing", (Throwable) null, 4, (Object) null);
                a11.invoke();
                return;
            }
            this.T = imageProxy;
            Bitmap a12 = com.sumsub.sns.internal.core.common.v.a(imageProxy, new x(this));
            com.sumsub.sns.prooface.data.a aVar = this.Q;
            if (aVar != null && !aVar.l()) {
                if (!this.U) {
                    com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "processImage(), Calibration is not completed", (Throwable) null, 4, (Object) null);
                }
                this.U = true;
                if (this.R) {
                    this.R = false;
                    Pair<Integer, Float> a13 = com.sumsub.sns.prooface.domain.a.f40230a.a(a12);
                    d0 d0Var = d0.f56774a;
                    String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & a13.getFirst().intValue())}, 1));
                    com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Calibrate, color=" + format + ", brightness=" + a13 + ", expositionBias=" + f11, (Throwable) null, 4, (Object) null);
                    com.sumsub.sns.prooface.data.a aVar2 = this.Q;
                    if (!(aVar2 == null || (j11 = aVar2.j()) == null)) {
                        j11.add(new com.sumsub.sns.prooface.data.b(f11, a13.getSecond().floatValue(), format));
                    }
                }
                a12.recycle();
                a11.invoke();
                return;
            }
            this.U = false;
            this.A.a(a12, rectF, new v(this, a11));
        } catch (Throwable th2) {
            b(th2);
            imageProxy.close();
        }
    }

    public final void b(Throwable th2) {
        if (e0.f32018a.isDebug()) {
            a((a.j) new a.q("Error: " + th2.getMessage()));
        }
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "ERROR: " + th2.getMessage(), (Throwable) null, 4, (Object) null);
        Logger a11 = com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA);
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        a11.e(com.sumsub.sns.prooface.a.f40167b, message, th2);
    }

    public final void b(String str) {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "message", (Throwable) null, 4, (Object) null);
        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), com.sumsub.sns.prooface.a.f40167b, str, (Throwable) null, 4, (Object) null);
    }

    public final void b(Bitmap bitmap) {
        try {
            Matrix matrix = new Matrix();
            matrix.setScale(0.2f, 0.2f);
            matrix.postScale(-1.0f, 1.0f);
            this.f36457c0 = com.sumsub.sns.internal.core.common.p.f32247a.a(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), 20, true);
        } catch (Throwable th2) {
            b(th2);
        }
    }

    public final void b(Exception exc) {
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) exc, this.B.c(), (Object) null, 4, (Object) null);
    }

    public final void a(o.a aVar) {
        try {
            if (!c(aVar.a())) {
                b(aVar);
            }
        } catch (Throwable th2) {
            b(th2);
        }
    }

    public final void a(float f11, float f12, float f13) {
        float f14 = f11;
        float f15 = f12;
        float f16 = f13;
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Start calibration, min=" + f12 + ", max=" + f16 + ", current=" + f11, (Throwable) null, 4, (Object) null);
        n1 n1Var = this.S;
        boolean z11 = true;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        if (f15 != f16) {
            z11 = false;
        }
        if (z11) {
            com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "Calibration, exposure min=max", (Throwable) null, 4, (Object) null);
            this.Q = com.sumsub.sns.prooface.data.a.Companion.b();
            n1 unused = kotlinx.coroutines.i.d(m0.a(this), v0.b(), (CoroutineStart) null, new b0(this, f11, (kotlin.coroutines.c<? super b0>) null), 2, (Object) null);
            return;
        }
        this.S = kotlinx.coroutines.i.d(m0.a(this), v0.b(), (CoroutineStart) null, new c0(this, f12, f13, f11, (kotlin.coroutines.c<? super c0>) null), 2, (Object) null);
    }

    public final void a(o.a.d dVar) {
        if (!this.f36458d0) {
            this.Z = System.currentTimeMillis() + ((long) 200);
            return;
        }
        int i11 = this.Y;
        if (i11 == this.X && i11 > 0) {
            C();
        }
        if (this.Y >= this.X) {
            n1 n1Var = this.f36463i0;
            if (n1Var != null) {
                n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            }
        } else if (System.currentTimeMillis() - this.Z >= 0) {
            this.Y++;
            a(dVar.a(), dVar.c(), "OK");
            this.Z = System.currentTimeMillis() + ((long) 200);
            this.f36461g0.setValue(new g.e(((float) this.Y) / ((float) this.X)));
        }
    }

    public final String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + bArr2.length + 4 + 4);
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        allocate.putInt(bArr2.length);
        allocate.put(bArr2);
        return Base64.encodeToString(this.D.a(allocate.array(), bArr3), 2);
    }

    public final void a(Bitmap bitmap, Size size, String str) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new l(this, bitmap, size, str, (kotlin.coroutines.c<? super l>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.graphics.Bitmap r37, android.util.Size r38, java.lang.String r39, kotlin.coroutines.c<? super com.sumsub.sns.prooface.data.h> r40) {
        /*
            r36 = this;
            r0 = r36
            r1 = r40
            boolean r2 = r1 instanceof com.sumsub.sns.internal.prooface.presentation.b.k
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.prooface.presentation.b$k r2 = (com.sumsub.sns.internal.prooface.presentation.b.k) r2
            int r3 = r2.f36544t
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36544t = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.prooface.presentation.b$k r2 = new com.sumsub.sns.internal.prooface.presentation.b$k
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36542r
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36544t
            r7 = 1
            if (r4 == 0) goto L_0x0097
            if (r4 != r7) goto L_0x008f
            long r3 = r2.f36541q
            int r8 = r2.f36540p
            java.lang.Object r9 = r2.f36539o
            com.sumsub.sns.prooface.data.a r9 = (com.sumsub.sns.prooface.data.a) r9
            java.lang.Object r10 = r2.f36538n
            com.sumsub.sns.prooface.data.d r10 = (com.sumsub.sns.prooface.data.d) r10
            java.lang.Object r11 = r2.f36537m
            java.lang.Integer r11 = (java.lang.Integer) r11
            java.lang.Object r12 = r2.f36536l
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r13 = r2.f36535k
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.f36534j
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r2.f36533i
            java.lang.Integer r15 = (java.lang.Integer) r15
            java.lang.Object r7 = r2.f36532h
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Object r6 = r2.f36531g
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r2.f36530f
            java.lang.String r5 = (java.lang.String) r5
            r37 = r3
            java.lang.Object r3 = r2.f36529e
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f36528d
            kotlinx.serialization.k r4 = (kotlinx.serialization.k) r4
            r39 = r3
            java.lang.Object r3 = r2.f36527c
            com.sumsub.sns.internal.core.domain.o$b r3 = (com.sumsub.sns.internal.core.domain.o.b) r3
            r17 = r3
            java.lang.Object r3 = r2.f36526b
            byte[] r3 = (byte[]) r3
            java.lang.Object r2 = r2.f36525a
            com.sumsub.sns.internal.prooface.presentation.b r2 = (com.sumsub.sns.internal.prooface.presentation.b) r2
            kotlin.k.b(r1)
            r19 = r39
            r20 = r5
            r21 = r6
            r22 = r7
            r30 = r9
            r29 = r10
            r28 = r11
            r27 = r12
            r26 = r13
            r24 = r14
            r23 = r15
            r11 = r37
            r13 = r3
            r3 = r17
            goto L_0x016f
        L_0x008f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0097:
            kotlin.k.b(r1)
            byte[] r1 = r36.w()
            r4 = 0
            byte r8 = r1[r4]
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r1)
            long r5 = r5.getLong(r4)
            int r7 = r37.getWidth()
            int r9 = r37.getHeight()
            com.sumsub.sns.internal.core.domain.o$b r10 = r36.a((android.graphics.Bitmap) r37)
            int r11 = r0.Y
            int r12 = r0.X
            if (r11 != r12) goto L_0x00be
            r36.b((android.graphics.Bitmap) r37)
        L_0x00be:
            r37.recycle()
            kotlinx.serialization.json.a r11 = r0.C
            java.lang.String r12 = r0.M
            java.lang.String r13 = r0.N
            java.lang.String r14 = com.sumsub.sns.internal.core.common.i.b()
            int r15 = r38.getWidth()
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.a.c(r15)
            int r16 = r38.getHeight()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.c(r16)
            r16 = r3
            java.lang.String r3 = "user"
            r18 = r5
            java.text.SimpleDateFormat r5 = f36451w
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            java.util.Date r6 = r6.getTime()
            java.lang.String r5 = r5.format(r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.c(r7)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.c(r9)
            com.sumsub.sns.prooface.data.d r9 = new com.sumsub.sns.prooface.data.d
            r20 = r8
            r8 = 2
            r38 = r6
            r37 = r7
            r6 = 0
            r7 = r39
            r9.<init>((java.lang.String) r7, (com.sumsub.sns.prooface.data.c) r6, (int) r8, (kotlin.jvm.internal.r) r6)
            com.sumsub.sns.prooface.data.a r6 = r0.Q
            if (r6 == 0) goto L_0x0111
            boolean r7 = r6.l()
            if (r7 == 0) goto L_0x0111
            goto L_0x0112
        L_0x0111:
            r6 = 0
        L_0x0112:
            r2.f36525a = r0
            r2.f36526b = r1
            r2.f36527c = r10
            r2.f36528d = r11
            r2.f36529e = r12
            r2.f36530f = r13
            r2.f36531g = r14
            r2.f36532h = r15
            r2.f36533i = r4
            r2.f36534j = r3
            r2.f36535k = r5
            r7 = r38
            r2.f36536l = r7
            r8 = r37
            r2.f36537m = r8
            r2.f36538n = r9
            r2.f36539o = r6
            r21 = r1
            r1 = r20
            r2.f36540p = r1
            r38 = r3
            r37 = r4
            r3 = r18
            r2.f36541q = r3
            r1 = 1
            r2.f36544t = r1
            java.lang.Object r1 = r0.e((kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.String>>) r2)
            r2 = r16
            if (r1 != r2) goto L_0x014e
            return r2
        L_0x014e:
            r23 = r37
            r24 = r38
            r2 = r0
            r26 = r5
            r30 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r19 = r12
            r22 = r15
            r8 = r20
            r20 = r13
            r13 = r21
            r21 = r14
            r34 = r3
            r3 = r10
            r4 = r11
            r11 = r34
        L_0x016f:
            r31 = r1
            java.util.Map r31 = (java.util.Map) r31
            com.sumsub.sns.prooface.data.g r1 = new com.sumsub.sns.prooface.data.g
            r25 = 0
            r32 = 64
            r33 = 0
            r18 = r1
            r18.<init>((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (java.lang.Integer) r22, (java.lang.Integer) r23, (java.lang.String) r24, (java.lang.Double) r25, (java.lang.String) r26, (java.lang.Integer) r27, (java.lang.Integer) r28, (com.sumsub.sns.prooface.data.d) r29, (com.sumsub.sns.prooface.data.a) r30, (java.util.Map) r31, (int) r32, (kotlin.jvm.internal.r) r33)
            kotlinx.serialization.modules.d r5 = r4.a()
            java.lang.Class<com.sumsub.sns.prooface.data.g> r6 = com.sumsub.sns.prooface.data.g.class
            kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
            java.lang.String r7 = "kotlinx.serialization.serializer.withModule"
            kotlin.jvm.internal.MagicApiIntrinsics.a(r7)
            kotlinx.serialization.b r5 = kotlinx.serialization.h.d(r5, r6)
            java.lang.String r1 = r4.b(r5, r1)
            java.nio.charset.Charset r4 = kotlin.text.b.f56908b
            byte[] r5 = r1.getBytes(r4)
            com.sumsub.sns.prooface.data.a r1 = r2.Q
            if (r1 == 0) goto L_0x01ab
            boolean r1 = r1.l()
            r4 = 1
            if (r1 != r4) goto L_0x01ab
            r17 = r4
            goto L_0x01ad
        L_0x01ab:
            r17 = 0
        L_0x01ad:
            if (r17 == 0) goto L_0x01b2
            r1 = 0
            r2.Q = r1
        L_0x01b2:
            com.sumsub.sns.prooface.network.d r1 = com.sumsub.sns.prooface.network.d.f40274a
            int r7 = r5.length
            byte r14 = (byte) r8
            r6 = 0
            r4 = r1
            r8 = r14
            r9 = r11
            byte[] r15 = r4.a(r5, r6, r7, r8, r9)
            byte[] r5 = r3.b()
            byte[] r3 = r3.b()
            int r7 = r3.length
            byte[] r1 = r4.a(r5, r6, r7, r8, r9)
            java.lang.String r1 = r2.a((byte[]) r15, (byte[]) r1, (byte[]) r13)
            com.sumsub.sns.prooface.data.h r1 = com.sumsub.sns.prooface.data.i.a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.prooface.presentation.b.a(android.graphics.Bitmap, android.util.Size, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final o.b a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 92, byteArrayOutputStream);
        o.b bVar = new o.b(bitmap.getWidth(), bitmap.getHeight(), byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        return bVar;
    }

    public final void a(com.sumsub.sns.internal.core.data.model.g gVar, Liveness3dFaceRepository.LivenessRepositoryResult.g gVar2) {
        SNSActionResult sNSActionResult;
        boolean z11 = false;
        String str = null;
        try {
            SNSActionResultHandler actionResultHandler = e0.f32018a.getActionResultHandler();
            if (actionResultHandler != null) {
                String B2 = gVar.B();
                String L2 = gVar.L();
                if (L2 == null) {
                    L2 = "";
                }
                com.sumsub.sns.prooface.data.j a11 = gVar2.a();
                String c11 = a11 != null ? a11.c() : null;
                com.sumsub.sns.prooface.data.j a12 = gVar2.a();
                sNSActionResult = actionResultHandler.onActionResult(B2, L2, c11, a12 != null ? kotlin.jvm.internal.x.b(a12.a(), Boolean.TRUE) : false);
            } else {
                sNSActionResult = null;
            }
            if (sNSActionResult == SNSActionResult.Cancel) {
                z11 = true;
            }
        } catch (Exception e11) {
            b((Throwable) e11);
        }
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "handleSessionTerminatedForAction: cancelByHost=" + z11, (Throwable) null, 4, (Object) null);
        if (z11) {
            SNSLivenessReason.CancelledByHostApplication cancelledByHostApplication = SNSLivenessReason.CancelledByHostApplication.INSTANCE;
            com.sumsub.sns.prooface.data.j a13 = gVar2.a();
            if (a13 != null) {
                str = a13.c();
            }
            a((SNSLivenessReason) cancelledByHostApplication, str);
        }
    }

    public static /* synthetic */ void a(b bVar, SNSLivenessReason sNSLivenessReason, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        bVar.a(sNSLivenessReason, str);
    }

    public final void a(SNSLivenessReason sNSLivenessReason, String str) {
        com.sumsub.sns.prooface.a.a(com.sumsub.sns.prooface.a.f40167b, "finishWithReason: " + sNSLivenessReason + ", answer=" + str, (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new n(this, str, sNSLivenessReason, (kotlin.coroutines.c<? super n>) null), 3, (Object) null);
    }
}
