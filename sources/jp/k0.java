package jp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.utils.OtcPayMethodUtil;
import jp.l;
import q6.d;
import rx.Subscription;
import up.g;
import va.b;

public final class k0 {

    /* renamed from: b  reason: collision with root package name */
    public static final k0 f84341b = new k0();

    /* renamed from: a  reason: collision with root package name */
    public Subscription f84342a;

    public static void c(Intent intent) {
        Bundle extras;
        if (intent != null && intent.getExtras() != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("tradeSide")) {
                String string = extras.getString("tradeSide");
                extras.remove("tradeSide");
                if ("buy".equalsIgnoreCase(string)) {
                    extras.putInt("tradeSide", 0);
                } else if ("sell".equalsIgnoreCase(string)) {
                    extras.putInt("tradeSide", 1);
                }
            }
            if (extras.containsKey("isOutArea")) {
                boolean parseBoolean = Boolean.parseBoolean(extras.getString("isOutArea"));
                extras.remove("isOutArea");
                extras.putBoolean("isOutArea", parseBoolean);
            }
            if (extras.containsKey("tradeArea")) {
                Object obj = extras.get("tradeArea");
                extras.remove("tradeArea");
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (OtcTradeAreaEnum.checkIsLegal(str)) {
                        extras.putInt("tradeArea", OtcTradeAreaEnum.matchTradeArea(str).getCode());
                    }
                }
            }
            intent.replaceExtras(extras);
        }
    }

    public static k0 d() {
        return f84341b;
    }

    public static OtcTradeAreaEnum e() {
        OtcTradeAreaEnum matchTradeArea = OtcTradeAreaEnum.matchTradeArea(f());
        if (OtcTradeAreaEnum.checkIsLegal(matchTradeArea)) {
            return matchTradeArea;
        }
        OtcTradeAreaEnum matchTradeArea2 = OtcTradeAreaEnum.matchTradeArea(b.q(g.c("otc_select_trade_currency_quote_asset")));
        return OtcTradeAreaEnum.checkIsLegal(matchTradeArea2) ? matchTradeArea2 : OtcTradeAreaEnum.FAST_AREA;
    }

    public static int f() {
        return ConfigPreferences.g("otc_config", "OTC_ORDER_LAST_TRADE_TYPE_NEW", -1);
    }

    public static /* synthetic */ void i(Activity activity, UserVO userVO) {
        if (activity != null && !activity.isFinishing()) {
            if (!userVO.isVerifyWayHaveSet()) {
                OtcModuleConfig.b().H(activity);
            } else if (OtcModuleConfig.a().j() == 2) {
                OtcPayMethodUtil.e(activity);
            } else {
                OtcPayMethodUtil.f(activity);
            }
        }
    }

    public static /* synthetic */ void j(Activity activity, UserVO userVO) {
        if (activity != null && !activity.isFinishing()) {
            if (userVO.isVerifyWayHaveSet()) {
                OtcPayMethodUtil.e(activity);
            } else {
                OtcModuleConfig.b().H(activity);
            }
        }
    }

    public static void k(Activity activity) {
        r(activity, (OtcTradeAreaEnum) null, (String) null, (l.c) null);
    }

    public static void l(Context context, Bundle bundle) {
        try {
            m(context, OtcTradeAreaEnum.matchTradeArea(Integer.parseInt(bundle.getString("area", ""))));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void m(Context context, OtcTradeAreaEnum otcTradeAreaEnum) {
        n(context, otcTradeAreaEnum, (String) null);
    }

    public static void n(Context context, OtcTradeAreaEnum otcTradeAreaEnum, String str) {
        o(context, otcTradeAreaEnum, str, (l.c) null);
    }

    public static void o(Context context, OtcTradeAreaEnum otcTradeAreaEnum, String str, l.c cVar) {
        r(context, otcTradeAreaEnum, str, cVar);
    }

    public static void p(Context context, String str) {
        n(context, (OtcTradeAreaEnum) null, str);
    }

    public static void q(int i11) {
        ConfigPreferences.k("otc_config", "OTC_ORDER_LAST_TRADE_TYPE_NEW", i11);
    }

    public static void r(Context context, OtcTradeAreaEnum otcTradeAreaEnum, String str, l.c cVar) {
        boolean z11;
        if (OtcTradeAreaEnum.checkIsLegal(otcTradeAreaEnum)) {
            z11 = true;
        } else {
            otcTradeAreaEnum = e();
            z11 = false;
        }
        OtcTradeActivity.mi(context, otcTradeAreaEnum, str, z11);
        if (cVar != null) {
            cVar.a();
        }
    }

    public void g(Activity activity, u6.g gVar) {
        if (OtcModuleConfig.a().a()) {
            Subscription subscription = this.f84342a;
            if (subscription != null && !subscription.isUnsubscribed()) {
                this.f84342a.unsubscribe();
            }
            if (OtcModuleConfig.a().D()) {
                this.f84342a = OtcPayMethodUtil.c(false, gVar).subscribe(d.c(gVar, new i0(activity)));
            } else {
                this.f84342a = OtcPayMethodUtil.d(false, gVar).subscribe(d.c(gVar, new j0(activity)));
            }
        } else {
            OtcModuleConfig.a().l(activity, (Intent) null, (Intent) null);
        }
    }

    public void h(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent(context, OtcModuleConfig.b().I());
        }
        if (OtcModuleConfig.a().a()) {
            context.startActivity(intent);
        } else if (context instanceof Activity) {
            OtcModuleConfig.a().l((Activity) context, intent, (Intent) null);
        }
    }
}
