package com.iproov.sdk.p026return;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import d10.r;
import d10.s;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.case  reason: invalid class name and invalid package */
public final class Ccase extends BaseCoroutineScope {
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public final j1<String> f1267break;
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final j1<com.iproov.sdk.p017implements.Cthis> f1268case;
    /* access modifiers changed from: private */

    /* renamed from: catch  reason: not valid java name */
    public final f1<String> f1269catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public final f1<FaceFeature> f1270class;

    /* renamed from: const  reason: not valid java name */
    private final b1<String> f1271const;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final j1<com.iproov.sdk.p021new.Cnew> f1272do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public final j1<com.iproov.sdk.p017implements.Cthis> f1273else;
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public final com.iproov.sdk.p019interface.Cif f1274final;
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public final j1<String> f1275for;
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public final j1<com.iproov.sdk.p017implements.Cthis> f1276goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final j1<Size> f1277if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final j1<Cconst> f1278new;
    /* access modifiers changed from: private */

    /* renamed from: super  reason: not valid java name */
    public final String[] f1279super;
    /* access modifiers changed from: private */

    /* renamed from: this  reason: not valid java name */
    public final j1<Size> f1280this;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final j1<com.iproov.sdk.p017implements.Cthis> f1281try;

    /* renamed from: com.iproov.sdk.return.case$break  reason: invalid class name */
    public static final class Cbreak {

        /* renamed from: do  reason: not valid java name */
        private final float f1282do;

        /* renamed from: for  reason: not valid java name */
        private final float f1283for;

        /* renamed from: if  reason: not valid java name */
        private final float f1284if;

        /* renamed from: new  reason: not valid java name */
        private final float f1285new;

        public Cbreak(float f11, float f12, float f13, float f14) {
            this.f1282do = f11;
            this.f1284if = f12;
            this.f1283for = f13;
            this.f1285new = f14;
        }

