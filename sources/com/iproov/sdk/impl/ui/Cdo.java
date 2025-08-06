package com.iproov.sdk.impl.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.o;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.q0;
import androidx.core.view.r0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.v;
import com.iproov.sdk.R;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.CameraPermissionException;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.p016if.Ccatch;
import com.iproov.sdk.p016if.Cinstanceof;
import com.iproov.sdk.p016if.Cprotected;
import com.iproov.sdk.p016if.Csynchronized;
import com.iproov.sdk.p025public.Cfor;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.ui.views.HovalayView;
import com.iproov.sdk.ui.views.ShimmeringImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.youth.banner.config.BannerConfig;
import d10.p;
import d10.q;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.g;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w;

/* renamed from: com.iproov.sdk.impl.ui.do  reason: invalid class name */
public class Cdo extends AppCompatActivity implements h0 {
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public Orientation f740break;
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final b1<Boolean> f741case = k1.a(Boolean.TRUE);
    /* access modifiers changed from: private */

    /* renamed from: catch  reason: not valid java name */
    public Orientation f742catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public com.iproov.sdk.p025public.Cfor f743class;

    /* renamed from: const  reason: not valid java name */
    private Cif f744const;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final w f745do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public final b1<Boolean> f746else = k1.a(Boolean.FALSE);
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public CountDownTimer f747final;

    /* renamed from: for  reason: not valid java name */
    private com.iproov.sdk.p021new.Cnew f748for;

    /* renamed from: goto  reason: not valid java name */
    private final com.iproov.sdk.p017implements.Ctry<com.iproov.sdk.p030switch.Cfor> f749goto = new com.iproov.sdk.p017implements.Ctry<>(350, new c(this));

    /* renamed from: if  reason: not valid java name */
    private final CoroutineContext f750if;

    /* renamed from: import  reason: not valid java name */
    private boolean f751import;

    /* renamed from: new  reason: not valid java name */
    private com.iproov.sdk.cameray.Ctry f752new;

    /* renamed from: super  reason: not valid java name */
    private AccessibilityManager f753super;
    /* access modifiers changed from: private */

    /* renamed from: this  reason: not valid java name */
    public com.iproov.sdk.p019interface.Cif f754this;

    /* renamed from: throw  reason: not valid java name */
    private com.iproov.sdk.p017implements.Cthrow f755throw;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public com.iproov.sdk.p002break.Cdo f756try;

