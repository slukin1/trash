package com.iproov.sdk.p009do;

import android.content.Context;
import com.iproov.sdk.IProovSessionState;
import com.iproov.sdk.p016if.Cprotected;
import com.iproov.sdk.p026return.Cconst;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

/* renamed from: com.iproov.sdk.do.new  reason: invalid class name and invalid package */
public final class Cnew {

    /* renamed from: do  reason: not valid java name */
    public static final Cnew f489do = new Cnew();

    /* renamed from: for  reason: not valid java name */
    private static Ccase f490for;

    /* renamed from: if  reason: not valid java name */
    private static final a f491if = MutexKt.b(false, 1, (Object) null);

    /* renamed from: new  reason: not valid java name */
    private static Cprotected f492new;

    /* renamed from: try  reason: not valid java name */
    private static final b1<IProovSessionState> f493try = k1.a(null);

    @d(c = "com.iproov.sdk.InternalRoot", f = "InternalRoot.kt", l = {65}, m = "createSession$iproov_release")
    /* renamed from: com.iproov.sdk.do.new$do  reason: invalid class name */
    public static final class Cdo extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public final /* synthetic */ Cnew f495case;

        /* renamed from: do  reason: not valid java name */
        public Object f496do;

        /* renamed from: else  reason: not valid java name */
        public int f497else;

        /* renamed from: for  reason: not valid java name */
        public Object f498for;

        /* renamed from: if  reason: not valid java name */
        public Object f499if;

        /* renamed from: new  reason: not valid java name */
        public Object f500new;

