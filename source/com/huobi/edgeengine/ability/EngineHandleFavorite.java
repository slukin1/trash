package com.huobi.edgeengine.ability;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.edgeengine.ability.AbilityFunction;
import java.util.Map;
import kotlin.jvm.internal.r;
import rj.b;
import td.i;

public final class EngineHandleFavorite implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43889a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void j(rj.b r0, com.huobi.edgeengine.ability.AbilityFunction.a r1, java.lang.Object r2) {
        /*
            if (r0 == 0) goto L_0x0010
            android.content.Context r0 = r0.d()
            if (r0 == 0) goto L_0x0010
            r2 = 2132019500(0x7f14092c, float:1.9677337E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.hbg.lib.widgets.utils.HuobiToastUtil.v(r0)
            if (r1 == 0) goto L_0x001e
            r0 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r1.a(r0, r2)
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ability.EngineHandleFavorite.j(rj.b, com.huobi.edgeengine.ability.AbilityFunction$a, java.lang.Object):void");
    }

    public static final void k(AbilityFunction.a aVar, APIStatusErrorException aPIStatusErrorException) {
        if (aVar != null) {
            aVar.a(true, 0);
        }
    }

    public static final void l(AbilityFunction.a aVar, Throwable th2) {
        if (aVar != null) {
            aVar.a(true, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r5 = r2.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void n(java.lang.String r1, rj.b r2, com.huobi.edgeengine.ability.AbilityFunction.a r3, boolean r4, java.lang.Throwable r5) {
        /*
            if (r4 == 0) goto L_0x0038
            r4 = 0
            if (r2 == 0) goto L_0x0010
            android.content.Context r5 = r2.d()
            if (r5 == 0) goto L_0x0010
            android.content.Context r5 = r5.getApplicationContext()
            goto L_0x0011
        L_0x0010:
            r5 = r4
        L_0x0011:
            java.lang.String r0 = sn.t.v(r1)
            rx.Observable r1 = sn.t.l(r1, r5, r0)
            rx.Observable$Transformer r4 = com.hbg.lib.core.util.RxJavaHelper.t(r4)
            rx.Observable r1 = r1.compose(r4)
            com.huobi.edgeengine.ability.o r4 = new com.huobi.edgeengine.ability.o
            r4.<init>(r2, r3)
            com.huobi.edgeengine.ability.k r2 = new com.huobi.edgeengine.ability.k
            r2.<init>(r3)
            com.huobi.edgeengine.ability.m r5 = new com.huobi.edgeengine.ability.m
            r5.<init>(r3)
            com.hbg.lib.core.network.rx.EasySubscriber r2 = com.hbg.lib.core.network.rx.EasySubscriber.create(r4, r2, r5)
            r1.subscribe(r2)
            goto L_0x0043
        L_0x0038:
            if (r3 == 0) goto L_0x0043
            r1 = 1
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.a(r1, r2)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ability.EngineHandleFavorite.n(java.lang.String, rj.b, com.huobi.edgeengine.ability.AbilityFunction$a, boolean, java.lang.Throwable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void o(rj.b r0, com.huobi.edgeengine.ability.AbilityFunction.a r1, java.lang.Object r2) {
        /*
            if (r0 == 0) goto L_0x0010
            android.content.Context r0 = r0.d()
            if (r0 == 0) goto L_0x0010
            r2 = 2132019509(0x7f140935, float:1.9677355E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.hbg.lib.widgets.utils.HuobiToastUtil.v(r0)
            if (r1 == 0) goto L_0x001e
            r0 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r1.a(r0, r2)
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ability.EngineHandleFavorite.o(rj.b, com.huobi.edgeengine.ability.AbilityFunction$a, java.lang.Object):void");
    }

    public static final void p(AbilityFunction.a aVar, APIStatusErrorException aPIStatusErrorException) {
        if (aVar != null) {
            aVar.a(true, 0);
        }
    }

    public static final void q(AbilityFunction.a aVar, Throwable th2) {
        if (aVar != null) {
            aVar.a(true, 0);
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof String) {
            Object parse = JSON.parse((String) obj);
            if (parse instanceof Map) {
                Map map = (Map) parse;
                if (map.containsKey("isFavorite") && map.containsKey("symbol")) {
                    String valueOf = String.valueOf(map.get("symbol"));
                    boolean z11 = true;
                    if (Integer.parseInt(String.valueOf(map.get("isFavorite"))) != 1) {
                        z11 = false;
                    }
                    if (!z11) {
                        i(bVar, valueOf, aVar);
                    } else {
                        m(bVar, valueOf, aVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r4.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(rj.b r4, java.lang.String r5, com.huobi.edgeengine.ability.AbilityFunction.a r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x000e
            android.content.Context r1 = r4.d()
            if (r1 == 0) goto L_0x000e
            android.content.Context r1 = r1.getApplicationContext()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            java.lang.String r2 = sn.t.v(r5)
            rx.Observable r5 = sn.t.i(r5, r1, r2)
            rx.Observable$Transformer r0 = com.hbg.lib.core.util.RxJavaHelper.t(r0)
            rx.Observable r5 = r5.compose(r0)
            com.huobi.edgeengine.ability.n r0 = new com.huobi.edgeengine.ability.n
            r0.<init>(r4, r6)
            com.huobi.edgeengine.ability.j r4 = new com.huobi.edgeengine.ability.j
            r4.<init>(r6)
            com.huobi.edgeengine.ability.l r1 = new com.huobi.edgeengine.ability.l
            r1.<init>(r6)
            com.hbg.lib.core.network.rx.EasySubscriber r4 = com.hbg.lib.core.network.rx.EasySubscriber.create(r0, r4, r1)
            r5.subscribe(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ability.EngineHandleFavorite.i(rj.b, java.lang.String, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final void m(b bVar, String str, AbilityFunction.a aVar) {
        i.a().b().g(str, new p(str, bVar, aVar));
    }
}