    /* renamed from: while  reason: not valid java name */
    private boolean f757while;

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$12", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$break  reason: invalid class name */
    public static final class Cbreak extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f758do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f759for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f760if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$12$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$break$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f761do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Cdo f762for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p016if.Cimport f763if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(com.iproov.sdk.p016if.Cimport importR, Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f763if = importR;
                this.f762for = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f763if, this.f762for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.iproov.sdk.public.for} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.iproov.sdk.break.do} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.iproov.sdk.break.do} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.iproov.sdk.public.for} */
            /* JADX WARNING: type inference failed for: r1v0 */
            /* JADX WARNING: type inference failed for: r1v2 */
            /* JADX WARNING: type inference failed for: r1v4 */
            /* JADX WARNING: type inference failed for: r1v10 */
            /* JADX WARNING: type inference failed for: r1v12 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r3) {
                /*
                    r2 = this;
                    java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r0 = r2.f761do
                    if (r0 != 0) goto L_0x00b7
                    kotlin.k.b(r3)
                    com.iproov.sdk.if.import r3 = r2.f763if
                    boolean r0 = r3 instanceof com.iproov.sdk.p016if.Cimport.Cif
                    r1 = 0
                    if (r0 == 0) goto L_0x0044
                    com.iproov.sdk.if.import$if r3 = (com.iproov.sdk.p016if.Cimport.Cif) r3
                    boolean r3 = r3.m782do()
                    if (r3 == 0) goto L_0x0036
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    r3.m894goto()
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.impl.ui.do$if r0 = com.iproov.sdk.impl.ui.Cdo.Cif.LIVENESS_FINISH
                    r3.m874do((com.iproov.sdk.impl.ui.Cdo.Cif) r0)
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.public.for r3 = r3.f743class
                    if (r3 != 0) goto L_0x002e
                    goto L_0x002f
                L_0x002e:
                    r1 = r3
                L_0x002f:
                    com.iproov.sdk.public.for$do r3 = com.iproov.sdk.p025public.Cfor.Cdo.COMPLETED
                    r1.m1291for(r3)
                    goto L_0x00b4
                L_0x0036:
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    r3.m921synchronized()
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.impl.ui.do$if r0 = com.iproov.sdk.impl.ui.Cdo.Cif.LIVENESS_SCAN
                    r3.m874do((com.iproov.sdk.impl.ui.Cdo.Cif) r0)
                    goto L_0x00b4
                L_0x0044:
                    boolean r0 = r3 instanceof com.iproov.sdk.p016if.Cimport.Ctry
                    if (r0 == 0) goto L_0x007c
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.break.do r3 = r3.f756try
                    if (r3 != 0) goto L_0x0051
                    goto L_0x0052
                L_0x0051:
                    r1 = r3
                L_0x0052:
                    com.iproov.sdk.ui.views.LivenessDebugOverlay r3 = r1.f40goto
                    com.iproov.sdk.if.import r0 = r2.f763if
                    r1 = 0
                    r3.setVisibility(r1)
                    com.iproov.sdk.if.import$try r0 = (com.iproov.sdk.p016if.Cimport.Ctry) r0
                    android.graphics.Rect r1 = r0.m785if()
                    r3.m2221if(r1)
                    android.graphics.Rect r1 = r0.m784for()
                    r3.m2219for(r1)
                    android.graphics.Rect r1 = r0.m783do()
                    r3.m2218do(r1)
                    android.graphics.Rect r0 = r0.m786new()
                    r3.m2222new(r0)
                    r3.m2220if()
                    goto L_0x00b4
                L_0x007c:
                    boolean r0 = r3 instanceof com.iproov.sdk.p016if.Cimport.Cfor
                    if (r0 == 0) goto L_0x0092
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.break.do r3 = r3.f756try
                    if (r3 != 0) goto L_0x0089
                    goto L_0x008a
                L_0x0089:
                    r1 = r3
                L_0x008a:
                    com.iproov.sdk.ui.views.LivenessDebugOverlay r3 = r1.f40goto
                    r0 = 8
                    r3.setVisibility(r0)
                    goto L_0x00b4
                L_0x0092:
                    boolean r0 = r3 instanceof com.iproov.sdk.p016if.Cimport.Ccase
                    if (r0 == 0) goto L_0x00a6
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.public.for r3 = r3.f743class
                    if (r3 != 0) goto L_0x009f
                    goto L_0x00a0
                L_0x009f:
                    r1 = r3
                L_0x00a0:
                    com.iproov.sdk.public.for$do r3 = com.iproov.sdk.p025public.Cfor.Cdo.FACE_FOUND
                    r1.m1291for(r3)
                    goto L_0x00b4
                L_0x00a6:
                    boolean r0 = r3 instanceof com.iproov.sdk.p016if.Cimport.Cdo
                    if (r0 == 0) goto L_0x00b2
                    com.iproov.sdk.impl.ui.do r3 = r2.f762for
                    com.iproov.sdk.impl.ui.do$if r0 = com.iproov.sdk.impl.ui.Cdo.Cif.LIVENESS_SUPPLEMENTARY_FRAME
                    r3.m874do((com.iproov.sdk.impl.ui.Cdo.Cif) r0)
                    goto L_0x00b4
                L_0x00b2:
                    boolean r3 = r3 instanceof com.iproov.sdk.p016if.Cimport.Cnew
                L_0x00b4:
                    kotlin.Unit r3 = kotlin.Unit.f56620a
                    return r3
                L_0x00b7:
                    java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r3.<init>(r0)
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.impl.ui.Cdo.Cbreak.Cdo.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$break$if  reason: invalid class name */
        public static final class Cif implements e<com.iproov.sdk.p016if.Cimport> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f764do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f765if;

            public Cif(h0 h0Var, Cdo doVar) {
                this.f764do = h0Var;
                this.f765if = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Cimport importR, c<? super Unit> cVar) {
                com.iproov.sdk.p016if.Cimport importR2 = importR;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f764do);
                Objects.toString(importR2);
                Object g11 = g.g(v0.c(), new Cdo(importR2, this.f765if, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cbreak(Cdo doVar, c<? super Cbreak> cVar) {
            super(2, cVar);
            this.f759for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cbreak breakR = new Cbreak(this.f759for, cVar);
            breakR.f760if = obj;
            return breakR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cbreak) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f758do;
            if (i11 == 0) {
                k.b(obj);
                f1<com.iproov.sdk.p016if.Cimport> f1Var = this.f759for.m890finally().m814try();
                Cif ifVar = new Cif((h0) this.f760if, this.f759for);
                this.f758do = 1;
                if (f1Var.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$closeUI$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$case  reason: invalid class name */
    public static final class Ccase extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f766do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f767if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccase(Cdo doVar, c<? super Ccase> cVar) {
            super(2, cVar);
            this.f767if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Ccase(this.f767if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ccase) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f766do == 0) {
                k.b(obj);
                this.f767if.finish();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$13", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$catch  reason: invalid class name */
    public static final class Ccatch extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f768do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f769if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$13$1$1", f = "FullScreenActivity.kt", l = {518}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$catch$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f770do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Cdo f771for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cinstanceof f772if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cinstanceof instanceofR, Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f772if = instanceofR;
                this.f771for = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f772if, this.f771for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f770do;
                if (i11 == 0) {
                    k.b(obj);
                    Cinstanceof instanceofR = this.f772if;
                    if (instanceofR instanceof Cinstanceof.Cif) {
                        b1 b1Var = this.f771for.f746else;
                        Boolean a11 = a.a(true);
                        this.f770do = 1;
                        if (b1Var.emit(a11, this) == d11) {
                            return d11;
                        }
                    } else if (instanceofR instanceof Cinstanceof.Cdo) {
                        this.f771for.m923this();
                    }
                } else if (i11 == 1) {
                    k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$catch$if  reason: invalid class name */
        public static final class Cif implements e<Cinstanceof> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f773do;

            public Cif(Cdo doVar) {
                this.f773do = doVar;
            }

            public Object emit(Cinstanceof instanceofR, c<? super Unit> cVar) {
                Object g11 = g.g(v0.c(), new Cdo(instanceofR, this.f773do, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccatch(Cdo doVar, c<? super Ccatch> cVar) {
            super(2, cVar);
            this.f769if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Ccatch(this.f769if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ccatch) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f768do;
            if (i11 == 0) {
                k.b(obj);
                f1<Cinstanceof> f1Var = this.f769if.m890finally().m806native();
                Cif ifVar = new Cif(this.f769if);
                this.f768do = 1;
                if (f1Var.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$14", f = "FullScreenActivity.kt", l = {526, 527}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$class  reason: invalid class name */
    public static final class Cclass extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f774do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f775if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cclass(Cdo doVar, c<? super Cclass> cVar) {
            super(2, cVar);
            this.f775if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cclass(this.f775if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cclass) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0053 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r6.f774do
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x001c
            L_0x000f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0017:
                kotlin.k.b(r7)
                r7 = r6
                goto L_0x0037
            L_0x001c:
                kotlin.k.b(r7)
                r7 = r6
            L_0x0020:
                com.iproov.sdk.impl.ui.do r1 = r7.f775if
                kotlinx.coroutines.w r1 = r1.f745do
                boolean r1 = r1.isActive()
                if (r1 == 0) goto L_0x0054
                r7.f774do = r3
                r4 = 300(0x12c, double:1.48E-321)
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r4, r7)
                if (r1 != r0) goto L_0x0037
                return r0
            L_0x0037:
                com.iproov.sdk.impl.ui.do r1 = r7.f775if
                com.iproov.sdk.if.protected r1 = r1.m890finally()
                kotlinx.coroutines.flow.b1 r1 = r1.m813throw()
                com.iproov.sdk.impl.ui.do r4 = r7.f775if
                com.iproov.sdk.graphics.iproov.OpenGLRenderer r4 = r4.m916static()
                com.iproov.sdk.implements.this r4 = r4.getFrameRate()
                r7.f774do = r2
                java.lang.Object r1 = r1.emit(r4, r7)
                if (r1 != r0) goto L_0x0020
                return r0
            L_0x0054:
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.impl.ui.Cdo.Cclass.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$15", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$const  reason: invalid class name */
    public static final class Cconst extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f776do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f777if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$15$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$const$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f778do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ String f779for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f780if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, String str, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f780if = doVar;
                this.f779for = str;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f780if, this.f779for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f778do == 0) {
                    k.b(obj);
                    this.f780if.m863default().setText(this.f779for);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$const$if  reason: invalid class name */
        public static final class Cif implements e<String> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f781do;

            @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$15$invokeSuspend$$inlined$collect$1", f = "FullScreenActivity.kt", l = {136}, m = "emit")
            /* renamed from: com.iproov.sdk.impl.ui.do$const$if$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f782do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cif f783for;

                /* renamed from: if  reason: not valid java name */
                public int f784if;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cif ifVar, c cVar) {
                    super(cVar);
                    this.f783for = ifVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f782do = obj;
                    this.f784if |= Integer.MIN_VALUE;
                    return this.f783for.emit((String) null, this);
                }
            }

            public Cif(Cdo doVar) {
                this.f781do = doVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.String r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.iproov.sdk.impl.ui.Cdo.Cconst.Cif.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    com.iproov.sdk.impl.ui.do$const$if$do r0 = (com.iproov.sdk.impl.ui.Cdo.Cconst.Cif.Cdo) r0
                    int r1 = r0.f784if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f784if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.impl.ui.do$const$if$do r0 = new com.iproov.sdk.impl.ui.do$const$if$do
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f782do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f784if
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r8)
                    goto L_0x005a
                L_0x0029:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0031:
                    kotlin.k.b(r8)
                    java.lang.String r7 = (java.lang.String) r7
                    com.iproov.sdk.impl.ui.do r8 = r6.f781do
                    com.iproov.sdk.interface.if r8 = r8.f754this
                    r2 = 0
                    if (r8 != 0) goto L_0x0040
                    r8 = r2
                L_0x0040:
                    boolean r8 = r8.m1105catch()
                    if (r8 == 0) goto L_0x005a
                    kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.v0.c()
                    com.iproov.sdk.impl.ui.do$const$do r4 = new com.iproov.sdk.impl.ui.do$const$do
                    com.iproov.sdk.impl.ui.do r5 = r6.f781do
                    r4.<init>(r5, r7, r2)
                    r0.f784if = r3
                    java.lang.Object r7 = kotlinx.coroutines.g.g(r8, r4, r0)
                    if (r7 != r1) goto L_0x005a
                    return r1
                L_0x005a:
                    kotlin.Unit r7 = kotlin.Unit.f56620a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.impl.ui.Cdo.Cconst.Cif.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cconst(Cdo doVar, c<? super Cconst> cVar) {
            super(2, cVar);
            this.f777if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cconst(this.f777if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cconst) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f776do;
            if (i11 == 0) {
                k.b(obj);
                j1<String> j1Var = this.f777if.m890finally().m799do();
                Cif ifVar = new Cif(this.f777if);
                this.f776do = 1;
                if (j1Var.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$onPause$1", f = "FullScreenActivity.kt", l = {193}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$default  reason: invalid class name */
    public static final class Cdefault extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f785do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f786if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdefault(Cdo doVar, c<? super Cdefault> cVar) {
            super(2, cVar);
            this.f786if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdefault(this.f786if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdefault) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f785do;
            if (i11 == 0) {
                k.b(obj);
                a1<Csynchronized> a1Var = this.f786if.m890finally().m801final();
                Csynchronized.Cfor forR = Csynchronized.Cfor.f726do;
                this.f785do = 1;
                if (a1Var.emit(forR, this) == d11) {
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

    /* renamed from: com.iproov.sdk.impl.ui.do$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initCameraPermission$1$1", f = "FullScreenActivity.kt", l = {715}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$else  reason: invalid class name */
    public static final class Celse extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f787do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f788if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Cdo doVar, c<? super Celse> cVar) {
            super(2, cVar);
            this.f788if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Celse(this.f788if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Celse) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f787do;
            if (i11 == 0) {
                k.b(obj);
                b1<Size> b1Var = this.f788if.m890finally().m796catch();
                Size screenSize = this.f788if.m916static().getScreenSize();
                this.f787do = 1;
                if (b1Var.emit(screenSize, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$onRequestPermissionsResult$1", f = "FullScreenActivity.kt", l = {229}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$extends  reason: invalid class name */
    public static final class Cextends extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f789do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f790if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cextends(Cdo doVar, c<? super Cextends> cVar) {
            super(2, cVar);
            this.f790if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cextends(this.f790if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cextends) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f789do;
            if (i11 == 0) {
                k.b(obj);
                a1<Csynchronized> a1Var = this.f790if.m890finally().m801final();
                Csynchronized.Cdo doVar = new Csynchronized.Cdo(new CameraPermissionException(this.f790if));
                this.f789do = 1;
                if (a1Var.emit(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$1", f = "FullScreenActivity.kt", l = {376}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$final  reason: invalid class name */
    public static final class Cfinal extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f791do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f792if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfinal(Cdo doVar, c<? super Cfinal> cVar) {
            super(2, cVar);
            this.f792if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cfinal(this.f792if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfinal) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f791do;
            if (i11 == 0) {
                k.b(obj);
                b1<Orientation> b1Var = this.f792if.m890finally().m800else();
                Orientation orientation = this.f792if.f740break;
                if (orientation == null) {
                    orientation = null;
                }
                this.f791do = 1;
                if (b1Var.emit(orientation, this) == d11) {
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

    /* renamed from: com.iproov.sdk.impl.ui.do$finally  reason: invalid class name */
    public static final class Cfinally extends CountDownTimer {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdo f793do;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$startCountdown$1$onFinish$1", f = "FullScreenActivity.kt", l = {805}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$finally$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f794do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f795if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f795if = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f795if, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f794do;
                if (i11 == 0) {
                    k.b(obj);
                    a1<com.iproov.sdk.p016if.Cclass> a1Var = this.f795if.m890finally().m807new();
                    com.iproov.sdk.p016if.Cclass classR = com.iproov.sdk.p016if.Cclass.COUNTDOWN_COMPLETE;
                    this.f794do = 1;
                    if (a1Var.emit(classR, this) == d11) {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfinally(Cdo doVar, long j11, long j12) {
            super(j11, j12);
            this.f793do = doVar;
        }

        public void onFinish() {
            CountDownTimer countDownTimer = this.f793do.f747final;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f793do.f747final = null;
            n1 unused = i.d(this.f793do, v0.a(), (CoroutineStart) null, new Cdo(this.f793do, (c<? super Cdo>) null), 2, (Object) null);
        }

        public void onTick(long j11) {
            if (j11 <= 1000) {
                this.f793do.m931while().m2177do();
            }
        }
    }

    /* renamed from: com.iproov.sdk.impl.ui.do$for  reason: invalid class name */
    public /* synthetic */ class Cfor {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f796do;

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ int[] f797if;

        static {
            int[] iArr = new int[Cif.values().length];
            iArr[Cif.GPA_NO_FACE.ordinal()] = 1;
            iArr[Cif.GPA_FLASHING_STARTING.ordinal()] = 2;
            iArr[Cif.LIVENESS_FINISH.ordinal()] = 3;
            iArr[Cif.GPA_INIT_SUPPLEMENTARY.ordinal()] = 4;
            iArr[Cif.GPA_INIT_NO_SUPPLEMENTARY.ordinal()] = 5;
            iArr[Cif.LIVENESS_INIT.ordinal()] = 6;
            f796do = iArr;
            int[] iArr2 = new int[com.iproov.sdk.p015goto.Cif.values().length];
            iArr2[com.iproov.sdk.p015goto.Cif.END_FACE_PATH.ordinal()] = 1;
            iArr2[com.iproov.sdk.p015goto.Cif.READY.ordinal()] = 2;
            iArr2[com.iproov.sdk.p015goto.Cif.FACE_PATH.ordinal()] = 3;
            iArr2[com.iproov.sdk.p015goto.Cif.NO_FACE_PATH.ordinal()] = 4;
            iArr2[com.iproov.sdk.p015goto.Cif.TOO_FAR_FACE_PATH.ordinal()] = 5;
            iArr2[com.iproov.sdk.p015goto.Cif.TOO_CLOSE_FACE_PATH.ordinal()] = 6;
            iArr2[com.iproov.sdk.p015goto.Cif.NO_FACE.ordinal()] = 7;
            iArr2[com.iproov.sdk.p015goto.Cif.TOO_FAR.ordinal()] = 8;
            iArr2[com.iproov.sdk.p015goto.Cif.TOO_CLOSE.ordinal()] = 9;
            iArr2[com.iproov.sdk.p015goto.Cif.TOO_BRIGHT.ordinal()] = 10;
            iArr2[com.iproov.sdk.p015goto.Cif.ROLL_TOO_HIGH.ordinal()] = 11;
            iArr2[com.iproov.sdk.p015goto.Cif.ROLL_TOO_LOW.ordinal()] = 12;
            iArr2[com.iproov.sdk.p015goto.Cif.YAW_TOO_HIGH.ordinal()] = 13;
            iArr2[com.iproov.sdk.p015goto.Cif.YAW_TOO_LOW.ordinal()] = 14;
            iArr2[com.iproov.sdk.p015goto.Cif.PITCH_TOO_LOW.ordinal()] = 15;
            iArr2[com.iproov.sdk.p015goto.Cif.PITCH_TOO_HIGH.ordinal()] = 16;
            f797if = iArr2;
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$10", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$goto  reason: invalid class name */
    public static final class Cgoto extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f798do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f799for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f800if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$10$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$goto$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f801do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Bitmap f802for;

            /* renamed from: if  reason: not valid java name */
            private /* synthetic */ Object f803if;

            /* renamed from: new  reason: not valid java name */
            public final /* synthetic */ Cdo f804new;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Bitmap bitmap, Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f802for = bitmap;
                this.f804new = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f802for, this.f804new, cVar);
                doVar.f803if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Unit unit;
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f801do == 0) {
                    k.b(obj);
                    h0 h0Var = (h0) this.f803if;
                    Bitmap bitmap = this.f802for;
                    if (bitmap == null) {
                        unit = null;
                    } else {
                        Cdo doVar = this.f804new;
                        doVar.m901import().setVisibility(0);
                        doVar.m901import().setImageBitmap(bitmap);
                        unit = Unit.f56620a;
                    }
                    if (unit == null) {
                        this.f804new.m901import().setVisibility(4);
                    }
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$goto$if  reason: invalid class name */
        public static final class Cif implements e<Bitmap> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f805do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f806if;

            public Cif(h0 h0Var, Cdo doVar) {
                this.f805do = h0Var;
                this.f806if = doVar;
            }

            public Object emit(Bitmap bitmap, c<? super Unit> cVar) {
                com.iproov.sdk.p017implements.Ccase.m977do(this.f805do);
                Object g11 = g.g(v0.c(), new Cdo(bitmap, this.f806if, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cgoto(Cdo doVar, c<? super Cgoto> cVar) {
            super(2, cVar);
            this.f799for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cgoto gotoR = new Cgoto(this.f799for, cVar);
            gotoR.f800if = obj;
            return gotoR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cgoto) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f798do;
            if (i11 == 0) {
                k.b(obj);
                j1<Bitmap> j1Var = this.f799for.m890finally().m809return();
                Cif ifVar = new Cif((h0) this.f800if, this.f799for);
                this.f798do = 1;
                if (j1Var.collect(ifVar, this) == d11) {
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

    /* renamed from: com.iproov.sdk.impl.ui.do$if  reason: invalid class name */
    public enum Cif {
        GPA_INIT_NO_SUPPLEMENTARY,
        GPA_INIT_SUPPLEMENTARY,
        GPA_SUPPLEMENTARY_FRAME,
        GPA_FACE,
        GPA_NO_FACE,
        GPA_FLASHING_STARTING,
        LIVENESS_SUPPLEMENTARY_FRAME,
        LIVENESS_SCAN,
        LIVENESS_STOP_SCAN,
        LIVENESS_FINISH,
        LIVENESS_INIT
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$5", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$import  reason: invalid class name */
    public static final class Cimport extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f819do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f820for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f821if;

        /* renamed from: com.iproov.sdk.impl.ui.do$import$do  reason: invalid class name */
        public static final class Cdo extends Lambda implements p<com.iproov.sdk.p016if.Cfinal, com.iproov.sdk.p016if.Cfinal, Boolean> {

            /* renamed from: do  reason: not valid java name */
            public static final Cdo f822do = new Cdo();

            public Cdo() {
                super(2);
            }

            /* renamed from: do  reason: not valid java name */
            public final Boolean invoke(com.iproov.sdk.p016if.Cfinal finalR, com.iproov.sdk.p016if.Cfinal finalR2) {
                return Boolean.valueOf(finalR2 == finalR);
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$import$for  reason: invalid class name */
        public static final class Cfor implements e<com.iproov.sdk.p016if.Cfinal> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f823do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f824if;

            @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$5$invokeSuspend$$inlined$collect$1", f = "FullScreenActivity.kt", l = {138, 139}, m = "emit")
            /* renamed from: com.iproov.sdk.impl.ui.do$import$for$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f825do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cfor f826for;

                /* renamed from: if  reason: not valid java name */
                public int f827if;

                /* renamed from: new  reason: not valid java name */
                public Object f828new;

                /* renamed from: try  reason: not valid java name */
                public Object f829try;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cfor forR, c cVar) {
                    super(cVar);
                    this.f826for = forR;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f825do = obj;
                    this.f827if |= Integer.MIN_VALUE;
                    return this.f826for.emit((com.iproov.sdk.p016if.Cfinal) null, this);
                }
            }

            public Cfor(h0 h0Var, Cdo doVar) {
                this.f823do = h0Var;
                this.f824if = doVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0080 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p016if.Cfinal r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.iproov.sdk.impl.ui.Cdo.Cimport.Cfor.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    com.iproov.sdk.impl.ui.do$import$for$do r0 = (com.iproov.sdk.impl.ui.Cdo.Cimport.Cfor.Cdo) r0
                    int r1 = r0.f827if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f827if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.impl.ui.do$import$for$do r0 = new com.iproov.sdk.impl.ui.do$import$for$do
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f825do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f827if
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x0040
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.k.b(r8)
                    goto L_0x0081
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.f829try
                    com.iproov.sdk.if.final r7 = (com.iproov.sdk.p016if.Cfinal) r7
                    java.lang.Object r2 = r0.f828new
                    com.iproov.sdk.impl.ui.do$import$for r2 = (com.iproov.sdk.impl.ui.Cdo.Cimport.Cfor) r2
                    kotlin.k.b(r8)
                    goto L_0x0068
                L_0x0040:
                    kotlin.k.b(r8)
                    com.iproov.sdk.if.final r7 = (com.iproov.sdk.p016if.Cfinal) r7
                    if (r7 == 0) goto L_0x0081
                    kotlinx.coroutines.h0 r8 = r6.f823do
                    com.iproov.sdk.p017implements.Ccase.m977do(r8)
                    r7.toString()
                    com.iproov.sdk.impl.ui.do r8 = r6.f824if
                    kotlinx.coroutines.flow.b1 r8 = r8.f741case
                    r2 = 0
                    java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r2)
                    r0.f828new = r6
                    r0.f829try = r7
                    r0.f827if = r4
                    java.lang.Object r8 = r8.emit(r2, r0)
                    if (r8 != r1) goto L_0x0067
                    return r1
                L_0x0067:
                    r2 = r6
                L_0x0068:
                    kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.v0.c()
                    com.iproov.sdk.impl.ui.do$import$if r4 = new com.iproov.sdk.impl.ui.do$import$if
                    com.iproov.sdk.impl.ui.do r2 = r2.f824if
                    r5 = 0
                    r4.<init>(r2, r7, r5)
                    r0.f828new = r5
                    r0.f829try = r5
                    r0.f827if = r3
                    java.lang.Object r7 = kotlinx.coroutines.g.g(r8, r4, r0)
                    if (r7 != r1) goto L_0x0081
                    return r1
                L_0x0081:
                    kotlin.Unit r7 = kotlin.Unit.f56620a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.impl.ui.Cdo.Cimport.Cfor.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$5$2$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$import$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f830do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p016if.Cfinal f831for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f832if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Cdo doVar, com.iproov.sdk.p016if.Cfinal finalR, c<? super Cif> cVar) {
                super(2, cVar);
                this.f832if = doVar;
                this.f831for = finalR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cif(this.f832if, this.f831for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f830do == 0) {
                    k.b(obj);
                    this.f832if.m873do(com.iproov.sdk.p016if.Csuper.m829do(this.f831for));
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cimport(Cdo doVar, c<? super Cimport> cVar) {
            super(2, cVar);
            this.f820for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cimport importR = new Cimport(this.f820for, cVar);
            importR.f821if = obj;
            return importR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cimport) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f819do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<com.iproov.sdk.p016if.Cfinal> t11 = f.t(this.f820for.m890finally().m815while(), Cdo.f822do);
                Cfor forR = new Cfor((h0) this.f821if, this.f820for);
                this.f819do = 1;
                if (t11.collect(forR, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$6", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$native  reason: invalid class name */
    public static final class Cnative extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f833do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f834for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f835if;

        /* renamed from: com.iproov.sdk.impl.ui.do$native$do  reason: invalid class name */
        public static final class Cdo extends Lambda implements p<com.iproov.sdk.p016if.Cpublic, com.iproov.sdk.p016if.Cpublic, Boolean> {

            /* renamed from: do  reason: not valid java name */
            public static final Cdo f836do = new Cdo();

            public Cdo() {
                super(2);
            }

            /* renamed from: do  reason: not valid java name */
            public final Boolean invoke(com.iproov.sdk.p016if.Cpublic publicR, com.iproov.sdk.p016if.Cpublic publicR2) {
                return Boolean.valueOf(publicR2 == publicR);
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$native$for  reason: invalid class name */
        public static final class Cfor implements e<com.iproov.sdk.p016if.Cpublic> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f837do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f838if;

            @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$6$invokeSuspend$$inlined$collect$1", f = "FullScreenActivity.kt", l = {137}, m = "emit")
            /* renamed from: com.iproov.sdk.impl.ui.do$native$for$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f839do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cfor f840for;

                /* renamed from: if  reason: not valid java name */
                public int f841if;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cfor forR, c cVar) {
                    super(cVar);
                    this.f840for = forR;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f839do = obj;
                    this.f841if |= Integer.MIN_VALUE;
                    return this.f840for.emit((com.iproov.sdk.p016if.Cpublic) null, this);
                }
            }

            public Cfor(h0 h0Var, Cdo doVar) {
                this.f837do = h0Var;
                this.f838if = doVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p016if.Cpublic r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.iproov.sdk.impl.ui.Cdo.Cnative.Cfor.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    com.iproov.sdk.impl.ui.do$native$for$do r0 = (com.iproov.sdk.impl.ui.Cdo.Cnative.Cfor.Cdo) r0
                    int r1 = r0.f841if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f841if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.impl.ui.do$native$for$do r0 = new com.iproov.sdk.impl.ui.do$native$for$do
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f839do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f841if
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r8)
                    goto L_0x0055
                L_0x0029:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0031:
                    kotlin.k.b(r8)
                    com.iproov.sdk.if.public r7 = (com.iproov.sdk.p016if.Cpublic) r7
                    if (r7 == 0) goto L_0x0055
                    kotlinx.coroutines.h0 r8 = r6.f837do
                    com.iproov.sdk.p017implements.Ccase.m977do(r8)
                    r7.toString()
                    kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.v0.c()
                    com.iproov.sdk.impl.ui.do$native$if r2 = new com.iproov.sdk.impl.ui.do$native$if
                    com.iproov.sdk.impl.ui.do r4 = r6.f838if
                    r5 = 0
                    r2.<init>(r4, r7, r5)
                    r0.f841if = r3
                    java.lang.Object r7 = kotlinx.coroutines.g.g(r8, r2, r0)
                    if (r7 != r1) goto L_0x0055
                    return r1
                L_0x0055:
                    kotlin.Unit r7 = kotlin.Unit.f56620a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.impl.ui.Cdo.Cnative.Cfor.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$6$2$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$native$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f842do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p016if.Cpublic f843for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f844if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Cdo doVar, com.iproov.sdk.p016if.Cpublic publicR, c<? super Cif> cVar) {
                super(2, cVar);
                this.f844if = doVar;
                this.f843for = publicR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cif(this.f844if, this.f843for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f842do == 0) {
                    k.b(obj);
                    this.f844if.m873do(com.iproov.sdk.p016if.Creturn.m817do(this.f843for));
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnative(Cdo doVar, c<? super Cnative> cVar) {
            super(2, cVar);
            this.f834for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cnative nativeR = new Cnative(this.f834for, cVar);
            nativeR.f835if = obj;
            return nativeR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnative) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f833do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<com.iproov.sdk.p016if.Cpublic> t11 = f.t(this.f834for.m890finally().m794break(), Cdo.f836do);
                Cfor forR = new Cfor((h0) this.f835if, this.f834for);
                this.f833do = 1;
                if (t11.collect(forR, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$activityFinishing$1", f = "FullScreenActivity.kt", l = {564}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f845do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f846if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Cdo doVar, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f846if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cnew(this.f846if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f845do;
            if (i11 == 0) {
                k.b(obj);
                a1<Csynchronized> a1Var = this.f846if.m890finally().m801final();
                Csynchronized.Cif ifVar = Csynchronized.Cif.f727do;
                this.f845do = 1;
                if (a1Var.emit(ifVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                try {
                    k.b(obj);
                } catch (Exception unused) {
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.impl.ui.do$package  reason: invalid class name */
    public static final class Cpackage extends Lambda implements d10.a<Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdo f847do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cpackage(Cdo doVar) {
            super(0);
            this.f847do = doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m956do() {
            this.f847do.m916static().setLAEndAnimationFlag(true);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m956do();
            return Unit.f56620a;
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$startLAHovalayEndAnimation$2$1", f = "FullScreenActivity.kt", l = {834}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$private  reason: invalid class name */
    public static final class Cprivate extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f848do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f849if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cprivate(Cdo doVar, c<? super Cprivate> cVar) {
            super(2, cVar);
            this.f849if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cprivate(this.f849if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cprivate) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f848do;
            if (i11 == 0) {
                k.b(obj);
                b1 b1Var = this.f849if.f741case;
                Boolean a11 = a.a(false);
                this.f848do = 1;
                if (b1Var.emit(a11, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$7", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$public  reason: invalid class name */
    public static final class Cpublic extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f850do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f851if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$7$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$public$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f852do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p016if.Cconst f853for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f854if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, com.iproov.sdk.p016if.Cconst constR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f854if = doVar;
                this.f853for = constR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f854if, this.f853for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f852do == 0) {
                    k.b(obj);
                    this.f854if.m916static().m710do(this.f853for.m721do(), this.f853for.m722for(), this.f853for.m723if());
                    this.f854if.m931while().m2179do(this.f853for.m722for(), this.f853for.m723if());
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$public$if  reason: invalid class name */
        public static final class Cif implements e<com.iproov.sdk.p016if.Cconst> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f855do;

            public Cif(Cdo doVar) {
                this.f855do = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Cconst constR, c<? super Unit> cVar) {
                Object g11 = g.g(v0.c(), new Cdo(this.f855do, constR, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cpublic(Cdo doVar, c<? super Cpublic> cVar) {
            super(2, cVar);
            this.f851if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cpublic(this.f851if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cpublic) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f850do;
            if (i11 == 0) {
                k.b(obj);
                f1<com.iproov.sdk.p016if.Cconst> f1Var = this.f851if.m890finally().m795case();
                Cif ifVar = new Cif(this.f851if);
                this.f850do = 1;
                if (f1Var.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$8", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$return  reason: invalid class name */
    public static final class Creturn extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f856do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f857if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$8$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$return$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f858do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p016if.Cnative f859for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f860if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, com.iproov.sdk.p016if.Cnative nativeR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f860if = doVar;
                this.f859for = nativeR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f860if, this.f859for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f858do == 0) {
                    k.b(obj);
                    this.f860if.m916static().setInnerBlurProgress(1.0f - ((float) this.f859for.m788do()));
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$return$if  reason: invalid class name */
        public static final class Cif implements e<com.iproov.sdk.p016if.Cnative> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f861do;

            public Cif(Cdo doVar) {
                this.f861do = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Cnative nativeR, c<? super Unit> cVar) {
                Object g11 = g.g(v0.c(), new Cdo(this.f861do, nativeR, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Creturn(Cdo doVar, c<? super Creturn> cVar) {
            super(2, cVar);
            this.f857if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Creturn(this.f857if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Creturn) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f856do;
            if (i11 == 0) {
                k.b(obj);
                f1<com.iproov.sdk.p016if.Cnative> f1Var = this.f857if.m890finally().m798const();
                Cif ifVar = new Cif(this.f857if);
                this.f856do = 1;
                if (f1Var.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$9", f = "FullScreenActivity.kt", l = {922}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$static  reason: invalid class name */
    public static final class Cstatic extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f862do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f863if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$9$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$static$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements q<Boolean, Boolean, c<? super Boolean>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f864do;

            /* renamed from: for  reason: not valid java name */
            public /* synthetic */ boolean f865for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ boolean f866if;

            public Cdo(c<? super Cdo> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object m963do(boolean z11, boolean z12, c<? super Boolean> cVar) {
                Cdo doVar = new Cdo(cVar);
                doVar.f866if = z11;
                doVar.f865for = z12;
                return doVar.invokeSuspend(Unit.f56620a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m963do(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (c) obj3);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f864do == 0) {
                    k.b(obj);
                    return a.a(this.f866if && !this.f865for);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$static$for  reason: invalid class name */
        public static final class Cfor implements kotlinx.coroutines.flow.d<Boolean> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ kotlinx.coroutines.flow.d f867do;

            /* renamed from: com.iproov.sdk.impl.ui.do$static$for$do  reason: invalid class name */
            public static final class Cdo implements e<Boolean> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ e f868do;

                @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$9$invokeSuspend$$inlined$filter$1$2", f = "FullScreenActivity.kt", l = {137}, m = "emit")
                /* renamed from: com.iproov.sdk.impl.ui.do$static$for$do$do  reason: invalid class name */
                public static final class Cdo extends ContinuationImpl {

                    /* renamed from: do  reason: not valid java name */
                    public /* synthetic */ Object f869do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cdo f870for;

                    /* renamed from: if  reason: not valid java name */
                    public int f871if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cdo(Cdo doVar, c cVar) {
                        super(cVar);
                        this.f870for = doVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f869do = obj;
                        this.f871if |= Integer.MIN_VALUE;
                        return this.f870for.emit((Object) null, this);
                    }
                }

                public Cdo(e eVar) {
                    this.f868do = eVar;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.iproov.sdk.impl.ui.Cdo.Cstatic.Cfor.Cdo.Cdo
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.iproov.sdk.impl.ui.do$static$for$do$do r0 = (com.iproov.sdk.impl.ui.Cdo.Cstatic.Cfor.Cdo.Cdo) r0
                        int r1 = r0.f871if
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f871if = r1
                        goto L_0x0018
                    L_0x0013:
                        com.iproov.sdk.impl.ui.do$static$for$do$do r0 = new com.iproov.sdk.impl.ui.do$static$for$do$do
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f869do
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r2 = r0.f871if
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.k.b(r6)
                        goto L_0x0048
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.k.b(r6)
                        kotlinx.coroutines.flow.e r6 = r4.f868do
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        if (r2 == 0) goto L_0x0048
                        r0.f871if = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L_0x0048
                        return r1
                    L_0x0048:
                        kotlin.Unit r5 = kotlin.Unit.f56620a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.impl.ui.Cdo.Cstatic.Cfor.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            public Cfor(kotlinx.coroutines.flow.d dVar) {
                this.f867do = dVar;
            }

            public Object collect(e eVar, c cVar) {
                Object collect = this.f867do.collect(new Cdo(eVar), cVar);
                if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                    return collect;
                }
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$static$if  reason: invalid class name */
        public static final class Cif implements e<Boolean> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f872do;

            public Cif(Cdo doVar) {
                this.f872do = doVar;
            }

            public Object emit(Boolean bool, c<? super Unit> cVar) {
                bool.booleanValue();
                this.f872do.m923this();
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cstatic(Cdo doVar, c<? super Cstatic> cVar) {
            super(2, cVar);
            this.f863if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cstatic(this.f863if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cstatic) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f862do;
            if (i11 == 0) {
                k.b(obj);
                Cfor forR = new Cfor(f.G(this.f863if.f746else, this.f863if.f741case, new Cdo((c<? super Cdo>) null)));
                Cif ifVar = new Cif(this.f863if);
                this.f862do = 1;
                if (forR.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$2", f = "FullScreenActivity.kt", l = {379}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$super  reason: invalid class name */
    public static final class Csuper extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f873do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f874if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Csuper(Cdo doVar, c<? super Csuper> cVar) {
            super(2, cVar);
            this.f874if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Csuper(this.f874if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Csuper) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f873do;
            if (i11 == 0) {
                k.b(obj);
                b1<Orientation> b1Var = this.f874if.m890finally().m802for();
                Orientation orientation = this.f874if.f742catch;
                if (orientation == null) {
                    orientation = null;
                }
                this.f873do = 1;
                if (b1Var.emit(orientation, this) == d11) {
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

    /* renamed from: com.iproov.sdk.impl.ui.do$switch  reason: invalid class name */
    public static final class Cswitch extends o {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdo f875do;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$onBackPressedCallback$1$handleOnBackPressed$1", f = "FullScreenActivity.kt", l = {242}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$switch$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f876do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f877if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f877if = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f877if, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f876do;
                if (i11 == 0) {
                    k.b(obj);
                    a1<Csynchronized> a1Var = this.f877if.m890finally().m801final();
                    Csynchronized.Cfor forR = Csynchronized.Cfor.f726do;
                    this.f876do = 1;
                    if (a1Var.emit(forR, this) == d11) {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cswitch(Cdo doVar) {
            super(true);
            this.f875do = doVar;
        }

        public void handleOnBackPressed() {
            com.iproov.sdk.p017implements.Ccase.m977do(this);
            n1 unused = i.d(this.f875do, v0.a(), (CoroutineStart) null, new Cdo(this.f875do, (c<? super Cdo>) null), 2, (Object) null);
            if (isEnabled()) {
                setEnabled(false);
                this.f875do.getOnBackPressedDispatcher().l();
            }
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$11", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$this  reason: invalid class name */
    public static final class Cthis extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f878do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f879for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f880if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$11$1$2", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$this$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f881do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Cdo f882for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p016if.Ccatch f883if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(com.iproov.sdk.p016if.Ccatch catchR, Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f883if = catchR;
                this.f882for = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f883if, this.f882for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Double d11;
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f881do == 0) {
                    k.b(obj);
                    com.iproov.sdk.p016if.Ccatch catchR = this.f883if;
                    if (catchR instanceof Ccatch.Cfor) {
                        this.f882for.m916static().m707class();
                    } else if (catchR instanceof Ccatch.Cdo) {
                        this.f882for.m874do(Cif.GPA_SUPPLEMENTARY_FRAME);
                    } else if (catchR instanceof Ccatch.Cnew) {
                        this.f882for.m911protected();
                    } else if ((catchR instanceof Ccatch.Cif) && (d11 = ((Ccatch.Cif) catchR).m719do()) != null) {
                        com.iproov.sdk.p017implements.Cpublic.m1031do(this.f882for.getWindow(), (float) d11.doubleValue());
                    }
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$this$if  reason: invalid class name */
        public static final class Cif implements e<com.iproov.sdk.p016if.Ccatch> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f884do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f885if;

            public Cif(h0 h0Var, Cdo doVar) {
                this.f884do = h0Var;
                this.f885if = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Ccatch catchR, c<? super Unit> cVar) {
                com.iproov.sdk.p016if.Ccatch catchR2 = catchR;
                Objects.toString(catchR2);
                com.iproov.sdk.p017implements.Ccase.m977do(this.f884do);
                Object g11 = g.g(v0.c(), new Cdo(catchR2, this.f885if, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cthis(Cdo doVar, c<? super Cthis> cVar) {
            super(2, cVar);
            this.f879for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cthis thisR = new Cthis(this.f879for, cVar);
            thisR.f880if = obj;
            return thisR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cthis) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f878do;
            if (i11 == 0) {
                k.b(obj);
                f1<com.iproov.sdk.p016if.Ccatch> f1Var = this.f879for.m890finally().m811super();
                Cif ifVar = new Cif((h0) this.f880if, this.f879for);
                this.f878do = 1;
                if (f1Var.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$3", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$throw  reason: invalid class name */
    public static final class Cthrow extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f886do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f887if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$3$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$throw$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements d10.r<com.iproov.sdk.p016if.Cnew, Size, Integer, c<? super Triple<? extends com.iproov.sdk.p016if.Cnew, ? extends Size, ? extends Integer>>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f888do;

            /* renamed from: for  reason: not valid java name */
            public /* synthetic */ Object f889for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f890if;

            /* renamed from: new  reason: not valid java name */
            public /* synthetic */ int f891new;

            public Cdo(c<? super Cdo> cVar) {
                super(4, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object m969do(com.iproov.sdk.p016if.Cnew newR, Size size, int i11, c<? super Triple<com.iproov.sdk.p016if.Cnew, Size, Integer>> cVar) {
                Cdo doVar = new Cdo(cVar);
                doVar.f890if = newR;
                doVar.f889for = size;
                doVar.f891new = i11;
                return doVar.invokeSuspend(Unit.f56620a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return m969do((com.iproov.sdk.p016if.Cnew) obj, (Size) obj2, ((Number) obj3).intValue(), (c) obj4);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f888do == 0) {
                    k.b(obj);
                    return new Triple((com.iproov.sdk.p016if.Cnew) this.f890if, (Size) this.f889for, a.c(this.f891new));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$throw$if  reason: invalid class name */
        public static final class Cif implements e<Triple<? extends com.iproov.sdk.p016if.Cnew, ? extends Size, ? extends Integer>> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f892do;

            public Cif(Cdo doVar) {
                this.f892do = doVar;
            }

            public Object emit(Triple<? extends com.iproov.sdk.p016if.Cnew, ? extends Size, ? extends Integer> triple, c<? super Unit> cVar) {
                Triple triple2 = triple;
                this.f892do.m916static().m711do(((com.iproov.sdk.p016if.Cnew) triple2.getFirst()).m789do(), (Size) triple2.getSecond(), ((Number) triple2.getThird()).intValue());
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cthrow(Cdo doVar, c<? super Cthrow> cVar) {
            super(2, cVar);
            this.f887if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cthrow(this.f887if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cthrow) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f886do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<R> k11 = f.k(f.y(this.f887if.m890finally().m797class()), f.y(this.f887if.m890finally().m808public()), f.y(f.s(this.f887if.m890finally().m803goto())), new Cdo((c<? super Cdo>) null));
                Cif ifVar = new Cif(this.f887if);
                this.f886do = 1;
                if (k11.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$onCreate$1", f = "FullScreenActivity.kt", l = {168}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$throws  reason: invalid class name */
    public static final class Cthrows extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f893do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f894if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$onCreate$1$1", f = "FullScreenActivity.kt", l = {172}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$throws$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f895do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Cdo f896for;

            /* renamed from: if  reason: not valid java name */
            private /* synthetic */ Object f897if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f896for = doVar;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f896for, cVar);
                doVar.f897if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f895do;
                if (i11 == 0) {
                    k.b(obj);
                    Cdo doVar = this.f896for;
                    this.f895do = 1;
                    if (doVar.m866do((h0) this.f897if, (c<? super n1>) this) == d11) {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cthrows(Cdo doVar, c<? super Cthrows> cVar) {
            super(2, cVar);
            this.f894if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cthrows(this.f894if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cthrows) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f893do;
            if (i11 == 0) {
                k.b(obj);
                Cdo doVar = this.f894if;
                Lifecycle.State state = Lifecycle.State.CREATED;
                Cdo doVar2 = new Cdo(doVar, (c<? super Cdo>) null);
                this.f893do = 1;
                if (RepeatOnLifecycleKt.b(doVar, state, doVar2, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$cameraPermissionGranted$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$try  reason: invalid class name */
    public static final class Ctry extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f898do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ float f899for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f900if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Cdo doVar, float f11, c<? super Ctry> cVar) {
            super(2, cVar);
            this.f900if = doVar;
            this.f899for = f11;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Ctry(this.f900if, this.f899for, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ctry) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f898do == 0) {
                k.b(obj);
                this.f900if.m896if(10, this.f899for);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$4", f = "FullScreenActivity.kt", l = {917}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.impl.ui.do$while  reason: invalid class name */
    public static final class Cwhile extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f901do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f902for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f903if;

        @d(c = "com.iproov.sdk.impl.ui.FullScreenActivity$initFlows$2$4$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.impl.ui.do$while$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f904do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Size f905for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f906if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, Size size, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f906if = doVar;
                this.f905for = size;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f906if, this.f905for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f904do == 0) {
                    k.b(obj);
                    this.f906if.m916static().m713for(this.f905for);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.impl.ui.do$while$if  reason: invalid class name */
        public static final class Cif implements e<Size> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f907do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f908if;

            public Cif(h0 h0Var, Cdo doVar) {
                this.f907do = h0Var;
                this.f908if = doVar;
            }

            public Object emit(Size size, c<? super Unit> cVar) {
                Size size2 = size;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f907do);
                x.i("Camera previewSize received ", size2);
                com.iproov.sdk.p017implements.Ccase.m977do(this.f907do);
                Object g11 = g.g(v0.c(), new Cdo(this.f908if, size2, (c<? super Cdo>) null), cVar);
                if (g11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return g11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cwhile(Cdo doVar, c<? super Cwhile> cVar) {
            super(2, cVar);
            this.f902for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cwhile whileR = new Cwhile(this.f902for, cVar);
            whileR.f903if = obj;
            return whileR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cwhile) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f901do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<Size> y11 = f.y(this.f902for.m890finally().m808public());
                Cif ifVar = new Cif((h0) this.f903if, this.f902for);
                this.f901do = 1;
                if (y11.collect(ifVar, this) == d11) {
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

    static {
        new Cdo((r) null);
    }

    public Cdo() {
        w b11 = r1.b((n1) null, 1, (Object) null);
        this.f745do = b11;
        this.f750if = b11.plus(v0.c()).plus(new g0(com.iproov.sdk.p017implements.Ccase.m977do(this)));
    }

    private final void a() {
        AppCompatTextView appCompatTextView = m863default();
        com.iproov.sdk.p019interface.Cif ifVar = this.f754this;
        com.iproov.sdk.p019interface.Cif ifVar2 = null;
        if (ifVar == null) {
            ifVar = null;
        }
        int i11 = 0;
        appCompatTextView.setVisibility(ifVar.m1105catch() ? 0 : 4);
        ImageView imageView = m901import();
        com.iproov.sdk.p019interface.Cif ifVar3 = this.f754this;
        if (ifVar3 != null) {
            ifVar2 = ifVar3;
        }
        if (!ifVar2.m1105catch()) {
            i11 = 4;
        }
        imageView.setVisibility(i11);
    }

    /* renamed from: abstract  reason: not valid java name */
    private final void m851abstract() {
        m916static().setPermissionsDelegate(new b(this));
    }

    /* renamed from: continue  reason: not valid java name */
    private final void m862continue() {
        this.f740break = com.iproov.sdk.p030switch.Cdo.m1883do(this);
        com.iproov.sdk.p021new.Cnew newR = this.f748for;
        Orientation orientation = null;
        if (newR == null) {
            newR = null;
        }
        Orientation orientation2 = newR.m1207new();
        Orientation orientation3 = this.f740break;
        if (orientation3 != null) {
            orientation = orientation3;
        }
        this.f742catch = com.iproov.sdk.p017implements.Cgoto.m1007do(orientation2, orientation);
        this.f754this = new com.iproov.sdk.p019interface.Cif(this);
        this.f743class = new com.iproov.sdk.p025public.Cfor(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: default  reason: not valid java name */
    public final AppCompatTextView m863default() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f35class;
    }

    /* renamed from: extends  reason: not valid java name */
    private final AppCompatTextView m887extends() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f36const;
    }

    /* access modifiers changed from: private */
    /* renamed from: finally  reason: not valid java name */
    public final Cprotected m890finally() {
        return com.iproov.sdk.p009do.Cnew.f489do.m577if();
    }

    /* renamed from: implements  reason: not valid java name */
    private final void m900implements() {
        m914return().setImportantForAccessibility(2);
        int i11 = R.string.iproov__prompt_get_ready;
        m897if(i11, Integer.valueOf(i11));
        this.f749goto.m1044do(0);
        m930volatile();
        this.f747final = new Cfinally(this, 2000, 1000).start();
    }

    /* renamed from: instanceof  reason: not valid java name */
    private final void m903instanceof() {
        m931while().m2181do(new Cpackage(this), new d(this), BannerConfig.SCROLL_TIME, 400);
    }

    /* renamed from: interface  reason: not valid java name */
    private final void m904interface() {
        getOnBackPressedDispatcher().i(this, new Cswitch(this));
    }

    /* renamed from: native  reason: not valid java name */
    private final ImageView m905native() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f43this;
    }

    /* renamed from: package  reason: not valid java name */
    private final void m909package() {
        if (isFinishing()) {
            m869do();
        }
    }

    /* renamed from: private  reason: not valid java name */
    private final void m910private() {
        q0.a(getWindow(), false);
        r0 r0Var = new r0(getWindow(), m918super());
        r0Var.a(WindowInsetsCompat.l.b());
        r0Var.d(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: protected  reason: not valid java name */
    public final void m911protected() {
        com.iproov.sdk.p025public.Cfor forR = this.f743class;
        if (forR == null) {
            forR = null;
        }
        forR.m1291for(Cfor.Cdo.START_FLASHING);
        m930volatile();
        m914return().announceForAccessibility(getString(R.string.iproov__accessibility_prompt_scanning));
        m920switch().setImportantForAccessibility(2);
        m874do(Cif.GPA_FLASHING_STARTING);
        m924throw().setVisibility(4);
        m914return().setTextColor(0);
        m914return().setBackgroundColor(0);
        m914return().setVisibility(8);
        m916static().m706catch();
    }

    /* renamed from: public  reason: not valid java name */
    private final Cextends.Cclass m912public() {
        return m890finally().m810static();
    }

    /* renamed from: return  reason: not valid java name */
    private final TextView m914return() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f32break;
    }

    /* access modifiers changed from: private */
    /* renamed from: static  reason: not valid java name */
    public final OpenGLRenderer m916static() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f34catch;
    }

    /* renamed from: strictfp  reason: not valid java name */
    private final void m917strictfp() {
        boolean z11 = false;
        m914return().setVisibility(0);
        m896if(10, 0.9f);
        m871do(m914return(), -1);
        m883do((String) com.iproov.sdk.p017implements.Cimport.m1015do(m912public().m1499super(), ""));
        m927transient();
        if (!m912public().m1487break().isPortrait()) {
            m887extends().setMaxLines(1);
        }
        ImageView imageView = m901import();
        com.iproov.sdk.p019interface.Cif ifVar = this.f754this;
        if (ifVar == null) {
            ifVar = null;
        }
        int i11 = 4;
        imageView.setVisibility(ifVar.m1105catch() ? 0 : 4);
        a();
        m853break();
        m857catch();
        ShimmeringImageView shimmeringImageView = m920switch();
        if (m859class().m238this()) {
            m920switch().m2228if();
            i11 = 0;
        }
        shimmeringImageView.setVisibility(i11);
        HovalayView hovalayView = m931while();
        if (m912public().m1487break() == Orientation.PORTRAIT || m912public().m1487break() == Orientation.REVERSE_PORTRAIT) {
            z11 = true;
        }
        hovalayView.setPortraitMode(z11);
        m931while().setSurroundColor(m912public().m1494final());
    }

    /* renamed from: switch  reason: not valid java name */
    private final ShimmeringImageView m920switch() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f38else;
    }

    /* access modifiers changed from: private */
    /* renamed from: synchronized  reason: not valid java name */
    public final void m921synchronized() {
        m894goto();
        this.f755throw = new com.iproov.sdk.p017implements.Cthrow(1000, false, new e(this));
    }

    /* renamed from: throws  reason: not valid java name */
    private final int m926throws() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: transient  reason: not valid java name */
    private final void m927transient() {
        Cextends.Cgoto gotoR = m912public().m1500this();
        if (gotoR instanceof Cextends.Cgoto.Cdo) {
            ImageView imageView = m905native();
            Cextends.Cgoto gotoR2 = m912public().m1500this();
            Objects.requireNonNull(gotoR2, "null cannot be cast to non-null type com.iproov.sdk.impl.SessionOptions.Icon.BitmapIcon");
            imageView.setImageBitmap(((Cextends.Cgoto.Cdo) gotoR2).m1512do());
        } else if (gotoR instanceof Cextends.Cgoto.Cif) {
            ImageView imageView2 = m905native();
            Cextends.Cgoto gotoR3 = m912public().m1500this();
            Objects.requireNonNull(gotoR3, "null cannot be cast to non-null type com.iproov.sdk.impl.SessionOptions.Icon.DrawableIcon");
            imageView2.setImageDrawable(((Cextends.Cgoto.Cif) gotoR3).m1514do());
        } else if (gotoR instanceof Cextends.Cgoto.Cfor) {
            ImageView imageView3 = m905native();
            Cextends.Cgoto gotoR4 = m912public().m1500this();
            Objects.requireNonNull(gotoR4, "null cannot be cast to non-null type com.iproov.sdk.impl.SessionOptions.Icon.ResourceIcon");
            imageView3.setImageResource(((Cextends.Cgoto.Cfor) gotoR4).m1513do());
        }
    }

    /* renamed from: volatile  reason: not valid java name */
    private final void m930volatile() {
        AccessibilityManager accessibilityManager;
        if (this.f753super == null) {
            Object systemService = getSystemService("accessibility");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            this.f753super = (AccessibilityManager) systemService;
        }
        AccessibilityManager accessibilityManager2 = this.f753super;
        boolean z11 = true;
        if (accessibilityManager2 == null || !accessibilityManager2.isEnabled()) {
            z11 = false;
        }
        if (z11 && (accessibilityManager = this.f753super) != null) {
            accessibilityManager.interrupt();
        }
    }

    public void finish() {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        m916static().setLAEndAnimationFlag(false);
        m894goto();
        m886else();
        super.finish();
    }

    public CoroutineContext getCoroutineContext() {
        return this.f750if;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.iproov.sdk.p002break.Cdo doVar = com.iproov.sdk.p002break.Cdo.m89do(getLayoutInflater());
        this.f756try = doVar;
        if (doVar == null) {
            doVar = null;
        }
        setContentView((View) doVar.getRoot());
        try {
            this.f748for = m890finally().m804if().getValue();
            a1<SurfaceTexture> a1Var = m890finally().m812this();
            com.iproov.sdk.p021new.Cnew newR = this.f748for;
            this.f752new = new com.iproov.sdk.p030switch.Cif(a1Var, newR == null ? null : newR, (CoroutineDispatcher) null, 4, (r) null);
            m862continue();
            m917strictfp();
            n1 unused = i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new Cthrows(this, (c<? super Cthrows>) null), 3, (Object) null);
            m892for();
            m929try();
            m895if();
            m908new();
            m851abstract();
            m904interface();
        } catch (Exception unused2) {
            finish();
        }
    }

    public void onDestroy() {
        m869do();
        m931while().m2183goto();
        m920switch().m2227for();
        this.f749goto.m1043do();
        if (this.f745do.isActive()) {
            n1.a.a(this.f745do, (CancellationException) null, 1, (Object) null);
        }
        super.onDestroy();
    }

    public void onPause() {
        if (!isFinishing() && !this.f751import) {
            n1 unused = i.d(this, v0.a(), (CoroutineStart) null, new Cdefault(this, (c<? super Cdefault>) null), 2, (Object) null);
        }
        this.f751import = false;
        super.onPause();
        m916static().onPause();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (i11 == 2001) {
            if ((!(iArr.length == 0)) && iArr[0] != 0) {
                com.iproov.sdk.p017implements.Ccase.m977do(this);
                n1 unused = i.d(this, v0.a(), (CoroutineStart) null, new Cextends(this, (c<? super Cextends>) null), 2, (Object) null);
            }
        }
    }

    public void onResume() {
        super.onResume();
        m930volatile();
        m916static().onResume();
        m910private();
    }

    public void onStop() {
        com.iproov.sdk.p017implements.Cpublic.m1033if(getWindow(), false);
        com.iproov.sdk.p017implements.Cpublic.m1032do(getWindow(), false);
        m909package();
        super.onStop();
    }

    /* renamed from: break  reason: not valid java name */
    private final void m853break() {
        Cextends.Cgoto gotoR = m912public().m1492do().m1522if();
        if (gotoR instanceof Cextends.Cgoto.Cdo) {
            m860const().setImageBitmap(((Cextends.Cgoto.Cdo) m912public().m1492do().m1522if()).m1512do());
        } else if (gotoR instanceof Cextends.Cgoto.Cif) {
            m860const().setImageDrawable(((Cextends.Cgoto.Cif) m912public().m1492do().m1522if()).m1514do());
        } else if (gotoR instanceof Cextends.Cgoto.Cfor) {
            m860const().setImageResource(((Cextends.Cgoto.Cfor) m912public().m1492do().m1522if()).m1513do());
        }
        m860const().setColorFilter(m912public().m1492do().m1521do(), PorterDuff.Mode.SRC_IN);
        m860const().setOnClickListener(new a(this));
    }

    /* renamed from: case  reason: not valid java name */
    private final void m855case() {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        if (!this.f757while) {
            this.f757while = true;
            com.iproov.sdk.p017implements.Ccase.m977do(this);
            OpenGLRenderer openGLRenderer = m916static();
            com.iproov.sdk.cameray.Ctry tryR = this.f752new;
            if (tryR == null) {
                tryR = null;
            }
            Cextends.Cclass classR = m912public();
            Orientation orientation = this.f742catch;
            if (orientation == null) {
                orientation = null;
            }
            openGLRenderer.m712do(tryR, classR, orientation, m859class().m232do());
            float hovalScaleFactor = m931while().getHovalScaleFactor();
            m916static().setHovalScaleFactor(hovalScaleFactor);
            n1 unused = i.d(this, v0.c(), (CoroutineStart) null, new Ctry(this, hovalScaleFactor, (c<? super Ctry>) null), 2, (Object) null);
        }
    }

    /* renamed from: catch  reason: not valid java name */
    private final void m857catch() {
        Cextends.Ccase caseR = m889final();
        if (caseR instanceof Cextends.Ccase.Cif) {
            m916static().setNaturalFilterStyle(((Cextends.Ccase.Cif) m889final()).m1484do());
        } else if (caseR instanceof Cextends.Ccase.Cdo) {
            m916static().setNaturalFilterStyle(Cextends.Cbreak.CLEAR);
        }
    }

    /* renamed from: class  reason: not valid java name */
    private final com.iproov.sdk.p003case.Cif m859class() {
        return m890finally().m805import().getValue();
    }

    /* renamed from: const  reason: not valid java name */
    private final ImageView m860const() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f41if;
    }

    /* renamed from: else  reason: not valid java name */
    private final void m886else() {
        CountDownTimer countDownTimer = this.f747final;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f747final = null;
        m914return().setImportantForAccessibility(1);
        this.f749goto.m1044do(350);
        m930volatile();
    }

    /* renamed from: final  reason: not valid java name */
    private final Cextends.Ccase m889final() {
        return m912public().m1498new();
    }

    /* renamed from: for  reason: not valid java name */
    private final void m892for() {
        Typeface typeface;
        Cextends.Celse elseR = m912public().m1502try();
        if (elseR instanceof Cextends.Celse.Cif) {
            Cextends.Celse elseR2 = m912public().m1502try();
            Objects.requireNonNull(elseR2, "null cannot be cast to non-null type com.iproov.sdk.impl.SessionOptions.Font.ResourceFont");
            typeface = com.iproov.sdk.p017implements.Csuper.m1037do((Context) this, ((Cextends.Celse.Cif) elseR2).m1509do());
        } else if (elseR instanceof Cextends.Celse.Cdo) {
            Cextends.Celse elseR3 = m912public().m1502try();
            Objects.requireNonNull(elseR3, "null cannot be cast to non-null type com.iproov.sdk.impl.SessionOptions.Font.PathFont");
            typeface = com.iproov.sdk.p017implements.Csuper.m1038do((Context) this, ((Cextends.Celse.Cdo) elseR3).m1508do());
        } else {
            typeface = null;
        }
        if (typeface != null) {
            com.iproov.sdk.p017implements.Csuper.m1039do(m914return(), typeface);
            com.iproov.sdk.p017implements.Csuper.m1039do((TextView) m887extends(), typeface);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: goto  reason: not valid java name */
    public final void m894goto() {
        com.iproov.sdk.p017implements.Cthrow throwR = this.f755throw;
        if (throwR != null) {
            throwR.m1042do();
        }
        this.f755throw = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public static final void m899if(Cdo doVar, com.iproov.sdk.p030switch.Cfor forR) {
        doVar.m882do(forR);
    }

    /* access modifiers changed from: private */
    /* renamed from: import  reason: not valid java name */
    public final ImageView m901import() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f33case;
    }

    /* access modifiers changed from: private */
    /* renamed from: native  reason: not valid java name */
    public static final void m906native(Cdo doVar) {
        if (ContextCompat.checkSelfPermission(doVar, "android.permission.CAMERA") == 0) {
            doVar.m855case();
        } else {
            com.iproov.sdk.p017implements.Ccase.m977do(doVar);
            doVar.f751import = true;
            ActivityCompat.requestPermissions(doVar, new String[]{"android.permission.CAMERA"}, 2001);
        }
        n1 unused = i.d(doVar, v0.a(), (CoroutineStart) null, new Celse(doVar, (c<? super Celse>) null), 2, (Object) null);
    }

    /* renamed from: new  reason: not valid java name */
    private final void m908new() {
        if (m859class().m232do() == com.iproov.sdk.p003case.Cdo.GENUINE_PRESENCE_ASSURANCE) {
            if (m859class().m231catch()) {
                m874do(Cif.GPA_INIT_SUPPLEMENTARY);
            } else {
                m874do(Cif.GPA_INIT_NO_SUPPLEMENTARY);
            }
        }
        if (m859class().m232do() == com.iproov.sdk.p003case.Cdo.LIVENESS) {
            m874do(Cif.LIVENESS_INIT);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: public  reason: not valid java name */
    public static final void m913public(Cdo doVar) {
        n1 unused = i.d(doVar, v0.c().G(), (CoroutineStart) null, new Cprivate(doVar, (c<? super Cprivate>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: return  reason: not valid java name */
    public static final void m915return(Cdo doVar) {
        doVar.m874do(Cif.LIVENESS_STOP_SCAN);
    }

    /* renamed from: super  reason: not valid java name */
    private final FrameLayout m918super() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f39for;
    }

    /* access modifiers changed from: private */
    /* renamed from: this  reason: not valid java name */
    public final void m923this() {
        n1 unused = i.d(this, v0.c(), (CoroutineStart) null, new Ccase(this, (c<? super Ccase>) null), 2, (Object) null);
    }

    /* renamed from: throw  reason: not valid java name */
    private final FrameLayout m924throw() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f42new;
    }

    /* renamed from: try  reason: not valid java name */
    private final void m929try() {
        m910private();
        if (!m912public().m1495for()) {
            getWindow().setFlags(8192, 8192);
        }
        com.iproov.sdk.p025public.Cnew newR = new com.iproov.sdk.p025public.Cnew(getWindow());
        newR.m1307do(true);
        newR.m1308if(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: while  reason: not valid java name */
    public final HovalayView m931while() {
        com.iproov.sdk.p002break.Cdo doVar = this.f756try;
        if (doVar == null) {
            doVar = null;
        }
        return doVar.f44try;
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public final void m896if(int i11, float f11) {
        int i12 = m864do(i11, f11);
        ViewGroup.LayoutParams layoutParams = m914return().getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = i12;
        m914return().setLayoutParams(layoutParams2);
        m914return().setMaxWidth((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d));
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public static final void m881do(Cdo doVar, com.iproov.sdk.p030switch.Cfor forR) {
        com.iproov.sdk.p017implements.Cimport.m1017do((Runnable) new f(doVar, forR));
    }

    /* renamed from: do  reason: not valid java name */
    private final int m864do(int i11, float f11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i12 = (int) (((float) displayMetrics.widthPixels) * f11 * 1.3333334f);
        return ((displayMetrics.heightPixels / 2) - (i12 / 2)) + ((i12 / 100) * i11);
    }

    /* renamed from: if  reason: not valid java name */
    private final void m895if() {
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        m887extends().setTextColor(m912public().m1501throw());
        if (!(m912public().m1487break() == Orientation.LANDSCAPE || m912public().m1487break() == Orientation.REVERSE_LANDSCAPE)) {
            m924throw().setBackgroundColor(m912public().m1493else());
            m924throw().setPadding(0, m926throws(), 0, 0);
        }
        m914return().setTextColor(m912public().m1491const());
        PaintDrawable paintDrawable = new PaintDrawable();
        if (m912public().m1490class()) {
            paintDrawable.setCornerRadius(getResources().getDimension(R.dimen.iproov__prompt_text_corner_radius));
        }
        m914return().setBackground(paintDrawable);
        m870do(m912public().m1489catch());
        if (m859class().m232do() == com.iproov.sdk.p003case.Cdo.LIVENESS) {
            m931while().setHovalEndColor(m912public().m1496goto().m1505do());
        } else {
            m931while().setHovalEndColor(m912public().m1488case().m1504if());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: do  reason: not valid java name */
    public static final void m878do(Cdo doVar, View view) {
        doVar.onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m882do(com.iproov.sdk.p030switch.Cfor forR) {
        if (forR != null && (!x.b(forR.m1886if(), m914return().getText().toString()))) {
            m872do(m914return(), forR.m1886if(), forR.m1885do());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m866do(h0 h0Var, c<? super n1> cVar) {
        h0 h0Var2 = h0Var;
        n1 unused = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cfinal(this, (c<? super Cfinal>) null), 2, (Object) null);
        h0 h0Var3 = h0Var;
        n1 unused2 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Csuper(this, (c<? super Csuper>) null), 2, (Object) null);
        n1 unused3 = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cthrow(this, (c<? super Cthrow>) null), 2, (Object) null);
        n1 unused4 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Cwhile(this, (c<? super Cwhile>) null), 2, (Object) null);
        n1 unused5 = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cimport(this, (c<? super Cimport>) null), 2, (Object) null);
        n1 unused6 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Cnative(this, (c<? super Cnative>) null), 2, (Object) null);
        n1 unused7 = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cpublic(this, (c<? super Cpublic>) null), 2, (Object) null);
        n1 unused8 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Creturn(this, (c<? super Creturn>) null), 2, (Object) null);
        n1 unused9 = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cstatic(this, (c<? super Cstatic>) null), 2, (Object) null);
        n1 unused10 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Cgoto(this, (c<? super Cgoto>) null), 2, (Object) null);
        n1 unused11 = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cthis(this, (c<? super Cthis>) null), 2, (Object) null);
        n1 unused12 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Cbreak(this, (c<? super Cbreak>) null), 2, (Object) null);
        n1 unused13 = i.d(h0Var2, v0.a(), (CoroutineStart) null, new Ccatch(this, (c<? super Ccatch>) null), 2, (Object) null);
        n1 unused14 = i.d(h0Var3, v0.a(), (CoroutineStart) null, new Cclass(this, (c<? super Cclass>) null), 2, (Object) null);
        return i.d(h0Var2, v0.a(), (CoroutineStart) null, new Cconst(this, (c<? super Cconst>) null), 2, (Object) null);
    }

    /* renamed from: if  reason: not valid java name */
    private final void m897if(int i11, Integer num) {
        m884do(getString(i11), num == null ? null : getString(num.intValue()));
    }

    /* renamed from: do  reason: not valid java name */
    private final void m869do() {
        m916static().m708const();
        n1 unused = i.d(this, v0.c(), (CoroutineStart) null, new Cnew(this, (c<? super Cnew>) null), 2, (Object) null);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m871do(TextView textView, int i11) {
        if (i11 == -1) {
            textView.setText("");
            textView.setVisibility(4);
            return;
        }
        textView.setText(i11);
        textView.setVisibility(0);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m872do(TextView textView, String str, String str2) {
        if (str != null) {
            boolean z11 = true;
            if (!(str.length() == 0)) {
                boolean z12 = str2 != null;
                m914return().setImportantForAccessibility(z12 ? 1 : 2);
                textView.setText(str);
                if (z12) {
                    if (!(str2 == null || str2.length() == 0)) {
                        z11 = false;
                    }
                    if (!z11) {
                        m930volatile();
                        m914return().announceForAccessibility(str2);
                    }
                }
                textView.setVisibility(0);
                return;
            }
        }
        textView.setText("");
        textView.setContentDescription("");
        textView.setVisibility(4);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m883do(String str) {
        m887extends().setVisibility(0);
        if (!x.b(str, m887extends().getText().toString())) {
            m887extends().announceForAccessibility(str);
        }
        m887extends().setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m874do(Cif ifVar) {
        Cif ifVar2 = this.f744const;
        if (ifVar2 != ifVar) {
            if (ifVar != Cif.LIVENESS_SUPPLEMENTARY_FRAME || (ifVar2 != Cif.LIVENESS_SCAN && ifVar2 != Cif.LIVENESS_STOP_SCAN && ifVar2 != Cif.LIVENESS_FINISH)) {
                switch (Cfor.f796do[ifVar.ordinal()]) {
                    case 1:
                        m931while().setForegroundGColor(m912public().m1488case().m1503do());
                        break;
                    case 2:
                        m914return().setVisibility(4);
                        m931while().m2176case();
                        break;
                    case 3:
                        m931while().setForegroundGColor(m912public().m1496goto().m1505do());
                        m903instanceof();
                        break;
                    case 4:
                    case 5:
                        m931while().m2182else();
                        m931while().setForegroundGColor(m912public().m1488case().m1503do());
                        break;
                    case 6:
                        m931while().setForegroundGColor(m912public().m1496goto().m1506if());
                        break;
                }
                this.f744const = ifVar;
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private final void m870do(int i11) {
        Drawable background = m914return().getBackground();
        if (background instanceof PaintDrawable) {
            ((PaintDrawable) background).getPaint().setColor(i11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m873do(com.iproov.sdk.p015goto.Cif ifVar) {
        int[] iArr = Cfor.f797if;
        Pair<Integer, Integer> pair = null;
        switch (iArr[ifVar.ordinal()]) {
            case 1:
                m874do(Cif.LIVENESS_FINISH);
                break;
            case 2:
                m874do(Cif.GPA_FACE);
                com.iproov.sdk.p025public.Cfor forR = this.f743class;
                if (forR == null) {
                    forR = null;
                }
                forR.m1291for(Cfor.Cdo.FACE_FOUND);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                if (this.f747final != null) {
                    m886else();
                }
                m874do(Cif.GPA_NO_FACE);
                break;
        }
        m931while().m2180do(ifVar);
        switch (iArr[ifVar.ordinal()]) {
            case 1:
                int i11 = R.string.iproov__prompt_liveness_scan_completed;
                pair = m867do(i11, Integer.valueOf(i11));
                break;
            case 2:
                if (this.f747final == null) {
                    m900implements();
                    break;
                }
                break;
            case 3:
                pair = m867do(R.string.iproov__prompt_align_face, Integer.valueOf(R.string.iproov__accessibility_prompt_align_face));
                break;
            case 4:
                pair = m867do(R.string.iproov__prompt_align_face, Integer.valueOf(R.string.iproov__accessibility_prompt_align_face));
                break;
            case 5:
                int i12 = R.string.iproov__prompt_too_far;
                pair = m867do(i12, Integer.valueOf(i12));
                break;
            case 6:
                int i13 = R.string.iproov__prompt_too_close;
                pair = m867do(i13, Integer.valueOf(i13));
                break;
            case 7:
                pair = m867do(R.string.iproov__prompt_align_face, Integer.valueOf(R.string.iproov__accessibility_prompt_align_face));
                break;
            case 8:
                int i14 = R.string.iproov__prompt_too_far;
                pair = m867do(i14, Integer.valueOf(i14));
                break;
            case 9:
                int i15 = R.string.iproov__prompt_too_close;
                pair = m867do(i15, Integer.valueOf(i15));
                break;
            case 10:
                int i16 = R.string.iproov__prompt_too_bright;
                pair = m867do(i16, Integer.valueOf(i16));
                break;
            case 11:
                pair = m868do(this, R.string.iproov__prompt_roll_too_high, (Integer) null, 2, (Object) null);
                break;
            case 12:
                pair = m868do(this, R.string.iproov__prompt_roll_too_low, (Integer) null, 2, (Object) null);
                break;
            case 13:
                pair = m868do(this, R.string.iproov__prompt_yaw_too_high, (Integer) null, 2, (Object) null);
                break;
            case 14:
                pair = m868do(this, R.string.iproov__prompt_yaw_too_low, (Integer) null, 2, (Object) null);
                break;
            case 15:
                pair = m868do(this, R.string.iproov__prompt_pitch_too_low, (Integer) null, 2, (Object) null);
                break;
            case 16:
                pair = m868do(this, R.string.iproov__prompt_pitch_too_high, (Integer) null, 2, (Object) null);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (pair != null) {
            m897if(pair.getFirst().intValue(), pair.getSecond());
        }
    }

    /* renamed from: do  reason: not valid java name */
    private final Pair<Integer, Integer> m867do(int i11, Integer num) {
        return new Pair<>(Integer.valueOf(i11), num);
    }

    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ Pair m868do(Cdo doVar, int i11, Integer num, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                num = null;
            }
            return doVar.m867do(i11, num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pair");
    }

    /* renamed from: do  reason: not valid java name */
    private final void m884do(String str, String str2) {
        this.f749goto.m1045do(new com.iproov.sdk.p030switch.Cfor(str, str2));
    }
}
