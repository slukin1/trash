package com.iproov.sdk.p001abstract;

import com.iproov.sdk.p022package.Cfor;
import com.iproov.sdk.p023private.Cnew;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.p028strictfp.Ctry;
import d10.a;
import d10.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* renamed from: com.iproov.sdk.abstract.do  reason: invalid class name and invalid package */
public final class Cdo {
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public String f15break;

    /* renamed from: case  reason: not valid java name */
    private final com.iproov.sdk.p028strictfp.Cif f16case = new com.iproov.sdk.p028strictfp.Cif();

    /* renamed from: do  reason: not valid java name */
    private final int f17do;

    /* renamed from: else  reason: not valid java name */
    private final Cif f18else = new Cif();

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p023private.Cif f19for;

    /* renamed from: goto  reason: not valid java name */
    private final Map<Integer, l<Cfor.Cdo, Unit>> f20goto = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final l<String, Unit> f21if;

    /* renamed from: new  reason: not valid java name */
    private final Cnew f22new;

    /* renamed from: this  reason: not valid java name */
    private final Ctry f23this;

    /* renamed from: try  reason: not valid java name */
    private final com.iproov.sdk.p028strictfp.Cfor f24try;

    /* renamed from: com.iproov.sdk.abstract.do$do  reason: invalid class name */
    public static final class Cdo extends Lambda implements l<Cfor, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdo f25do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cdo doVar) {
            super(1);
            this.f25do = doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m78do(Cfor forR) {
            this.f25do.m60do((Cfor.Cdo) forR);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m78do((Cfor) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.abstract.do$if  reason: invalid class name */
    public static final class Cif extends Lambda implements a<Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdo f26do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cdo doVar) {
            super(0);
            this.f26do = doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m79do() {
            this.f26do.f21if.invoke(this.f26do.f15break);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m79do();
            return Unit.f56620a;
        }
    }

    public Cdo(Cextends.Ccatch catchR, int i11, l<? super String, Unit> lVar, com.iproov.sdk.p023private.Cif ifVar, Cnew newR, com.iproov.sdk.p028strictfp.Cfor forR) {
        this.f17do = i11;
        this.f21if = lVar;
        this.f19for = ifVar;
        this.f22new = newR;
        this.f24try = forR;
        this.f23this = new Ctry((long) (catchR.m1486if() * 1000));
        forR.m1841do().put(Reflection.b(Cfor.Cdo.class), new Cdo(this));
    }

    /* renamed from: case  reason: not valid java name */
    public final void m63case() {
        this.f18else.m80case();
    }

    /* renamed from: else  reason: not valid java name */
    public final void m70else() {
        this.f18else.m84else();
    }

    /* renamed from: for  reason: not valid java name */
    public final int m71for() {
        return this.f18else.m88try();
    }

    /* renamed from: goto  reason: not valid java name */
    public final void m72goto() {
        this.f23this.m1850do((a<Unit>) new Cif(this));
    }

    /* renamed from: new  reason: not valid java name */
    public final long m75new() {
        return this.f16case.m1844do();
    }

    /* renamed from: this  reason: not valid java name */
    public final void m76this() {
        this.f23this.m1849do();
    }

    /* renamed from: try  reason: not valid java name */
    public final int m77try() {
        return this.f17do;
    }

    /* renamed from: if  reason: not valid java name */
    public final double m73if() {
        return (((double) this.f18else.m81do()) / ((double) this.f18else.m85for())) * 0.5d;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m66do(long j11) {
        com.iproov.sdk.p028strictfp.Cif ifVar = this.f16case;
        ifVar.m1845do(ifVar.m1844do() + j11);
    }

    /* renamed from: if  reason: not valid java name */
    public final void m74if(int i11) {
        this.f18else.m83do(i11);
    }

    /* renamed from: do  reason: not valid java name */
    public final byte[] m69do(byte[] bArr, boolean z11, String str) {
        return this.f16case.m1846do(bArr, z11, str);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m58do(int i11, l<? super Cfor.Cdo, Unit> lVar) {
        this.f20goto.put(Integer.valueOf(i11), lVar);
        m72goto();
    }

    /* renamed from: do  reason: not valid java name */
    public final void m67do(com.iproov.sdk.p022package.Cnew newR, com.iproov.sdk.p007continue.Cdo doVar, l<? super Cfor.Cdo, Unit> lVar, l<? super Exception, Unit> lVar2) {
        int incrementAndGet = this.f18else.m87new().incrementAndGet();
        if (lVar != null) {
            m58do(incrementAndGet, lVar);
            m61do(this.f22new.m1277do(newR));
        }
        try {
            doVar.m291do(this.f19for.m1276do(newR, incrementAndGet));
        } catch (Exception e11) {
            lVar2.invoke(e11);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m68do(byte[] bArr, l<? super Exception, Unit> lVar) {
        try {
            this.f24try.m1842do(this.f19for.m1275do(bArr));
        } catch (Exception e11) {
            lVar.invoke(e11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m60do(Cfor.Cdo doVar) {
        l lVar = this.f20goto.get(Integer.valueOf(doVar.m1231if()));
        this.f20goto.remove(Integer.valueOf(doVar.m1231if()));
        if (this.f20goto.isEmpty()) {
            m76this();
        } else {
            m72goto();
        }
        if (lVar != null) {
            lVar.invoke(doVar);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m65do(int i11) {
        this.f18else.m82do(((double) i11) / ((double) 100));
    }

    /* renamed from: do  reason: not valid java name */
    public final double m64do() {
        return this.f18else.m86if();
    }

    /* renamed from: do  reason: not valid java name */
    private final void m61do(String str) {
        this.f15break = str;
    }
}
