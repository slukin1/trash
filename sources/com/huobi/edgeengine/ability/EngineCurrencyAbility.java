package com.huobi.edgeengine.ability;

import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.huobi.edgeengine.ability.AbilityFunction;
import d7.k;
import kotlin.jvm.internal.r;
import rj.b;

public final class EngineCurrencyAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43888a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        CurrencyBean s11;
        if ((obj instanceof String) && (s11 = k.C().s((String) obj)) != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showPrecision", s11.getPrecision());
            if (aVar != null) {
                aVar.a(true, jSONObject.toJSONString());
            }
        }
    }
}
