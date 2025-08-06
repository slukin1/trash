package com.iproov.sdk.p026return;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.iproov.sdk.p016if.Cabstract;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import d10.q;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.default  reason: invalid class name and invalid package */
public final class Cdefault extends BaseCoroutineScope implements Cabstract {

    /* renamed from: this  reason: not valid java name */
    private static final Set<Integer> f1375this = SetsKt__SetsKt.f(10, 9, 1);
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final d<Boolean> f1376case;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final a1<Creturn> f1377do;

    /* renamed from: else  reason: not valid java name */
    private final Cfor f1378else;

    /* renamed from: for  reason: not valid java name */
    private final Cthrows f1379for;

    /* renamed from: goto  reason: not valid java name */
    private final Cnew f1380goto;

    /* renamed from: if  reason: not valid java name */
    private final b1<Cthrows> f1381if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final j1<Long> f1382new;

    /* renamed from: try  reason: not valid java name */
    private final SensorManager f1383try;

    @kotlin.coroutines.jvm.internal.d(c = "com.iproov.sdk.impl.SensorsImpl$1", f = "SensorsImpl.kt", l = {178}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.default$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1384do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdefault f1385if;

        @kotlin.coroutines.jvm.internal.d(c = "com.iproov.sdk.impl.SensorsImpl$1$1", f = "SensorsImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.default$do$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements q<Long, Boolean, c<? super Pair<? extends Long, ? extends Boolean>>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1386do;

            /* renamed from: for  reason: not valid java name */
            public /* synthetic */ boolean f1387for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ long f1388if;

            public Cdo(c<? super Cdo> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object m1436do(long j11, boolean z11, c<? super Pair<Long, Boolean>> cVar) {
                Cdo doVar = new Cdo(cVar);
                doVar.f1388if = j11;
                doVar.f1387for = z11;
                return doVar.invokeSuspend(Unit.f56620a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m1436do(((Number) obj).longValue(), ((Boolean) obj2).booleanValue(), (c) obj3);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1386do == 0) {
                    k.b(obj);
                    return new Pair(a.d(this.f1388if), a.a(this.f1387for));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.return.default$do$if  reason: invalid class name */
        public static final class Cif implements e<Pair<? extends Long, ? extends Boolean>> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdefault f1389do;

            public Cif(Cdefault defaultR) {
                this.f1389do = defaultR;
            }

            public Object emit(Pair<? extends Long, ? extends Boolean> pair, c<? super Unit> cVar) {
                Pair pair2 = pair;
                this.f1389do.m1426const();
                if (((Boolean) pair2.getSecond()).booleanValue()) {
                    this.f1389do.m1428do(((Number) pair2.getFirst()).longValue());
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cdefault defaultR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1385if = defaultR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1385if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1384do;
            if (i11 == 0) {
                k.b(obj);
                d s11 = f.s(f.G(this.f1385if.f1382new, this.f1385if.f1376case, new Cdo((c<? super Cdo>) null)));
                Cif ifVar = new Cif(this.f1385if);
                this.f1384do = 1;
                if (s11.collect(ifVar, this) == d11) {
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

    /* renamed from: com.iproov.sdk.return.default$for  reason: invalid class name */
    public static final class Cfor implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    /* renamed from: com.iproov.sdk.return.default$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.return.default$new  reason: invalid class name */
    public static final class Cnew implements SensorEventListener {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdefault f1390do;

        public Cnew(Cdefault defaultR) {
            this.f1390do = defaultR;
        }

        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent != null) {
                Cdefault defaultR = this.f1390do;
                defaultR.f1377do.d(new Creturn(sensorEvent.sensor.getType(), sensorEvent.sensor.getName(), defaultR.m1430do(sensorEvent.sensor.getType(), sensorEvent.values)));
            }
        }
    }

    /* renamed from: com.iproov.sdk.return.default$try  reason: invalid class name */
    public static final class Ctry implements d<Boolean> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ d f1391do;

        /* renamed from: com.iproov.sdk.return.default$try$do  reason: invalid class name */
        public static final class Cdo implements e<Integer> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ e f1392do;

            @kotlin.coroutines.jvm.internal.d(c = "com.iproov.sdk.impl.SensorsImpl$special$$inlined$map$1$2", f = "SensorsImpl.kt", l = {137}, m = "emit")
            /* renamed from: com.iproov.sdk.return.default$try$do$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f1393do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f1394for;

                /* renamed from: if  reason: not valid java name */
                public int f1395if;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cdo doVar, c cVar) {
                    super(cVar);
                    this.f1394for = doVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f1393do = obj;
                    this.f1395if |= Integer.MIN_VALUE;
                    return this.f1394for.emit((Object) null, this);
                }
            }

            public Cdo(e eVar) {
                this.f1392do = eVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.iproov.sdk.p026return.Cdefault.Ctry.Cdo.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.iproov.sdk.return.default$try$do$do r0 = (com.iproov.sdk.p026return.Cdefault.Ctry.Cdo.Cdo) r0
                    int r1 = r0.f1395if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f1395if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.return.default$try$do$do r0 = new com.iproov.sdk.return.default$try$do$do
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f1393do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f1395if
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
                    kotlinx.coroutines.flow.e r6 = r4.f1392do
                    java.lang.Number r5 = (java.lang.Number) r5
                    int r5 = r5.intValue()
                    if (r5 <= 0) goto L_0x0040
                    r5 = r3
                    goto L_0x0041
                L_0x0040:
                    r5 = 0
                L_0x0041:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
                    r0.f1395if = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x004e
                    return r1
                L_0x004e:
                    kotlin.Unit r5 = kotlin.Unit.f56620a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cdefault.Ctry.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public Ctry(d dVar) {
            this.f1391do = dVar;
        }

        public Object collect(e eVar, c cVar) {
            Object collect = this.f1391do.collect(new Cdo(eVar), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    static {
        new Cif((r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cdefault(Context context, a1 a1Var, b1 b1Var, Cthrows throwsR, j1 j1Var, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, a1Var, b1Var, throwsR, j1Var, (i11 & 32) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* renamed from: class  reason: not valid java name */
    private final void m1425class() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Number intValue : this.f1379for.m1754do()) {
            int intValue2 = intValue.intValue();
            Sensor defaultSensor = this.f1383try.getDefaultSensor(intValue2);
            if (defaultSensor != null) {
                if (this.f1383try.registerListener(this.f1378else, defaultSensor, 3)) {
                    Ccase.m977do(this);
                    x.i("SensorSampling: Sensor Available=", defaultSensor.getName());
                    linkedHashSet.add(Integer.valueOf(intValue2));
                }
                this.f1383try.unregisterListener(this.f1378else, defaultSensor);
            }
        }
        this.f1381if.d(new Cthrows(linkedHashSet));
    }

    /* access modifiers changed from: private */
    /* renamed from: const  reason: not valid java name */
    public final void m1426const() {
        for (Number intValue : this.f1379for.m1754do()) {
            Sensor defaultSensor = this.f1383try.getDefaultSensor(intValue.intValue());
            if (defaultSensor != null) {
                this.f1383try.unregisterListener(this.f1380goto, defaultSensor);
            }
        }
    }

    public void doStop() {
        m1426const();
    }

    public Cdefault(Context context, a1<Creturn> a1Var, b1<Cthrows> b1Var, Cthrows throwsR, j1<Long> j1Var, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1377do = a1Var;
        this.f1381if = b1Var;
        this.f1379for = throwsR;
        this.f1382new = j1Var;
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.f1383try = (SensorManager) systemService;
        this.f1376case = f.s(new Ctry(a1Var.e()));
        this.f1378else = new Cfor();
        this.f1380goto = new Cnew(this);
        m1425class();
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final float[] m1430do(int i11, float[] fArr) {
        if (!f1375this.contains(Integer.valueOf(i11))) {
            return i11 == 11 ? com.iproov.sdk.utils.Cfor.m2240do(fArr) : fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int i12 = 0;
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i13 = i12 + 1;
                fArr2[i12] = fArr[i12] / 9.81f;
                if (i13 > length) {
                    break;
                }
                i12 = i13;
            }
        }
        return fArr2;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m1428do(long j11) {
        if (j11 != 0) {
            Ccase.m977do(this);
            for (Number intValue : this.f1379for.m1754do()) {
                Sensor defaultSensor = this.f1383try.getDefaultSensor(intValue.intValue());
                if (defaultSensor != null) {
                    this.f1383try.registerListener(this.f1380goto, defaultSensor, (int) j11);
                }
            }
        }
    }
}
