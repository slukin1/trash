package com.iproov.sdk.p026return;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p016if.Cthrows;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p017implements.Cfor;
import com.iproov.sdk.p017implements.Cnew;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

/* renamed from: com.iproov.sdk.return.import  reason: invalid class name and invalid package */
public final class Cimport extends BaseCoroutineScope implements Cthrows {

    /* renamed from: break  reason: not valid java name */
    private int f1615break;

    /* renamed from: case  reason: not valid java name */
    private n1 f1616case;
    /* access modifiers changed from: private */

    /* renamed from: catch  reason: not valid java name */
    public long f1617catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public int f1618class = -1;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public final AtomicInteger f1619const = new AtomicInteger(-1);

    /* renamed from: do  reason: not valid java name */
    private final a1<Cnew> f1620do;

    /* renamed from: else  reason: not valid java name */
    private int f1621else = 1;
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public final AtomicInteger f1622final = new AtomicInteger(0);

    /* renamed from: for  reason: not valid java name */
    private final Cfor f1623for = new Cfor();
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public int f1624goto = 10;

    /* renamed from: if  reason: not valid java name */
    private final Cif f1625if = new Cif();

    /* renamed from: new  reason: not valid java name */
    private a1<Cnew> f1626new;

    /* renamed from: this  reason: not valid java name */
    private Cdo f1627this;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public int f1628try;

    /* renamed from: com.iproov.sdk.return.import$do  reason: invalid class name */
    public final class Cdo {

        /* renamed from: do  reason: not valid java name */
        private final Cnew f1629do;

        /* renamed from: if  reason: not valid java name */
        private Double f1631if;

