package com.iproov.sdk.p026return;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Size;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.Ccase;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p016if.Cimport;
import com.iproov.sdk.p016if.Cnative;
import com.iproov.sdk.p016if.Cpackage;
import com.iproov.sdk.p016if.Cprivate;
import com.iproov.sdk.p016if.Cpublic;
import com.iproov.sdk.p016if.Cstrictfp;
import com.iproov.sdk.p016if.Cthis;
import com.iproov.sdk.p016if.Cthrows;
import d10.p;
import d10.q;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.throw  reason: invalid class name and invalid package */
public final class Cthrow extends Cthis {
    /* access modifiers changed from: private */

    /* renamed from: abstract  reason: not valid java name */
    public Size f1802abstract;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public final Context f1803const;
    /* access modifiers changed from: private */

    /* renamed from: continue  reason: not valid java name */
    public final Ctry f1804continue;

    /* renamed from: default  reason: not valid java name */
    private final Cprivate f1805default;
    /* access modifiers changed from: private */

    /* renamed from: extends  reason: not valid java name */
    public final Cthrows f1806extends;

    /* renamed from: final  reason: not valid java name */
    private final Cthis f1807final;
    /* access modifiers changed from: private */

    /* renamed from: finally  reason: not valid java name */
    public final com.iproov.sdk.p019interface.Cif f1808finally;

    /* renamed from: import  reason: not valid java name */
    private final b1<Cpublic> f1809import;
    /* access modifiers changed from: private */

    /* renamed from: native  reason: not valid java name */
    public final a1<Cimport> f1810native;
    /* access modifiers changed from: private */

    /* renamed from: package  reason: not valid java name */
    public com.iproov.sdk.core.Ccase f1811package;

    /* renamed from: private  reason: not valid java name */
    private final int f1812private;
    /* access modifiers changed from: private */

    /* renamed from: public  reason: not valid java name */
    public final a1<Cnative> f1813public;
    /* access modifiers changed from: private */

    /* renamed from: return  reason: not valid java name */
    public final j1<Size> f1814return;
    /* access modifiers changed from: private */

    /* renamed from: static  reason: not valid java name */
    public final f1<Cnew> f1815static;
    /* access modifiers changed from: private */

    /* renamed from: super  reason: not valid java name */
    public final b1<com.iproov.sdk.p016if.Cnew> f1816super;
    /* access modifiers changed from: private */

    /* renamed from: switch  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Celse> f1817switch;
    /* access modifiers changed from: private */

    /* renamed from: throw  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Cfor> f1818throw;
    /* access modifiers changed from: private */

    /* renamed from: throws  reason: not valid java name */
    public final b1<Integer> f1819throws;
    /* access modifiers changed from: private */

    /* renamed from: while  reason: not valid java name */
    public final j1<Size> f1820while;

    @d(c = "com.iproov.sdk.impl.LAScannerImpl", f = "LAScannerImpl.kt", l = {264, 266}, m = "processCannyFace")
    /* renamed from: com.iproov.sdk.return.throw$case  reason: invalid class name */
    public static final class Ccase extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1821do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f1822for;

        /* renamed from: if  reason: not valid java name */
        public Object f1823if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cthrow f1824new;

