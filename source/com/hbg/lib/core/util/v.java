package com.hbg.lib.core.util;

import com.hbg.lib.network.hbg.otcoptions.PreVisibleBean;
import rx.Observable;
import rx.functions.Action1;
import v7.b;

public final class v {

    /* renamed from: b  reason: collision with root package name */
    public static v f68754b = new v();

    /* renamed from: a  reason: collision with root package name */
    public Boolean f68755a;

    public class a implements Action1<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void call(Boolean bool) {
            Boolean unused = v.this.f68755a = bool;
        }
    }

    public static v e() {
        return f68754b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(PreVisibleBean preVisibleBean) {
        this.f68755a = Boolean.valueOf(preVisibleBean.isVisible());
    }

    public Observable<PreVisibleBean> f() {
        return b.a().getPreVisible().b().doOnNext(new s(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
        r3 = r2.f68755a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.Observable<java.lang.Boolean> g(boolean r3) {
        /*
            r2 = this;
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0011
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            rx.Observable r3 = rx.Observable.just(r3)
            return r3
        L_0x0011:
            com.hbg.lib.network.hbg.IHbgApi r0 = v7.b.a()
            d9.a r0 = r0.getPreVisible()
            rx.Observable r0 = r0.b()
            com.hbg.lib.core.util.t r1 = com.hbg.lib.core.util.t.f68752b
            rx.Observable r0 = r0.flatMap(r1)
            com.hbg.lib.core.util.v$a r1 = new com.hbg.lib.core.util.v$a
            r1.<init>()
            rx.Observable r0 = r0.doOnNext(r1)
            com.hbg.lib.core.util.u r1 = com.hbg.lib.core.util.u.f68753b
            rx.Observable r0 = r0.onErrorReturn(r1)
            if (r3 == 0) goto L_0x003d
            java.lang.Boolean r3 = r2.f68755a
            if (r3 == 0) goto L_0x003d
            rx.Observable r3 = rx.Observable.just(r3)
            return r3
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.core.util.v.g(boolean):rx.Observable");
    }
}