        public Cdo(Cnew newR) {
            this.f1629do = newR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cnew m1603do() {
            return this.f1629do;
        }

        /* renamed from: if  reason: not valid java name */
        public final double m1605if() {
            Double d11 = this.f1631if;
            if (d11 != null) {
                return d11.doubleValue();
            }
            double d12 = Cimport.this.m1598new(this.f1629do);
            this.f1631if = Double.valueOf(d12);
            return d12;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m1604do(double d11) {
            this.f1631if = Double.valueOf(d11);
        }
    }

    @d(c = "com.iproov.sdk.impl.LivenessFrameSelector$start$1$1", f = "LivenessFrameSelector.kt", l = {343}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.import$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1632do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cimport f1633for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ a1<Cnew> f1634if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ boolean f1635new;

        /* renamed from: com.iproov.sdk.return.import$if$do  reason: invalid class name */
        public static final class Cdo implements e<Cnew> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cimport f1636do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ boolean f1637if;

            public Cdo(Cimport importR, boolean z11) {
                this.f1636do = importR;
                this.f1637if = z11;
            }

            public Object emit(Cnew newR, c<? super Unit> cVar) {
                Cnew newR2 = newR;
                this.f1636do.f1618class = newR2.m1648else();
                this.f1636do.f1622final.set(this.f1636do.f1619const.get() - this.f1636do.f1618class);
                boolean z11 = this.f1636do.f1628try == this.f1636do.f1624goto && (newR2.m1651if() < this.f1636do.f1624goto || this.f1636do.f1617catch < System.nanoTime() || !this.f1637if);
                if (newR2.m1646case() == 1) {
                    this.f1636do.m1591do(newR2);
                } else if (!z11) {
                    this.f1636do.m1597if(newR2);
                } else {
                    newR2.m1651if();
                    newR2.m1646case();
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(a1<Cnew> a1Var, Cimport importR, boolean z11, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1634if = a1Var;
            this.f1633for = importR;
            this.f1635new = z11;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1634if, this.f1633for, this.f1635new, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1632do;
            if (i11 == 0) {
                k.b(obj);
                a1<Cnew> a1Var = this.f1634if;
                Cdo doVar = new Cdo(this.f1633for, this.f1635new);
                this.f1632do = 1;
                if (a1Var.collect(doVar, this) == d11) {
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

    public Cimport(a1<Cnew> a1Var) {
        super((CoroutineDispatcher) null, 1, (r) null);
        this.f1620do = a1Var;
    }

    /* renamed from: class  reason: not valid java name */
    private final void m1587class() {
        for (Cdo next : this.f1625if.m1582for()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(next.m1437do());
            sb2.append('/');
            sb2.append(next.m1442new());
            sb2.append('[');
            sb2.append(next.m1440for());
            sb2.append(']');
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" Overall blur delay = ");
        sb3.append(this.f1625if.m1584new() / ((long) 1000000));
        sb3.append(" ms");
        Ccase.m977do(this);
    }

    public void doStop() {
        super.doStop();
        n1 n1Var = this.f1616case;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f1616case = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public final double m1598new(Cnew newR) {
        FaceFeature faceFeature = newR.m1649for();
        Bitmap bitmap = newR.m1647do();
        if (faceFeature != null) {
            RectF faceBounds = faceFeature.getFaceBounds();
            float f11 = faceBounds.left;
            float f12 = faceBounds.top;
            bitmap = Cnew.m1029do(bitmap, (int) f11, (int) f12, (int) (faceBounds.right - f11), (int) (faceBounds.bottom - f12));
            if (bitmap == null) {
                throw new IllegalStateException("Bitmap can not be null".toString());
            }
        }
        return this.f1623for.m1006do(bitmap);
    }

    /* renamed from: for  reason: not valid java name */
    private final void m1594for(Cnew newR) {
        this.f1619const.set(newR.m1648else());
        a1<Cnew> a1Var = this.f1626new;
        if (a1Var != null) {
            a1Var.d(newR);
        }
        this.f1625if.m1580do(this.f1622final.get());
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public final void m1597if(Cnew newR) {
        Cdo doVar = this.f1627this;
        if (doVar != null) {
            double d11 = m1598new(newR);
            if (d11 > doVar.m1605if()) {
                Ccase.m977do(this);
                newR.m1651if();
                newR.m1646case();
                Cdo doVar2 = new Cdo(newR);
                doVar2.m1604do(d11);
                Unit unit = Unit.f56620a;
                this.f1627this = doVar2;
            } else {
                Ccase.m977do(this);
                newR.m1651if();
                newR.m1646case();
            }
            this.f1625if.m1581do(doVar.m1603do().m1646case(), newR.m1646case());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m1591do(Cnew newR) {
        Cdo doVar = this.f1627this;
        if (doVar != null) {
            Ccase.m977do(this);
            doVar.m1603do().m1651if();
            doVar.m1603do().m1646case();
            this.f1620do.d(doVar.m1603do());
        }
        Cdo doVar2 = this.f1627this;
        if (doVar2 != null && doVar2.m1603do().m1650goto()) {
            Ccase.m977do(this);
            Cdo doVar3 = this.f1627this;
            x.i("FINISHED ", doVar3 == null ? null : Integer.valueOf(doVar3.m1603do().m1651if()));
            this.f1625if.m1579do();
            m1587class();
            this.f1627this = null;
            n1 n1Var = this.f1616case;
            if (n1Var != null) {
                n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f1616case = null;
            return;
        }
        this.f1625if.m1585try();
        this.f1627this = new Cdo(newR);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1602do(int i11, int i12, boolean z11) {
        a1<Cnew> b11 = g1.b(i12 * i11, 0, (BufferOverflow) null, 6, (Object) null);
        this.f1626new = b11;
        this.f1616case = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(b11, this, z11, (c<? super Cif>) null), 3, (Object) null);
    }

    /* renamed from: do  reason: not valid java name */
    public com.iproov.sdk.p015goto.Cif m1601do(com.iproov.sdk.p021new.Cfor forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, com.iproov.sdk.p015goto.Cif ifVar, int i11, int i12, int i13, boolean z11, int i14) {
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        boolean z12 = z11;
        if (this.f1626new == null) {
            m1602do(i16, i17, z12);
        }
        this.f1615break++;
        int i18 = this.f1621else + 1;
        this.f1621else = i18;
        this.f1624goto = i16;
        boolean z13 = false;
        boolean z14 = i15 != this.f1628try;
        boolean z15 = i15 == i16;
        if (!z15 ? i18 > i17 : this.f1617catch < System.nanoTime()) {
            z13 = true;
        }
        if (z14) {
            this.f1625if.m1583if();
            this.f1628try = i15;
            Ccase.m977do(this);
            this.f1621else = 1;
            if (z15 && z12) {
                Ccase.m977do(this);
                this.f1617catch = System.nanoTime() + (((long) i14) * 1000000);
            }
            m1594for(new Cnew(forR, bitmap, faceFeature, rectF, ifVar, i11, z15, this.f1621else));
        } else if (!z13) {
            Ccase.m977do(this);
            this.f1625if.m1583if();
            m1594for(new Cnew(forR, bitmap, faceFeature, rectF, ifVar, i11, z15, this.f1621else));
        } else if (z15) {
            Ccase.m977do(this);
            System.nanoTime();
            m1594for(new Cnew(forR, bitmap, faceFeature, rectF, ifVar, i11, true, 1));
            return com.iproov.sdk.p015goto.Cif.END_FACE_PATH;
        } else {
            Ccase.m977do(this);
        }
        return ifVar;
    }
}