        /* renamed from: do  reason: not valid java name */
        public final float m1392do() {
            return this.f1282do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cbreak)) {
                return false;
            }
            Cbreak breakR = (Cbreak) obj;
            return x.b(Float.valueOf(this.f1282do), Float.valueOf(breakR.f1282do)) && x.b(Float.valueOf(this.f1284if), Float.valueOf(breakR.f1284if)) && x.b(Float.valueOf(this.f1283for), Float.valueOf(breakR.f1283for)) && x.b(Float.valueOf(this.f1285new), Float.valueOf(breakR.f1285new));
        }

        /* renamed from: for  reason: not valid java name */
        public final float m1393for() {
            return this.f1285new;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f1282do) * 31) + Float.floatToIntBits(this.f1284if)) * 31) + Float.floatToIntBits(this.f1283for)) * 31) + Float.floatToIntBits(this.f1285new);
        }

        /* renamed from: if  reason: not valid java name */
        public final float m1394if() {
            return this.f1283for;
        }

        /* renamed from: new  reason: not valid java name */
        public final float m1395new() {
            return this.f1284if;
        }

        public String toString() {
            return "FPSWrapper(camera=" + this.f1282do + ", render=" + this.f1284if + ", encoder=" + this.f1283for + ", faceDetector=" + this.f1285new + ')';
        }
    }

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$6", f = "DebugDataSnapshot.kt", l = {136}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$case  reason: invalid class name */
    public static final class Ccase extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1286do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Ccase f1287if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$6$2", f = "DebugDataSnapshot.kt", l = {134}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$case$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<String, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1288do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1289for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1290if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Ccase caseR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1289for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f1289for, cVar);
                doVar.f1290if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(String str, c<? super Unit> cVar) {
                return ((Cdo) create(str, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1288do;
                if (i11 == 0) {
                    k.b(obj);
                    this.f1289for.f1279super[Cthis.LIGHTING_DETECTOR.ordinal()] = (String) this.f1290if;
                    Ccase caseR = this.f1289for;
                    this.f1288do = 1;
                    if (caseR.m1380do("lightingDetectorDebug", (c<? super Unit>) this) == d11) {
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

        /* renamed from: com.iproov.sdk.return.case$case$if  reason: invalid class name */
        public static final class Cif implements kotlinx.coroutines.flow.d<String> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ kotlinx.coroutines.flow.d f1291do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Ccase f1292if;

            /* renamed from: com.iproov.sdk.return.case$case$if$do  reason: invalid class name */
            public static final class Cdo implements e<String> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ e f1293do;

                /* renamed from: if  reason: not valid java name */
                public final /* synthetic */ Ccase f1294if;

                @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$6$invokeSuspend$$inlined$filter$1$2", f = "DebugDataSnapshot.kt", l = {137}, m = "emit")
                /* renamed from: com.iproov.sdk.return.case$case$if$do$do  reason: invalid class name */
                public static final class Cdo extends ContinuationImpl {

                    /* renamed from: do  reason: not valid java name */
                    public /* synthetic */ Object f1295do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cdo f1296for;

                    /* renamed from: if  reason: not valid java name */
                    public int f1297if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cdo(Cdo doVar, c cVar) {
                        super(cVar);
                        this.f1296for = doVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f1295do = obj;
                        this.f1297if |= Integer.MIN_VALUE;
                        return this.f1296for.emit((Object) null, this);
                    }
                }

                public Cdo(e eVar, Ccase caseR) {
                    this.f1293do = eVar;
                    this.f1294if = caseR;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.iproov.sdk.p026return.Ccase.Ccase.Cif.Cdo.Cdo
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.iproov.sdk.return.case$case$if$do$do r0 = (com.iproov.sdk.p026return.Ccase.Ccase.Cif.Cdo.Cdo) r0
                        int r1 = r0.f1297if
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f1297if = r1
                        goto L_0x0018
                    L_0x0013:
                        com.iproov.sdk.return.case$case$if$do$do r0 = new com.iproov.sdk.return.case$case$if$do$do
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f1295do
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r2 = r0.f1297if
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.k.b(r6)
                        goto L_0x004e
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.k.b(r6)
                        kotlinx.coroutines.flow.e r6 = r4.f1293do
                        r2 = r5
                        java.lang.String r2 = (java.lang.String) r2
                        com.iproov.sdk.return.case r2 = r4.f1294if
                        com.iproov.sdk.interface.if r2 = r2.f1274final
                        boolean r2 = r2.m1105catch()
                        if (r2 == 0) goto L_0x004e
                        r0.f1297if = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L_0x004e
                        return r1
                    L_0x004e:
                        kotlin.Unit r5 = kotlin.Unit.f56620a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Ccase.Ccase.Cif.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            public Cif(kotlinx.coroutines.flow.d dVar, Ccase caseR) {
                this.f1291do = dVar;
                this.f1292if = caseR;
            }

            public Object collect(e eVar, c cVar) {
                Object collect = this.f1291do.collect(new Cdo(eVar, this.f1292if), cVar);
                if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                    return collect;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccase(Ccase caseR, c<? super Ccase> cVar) {
            super(2, cVar);
            this.f1287if = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Ccase(this.f1287if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ccase) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1286do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d P = f.P(new Cif(this.f1287if.f1269catch, this.f1287if), new Cdo(this.f1287if, (c<? super Cdo>) null));
                this.f1286do = 1;
                if (f.h(P, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$1", f = "DebugDataSnapshot.kt", l = {67}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1298do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Ccase f1299if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$1$1", f = "DebugDataSnapshot.kt", l = {65}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$do$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<Cconst, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1300do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1301for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1302if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Ccase caseR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1301for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f1301for, cVar);
                doVar.f1302if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(Cconst constR, c<? super Unit> cVar) {
                return ((Cdo) create(constR, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1300do;
                if (i11 == 0) {
                    k.b(obj);
                    Cconst constR = (Cconst) this.f1302if;
                    this.f1301for.f1279super[Cthis.CAMERA_SDK.ordinal()] = x.i("Camera: ", constR == null ? "N/A" : constR);
                    Ccase caseR = this.f1301for;
                    String i12 = x.i("cameraSDK ", constR);
                    this.f1300do = 1;
                    if (caseR.m1380do(i12, (c<? super Unit>) this) == d11) {
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
        public Cdo(Ccase caseR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1299if = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1299if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1298do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d P = f.P(this.f1299if.f1278new, new Cdo(this.f1299if, (c<? super Cdo>) null));
                this.f1298do = 1;
                if (f.h(P, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$7", f = "DebugDataSnapshot.kt", l = {144}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$else  reason: invalid class name */
    public static final class Celse extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1303do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Ccase f1304if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$7$1", f = "DebugDataSnapshot.kt", l = {142}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$else$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<FaceFeature, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1305do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1306for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1307if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Ccase caseR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1306for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f1306for, cVar);
                doVar.f1307if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(FaceFeature faceFeature, c<? super Unit> cVar) {
                return ((Cdo) create(faceFeature, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1305do;
                if (i11 == 0) {
                    k.b(obj);
                    FaceFeature faceFeature = (FaceFeature) this.f1307if;
                    this.f1306for.f1279super[Cthis.POSE.ordinal()] = x.i("Feature: ", this.f1306for.m1381do(faceFeature == null ? null : faceFeature.getPose()));
                    Ccase caseR = this.f1306for;
                    this.f1305do = 1;
                    if (caseR.m1380do("faceFeatureFlow", (c<? super Unit>) this) == d11) {
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
        public Celse(Ccase caseR, c<? super Celse> cVar) {
            super(2, cVar);
            this.f1304if = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Celse(this.f1304if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Celse) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1303do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d P = f.P(this.f1304if.f1270class, new Cdo(this.f1304if, (c<? super Cdo>) null));
                this.f1303do = 1;
                if (f.h(P, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$3", f = "DebugDataSnapshot.kt", l = {104, 111}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$for  reason: invalid class name */
    public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1308do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Ccase f1309for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1310if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$3$1", f = "DebugDataSnapshot.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$for$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements s<com.iproov.sdk.p017implements.Cthis, com.iproov.sdk.p017implements.Cthis, com.iproov.sdk.p017implements.Cthis, com.iproov.sdk.p017implements.Cthis, c<? super Cbreak>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1311do;

            /* renamed from: for  reason: not valid java name */
            public /* synthetic */ Object f1312for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1313if;

            /* renamed from: new  reason: not valid java name */
            public /* synthetic */ Object f1314new;

            /* renamed from: try  reason: not valid java name */
            public /* synthetic */ Object f1315try;

            public Cdo(c<? super Cdo> cVar) {
                super(5, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(com.iproov.sdk.p017implements.Cthis thisR, com.iproov.sdk.p017implements.Cthis thisR2, com.iproov.sdk.p017implements.Cthis thisR3, com.iproov.sdk.p017implements.Cthis thisR4, c<? super Cbreak> cVar) {
                Cdo doVar = new Cdo(cVar);
                doVar.f1313if = thisR;
                doVar.f1312for = thisR2;
                doVar.f1314new = thisR3;
                doVar.f1315try = thisR4;
                return doVar.invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1311do == 0) {
                    k.b(obj);
                    return new Cbreak((float) ((com.iproov.sdk.p017implements.Cthis) this.f1313if).m1040do(), (float) ((com.iproov.sdk.p017implements.Cthis) this.f1315try).m1040do(), (float) ((com.iproov.sdk.p017implements.Cthis) this.f1314new).m1040do(), (float) ((com.iproov.sdk.p017implements.Cthis) this.f1312for).m1040do());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.return.case$for$for  reason: invalid class name */
        public static final class Cfor implements kotlinx.coroutines.flow.d<Cbreak> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ kotlinx.coroutines.flow.d f1316do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Ccase f1317if;

            /* renamed from: com.iproov.sdk.return.case$for$for$do  reason: invalid class name */
            public static final class Cdo implements e<Cbreak> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ e f1318do;

                /* renamed from: if  reason: not valid java name */
                public final /* synthetic */ Ccase f1319if;

                @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$3$invokeSuspend$$inlined$filter$1$2", f = "DebugDataSnapshot.kt", l = {137}, m = "emit")
                /* renamed from: com.iproov.sdk.return.case$for$for$do$do  reason: invalid class name */
                public static final class Cdo extends ContinuationImpl {

                    /* renamed from: do  reason: not valid java name */
                    public /* synthetic */ Object f1320do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cdo f1321for;

                    /* renamed from: if  reason: not valid java name */
                    public int f1322if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cdo(Cdo doVar, c cVar) {
                        super(cVar);
                        this.f1321for = doVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f1320do = obj;
                        this.f1322if |= Integer.MIN_VALUE;
                        return this.f1321for.emit((Object) null, this);
                    }
                }

                public Cdo(e eVar, Ccase caseR) {
                    this.f1318do = eVar;
                    this.f1319if = caseR;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.iproov.sdk.p026return.Ccase.Cfor.Cfor.Cdo.Cdo
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.iproov.sdk.return.case$for$for$do$do r0 = (com.iproov.sdk.p026return.Ccase.Cfor.Cfor.Cdo.Cdo) r0
                        int r1 = r0.f1322if
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f1322if = r1
                        goto L_0x0018
                    L_0x0013:
                        com.iproov.sdk.return.case$for$for$do$do r0 = new com.iproov.sdk.return.case$for$for$do$do
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f1320do
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r2 = r0.f1322if
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.k.b(r6)
                        goto L_0x004e
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.k.b(r6)
                        kotlinx.coroutines.flow.e r6 = r4.f1318do
                        r2 = r5
                        com.iproov.sdk.return.case$break r2 = (com.iproov.sdk.p026return.Ccase.Cbreak) r2
                        com.iproov.sdk.return.case r2 = r4.f1319if
                        com.iproov.sdk.interface.if r2 = r2.f1274final
                        boolean r2 = r2.m1105catch()
                        if (r2 == 0) goto L_0x004e
                        r0.f1322if = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L_0x004e
                        return r1
                    L_0x004e:
                        kotlin.Unit r5 = kotlin.Unit.f56620a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Ccase.Cfor.Cfor.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            public Cfor(kotlinx.coroutines.flow.d dVar, Ccase caseR) {
                this.f1316do = dVar;
                this.f1317if = caseR;
            }

            public Object collect(e eVar, c cVar) {
                Object collect = this.f1316do.collect(new Cdo(eVar, this.f1317if), cVar);
                if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                    return collect;
                }
                return Unit.f56620a;
            }
        }

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$3$3", f = "DebugDataSnapshot.kt", l = {109}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$for$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<Cbreak, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1323do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1324for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1325if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Ccase caseR, c<? super Cif> cVar) {
                super(2, cVar);
                this.f1324for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cif ifVar = new Cif(this.f1324for, cVar);
                ifVar.f1325if = obj;
                return ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(Cbreak breakR, c<? super Unit> cVar) {
                return ((Cif) create(breakR, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1323do;
                if (i11 == 0) {
                    k.b(obj);
                    Cbreak breakR = (Cbreak) this.f1325if;
                    String[] strArr = this.f1324for.f1279super;
                    int ordinal = Cthis.CAMERA_FPS.ordinal();
                    strArr[ordinal] = "FPS: renderer: " + String.format("%.1f", Arrays.copyOf(new Object[]{a.b(breakR.m1395new())}, 1)) + " camera: " + String.format("%.1f", Arrays.copyOf(new Object[]{a.b(breakR.m1392do())}, 1)) + "\nFPS: encoder: " + String.format("%.1f", Arrays.copyOf(new Object[]{a.b(breakR.m1394if())}, 1)) + " faceDetector: " + String.format("%.1f", Arrays.copyOf(new Object[]{a.b(breakR.m1393for())}, 1));
                    Ccase caseR = this.f1324for;
                    this.f1323do = 1;
                    if (caseR.m1380do("cameraFPS", (c<? super Unit>) this) == d11) {
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
        public Cfor(Ccase caseR, c<? super Cfor> cVar) {
            super(2, cVar);
            this.f1309for = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cfor forR = new Cfor(this.f1309for, cVar);
            forR.f1310if = obj;
            return forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1308do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d l11 = f.l(this.f1309for.f1281try, this.f1309for.f1276goto, this.f1309for.f1273else, this.f1309for.f1268case, new Cdo((c<? super Cdo>) null));
                this.f1308do = 1;
                obj = f.Z(l11, (h0) this.f1310if, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else if (i11 == 2) {
                k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlinx.coroutines.flow.d P = f.P(new Cfor((kotlinx.coroutines.flow.d) obj, this.f1309for), new Cif(this.f1309for, (c<? super Cif>) null));
            this.f1308do = 2;
            if (f.h(P, this) == d11) {
                return d11;
            }
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.return.case$goto  reason: invalid class name */
    public static final class Cgoto {

        /* renamed from: do  reason: not valid java name */
        private final com.iproov.sdk.p021new.Cnew f1326do;

        /* renamed from: for  reason: not valid java name */
        private final Size f1327for;

        /* renamed from: if  reason: not valid java name */
        private final Size f1328if;

        public Cgoto(com.iproov.sdk.p021new.Cnew newR, Size size, Size size2) {
            this.f1326do = newR;
            this.f1328if = size;
            this.f1327for = size2;
        }

        /* renamed from: do  reason: not valid java name */
        public final com.iproov.sdk.p021new.Cnew m1405do() {
            return this.f1326do;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cgoto)) {
                return false;
            }
            Cgoto gotoR = (Cgoto) obj;
            return x.b(this.f1326do, gotoR.f1326do) && x.b(this.f1328if, gotoR.f1328if) && x.b(this.f1327for, gotoR.f1327for);
        }

        /* renamed from: for  reason: not valid java name */
        public final Size m1406for() {
            return this.f1327for;
        }

        public int hashCode() {
            com.iproov.sdk.p021new.Cnew newR = this.f1326do;
            int i11 = 0;
            int hashCode = (newR == null ? 0 : newR.hashCode()) * 31;
            Size size = this.f1328if;
            int hashCode2 = (hashCode + (size == null ? 0 : size.hashCode())) * 31;
            Size size2 = this.f1327for;
            if (size2 != null) {
                i11 = size2.hashCode();
            }
            return hashCode2 + i11;
        }

        /* renamed from: if  reason: not valid java name */
        public final Size m1407if() {
            return this.f1328if;
        }

        public String toString() {
            return "CameraWrapper(cameraInfo=" + this.f1326do + ", previewSize=" + this.f1328if + ", rendererSize=" + this.f1327for + ')';
        }
    }

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$2", f = "DebugDataSnapshot.kt", l = {89}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1329do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Ccase f1330if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$2$1", f = "DebugDataSnapshot.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$if$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements r<com.iproov.sdk.p021new.Cnew, Size, Size, c<? super Cgoto>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1331do;

            /* renamed from: for  reason: not valid java name */
            public /* synthetic */ Object f1332for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1333if;

            /* renamed from: new  reason: not valid java name */
            public /* synthetic */ Object f1334new;

            public Cdo(c<? super Cdo> cVar) {
                super(4, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(com.iproov.sdk.p021new.Cnew newR, Size size, Size size2, c<? super Cgoto> cVar) {
                Cdo doVar = new Cdo(cVar);
                doVar.f1333if = newR;
                doVar.f1332for = size;
                doVar.f1334new = size2;
                return doVar.invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1331do == 0) {
                    k.b(obj);
                    return new Cgoto((com.iproov.sdk.p021new.Cnew) this.f1333if, (Size) this.f1332for, (Size) this.f1334new);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$2$2", f = "DebugDataSnapshot.kt", l = {87}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$if$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<Cgoto, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1335do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1336for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1337if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Ccase caseR, c<? super Cif> cVar) {
                super(2, cVar);
                this.f1336for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cif ifVar = new Cif(this.f1336for, cVar);
                ifVar.f1337if = obj;
                return ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(Cgoto gotoR, c<? super Unit> cVar) {
                return ((Cif) create(gotoR, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                String str;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1335do;
                if (i11 == 0) {
                    k.b(obj);
                    Cgoto gotoR = (Cgoto) this.f1337if;
                    String str2 = "N/A";
                    if (gotoR.m1405do() == null) {
                        str = str2;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        Size size = gotoR.m1407if();
                        String str3 = null;
                        sb2.append(size == null ? null : a.c(size.getWidth()).toString());
                        sb2.append(" x ");
                        Size size2 = gotoR.m1407if();
                        if (size2 != null) {
                            str3 = a.c(size2.getHeight()).toString();
                        }
                        sb2.append(str3);
                        str = sb2.toString();
                    }
                    Size size3 = gotoR.m1406for();
                    if (size3 != null) {
                        String str4 = size3.getWidth() + " x " + size3.getHeight();
                        if (str4 != null) {
                            str2 = str4;
                        }
                    }
                    this.f1336for.f1279super[Cthis.CAMERA_PREVIEW.ordinal()] = "Preview: " + str + " Display: " + str2;
                    Ccase caseR = this.f1336for;
                    this.f1335do = 1;
                    if (caseR.m1380do("cameraInfo", (c<? super Unit>) this) == d11) {
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
        public Cif(Ccase caseR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1330if = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1330if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1329do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d P = f.P(f.k(this.f1330if.f1272do, this.f1330if.f1277if, this.f1330if.f1280this, new Cdo((c<? super Cdo>) null)), new Cif(this.f1330if, (c<? super Cif>) null));
                this.f1329do = 1;
                if (f.h(P, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$4", f = "DebugDataSnapshot.kt", l = {119}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1338do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Ccase f1339if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$4$1", f = "DebugDataSnapshot.kt", l = {117}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$new$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<String, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1340do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1341for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1342if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Ccase caseR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1341for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f1341for, cVar);
                doVar.f1342if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(String str, c<? super Unit> cVar) {
                return ((Cdo) create(str, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1340do;
                if (i11 == 0) {
                    k.b(obj);
                    String str = (String) this.f1342if;
                    String[] strArr = this.f1341for.f1279super;
                    int ordinal = Cthis.FACE_DETECTOR_NAME.ordinal();
                    if (str == null) {
                        str = "N/A";
                    }
                    strArr[ordinal] = x.i("Face detector: ", str);
                    Ccase caseR = this.f1341for;
                    this.f1340do = 1;
                    if (caseR.m1380do("faceDetectorName", (c<? super Unit>) this) == d11) {
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
        public Cnew(Ccase caseR, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f1339if = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cnew(this.f1339if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1338do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d P = f.P(this.f1339if.f1267break, new Cdo(this.f1339if, (c<? super Cdo>) null));
                this.f1338do = 1;
                if (f.h(P, this) == d11) {
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

    /* renamed from: com.iproov.sdk.return.case$this  reason: invalid class name */
    public enum Cthis {
        CAMERA_SDK,
        CAMERA_PREVIEW,
        CAMERA_FPS,
        FACE_DETECTOR_NAME,
        ENCODER,
        LIGHTING_DETECTOR,
        POSE
    }

    @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$5", f = "DebugDataSnapshot.kt", l = {127}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.case$try  reason: invalid class name */
    public static final class Ctry extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1351do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Ccase f1352if;

        @d(c = "com.iproov.sdk.impl.DebugDataSnapshot$5$1", f = "DebugDataSnapshot.kt", l = {125}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.case$try$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<String, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1353do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Ccase f1354for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1355if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Ccase caseR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1354for = caseR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f1354for, cVar);
                doVar.f1355if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(String str, c<? super Unit> cVar) {
                return ((Cdo) create(str, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1353do;
                if (i11 == 0) {
                    k.b(obj);
                    this.f1354for.f1279super[Cthis.ENCODER.ordinal()] = x.i("Encoder: ", (String) this.f1355if);
                    Ccase caseR = this.f1354for;
                    this.f1353do = 1;
                    if (caseR.m1380do("encoderType", (c<? super Unit>) this) == d11) {
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
        public Ctry(Ccase caseR, c<? super Ctry> cVar) {
            super(2, cVar);
            this.f1352if = caseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Ctry(this.f1352if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ctry) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1351do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d P = f.P(this.f1352if.f1275for, new Cdo(this.f1352if, (c<? super Cdo>) null));
                this.f1351do = 1;
                if (f.h(P, this) == d11) {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ccase(Context context, j1 j1Var, j1 j1Var2, j1 j1Var3, j1 j1Var4, j1 j1Var5, j1 j1Var6, j1 j1Var7, j1 j1Var8, j1 j1Var9, j1 j1Var10, f1 f1Var, f1 f1Var2, b1 b1Var, CoroutineDispatcher coroutineDispatcher, int i11, kotlin.jvm.internal.r rVar) {
        this(context, j1Var, j1Var2, j1Var3, j1Var4, j1Var5, j1Var6, j1Var7, j1Var8, j1Var9, j1Var10, f1Var, f1Var2, b1Var, (i11 & 16384) != 0 ? v0.a() : coroutineDispatcher);
    }

    public Ccase(Context context, j1<? extends com.iproov.sdk.p021new.Cnew> j1Var, j1<Size> j1Var2, j1<String> j1Var3, j1<? extends Cconst> j1Var4, j1<com.iproov.sdk.p017implements.Cthis> j1Var5, j1<com.iproov.sdk.p017implements.Cthis> j1Var6, j1<com.iproov.sdk.p017implements.Cthis> j1Var7, j1<com.iproov.sdk.p017implements.Cthis> j1Var8, j1<Size> j1Var9, j1<String> j1Var10, f1<String> f1Var, f1<? extends FaceFeature> f1Var2, b1<String> b1Var, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1272do = j1Var;
        this.f1277if = j1Var2;
        this.f1275for = j1Var3;
        this.f1278new = j1Var4;
        this.f1281try = j1Var5;
        this.f1268case = j1Var6;
        this.f1273else = j1Var7;
        this.f1276goto = j1Var8;
        this.f1280this = j1Var9;
        this.f1267break = j1Var10;
        this.f1269catch = f1Var;
        this.f1270class = f1Var2;
        this.f1271const = b1Var;
        this.f1274final = new com.iproov.sdk.p019interface.Cif(context);
        int length = Cthis.values().length;
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            strArr[i11] = "--------";
        }
        this.f1279super = strArr;
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        n1 unused3 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cfor(this, (c<? super Cfor>) null), 3, (Object) null);
        n1 unused4 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cnew(this, (c<? super Cnew>) null), 3, (Object) null);
        n1 unused5 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Ctry(this, (c<? super Ctry>) null), 3, (Object) null);
        n1 unused6 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Ccase(this, (c<? super Ccase>) null), 3, (Object) null);
        n1 unused7 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Celse(this, (c<? super Celse>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final String m1381do(Pose pose) {
        if (pose == null) {
            return "🔄 Pose not supported";
        }
        return "🔄 " + com.iproov.sdk.p035try.Cfor.m2132do(Float.valueOf(pose.roll)) + ", ↔️ " + com.iproov.sdk.p035try.Cfor.m2132do(Float.valueOf(pose.yaw)) + ", ↕️ " + com.iproov.sdk.p035try.Cfor.m2132do(Float.valueOf(pose.pitch));
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m1380do(String str, c<? super Unit> cVar) {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        x.i("generateReport ", str);
        Object emit = this.f1271const.emit(TextUtils.join("\n", this.f1279super), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }
}
