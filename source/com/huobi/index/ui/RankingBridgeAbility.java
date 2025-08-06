package com.huobi.index.ui;

import al.p;
import android.content.Context;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.eclipsesource.v8.V8Object;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.index.bean.RankingListData;
import com.huobi.index.ui.RankingActivity;
import com.huochat.community.network.domain.DomainTool;
import com.huochat.community.util.JsonTool;
import d7.a1;
import java.util.Locale;
import java.util.Map;
import rj.b;
import sn.f;
import yl.t;

public class RankingBridgeAbility extends AbstractAbility {

    /* renamed from: a  reason: collision with root package name */
    public static RankingActivity.c f73821a;

    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f73822b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f73823c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f73824d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, b bVar, String str3) {
            super(str);
            this.f73822b = str2;
            this.f73823c = bVar;
            this.f73824d = str3;
        }

        public static /* synthetic */ void b(String str, RankingListData rankingListData) {
            RankingActivity.c cVar = RankingBridgeAbility.f73821a;
            if (cVar != null) {
                cVar.a(str, rankingListData);
            }
        }

        public void run() {
            this.f73823c.r(new t1(this.f73824d, (RankingListData) JsonTool.parseObject(this.f73822b, RankingListData.class)));
        }
    }

    public static /* synthetic */ void d(RankingListData rankingListData) {
        RankingActivity.c cVar = f73821a;
        if (cVar != null) {
            cVar.a("setRankingRequestError", rankingListData);
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        String str;
        AbilityFunction.a aVar2 = aVar;
        if (aVar2 == null || obj == null) {
            Log.d("Console", "call RankingBridgeAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("action") ? v8Object.getString("action") : "";
            if (v8Object.contains("data")) {
                str = v8Object.getString("data");
            } else {
                str = "";
            }
            Context d11 = bVar.d();
            char c11 = 65535;
            switch (string.hashCode()) {
                case -2137898495:
                    if (string.equals("getVolumeStr")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -1619342848:
                    if (string.equals("getIconURL")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1290010831:
                    if (string.equals("getAllSymbolInfo")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -815430852:
                    if (string.equals("goToKLine")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -576893875:
                    if (string.equals("setRankingRequestError")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -497295554:
                    if (string.equals("setRankingData")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -31950244:
                    if (string.equals("getSymbolInfo")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 12936938:
                    if (string.equals("getPriceColorType")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 314182241:
                    if (string.equals("getRateTypeStr")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1482452228:
                    if (string.equals("getIconPlaceholder")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 1898460104:
                    if (string.equals("getIconURLHost")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    b bVar2 = bVar;
                    new a("ranking", str, bVar, string).start();
                    aVar2.a(true, "");
                    return;
                case 1:
                    SymbolBean J = a1.v().J(str, TradeType.PRO);
                    JSONObject jSONObject = new JSONObject();
                    Log.d("Console", "call RankingBridgeAbility getSymbolInfo ");
                    if (J != null) {
                        jSONObject.put("isHad", (Object) Boolean.valueOf(J.isHadSt()));
                        jSONObject.put("isSt", (Object) Boolean.valueOf(J.isStTag()));
                        jSONObject.put("isHiddenUp", (Object) Boolean.valueOf(J.hasTag(SymbolBean.TAG_HIDDEN_UP)));
                        jSONObject.put("baseCurrencyDisplayName", (Object) J.getBaseCurrencyDisplayName());
                        jSONObject.put("quoteCurrencyDisplayName", (Object) J.getQuoteCurrencyDisplayName());
                        jSONObject.put("tradePricePrecision", (Object) Integer.valueOf(J.getTradePricePrecision()));
                        aVar2.a(true, jSONObject.toString());
                        return;
                    }
                    aVar2.a(true, "");
                    return;
                case 2:
                    Map<String, SymbolBean> V = a1.v().V(TradeType.PRO);
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry next : V.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("isHad", (Object) Boolean.valueOf(((SymbolBean) next.getValue()).isHadSt()));
                        jSONObject3.put("isSt", (Object) Boolean.valueOf(((SymbolBean) next.getValue()).isStTag()));
                        jSONObject3.put("isHiddenUp", (Object) Boolean.valueOf(((SymbolBean) next.getValue()).hasTag(SymbolBean.TAG_HIDDEN_UP)));
                        jSONObject3.put("baseCurrencyDisplayName", (Object) ((SymbolBean) next.getValue()).getBaseCurrencyDisplayName());
                        jSONObject3.put("quoteCurrencyDisplayName", (Object) ((SymbolBean) next.getValue()).getQuoteCurrencyDisplayName());
                        jSONObject3.put("tradePricePrecision", (Object) Integer.valueOf(((SymbolBean) next.getValue()).getTradePricePrecision()));
                        jSONObject2.put((String) next.getKey(), (Object) jSONObject3);
                    }
                    aVar2.a(true, jSONObject2.toString());
                    return;
                case 3:
                    aVar2.a(true, AssetModuleConfig.a().j().replace(DomainTool.DOMAIN_PREFIX, ""));
                    return;
                case 4:
                    aVar2.a(true, p.l(str));
                    return;
                case 5:
                    aVar2.a(true, LegalCurrencyConfigUtil.y().toUpperCase(Locale.US));
                    return;
                case 6:
                    aVar2.a(true, t.j(str));
                    return;
                case 7:
                    aVar2.a(true, w.l() ? "0" : "1");
                    return;
                case 8:
                    Log.d("Console", "call RankingBridgeAbility setRankingRequestError " + str);
                    bVar.r(new s1((RankingListData) JsonTool.parseObject(str, RankingListData.class)));
                    return;
                case 9:
                    Log.d("Console", "call RankingBridgeAbility goToKLine ");
                    Log.d("Console", "call RankingBridgeAbility goToKLine start ");
                    f.C(d11, str, false, TradeType.PRO);
                    return;
                case 10:
                    aVar2.a(true, "");
                    return;
                default:
                    aVar2.a(true, "");
                    return;
            }
        } catch (Exception e11) {
            Log.d("Console", "call RankingBridgeAbility error ");
            e11.printStackTrace();
            aVar2.a(false, e11.getMessage());
        }
        Log.d("Console", "call RankingBridgeAbility error ");
        e11.printStackTrace();
        aVar2.a(false, e11.getMessage());
    }

    public boolean b() {
        return false;
    }
}
