package com.huobi.edgeengine.ability;

import android.app.Activity;
import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import java.util.Locale;
import jp.k0;
import kotlin.jvm.internal.r;
import org.json.JSONObject;
import rj.b;

public final class DoubleCoinAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43887a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (bVar != null) {
            JSONObject jSONObject = new JSONObject((String) obj);
            int optInt = jSONObject.optInt("type", -1);
            if (optInt == 1) {
                UnifyTransferActivity.Th((Activity) bVar.d(), jSONObject.optString(FirebaseAnalytics.Param.CURRENCY), "12");
            } else if (optInt == 2) {
                String optString = jSONObject.optString(FirebaseAnalytics.Param.CURRENCY);
                if (StringsKt__StringsJVMKt.w(optString, "USDT", true)) {
                    k0.n(bVar.d(), OtcTradeAreaEnum.matchTradeArea(0), optString.toLowerCase(Locale.ROOT));
                    return;
                }
                Context d11 = bVar.d();
                Context d12 = bVar.d();
                d11.startActivity(com.huobi.utils.k0.s(d12, optString.toLowerCase(Locale.ROOT) + "usdt", true));
            }
        }
    }
}
