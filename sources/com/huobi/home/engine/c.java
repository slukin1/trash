package com.huobi.home.engine;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import d7.a1;
import java.util.Locale;
import java.util.Map;
import rj.b;
import tg.r;
import yl.g;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f72480a = new c();

    public static final class a implements V2TIMValueCallback<V2TIMConversationResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f72481a;

        public a(b bVar) {
            this.f72481a = bVar;
        }

        /* renamed from: a */
        public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
            JSONObject jSONObject = new JSONObject();
            int i11 = 0;
            for (V2TIMConversation unreadCount : v2TIMConversationResult.getConversationList()) {
                i11 += unreadCount.getUnreadCount();
            }
            jSONObject.put("count", Integer.valueOf(i11));
            b bVar = this.f72481a;
            if (bVar != null) {
                bVar.I("nav.sendUnreadMessage(" + jSONObject + ')');
            }
        }

        public void onError(int i11, String str) {
            Log.d("Home", "message error i =" + i11 + " s=" + str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002b, code lost:
        r3 = r1.j();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(rj.b r10) {
        /*
            r9 = this;
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
            boolean r1 = com.hbg.lib.core.util.w.l()
            r2 = 1
            r1 = r1 ^ r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "priceColorType"
            r0.put(r3, r1)
            com.hbg.lib.core.util.NightHelper r1 = com.hbg.lib.core.util.NightHelper.e()
            boolean r1 = r1.g()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "colorMode"
            r0.put(r3, r1)
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()
            if (r1 == 0) goto L_0x003d
            java.lang.String r3 = r1.j()
            if (r3 == 0) goto L_0x003d
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r4 = "https://"
            java.lang.String r5 = ""
            java.lang.String r1 = kotlin.text.StringsKt__StringsJVMKt.G(r3, r4, r5, r6, r7, r8)
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            java.lang.String r3 = "iconURLHost"
            r0.put(r3, r1)
            java.lang.String r1 = "iconPlaceholder"
            java.lang.String r3 = ""
            r0.put(r1, r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "OS"
            r0.put(r2, r1)
            r1 = 105400(0x19bb8, float:1.47697E-40)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "appVersion"
            r0.put(r2, r1)
            java.util.Locale r1 = m6.a.a()
            java.lang.String r2 = "language"
            r0.put(r2, r1)
            android.app.Application r1 = bh.j.c()
            int r1 = r1.hashCode()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "appLifeCycleId"
            r0.put(r2, r1)
            boolean r1 = com.huobi.utils.UpgradeUtil.c()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r2 = "hasNewVersion"
            r0.put(r2, r1)
            if (r10 == 0) goto L_0x00a1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "sendCommonConfig("
            r1.append(r2)
            r1.append(r0)
            r0 = 41
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.I(r0)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.c.a(rj.b):void");
    }

    public final void b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        boolean z11 = true;
        jSONObject.put("isLogin", Integer.valueOf(r.x().F0() ? StringUtils.q(r.x().H()) ? 1 : 2 : 0));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("uId", r.x().J());
        jSONObject2.put("name", r.x().N());
        jSONObject2.put("isChildAccount", Boolean.valueOf(r.x().X()));
        jSONObject2.put("headImage", r.x().p());
        if (r.x().D() == null) {
            z11 = false;
        }
        jSONObject2.put("isNFT", Boolean.valueOf(z11));
        jSONObject2.put("countryId", sn.a.c().a());
        jSONObject2.put("registerCountryId", String.valueOf(g.h().g()));
        jSONObject.put("userInfo", jSONObject2);
        if (bVar != null) {
            bVar.I("sendLoginStatus(" + jSONObject + ')');
        }
    }

    public final void c(b bVar) {
        if (bVar != null) {
            bVar.I("pageAppear()");
        }
    }

    public final void d(b bVar) {
        if (bVar != null) {
            bVar.I("pageDisappear()");
        }
    }

    public final void e(b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FirebaseAnalytics.Param.CHARACTER, LegalCurrencyConfigUtil.y().toUpperCase(Locale.ROOT));
        if (bVar != null) {
            bVar.I("sendRateTypeStr(" + jSONObject + ')');
        }
    }

    public final void f(b bVar, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("data", jSONObject);
        if (bVar != null) {
            bVar.I("sendSocketData(" + jSONObject2 + ')');
        }
    }

    public final void g(b bVar) {
        Map<String, SymbolBean> V = a1.v().V(TradeType.PRO);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : V.entrySet()) {
            SymbolBean symbolBean = (SymbolBean) next.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isHad", Boolean.valueOf(symbolBean.isHadSt()));
            jSONObject2.put("isSt", Boolean.valueOf(symbolBean.isStTag()));
            jSONObject2.put("isHiddenUp", Boolean.valueOf(symbolBean.hasTag(SymbolBean.TAG_HIDDEN_UP)));
            jSONObject2.put("baseCurrencyDisplayName", symbolBean.getBaseCurrencyDisplayName());
            jSONObject2.put("quoteCurrencyDisplayName", symbolBean.getQuoteCurrencyDisplayName());
            jSONObject2.put("tradePricePrecision", Integer.valueOf(symbolBean.getTradePricePrecision()));
            jSONObject.put((String) next.getKey(), jSONObject2);
        }
        if (bVar != null) {
            bVar.I("sendSymbolInfo(" + jSONObject + ')');
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        if ("1".equals(r1) != false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(rj.b r6) {
        /*
            r5 = this;
            jo.a r0 = jo.a.e()
            java.util.Map r0 = r0.d()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x001a
            java.lang.String r2 = "Push-Chat"
            java.lang.Object r0 = r0.get(r2)
            com.hbg.lib.network.uc.retrofit.bean.MessageConfig r0 = (com.hbg.lib.network.uc.retrofit.bean.MessageConfig) r0
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isLogin "
            r2.append(r3)
            tg.r r3 = tg.r.x()
            boolean r3 = r3.F0()
            r2.append(r3)
            java.lang.String r3 = " isOpen"
            r2.append(r3)
            if (r0 == 0) goto L_0x003c
            java.lang.String r3 = r0.d()
            goto L_0x003d
        L_0x003c:
            r3 = r1
        L_0x003d:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Home"
            android.util.Log.d(r3, r2)
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x007a
            if (r0 == 0) goto L_0x005a
            java.lang.String r2 = r0.d()
            goto L_0x005b
        L_0x005a:
            r2 = r1
        L_0x005b:
            if (r2 == 0) goto L_0x006b
            if (r0 == 0) goto L_0x0063
            java.lang.String r1 = r0.d()
        L_0x0063:
            java.lang.String r0 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007a
        L_0x006b:
            com.huobi.framework.im.common.ImManager r0 = com.huobi.framework.im.common.ImManager.INSTANCE
            r1 = 0
            r3 = 100
            com.huobi.home.engine.c$a r4 = new com.huobi.home.engine.c$a
            r4.<init>(r6)
            r0.getConversationList(r1, r3, r4)
            goto L_0x00a4
        L_0x007a:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "count"
            r0.put(r2, r1)
            if (r6 == 0) goto L_0x00a4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "nav.sendUnreadMessage("
            r1.append(r2)
            r1.append(r0)
            r0 = 41
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.I(r0)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.c.h(rj.b):void");
    }

    public final void i(b bVar, int i11) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("count", Integer.valueOf(i11));
        if (bVar != null) {
            bVar.I("nav.sendUnreadMessage(" + jSONObject + ')');
        }
    }
}
