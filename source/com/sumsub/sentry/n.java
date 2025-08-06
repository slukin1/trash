package com.sumsub.sentry;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class n implements h, Closeable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f30432d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final String f30433e = "production";

    /* renamed from: a  reason: collision with root package name */
    public final l0 f30434a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f30435b;

    /* renamed from: c  reason: collision with root package name */
    public final k f30436c;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public n(l0 l0Var, b0 b0Var, k kVar) {
        this.f30434a = l0Var;
        this.f30435b = b0Var;
        this.f30436c = kVar;
    }

    public final k a() {
        return this.f30436c;
    }

    public final void b(u uVar) {
        d(uVar);
        g(uVar);
        f(uVar);
        a(uVar);
    }

    public final void c(u uVar) {
        e(uVar);
    }

    public void close() throws IOException {
        k kVar = this.f30436c;
        if (kVar != null) {
            kVar.c();
        }
    }

    public final void d(u uVar) {
        if (uVar.h() == null) {
            uVar.c("production");
        }
    }

    public final void e(u uVar) {
        if (uVar.m() == null) {
            uVar.e(u.f30502m);
        }
    }

    public final void f(u uVar) {
        if (uVar.q() == null) {
            uVar.a(new s("SumSub", com.sumsub.sns.a.f30551d, (List) null, (List) null, 12, (r) null));
        }
    }

    public final void g(u uVar) {
        if (this.f30436c != null && uVar.s() == null) {
            uVar.g(this.f30436c.d());
        }
    }

    public z a(z zVar) {
        c((u) zVar);
        b(zVar);
        b((u) zVar);
        c(zVar);
        t.f30497a.a(zVar);
        return zVar;
    }

    public final void c(z zVar) {
        List<a0> a11;
        if (zVar.Q() == null) {
            ArrayList arrayList = null;
            m0<a0> E = zVar.E();
            if (!(E == null || (a11 = E.a()) == null)) {
                for (a0 a0Var : a11) {
                    if (!(a0Var.a() == null || a0Var.g() == null)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(a0Var.g());
                    }
                }
            }
            List<k0> a12 = this.f30434a.a(arrayList);
            if (a12 != null) {
                zVar.b(new m0(a12));
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(l0 l0Var, b0 b0Var, k kVar, int i11, r rVar) {
        this((i11 & 1) != 0 ? new l0(new j0((List) null, (List) null, 3, (r) null)) : l0Var, (i11 & 2) != 0 ? new b0(new j0((List) null, (List) null, 3, (r) null)) : b0Var, kVar);
    }

    public final void b(z zVar) {
        Throwable x11 = zVar.x();
        if (x11 != null) {
            zVar.a(new m0(CollectionsKt___CollectionsKt.I0(CollectionsKt___CollectionsKt.X(this.f30435b.b(x11)))));
        }
    }

    public final void a(u uVar) {
        if (uVar.z() == null) {
            uVar.a(new q0((String) null, (String) null, (String) null, (String) null, 15, (r) null));
        }
    }

    public final boolean b() {
        k kVar = this.f30436c;
        if (kVar != null) {
            return kVar.f();
        }
        return true;
    }
}
