package com.huobi.home.engine;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.eclipsesource.v8.V8Object;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import kotlin.jvm.internal.x;
import rj.b;
import zn.a;

public final class GuideBridgeAbility extends AbstractAbility {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar == null || obj == null || bVar == null) {
            Log.d("Console", "call GuideBridgeAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("action") ? v8Object.getString("action") : "";
            if (x.b(string, "openPage")) {
                f(v8Object, bVar.d(), aVar);
            } else if (x.b(string, "getColorMode")) {
                e(v8Object, bVar.d(), aVar);
            } else {
                aVar.a(true, "");
            }
        } catch (Throwable th2) {
            Log.d("Console", "call GuideBridgeAbility error ");
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public boolean b() {
        return false;
    }

    public final void c(Activity activity) {
        String str;
        if (p.i(activity)) {
            str = "hkd";
        } else if (p.h(activity)) {
            str = "cny";
        } else if (p.c(activity)) {
            str = "rub";
        } else {
            str = p.g(activity) ? "vnd" : "usd";
        }
        a.d().v(Uri.parse("holigeit://open/v1?&login=1&url=ihuobiglobal://m.hbg.com/otc/index?isOutArea=true&tradeArea=p2p&tradeSide=buy&siteType=1&tradeCurrency=usdt&fiatName=" + str)).a().c();
        activity.finish();
    }

    public final void d(Activity activity) {
        a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/index?tradeArea=deposit&isOutArea=true&isFromGuide=true")).a().c();
        activity.finish();
    }

    public final void e(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        aVar.a(true, NightHelper.e().g() ? "1" : "0");
    }

    public final void f(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        boolean z11 = true;
        String str = null;
        String string = v8Object != null && v8Object.contains("type") ? v8Object != null ? v8Object.getString("type") : null : "";
        if (!(v8Object != null && v8Object.contains(PlaceFields.PAGE))) {
            str = "";
        } else if (v8Object != null) {
            str = v8Object.getString(PlaceFields.PAGE);
        }
        if (string == null || !string.equals("url")) {
            z11 = false;
        }
        if (z11) {
            BaseModuleConfig.a().k0(str);
        } else if (x.b(str, "deposit")) {
            d((Activity) context);
        } else if (x.b(str, "buy")) {
            c((Activity) context);
        }
    }
}
