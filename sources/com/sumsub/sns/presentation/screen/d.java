package com.sumsub.sns.presentation.screen;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.model.FlowType;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSTrackEvents;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.SdkEvent;
import com.sumsub.sns.internal.core.common.u0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.ReviewStatusType;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.domain.model.a;
import com.sumsub.sns.internal.domain.g;
import com.sumsub.sns.presentation.screen.b;
import com.sumsub.sns.prooface.SNSProoface;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class d extends com.sumsub.sns.core.presentation.base.a<C0526d> {
    public static final b L = new b((kotlin.jvm.internal.r) null);
    public static final /* synthetic */ kotlin.reflect.l<Object>[] M;
    public static final long N = 7000;
    public static final long O = 5000;
    public static final String P = "SNSAppViewModel";
    public static final long Q = 350;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a A;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a B;
    public n1 C;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a D;
    public Document E;
    public boolean F;
    public final b1<Boolean> G;
    public final b1<Integer> H;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a I;
    public final Set<String> J;
    public final kotlinx.coroutines.flow.d<Boolean> K;

    /* renamed from: q  reason: collision with root package name */
    public final SavedStateHandle f39605q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.domain.g f39606r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.domain.e f39607s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.p f39608t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f39609u;

    /* renamed from: v  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.settings.b f39610v;

    /* renamed from: w  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f39611w;

    /* renamed from: x  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.b f39612x;

    /* renamed from: y  reason: collision with root package name */
    public long f39613y = 5000;

    /* renamed from: z  reason: collision with root package name */
    public n1 f39614z;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements d10.p<Boolean, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39615a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ boolean f39616b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f39617c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$1$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.presentation.screen.d$a$a  reason: collision with other inner class name */
        public static final class C0525a extends SuspendLambda implements d10.p<C0526d, kotlin.coroutines.c<? super C0526d>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f39618a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f39619b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f39620c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0525a(boolean z11, kotlin.coroutines.c<? super C0525a> cVar) {
                super(2, cVar);
                this.f39620c = z11;
            }

            /* renamed from: a */
            public final Object invoke(C0526d dVar, kotlin.coroutines.c<? super C0526d> cVar) {
                return ((C0525a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0525a aVar = new C0525a(this.f39620c, cVar);
                aVar.f39619b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f39618a == 0) {
                    kotlin.k.b(obj);
                    return C0526d.a((C0526d) this.f39619b, false, kotlin.coroutines.jvm.internal.a.a(this.f39620c), false, (CharSequence) null, (CharSequence) null, 29, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f39617c = dVar;
        }

        public final Object a(boolean z11, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(Boolean.valueOf(z11), cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f39617c, cVar);
            aVar.f39616b = ((Boolean) obj).booleanValue();
            return aVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (kotlin.coroutines.c) obj2);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39615a == 0) {
                kotlin.k.b(obj);
                boolean z11 = this.f39616b;
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.b(cVar, d.P, "Show progress = " + z11, (Throwable) null, 4, (Object) null);
                this.f39617c.a(true, new C0525a(z11, (kotlin.coroutines.c<? super C0525a>) null));
                if (z11) {
                    this.f39617c.B();
                } else {
                    this.f39617c.p();
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {836, 837, 861, 879}, m = "resolveApplicantStatus")
    public static final class a0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39621a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39622b;

        /* renamed from: c  reason: collision with root package name */
        public Object f39623c;

        /* renamed from: d  reason: collision with root package name */
        public Object f39624d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39625e;

        /* renamed from: f  reason: collision with root package name */
        public int f39626f;

        /* renamed from: g  reason: collision with root package name */
        public /* synthetic */ Object f39627g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f39628h;

        /* renamed from: i  reason: collision with root package name */
        public int f39629i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(d dVar, kotlin.coroutines.c<? super a0> cVar) {
            super(cVar);
            this.f39628h = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39627g = obj;
            this.f39629i |= Integer.MIN_VALUE;
            return this.f39628h.b(false, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public b() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$resolveApplicantStatusWithLevelChangeWaiting$1", f = "SNSAppViewModel.kt", l = {912}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39630a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f39631b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.g f39632c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.e f39633d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39634e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(d dVar, com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, boolean z11, kotlin.coroutines.c<? super b0> cVar) {
            super(2, cVar);
            this.f39631b = dVar;
            this.f39632c = gVar;
            this.f39633d = eVar;
            this.f39634e = z11;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b0(this.f39631b, this.f39632c, this.f39633d, this.f39634e, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39630a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                long h11 = this.f39631b.f39613y;
                this.f39630a = 1;
                if (DelayKt.b(h11, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "level change did not happen", (Throwable) null, 4, (Object) null);
            this.f39631b.q();
            this.f39631b.a(this.f39632c, this.f39633d, false, this.f39634e);
            return Unit.f56620a;
        }
    }

    public static final class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.domain.model.c f39635a;

        /* renamed from: b  reason: collision with root package name */
        public final Parcelable f39636b;

        public static final class a implements Parcelable.Creator<c> {
            /* renamed from: a */
            public final c createFromParcel(Parcel parcel) {
                return new c(com.sumsub.sns.internal.core.domain.model.c.CREATOR.createFromParcel(parcel), parcel.readParcelable(c.class.getClassLoader()));
            }

            /* renamed from: a */
            public final c[] newArray(int i11) {
                return new c[i11];
            }
        }

        public c(com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable) {
            this.f39635a = cVar;
            this.f39636b = parcelable;
        }

        public final com.sumsub.sns.internal.core.domain.model.c a() {
            return this.f39635a;
        }

        public final Parcelable b() {
            return this.f39636b;
        }

        public final com.sumsub.sns.internal.core.domain.model.c c() {
            return this.f39635a;
        }

        public final Parcelable d() {
            return this.f39636b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.x.b(this.f39635a, cVar.f39635a) && kotlin.jvm.internal.x.b(this.f39636b, cVar.f39636b);
        }

        public int hashCode() {
            return (this.f39635a.hashCode() * 31) + this.f39636b.hashCode();
        }

        public String toString() {
            return "PendingInstructionsData(introParams=" + this.f39635a + ", payload=" + this.f39636b + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f39635a.writeToParcel(parcel, i11);
            parcel.writeParcelable(this.f39636b, i11);
        }

        public final c a(com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable) {
            return new c(cVar, parcelable);
        }

        public static /* synthetic */ c a(c cVar, com.sumsub.sns.internal.core.domain.model.c cVar2, Parcelable parcelable, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                cVar2 = cVar.f39635a;
            }
            if ((i11 & 2) != 0) {
                parcelable = cVar.f39636b;
            }
            return cVar.a(cVar2, parcelable);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$resolveInstructions$1", f = "SNSAppViewModel.kt", l = {545, 546, 563}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f39637a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39638b;

        /* renamed from: c  reason: collision with root package name */
        public Object f39639c;

        /* renamed from: d  reason: collision with root package name */
        public int f39640d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39641e;

        /* renamed from: f  reason: collision with root package name */
        public int f39642f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f39643g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.domain.model.c f39644h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(d dVar, com.sumsub.sns.internal.core.domain.model.c cVar, kotlin.coroutines.c<? super c0> cVar2) {
            super(2, cVar2);
            this.f39643g = dVar;
            this.f39644h = cVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c0(this.f39643g, this.f39644h, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00f8 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0120 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r6 = r21
                java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r6.f39642f
                r8 = 0
                r9 = 3
                r10 = 2
                r11 = 1
                if (r0 == 0) goto L_0x0044
                if (r0 == r11) goto L_0x003e
                if (r0 == r10) goto L_0x0034
                if (r0 != r9) goto L_0x002c
                boolean r0 = r6.f39641e
                int r1 = r6.f39640d
                java.lang.Object r2 = r6.f39639c
                com.sumsub.sns.internal.core.presentation.intro.f r2 = (com.sumsub.sns.internal.core.presentation.intro.f) r2
                java.lang.Object r3 = r6.f39638b
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r6.f39637a
                com.sumsub.sns.internal.core.data.model.e r4 = (com.sumsub.sns.internal.core.data.model.e) r4
                kotlin.k.b(r22)
                r8 = r1
                r1 = r22
                goto L_0x00f9
            L_0x002c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0034:
                java.lang.Object r0 = r6.f39637a
                com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
                kotlin.k.b(r22)
                r1 = r22
                goto L_0x0070
            L_0x003e:
                kotlin.k.b(r22)
                r0 = r22
                goto L_0x005c
            L_0x0044:
                kotlin.k.b(r22)
                com.sumsub.sns.presentation.screen.d r0 = r6.f39643g
                com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.f39611w
                r6.f39642f = r11
                r1 = 0
                r2 = 0
                r4 = 3
                r5 = 0
                r3 = r21
                java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r0, r1, r2, r3, r4, r5)
                if (r0 != r7) goto L_0x005c
                return r7
            L_0x005c:
                com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
                com.sumsub.sns.presentation.screen.d r1 = r6.f39643g
                com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.f39611w
                r6.f39637a = r0
                r6.f39642f = r10
                r2 = 0
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r1, r8, r6, r11, r2)
                if (r1 != r7) goto L_0x0070
                return r7
            L_0x0070:
                r4 = r1
                com.sumsub.sns.internal.core.data.model.e r4 = (com.sumsub.sns.internal.core.data.model.e) r4
                com.sumsub.sns.presentation.screen.d r1 = r6.f39643g
                com.sumsub.sns.internal.core.data.source.common.a r1 = r1.f39609u
                java.lang.String r1 = r1.a()
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r0.u()
            L_0x0083:
                r3 = r1
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r1 = r1.g()
                java.lang.String r2 = "VIDEO_IDENT"
                boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
                if (r1 != 0) goto L_0x00a8
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r1 = r1.g()
                com.sumsub.sns.internal.core.domain.model.c r5 = r6.f39644h
                java.lang.String r5 = r5.f()
                boolean r5 = com.sumsub.sns.internal.core.presentation.intro.a.a(r5)
                boolean r1 = com.sumsub.sns.internal.core.data.model.f.a(r4, r1, r5)
                if (r1 != 0) goto L_0x00ba
            L_0x00a8:
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r1 = r1.g()
                boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
                if (r1 == 0) goto L_0x00bb
                boolean r0 = r0.P()
                if (r0 == 0) goto L_0x00bb
            L_0x00ba:
                r8 = r11
            L_0x00bb:
                com.sumsub.sns.internal.core.presentation.intro.f r2 = new com.sumsub.sns.internal.core.presentation.intro.f
                com.sumsub.sns.internal.core.domain.model.c r0 = r6.f39644h
                java.lang.String r0 = r0.g()
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r1 = r1.f()
                com.sumsub.sns.internal.core.domain.model.c r5 = r6.f39644h
                java.lang.String r5 = r5.e()
                r2.<init>(r0, r1, r5)
                com.sumsub.sns.presentation.screen.d r0 = r6.f39643g
                java.util.Set r0 = r0.J
                com.sumsub.sns.presentation.screen.d r1 = r6.f39643g
                com.sumsub.sns.internal.core.domain.model.c r5 = r6.f39644h
                java.lang.String r1 = r1.a((com.sumsub.sns.internal.core.domain.model.c) r5)
                boolean r0 = r0.contains(r1)
                com.sumsub.sns.presentation.screen.d r1 = r6.f39643g
                r6.f39637a = r4
                r6.f39638b = r3
                r6.f39639c = r2
                r6.f39640d = r8
                r6.f39641e = r0
                r6.f39642f = r9
                java.lang.Object r1 = r1.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r6)
                if (r1 != r7) goto L_0x00f9
                return r7
            L_0x00f9:
                r13 = r1
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r13 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r13
                java.util.Map r14 = r4.C()
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r15 = r1.g()
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r16 = r1.e()
                com.sumsub.sns.internal.core.domain.model.c r1 = r6.f39644h
                java.lang.String r17 = r1.f()
                com.sumsub.sns.internal.core.presentation.intro.b r1 = new com.sumsub.sns.internal.core.presentation.intro.b
                r18 = 0
                r19 = 32
                r20 = 0
                r12 = r1
                r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
                if (r8 == 0) goto L_0x0147
                if (r0 != 0) goto L_0x0147
                boolean r0 = r1.f()
                if (r0 == 0) goto L_0x0147
                com.sumsub.sns.core.c r12 = com.sumsub.sns.core.c.f30748a
                r15 = 0
                r16 = 4
                r17 = 0
                java.lang.String r13 = "SNSAppViewModel"
                java.lang.String r14 = "resolveInstructions: fire instructions event"
                com.sumsub.sns.core.c.b(r12, r13, r14, r15, r16, r17)
                com.sumsub.sns.presentation.screen.d r0 = r6.f39643g
                com.sumsub.sns.presentation.screen.b$e r1 = new com.sumsub.sns.presentation.screen.b$e
                com.sumsub.sns.internal.core.domain.model.c r4 = r6.f39644h
                boolean r4 = r4.h()
                r1.<init>(r2, r4, r3)
                r0.a((com.sumsub.sns.core.presentation.base.a.j) r1)
                goto L_0x015a
            L_0x0147:
                com.sumsub.sns.core.c r12 = com.sumsub.sns.core.c.f30748a
                r15 = 0
                r16 = 4
                r17 = 0
                java.lang.String r13 = "SNSAppViewModel"
                java.lang.String r14 = "resolveInstructions: execute after instructions"
                com.sumsub.sns.core.c.b(r12, r13, r14, r15, r16, r17)
                com.sumsub.sns.presentation.screen.d r0 = r6.f39643g
                r0.c((boolean) r11)
            L_0x015a:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.c0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: com.sumsub.sns.presentation.screen.d$d  reason: collision with other inner class name */
    public static final class C0526d implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f39645a;

        /* renamed from: b  reason: collision with root package name */
        public final Boolean f39646b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f39647c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f39648d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f39649e;

        public C0526d() {
            this(false, (Boolean) null, false, (CharSequence) null, (CharSequence) null, 31, (kotlin.jvm.internal.r) null);
        }

        public final boolean a() {
            return this.f39645a;
        }

        public final Boolean b() {
            return this.f39646b;
        }

        public final boolean c() {
            return this.f39647c;
        }

        public final CharSequence d() {
            return this.f39648d;
        }

        public final CharSequence e() {
            return this.f39649e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0526d)) {
                return false;
            }
            C0526d dVar = (C0526d) obj;
            return this.f39645a == dVar.f39645a && kotlin.jvm.internal.x.b(this.f39646b, dVar.f39646b) && this.f39647c == dVar.f39647c && kotlin.jvm.internal.x.b(this.f39648d, dVar.f39648d) && kotlin.jvm.internal.x.b(this.f39649e, dVar.f39649e);
        }

        public final boolean f() {
            return this.f39647c;
        }

        public final CharSequence g() {
            return this.f39649e;
        }

        public final CharSequence h() {
            return this.f39648d;
        }

        public int hashCode() {
            boolean z11 = this.f39645a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            Boolean bool = this.f39646b;
            int i12 = 0;
            int hashCode = (i11 + (bool == null ? 0 : bool.hashCode())) * 31;
            boolean z13 = this.f39647c;
            if (!z13) {
                z12 = z13;
            }
            int i13 = (hashCode + (z12 ? 1 : 0)) * 31;
            CharSequence charSequence = this.f39648d;
            int hashCode2 = (i13 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f39649e;
            if (charSequence2 != null) {
                i12 = charSequence2.hashCode();
            }
            return hashCode2 + i12;
        }

        public final Boolean i() {
            return this.f39646b;
        }

        public final boolean j() {
            return this.f39645a;
        }

        public String toString() {
            return "ViewState(isSdkPrepared=" + this.f39645a + ", isLoading=" + this.f39646b + ", loadingIsTooLong=" + this.f39647c + ", preparedText=" + this.f39648d + ", loadingTooLongText=" + this.f39649e + ')';
        }

        public C0526d(boolean z11, Boolean bool, boolean z12, CharSequence charSequence, CharSequence charSequence2) {
            this.f39645a = z11;
            this.f39646b = bool;
            this.f39647c = z12;
            this.f39648d = charSequence;
            this.f39649e = charSequence2;
        }

        public final C0526d a(boolean z11, Boolean bool, boolean z12, CharSequence charSequence, CharSequence charSequence2) {
            return new C0526d(z11, bool, z12, charSequence, charSequence2);
        }

        public static /* synthetic */ C0526d a(C0526d dVar, boolean z11, Boolean bool, boolean z12, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = dVar.f39645a;
            }
            if ((i11 & 2) != 0) {
                bool = dVar.f39646b;
            }
            Boolean bool2 = bool;
            if ((i11 & 4) != 0) {
                z12 = dVar.f39647c;
            }
            boolean z13 = z12;
            if ((i11 & 8) != 0) {
                charSequence = dVar.f39648d;
            }
            CharSequence charSequence3 = charSequence;
            if ((i11 & 16) != 0) {
                charSequence2 = dVar.f39649e;
            }
            return dVar.a(z11, bool2, z13, charSequence3, charSequence2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ C0526d(boolean r5, java.lang.Boolean r6, boolean r7, java.lang.CharSequence r8, java.lang.CharSequence r9, int r10, kotlin.jvm.internal.r r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                r1 = 0
                if (r5 == 0) goto L_0x000f
                r2 = r1
                goto L_0x0010
            L_0x000f:
                r2 = r6
            L_0x0010:
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                goto L_0x0016
            L_0x0015:
                r0 = r7
            L_0x0016:
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r1
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r1
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r2
                r8 = r0
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.C0526d.<init>(boolean, java.lang.Boolean, boolean, java.lang.CharSequence, java.lang.CharSequence, int, kotlin.jvm.internal.r):void");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$scheduleSlowConnectionTimer$1", f = "SNSAppViewModel.kt", l = {169}, m = "invokeSuspend")
    public static final class d0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39650a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39651b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f39652c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$scheduleSlowConnectionTimer$1$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<C0526d, kotlin.coroutines.c<? super C0526d>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f39653a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f39654b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(C0526d dVar, kotlin.coroutines.c<? super C0526d> cVar) {
                return ((a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f39654b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f39653a == 0) {
                    kotlin.k.b(obj);
                    return C0526d.a((C0526d) this.f39654b, false, (Boolean) null, true, (CharSequence) null, (CharSequence) null, 27, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(d dVar, kotlin.coroutines.c<? super d0> cVar) {
            super(2, cVar);
            this.f39652c = dVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d0 d0Var = new d0(this.f39652c, cVar);
            d0Var.f39651b = obj;
            return d0Var;
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.h0 h0Var;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39650a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.h0 h0Var2 = (kotlinx.coroutines.h0) this.f39651b;
                this.f39651b = h0Var2;
                this.f39650a = 1;
                if (DelayKt.b(d.N, this) == d11) {
                    return d11;
                }
                h0Var = h0Var2;
            } else if (i11 == 1) {
                h0Var = (kotlinx.coroutines.h0) this.f39651b;
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (i0.i(h0Var)) {
                com.sumsub.sns.core.presentation.base.a.a(this.f39652c, false, new a((kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            }
            return Unit.f56620a;
        }
    }

    public /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39655a;

        static {
            int[] iArr = new int[FlowType.values().length];
            iArr[FlowType.Module.ordinal()] = 1;
            f39655a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$setDefaultSDKState$$inlined$launchOnViewModelScope$1", f = "SNSAppViewModel.kt", l = {448}, m = "invokeSuspend")
    public static final class e0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39656a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39657b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.base.a f39658c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f39659d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f39660e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(com.sumsub.sns.core.presentation.base.a aVar, String str, kotlin.coroutines.c cVar, d dVar) {
            super(2, cVar);
            this.f39658c = aVar;
            this.f39659d = str;
            this.f39660e = dVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e0 e0Var = new e0(this.f39658c, this.f39659d, cVar, this.f39660e);
            e0Var.f39657b = obj;
            return e0Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
            r1 = r7.g();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
            com.sumsub.sns.core.presentation.base.a.a(r6.f39658c, (java.lang.Throwable) r7, r6.f39659d, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x0010, B:9:0x0023] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007a A[ExcHandler: Exception (r7v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:4:0x0010] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r6.f39656a
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                java.lang.Object r0 = r6.f39657b
                kotlinx.coroutines.h0 r0 = (kotlinx.coroutines.h0) r0
                kotlin.k.b(r7)     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                goto L_0x003f
            L_0x0014:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001c:
                kotlin.k.b(r7)
                java.lang.Object r7 = r6.f39657b
                kotlinx.coroutines.h0 r7 = (kotlinx.coroutines.h0) r7
                com.sumsub.sns.presentation.screen.d r1 = r6.f39660e     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.f39611w     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                kotlinx.coroutines.flow.j1 r1 = r1.b()     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                com.sumsub.sns.presentation.screen.d$f0 r4 = new com.sumsub.sns.presentation.screen.d$f0     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                r4.<init>(r3)     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                r6.f39657b = r7     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                r6.f39656a = r2     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                java.lang.Object r1 = kotlinx.coroutines.flow.f.z(r1, r4, r6)     // Catch:{ CancellationException -> 0x0087, Exception -> 0x007a }
                if (r1 != r0) goto L_0x003d
                return r0
            L_0x003d:
                r0 = r7
                r7 = r1
            L_0x003f:
                com.sumsub.sns.internal.core.data.source.dynamic.b$a r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r7     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                if (r7 == 0) goto L_0x0050
                com.sumsub.sns.internal.core.data.source.dynamic.e r1 = r7.g()     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                if (r1 == 0) goto L_0x0050
                java.lang.Object r1 = r1.d()     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                goto L_0x0051
            L_0x0050:
                r1 = r3
            L_0x0051:
                if (r7 == 0) goto L_0x0060
                com.sumsub.sns.internal.core.data.source.dynamic.e r7 = r7.j()     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                if (r7 == 0) goto L_0x0060
                java.lang.Object r7 = r7.d()     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                r3 = r7
                com.sumsub.sns.internal.core.data.model.t r3 = (com.sumsub.sns.internal.core.data.model.t) r3     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
            L_0x0060:
                if (r1 == 0) goto L_0x0095
                if (r3 == 0) goto L_0x0095
                java.util.List r7 = r3.d()     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                com.sumsub.sns.core.data.model.SNSSDKState r7 = com.sumsub.sns.internal.core.data.model.k.a(r1, r7)     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                if (r7 == 0) goto L_0x0095
                com.sumsub.sns.presentation.screen.d r1 = r6.f39660e     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                com.sumsub.sns.internal.core.data.source.common.a r1 = r1.f39609u     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                r1.a((com.sumsub.sns.core.data.model.SNSSDKState) r7)     // Catch:{ CancellationException -> 0x0078, Exception -> 0x007a }
                goto L_0x0095
            L_0x0078:
                r7 = r0
                goto L_0x0087
            L_0x007a:
                r7 = move-exception
                r1 = r7
                com.sumsub.sns.core.presentation.base.a r0 = r6.f39658c
                java.lang.String r2 = r6.f39659d
                r3 = 0
                r4 = 4
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.Object) r3, (int) r4, (java.lang.Object) r5)
                goto L_0x0095
            L_0x0087:
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r7)
                r3 = 0
                r4 = 4
                r5 = 0
                java.lang.String r2 = "CancellationException happened"
                com.sumsub.log.logger.a.a(r0, r1, r2, r3, r4, r5)
            L_0x0095:
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.e0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$cancelSlowConnectionJob$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements d10.p<C0526d, kotlin.coroutines.c<? super C0526d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39661a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39662b;

        public f(kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(C0526d dVar, kotlin.coroutines.c<? super C0526d> cVar) {
            return ((f) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            f fVar = new f(cVar);
            fVar.f39662b = obj;
            return fVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39661a == 0) {
                kotlin.k.b(obj);
                return C0526d.a((C0526d) this.f39662b, false, (Boolean) null, false, (CharSequence) null, (CharSequence) null, 27, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$setDefaultSDKState$1$data$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class f0 extends SuspendLambda implements d10.p<b.a, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39663a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39664b;

        public f0(kotlin.coroutines.c<? super f0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((f0) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            f0 f0Var = new f0(cVar);
            f0Var.f39664b = obj;
            return f0Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            r0 = r2.g();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r1.f39663a
                if (r0 != 0) goto L_0x0032
                kotlin.k.b(r2)
                java.lang.Object r2 = r1.f39664b
                com.sumsub.sns.internal.core.data.source.dynamic.b$a r2 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r2
                if (r2 == 0) goto L_0x001d
                com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r2.g()
                if (r0 == 0) goto L_0x001d
                java.lang.Object r0 = r0.d()
                com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
                goto L_0x001e
            L_0x001d:
                r0 = 0
            L_0x001e:
                if (r0 == 0) goto L_0x002c
                com.sumsub.sns.internal.core.data.source.dynamic.e r2 = r2.j()
                java.lang.Object r2 = r2.d()
                if (r2 == 0) goto L_0x002c
                r2 = 1
                goto L_0x002d
            L_0x002c:
                r2 = 0
            L_0x002d:
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r2)
                return r2
            L_0x0032:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.f0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {669, 675, 698}, m = "checkAgreementForAction")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39665a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39666b;

        /* renamed from: c  reason: collision with root package name */
        public Object f39667c;

        /* renamed from: d  reason: collision with root package name */
        public Object f39668d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f39669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f39670f;

        /* renamed from: g  reason: collision with root package name */
        public int f39671g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d dVar, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f39670f = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39669e = obj;
            this.f39671g |= Integer.MIN_VALUE;
            return this.f39670f.a((com.sumsub.sns.internal.core.data.model.g) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$setNetworkState$$inlined$launchOnViewModelScope$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class g0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39672a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39673b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.base.a f39674c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f39675d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f39676e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f39677f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g0(com.sumsub.sns.core.presentation.base.a aVar, String str, kotlin.coroutines.c cVar, d dVar, String str2) {
            super(2, cVar);
            this.f39674c = aVar;
            this.f39675d = str;
            this.f39676e = dVar;
            this.f39677f = str2;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            g0 g0Var = new g0(this.f39674c, this.f39675d, cVar, this.f39676e, this.f39677f);
            g0Var.f39673b = obj;
            return g0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39672a == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.h0 h0Var = (kotlinx.coroutines.h0) this.f39673b;
                try {
                    this.f39676e.f39610v.b(this.f39677f);
                } catch (CancellationException unused2) {
                    com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(h0Var), "CancellationException happened", (Throwable) null, 4, (Object) null);
                } catch (Exception e11) {
                    com.sumsub.sns.core.presentation.base.a.a(this.f39674c, (Throwable) e11, this.f39675d, (Object) null, 4, (Object) null);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$delayedFinish$$inlined$launchOnViewModelScope$1", f = "SNSAppViewModel.kt", l = {449, 450}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39678a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39679b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.base.a f39680c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f39681d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f39682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.common.q f39683f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f39684g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(com.sumsub.sns.core.presentation.base.a aVar, String str, kotlin.coroutines.c cVar, long j11, com.sumsub.sns.internal.core.common.q qVar, d dVar) {
            super(2, cVar);
            this.f39680c = aVar;
            this.f39681d = str;
            this.f39682e = j11;
            this.f39683f = qVar;
            this.f39684g = dVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            h hVar = new h(this.f39680c, this.f39681d, cVar, this.f39682e, this.f39683f, this.f39684g);
            hVar.f39679b = obj;
            return hVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            r0 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
            com.sumsub.sns.core.presentation.base.a.a(r10.f39680c, (java.lang.Throwable) r11, r10.f39681d, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
            r0 = r11;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0012, B:10:0x0022] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0012, B:16:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0084 A[ExcHandler: Exception (r11v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:5:0x0012] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r10.f39678a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0029
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                java.lang.Object r0 = r10.f39679b
                kotlinx.coroutines.h0 r0 = (kotlinx.coroutines.h0) r0
                kotlin.k.b(r11)     // Catch:{ CancellationException -> 0x0092, Exception -> 0x0084 }
                goto L_0x0078
            L_0x0016:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001e:
                java.lang.Object r1 = r10.f39679b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r11)     // Catch:{ CancellationException -> 0x0027, Exception -> 0x0084 }
                r11 = r1
                goto L_0x006a
            L_0x0027:
                r0 = r1
                goto L_0x0092
            L_0x0029:
                kotlin.k.b(r11)
                java.lang.Object r11 = r10.f39679b
                kotlinx.coroutines.h0 r11 = (kotlinx.coroutines.h0) r11
                com.sumsub.sns.core.c r4 = com.sumsub.sns.core.c.f30748a     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                java.lang.String r5 = "SNSAppViewModel"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r1.<init>()     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                java.lang.String r6 = "Delayed finish for "
                r1.append(r6)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                long r6 = r10.f39682e     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r1.append(r6)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                java.lang.String r6 = " ms requested with reason "
                r1.append(r6)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                com.sumsub.sns.internal.core.common.q r6 = r10.f39683f     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r1.append(r6)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                java.lang.String r6 = r1.toString()     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r7 = 0
                r8 = 4
                r9 = 0
                com.sumsub.sns.core.c.b(r4, r5, r6, r7, r8, r9)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                com.sumsub.sns.presentation.screen.d r1 = r10.f39684g     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                kotlinx.coroutines.n1 r1 = r1.f39614z     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                if (r1 == 0) goto L_0x006a
                r10.f39679b = r11     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r10.f39678a = r3     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                java.lang.Object r1 = r1.F(r10)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                if (r1 != r0) goto L_0x006a
                return r0
            L_0x006a:
                long r3 = r10.f39682e     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r10.f39679b = r11     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                r10.f39678a = r2     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r3, r10)     // Catch:{ CancellationException -> 0x0091, Exception -> 0x0084 }
                if (r1 != r0) goto L_0x0077
                return r0
            L_0x0077:
                r0 = r11
            L_0x0078:
                com.sumsub.sns.presentation.screen.d r1 = r10.f39684g     // Catch:{ CancellationException -> 0x0092, Exception -> 0x0084 }
                com.sumsub.sns.internal.core.common.q r2 = r10.f39683f     // Catch:{ CancellationException -> 0x0092, Exception -> 0x0084 }
                r3 = 0
                r4 = 0
                r5 = 6
                r6 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r1, (com.sumsub.sns.internal.core.common.q) r2, (java.lang.Object) r3, (java.lang.Long) r4, (int) r5, (java.lang.Object) r6)     // Catch:{ CancellationException -> 0x0092, Exception -> 0x0084 }
                goto L_0x00a0
            L_0x0084:
                r11 = move-exception
                r1 = r11
                com.sumsub.sns.core.presentation.base.a r0 = r10.f39680c
                java.lang.String r2 = r10.f39681d
                r3 = 0
                r4 = 4
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.Object) r3, (int) r4, (java.lang.Object) r5)
                goto L_0x00a0
            L_0x0091:
                r0 = r11
            L_0x0092:
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r0)
                r4 = 0
                r5 = 4
                r6 = 0
                java.lang.String r3 = "CancellationException happened"
                com.sumsub.log.logger.a.a(r1, r2, r3, r4, r5, r6)
            L_0x00a0:
                kotlin.Unit r11 = kotlin.Unit.f56620a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class h0 implements kotlinx.coroutines.flow.d<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d f39685a;

        public static final class a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.e f39686a;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$special$$inlined$map$1$2", f = "SNSAppViewModel.kt", l = {224}, m = "emit")
            /* renamed from: com.sumsub.sns.presentation.screen.d$h0$a$a  reason: collision with other inner class name */
            public static final class C0527a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f39687a;

                /* renamed from: b  reason: collision with root package name */
                public int f39688b;

                /* renamed from: c  reason: collision with root package name */
                public Object f39689c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f39690d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0527a(a aVar, kotlin.coroutines.c cVar) {
                    super(cVar);
                    this.f39690d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f39687a = obj;
                    this.f39688b |= Integer.MIN_VALUE;
                    return this.f39690d.emit((Object) null, this);
                }
            }

            public a(kotlinx.coroutines.flow.e eVar) {
                this.f39686a = eVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.sumsub.sns.presentation.screen.d.h0.a.C0527a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.sumsub.sns.presentation.screen.d$h0$a$a r0 = (com.sumsub.sns.presentation.screen.d.h0.a.C0527a) r0
                    int r1 = r0.f39688b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f39688b = r1
                    goto L_0x0018
                L_0x0013:
                    com.sumsub.sns.presentation.screen.d$h0$a$a r0 = new com.sumsub.sns.presentation.screen.d$h0$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f39687a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f39688b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r6)
                    goto L_0x0045
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.k.b(r6)
                    kotlinx.coroutines.flow.e r6 = r4.f39686a
                    kotlin.Pair r5 = (kotlin.Pair) r5
                    java.lang.Object r5 = r5.getFirst()
                    r0.f39688b = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x0045
                    return r1
                L_0x0045:
                    kotlin.Unit r5 = kotlin.Unit.f56620a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.h0.a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public h0(kotlinx.coroutines.flow.d dVar) {
            this.f39685a = dVar;
        }

        public Object collect(kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
            Object collect = this.f39685a.collect(new a(eVar), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {640, 647}, m = "handleAction")
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39691a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39692b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f39693c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f39694d;

        /* renamed from: e  reason: collision with root package name */
        public int f39695e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d dVar, kotlin.coroutines.c<? super i> cVar) {
            super(cVar);
            this.f39694d = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39693c = obj;
            this.f39695e |= Integer.MIN_VALUE;
            return this.f39694d.a((com.sumsub.sns.internal.core.data.model.g) null, (com.sumsub.sns.internal.core.data.model.e) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {613, 620, 618}, m = "handleFlowType")
    public static final class j extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39696a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39697b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f39698c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f39699d;

        /* renamed from: e  reason: collision with root package name */
        public int f39700e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d dVar, kotlin.coroutines.c<? super j> cVar) {
            super(cVar);
            this.f39699d = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39698c = obj;
            this.f39700e |= Integer.MIN_VALUE;
            return this.f39699d.a((com.sumsub.sns.internal.core.data.model.g) null, (FlowType) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$launchWithProgress$1", f = "SNSAppViewModel.kt", l = {1038}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39701a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39702b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> f39703c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f39704d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(d10.p<? super kotlinx.coroutines.h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, d dVar, kotlin.coroutines.c<? super k> cVar) {
            super(2, cVar);
            this.f39703c = pVar;
            this.f39704d = dVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            k kVar = new k(this.f39703c, this.f39704d, cVar);
            kVar.f39702b = obj;
            return kVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39701a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.h0 h0Var = (kotlinx.coroutines.h0) this.f39702b;
                d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> pVar = this.f39703c;
                this.f39701a = 1;
                if (pVar.invoke(h0Var, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                try {
                    kotlin.k.b(obj);
                } catch (CancellationException unused) {
                    com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "CancellationException happened", (Throwable) null, 4, (Object) null);
                } catch (Exception e11) {
                    com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this.f39704d, (Throwable) e11, DocumentType.f32355j, (Object) null, 4, (Object) null);
                } catch (Throwable th2) {
                    this.f39704d.f(false);
                    throw th2;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f39704d.f(false);
            return Unit.f56620a;
            this.f39704d.f(false);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$moveToNextDocument$1", f = "SNSAppViewModel.kt", l = {280, 287, 296, 308, 315, 321}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f39705a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39706b;

        /* renamed from: c  reason: collision with root package name */
        public int f39707c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f39708d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39709e;

        public static final class a extends Lambda implements d10.l<Document, CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f39710a = new a();

            public a() {
                super(1);
            }

            /* renamed from: a */
            public final CharSequence invoke(Document document) {
                return document.getType().c();
            }
        }

        public /* synthetic */ class b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f39711a;

            static {
                int[] iArr = new int[FlowType.values().length];
                iArr[FlowType.Module.ordinal()] = 1;
                iArr[FlowType.Actions.ordinal()] = 2;
                f39711a = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(d dVar, boolean z11, kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
            this.f39708d = dVar;
            this.f39709e = z11;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l(this.f39708d, this.f39709e, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x007d, code lost:
            if (kotlin.Result.m3079isSuccessimpl(r2) == false) goto L_0x01a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0083, code lost:
            if (kotlin.Result.m3078isFailureimpl(r2) == false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0085, code lost:
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0087, code lost:
            r6 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
            r6 = (com.sumsub.sns.internal.domain.e.a) r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008a, code lost:
            if (r6 == null) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008c, code lost:
            r6 = r6.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0096, code lost:
            if (kotlin.Result.m3078isFailureimpl(r2) == false) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0099, code lost:
            r2 = (com.sumsub.sns.internal.domain.e.a) r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
            if (r2 == null) goto L_0x00a2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
            r2 = r2.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
            r7 = com.sumsub.sns.presentation.screen.d.e(r0.f39708d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
            if (r7 != null) goto L_0x00c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
            r7 = com.sumsub.sns.presentation.screen.d.f(r0.f39708d);
            r0.f39705a = r6;
            r0.f39706b = r2;
            r0.f39707c = 2;
            r7 = r7.b(true, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.e>>) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
            if (r7 != r1) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00be, code lost:
            r7 = (com.sumsub.sns.internal.core.data.model.e) ((com.sumsub.sns.internal.core.data.source.dynamic.e) r7).e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c6, code lost:
            r15 = r6;
            r16 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
            if (r2 == null) goto L_0x015d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cc, code lost:
            if (r15 != null) goto L_0x00d0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d0, code lost:
            r17 = com.sumsub.sns.core.c.f30748a;
            r13 = new java.lang.StringBuilder();
            r13.append("moveToNextDocument, flowType=");
            r13.append(r16.y());
            r13.append(", documents: ");
            r5 = r13;
            r5.append(kotlin.collections.CollectionsKt___CollectionsKt.k0(r15, (java.lang.CharSequence) null, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, com.sumsub.sns.presentation.screen.d.l.a.f39710a, 31, (java.lang.Object) null));
            com.sumsub.sns.core.c.b(r17, com.sumsub.sns.presentation.screen.d.P, r5.toString(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
            r5 = com.sumsub.sns.presentation.screen.d.l.b.f39711a[r16.y().ordinal()];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0118, code lost:
            if (r5 == 1) goto L_0x014a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x011a, code lost:
            if (r5 == 2) goto L_0x0139;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x011c, code lost:
            r3 = r0.f39708d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0120, code lost:
            if (r0.f39709e != false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0126, code lost:
            if (r2.P() == false) goto L_0x0129;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0129, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x012a, code lost:
            r0.f39705a = null;
            r0.f39706b = null;
            r0.f39707c = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0136, code lost:
            if (com.sumsub.sns.presentation.screen.d.a(r3, r2, (java.util.List) r15, r4, (kotlin.coroutines.c) r0) != r1) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0138, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0139, code lost:
            r3 = r0.f39708d;
            r0.f39705a = null;
            r0.f39706b = null;
            r0.f39707c = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0147, code lost:
            if (com.sumsub.sns.presentation.screen.d.a(r3, r2, (java.util.List) r15, (kotlin.coroutines.c) r0) != r1) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0149, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x014a, code lost:
            r3 = r0.f39708d;
            r4 = r0.f39709e;
            r0.f39705a = null;
            r0.f39706b = null;
            r0.f39707c = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x015a, code lost:
            if (com.sumsub.sns.presentation.screen.d.b(r3, r2, r15, r4, r0) != r1) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x015c, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x015d, code lost:
            r3 = com.sumsub.sns.core.c.f30748a;
            r5 = new java.lang.StringBuilder();
            r5.append("moveToNextDocument; applicant==null ? ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0169, code lost:
            if (r2 != null) goto L_0x016d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x016b, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x016d, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x016e, code lost:
            r5.append(r14);
            r5.append("; documents==null ? ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0176, code lost:
            if (r15 != null) goto L_0x0179;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0179, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x017a, code lost:
            r5.append(r4);
            r5.append("; ");
            com.sumsub.sns.core.c.b(r3, com.sumsub.sns.presentation.screen.d.P, r5.toString(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
            r2 = r0.f39708d;
            r0.f39705a = null;
            r0.f39706b = null;
            r0.f39707c = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x019d, code lost:
            if (com.sumsub.sns.presentation.screen.d.a(r2, false, (kotlin.coroutines.c) r0) != r1) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x019f, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a2, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a3, code lost:
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0.f39708d, (java.lang.Throwable) (java.lang.Exception) kotlin.Result.m3075exceptionOrNullimpl(r2), com.sumsub.sns.internal.core.data.model.DocumentType.f32355j, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b7, code lost:
            return kotlin.Unit.f56620a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r0 = r20
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f39707c
                r3 = 2
                r4 = 1
                switch(r2) {
                    case 0: goto L_0x003a;
                    case 1: goto L_0x002e;
                    case 2: goto L_0x001f;
                    case 3: goto L_0x001a;
                    case 4: goto L_0x0015;
                    case 5: goto L_0x0015;
                    case 6: goto L_0x0015;
                    default: goto L_0x000d;
                }
            L_0x000d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0015:
                kotlin.k.b(r21)
                goto L_0x01b5
            L_0x001a:
                kotlin.k.b(r21)
                goto L_0x01a0
            L_0x001f:
                java.lang.Object r2 = r0.f39706b
                com.sumsub.sns.internal.core.data.model.g r2 = (com.sumsub.sns.internal.core.data.model.g) r2
                java.lang.Object r6 = r0.f39705a
                java.util.List r6 = (java.util.List) r6
                kotlin.k.b(r21)
                r7 = r21
                goto L_0x00be
            L_0x002e:
                kotlin.k.b(r21)
                r2 = r21
                kotlin.Result r2 = (kotlin.Result) r2
                java.lang.Object r2 = r2.m3081unboximpl()
                goto L_0x0079
            L_0x003a:
                kotlin.k.b(r21)
                com.sumsub.sns.core.c r6 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = "Move to next document..., reload documents = "
                r2.append(r7)
                com.sumsub.sns.presentation.screen.d r7 = r0.f39708d
                boolean r7 = r7.x()
                r2.append(r7)
                java.lang.String r8 = r2.toString()
                r9 = 0
                r10 = 4
                r11 = 0
                java.lang.String r7 = "SNSAppViewModel"
                com.sumsub.sns.core.c.b(r6, r7, r8, r9, r10, r11)
                com.sumsub.sns.presentation.screen.d r2 = r0.f39708d
                com.sumsub.sns.internal.domain.e r2 = r2.f39607s
                com.sumsub.sns.presentation.screen.d r6 = r0.f39708d
                boolean r6 = r6.x()
                com.sumsub.sns.presentation.screen.d r7 = r0.f39708d
                com.sumsub.sns.internal.core.data.source.applicant.b r7 = r7.f39612x
                r0.f39707c = r4
                java.lang.Object r2 = r2.a(r6, r7, r0)
                if (r2 != r1) goto L_0x0079
                return r1
            L_0x0079:
                boolean r6 = kotlin.Result.m3079isSuccessimpl(r2)
                if (r6 == 0) goto L_0x01a3
                boolean r6 = kotlin.Result.m3078isFailureimpl(r2)
                if (r6 == 0) goto L_0x0087
                r6 = 0
                goto L_0x0088
            L_0x0087:
                r6 = r2
            L_0x0088:
                com.sumsub.sns.internal.domain.e$a r6 = (com.sumsub.sns.internal.domain.e.a) r6
                if (r6 == 0) goto L_0x0091
                java.util.List r6 = r6.d()
                goto L_0x0092
            L_0x0091:
                r6 = 0
            L_0x0092:
                boolean r7 = kotlin.Result.m3078isFailureimpl(r2)
                if (r7 == 0) goto L_0x0099
                r2 = 0
            L_0x0099:
                com.sumsub.sns.internal.domain.e$a r2 = (com.sumsub.sns.internal.domain.e.a) r2
                if (r2 == 0) goto L_0x00a2
                com.sumsub.sns.internal.core.data.model.g r2 = r2.c()
                goto L_0x00a3
            L_0x00a2:
                r2 = 0
            L_0x00a3:
                com.sumsub.sns.presentation.screen.d r7 = r0.f39708d
                com.sumsub.sns.internal.core.data.model.e r7 = r7.d()
                if (r7 != 0) goto L_0x00c6
                com.sumsub.sns.presentation.screen.d r7 = r0.f39708d
                com.sumsub.sns.internal.core.data.source.dynamic.b r7 = r7.f39611w
                r0.f39705a = r6
                r0.f39706b = r2
                r0.f39707c = r3
                java.lang.Object r7 = r7.b((boolean) r4, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.e>>) r0)
                if (r7 != r1) goto L_0x00be
                return r1
            L_0x00be:
                com.sumsub.sns.internal.core.data.source.dynamic.e r7 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r7
                java.lang.Object r7 = r7.e()
                com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7
            L_0x00c6:
                r15 = r6
                r16 = r7
                r14 = 0
                if (r2 == 0) goto L_0x015d
                if (r15 != 0) goto L_0x00d0
                goto L_0x015d
            L_0x00d0:
                com.sumsub.sns.core.c r17 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r6 = "moveToNextDocument, flowType="
                r13.append(r6)
                com.sumsub.sns.core.data.model.FlowType r6 = r16.y()
                r13.append(r6)
                java.lang.String r6 = ", documents: "
                r13.append(r6)
                com.sumsub.sns.presentation.screen.d$l$a r12 = com.sumsub.sns.presentation.screen.d.l.a.f39710a
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r18 = 31
                r19 = 0
                r6 = r15
                r5 = r13
                r13 = r18
                r14 = r19
                java.lang.String r6 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r6, r7, r8, r9, r10, r11, r12, r13, r14)
                r5.append(r6)
                java.lang.String r8 = r5.toString()
                r10 = 4
                java.lang.String r7 = "SNSAppViewModel"
                r6 = r17
                com.sumsub.sns.core.c.b(r6, r7, r8, r9, r10, r11)
                com.sumsub.sns.core.data.model.FlowType r5 = r16.y()
                int[] r6 = com.sumsub.sns.presentation.screen.d.l.b.f39711a
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r4) goto L_0x014a
                if (r5 == r3) goto L_0x0139
                com.sumsub.sns.presentation.screen.d r3 = r0.f39708d
                boolean r5 = r0.f39709e
                if (r5 != 0) goto L_0x012a
                boolean r5 = r2.P()
                if (r5 == 0) goto L_0x0129
                goto L_0x012a
            L_0x0129:
                r4 = 0
            L_0x012a:
                r5 = 0
                r0.f39705a = r5
                r0.f39706b = r5
                r5 = 6
                r0.f39707c = r5
                java.lang.Object r2 = r3.a((com.sumsub.sns.internal.core.data.model.g) r2, (java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r15, (boolean) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
                if (r2 != r1) goto L_0x01b5
                return r1
            L_0x0139:
                r5 = 0
                com.sumsub.sns.presentation.screen.d r3 = r0.f39708d
                r0.f39705a = r5
                r0.f39706b = r5
                r4 = 5
                r0.f39707c = r4
                java.lang.Object r2 = r3.a((com.sumsub.sns.internal.core.data.model.g) r2, (java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r15, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
                if (r2 != r1) goto L_0x01b5
                return r1
            L_0x014a:
                r5 = 0
                com.sumsub.sns.presentation.screen.d r3 = r0.f39708d
                boolean r4 = r0.f39709e
                r0.f39705a = r5
                r0.f39706b = r5
                r5 = 4
                r0.f39707c = r5
                java.lang.Object r2 = r3.b(r2, r15, r4, r0)
                if (r2 != r1) goto L_0x01b5
                return r1
            L_0x015d:
                com.sumsub.sns.core.c r3 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "moveToNextDocument; applicant==null ? "
                r5.append(r6)
                if (r2 != 0) goto L_0x016d
                r14 = r4
                goto L_0x016e
            L_0x016d:
                r14 = 0
            L_0x016e:
                r5.append(r14)
                java.lang.String r2 = "; documents==null ? "
                r5.append(r2)
                if (r15 != 0) goto L_0x0179
                goto L_0x017a
            L_0x0179:
                r4 = 0
            L_0x017a:
                r5.append(r4)
                java.lang.String r2 = "; "
                r5.append(r2)
                java.lang.String r5 = r5.toString()
                r6 = 0
                r7 = 4
                r8 = 0
                java.lang.String r4 = "SNSAppViewModel"
                com.sumsub.sns.core.c.b(r3, r4, r5, r6, r7, r8)
                com.sumsub.sns.presentation.screen.d r2 = r0.f39708d
                r3 = 0
                r0.f39705a = r3
                r0.f39706b = r3
                r3 = 3
                r0.f39707c = r3
                r3 = 0
                java.lang.Object r2 = r2.a((boolean) r3, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
                if (r2 != r1) goto L_0x01a0
                return r1
            L_0x01a0:
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            L_0x01a3:
                com.sumsub.sns.presentation.screen.d r1 = r0.f39708d
                java.lang.Throwable r2 = kotlin.Result.m3075exceptionOrNullimpl(r2)
                r3 = r2
                java.lang.Exception r3 = (java.lang.Exception) r3
                r5 = 0
                r6 = 4
                r7 = 0
                java.lang.String r4 = "TYPE_UNKNOWN"
                r2 = r1
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r2, (java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.Object) r5, (int) r6, (java.lang.Object) r7)
            L_0x01b5:
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {368, 372, 391}, m = "moveToNextModuleDocument")
    public static final class m extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39712a;

        /* renamed from: b  reason: collision with root package name */
        public Object f39713b;

        /* renamed from: c  reason: collision with root package name */
        public Object f39714c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f39715d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f39716e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f39717f;

        /* renamed from: g  reason: collision with root package name */
        public int f39718g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d dVar, kotlin.coroutines.c<? super m> cVar) {
            super(cVar);
            this.f39717f = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39716e = obj;
            this.f39718g |= Integer.MIN_VALUE;
            return this.f39717f.b((com.sumsub.sns.internal.core.data.model.g) null, (List<Document>) null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {1030}, m = "needSelectAgreement")
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f39719a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f39720b;

        /* renamed from: c  reason: collision with root package name */
        public int f39721c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(d dVar, kotlin.coroutines.c<? super n> cVar) {
            super(cVar);
            this.f39720b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39719a = obj;
            this.f39721c |= Integer.MIN_VALUE;
            return this.f39720b.b((com.sumsub.sns.internal.core.data.model.g) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$observeData$1", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements d10.q<kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39722a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39723b;

        public o(kotlin.coroutines.c<? super o> cVar) {
            super(3, cVar);
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super SNSMessage.ServerMessage> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            o oVar = new o(cVar);
            oVar.f39723b = th2;
            return oVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39722a == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.core.c.a(com.sumsub.sns.core.c.f30748a, d.P, String.valueOf(((Throwable) this.f39723b).getMessage()), (Throwable) null, 4, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$observeData$2", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements d10.p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39724a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39725b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f39726c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(d dVar, kotlin.coroutines.c<? super p> cVar) {
            super(2, cVar);
            this.f39726c = dVar;
        }

        /* renamed from: a */
        public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((p) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            p pVar = new p(this.f39726c, cVar);
            pVar.f39725b = obj;
            return pVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39724a == 0) {
                kotlin.k.b(obj);
                this.f39726c.a((b.a) this.f39725b);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onCancel$1", f = "SNSAppViewModel.kt", l = {440, 443}, m = "invokeSuspend")
    public static final class q extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39727a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f39728b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSCompletionResult f39729c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(d dVar, SNSCompletionResult sNSCompletionResult, kotlin.coroutines.c<? super q> cVar) {
            super(2, cVar);
            this.f39728b = dVar;
            this.f39729c = sNSCompletionResult;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((q) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new q(this.f39728b, this.f39729c, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9 A[Catch:{ Exception -> 0x00c3 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f39727a
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                kotlin.k.b(r10)
                goto L_0x0066
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                kotlin.k.b(r10)
                goto L_0x0032
            L_0x001f:
                kotlin.k.b(r10)
                com.sumsub.sns.presentation.screen.d r10 = r9.f39728b
                com.sumsub.sns.internal.core.data.source.dynamic.b r10 = r10.f39611w
                r9.f39727a = r4
                r1 = 0
                java.lang.Object r10 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r10, r1, r9, r4, r3)
                if (r10 != r0) goto L_0x0032
                return r0
            L_0x0032:
                com.sumsub.sns.internal.core.data.source.dynamic.e r10 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r10
                java.lang.Object r10 = r10.d()
                com.sumsub.sns.internal.core.data.model.e r10 = (com.sumsub.sns.internal.core.data.model.e) r10
                if (r10 == 0) goto L_0x00a5
                com.sumsub.sns.internal.core.data.model.e$a r10 = r10.r()
                if (r10 == 0) goto L_0x00a5
                com.sumsub.sns.core.data.model.FlowActionType r1 = r10.d()
                com.sumsub.sns.core.data.model.FlowActionType$FaceEnrollment r5 = com.sumsub.sns.core.data.model.FlowActionType.FaceEnrollment.INSTANCE
                boolean r1 = kotlin.jvm.internal.x.b(r1, r5)
                r1 = r1 ^ r4
                if (r1 == 0) goto L_0x0050
                r3 = r10
            L_0x0050:
                if (r3 == 0) goto L_0x00a5
                com.sumsub.sns.presentation.screen.d r10 = r9.f39728b
                com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r10.f39611w
                r9.f39727a = r2
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                r6 = r9
                java.lang.Object r10 = com.sumsub.sns.internal.core.data.source.dynamic.h.a(r3, r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0066
                return r0
            L_0x0066:
                com.sumsub.sns.internal.core.data.source.dynamic.e r10 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r10
                java.lang.Object r10 = r10.d()
                com.sumsub.sns.internal.core.data.model.g r10 = (com.sumsub.sns.internal.core.data.model.g) r10
                if (r10 == 0) goto L_0x00a5
                com.sumsub.sns.core.c r0 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "handleActionCompleted: "
                r1.append(r2)
                java.lang.String r2 = r10.B()
                r1.append(r2)
                java.lang.String r2 = ", "
                r1.append(r2)
                java.lang.String r3 = r10.L()
                r1.append(r3)
                r1.append(r2)
                com.sumsub.sns.internal.core.data.model.ReviewStatusType r10 = r10.K()
                r1.append(r10)
                java.lang.String r2 = r1.toString()
                r3 = 0
                r4 = 4
                r5 = 0
                java.lang.String r1 = "SNSAppViewModel"
                com.sumsub.sns.core.c.b(r0, r1, r2, r3, r4, r5)
            L_0x00a5:
                com.sumsub.sns.presentation.screen.d r10 = r9.f39728b
                com.sumsub.sns.presentation.screen.b$b r0 = new com.sumsub.sns.presentation.screen.b$b
                com.sumsub.sns.core.data.model.SNSCompletionResult r1 = r9.f39729c
                r0.<init>(r1)
                r10.a((com.sumsub.sns.core.presentation.base.a.j) r0)
                com.sumsub.sns.core.SNSMobileSDK r10 = com.sumsub.sns.core.SNSMobileSDK.INSTANCE     // Catch:{ Exception -> 0x00c3 }
                com.sumsub.sns.core.data.listener.SNSCompleteHandler r0 = r10.getCompleteHandler()     // Catch:{ Exception -> 0x00c3 }
                if (r0 == 0) goto L_0x00d3
                com.sumsub.sns.core.data.model.SNSCompletionResult r1 = r9.f39729c     // Catch:{ Exception -> 0x00c3 }
                com.sumsub.sns.core.data.model.SNSSDKState r10 = r10.getState()     // Catch:{ Exception -> 0x00c3 }
                r0.onComplete(r1, r10)     // Catch:{ Exception -> 0x00c3 }
                goto L_0x00d3
            L_0x00c3:
                r10 = move-exception
                com.sumsub.sns.core.c r0 = com.sumsub.sns.core.c.f30748a
                java.lang.String r1 = r10.getMessage()
                if (r1 != 0) goto L_0x00ce
                java.lang.String r1 = ""
            L_0x00ce:
                java.lang.String r2 = "SNSAppViewModel"
                r0.a(r2, r1, r10)
            L_0x00d3:
                com.sumsub.sns.core.SNSMobileSDK r10 = com.sumsub.sns.core.SNSMobileSDK.INSTANCE
                r10.shutdown()
                kotlin.Unit r10 = kotlin.Unit.f56620a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onDocumentClicked$1", f = "SNSAppViewModel.kt", l = {413, 414, 426}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f39730a;

        /* renamed from: b  reason: collision with root package name */
        public int f39731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Document f39732c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f39733d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(Document document, d dVar, kotlin.coroutines.c<? super r> cVar) {
            super(2, cVar);
            this.f39732c = document;
            this.f39733d = dVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((r) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new r(this.f39732c, this.f39733d, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.sumsub.sns.internal.core.data.model.g} */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
            if ((r3 != null ? r3.contains(r13.f39732c.getType().c()) : false) != false) goto L_0x00af;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d3 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r13.f39731b
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L_0x002c
                if (r1 == r6) goto L_0x0028
                if (r1 == r3) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                kotlin.k.b(r14)
                goto L_0x00d4
            L_0x0018:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x0020:
                java.lang.Object r1 = r13.f39730a
                com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
                kotlin.k.b(r14)
                goto L_0x007d
            L_0x0028:
                kotlin.k.b(r14)
                goto L_0x0063
            L_0x002c:
                kotlin.k.b(r14)
                com.sumsub.sns.core.c r7 = com.sumsub.sns.core.c.f30748a
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r1 = "A user has clicked on document: "
                r14.append(r1)
                com.sumsub.sns.internal.core.data.model.Document r1 = r13.f39732c
                com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
                java.lang.String r1 = r1.c()
                r14.append(r1)
                java.lang.String r9 = r14.toString()
                r10 = 0
                r11 = 4
                r12 = 0
                java.lang.String r8 = "SNSAppViewModel"
                com.sumsub.sns.core.c.b(r7, r8, r9, r10, r11, r12)
                com.sumsub.sns.presentation.screen.d r14 = r13.f39733d
                com.sumsub.sns.internal.core.data.source.dynamic.b r14 = r14.f39611w
                r13.f39731b = r6
                java.lang.Object r14 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r14, r5, r13, r6, r4)
                if (r14 != r0) goto L_0x0063
                return r0
            L_0x0063:
                com.sumsub.sns.internal.core.data.source.dynamic.e r14 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r14
                java.lang.Object r14 = r14.e()
                r1 = r14
                com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
                com.sumsub.sns.presentation.screen.d r14 = r13.f39733d
                com.sumsub.sns.internal.core.data.source.dynamic.b r14 = r14.f39611w
                r13.f39730a = r1
                r13.f39731b = r3
                java.lang.Object r14 = com.sumsub.sns.internal.core.data.source.dynamic.h.f(r14, r5, r13, r6, r4)
                if (r14 != r0) goto L_0x007d
                return r0
            L_0x007d:
                com.sumsub.sns.internal.core.data.source.dynamic.e r14 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r14
                java.lang.Object r14 = r14.e()
                com.sumsub.sns.internal.core.data.model.t r14 = (com.sumsub.sns.internal.core.data.model.t) r14
                java.util.List r14 = r14.d()
                com.sumsub.sns.internal.core.data.model.g$c r3 = r1.I()
                boolean r3 = r3.k()
                if (r3 == 0) goto L_0x00af
                com.sumsub.sns.internal.core.data.model.g$c r3 = r1.I()
                java.util.List r3 = r3.j()
                if (r3 == 0) goto L_0x00ac
                com.sumsub.sns.internal.core.data.model.Document r7 = r13.f39732c
                com.sumsub.sns.internal.core.data.model.DocumentType r7 = r7.getType()
                java.lang.String r7 = r7.c()
                boolean r3 = r3.contains(r7)
                goto L_0x00ad
            L_0x00ac:
                r3 = r5
            L_0x00ad:
                if (r3 == 0) goto L_0x00b0
            L_0x00af:
                r5 = r6
            L_0x00b0:
                if (r5 == 0) goto L_0x00b9
                com.sumsub.sns.internal.core.data.model.Document r14 = r13.f39732c
                java.util.List r14 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r14)
                goto L_0x00bd
            L_0x00b9:
                java.util.List r14 = com.sumsub.sns.internal.core.common.i.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r14, (com.sumsub.sns.internal.core.data.model.g) r1)
            L_0x00bd:
                com.sumsub.sns.presentation.screen.d r3 = r13.f39733d
                com.sumsub.sns.internal.core.data.model.Document r5 = r13.f39732c
                com.sumsub.sns.internal.core.data.model.DocumentType r5 = r5.getType()
                boolean r5 = r5.m()
                r13.f39730a = r4
                r13.f39731b = r2
                java.lang.Object r14 = r3.a((com.sumsub.sns.internal.core.data.model.g) r1, (java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r14, (boolean) r5, (kotlin.coroutines.c<? super kotlin.Unit>) r13)
                if (r14 != r0) goto L_0x00d4
                return r0
            L_0x00d4:
                kotlin.Unit r14 = kotlin.Unit.f56620a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.r.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onLoad$1", f = "SNSAppViewModel.kt", l = {204, 213}, m = "invokeSuspend")
    public static final class s extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39734a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f39735b;

        public static final class a extends Lambda implements d10.l<SNSTrackEvents, Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f39736a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(d dVar) {
                super(1);
                this.f39736a = dVar;
            }

            public final void a(SNSTrackEvents sNSTrackEvents) {
                this.f39736a.a((SNSEvent) new SNSEvent.SNSEventAnalytics(sNSTrackEvents));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((SNSTrackEvents) obj);
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(d dVar, kotlin.coroutines.c<? super s> cVar) {
            super(2, cVar);
            this.f39735b = dVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((s) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s(this.f39735b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39734a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, d.P, "onLoad", (Throwable) null, 4, (Object) null);
                com.sumsub.sns.internal.core.analytics.b.f31873a.a((d10.l<? super SNSTrackEvents, Unit>) new a(this.f39735b));
                com.sumsub.sns.internal.domain.g i12 = this.f39735b.f39606r;
                g.a aVar = new g.a();
                this.f39734a = 1;
                obj = i12.b(aVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                kotlin.k.b(obj);
                this.f39735b.A();
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.internal.core.domain.model.a aVar2 = (com.sumsub.sns.internal.core.domain.model.a) obj;
            if (aVar2.a()) {
                this.f39735b.b((Throwable) ((a.C0372a) aVar2).d());
                return Unit.f56620a;
            }
            g.b bVar = (g.b) ((a.b) aVar2).d();
            this.f39735b.a((SNSEvent) new SNSEvent.SNSEventApplicantLoaded(this.f39735b.f39610v.a()));
            d dVar = this.f39735b;
            boolean n11 = dVar.y();
            com.sumsub.sns.internal.core.data.model.g d12 = bVar.d();
            com.sumsub.sns.internal.core.data.model.e e11 = bVar.e();
            this.f39734a = 2;
            if (dVar.a(n11, d12, e11, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                return d11;
            }
            this.f39735b.A();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onMoveToApplicantStatusScreen$$inlined$launchOnViewModelScope$1", f = "SNSAppViewModel.kt", l = {449, 454}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39737a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39738b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.core.presentation.base.a f39739c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f39740d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f39742f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f39743g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(com.sumsub.sns.core.presentation.base.a aVar, String str, kotlin.coroutines.c cVar, boolean z11, d dVar, boolean z12) {
            super(2, cVar);
            this.f39739c = aVar;
            this.f39740d = str;
            this.f39741e = z11;
            this.f39742f = dVar;
            this.f39743g = z12;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((t) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            t tVar = new t(this.f39739c, this.f39740d, cVar, this.f39741e, this.f39742f, this.f39743g);
            tVar.f39738b = obj;
            return tVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r0 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
            com.sumsub.sns.core.presentation.base.a.a(r10.f39739c, (java.lang.Throwable) r11, r10.f39740d, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
            r0 = r11;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0012, B:10:0x0023] */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0012, B:16:0x0036] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0082 A[ExcHandler: Exception (r11v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:5:0x0012] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r10.f39737a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x002f
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                java.lang.Object r0 = r10.f39738b
                kotlinx.coroutines.h0 r0 = (kotlinx.coroutines.h0) r0
                kotlin.k.b(r11)     // Catch:{ CancellationException -> 0x0090, Exception -> 0x0082 }
                goto L_0x009e
            L_0x0017:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001f:
                java.lang.Object r1 = r10.f39738b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r11)     // Catch:{ CancellationException -> 0x002d, Exception -> 0x0082 }
                kotlin.Result r11 = (kotlin.Result) r11     // Catch:{ CancellationException -> 0x002d, Exception -> 0x0082 }
                r11.m3081unboximpl()     // Catch:{ CancellationException -> 0x002d, Exception -> 0x0082 }
                r11 = r1
                goto L_0x006c
            L_0x002d:
                r0 = r1
                goto L_0x0090
            L_0x002f:
                kotlin.k.b(r11)
                java.lang.Object r11 = r10.f39738b
                kotlinx.coroutines.h0 r11 = (kotlinx.coroutines.h0) r11
                com.sumsub.sns.core.c r4 = com.sumsub.sns.core.c.f30748a     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                java.lang.String r5 = "SNSAppViewModel"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r1.<init>()     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                java.lang.String r6 = "Show applicant status screen: isCancelled="
                r1.append(r6)     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                boolean r6 = r10.f39741e     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r1.append(r6)     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                java.lang.String r6 = r1.toString()     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r7 = 0
                r8 = 4
                r9 = 0
                com.sumsub.sns.core.c.b(r4, r5, r6, r7, r8, r9)     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                com.sumsub.sns.presentation.screen.d r1 = r10.f39742f     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                com.sumsub.sns.internal.domain.e r1 = r1.f39607s     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                boolean r4 = r10.f39743g     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                com.sumsub.sns.presentation.screen.d r5 = r10.f39742f     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                com.sumsub.sns.internal.core.data.source.applicant.b r5 = r5.f39612x     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r10.f39738b = r11     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r10.f39737a = r3     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                java.lang.Object r1 = r1.a(r4, r5, r10)     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                if (r1 != r0) goto L_0x006c
                return r0
            L_0x006c:
                com.sumsub.sns.presentation.screen.d r1 = r10.f39742f     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                boolean r3 = r10.f39741e     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r1.d((boolean) r3)     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                com.sumsub.sns.presentation.screen.d r1 = r10.f39742f     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                boolean r3 = r10.f39741e     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r10.f39738b = r11     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                r10.f39737a = r2     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                java.lang.Object r11 = r1.a((boolean) r3, (kotlin.coroutines.c<? super kotlin.Unit>) r10)     // Catch:{ CancellationException -> 0x008f, Exception -> 0x0082 }
                if (r11 != r0) goto L_0x009e
                return r0
            L_0x0082:
                r11 = move-exception
                r1 = r11
                com.sumsub.sns.core.presentation.base.a r0 = r10.f39739c
                java.lang.String r2 = r10.f39740d
                r3 = 0
                r4 = 4
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.Object) r3, (int) r4, (java.lang.Object) r5)
                goto L_0x009e
            L_0x008f:
                r0 = r11
            L_0x0090:
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r0)
                r4 = 0
                r5 = 4
                r6 = 0
                java.lang.String r3 = "CancellationException happened"
                com.sumsub.log.logger.a.a(r1, r2, r3, r4, r5, r6)
            L_0x009e:
                kotlin.Unit r11 = kotlin.Unit.f56620a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {157}, m = "onPrepare")
    public static final class u extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39744a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39745b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f39746c;

        /* renamed from: d  reason: collision with root package name */
        public int f39747d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(d dVar, kotlin.coroutines.c<? super u> cVar) {
            super(cVar);
            this.f39746c = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39745b = obj;
            this.f39747d |= Integer.MIN_VALUE;
            return this.f39746c.d((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onPrepare$2", f = "SNSAppViewModel.kt", l = {160, 161}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.p<C0526d, kotlin.coroutines.c<? super C0526d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f39748a;

        /* renamed from: b  reason: collision with root package name */
        public int f39749b;

        /* renamed from: c  reason: collision with root package name */
        public int f39750c;

        /* renamed from: d  reason: collision with root package name */
        public int f39751d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f39752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f39753f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(d dVar, kotlin.coroutines.c<? super v> cVar) {
            super(2, cVar);
            this.f39753f = dVar;
        }

        /* renamed from: a */
        public final Object invoke(C0526d dVar, kotlin.coroutines.c<? super C0526d> cVar) {
            return ((v) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            v vVar = new v(this.f39753f, cVar);
            vVar.f39752e = obj;
            return vVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r13.f39751d
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x0034
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                int r0 = r13.f39750c
                int r1 = r13.f39749b
                java.lang.Object r2 = r13.f39748a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r5 = r13.f39752e
                com.sumsub.sns.presentation.screen.d$d r5 = (com.sumsub.sns.presentation.screen.d.C0526d) r5
                kotlin.k.b(r14)
                r9 = r2
                goto L_0x006e
            L_0x0020:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x0028:
                int r1 = r13.f39750c
                int r5 = r13.f39749b
                java.lang.Object r6 = r13.f39752e
                com.sumsub.sns.presentation.screen.d$d r6 = (com.sumsub.sns.presentation.screen.d.C0526d) r6
                kotlin.k.b(r14)
                goto L_0x0052
            L_0x0034:
                kotlin.k.b(r14)
                java.lang.Object r14 = r13.f39752e
                com.sumsub.sns.presentation.screen.d$d r14 = (com.sumsub.sns.presentation.screen.d.C0526d) r14
                com.sumsub.sns.presentation.screen.d r1 = r13.f39753f
                r13.f39752e = r14
                r13.f39749b = r4
                r13.f39750c = r4
                r13.f39751d = r3
                java.lang.String r5 = "sns_general_progress_text"
                java.lang.Object r1 = r1.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r13)
                if (r1 != r0) goto L_0x004e
                return r0
            L_0x004e:
                r6 = r14
                r14 = r1
                r1 = r4
                r5 = r1
            L_0x0052:
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                com.sumsub.sns.presentation.screen.d r7 = r13.f39753f
                r13.f39752e = r6
                r13.f39748a = r14
                r13.f39749b = r5
                r13.f39750c = r1
                r13.f39751d = r2
                java.lang.String r2 = "sns_general_loadingTakesTooLong"
                java.lang.Object r2 = r7.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r13)
                if (r2 != r0) goto L_0x0069
                return r0
            L_0x0069:
                r9 = r14
                r0 = r1
                r14 = r2
                r1 = r5
                r5 = r6
            L_0x006e:
                r7 = 0
                if (r1 == 0) goto L_0x0073
                r6 = r3
                goto L_0x0074
            L_0x0073:
                r6 = r4
            L_0x0074:
                if (r0 == 0) goto L_0x0078
                r8 = r3
                goto L_0x0079
            L_0x0078:
                r8 = r4
            L_0x0079:
                r10 = r14
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                r11 = 7
                r12 = 0
                com.sumsub.sns.presentation.screen.d$d r14 = com.sumsub.sns.presentation.screen.d.C0526d.a(r5, r6, r7, r8, r9, r10, r11, r12)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.v.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onProgress$1", f = "SNSAppViewModel.kt", l = {138}, m = "invokeSuspend")
    public static final class w extends SuspendLambda implements d10.s<kotlinx.coroutines.flow.e<? super Pair<? extends Boolean, ? extends Long>>, a.k, Boolean, Integer, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39754a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39755b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f39756c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ boolean f39757d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ int f39758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f39759f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(d dVar, kotlin.coroutines.c<? super w> cVar) {
            super(5, cVar);
            this.f39759f = dVar;
        }

        public final Object a(kotlinx.coroutines.flow.e<? super Pair<Boolean, Long>> eVar, a.k kVar, boolean z11, int i11, kotlin.coroutines.c<? super Unit> cVar) {
            w wVar = new w(this.f39759f, cVar);
            wVar.f39755b = eVar;
            wVar.f39756c = kVar;
            wVar.f39757d = z11;
            wVar.f39758e = i11;
            return wVar.invokeSuspend(Unit.f56620a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return a((kotlinx.coroutines.flow.e) obj, (a.k) obj2, ((Boolean) obj3).booleanValue(), ((Number) obj4).intValue(), (kotlin.coroutines.c) obj5);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39754a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.flow.e eVar = (kotlinx.coroutines.flow.e) this.f39755b;
                a.k kVar = (a.k) this.f39756c;
                boolean z11 = this.f39757d;
                int i12 = this.f39758e;
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.b(cVar, d.P, "onProgress: progress=" + z11 + ", internalProgress=" + i12 + ", internalState=" + this.f39759f.i().getValue(), (Throwable) null, 4, (Object) null);
                Pair a11 = kotlin.l.a(kotlin.coroutines.jvm.internal.a.a(!kVar.f() || !kVar.j() || z11 || i12 > 0), kotlin.coroutines.jvm.internal.a.d((z11 || i12 > 0 || !kVar.f() || !kVar.j()) ? 0 : 350));
                this.f39755b = null;
                this.f39754a = 1;
                if (eVar.emit(a11, this) == d11) {
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

    public static final class x extends Lambda implements d10.l<Pair<? extends Boolean, ? extends Long>, Long> {

        /* renamed from: a  reason: collision with root package name */
        public static final x f39760a = new x();

        public x() {
            super(1);
        }

        /* renamed from: a */
        public final Long invoke(Pair<Boolean, Long> pair) {
            return pair.getSecond();
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onSdkPreparedSuccess$2", f = "SNSAppViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.p<C0526d, kotlin.coroutines.c<? super C0526d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39761a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39762b;

        public y(kotlin.coroutines.c<? super y> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(C0526d dVar, kotlin.coroutines.c<? super C0526d> cVar) {
            return ((y) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            y yVar = new y(cVar);
            yVar.f39762b = obj;
            return yVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f39761a == 0) {
                kotlin.k.b(obj);
                return C0526d.a((C0526d) this.f39762b, true, (Boolean) null, false, (CharSequence) null, (CharSequence) null, 30, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", l = {785, 795}, m = "onStepComplete")
    public static final class z extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f39763a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39764b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f39765c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f39766d;

        /* renamed from: e  reason: collision with root package name */
        public int f39767e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(d dVar, kotlin.coroutines.c<? super z> cVar) {
            super(cVar);
            this.f39766d = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39765c = obj;
            this.f39767e |= Integer.MIN_VALUE;
            return this.f39766d.a(false, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    static {
        Class<d> cls = d.class;
        M = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "currentLevelName", "getCurrentLevelName()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "isSDKPrepared", "isSDKPrepared()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "verificationStarted", "getVerificationStarted()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "pendingInstructionsData", "getPendingInstructionsData()Lcom/sumsub/sns/presentation/screen/SNSAppViewModel$PendingInstructionsData;", 0))};
    }

    public d(SavedStateHandle savedStateHandle, com.sumsub.sns.internal.domain.g gVar, com.sumsub.sns.internal.domain.e eVar, com.sumsub.sns.internal.core.domain.p pVar, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.settings.b bVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar2, com.sumsub.sns.internal.core.data.source.applicant.b bVar3) {
        super(aVar, bVar2);
        this.f39605q = savedStateHandle;
        this.f39606r = gVar;
        this.f39607s = eVar;
        this.f39608t = pVar;
        this.f39609u = aVar;
        this.f39610v = bVar;
        this.f39611w = bVar2;
        this.f39612x = bVar3;
        this.A = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "KEY_CURRENT_LEVEL", null);
        Boolean bool = Boolean.FALSE;
        this.B = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "KEY_SDK_PREPARED", bool);
        this.D = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "VERIFICATION_STARTED", bool);
        b1<Boolean> a11 = k1.a(bool);
        this.G = a11;
        b1<Integer> a12 = k1.a(0);
        this.H = a12;
        this.I = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "KEY_AFTER_INSTRUCTIONS_DATA", null);
        this.J = new LinkedHashSet();
        kotlinx.coroutines.flow.d<Boolean> s11 = kotlinx.coroutines.flow.f.s(new h0(kotlinx.coroutines.flow.f.r(kotlinx.coroutines.flow.f.n(i(), a11, a12, new w(this, (kotlin.coroutines.c<? super w>) null)), x.f39760a)));
        this.K = s11;
        com.sumsub.sns.internal.core.common.b0.a(s11, m0.a(this), new a(this, (kotlin.coroutines.c<? super a>) null));
        m();
    }

    public static /* synthetic */ void v() {
    }

    public final void A() {
        com.sumsub.sns.internal.core.common.b0.a(kotlinx.coroutines.flow.f.f(this.f39611w.a(), new o((kotlin.coroutines.c<? super o>) null)), m0.a(this), (d10.p) null, 2, (Object) null);
        com.sumsub.sns.internal.core.common.b0.a(this.f39611w.b(), m0.a(this), new p(this, (kotlin.coroutines.c<? super p>) null));
    }

    public final void B() {
        p();
        this.C = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new d0(this, (kotlin.coroutines.c<? super d0>) null), 3, (Object) null);
    }

    public final void C() {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new e0(this, DocumentType.f32355j, (kotlin.coroutines.c) null, this), 3, (Object) null);
    }

    public void onCleared() {
        com.sumsub.sns.internal.core.analytics.b.f31873a.a((d10.l<? super SNSTrackEvents, Unit>) null);
        q();
        super.onCleared();
    }

    public final void q() {
        f(false);
        if (this.f39614z != null) {
            com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, P, "cancelWaitForLevelChange", (Throwable) null, 4, (Object) null);
        }
        n1 n1Var = this.f39614z;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f39614z = null;
    }

    public final void r() {
        this.J.clear();
    }

    public final String s() {
        return (String) this.A.a(this, M[0]);
    }

    /* renamed from: t */
    public C0526d e() {
        return new C0526d(false, (Boolean) null, false, (CharSequence) null, (CharSequence) null, 31, (kotlin.jvm.internal.r) null);
    }

    public final kotlinx.coroutines.flow.d<Boolean> u() {
        return this.K;
    }

    public final c w() {
        return (c) this.I.a(this, M[3]);
    }

    public final boolean x() {
        return ((Boolean) this.D.a(this, M[2])).booleanValue();
    }

    public final boolean y() {
        return ((Boolean) this.B.a(this, M[1])).booleanValue();
    }

    public final boolean z() {
        return this.f39614z != null;
    }

    public final void c(Document document) {
        this.E = document;
        i(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.presentation.screen.d.u
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.presentation.screen.d$u r0 = (com.sumsub.sns.presentation.screen.d.u) r0
            int r1 = r0.f39747d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39747d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.d$u r0 = new com.sumsub.sns.presentation.screen.d$u
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f39745b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f39747d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f39744a
            com.sumsub.sns.presentation.screen.d r0 = (com.sumsub.sns.presentation.screen.d) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f39744a = r4
            r0.f39747d = r3
            java.lang.Object r5 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            com.sumsub.sns.presentation.screen.d$v r5 = new com.sumsub.sns.presentation.screen.d$v
            r1 = 0
            r5.<init>(r0, r1)
            r2 = 0
            com.sumsub.sns.core.presentation.base.a.a(r0, r2, r5, r3, r1)
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.d(kotlin.coroutines.c):java.lang.Object");
    }

    public final void f(boolean z11) {
        b1<Integer> b1Var = this.H;
        b1Var.setValue(Integer.valueOf(b1Var.getValue().intValue() + (z11 ? 1 : -1)));
    }

    public final void g(boolean z11) {
        this.G.setValue(Boolean.valueOf(z11));
    }

    public final void h(boolean z11) {
        this.B.a(this, M[1], Boolean.valueOf(z11));
    }

    public final void i(boolean z11) {
        this.D.a(this, M[2], Boolean.valueOf(z11));
    }

    public void m() {
        a((d10.p<? super kotlinx.coroutines.h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new s(this, (kotlin.coroutines.c<? super s>) null));
    }

    public final void p() {
        n1 n1Var = this.C;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.C = null;
        com.sumsub.sns.core.presentation.base.a.a(this, false, new f((kotlin.coroutines.c<? super f>) null), 1, (Object) null);
    }

    public final void e(boolean z11) {
        a((d10.p<? super kotlinx.coroutines.h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new l(this, z11, (kotlin.coroutines.c<? super l>) null));
    }

    public final void c(boolean z11) {
        c w11 = w();
        if (w11 != null) {
            a((c) null);
            if (z11) {
                if (w11.d() instanceof b.d) {
                    ((b.d) w11.d()).a((com.sumsub.sns.internal.core.domain.model.c) null);
                }
                this.J.add(a(w11.c()));
                if (w11.d() instanceof b) {
                    a((a.j) w11.d());
                } else {
                    a((a.j) new b.a(true, w11.d()));
                }
            } else {
                a((a.j) new b.a(false, w11.d()));
            }
        }
    }

    public final void b(String str) {
        this.A.a(this, M[0], str);
    }

    public final void b(com.sumsub.sns.internal.core.data.model.g gVar, Document document) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "startActionStep: " + document, (Throwable) null, 4, (Object) null);
        b.d a11 = f.b(gVar, document);
        if (a11 == null) {
            a11 = a.a(document, gVar, true);
            if (!a11.a()) {
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new IllegalArgumentException("Step " + document.getType().c() + " is NOT supported in actions"), document.getType().c(), (Object) null, 4, (Object) null);
                return;
            }
        }
        a((a.j) a11);
    }

    public final void d(boolean z11) {
        Document document = this.E;
        if (document != null) {
            c((Document) null);
            a((SNSEvent) new SNSEvent.SNSEventStepCompleted(this.f39610v.a(), document.getType().c(), z11));
        }
    }

    public final void c(String str) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g0(this, DocumentType.f32355j, (kotlin.coroutines.c) null, this, str), 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.util.List<com.sumsub.sns.internal.core.data.model.Document>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.sumsub.sns.internal.core.data.model.g r12, java.util.List<com.sumsub.sns.internal.core.data.model.Document> r13, boolean r14, kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.presentation.screen.d.m
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.presentation.screen.d$m r0 = (com.sumsub.sns.presentation.screen.d.m) r0
            int r1 = r0.f39718g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39718g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.d$m r0 = new com.sumsub.sns.presentation.screen.d$m
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f39716e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f39718g
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r6) goto L_0x003e
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.k.b(r15)
            goto L_0x0117
        L_0x0032:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003a:
            kotlin.k.b(r15)
            goto L_0x008d
        L_0x003e:
            boolean r14 = r0.f39715d
            java.lang.Object r12 = r0.f39714c
            r13 = r12
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r12 = r0.f39713b
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            java.lang.Object r2 = r0.f39712a
            com.sumsub.sns.presentation.screen.d r2 = (com.sumsub.sns.presentation.screen.d) r2
            kotlin.k.b(r15)
            goto L_0x0068
        L_0x0051:
            kotlin.k.b(r15)
            com.sumsub.sns.internal.core.data.source.dynamic.b r15 = r11.f39611w
            r0.f39712a = r11
            r0.f39713b = r12
            r0.f39714c = r13
            r0.f39715d = r14
            r0.f39718g = r6
            java.lang.Object r15 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r15, r5, r0, r6, r7)
            if (r15 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r11
        L_0x0068:
            com.sumsub.sns.internal.core.data.source.dynamic.e r15 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r15
            java.lang.Object r15 = r15.d()
            com.sumsub.sns.internal.core.data.model.e r15 = (com.sumsub.sns.internal.core.data.model.e) r15
            if (r15 != 0) goto L_0x0075
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x0075:
            r2.d((boolean) r5)
            boolean r8 = r12.O()
            if (r8 == 0) goto L_0x0090
            r0.f39712a = r7
            r0.f39713b = r7
            r0.f39714c = r7
            r0.f39718g = r4
            java.lang.Object r12 = r2.a((boolean) r5, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x008d
            return r1
        L_0x008d:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x0090:
            java.util.Iterator r13 = r13.iterator()
        L_0x0094:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x00c5
            java.lang.Object r4 = r13.next()
            r8 = r4
            com.sumsub.sns.internal.core.data.model.Document r8 = (com.sumsub.sns.internal.core.data.model.Document) r8
            com.sumsub.sns.internal.core.data.model.DocumentType r9 = r8.getType()
            java.lang.String r9 = r9.c()
            java.lang.String r10 = r15.z()
            boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
            if (r9 == 0) goto L_0x00c1
            boolean r9 = r8.isSubmitted()
            if (r9 == 0) goto L_0x00bf
            boolean r8 = r8.isRejected()
            if (r8 == 0) goto L_0x00c1
        L_0x00bf:
            r8 = r6
            goto L_0x00c2
        L_0x00c1:
            r8 = r5
        L_0x00c2:
            if (r8 == 0) goto L_0x0094
            goto L_0x00c6
        L_0x00c5:
            r4 = r7
        L_0x00c6:
            com.sumsub.sns.internal.core.data.model.Document r4 = (com.sumsub.sns.internal.core.data.model.Document) r4
            if (r4 == 0) goto L_0x0108
            com.sumsub.sns.internal.core.data.model.g$c r13 = r12.I()
            boolean r13 = r13.k()
            if (r13 == 0) goto L_0x00ff
            com.sumsub.sns.internal.core.data.model.g$c r13 = r12.I()
            java.util.List r13 = r13.j()
            if (r13 == 0) goto L_0x00ed
            com.sumsub.sns.internal.core.data.model.DocumentType r15 = r4.getType()
            java.lang.String r15 = r15.c()
            boolean r13 = r13.contains(r15)
            if (r13 != r6) goto L_0x00ed
            r5 = r6
        L_0x00ed:
            if (r5 != 0) goto L_0x00ff
            if (r14 == 0) goto L_0x00f9
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r4)
            r2.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r12)
            goto L_0x0105
        L_0x00f9:
            com.sumsub.sns.presentation.screen.b$d$c r12 = com.sumsub.sns.presentation.screen.b.d.c.f39587c
            r2.a((com.sumsub.sns.core.presentation.base.a.j) r12)
            goto L_0x0105
        L_0x00ff:
            r2.a((com.sumsub.sns.internal.core.data.model.g) r12, (com.sumsub.sns.internal.core.data.model.Document) r4)
            r2.a((com.sumsub.sns.internal.core.data.model.Document) r4)
        L_0x0105:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x0108:
            r0.f39712a = r7
            r0.f39713b = r7
            r0.f39714c = r7
            r0.f39718g = r3
            java.lang.Object r12 = r2.a((boolean) r5, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x0117
            return r1
        L_0x0117:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.b(com.sumsub.sns.internal.core.data.model.g, java.util.List, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(c cVar) {
        this.I.a(this, M[3], cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r0 = r0.e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.core.data.source.dynamic.b.a r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r11.s()
            r1 = 0
            if (r0 != 0) goto L_0x0025
            com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r12.j()
            java.lang.Object r0 = r0.d()
            com.sumsub.sns.internal.core.data.model.t r0 = (com.sumsub.sns.internal.core.data.model.t) r0
            if (r0 == 0) goto L_0x0021
            com.sumsub.sns.internal.core.data.model.remote.response.c r0 = r0.e()
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r0.b()
            goto L_0x0022
        L_0x0021:
            r0 = r1
        L_0x0022:
            r11.b((java.lang.String) r0)
        L_0x0025:
            com.sumsub.sns.internal.core.data.source.dynamic.e r0 = r12.j()
            java.lang.Object r0 = r0.d()
            com.sumsub.sns.internal.core.data.model.t r0 = (com.sumsub.sns.internal.core.data.model.t) r0
            if (r0 == 0) goto L_0x003c
            com.sumsub.sns.internal.core.data.model.remote.response.c r0 = r0.e()
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r0.b()
            goto L_0x003d
        L_0x003c:
            r0 = r1
        L_0x003d:
            java.lang.String r2 = r11.s()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r0)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x004d
            if (r0 == 0) goto L_0x004d
            r2 = r3
            goto L_0x004e
        L_0x004d:
            r2 = r4
        L_0x004e:
            r11.b((java.lang.String) r0)
            com.sumsub.sns.core.c r0 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Data updated: levelChanged="
            r5.append(r6)
            r5.append(r2)
            java.lang.String r6 = ", level="
            r5.append(r6)
            java.lang.String r6 = r11.s()
            r5.append(r6)
            java.lang.String r6 = ", isWaitingForLevelChange="
            r5.append(r6)
            boolean r6 = r11.z()
            r5.append(r6)
            java.lang.String r7 = r5.toString()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "SNSAppViewModel"
            r5 = r0
            com.sumsub.sns.core.c.b(r5, r6, r7, r8, r9, r10)
            boolean r5 = r11.z()
            if (r5 == 0) goto L_0x00c5
            if (r2 == 0) goto L_0x00c5
            r11.q()
            com.sumsub.sns.internal.core.data.source.dynamic.e r12 = r12.g()
            java.lang.Object r12 = r12.d()
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            if (r12 == 0) goto L_0x00a4
            boolean r12 = r12.A()
            if (r12 != r3) goto L_0x00a4
            r12 = r3
            goto L_0x00a5
        L_0x00a4:
            r12 = r4
        L_0x00a5:
            if (r12 == 0) goto L_0x00b7
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "SNSAppViewModel"
            java.lang.String r7 = "Data updated: Applicant has VI only, moving to status screen"
            r5 = r0
            com.sumsub.sns.core.c.b(r5, r6, r7, r8, r9, r10)
            r12 = 2
            a((com.sumsub.sns.presentation.screen.d) r11, (boolean) r4, (boolean) r4, (int) r12, (java.lang.Object) r1)
            goto L_0x00c5
        L_0x00b7:
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "SNSAppViewModel"
            java.lang.String r7 = "Data updated: moving to next document"
            r5 = r0
            com.sumsub.sns.core.c.b(r5, r6, r7, r8, r9, r10)
            a((com.sumsub.sns.presentation.screen.d) r11, (boolean) r4, (int) r3, (java.lang.Object) r1)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.a(com.sumsub.sns.internal.core.data.source.dynamic.b$a):void");
    }

    public static /* synthetic */ void a(d dVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        dVar.e(z11);
    }

    public final void b(DocumentType documentType) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "A user has uploaded document: " + documentType.c(), (Throwable) null, 4, (Object) null);
    }

    public final Object a(com.sumsub.sns.internal.core.data.model.g gVar, List<Document> list, kotlin.coroutines.c<? super Unit> cVar) {
        Document b11 = g.b(list, gVar);
        if (b11 == null || kotlin.jvm.internal.x.b(this.E, b11)) {
            d(false);
            Object a11 = a(false, cVar);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
        }
        d(false);
        b(gVar, b11);
        a(b11);
        return Unit.f56620a;
    }

    public final void b(Document document) {
        a((d10.p<? super kotlinx.coroutines.h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object>) new r(document, this, (kotlin.coroutines.c<? super r>) null));
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "On handle error - " + oVar, (Throwable) null, 4, (Object) null);
        if (oVar instanceof o.c) {
            a(this, (SNSCompletionResult) new SNSCompletionResult.AbnormalTermination(oVar.b()), false, 2, (Object) null);
        } else {
            a((a.j) new b.c(oVar));
        }
    }

    public final void b(com.sumsub.sns.internal.core.data.model.g gVar) {
        T t11;
        Iterator<T> it2 = gVar.I().g().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((g.c.a) t11).m().k()) {
                break;
            }
        }
        g.c.a aVar = (g.c.a) t11;
        if (aVar != null) {
            try {
                SNSProoface.Companion companion = SNSProoface.Companion;
            } catch (Exception e11) {
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.a(cVar, P, "Prooface is not available: " + e11, (Throwable) null, 4, (Object) null);
                g(false);
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) e11, aVar.m().c(), (Object) null, 4, (Object) null);
            }
        }
    }

    public static /* synthetic */ void a(d dVar, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        dVar.a(z11, z12);
    }

    public static /* synthetic */ void a(d dVar, SNSCompletionResult sNSCompletionResult, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        dVar.a(sNSCompletionResult, z11);
    }

    public final void b(Throwable th2) {
        if (!(th2 instanceof CancellationException)) {
            a((com.sumsub.sns.internal.core.data.model.o) new o.c(th2, (Object) null, (o.a) null, 6, (kotlin.jvm.internal.r) null), DocumentType.f32355j);
            g(false);
            com.sumsub.sns.core.c.f30748a.a(P, "An error while preparing the sdk...", th2);
        }
    }

    public final void a(SNSCompletionResult sNSCompletionResult, boolean z11) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "Cancel verification with reason - " + sNSCompletionResult, (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.analytics.f.a(0, 1, (Object) null).a(SdkEvent.Dismiss).a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a("isDismissMethodCalled", Boolean.valueOf(z11))}).a(true);
        q();
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new q(this, sNSCompletionResult, (kotlin.coroutines.c<? super q>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ca A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(boolean r24, kotlin.coroutines.c<? super kotlin.Unit> r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            boolean r3 = r2 instanceof com.sumsub.sns.presentation.screen.d.a0
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.presentation.screen.d$a0 r3 = (com.sumsub.sns.presentation.screen.d.a0) r3
            int r4 = r3.f39629i
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f39629i = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.presentation.screen.d$a0 r3 = new com.sumsub.sns.presentation.screen.d$a0
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f39627g
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r3.f39629i
            r11 = 0
            r12 = 4
            r13 = 3
            r5 = 2
            r14 = 0
            r15 = 1
            if (r4 == 0) goto L_0x008f
            if (r4 == r15) goto L_0x0084
            if (r4 == r5) goto L_0x0070
            if (r4 == r13) goto L_0x0053
            if (r4 != r12) goto L_0x004b
            int r1 = r3.f39626f
            boolean r4 = r3.f39625e
            java.lang.Object r5 = r3.f39623c
            com.sumsub.sns.internal.core.data.model.g r5 = (com.sumsub.sns.internal.core.data.model.g) r5
            java.lang.Object r6 = r3.f39622b
            com.sumsub.sns.internal.core.data.model.e r6 = (com.sumsub.sns.internal.core.data.model.e) r6
            java.lang.Object r3 = r3.f39621a
            com.sumsub.sns.presentation.screen.d r3 = (com.sumsub.sns.presentation.screen.d) r3
            kotlin.k.b(r2)
            goto L_0x01a3
        L_0x004b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0053:
            boolean r1 = r3.f39625e
            java.lang.Object r4 = r3.f39624d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r3.f39623c
            com.sumsub.sns.internal.core.data.model.g r5 = (com.sumsub.sns.internal.core.data.model.g) r5
            java.lang.Object r6 = r3.f39622b
            com.sumsub.sns.internal.core.data.model.e r6 = (com.sumsub.sns.internal.core.data.model.e) r6
            java.lang.Object r7 = r3.f39621a
            com.sumsub.sns.presentation.screen.d r7 = (com.sumsub.sns.presentation.screen.d) r7
            kotlin.k.b(r2)
            r22 = r6
            r6 = r5
            r5 = r7
        L_0x006c:
            r7 = r22
            goto L_0x0133
        L_0x0070:
            boolean r1 = r3.f39625e
            java.lang.Object r4 = r3.f39622b
            com.sumsub.sns.internal.core.data.model.e r4 = (com.sumsub.sns.internal.core.data.model.e) r4
            java.lang.Object r5 = r3.f39621a
            com.sumsub.sns.presentation.screen.d r5 = (com.sumsub.sns.presentation.screen.d) r5
            kotlin.k.b(r2)
            kotlin.Result r2 = (kotlin.Result) r2
            java.lang.Object r2 = r2.m3081unboximpl()
            goto L_0x00eb
        L_0x0084:
            boolean r1 = r3.f39625e
            java.lang.Object r4 = r3.f39621a
            com.sumsub.sns.presentation.screen.d r4 = (com.sumsub.sns.presentation.screen.d) r4
            kotlin.k.b(r2)
            r9 = r4
            goto L_0x00c0
        L_0x008f:
            kotlin.k.b(r2)
            com.sumsub.sns.core.c r16 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "resolveApplicantStatus: isCancelled="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r18 = r2.toString()
            r19 = 0
            r20 = 4
            r21 = 0
            java.lang.String r17 = "SNSAppViewModel"
            com.sumsub.sns.core.c.b(r16, r17, r18, r19, r20, r21)
            com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r0.f39611w
            r3.f39621a = r0
            r3.f39625e = r1
            r3.f39629i = r15
            java.lang.Object r2 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r2, r14, r3, r15, r11)
            if (r2 != r10) goto L_0x00bf
            return r10
        L_0x00bf:
            r9 = r0
        L_0x00c0:
            com.sumsub.sns.internal.core.data.source.dynamic.e r2 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r2
            java.lang.Object r2 = r2.d()
            com.sumsub.sns.internal.core.data.model.e r2 = (com.sumsub.sns.internal.core.data.model.e) r2
            com.sumsub.sns.internal.domain.e r4 = r9.f39607s
            com.sumsub.sns.internal.core.data.source.applicant.b r6 = r9.f39612x
            r3.f39621a = r9
            r3.f39622b = r2
            r3.f39625e = r1
            r3.f39629i = r5
            r5 = 0
            r8 = 1
            r16 = 0
            r7 = r3
            r17 = r9
            r9 = r16
            java.lang.Object r4 = com.sumsub.sns.internal.domain.e.a(r4, r5, r6, r7, r8, r9)
            if (r4 != r10) goto L_0x00e4
            return r10
        L_0x00e4:
            r5 = r17
            r22 = r4
            r4 = r2
            r2 = r22
        L_0x00eb:
            if (r4 == 0) goto L_0x01df
            boolean r6 = kotlin.Result.m3078isFailureimpl(r2)
            if (r6 == 0) goto L_0x00f5
            goto L_0x01df
        L_0x00f5:
            boolean r6 = r5.z()
            if (r6 == 0) goto L_0x010d
            com.sumsub.sns.core.c r16 = com.sumsub.sns.core.c.f30748a
            r19 = 0
            r20 = 4
            r21 = 0
            java.lang.String r17 = "SNSAppViewModel"
            java.lang.String r18 = "resolveApplicantStatus: waiting for level change, do nothing"
            com.sumsub.sns.core.c.b(r16, r17, r18, r19, r20, r21)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x010d:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.domain.e$a r2 = (com.sumsub.sns.internal.domain.e.a) r2
            com.sumsub.sns.internal.core.data.model.g r6 = r2.a()
            java.util.List r2 = r2.b()
            r3.f39621a = r5
            r3.f39622b = r4
            r3.f39623c = r6
            r3.f39624d = r2
            r3.f39625e = r1
            r3.f39629i = r13
            java.lang.Object r7 = r5.b((com.sumsub.sns.internal.core.data.model.g) r6, (kotlin.coroutines.c<? super java.lang.Boolean>) r3)
            if (r7 != r10) goto L_0x012d
            return r10
        L_0x012d:
            r22 = r4
            r4 = r2
            r2 = r7
            goto L_0x006c
        L_0x0133:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0143
            com.sumsub.sns.presentation.screen.b$d$a r1 = com.sumsub.sns.presentation.screen.b.d.a.f39585c
            r5.a((com.sumsub.sns.core.presentation.base.a.j) r1)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0143:
            boolean r2 = r4 instanceof java.util.Collection
            if (r2 == 0) goto L_0x014e
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x014e
            goto L_0x0172
        L_0x014e:
            java.util.Iterator r2 = r4.iterator()
        L_0x0152:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0172
            java.lang.Object r8 = r2.next()
            com.sumsub.sns.internal.core.data.model.Document r8 = (com.sumsub.sns.internal.core.data.model.Document) r8
            boolean r9 = r8.isSubmitted()
            if (r9 == 0) goto L_0x016d
            boolean r8 = r8.isRejected()
            if (r8 == 0) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r8 = r14
            goto L_0x016e
        L_0x016d:
            r8 = r15
        L_0x016e:
            if (r8 == 0) goto L_0x0152
            r2 = r15
            goto L_0x0173
        L_0x0172:
            r2 = r14
        L_0x0173:
            com.sumsub.sns.internal.core.data.model.g$c r8 = r6.I()
            boolean r8 = r8.k()
            if (r8 == 0) goto L_0x0186
            boolean r4 = r5.a((com.sumsub.sns.internal.core.data.model.g) r6, (java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r4, (boolean) r1)
            if (r4 == 0) goto L_0x0186
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0186:
            com.sumsub.sns.internal.core.data.source.dynamic.b r4 = r5.f39611w
            r3.f39621a = r5
            r3.f39622b = r7
            r3.f39623c = r6
            r3.f39624d = r11
            r3.f39625e = r1
            r3.f39626f = r2
            r3.f39629i = r12
            java.lang.Object r3 = r4.c((boolean) r14, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r3)
            if (r3 != r10) goto L_0x019d
            return r10
        L_0x019d:
            r4 = r1
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r7
        L_0x01a3:
            com.sumsub.sns.internal.core.data.source.dynamic.e r2 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r2
            boolean r7 = r2 instanceof com.sumsub.sns.internal.core.data.source.dynamic.e.d
            if (r7 == 0) goto L_0x01c7
            java.lang.Object r2 = r2.e()
            com.sumsub.sns.internal.core.data.model.t r2 = (com.sumsub.sns.internal.core.data.model.t) r2
            com.sumsub.sns.internal.core.data.model.remote.response.h r2 = r2.f()
            if (r2 == 0) goto L_0x01c2
            java.lang.Boolean r2 = r2.e()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.a.a(r15)
            boolean r2 = kotlin.jvm.internal.x.b(r2, r7)
            goto L_0x01c3
        L_0x01c2:
            r2 = r14
        L_0x01c3:
            if (r2 == 0) goto L_0x01c7
            r2 = r15
            goto L_0x01c8
        L_0x01c7:
            r2 = r14
        L_0x01c8:
            if (r2 == 0) goto L_0x01d6
            if (r1 != 0) goto L_0x01d6
            boolean r2 = r3.F
            if (r2 == 0) goto L_0x01d6
            r3.a((com.sumsub.sns.internal.core.data.model.g) r5, (com.sumsub.sns.internal.core.data.model.e) r6, (boolean) r4)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x01d6:
            if (r1 == 0) goto L_0x01d9
            r14 = r15
        L_0x01d9:
            r3.a((com.sumsub.sns.internal.core.data.model.g) r5, (com.sumsub.sns.internal.core.data.model.e) r6, (boolean) r14, (boolean) r4)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x01df:
            com.sumsub.sns.core.c r6 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Config is null ("
            r1.append(r3)
            if (r4 != 0) goto L_0x01ee
            r14 = r15
        L_0x01ee:
            r1.append(r14)
            java.lang.String r3 = ") or applicant update result ("
            r1.append(r3)
            boolean r2 = kotlin.Result.m3078isFailureimpl(r2)
            r1.append(r2)
            java.lang.String r2 = "), going to status screen"
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "SNSAppViewModel"
            com.sumsub.sns.core.c.b(r6, r7, r8, r9, r10, r11)
            com.sumsub.sns.presentation.screen.b$d$c r1 = com.sumsub.sns.presentation.screen.b.d.c.f39587c
            r5.a((com.sumsub.sns.core.presentation.base.a.j) r1)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.b(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(com.sumsub.sns.internal.core.data.model.g gVar, Document document) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "Show preview for document: " + document.getType().c(), (Throwable) null, 4, (Object) null);
        g(false);
        if (document.getType().k() && a.a(gVar, document).c()) {
            a(document.getType());
        }
        b.d a11 = a.a(document, gVar, false, 2, (Object) null);
        com.sumsub.sns.core.c.b(cVar, P, "navigation event: " + a11 + '}', (Throwable) null, 4, (Object) null);
        a((a.j) a11);
    }

    public final void a(DocumentType documentType) {
        try {
            SNSProoface.Companion companion = SNSProoface.Companion;
        } catch (Exception e11) {
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            com.sumsub.sns.core.c.a(cVar, P, "Prooface is not available: " + e11, (Throwable) null, 4, (Object) null);
            g(false);
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) e11, documentType.c(), (Object) null, 4, (Object) null);
        }
    }

    public void a(a.j jVar) {
        if (jVar instanceof b.d) {
            b.d dVar = (b.d) jVar;
            if (dVar.b() != null) {
                com.sumsub.sns.internal.core.domain.model.c b11 = dVar.b();
                if (b11 != null) {
                    a(new com.sumsub.sns.internal.core.domain.model.c(b11.g(), b11.f(), b11.e(), b11.h()), (Parcelable) jVar);
                    return;
                }
                return;
            }
        }
        super.a(jVar);
    }

    public final void a(com.sumsub.sns.internal.core.domain.model.c cVar, Parcelable parcelable) {
        com.sumsub.sns.core.c cVar2 = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar2, P, "resolveInstructions, introParams=" + cVar + ", payload=" + parcelable, (Throwable) null, 4, (Object) null);
        if (parcelable != null) {
            a(new c(cVar, parcelable));
        }
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new c0(this, cVar, (kotlin.coroutines.c<? super c0>) null), 3, (Object) null);
    }

    public final String a(com.sumsub.sns.internal.core.domain.model.c cVar) {
        return cVar.g() + '|' + cVar.f() + '|' + cVar.e();
    }

    public final Object a(boolean z11, com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super Unit> cVar) {
        com.sumsub.sns.core.c cVar2 = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar2, P, "SDK is prepared. Applicant - " + eVar.s() + ", type=" + eVar.y(), (Throwable) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new y((kotlin.coroutines.c<? super y>) null), 1, (Object) null);
        h(true);
        a((SNSEvent) new SNSEvent.VerificationStarted(eVar.s()));
        if (z11) {
            C();
            return Unit.f56620a;
        }
        Object a11 = a(gVar, eVar.y(), cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.g r8, com.sumsub.sns.core.data.model.FlowType r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.presentation.screen.d.j
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.presentation.screen.d$j r0 = (com.sumsub.sns.presentation.screen.d.j) r0
            int r1 = r0.f39700e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39700e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.d$j r0 = new com.sumsub.sns.presentation.screen.d$j
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f39698c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f39700e
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r6) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.k.b(r10)
            goto L_0x007f
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.Object r8 = r0.f39697b
            com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8
            java.lang.Object r9 = r0.f39696a
            com.sumsub.sns.presentation.screen.d r9 = (com.sumsub.sns.presentation.screen.d) r9
            kotlin.k.b(r10)
            goto L_0x0070
        L_0x0044:
            kotlin.k.b(r10)
            goto L_0x0059
        L_0x0048:
            kotlin.k.b(r10)
            com.sumsub.sns.core.data.model.FlowType r10 = com.sumsub.sns.core.data.model.FlowType.Standalone
            r2 = 0
            if (r9 != r10) goto L_0x005c
            r0.f39700e = r6
            java.lang.Object r8 = r7.b((boolean) r2, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x0059
            return r1
        L_0x0059:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        L_0x005c:
            com.sumsub.sns.core.data.model.FlowType r10 = com.sumsub.sns.core.data.model.FlowType.Actions
            if (r9 != r10) goto L_0x0082
            com.sumsub.sns.internal.core.data.source.dynamic.b r9 = r7.f39611w
            r0.f39696a = r7
            r0.f39697b = r8
            r0.f39700e = r4
            java.lang.Object r10 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r9, r2, r0, r6, r5)
            if (r10 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r9 = r7
        L_0x0070:
            com.sumsub.sns.internal.core.data.model.e r10 = (com.sumsub.sns.internal.core.data.model.e) r10
            r0.f39696a = r5
            r0.f39697b = r5
            r0.f39700e = r3
            java.lang.Object r8 = r9.a((com.sumsub.sns.internal.core.data.model.g) r8, (com.sumsub.sns.internal.core.data.model.e) r10, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x007f
            return r1
        L_0x007f:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        L_0x0082:
            com.sumsub.sns.core.data.model.FlowType r10 = com.sumsub.sns.core.data.model.FlowType.Module
            if (r9 != r10) goto L_0x0089
            r7.a((com.sumsub.sns.internal.core.data.model.g) r8)
        L_0x0089:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.a(com.sumsub.sns.internal.core.data.model.g, com.sumsub.sns.core.data.model.FlowType, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.sumsub.sns.internal.core.data.model.g r6, kotlin.coroutines.c<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.presentation.screen.d.n
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.presentation.screen.d$n r0 = (com.sumsub.sns.presentation.screen.d.n) r0
            int r1 = r0.f39721c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39721c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.d$n r0 = new com.sumsub.sns.presentation.screen.d$n
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f39719a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f39721c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.k.b(r7)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.k.b(r7)
            com.sumsub.sns.internal.core.data.model.b r6 = r6.r()
            if (r6 != 0) goto L_0x0061
            r0.f39721c = r4
            java.lang.Object r7 = r5.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r0)
            if (r7 != r1) goto L_0x0044
            return r1
        L_0x0044:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7
            java.util.List r6 = r7.c()
            if (r6 == 0) goto L_0x0051
            int r6 = r6.size()
            goto L_0x0052
        L_0x0051:
            r6 = r3
        L_0x0052:
            if (r6 <= r4) goto L_0x0061
            com.sumsub.sns.internal.ff.a r6 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r6 = r6.x()
            boolean r6 = r6.g()
            if (r6 != 0) goto L_0x0061
            r3 = r4
        L_0x0061:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.b(com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(com.sumsub.sns.internal.core.data.model.g gVar) {
        if (gVar.r() != null || com.sumsub.sns.internal.ff.a.f34215a.x().g()) {
            a(this, false, 1, (Object) null);
        } else {
            a((a.j) b.d.a.f39585c);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: com.sumsub.sns.internal.core.data.model.e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.g r10, com.sumsub.sns.internal.core.data.model.e r11, kotlin.coroutines.c<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.presentation.screen.d.i
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.presentation.screen.d$i r0 = (com.sumsub.sns.presentation.screen.d.i) r0
            int r1 = r0.f39695e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39695e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.d$i r0 = new com.sumsub.sns.presentation.screen.d$i
            r0.<init>(r9, r12)
        L_0x0018:
            r4 = r0
            java.lang.Object r12 = r4.f39693c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f39695e
            r7 = 0
            r2 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0047
            if (r1 == r8) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            java.lang.Object r10 = r4.f39691a
            com.sumsub.sns.presentation.screen.d r10 = (com.sumsub.sns.presentation.screen.d) r10
            kotlin.k.b(r12)
            goto L_0x0089
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            java.lang.Object r10 = r4.f39692b
            r11 = r10
            com.sumsub.sns.internal.core.data.model.e r11 = (com.sumsub.sns.internal.core.data.model.e) r11
            java.lang.Object r10 = r4.f39691a
            com.sumsub.sns.presentation.screen.d r10 = (com.sumsub.sns.presentation.screen.d) r10
            kotlin.k.b(r12)
            goto L_0x0058
        L_0x0047:
            kotlin.k.b(r12)
            r4.f39691a = r9
            r4.f39692b = r11
            r4.f39695e = r8
            java.lang.Object r12 = r9.a((com.sumsub.sns.internal.core.data.model.g) r10, (kotlin.coroutines.c<? super java.lang.Boolean>) r4)
            if (r12 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r10 = r9
        L_0x0058:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x0068
            com.sumsub.sns.presentation.screen.b$d$a r11 = com.sumsub.sns.presentation.screen.b.d.a.f39585c
            r10.a((com.sumsub.sns.core.presentation.base.a.j) r11)
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x0068:
            if (r11 == 0) goto L_0x00b5
            com.sumsub.sns.internal.core.data.model.e$a r11 = r11.r()
            if (r11 == 0) goto L_0x00ad
            java.lang.String r11 = r11.c()
            if (r11 == 0) goto L_0x00ad
            com.sumsub.sns.internal.core.data.source.common.a r1 = r10.f39609u
            r4.f39691a = r10
            r4.f39692b = r7
            r4.f39695e = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r11
            java.lang.Object r12 = com.sumsub.sns.internal.core.data.source.common.d.b(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L_0x0089
            return r0
        L_0x0089:
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            r10.b((com.sumsub.sns.internal.core.data.model.g) r12)
            com.sumsub.sns.internal.core.data.model.g$c r11 = r12.I()
            java.util.List r11 = r11.g()
            java.lang.Object r11 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r11)
            com.sumsub.sns.internal.core.data.model.g$c$a r11 = (com.sumsub.sns.internal.core.data.model.g.c.a) r11
            if (r11 == 0) goto L_0x00a5
            r11 = 0
            a((com.sumsub.sns.presentation.screen.d) r10, (boolean) r11, (int) r8, (java.lang.Object) r7)
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x00a5:
            java.security.InvalidParameterException r10 = new java.security.InvalidParameterException
            java.lang.String r11 = "No doc set item found"
            r10.<init>(r11)
            throw r10
        L_0x00ad:
            java.security.InvalidParameterException r10 = new java.security.InvalidParameterException
            java.lang.String r11 = "ActionId is not found"
            r10.<init>(r11)
            throw r10
        L_0x00b5:
            java.security.InvalidParameterException r10 = new java.security.InvalidParameterException
            java.lang.String r11 = "Config for action is null"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.a(com.sumsub.sns.internal.core.data.model.g, com.sumsub.sns.internal.core.data.model.e, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.g r21, kotlin.coroutines.c<? super java.lang.Boolean> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            boolean r2 = r1 instanceof com.sumsub.sns.presentation.screen.d.g
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.presentation.screen.d$g r2 = (com.sumsub.sns.presentation.screen.d.g) r2
            int r3 = r2.f39671g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f39671g = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.presentation.screen.d$g r2 = new com.sumsub.sns.presentation.screen.d$g
            r2.<init>(r0, r1)
        L_0x001c:
            r8 = r2
            java.lang.Object r1 = r8.f39669e
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r8.f39671g
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 0
            r9 = 1
            if (r3 == 0) goto L_0x0067
            if (r3 == r9) goto L_0x005a
            if (r3 == r5) goto L_0x0045
            if (r3 != r4) goto L_0x003d
            kotlin.k.b(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r1 = r1.m3081unboximpl()
            goto L_0x016e
        L_0x003d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0045:
            java.lang.Object r3 = r8.f39668d
            com.sumsub.sns.internal.core.data.model.b r3 = (com.sumsub.sns.internal.core.data.model.b) r3
            java.lang.Object r5 = r8.f39667c
            com.sumsub.sns.internal.core.data.model.g r5 = (com.sumsub.sns.internal.core.data.model.g) r5
            java.lang.Object r10 = r8.f39666b
            com.sumsub.sns.internal.core.data.model.b r10 = (com.sumsub.sns.internal.core.data.model.b) r10
            java.lang.Object r11 = r8.f39665a
            com.sumsub.sns.presentation.screen.d r11 = (com.sumsub.sns.presentation.screen.d) r11
            kotlin.k.b(r1)
            goto L_0x00c8
        L_0x005a:
            java.lang.Object r3 = r8.f39666b
            com.sumsub.sns.internal.core.data.model.b r3 = (com.sumsub.sns.internal.core.data.model.b) r3
            java.lang.Object r10 = r8.f39665a
            com.sumsub.sns.presentation.screen.d r10 = (com.sumsub.sns.presentation.screen.d) r10
            kotlin.k.b(r1)
            r11 = r10
            goto L_0x008f
        L_0x0067:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.ff.a r1 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r1 = r1.x()
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x007b
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r9)
            return r1
        L_0x007b:
            com.sumsub.sns.internal.core.data.model.b r3 = r21.r()
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r0.f39611w
            r8.f39665a = r0
            r8.f39666b = r3
            r8.f39671g = r9
            java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r1, r7, r8, r9, r6)
            if (r1 != r2) goto L_0x008e
            return r2
        L_0x008e:
            r11 = r0
        L_0x008f:
            com.sumsub.sns.internal.core.data.source.dynamic.e r1 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r1
            java.lang.Object r1 = r1.d()
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            if (r1 != 0) goto L_0x009e
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            return r1
        L_0x009e:
            com.sumsub.sns.internal.core.data.model.b r10 = r1.r()
            if (r3 != 0) goto L_0x00ab
            if (r10 != 0) goto L_0x00ab
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            return r1
        L_0x00ab:
            com.sumsub.sns.internal.core.data.source.dynamic.b r12 = r11.f39611w
            r8.f39665a = r11
            r8.f39666b = r3
            r8.f39667c = r1
            r8.f39668d = r10
            r8.f39671g = r5
            java.lang.Object r5 = r12.d(r8)
            if (r5 != r2) goto L_0x00be
            return r2
        L_0x00be:
            r18 = r5
            r5 = r1
            r1 = r18
            r19 = r10
            r10 = r3
            r3 = r19
        L_0x00c8:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r1 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r1
            java.util.List r1 = r1.c()
            if (r1 != 0) goto L_0x00d5
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r9)
            return r1
        L_0x00d5:
            if (r3 == 0) goto L_0x0106
            boolean r12 = r1.isEmpty()
            if (r12 == 0) goto L_0x00de
            goto L_0x0101
        L_0x00de:
            java.util.Iterator r12 = r1.iterator()
        L_0x00e2:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0101
            java.lang.Object r13 = r12.next()
            com.sumsub.sns.internal.core.data.model.d r13 = (com.sumsub.sns.internal.core.data.model.d) r13
            com.sumsub.sns.internal.core.data.model.b r13 = r13.c()
            if (r13 == 0) goto L_0x00fc
            boolean r13 = r13.a(r3)
            if (r13 != r9) goto L_0x00fc
            r13 = r9
            goto L_0x00fd
        L_0x00fc:
            r13 = r7
        L_0x00fd:
            if (r13 == 0) goto L_0x00e2
            r12 = r9
            goto L_0x0102
        L_0x0101:
            r12 = r7
        L_0x0102:
            if (r12 == 0) goto L_0x0106
            r12 = r9
            goto L_0x0107
        L_0x0106:
            r12 = r7
        L_0x0107:
            if (r12 == 0) goto L_0x010e
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r9)
            return r1
        L_0x010e:
            if (r3 == 0) goto L_0x0115
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            return r1
        L_0x0115:
            if (r10 != 0) goto L_0x011c
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            return r1
        L_0x011c:
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x0123
            goto L_0x0145
        L_0x0123:
            java.util.Iterator r1 = r1.iterator()
        L_0x0127:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0145
            java.lang.Object r3 = r1.next()
            com.sumsub.sns.internal.core.data.model.d r3 = (com.sumsub.sns.internal.core.data.model.d) r3
            com.sumsub.sns.internal.core.data.model.b r3 = r3.c()
            if (r3 == 0) goto L_0x0141
            boolean r3 = r3.a(r10)
            if (r3 != r9) goto L_0x0141
            r3 = r9
            goto L_0x0142
        L_0x0141:
            r3 = r7
        L_0x0142:
            if (r3 == 0) goto L_0x0127
            goto L_0x0146
        L_0x0145:
            r9 = r7
        L_0x0146:
            if (r9 == 0) goto L_0x0177
            com.sumsub.sns.core.c r12 = com.sumsub.sns.core.c.f30748a
            r15 = 0
            r16 = 4
            r17 = 0
            java.lang.String r13 = "SNSAppViewModel"
            java.lang.String r14 = "updating the action agreement from applicant"
            com.sumsub.sns.core.c.b(r12, r13, r14, r15, r16, r17)
            com.sumsub.sns.internal.core.domain.p r3 = r11.f39608t
            com.sumsub.sns.internal.core.data.source.applicant.b r1 = r11.f39612x
            r8.f39665a = r6
            r8.f39666b = r6
            r8.f39667c = r6
            r8.f39668d = r6
            r8.f39671g = r4
            r7 = 1
            r4 = r1
            r6 = r10
            java.lang.Object r1 = r3.a(r4, r5, r6, r7, r8)
            if (r1 != r2) goto L_0x016e
            return r2
        L_0x016e:
            boolean r1 = kotlin.Result.m3079isSuccessimpl(r1)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r1)
            return r1
        L_0x0177:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.a(com.sumsub.sns.internal.core.data.model.g, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object a(com.sumsub.sns.internal.core.data.model.g gVar, List<Document> list, boolean z11, kotlin.coroutines.c<? super Unit> cVar) {
        Document b11 = g.b(list, gVar);
        if (b11 == null || kotlin.jvm.internal.x.b(this.E, b11)) {
            d(false);
            if (g.a(list, gVar) != null) {
                com.sumsub.sns.core.c cVar2 = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.b(cVar2, P, "moveToNextStep: applicantStatus=" + gVar.J().p(), (Throwable) null, 4, (Object) null);
                if (z11) {
                    a(com.sumsub.sns.internal.core.common.i.a(list, gVar));
                } else {
                    a((a.j) b.d.c.f39587c);
                }
                return Unit.f56620a;
            }
            Object a11 = a(false, cVar);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
        }
        d(false);
        a(gVar, b11);
        a(b11);
        return Unit.f56620a;
    }

    public final void a(List<Document> list) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "startVideoIdentification: docs " + list.size(), (Throwable) null, 4, (Object) null);
        if (u0.b()) {
            a((a.j) new b.d.o(list));
            return;
        }
        g(false);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new Exception("VideoIdent not available"), DocumentType.f32356k, (Object) null, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r14, kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.presentation.screen.d.z
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.presentation.screen.d$z r0 = (com.sumsub.sns.presentation.screen.d.z) r0
            int r1 = r0.f39767e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39767e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.d$z r0 = new com.sumsub.sns.presentation.screen.d$z
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f39765c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f39767e
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            kotlin.k.b(r15)
            goto L_0x00af
        L_0x002f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0037:
            boolean r14 = r0.f39764b
            java.lang.Object r2 = r0.f39763a
            com.sumsub.sns.presentation.screen.d r2 = (com.sumsub.sns.presentation.screen.d) r2
            kotlin.k.b(r15)
            goto L_0x006f
        L_0x0041:
            kotlin.k.b(r15)
            com.sumsub.sns.core.c r7 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "onStepComplete, isCancelled="
            r15.append(r2)
            r15.append(r14)
            java.lang.String r9 = r15.toString()
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "SNSAppViewModel"
            com.sumsub.sns.core.c.b(r7, r8, r9, r10, r11, r12)
            com.sumsub.sns.internal.core.data.source.dynamic.b r15 = r13.f39611w
            r0.f39763a = r13
            r0.f39764b = r14
            r0.f39767e = r5
            java.lang.Object r15 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r15, r3, r0, r5, r6)
            if (r15 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r2 = r13
        L_0x006f:
            com.sumsub.sns.internal.core.data.source.dynamic.e r15 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r15
            java.lang.Throwable r7 = r15.a()
            if (r7 == 0) goto L_0x007d
            r2.b((java.lang.Throwable) r7)
            kotlin.Unit r14 = kotlin.Unit.f56620a
            return r14
        L_0x007d:
            java.lang.Object r15 = r15.d()
            com.sumsub.sns.internal.core.data.model.e r15 = (com.sumsub.sns.internal.core.data.model.e) r15
            if (r15 == 0) goto L_0x008a
            com.sumsub.sns.core.data.model.FlowType r15 = r15.y()
            goto L_0x008b
        L_0x008a:
            r15 = r6
        L_0x008b:
            if (r15 != 0) goto L_0x008f
            r15 = -1
            goto L_0x0097
        L_0x008f:
            int[] r7 = com.sumsub.sns.presentation.screen.d.e.f39655a
            int r15 = r15.ordinal()
            r15 = r7[r15]
        L_0x0097:
            if (r15 != r5) goto L_0x00a4
            com.sumsub.sns.core.data.model.SNSCompletionResult$SuccessTermination r14 = new com.sumsub.sns.core.data.model.SNSCompletionResult$SuccessTermination
            r14.<init>(r6, r5, r6)
            a((com.sumsub.sns.presentation.screen.d) r2, (com.sumsub.sns.core.data.model.SNSCompletionResult) r14, (boolean) r3, (int) r4, (java.lang.Object) r6)
            kotlin.Unit r14 = kotlin.Unit.f56620a
            return r14
        L_0x00a4:
            r0.f39763a = r6
            r0.f39767e = r4
            java.lang.Object r14 = r2.b((boolean) r14, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r14 != r1) goto L_0x00af
            return r1
        L_0x00af:
            kotlin.Unit r14 = kotlin.Unit.f56620a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.a(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(Document document) {
        c(document);
        a((SNSEvent) new SNSEvent.SNSEventStepInitiated(this.f39610v.a(), document.getType().c()));
    }

    public final void a(SNSEvent sNSEvent) {
        try {
            SNSEventHandler eventHandler = SNSMobileSDK.INSTANCE.getEventHandler();
            if (eventHandler != null) {
                eventHandler.onEvent(sNSEvent);
            }
        } catch (Throwable th2) {
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            cVar.a(P, "Can't fire sns event " + sNSEvent, th2);
        }
    }

    public final void a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, boolean z11) {
        f(true);
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, P, "waiting for possible level change ...", (Throwable) null, 4, (Object) null);
        a((a.j) b.f.f39603a);
        this.f39614z = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new b0(this, gVar, eVar, z11, (kotlin.coroutines.c<? super b0>) null), 3, (Object) null);
    }

    public final boolean a(com.sumsub.sns.internal.core.data.model.g gVar, List<Document> list, boolean z11) {
        List<Document> a11 = g.a(list, gVar);
        if (a11 != null) {
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            com.sumsub.sns.core.c.b(cVar, P, "resolveApplicantStatusWithVideoIdent: applicantStatus=" + gVar.J().p() + ", unsubmitted docs=" + a11.size(), (Throwable) null, 4, (Object) null);
            if (gVar.J().p() == ReviewStatusType.Pending || gVar.J().p() == ReviewStatusType.Queued) {
                if (z11 && !gVar.A()) {
                    a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
                    return true;
                } else if (gVar.A() || a(gVar, list)) {
                    a((a.j) b.d.c.f39587c);
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, boolean z11, boolean z12) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, P, "resolveNextScreenByApplicantStatus: status=" + gVar.K() + ", isCancelled=" + z12, (Throwable) null, 4, (Object) null);
        this.F = true;
        ReviewStatusType K2 = gVar.K();
        ReviewStatusType reviewStatusType = ReviewStatusType.Init;
        if (K2 != reviewStatusType || !com.sumsub.sns.internal.core.data.model.f.f(eVar) || !z11 || gVar.A()) {
            if (gVar.K() == reviewStatusType && com.sumsub.sns.internal.core.data.model.f.d(eVar) && !z11) {
                a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
            } else if (gVar.K() == ReviewStatusType.Pending && com.sumsub.sns.internal.core.data.model.f.d(eVar)) {
                a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
            } else if (gVar.K() == ReviewStatusType.Prechecked && com.sumsub.sns.internal.core.data.model.f.d(eVar)) {
                a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
            } else if (gVar.O() && com.sumsub.sns.internal.core.data.model.f.b(eVar)) {
                a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
            } else if (!gVar.P() || !com.sumsub.sns.internal.core.data.model.f.h(eVar)) {
                a((a.j) b.d.c.f39587c);
            } else if (!z11 || z12) {
                a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
            } else {
                e(true);
            }
        } else if (z12) {
            a(this, (SNSCompletionResult) new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (kotlin.jvm.internal.r) null), false, 2, (Object) null);
        } else {
            a(this, false, 1, (Object) null);
        }
    }

    public final void a(long j11) {
        this.f39613y = j11;
    }

    public final void a(d10.p<? super kotlinx.coroutines.h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar) {
        f(true);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new k(pVar, this, (kotlin.coroutines.c<? super k>) null), 3, (Object) null);
    }

    public final void a(boolean z11, boolean z12) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new t(this, DocumentType.f32355j, (kotlin.coroutines.c) null, z11, this, z12), 3, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if ((r5 != null && r5.contains(r4.getType().c())) == false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.sumsub.sns.internal.core.data.model.g r7, java.util.List<com.sumsub.sns.internal.core.data.model.Document> r8) {
        /*
            r6 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x000d:
            boolean r2 = r8.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r8.next()
            r4 = r2
            com.sumsub.sns.internal.core.data.model.Document r4 = (com.sumsub.sns.internal.core.data.model.Document) r4
            com.sumsub.sns.internal.core.data.model.g$c r5 = r7.I()
            boolean r5 = r5.k()
            if (r5 == 0) goto L_0x0043
            com.sumsub.sns.internal.core.data.model.g$c r5 = r7.I()
            java.util.List r5 = r5.j()
            if (r5 == 0) goto L_0x003f
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r4.getType()
            java.lang.String r4 = r4.c()
            boolean r4 = r5.contains(r4)
            if (r4 != r3) goto L_0x003f
            r4 = r3
            goto L_0x0040
        L_0x003f:
            r4 = r0
        L_0x0040:
            if (r4 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r3 = r0
        L_0x0044:
            if (r3 == 0) goto L_0x000d
            r1.add(r2)
            goto L_0x000d
        L_0x004a:
            boolean r7 = r1.isEmpty()
            if (r7 == 0) goto L_0x0051
            goto L_0x0068
        L_0x0051:
            java.util.Iterator r7 = r1.iterator()
        L_0x0055:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0068
            java.lang.Object r8 = r7.next()
            com.sumsub.sns.internal.core.data.model.Document r8 = (com.sumsub.sns.internal.core.data.model.Document) r8
            boolean r8 = r8.isRejected()
            if (r8 == 0) goto L_0x0055
            r0 = r3
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.d.a(com.sumsub.sns.internal.core.data.model.g, java.util.List):boolean");
    }

    public final void a(com.sumsub.sns.internal.core.common.q qVar, long j11) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new h(this, DocumentType.f32355j, (kotlin.coroutines.c) null, j11, qVar, this), 3, (Object) null);
    }
}