        /* renamed from: try  reason: not valid java name */
        public /* synthetic */ Object f501try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cnew newR, c<? super Cdo> cVar) {
            super(cVar);
            this.f495case = newR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f501try = obj;
            this.f497else |= Integer.MIN_VALUE;
            return this.f495case.m573do((Context) null, (String) null, (d10.a<Cconst>) null, this);
        }
    }

    @d(c = "com.iproov.sdk.InternalRoot", f = "InternalRoot.kt", l = {65}, m = "currentSession$iproov_release")
    /* renamed from: com.iproov.sdk.do.new$if  reason: invalid class name */
    public static final class Cif extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f502do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cnew f503for;

        /* renamed from: if  reason: not valid java name */
        public /* synthetic */ Object f504if;

        /* renamed from: new  reason: not valid java name */
        public int f505new;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cnew newR, c<? super Cif> cVar) {
            super(cVar);
            this.f503for = newR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f504if = obj;
            this.f505new |= Integer.MIN_VALUE;
            return this.f503for.m574do((c<? super Ccase>) this);
        }
    }

    private Cnew() {
    }

    /* renamed from: for  reason: not valid java name */
    private final boolean m572for() {
        Ccase caseR = f490for;
        return caseR != null && caseR.isActive();
    }

    /* renamed from: do  reason: not valid java name */
    public final void m576do(Cprotected protectedR) {
        f492new = protectedR;
    }

    /* renamed from: if  reason: not valid java name */
    public final Cprotected m577if() {
        return f492new;
    }

    /* renamed from: do  reason: not valid java name */
    public final b1<IProovSessionState> m575do() {
        return f493try;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m574do(kotlin.coroutines.c<? super com.iproov.sdk.p009do.Ccase> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.iproov.sdk.p009do.Cnew.Cif
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.iproov.sdk.do.new$if r0 = (com.iproov.sdk.p009do.Cnew.Cif) r0
            int r1 = r0.f505new
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f505new = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.do.new$if r0 = new com.iproov.sdk.do.new$if
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f504if
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f505new
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r0 = r0.f502do
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
            kotlin.k.b(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.k.b(r6)
            kotlinx.coroutines.sync.a r6 = f491if
            r0.f502do = r6
            r0.f505new = r4
            java.lang.Object r0 = r6.d(r3, r0)
            if (r0 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r6
        L_0x0047:
            com.iproov.sdk.do.case r6 = f490for     // Catch:{ all -> 0x004d }
            r0.e(r3)
            return r6
        L_0x004d:
            r6 = move-exception
            r0.e(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p009do.Cnew.m574do(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: d10.a<com.iproov.sdk.return.const>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[Catch:{ IProovException -> 0x00ae, all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[Catch:{ IProovException -> 0x00ae, all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[Catch:{ IProovException -> 0x00ae, all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m573do(android.content.Context r6, java.lang.String r7, d10.a<com.iproov.sdk.p026return.Cconst> r8, kotlin.coroutines.c<? super com.iproov.sdk.p009do.Ccase> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.iproov.sdk.p009do.Cnew.Cdo
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.iproov.sdk.do.new$do r0 = (com.iproov.sdk.p009do.Cnew.Cdo) r0
            int r1 = r0.f497else
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f497else = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.do.new$do r0 = new com.iproov.sdk.do.new$do
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f501try
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f497else
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            java.lang.Object r6 = r0.f500new
            kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r6
            java.lang.Object r7 = r0.f498for
            r8 = r7
            d10.a r8 = (d10.a) r8
            java.lang.Object r7 = r0.f499if
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.f496do
            android.content.Context r0 = (android.content.Context) r0
            kotlin.k.b(r9)
            r9 = r6
            r6 = r0
            goto L_0x005b
        L_0x003d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0045:
            kotlin.k.b(r9)
            kotlinx.coroutines.sync.a r9 = f491if
            r0.f496do = r6
            r0.f499if = r7
            r0.f498for = r8
            r0.f500new = r9
            r0.f497else = r4
            java.lang.Object r0 = r9.d(r3, r0)
            if (r0 != r1) goto L_0x005b
            return r1
        L_0x005b:
            com.iproov.sdk.do.new r0 = f489do     // Catch:{ IProovException -> 0x00ae }
            boolean r0 = r0.m572for()     // Catch:{ IProovException -> 0x00ae }
            if (r0 == 0) goto L_0x0073
            com.iproov.sdk.return.final r8 = new com.iproov.sdk.return.final     // Catch:{ IProovException -> 0x00ae }
            com.iproov.sdk.IProovState$Error r0 = new com.iproov.sdk.IProovState$Error     // Catch:{ IProovException -> 0x00ae }
            com.iproov.sdk.core.exception.CaptureAlreadyActiveException r1 = new com.iproov.sdk.core.exception.CaptureAlreadyActiveException     // Catch:{ IProovException -> 0x00ae }
            r1.<init>(r6)     // Catch:{ IProovException -> 0x00ae }
            r0.<init>(r1)     // Catch:{ IProovException -> 0x00ae }
            r8.<init>(r7, r0)     // Catch:{ IProovException -> 0x00ae }
            goto L_0x00bc
        L_0x0073:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IProovException -> 0x00ae }
            r1 = 24
            if (r0 < r1) goto L_0x009f
            boolean r0 = r6 instanceof android.app.Activity     // Catch:{ IProovException -> 0x00ae }
            if (r0 == 0) goto L_0x0081
            r0 = r6
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ IProovException -> 0x00ae }
            goto L_0x0082
        L_0x0081:
            r0 = r3
        L_0x0082:
            if (r0 != 0) goto L_0x0085
            goto L_0x008c
        L_0x0085:
            boolean r0 = r0.isInMultiWindowMode()     // Catch:{ IProovException -> 0x00ae }
            if (r0 != r4) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r4 = 0
        L_0x008d:
            if (r4 == 0) goto L_0x009f
            com.iproov.sdk.return.final r8 = new com.iproov.sdk.return.final     // Catch:{ IProovException -> 0x00ae }
            com.iproov.sdk.IProovState$Error r0 = new com.iproov.sdk.IProovState$Error     // Catch:{ IProovException -> 0x00ae }
            com.iproov.sdk.core.exception.MultiWindowUnsupportedException r1 = new com.iproov.sdk.core.exception.MultiWindowUnsupportedException     // Catch:{ IProovException -> 0x00ae }
            r1.<init>(r6)     // Catch:{ IProovException -> 0x00ae }
            r0.<init>(r1)     // Catch:{ IProovException -> 0x00ae }
            r8.<init>(r7, r0)     // Catch:{ IProovException -> 0x00ae }
            goto L_0x00bc
        L_0x009f:
            java.lang.Object r6 = r8.invoke()     // Catch:{ IProovException -> 0x00ae }
            r8 = r6
            com.iproov.sdk.return.const r8 = (com.iproov.sdk.p026return.Cconst) r8     // Catch:{ IProovException -> 0x00ae }
            f490for = r8     // Catch:{ IProovException -> 0x00ae }
            r8 = r6
            com.iproov.sdk.do.case r8 = (com.iproov.sdk.p009do.Ccase) r8     // Catch:{ IProovException -> 0x00ae }
            goto L_0x00bc
        L_0x00ac:
            r6 = move-exception
            goto L_0x00c0
        L_0x00ae:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00ac }
            com.iproov.sdk.return.final r8 = new com.iproov.sdk.return.final     // Catch:{ all -> 0x00ac }
            com.iproov.sdk.IProovState$Error r0 = new com.iproov.sdk.IProovState$Error     // Catch:{ all -> 0x00ac }
            r0.<init>(r6)     // Catch:{ all -> 0x00ac }
            r8.<init>(r7, r0)     // Catch:{ all -> 0x00ac }
        L_0x00bc:
            r9.e(r3)
            return r8
        L_0x00c0:
            r9.e(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p009do.Cnew.m573do(android.content.Context, java.lang.String, d10.a, kotlin.coroutines.c):java.lang.Object");
    }
}
