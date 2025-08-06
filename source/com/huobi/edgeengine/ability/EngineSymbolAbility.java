package com.huobi.edgeengine.ability;

import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.edgeengine.ability.AbilityFunction;
import d7.a1;
import kotlin.jvm.internal.r;
import rj.b;

public final class EngineSymbolAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43892a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        SymbolBean J;
        if ((obj instanceof String) && (J = a1.v().J((String) obj, TradeType.PRO)) != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("baseCurrencyDisplayName", J.getBaseCurrencyDisplayName());
            jSONObject.put("quoteCurrencyDisplayName", J.getQuoteCurrencyDisplayName());
            jSONObject.put("baseCurrency", J.getBaseCurrency());
            jSONObject.put("tradePricePrecision", Integer.valueOf(J.getTradePricePrecision()));
            jSONObject.put("showPrecision", J.getSymbolPartition());
            jSONObject.put("symbolName", J.getSymbolName());
            if (aVar != null) {
                aVar.a(true, jSONObject.toJSONString());
            }
        }
    }
}