        /* renamed from: try  reason: not valid java name */
        public int f1825try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccase(Cthrow throwR, c<? super Ccase> cVar) {
            super(cVar);
            this.f1824new = throwR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1822for = obj;
            this.f1825try |= Integer.MIN_VALUE;
            return this.f1824new.m1738do((com.iproov.sdk.p021new.Cfor) null, (Bitmap) null, (FaceFeature) null, this);
        }
    }

    @d(c = "com.iproov.sdk.impl.LAScannerImpl$1", f = "LAScannerImpl.kt", l = {270}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.throw$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1826do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ j1<Orientation> f1827for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cthrow f1828if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ com.iproov.sdk.p021new.Cnew f1829new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ com.iproov.sdk.p003case.Cif f1830try;

        @d(c = "com.iproov.sdk.impl.LAScannerImpl$1$1", f = "LAScannerImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.throw$do$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements q<Size, Orientation, c<? super Pair<? extends Size, ? extends Orientation>>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1831do;

            /* renamed from: for  reason: not valid java name */
            public /* synthetic */ Object f1832for;

            /* renamed from: if  reason: not valid java name */
            public /* synthetic */ Object f1833if;

            public Cdo(c<? super Cdo> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(Size size, Orientation orientation, c<? super Pair<Size, ? extends Orientation>> cVar) {
                Cdo doVar = new Cdo(cVar);
                doVar.f1833if = size;
                doVar.f1832for = orientation;
                return doVar.invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1831do == 0) {
                    k.b(obj);
                    return new Pair((Size) this.f1833if, (Orientation) this.f1832for);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.return.throw$do$if  reason: invalid class name */
        public static final class Cif implements e<Pair<? extends Size, ? extends Orientation>> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cthrow f1834do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p003case.Cif f1835for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p021new.Cnew f1836if;

            public Cif(Cthrow throwR, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar) {
                this.f1834do = throwR;
                this.f1836if = newR;
                this.f1835for = ifVar;
            }

            public Object emit(Pair<? extends Size, ? extends Orientation> pair, c<? super Unit> cVar) {
                Size size;
                Pair pair2 = pair;
                Size size2 = this.f1834do.f1802abstract;
                if (size2 == null) {
                    DisplayMetrics displayMetrics = this.f1834do.f1803const.getResources().getDisplayMetrics();
                    size = new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
                } else {
                    size = size2;
                }
                com.iproov.sdk.core.Ccase caseR = new com.iproov.sdk.core.Ccase(this.f1834do.f1803const, this.f1836if, (Size) pair2.getFirst(), size, this.f1835for.m230case(), this.f1834do.f1804continue, (Orientation) pair2.getSecond());
                this.f1834do.f1811package = caseR;
                Object emit = this.f1834do.f1819throws.emit(a.c(caseR.m325if()), cVar);
                if (emit == IntrinsicsKt__IntrinsicsKt.d()) {
                    return emit;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cthrow throwR, j1<? extends Orientation> j1Var, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1828if = throwR;
            this.f1827for = j1Var;
            this.f1829new = newR;
            this.f1830try = ifVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1828if, this.f1827for, this.f1829new, this.f1830try, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1826do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<R> G = f.G(f.y(this.f1828if.f1820while), f.y(this.f1827for), new Cdo((c<? super Cdo>) null));
                Cif ifVar = new Cif(this.f1828if, this.f1829new, this.f1830try);
                this.f1826do = 1;
                if (G.collect(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.LAScannerImpl", f = "LAScannerImpl.kt", l = {235, 238, 240}, m = "processFrame")
    /* renamed from: com.iproov.sdk.return.throw$else  reason: invalid class name */
    public static final class Celse extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1837do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f1838for;

        /* renamed from: if  reason: not valid java name */
        public Object f1839if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cthrow f1840new;

        /* renamed from: try  reason: not valid java name */
        public int f1841try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Cthrow throwR, c<? super Celse> cVar) {
            super(cVar);
            this.f1840new = throwR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1838for = obj;
            this.f1841try |= Integer.MIN_VALUE;
            return this.f1840new.m1739do((com.iproov.sdk.p021new.Cfor) null, (c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.impl.LAScannerImpl$3", f = "LAScannerImpl.kt", l = {275}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.throw$for  reason: invalid class name */
    public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1842do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cthrow f1843for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ j1<Orientation> f1844if;

        /* renamed from: com.iproov.sdk.return.throw$for$do  reason: invalid class name */
        public static final class Cdo implements e<Orientation> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cthrow f1845do;

            public Cdo(Cthrow throwR) {
                this.f1845do = throwR;
            }

            public Object emit(Orientation orientation, c<? super Unit> cVar) {
                Cthrow throwR = this.f1845do;
                Context context = this.f1845do.f1803const;
                Object obj = throwR.m1714do((IProovException) new InvalidOptionsException(context, "Liveness Assurance is currently only supported in portrait orientation (currently: " + orientation + ')'), cVar);
                if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
                    return obj;
                }
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.return.throw$for$if  reason: invalid class name */
        public static final class Cif implements kotlinx.coroutines.flow.d<Orientation> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ kotlinx.coroutines.flow.d f1846do;

            /* renamed from: com.iproov.sdk.return.throw$for$if$do  reason: invalid class name */
            public static final class Cdo implements e<Orientation> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ e f1847do;

                @d(c = "com.iproov.sdk.impl.LAScannerImpl$3$invokeSuspend$$inlined$filter$1$2", f = "LAScannerImpl.kt", l = {137}, m = "emit")
                /* renamed from: com.iproov.sdk.return.throw$for$if$do$do  reason: invalid class name */
                public static final class Cdo extends ContinuationImpl {

                    /* renamed from: do  reason: not valid java name */
                    public /* synthetic */ Object f1848do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cdo f1849for;

                    /* renamed from: if  reason: not valid java name */
                    public int f1850if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cdo(Cdo doVar, c cVar) {
                        super(cVar);
                        this.f1849for = doVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f1848do = obj;
                        this.f1850if |= Integer.MIN_VALUE;
                        return this.f1849for.emit((Object) null, this);
                    }
                }

                public Cdo(e eVar) {
                    this.f1847do = eVar;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.iproov.sdk.p026return.Cthrow.Cfor.Cif.Cdo.Cdo
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.iproov.sdk.return.throw$for$if$do$do r0 = (com.iproov.sdk.p026return.Cthrow.Cfor.Cif.Cdo.Cdo) r0
                        int r1 = r0.f1850if
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f1850if = r1
                        goto L_0x0018
                    L_0x0013:
                        com.iproov.sdk.return.throw$for$if$do$do r0 = new com.iproov.sdk.return.throw$for$if$do$do
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f1848do
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r2 = r0.f1850if
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.k.b(r6)
                        goto L_0x0050
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.k.b(r6)
                        kotlinx.coroutines.flow.e r6 = r4.f1847do
                        r2 = r5
                        com.iproov.sdk.cameray.Orientation r2 = (com.iproov.sdk.cameray.Orientation) r2
                        if (r2 != 0) goto L_0x003c
                        goto L_0x0044
                    L_0x003c:
                        boolean r2 = r2.isPortrait()
                        if (r2 != 0) goto L_0x0044
                        r2 = r3
                        goto L_0x0045
                    L_0x0044:
                        r2 = 0
                    L_0x0045:
                        if (r2 == 0) goto L_0x0050
                        r0.f1850if = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L_0x0050
                        return r1
                    L_0x0050:
                        kotlin.Unit r5 = kotlin.Unit.f56620a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cthrow.Cfor.Cif.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            public Cif(kotlinx.coroutines.flow.d dVar) {
                this.f1846do = dVar;
            }

            public Object collect(e eVar, c cVar) {
                Object collect = this.f1846do.collect(new Cdo(eVar), cVar);
                if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                    return collect;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(j1<? extends Orientation> j1Var, Cthrow throwR, c<? super Cfor> cVar) {
            super(2, cVar);
            this.f1844if = j1Var;
            this.f1843for = throwR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cfor(this.f1844if, this.f1843for, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1842do;
            if (i11 == 0) {
                k.b(obj);
                Cif ifVar = new Cif(this.f1844if);
                Cdo doVar = new Cdo(this.f1843for);
                this.f1842do = 1;
                if (ifVar.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.LAScannerImpl$2", f = "LAScannerImpl.kt", l = {270}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.throw$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1851do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cthrow f1852if;

        /* renamed from: com.iproov.sdk.return.throw$if$do  reason: invalid class name */
        public static final class Cdo implements e<Size> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cthrow f1853do;

            public Cdo(Cthrow throwR) {
                this.f1853do = throwR;
            }

            public Object emit(Size size, c<? super Unit> cVar) {
                Unit unit;
                this.f1853do.f1802abstract = size;
                com.iproov.sdk.core.Ccase caseR = this.f1853do.f1811package;
                if (caseR == null) {
                    unit = null;
                } else {
                    caseR.m324do(this.f1853do.f1802abstract);
                    unit = Unit.f56620a;
                }
                if (unit == IntrinsicsKt__IntrinsicsKt.d()) {
                    return unit;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cthrow throwR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1852if = throwR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1852if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1851do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d y11 = f.y(this.f1852if.f1814return);
                Cdo doVar = new Cdo(this.f1852if);
                this.f1851do = 1;
                if (y11.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.LAScannerImpl$4", f = "LAScannerImpl.kt", l = {270}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.throw$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1854do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cthrow f1855if;

        /* renamed from: com.iproov.sdk.return.throw$new$do  reason: invalid class name */
        public static final class Cdo implements e<Cnew> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cthrow f1856do;

            @d(c = "com.iproov.sdk.impl.LAScannerImpl$4$invokeSuspend$$inlined$collect$1", f = "LAScannerImpl.kt", l = {137, 144, 145, 146}, m = "emit")
            /* renamed from: com.iproov.sdk.return.throw$new$do$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: case  reason: not valid java name */
                public Object f1857case;

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f1858do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f1859for;

                /* renamed from: if  reason: not valid java name */
                public int f1860if;

                /* renamed from: new  reason: not valid java name */
                public Object f1861new;

                /* renamed from: try  reason: not valid java name */
                public Object f1862try;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cdo doVar, c cVar) {
                    super(cVar);
                    this.f1859for = doVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f1858do = obj;
                    this.f1860if |= Integer.MIN_VALUE;
                    return this.f1859for.emit((Cnew) null, this);
                }
            }

            public Cdo(Cthrow throwR) {
                this.f1856do = throwR;
            }

            /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00c6 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00c7  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00e6  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0100 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p026return.Cnew r12, kotlin.coroutines.c<? super kotlin.Unit> r13) {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof com.iproov.sdk.p026return.Cthrow.Cnew.Cdo.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r13
                    com.iproov.sdk.return.throw$new$do$do r0 = (com.iproov.sdk.p026return.Cthrow.Cnew.Cdo.Cdo) r0
                    int r1 = r0.f1860if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f1860if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.return.throw$new$do$do r0 = new com.iproov.sdk.return.throw$new$do$do
                    r0.<init>(r11, r13)
                L_0x0018:
                    java.lang.Object r13 = r0.f1858do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f1860if
                    r3 = 4
                    r4 = 3
                    r5 = 2
                    r6 = 1
                    if (r2 == 0) goto L_0x006c
                    if (r2 == r6) goto L_0x005c
                    if (r2 == r5) goto L_0x004c
                    if (r2 == r4) goto L_0x003b
                    if (r2 != r3) goto L_0x0033
                    kotlin.k.b(r13)
                    goto L_0x0101
                L_0x0033:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r13)
                    throw r12
                L_0x003b:
                    java.lang.Object r12 = r0.f1857case
                    com.iproov.sdk.core.case r12 = (com.iproov.sdk.core.Ccase) r12
                    java.lang.Object r2 = r0.f1862try
                    com.iproov.sdk.return.new r2 = (com.iproov.sdk.p026return.Cnew) r2
                    java.lang.Object r4 = r0.f1861new
                    com.iproov.sdk.return.throw$new$do r4 = (com.iproov.sdk.p026return.Cthrow.Cnew.Cdo) r4
                    kotlin.k.b(r13)
                    goto L_0x00e7
                L_0x004c:
                    java.lang.Object r12 = r0.f1857case
                    com.iproov.sdk.core.case r12 = (com.iproov.sdk.core.Ccase) r12
                    java.lang.Object r2 = r0.f1862try
                    com.iproov.sdk.return.new r2 = (com.iproov.sdk.p026return.Cnew) r2
                    java.lang.Object r5 = r0.f1861new
                    com.iproov.sdk.return.throw$new$do r5 = (com.iproov.sdk.p026return.Cthrow.Cnew.Cdo) r5
                    kotlin.k.b(r13)
                    goto L_0x00c8
                L_0x005c:
                    java.lang.Object r12 = r0.f1857case
                    com.iproov.sdk.core.case r12 = (com.iproov.sdk.core.Ccase) r12
                    java.lang.Object r2 = r0.f1862try
                    com.iproov.sdk.return.new r2 = (com.iproov.sdk.p026return.Cnew) r2
                    java.lang.Object r6 = r0.f1861new
                    com.iproov.sdk.return.throw$new$do r6 = (com.iproov.sdk.p026return.Cthrow.Cnew.Cdo) r6
                    kotlin.k.b(r13)
                    goto L_0x00a9
                L_0x006c:
                    kotlin.k.b(r13)
                    r2 = r12
                    com.iproov.sdk.return.new r2 = (com.iproov.sdk.p026return.Cnew) r2
                    com.iproov.sdk.return.throw r12 = r11.f1856do
                    com.iproov.sdk.try.else r12 = r12.m1713class()
                    r12.m2130if()
                    com.iproov.sdk.return.throw r12 = r11.f1856do
                    com.iproov.sdk.core.case r12 = r12.f1811package
                    if (r12 != 0) goto L_0x0085
                    goto L_0x0101
                L_0x0085:
                    com.iproov.sdk.return.throw r13 = r11.f1856do
                    kotlinx.coroutines.flow.a1 r13 = r13.f1817switch
                    com.iproov.sdk.if.else$do r7 = new com.iproov.sdk.if.else$do
                    com.iproov.sdk.new.for r8 = r2.m1653try()
                    int r9 = r12.m325if()
                    r10 = 0
                    r7.<init>(r8, r10, r9)
                    r0.f1861new = r11
                    r0.f1862try = r2
                    r0.f1857case = r12
                    r0.f1860if = r6
                    java.lang.Object r13 = r13.emit(r7, r0)
                    if (r13 != r1) goto L_0x00a8
                    return r1
                L_0x00a8:
                    r6 = r11
                L_0x00a9:
                    com.iproov.sdk.return.throw r13 = r6.f1856do
                    kotlinx.coroutines.flow.a1 r13 = r13.f1818throw
                    com.iproov.sdk.if.for$if r7 = new com.iproov.sdk.if.for$if
                    android.graphics.RectF r8 = r2.m1652new()
                    r7.<init>(r8)
                    r0.f1861new = r6
                    r0.f1862try = r2
                    r0.f1857case = r12
                    r0.f1860if = r5
                    java.lang.Object r13 = r13.emit(r7, r0)
                    if (r13 != r1) goto L_0x00c7
                    return r1
                L_0x00c7:
                    r5 = r6
                L_0x00c8:
                    com.iproov.sdk.return.throw r13 = r5.f1856do
                    kotlinx.coroutines.flow.a1 r13 = r13.f1810native
                    com.iproov.sdk.if.import$if r6 = new com.iproov.sdk.if.import$if
                    boolean r7 = r2.m1650goto()
                    r6.<init>(r7)
                    r0.f1861new = r5
                    r0.f1862try = r2
                    r0.f1857case = r12
                    r0.f1860if = r4
                    java.lang.Object r13 = r13.emit(r6, r0)
                    if (r13 != r1) goto L_0x00e6
                    return r1
                L_0x00e6:
                    r4 = r5
                L_0x00e7:
                    com.iproov.sdk.return.throw r13 = r4.f1856do
                    com.iproov.sdk.new.for r2 = r2.m1653try()
                    int r12 = r12.m325if()
                    r4 = 0
                    r0.f1861new = r4
                    r0.f1862try = r4
                    r0.f1857case = r4
                    r0.f1860if = r3
                    java.lang.Object r12 = r13.m1715do(r2, r12, r0)
                    if (r12 != r1) goto L_0x0101
                    return r1
                L_0x0101:
                    kotlin.Unit r12 = kotlin.Unit.f56620a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cthrow.Cnew.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Cthrow throwR, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f1855if = throwR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cnew(this.f1855if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1854do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1855if.f1815static;
                Cdo doVar = new Cdo(this.f1855if);
                this.f1854do = 1;
                if (f1Var.collect(doVar, this) == d11) {
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

    /* renamed from: com.iproov.sdk.return.throw$try  reason: invalid class name */
    public static final class Ctry implements Ccase.Cdo {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cthrow f1863do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ com.iproov.sdk.p003case.Cif f1864if;

        @d(c = "com.iproov.sdk.impl.LAScannerImpl$legacyListener$1$cropRequested$1", f = "LAScannerImpl.kt", l = {113, 114, 116}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.throw$try$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1865do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Rect f1866for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cthrow f1867if;

            /* renamed from: new  reason: not valid java name */
            public final /* synthetic */ RectF f1868new;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cthrow throwR, Rect rect, RectF rectF, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1867if = throwR;
                this.f1866for = rect;
                this.f1868new = rectF;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f1867if, this.f1866for, this.f1868new, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r7.f1865do
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x0025
                    if (r1 == r4) goto L_0x0021
                    if (r1 == r3) goto L_0x001d
                    if (r1 != r2) goto L_0x0015
                    kotlin.k.b(r8)
                    goto L_0x0072
                L_0x0015:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x001d:
                    kotlin.k.b(r8)
                    goto L_0x0055
                L_0x0021:
                    kotlin.k.b(r8)
                    goto L_0x0040
                L_0x0025:
                    kotlin.k.b(r8)
                    com.iproov.sdk.return.throw r8 = r7.f1867if
                    kotlinx.coroutines.flow.b1 r8 = r8.f1816super
                    com.iproov.sdk.if.new r1 = new com.iproov.sdk.if.new
                    android.graphics.Rect r5 = r7.f1866for
                    android.graphics.RectF r6 = r7.f1868new
                    r1.<init>(r5, r6)
                    r7.f1865do = r4
                    java.lang.Object r8 = r8.emit(r1, r7)
                    if (r8 != r0) goto L_0x0040
                    return r0
                L_0x0040:
                    com.iproov.sdk.return.throw r8 = r7.f1867if
                    kotlinx.coroutines.flow.a1 r8 = r8.f1810native
                    com.iproov.sdk.if.import$if r1 = new com.iproov.sdk.if.import$if
                    r4 = 0
                    r1.<init>(r4)
                    r7.f1865do = r3
                    java.lang.Object r8 = r8.emit(r1, r7)
                    if (r8 != r0) goto L_0x0055
                    return r0
                L_0x0055:
                    com.iproov.sdk.return.throw r8 = r7.f1867if
                    com.iproov.sdk.interface.if r8 = r8.f1808finally
                    boolean r8 = r8.m1105catch()
                    if (r8 == 0) goto L_0x0072
                    com.iproov.sdk.return.throw r8 = r7.f1867if
                    kotlinx.coroutines.flow.a1 r8 = r8.f1810native
                    com.iproov.sdk.if.import$case r1 = com.iproov.sdk.p016if.Cimport.Ccase.f688do
                    r7.f1865do = r2
                    java.lang.Object r8 = r8.emit(r1, r7)
                    if (r8 != r0) goto L_0x0072
                    return r0
                L_0x0072:
                    kotlin.Unit r8 = kotlin.Unit.f56620a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cthrow.Ctry.Cdo.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @d(c = "com.iproov.sdk.impl.LAScannerImpl$legacyListener$1$onProgressUpdate$1", f = "LAScannerImpl.kt", l = {149}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.throw$try$for  reason: invalid class name */
        public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1869do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ double f1870for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cthrow f1871if;

            /* renamed from: new  reason: not valid java name */
            public final /* synthetic */ double f1872new;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cfor(Cthrow throwR, double d11, double d12, c<? super Cfor> cVar) {
                super(2, cVar);
                this.f1871if = throwR;
                this.f1870for = d11;
                this.f1872new = d12;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cfor(this.f1871if, this.f1870for, this.f1872new, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1869do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1871if.f1813public;
                    Cnative nativeR = new Cnative(this.f1870for, this.f1872new);
                    this.f1869do = 1;
                    if (a1Var.emit(nativeR, this) == d11) {
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

        @d(c = "com.iproov.sdk.impl.LAScannerImpl$legacyListener$1$drawOverlay$1", f = "LAScannerImpl.kt", l = {127}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.throw$try$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: case  reason: not valid java name */
            public final /* synthetic */ Rect f1873case;

            /* renamed from: do  reason: not valid java name */
            public int f1874do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Rect f1875for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cthrow f1876if;

            /* renamed from: new  reason: not valid java name */
            public final /* synthetic */ Rect f1877new;

            /* renamed from: try  reason: not valid java name */
            public final /* synthetic */ Rect f1878try;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Cthrow throwR, Rect rect, Rect rect2, Rect rect3, Rect rect4, c<? super Cif> cVar) {
                super(2, cVar);
                this.f1876if = throwR;
                this.f1875for = rect;
                this.f1877new = rect2;
                this.f1878try = rect3;
                this.f1873case = rect4;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cif(this.f1876if, this.f1875for, this.f1877new, this.f1878try, this.f1873case, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object obj2;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1874do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1876if.f1810native;
                    if (this.f1876if.f1808finally.m1105catch()) {
                        obj2 = new Cimport.Ctry(this.f1875for, this.f1877new, this.f1878try, this.f1873case);
                    } else {
                        obj2 = Cimport.Cfor.f690do;
                    }
                    this.f1874do = 1;
                    if (a1Var.emit(obj2, this) == d11) {
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

        public Ctry(Cthrow throwR, com.iproov.sdk.p003case.Cif ifVar) {
            this.f1863do = throwR;
            this.f1864if = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public /* bridge */ /* synthetic */ void m1750do(Double d11, Double d12) {
            m1747do(d11.doubleValue(), d12.doubleValue());
        }

        /* renamed from: do  reason: not valid java name */
        public com.iproov.sdk.p015goto.Cif m1746do(com.iproov.sdk.p021new.Cfor forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, com.iproov.sdk.p015goto.Cif ifVar, int i11, int i12, int i13) {
            return this.f1863do.f1806extends.m838do(forR, bitmap, faceFeature, rectF, ifVar, i11, i12, i13, false, this.f1864if.m230case().m376if());
        }

        /* renamed from: do  reason: not valid java name */
        public void m1749do(Rect rect, RectF rectF) {
            Cthrow throwR = this.f1863do;
            n1 unused = i.d(throwR, (CoroutineContext) null, (CoroutineStart) null, new Cdo(throwR, rect, rectF, (c<? super Cdo>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1748do(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            Cthrow throwR = this.f1863do;
            n1 unused = i.d(throwR, (CoroutineContext) null, (CoroutineStart) null, new Cif(throwR, rect, rect2, rect3, rect4, (c<? super Cif>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1747do(double d11, double d12) {
            Cthrow throwR = this.f1863do;
            n1 unused = i.d(throwR, (CoroutineContext) null, (CoroutineStart) null, new Cfor(throwR, d11, d12, (c<? super Cfor>) null), 3, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cthrow(Context context, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar, Cthis thisR, b1 b1Var, a1 a1Var, j1 j1Var, b1 b1Var2, a1 a1Var2, a1 a1Var3, j1 j1Var2, f1 f1Var, j1 j1Var3, j1 j1Var4, a1 a1Var4, a1 a1Var5, a1 a1Var6, b1 b1Var3, b1 b1Var4, a1 a1Var7, Cprivate privateR, Cthrows throwsR, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, newR, ifVar, thisR, b1Var, a1Var, j1Var, b1Var2, a1Var2, a1Var3, j1Var2, f1Var, j1Var3, j1Var4, a1Var4, a1Var5, a1Var6, b1Var3, b1Var4, a1Var7, privateR, throwsR, (i11 & 4194304) != 0 ? v0.a() : coroutineDispatcher);
    }

    public void doStop() {
        this.f1805default.stop();
        this.f1807final.stop();
        this.f1806extends.stop();
    }

    /* renamed from: this  reason: not valid java name */
    public int m1740this() {
        return this.f1812private;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cthrow(Context context, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar, Cthis thisR, b1<com.iproov.sdk.p016if.Cnew> b1Var, a1<com.iproov.sdk.p016if.Cfor> a1Var, j1<Size> j1Var, b1<Cpublic> b1Var2, a1<Cimport> a1Var2, a1<Cnative> a1Var3, j1<Size> j1Var2, f1<Cnew> f1Var, j1<? extends Orientation> j1Var3, j1<? extends Orientation> j1Var4, a1<Cpackage> a1Var4, a1<com.iproov.sdk.p016if.Celse> a1Var5, a1<Cstrictfp> a1Var6, b1<Integer> b1Var3, b1<Bitmap> b1Var4, a1<FaceFeature> a1Var7, Cprivate privateR, Cthrows throwsR, CoroutineDispatcher coroutineDispatcher) {
        super(context, newR, ifVar, thisR, j1Var3, a1Var4, a1Var6, a1Var7, b1Var4, coroutineDispatcher);
        Cprivate privateR2 = privateR;
        this.f1803const = context;
        this.f1807final = thisR;
        this.f1816super = b1Var;
        this.f1818throw = a1Var;
        this.f1820while = j1Var;
        this.f1809import = b1Var2;
        this.f1810native = a1Var2;
        this.f1813public = a1Var3;
        this.f1814return = j1Var2;
        this.f1815static = f1Var;
        this.f1817switch = a1Var5;
        this.f1819throws = b1Var3;
        this.f1805default = privateR2;
        this.f1806extends = throwsR;
        this.f1808finally = new com.iproov.sdk.p019interface.Cif(context);
        this.f1812private = 3;
        this.f1804continue = new Ctry(this, ifVar);
        privateR2.m793do((long) (ifVar.m230case().m366break() * ((float) 1000)), ifVar.m230case().m369class());
        m1713class().m2128do(ifVar.m231catch());
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, j1Var4, newR, ifVar, (c<? super Cdo>) null), 3, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        n1 unused3 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cfor(j1Var3, this, (c<? super Cfor>) null), 3, (Object) null);
        n1 unused4 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cnew(this, (c<? super Cnew>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1739do(com.iproov.sdk.p021new.Cfor r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.iproov.sdk.p026return.Cthrow.Celse
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.iproov.sdk.return.throw$else r0 = (com.iproov.sdk.p026return.Cthrow.Celse) r0
            int r1 = r0.f1841try
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1841try = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.throw$else r0 = new com.iproov.sdk.return.throw$else
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f1838for
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1841try
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0050
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.k.b(r9)
            goto L_0x00a7
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.Object r8 = r0.f1839if
            com.iproov.sdk.new.for r8 = (com.iproov.sdk.p021new.Cfor) r8
            java.lang.Object r2 = r0.f1837do
            com.iproov.sdk.return.throw r2 = (com.iproov.sdk.p026return.Cthrow) r2
            kotlin.k.b(r9)
            goto L_0x0089
        L_0x0044:
            java.lang.Object r8 = r0.f1839if
            com.iproov.sdk.new.for r8 = (com.iproov.sdk.p021new.Cfor) r8
            java.lang.Object r2 = r0.f1837do
            com.iproov.sdk.return.throw r2 = (com.iproov.sdk.p026return.Cthrow) r2
            kotlin.k.b(r9)
            goto L_0x006b
        L_0x0050:
            kotlin.k.b(r9)
            kotlinx.coroutines.w r9 = r7.getJob()
            boolean r9 = r9.isActive()
            if (r9 == 0) goto L_0x00a7
            r0.f1837do = r7
            r0.f1839if = r8
            r0.f1841try = r5
            java.lang.Object r9 = super.m1717if(r8, r0)
            if (r9 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r2 = r7
        L_0x006b:
            com.iproov.sdk.try.else r9 = r2.m1713class()
            boolean r9 = r9.m2129do()
            if (r9 == 0) goto L_0x00a7
            com.iproov.sdk.p017implements.Ccase.m977do(r2)
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.import> r9 = r2.f1810native
            com.iproov.sdk.if.import$do r6 = com.iproov.sdk.p016if.Cimport.Cdo.f689do
            r0.f1837do = r2
            r0.f1839if = r8
            r0.f1841try = r4
            java.lang.Object r9 = r9.emit(r6, r0)
            if (r9 != r1) goto L_0x0089
            return r1
        L_0x0089:
            com.iproov.sdk.core.case r9 = r2.f1811package
            if (r9 != 0) goto L_0x008e
            goto L_0x00a7
        L_0x008e:
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.else> r2 = r2.f1817switch
            com.iproov.sdk.if.else$do r4 = new com.iproov.sdk.if.else$do
            int r9 = r9.m325if()
            r4.<init>(r8, r5, r9)
            r8 = 0
            r0.f1837do = r8
            r0.f1839if = r8
            r0.f1841try = r3
            java.lang.Object r8 = r2.emit(r4, r0)
            if (r8 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cthrow.m1739do(com.iproov.sdk.new.for, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1738do(com.iproov.sdk.p021new.Cfor r10, android.graphics.Bitmap r11, com.iproov.sdk.face.model.FaceFeature r12, kotlin.coroutines.c<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.iproov.sdk.p026return.Cthrow.Ccase
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.iproov.sdk.return.throw$case r0 = (com.iproov.sdk.p026return.Cthrow.Ccase) r0
            int r1 = r0.f1825try
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1825try = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.throw$case r0 = new com.iproov.sdk.return.throw$case
            r0.<init>(r9, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f1822for
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1825try
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.k.b(r13)
            goto L_0x0089
        L_0x002d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0035:
            java.lang.Object r10 = r0.f1823if
            com.iproov.sdk.if.public r10 = (com.iproov.sdk.p016if.Cpublic) r10
            java.lang.Object r11 = r0.f1821do
            com.iproov.sdk.return.throw r11 = (com.iproov.sdk.p026return.Cthrow) r11
            kotlin.k.b(r13)
            goto L_0x0074
        L_0x0041:
            kotlin.k.b(r13)
            com.iproov.sdk.core.case r13 = r9.f1811package
            if (r13 != 0) goto L_0x004a
            r10 = r5
            goto L_0x005c
        L_0x004a:
            android.graphics.Rect r2 = new android.graphics.Rect
            int r6 = r11.getWidth()
            int r7 = r11.getHeight()
            r8 = 0
            r2.<init>(r8, r8, r6, r7)
            com.iproov.sdk.goto.if r10 = r13.m323do((com.iproov.sdk.p021new.Cfor) r10, (android.graphics.Bitmap) r11, (com.iproov.sdk.face.model.FaceFeature) r12, (android.graphics.Rect) r2)
        L_0x005c:
            if (r10 != 0) goto L_0x0060
            com.iproov.sdk.goto.if r10 = com.iproov.sdk.p015goto.Cif.NO_FACE_PATH
        L_0x0060:
            com.iproov.sdk.if.public r10 = com.iproov.sdk.p016if.Creturn.m818do((com.iproov.sdk.p015goto.Cif) r10)
            kotlinx.coroutines.flow.b1<com.iproov.sdk.if.public> r11 = r9.f1809import
            r0.f1821do = r9
            r0.f1823if = r10
            r0.f1825try = r4
            java.lang.Object r11 = r11.emit(r10, r0)
            if (r11 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r11 = r9
        L_0x0074:
            com.iproov.sdk.if.public r12 = com.iproov.sdk.p016if.Cpublic.FINISHED
            if (r10 != r12) goto L_0x008c
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.import> r10 = r11.f1810native
            com.iproov.sdk.if.import$new r11 = com.iproov.sdk.p016if.Cimport.Cnew.f692do
            r0.f1821do = r5
            r0.f1823if = r5
            r0.f1825try = r3
            java.lang.Object r10 = r10.emit(r11, r0)
            if (r10 != r1) goto L_0x0089
            return r1
        L_0x0089:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x008c:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cthrow.m1738do(com.iproov.sdk.new.for, android.graphics.Bitmap, com.iproov.sdk.face.model.FaceFeature, kotlin.coroutines.c):java.lang.Object");
    }
}
