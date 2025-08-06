package com.iproov.sdk.p013finally;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.ServerException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p007continue.Cdo;
import com.iproov.sdk.p009do.Cbreak;
import com.iproov.sdk.p022package.Cfor;
import com.iproov.sdk.p022package.Cif;
import com.iproov.sdk.p022package.Cnew;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.p026return.Cstatic;
import d10.l;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.finally.try  reason: invalid class name and invalid package */
public final class Ctry {
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public static final String f537else = x.i("🔌 ", Ctry.class.getSimpleName());
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final com.iproov.sdk.p001abstract.Cdo f538case;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final Context f539do;

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p028strictfp.Cnew f540for;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final Cif f541if;

    /* renamed from: new  reason: not valid java name */
    private final com.iproov.sdk.p007continue.Cif f542new;

    /* renamed from: try  reason: not valid java name */
    private final com.iproov.sdk.p028strictfp.Cdo f543try = new com.iproov.sdk.p028strictfp.Cdo();

    /* renamed from: com.iproov.sdk.finally.try$break  reason: invalid class name */
    public static final class Cbreak extends Lambda implements l<Cfor.Cdo, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f544do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cbreak(Ctry tryR) {
            super(1);
            this.f544do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m665do(Cfor.Cdo doVar) {
            String unused = Ctry.f537else;
            com.iproov.sdk.p022package.Cif ifVar = com.iproov.sdk.p022package.Cif.f1093do.m1238do(this.f544do.f539do, doVar.m1230do());
            if (ifVar instanceof Cif.Cfor) {
                Cif.Cfor forR = (Cif.Cfor) ifVar;
                this.f544do.f541if.m674do(forR.m1239do());
                com.iproov.sdk.p009do.Cfor.m567do(forR.m1239do());
            } else if (ifVar instanceof Cif.Cif) {
                this.f544do.f541if.onError(((Cif.Cif) ifVar).m1240do());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m665do((Cfor.Cdo) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$case  reason: invalid class name */
    public static final class Ccase extends Lambda implements l<com.iproov.sdk.p022package.Cfor, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f545do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccase(Ctry tryR) {
            super(1);
            this.f545do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m666do(com.iproov.sdk.p022package.Cfor forR) {
            this.f545do.m648do((Cfor.Cnew) forR);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m666do((com.iproov.sdk.p022package.Cfor) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$catch  reason: invalid class name */
    public static final class Ccatch extends Lambda implements l<Exception, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f546do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccatch(Ctry tryR) {
            super(1);
            this.f546do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m667do(Exception exc) {
            this.f546do.f541if.onError(new UnexpectedErrorException(this.f546do.f539do, exc));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m667do((Exception) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$class  reason: invalid class name */
    public static final class Cclass extends Lambda implements l<Cfor.Cdo, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f547do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cclass(Ctry tryR) {
            super(1);
            this.f547do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m668do(Cfor.Cdo doVar) {
            String unused = Ctry.f537else;
            x.i("Ack received: ", Integer.valueOf(doVar.m1231if()));
            this.f547do.f538case.m63case();
            this.f547do.f541if.m673do(this.f547do.m661for());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m668do((Cfor.Cdo) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$else  reason: invalid class name */
    public static final class Celse extends Lambda implements l<com.iproov.sdk.p022package.Cfor, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f548do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Ctry tryR) {
            super(1);
            this.f548do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m669do(com.iproov.sdk.p022package.Cfor forR) {
            this.f548do.m647do((Cfor.Cif) forR);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m669do((com.iproov.sdk.p022package.Cfor) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$for  reason: invalid class name */
    public static final class Cfor extends Lambda implements l<Exception, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f549do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Ctry tryR) {
            super(1);
            this.f549do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m670do(Exception exc) {
            this.f549do.f541if.onError(new UnexpectedErrorException(this.f549do.f539do, exc));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m670do((Exception) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$goto  reason: invalid class name */
    public static final class Cgoto extends Lambda implements l<com.iproov.sdk.p022package.Cfor, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f550do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cgoto(Ctry tryR) {
            super(1);
            this.f550do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m671do(com.iproov.sdk.p022package.Cfor forR) {
            this.f550do.m646do((Cfor.Cfor) forR);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m671do((com.iproov.sdk.p022package.Cfor) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: do  reason: not valid java name */
        void m672do();

        /* renamed from: do  reason: not valid java name */
        void m673do(double d11);

        /* renamed from: do  reason: not valid java name */
        void m674do(com.iproov.sdk.p003case.Cif ifVar);

        /* renamed from: do  reason: not valid java name */
        void m675do(com.iproov.sdk.p035try.Cdo doVar);

        /* renamed from: if  reason: not valid java name */
        void m676if();

        void onConnected();

        void onConnecting();

        void onError(IProovException iProovException);
    }

    /* renamed from: com.iproov.sdk.finally.try$new  reason: invalid class name */
    public static final class Cnew implements Cdo.Cdo {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f551do;

        public Cnew(Ctry tryR) {
            this.f551do = tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public void m677do() {
            this.f551do.f541if.onConnected();
        }

        /* renamed from: if  reason: not valid java name */
        public void m681if() {
            String unused = Ctry.f537else;
            this.f551do.f538case.m76this();
            this.f551do.f541if.m672do();
        }

        /* renamed from: do  reason: not valid java name */
        public void m679do(String str, int i11) {
            String unused = Ctry.f537else;
        }

        /* renamed from: do  reason: not valid java name */
        public void m678do(String str) {
            NetworkException networkException = new NetworkException(this.f551do.f539do, str);
            networkException.printStackTrace();
            String unused = Ctry.f537else;
            x.i("onError: ", networkException);
            this.f551do.f541if.onError(networkException);
        }

        /* renamed from: do  reason: not valid java name */
        public void m680do(byte[] bArr) {
            String unused = Ctry.f537else;
            this.f551do.m650do(bArr);
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$this  reason: invalid class name */
    public static final class Cthis extends Lambda implements l<Cfor.Cdo, Unit> {

        /* renamed from: do  reason: not valid java name */
        public static final Cthis f552do = new Cthis();

        public Cthis() {
            super(1);
        }

        /* renamed from: do  reason: not valid java name */
        public final void m682do(Cfor.Cdo doVar) {
            String unused = Ctry.f537else;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m682do((Cfor.Cdo) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.finally.try$try  reason: invalid class name */
    public /* synthetic */ class Ctry extends FunctionReferenceImpl implements l<String, Unit> {
        public Ctry(Object obj) {
            super(1, obj, Ctry.class, "onTimeout", "onTimeout(Ljava/lang/String;)V", 0);
        }

        /* renamed from: do  reason: not valid java name */
        public final void m683do(String str) {
            ((Ctry) this.receiver).m653for(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m683do((String) obj);
            return Unit.f56620a;
        }
    }

    static {
        new Cdo((r) null);
    }

    public Ctry(Context context, String str, String str2, Cextends.Ccatch catchR, Cif ifVar) {
        this.f539do = context;
        this.f541if = ifVar;
        this.f540for = new com.iproov.sdk.p028strictfp.Cnew(str2, catchR);
        this.f542new = new com.iproov.sdk.p007continue.Cif(m638do(str), context, catchR);
        Cextends.Ccatch catchR2 = catchR;
        this.f538case = new com.iproov.sdk.p001abstract.Cdo(catchR2, 5, new Ctry(this), new com.iproov.sdk.p023private.Cfor(5, context), new com.iproov.sdk.p023private.Cdo(), new com.iproov.sdk.p028strictfp.Cfor(MapsKt__MapsKt.j(kotlin.l.a(Reflection.b(Cfor.Cnew.class), new Ccase(this)), kotlin.l.a(Reflection.b(Cfor.Cif.class), new Celse(this)), kotlin.l.a(Reflection.b(Cfor.Cfor.class), new Cgoto(this)))));
    }

    /* renamed from: new  reason: not valid java name */
    public final synchronized void m664new(String str) {
        if (this.f542new.m301do()) {
            m649do((com.iproov.sdk.p022package.Cnew) new Cnew.Cdo(str), (l<? super Cfor.Cdo, Unit>) Cthis.f552do);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public final void m653for(String str) {
        m663if(str);
        IPLog.w(f537else, "Socket timeout");
        this.f541if.onError(new NetworkException(this.f539do, "Socket timeout"));
    }

    /* renamed from: if  reason: not valid java name */
    public final synchronized void m662if() {
        m655new();
    }

    /* renamed from: if  reason: not valid java name */
    public final synchronized void m663if(String str) {
        this.f538case.m76this();
        x.i("Disconnecting... ", str);
        this.f541if.m676if();
        this.f542new.m299do(str);
    }

    /* renamed from: new  reason: not valid java name */
    private final void m655new() {
        this.f542new.m298do((Cdo.Cdo) new Cnew(this));
        this.f541if.onConnecting();
    }

    /* renamed from: for  reason: not valid java name */
    public final double m661for() {
        double d11 = this.f538case.m73if();
        return d11 + ((1.0d - d11) * this.f538case.m64do());
    }

    /* renamed from: do  reason: not valid java name */
    public final synchronized void m659do(com.iproov.sdk.p035try.Cif ifVar) {
        if (this.f542new.m301do()) {
            x.i("Sending client_start: ", ifVar);
            com.iproov.sdk.core.Cbreak.m310do(com.iproov.sdk.core.Ccatch.AND7);
            m649do((com.iproov.sdk.p022package.Cnew) new Cnew.Cif(ifVar, Cif.f534do.m630do(this.f539do, this.f540for.m1847do(), ifVar.m2138if())), (l<? super Cfor.Cdo, Unit>) new Cbreak(this));
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: do  reason: not valid java name */
    public final synchronized void m660do(byte[] bArr, Long l11, List<Cstatic> list, RectF rectF, String str, com.iproov.sdk.p005class.Celse elseR, com.iproov.sdk.core.Cif ifVar, boolean z11, Cbreak.Cfor forR) throws IProovException {
        byte[] bArr2 = bArr;
        boolean z12 = z11;
        Cbreak.Cfor forR2 = forR;
        synchronized (this) {
            if (this.f542new.m301do()) {
                Cnew.Ccase caseR = r2;
                Cnew.Ccase caseR2 = new Cnew.Ccase(this.f540for.m1847do(), this.f538case.m77try(), this.f543try.m1840if(), this.f543try.m1838do(), elseR, this.f538case.m71for() + 1, z11, list, ifVar, rectF, l11, str, m651do(bArr2, z12));
                this.f538case.m71for();
                Objects.toString(ifVar);
                int length = bArr2.length;
                this.f538case.m66do((long) bArr2.length);
                if (z11) {
                    long j11 = this.f538case.m75new() / ((long) 1024);
                    Cbreak.Cfor forR3 = forR;
                    if (forR3 != null) {
                        x.i("Sending telemetry: ", forR.m560do());
                        m642do(this, new Cnew.Ctry(forR3), (l) null, 2, (Object) null);
                    }
                }
                com.iproov.sdk.core.Cbreak.m310do(com.iproov.sdk.core.Ccatch.AND6);
                m649do((com.iproov.sdk.p022package.Cnew) caseR, (l<? super Cfor.Cdo, Unit>) new Cclass(this));
                this.f538case.m70else();
            } else {
                throw new NetworkException(this.f539do, "Cannot send video (socket not connected)");
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ void m644do(Ctry tryR, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        tryR.m663if(str);
    }

    /* renamed from: do  reason: not valid java name */
    public final synchronized void m658do(com.iproov.sdk.p033throws.Cbreak breakR) {
        if (this.f542new.m301do()) {
            m642do(this, new Cnew.Cnew(breakR), (l) null, 2, (Object) null);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m656do(int i11) {
        this.f538case.m74if(i11);
    }

    /* renamed from: do  reason: not valid java name */
    public final void m657do(com.iproov.sdk.cameray.Cbreak breakR, int i11) {
        this.f543try.m1839do(breakR, i11);
    }

    /* renamed from: do  reason: not valid java name */
    private final byte[] m651do(byte[] bArr, boolean z11) {
        try {
            return this.f538case.m69do(bArr, z11, this.f540for.m1847do());
        } catch (Cdo e11) {
            e11.printStackTrace();
            throw new UnexpectedErrorException(this.f539do, (Exception) e11);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private final String m638do(String str) {
        this.f540for.m1847do();
        return str + '/' + this.f540for.m1847do();
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m646do(Cfor.Cfor forR) {
        this.f538case.m72goto();
        this.f538case.m65do(forR.m1232do());
        this.f541if.m673do(m661for());
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m648do(Cfor.Cnew newR) {
        this.f538case.m76this();
        com.iproov.sdk.p035try.Cdo doVar = new com.iproov.sdk.p035try.Cdo(newR.m1234do(), newR.m1235for(), this.f540for.m1847do());
        m642do(this, new Cnew.Cfor(com.iproov.sdk.p028strictfp.Ccase.f1964do.m1837do(), newR.m1236if()), (l) null, 2, (Object) null);
        this.f541if.m675do(doVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m647do(Cfor.Cif ifVar) {
        x.i("onEdgeAbort ", ifVar.m1233do());
        this.f538case.m76this();
        this.f541if.onError(new ServerException(this.f539do, ifVar.m1233do()));
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m650do(byte[] bArr) {
        this.f538case.m68do(bArr, (l<? super Exception, Unit>) new Cfor(this));
    }

    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ void m642do(Ctry tryR, com.iproov.sdk.p022package.Cnew newR, l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            lVar = null;
        }
        tryR.m649do(newR, (l<? super Cfor.Cdo, Unit>) lVar);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m649do(com.iproov.sdk.p022package.Cnew newR, l<? super Cfor.Cdo, Unit> lVar) {
        com.iproov.sdk.core.Cbreak.m310do(com.iproov.sdk.core.Ccatch.AND8);
        this.f538case.m67do(newR, this.f542new, lVar, new Ccatch(this));
    }
}
