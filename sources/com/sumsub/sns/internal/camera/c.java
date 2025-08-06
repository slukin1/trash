package com.sumsub.sns.internal.camera;

import android.util.Size;
import androidx.camera.video.v;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.analytics.GlobalStatePayload;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import com.sumsub.sns.internal.core.presentation.helper.camera.b;
import d10.p;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public abstract class c extends com.sumsub.sns.core.presentation.base.a<b> {

    /* renamed from: q  reason: collision with root package name */
    public final DocumentType f31353q;

    /* renamed from: r  reason: collision with root package name */
    public final String f31354r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f31355s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f31356t;

    /* renamed from: u  reason: collision with root package name */
    public final Size f31357u = new Size(1920, 1080);

    /* renamed from: v  reason: collision with root package name */
    public final CameraX.b f31358v = new CameraX.b(0, (v) null, (v) null, 0, 0, 31, (r) null);

    /* renamed from: w  reason: collision with root package name */
    public IdentitySide f31359w;

    public static abstract class a implements a.j {

        /* renamed from: com.sumsub.sns.internal.camera.c$a$a  reason: collision with other inner class name */
        public static final class C0302a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final String f31360a;

            public C0302a(String str) {
                super((r) null);
                this.f31360a = str;
            }

            public final String a() {
                return this.f31360a;
            }

            public final String b() {
                return this.f31360a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0302a) && x.b(this.f31360a, ((C0302a) obj).f31360a);
            }

            public int hashCode() {
                return this.f31360a.hashCode();
            }

            public String toString() {
                return "TakePicture(filePrefix=" + this.f31360a + ')';
            }

            public final C0302a a(String str) {
                return new C0302a(str);
            }

            public static /* synthetic */ C0302a a(C0302a aVar, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = aVar.f31360a;
                }
                return aVar.a(str);
            }
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f31361a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31362b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f31363c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f31364d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f31365e;

        /* renamed from: f  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.presentation.helper.camera.b f31366f;

        public b() {
            this(false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 63, (r) null);
        }

        public final boolean a() {
            return this.f31361a;
        }

        public final boolean b() {
            return this.f31362b;
        }

        public final boolean c() {
            return this.f31363c;
        }

        public final boolean d() {
            return this.f31364d;
        }

        public final boolean e() {
            return this.f31365e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f31361a == bVar.f31361a && this.f31362b == bVar.f31362b && this.f31363c == bVar.f31363c && this.f31364d == bVar.f31364d && this.f31365e == bVar.f31365e && x.b(this.f31366f, bVar.f31366f);
        }

        public final com.sumsub.sns.internal.core.presentation.helper.camera.b f() {
            return this.f31366f;
        }

        public final boolean g() {
            return this.f31362b;
        }

        public final boolean h() {
            return this.f31365e;
        }

        public int hashCode() {
            boolean z11 = this.f31361a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            boolean z13 = this.f31362b;
            if (z13) {
                z13 = true;
            }
            int i12 = (i11 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.f31363c;
            if (z14) {
                z14 = true;
            }
            int i13 = (i12 + (z14 ? 1 : 0)) * 31;
            boolean z15 = this.f31364d;
            if (z15) {
                z15 = true;
            }
            int i14 = (i13 + (z15 ? 1 : 0)) * 31;
            boolean z16 = this.f31365e;
            if (!z16) {
                z12 = z16;
            }
            int i15 = (i14 + (z12 ? 1 : 0)) * 31;
            com.sumsub.sns.internal.core.presentation.helper.camera.b bVar = this.f31366f;
            return i15 + (bVar == null ? 0 : bVar.hashCode());
        }

        public final com.sumsub.sns.internal.core.presentation.helper.camera.b i() {
            return this.f31366f;
        }

        public final boolean j() {
            return this.f31361a;
        }

        public final boolean k() {
            return this.f31363c;
        }

        public final boolean l() {
            return this.f31364d;
        }

        public String toString() {
            return "ViewState(showCamera=" + this.f31361a + ", enableTakePicture=" + this.f31362b + ", showTakePicture=" + this.f31363c + ", showTakePictureProgress=" + this.f31364d + ", flash=" + this.f31365e + ", helperState=" + this.f31366f + ')';
        }

        public b(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, com.sumsub.sns.internal.core.presentation.helper.camera.b bVar) {
            this.f31361a = z11;
            this.f31362b = z12;
            this.f31363c = z13;
            this.f31364d = z14;
            this.f31365e = z15;
            this.f31366f = bVar;
        }

        public final b a(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, com.sumsub.sns.internal.core.presentation.helper.camera.b bVar) {
            return new b(z11, z12, z13, z14, z15, bVar);
        }

        public static /* synthetic */ b a(b bVar, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, com.sumsub.sns.internal.core.presentation.helper.camera.b bVar2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = bVar.f31361a;
            }
            if ((i11 & 2) != 0) {
                z12 = bVar.f31362b;
            }
            boolean z16 = z12;
            if ((i11 & 4) != 0) {
                z13 = bVar.f31363c;
            }
            boolean z17 = z13;
            if ((i11 & 8) != 0) {
                z14 = bVar.f31364d;
            }
            boolean z18 = z14;
            if ((i11 & 16) != 0) {
                z15 = bVar.f31365e;
            }
            boolean z19 = z15;
            if ((i11 & 32) != 0) {
                bVar2 = bVar.f31366f;
            }
            return bVar.a(z11, z16, z17, z18, z19, bVar2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ b(boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, com.sumsub.sns.internal.core.presentation.helper.camera.b r10, int r11, kotlin.jvm.internal.r r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                r0 = 1
                if (r12 == 0) goto L_0x0007
                r12 = r0
                goto L_0x0008
            L_0x0007:
                r12 = r5
            L_0x0008:
                r5 = r11 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r11 & 4
                if (r5 == 0) goto L_0x0014
                goto L_0x0015
            L_0x0014:
                r0 = r7
            L_0x0015:
                r5 = r11 & 8
                r6 = 0
                if (r5 == 0) goto L_0x001c
                r2 = r6
                goto L_0x001d
            L_0x001c:
                r2 = r8
            L_0x001d:
                r5 = r11 & 16
                if (r5 == 0) goto L_0x0023
                r3 = r6
                goto L_0x0024
            L_0x0023:
                r3 = r9
            L_0x0024:
                r5 = r11 & 32
                if (r5 == 0) goto L_0x0029
                r10 = 0
            L_0x0029:
                r11 = r10
                r5 = r4
                r6 = r12
                r7 = r1
                r8 = r0
                r9 = r2
                r10 = r3
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.c.b.<init>(boolean, boolean, boolean, boolean, boolean, com.sumsub.sns.internal.core.presentation.helper.camera.b, int, kotlin.jvm.internal.r):void");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel$currentSide$1", f = "SNSCameraViewModel.kt", l = {49}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.camera.c$c  reason: collision with other inner class name */
    public static final class C0303c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f31368b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0303c(c cVar, kotlin.coroutines.c<? super C0303c> cVar2) {
            super(2, cVar2);
            this.f31368b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0303c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new C0303c(this.f31368b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31367a;
            if (i11 == 0) {
                k.b(obj);
                c cVar = this.f31368b;
                this.f31367a = 1;
                if (cVar.e(this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel$onCameraPermissionDenied$1", f = "SNSCameraViewModel.kt", l = {150, 151, 152}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31369a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31370b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31371c;

        /* renamed from: d  reason: collision with root package name */
        public int f31372d;

        /* renamed from: e  reason: collision with root package name */
        public int f31373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f31374f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar, kotlin.coroutines.c<? super d> cVar2) {
            super(2, cVar2);
            this.f31374f = cVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f31374f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f31373e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0047
                if (r1 == r4) goto L_0x003d
                if (r1 == r3) goto L_0x002f
                if (r1 != r2) goto L_0x0027
                int r0 = r9.f31372d
                java.lang.Object r1 = r9.f31371c
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r9.f31370b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r9.f31369a
                com.sumsub.sns.internal.camera.c r3 = (com.sumsub.sns.internal.camera.c) r3
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
                int r1 = r9.f31372d
                java.lang.Object r3 = r9.f31370b
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r9.f31369a
                com.sumsub.sns.internal.camera.c r4 = (com.sumsub.sns.internal.camera.c) r4
                kotlin.k.b(r10)
                goto L_0x0077
            L_0x003d:
                int r1 = r9.f31372d
                java.lang.Object r4 = r9.f31369a
                com.sumsub.sns.internal.camera.c r4 = (com.sumsub.sns.internal.camera.c) r4
                kotlin.k.b(r10)
                goto L_0x005f
            L_0x0047:
                kotlin.k.b(r10)
                com.sumsub.sns.internal.camera.c r10 = r9.f31374f
                r1 = 0
                r9.f31369a = r10
                r9.f31372d = r1
                r9.f31373e = r4
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
                com.sumsub.sns.internal.camera.c r5 = r9.f31374f
                r9.f31369a = r4
                r9.f31370b = r10
                r9.f31372d = r1
                r9.f31373e = r3
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
                com.sumsub.sns.internal.camera.c r5 = r9.f31374f
                r9.f31369a = r4
                r9.f31370b = r3
                r9.f31371c = r10
                r9.f31372d = r1
                r9.f31373e = r2
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
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.c.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel$onPictureTaken$1", f = "SNSCameraViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<b, kotlin.coroutines.c<? super b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31375a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31376b;

        public e(kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(b bVar, kotlin.coroutines.c<? super b> cVar) {
            return ((e) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(cVar);
            eVar.f31376b = obj;
            return eVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31375a == 0) {
                k.b(obj);
                return b.a((b) this.f31376b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 61, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel", f = "SNSCameraViewModel.kt", l = {56, 60}, m = "onPrepare$suspendImpl")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31377a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31378b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f31379c;

        /* renamed from: d  reason: collision with root package name */
        public int f31380d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(c cVar, kotlin.coroutines.c<? super f> cVar2) {
            super(cVar2);
            this.f31379c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31378b = obj;
            this.f31380d |= Integer.MIN_VALUE;
            return c.b(this.f31379c, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel$onTakePictureClicked$1", f = "SNSCameraViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<b, kotlin.coroutines.c<? super b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31381a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31382b;

        public g(kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(b bVar, kotlin.coroutines.c<? super b> cVar) {
            return ((g) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            g gVar = new g(cVar);
            gVar.f31382b = obj;
            return gVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31381a == 0) {
                k.b(obj);
                return b.a((b) this.f31382b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 61, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel$onToggleFlashClicked$1", f = "SNSCameraViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<b, kotlin.coroutines.c<? super b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31383a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31384b;

        public h(kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(b bVar, kotlin.coroutines.c<? super b> cVar) {
            return ((h) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            h hVar = new h(cVar);
            hVar.f31384b = obj;
            return hVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31383a == 0) {
                k.b(obj);
                b bVar = (b) this.f31384b;
                return b.a(bVar, false, false, false, false, !bVar.h(), (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 47, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel", f = "SNSCameraViewModel.kt", l = {65}, m = "updateInstructions")
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31385a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31386b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f31387c;

        /* renamed from: d  reason: collision with root package name */
        public int f31388d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(c cVar, kotlin.coroutines.c<? super i> cVar2) {
            super(cVar2);
            this.f31387c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31386b = obj;
            this.f31388d |= Integer.MIN_VALUE;
            return this.f31387c.e(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.SNSCameraViewModel$updateInstructions$3", f = "SNSCameraViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements p<b, kotlin.coroutines.c<? super b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31389a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f31391c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f31392d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f31393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.g f31394f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(c cVar, String str, String str2, com.sumsub.sns.internal.core.data.model.g gVar, kotlin.coroutines.c<? super j> cVar2) {
            super(2, cVar2);
            this.f31391c = cVar;
            this.f31392d = str;
            this.f31393e = str2;
            this.f31394f = gVar;
        }

        /* renamed from: a */
        public final Object invoke(b bVar, kotlin.coroutines.c<? super b> cVar) {
            return ((j) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            j jVar = new j(this.f31391c, this.f31392d, this.f31393e, this.f31394f, cVar);
            jVar.f31390b = obj;
            return jVar;
        }

        public final Object invokeSuspend(Object obj) {
            com.sumsub.sns.internal.core.presentation.helper.camera.b bVar;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31389a == 0) {
                k.b(obj);
                b bVar2 = (b) this.f31390b;
                com.sumsub.sns.internal.core.data.model.e a11 = this.f31391c.d();
                boolean z11 = false;
                if (a11 != null) {
                    String str = this.f31392d;
                    if (this.f31391c.q() == IdentitySide.Back) {
                        z11 = true;
                    }
                    z11 = com.sumsub.sns.internal.core.data.model.f.a(a11, str, z11);
                }
                b.c b11 = this.f31391c.h();
                com.sumsub.sns.internal.core.data.model.e a12 = this.f31391c.d();
                com.sumsub.sns.internal.core.presentation.intro.b bVar3 = new com.sumsub.sns.internal.core.presentation.intro.b(b11, a12 != null ? a12.C() : null, this.f31392d, this.f31391c.s(), this.f31393e, false, 32, (r) null);
                com.sumsub.sns.internal.core.presentation.intro.f fVar = new com.sumsub.sns.internal.core.presentation.intro.f(this.f31392d, this.f31393e, this.f31391c.s());
                String a13 = this.f31391c.p().a();
                if (a13 == null) {
                    a13 = this.f31394f.u();
                }
                if (!z11 || !bVar3.f()) {
                    bVar = this.f31391c.a(this.f31394f, fVar, a13);
                } else {
                    bVar = this.f31391c.a(fVar, (Map<String, ? extends Object>) bVar3.c(), a13);
                }
                return b.a(bVar2, false, false, false, false, false, bVar, 31, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public c(DocumentType documentType, String str, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        this.f31353q = documentType;
        this.f31354r = str;
        this.f31355s = aVar;
        this.f31356t = bVar;
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        return b(this, cVar);
    }

    public final com.sumsub.sns.internal.core.data.source.common.a p() {
        return this.f31355s;
    }

    public final IdentitySide q() {
        return this.f31359w;
    }

    /* renamed from: r */
    public b e() {
        return new b(false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 63, (r) null);
    }

    public final String s() {
        return this.f31354r;
    }

    public Size t() {
        return this.f31357u;
    }

    public final DocumentType u() {
        return this.f31353q;
    }

    public CameraX.b v() {
        return this.f31358v;
    }

    public final void w() {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new d(this, (kotlin.coroutines.c<? super d>) null), 3, (Object) null);
    }

    public void x() {
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "On take picture is clicked", (Throwable) null, 4, (Object) null);
        a((a.j) new a.C0302a("manual_"));
        com.sumsub.sns.core.presentation.base.a.a(this, false, new g((kotlin.coroutines.c<? super g>) null), 1, (Object) null);
    }

    public final void y() {
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a, DocCapture.f31492c, "On Toggle Flash is clicked", (Throwable) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new h((kotlin.coroutines.c<? super h>) null), 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object b(com.sumsub.sns.internal.camera.c r10, kotlin.coroutines.c r11) {
        /*
            boolean r0 = r11 instanceof com.sumsub.sns.internal.camera.c.f
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.camera.c$f r0 = (com.sumsub.sns.internal.camera.c.f) r0
            int r1 = r0.f31380d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31380d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.c$f r0 = new com.sumsub.sns.internal.camera.c$f
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f31378b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31380d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r11)
            goto L_0x0082
        L_0x002c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0034:
            java.lang.Object r10 = r0.f31377a
            com.sumsub.sns.internal.camera.c r10 = (com.sumsub.sns.internal.camera.c) r10
            kotlin.k.b(r11)
            goto L_0x004a
        L_0x003c:
            kotlin.k.b(r11)
            r0.f31377a = r10
            r0.f31380d = r4
            java.lang.Object r11 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r11 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "Camera is started. Side - "
            r11.append(r2)
            com.sumsub.sns.internal.core.data.model.IdentitySide r2 = r10.f31359w
            r11.append(r2)
            java.lang.String r6 = r11.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            com.sumsub.log.logger.a.c(r4, r5, r6, r7, r8, r9)
            com.sumsub.sns.internal.core.analytics.b r11 = com.sumsub.sns.internal.core.analytics.b.f31873a
            com.sumsub.sns.internal.core.analytics.GlobalStatePayload r2 = com.sumsub.sns.internal.core.analytics.GlobalStatePayload.IdDocType
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r10.f31353q
            java.lang.String r4 = r4.c()
            r11.a((com.sumsub.sns.internal.core.analytics.GlobalStatePayload) r2, (java.lang.String) r4)
            r11 = 0
            r0.f31377a = r11
            r0.f31380d = r3
            java.lang.Object r10 = r10.e(r0)
            if (r10 != r1) goto L_0x0082
            return r1
        L_0x0082:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.c.b(com.sumsub.sns.internal.camera.c, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.sumsub.sns.internal.camera.c.i
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.camera.c$i r0 = (com.sumsub.sns.internal.camera.c.i) r0
            int r1 = r0.f31388d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31388d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.c$i r0 = new com.sumsub.sns.internal.camera.c$i
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f31386b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31388d
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r5) goto L_0x002f
            java.lang.Object r0 = r0.f31385a
            com.sumsub.sns.internal.camera.c r0 = (com.sumsub.sns.internal.camera.c) r0
            kotlin.k.b(r13)
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0037:
            kotlin.k.b(r13)
            com.sumsub.sns.internal.core.data.model.IdentitySide r13 = r12.f31359w
            if (r13 == 0) goto L_0x004b
            java.lang.String r13 = r13.getValue()
            if (r13 == 0) goto L_0x004b
            com.sumsub.sns.internal.core.analytics.b r2 = com.sumsub.sns.internal.core.analytics.b.f31873a
            com.sumsub.sns.internal.core.analytics.GlobalStatePayload r6 = com.sumsub.sns.internal.core.analytics.GlobalStatePayload.IdDocSubType
            r2.a((com.sumsub.sns.internal.core.analytics.GlobalStatePayload) r6, (java.lang.String) r13)
        L_0x004b:
            com.sumsub.sns.internal.core.data.source.dynamic.b r13 = r12.f31356t
            r0.f31385a = r12
            r0.f31388d = r5
            java.lang.Object r13 = com.sumsub.sns.internal.core.data.source.dynamic.h.d(r13, r4, r0, r5, r3)
            if (r13 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r0 = r12
        L_0x0059:
            r10 = r13
            com.sumsub.sns.internal.core.data.model.g r10 = (com.sumsub.sns.internal.core.data.model.g) r10
            com.sumsub.sns.internal.core.data.model.DocumentType r13 = r0.f31353q
            java.lang.String r8 = r13.c()
            com.sumsub.sns.internal.core.data.model.DocumentType r13 = r0.f31353q
            com.sumsub.sns.internal.core.data.model.g$c$a r13 = r10.a((com.sumsub.sns.internal.core.data.model.DocumentType) r13)
            if (r13 == 0) goto L_0x0072
            boolean r1 = r13.w()
            if (r1 != r5) goto L_0x0072
            r1 = r5
            goto L_0x0073
        L_0x0072:
            r1 = r4
        L_0x0073:
            if (r1 == 0) goto L_0x007d
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r13 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.PHOTOSELFIE
            java.lang.String r13 = r13.getSceneName()
        L_0x007b:
            r9 = r13
            goto L_0x00a5
        L_0x007d:
            if (r13 == 0) goto L_0x0087
            boolean r13 = r13.v()
            if (r13 != r5) goto L_0x0087
            r13 = r5
            goto L_0x0088
        L_0x0087:
            r13 = r4
        L_0x0088:
            if (r13 == 0) goto L_0x0091
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r13 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.PORTRAIT_SELFIE
            java.lang.String r13 = r13.getSceneName()
            goto L_0x007b
        L_0x0091:
            com.sumsub.sns.internal.core.data.model.IdentitySide r13 = r0.f31359w
            com.sumsub.sns.internal.core.data.model.IdentitySide r1 = com.sumsub.sns.internal.core.data.model.IdentitySide.Back
            if (r13 != r1) goto L_0x009e
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r13 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.SCAN_BACKSIDE
            java.lang.String r13 = r13.getSceneName()
            goto L_0x007b
        L_0x009e:
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r13 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.SCAN_FRONTSIDE
            java.lang.String r13 = r13.getSceneName()
            goto L_0x007b
        L_0x00a5:
            com.sumsub.sns.internal.camera.c$j r13 = new com.sumsub.sns.internal.camera.c$j
            r11 = 0
            r6 = r13
            r7 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            com.sumsub.sns.core.presentation.base.a.a(r0, r4, r13, r5, r3)
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.c.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(IdentitySide identitySide) {
        boolean z11 = this.f31359w != identitySide;
        this.f31359w = identitySide;
        if (z11) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "setting current side to " + identitySide, (Throwable) null, 4, (Object) null);
            n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new C0303c(this, (kotlin.coroutines.c<? super C0303c>) null), 3, (Object) null);
        }
    }

    public final com.sumsub.sns.internal.core.presentation.helper.camera.b a(com.sumsub.sns.internal.core.presentation.intro.f fVar, Map<String, ? extends Object> map, String str) {
        return new b.C0380b(fVar, map, str);
    }

    public com.sumsub.sns.internal.core.presentation.helper.camera.b a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.presentation.intro.f fVar, String str) {
        List<q> list;
        String value;
        String str2 = this.f31354r;
        if (str2 == null || (list = CollectionsKt__CollectionsJVMKt.e(q.f32683c.a(str2))) == null) {
            list = gVar.b(this.f31353q);
        }
        List<q> list2 = list;
        IdentitySide identitySide = this.f31359w;
        if (!(identitySide == null || (value = identitySide.getValue()) == null)) {
            com.sumsub.sns.internal.core.analytics.b.f31873a.a(GlobalStatePayload.IdDocSubType, value);
        }
        return com.sumsub.sns.internal.core.presentation.helper.camera.a.f33847a.a(h(), this.f31353q, gVar.a(this.f31353q), fVar, str, list2, this.f31359w);
    }

    public void a(File file) {
        com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Picture is taken", (Throwable) null, 4, (Object) null);
        b(true);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new e((kotlin.coroutines.c<? super e>) null), 1, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) null, (Object) new n(file, file, (String) null, (String) null, this.f31359w, false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (n.b) null, false, 492, (r) null), (Long) null, 5, (Object) null);
    }
}
