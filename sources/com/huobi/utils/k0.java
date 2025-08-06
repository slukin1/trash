package com.huobi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.b;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.activity.FutureTradeContainerActivity;
import com.huobi.activity.TradeContainerActivity;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.feature.ui.FutureTradeFragment;
import com.huobi.homemarket.ui.HomeMarketNewFragment;
import com.huobi.homemarket.ui.MarketContainerActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.otc.flutter.OtcTradePayingAndSuccessActivity;
import com.huobi.trade.helper.j;
import com.huobi.trade.ui.TradeFragment;
import d7.a1;
import dt.i2;
import gj.d;
import java.util.List;
import qt.i;
import rn.c;
import tg.r;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static TradeType f83751a = null;

    /* renamed from: b  reason: collision with root package name */
    public static TradeType f83752b = null;

    /* renamed from: c  reason: collision with root package name */
    public static TradeType f83753c = null;

    /* renamed from: d  reason: collision with root package name */
    public static TradeType f83754d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f83755e = "pro.huobi.home";

    /* renamed from: f  reason: collision with root package name */
    public static boolean f83756f = false;

    public static Intent A(Context context, String str) {
        Intent putExtra = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.c2clend");
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra("EXTRA_CURRENCY", str);
        }
        return putExtra;
    }

    public static Intent B(Context context) {
        return C(context, "", true);
    }

    public static Intent C(Context context, String str, boolean z11) {
        if (!d.n().G()) {
            Intent putExtra = new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.c2c").putExtra("trade_driection", z11);
            if (!TextUtils.isEmpty(str)) {
                putExtra.putExtra("symbolId", str);
            }
            return putExtra;
        }
        Intent putExtra2 = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.c2c").putExtra("trade_driection", z11);
        if (!TextUtils.isEmpty(str)) {
            putExtra2.putExtra("symbolId", str);
            i2.a().h(TradeType.C2C, str);
        }
        G("pro.huobi.c2c");
        TradeType tradeType = TradeType.C2C;
        H(tradeType);
        F(tradeType);
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        putExtra2.putExtras(bundle);
        return putExtra2;
    }

    public static void D(TradeType tradeType) {
        f83752b = tradeType;
    }

    public static void E(TradeType tradeType) {
        f83751a = tradeType;
    }

    public static void F(TradeType tradeType) {
        f83754d = tradeType;
        if (tradeType != null) {
            ConfigPreferences.m("user_config", "config_trade_select_margin", tradeType.toString());
        }
    }

    public static void G(String str) {
        f83755e = str;
    }

    public static void H(TradeType tradeType) {
        f83753c = tradeType;
    }

    public static void I(Context context) {
        J(context, "", true);
    }

    public static void J(Context context, String str, boolean z11) {
        context.startActivity(C(context, str, z11));
    }

    public static void K(Context context, String str) {
        Intent A = A(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        A.putExtras(bundle);
        context.startActivity(A);
    }

    public static void L(Context context) {
        M("", "0", true, context);
    }

    public static void M(String str, String str2, boolean z11, Context context) {
        Intent intent;
        if (d.n().G()) {
            if (str2 == null || !str2.equals("1")) {
                intent = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.margin").putExtra("trade_driection", z11);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("symbolId", StringUtils.g(str));
                    i2.a().h(TradeType.MARGIN, str);
                }
                G("pro.huobi.margin");
                TradeType tradeType = TradeType.MARGIN;
                H(tradeType);
                F(tradeType);
                Bundle bundle = new Bundle();
                bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
                bundle.putString("key_trade_type", tradeType.name());
                j.b(intent.getBooleanExtra("change_trend_to_default", false));
                com.huobi.trade.helper.d.d(tradeType, intent.getBooleanExtra("trade_driection", z11));
                b.c().g(0);
                intent.putExtras(bundle);
            } else {
                intent = new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.margin").putExtra("trade_driection", z11);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("symbolId", str);
                }
            }
            context.startActivity(intent);
        }
    }

    public static void N(String str, boolean z11, Context context, boolean z12) {
        if (d.n().G()) {
            TradeType tradeType = z12 ? TradeType.SUPERMARGIN : TradeType.MARGIN;
            String str2 = z12 ? "pro.huobi.supermargin" : "pro.huobi.margin";
            Intent putExtra = new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", str2).putExtra("trade_driection", z11);
            if (!TextUtils.isEmpty(str)) {
                putExtra.putExtra("symbolId", str);
                i2.a().h(tradeType, str);
            }
            G(str2);
            H(tradeType);
            F(tradeType);
            Bundle bundle = new Bundle();
            bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
            bundle.putString("key_trade_type", tradeType.name());
            j.b(putExtra.getBooleanExtra("change_trend_to_default", false));
            com.huobi.trade.helper.d.d(tradeType, putExtra.getBooleanExtra("trade_driection", z11));
            b.c().g(z12 ? 1 : 0);
            putExtra.putExtras(bundle);
            context.startActivity(putExtra);
        }
    }

    public static void O(Context context, String str, boolean z11) {
        Intent s11 = s(context, str, z11);
        s11.setClass(context, TradeContainerActivity.class);
        G("pro.huobi.pro");
        TradeType tradeType = TradeType.PRO;
        H(tradeType);
        if (!TextUtils.isEmpty(str)) {
            s11.putExtra("symbolId", str);
            i2.a().h(tradeType, str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        s11.putExtras(bundle);
        com.huobi.trade.helper.d.d(tradeType, z11);
        i.d(tradeType, z11);
        context.startActivity(s11);
    }

    public static void P(Context context, String str, boolean z11) {
        Intent putExtra = new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.pro").putExtra("trade_driection", z11);
        f83756f = true;
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra("symbolId", str);
        }
        context.startActivity(putExtra);
    }

    public static void Q(Context context) {
        R("", "0", true, context);
    }

    public static void R(String str, String str2, boolean z11, Context context) {
        Intent intent;
        if (str2 == null || !str2.equals("1")) {
            intent = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.supermargin").putExtra("trade_driection", z11);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("symbolId", str);
                i2.a().h(TradeType.SUPERMARGIN, str);
            }
            G("pro.huobi.supermargin");
            TradeType tradeType = TradeType.SUPERMARGIN;
            H(tradeType);
            F(tradeType);
            Bundle bundle = new Bundle();
            bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
            bundle.putString("key_trade_type", tradeType.name());
            j.b(intent.getBooleanExtra("change_trend_to_default", false));
            com.huobi.trade.helper.d.d(tradeType, intent.getBooleanExtra("trade_driection", z11));
            b.c().g(1);
            intent.putExtras(bundle);
        } else {
            intent = new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.supermargin").putExtra("trade_driection", z11);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("symbolId", str);
            }
        }
        context.startActivity(intent);
    }

    public static void S(Context context, String str, boolean z11, TradeType tradeType) {
        if (tradeType == TradeType.PRO) {
            O(context, str, z11);
        } else if (tradeType == TradeType.MARGIN) {
            M(str, "0", z11, context);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            R(str, "0", z11, context);
        } else if (tradeType == TradeType.C2C) {
            J(context, str, z11);
        }
    }

    public static Intent a(Context context) {
        if (HomeHelper.j()) {
            return h(context);
        }
        return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.account");
    }

    public static Intent b(Context context) {
        return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.account");
    }

    public static Intent c(Context context) {
        return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.balance");
    }

    public static Intent d(Context context, boolean z11) {
        if (!d.n().E()) {
            return new Intent();
        }
        if (z11) {
            return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.contract");
        }
        Intent putExtra = new Intent(context, FutureTradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.contract");
        G("pro.huobi.contract");
        TradeType tradeType = TradeType.CONTRACT;
        E(tradeType);
        D(tradeType);
        Bundle bundle = new Bundle();
        bundle.putString("FutureTradeContainerActivity", FutureTradeFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static TradeType e() {
        return f83752b;
    }

    public static String f() {
        TradeType tradeType = f83751a;
        if (tradeType == null) {
            TradeType j11 = ContractUserInfoProvider.i().j();
            if (j11 == TradeType.CONTRACT) {
                return "pro.huobi.contract";
            }
            if (j11 == TradeType.SWAP) {
                return "pro.huobi.swap";
            }
            if (j11 == TradeType.OPTION) {
                return "pro.huobi.option";
            }
            return j11 == TradeType.LINEAR_SWAP ? "pro.huobi.linearswap" : "pro.huobi.contract";
        } else if (tradeType == TradeType.CONTRACT) {
            return "pro.huobi.contract";
        } else {
            if (f83751a == TradeType.SWAP) {
                return "pro.huobi.swap";
            }
            if (f83751a == TradeType.OPTION) {
                return "pro.huobi.option";
            }
            return f83751a == TradeType.LINEAR_SWAP ? "pro.huobi.linearswap" : "pro.huobi.contract";
        }
    }

    public static TradeType g() {
        return f83751a;
    }

    public static Intent h(Context context) {
        return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.home");
    }

    public static Intent i(Context context, boolean z11) {
        if (z11) {
            return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.linearswap");
        }
        Intent putExtra = new Intent(context, FutureTradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.linearswap");
        G("pro.huobi.linearswap");
        E(TradeType.LINEAR_SWAP);
        Bundle bundle = new Bundle();
        bundle.putString("FutureTradeContainerActivity", FutureTradeFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent j(Context context, boolean z11) {
        if (z11) {
            return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.margin");
        }
        Intent putExtra = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.margin");
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static TradeType k() {
        if (f83754d == null) {
            String d11 = ConfigPreferences.d("user_config", "config_trade_select_margin");
            if (!TextUtils.isEmpty(d11)) {
                f83754d = TradeType.valueOf(d11);
            }
        }
        return f83754d;
    }

    public static Intent l(Context context) {
        Intent putExtra = new Intent(context, MarketContainerActivity.class).putExtra("navigator_action", "pro.huobi.markets");
        Bundle bundle = new Bundle();
        bundle.putString("class_name", HomeMarketNewFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent m(Context context, int i11) {
        Intent putExtra = new Intent(context, MarketContainerActivity.class).putExtra("navigator_action", "pro.huobi.markets").putExtra("child_action", i11);
        Bundle bundle = new Bundle();
        bundle.putString("class_name", HomeMarketNewFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent n(Context context) {
        return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.markets");
    }

    public static Intent o(Context context) {
        Intent putExtra = new Intent(context, FutureTradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.option");
        Bundle bundle = new Bundle();
        bundle.putString("FutureTradeContainerActivity", FutureTradeFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent p(Context context) {
        return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.otc");
    }

    public static Intent q(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, OtcTradePayingAndSuccessActivity.class);
        return intent;
    }

    public static String r() {
        return f83755e;
    }

    public static Intent s(Context context, String str, boolean z11) {
        Intent putExtra = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.pro").putExtra("trade_driection", z11);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra("symbolId", str);
            i2.a().h(TradeType.PRO, str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        bundle.putString("key_trade_type", TradeType.PRO.name());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent t(Context context, boolean z11) {
        if (z11) {
            return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.pro");
        }
        Intent putExtra = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.pro");
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent u(Context context, boolean z11) {
        if (z11) {
            return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.supermargin");
        }
        Intent putExtra = new Intent(context, TradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.supermargin");
        G("pro.huobi.supermargin");
        TradeType tradeType = TradeType.SUPERMARGIN;
        H(tradeType);
        F(tradeType);
        z(tradeType);
        Bundle bundle = new Bundle();
        bundle.putString("TradeContainerActivity", TradeFragment.class.getName());
        bundle.putString("key_trade_type", tradeType.name());
        j.b(putExtra.getBooleanExtra("change_trend_to_default", false));
        com.huobi.trade.helper.d.d(tradeType, putExtra.getBooleanExtra("trade_driection", true));
        b.c().g(1);
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static Intent v(Context context, boolean z11) {
        if (z11) {
            return new Intent(context, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.swap");
        }
        Intent putExtra = new Intent(context, FutureTradeContainerActivity.class).putExtra("navigator_action", "pro.huobi.swap");
        G("pro.huobi.swap");
        TradeType tradeType = TradeType.SWAP;
        E(tradeType);
        D(tradeType);
        Bundle bundle = new Bundle();
        bundle.putString("FutureTradeContainerActivity", FutureTradeFragment.class.getName());
        putExtra.putExtras(bundle);
        return putExtra;
    }

    public static String w() {
        TradeType tradeType = f83753c;
        if (tradeType == null) {
            TradeType c11 = i2.a().c();
            if (c11 == TradeType.MARGIN) {
                return "pro.huobi.margin";
            }
            return c11 == TradeType.SUPERMARGIN ? "pro.huobi.supermargin" : "pro.huobi.pro";
        } else if (tradeType == TradeType.PRO) {
            return "pro.huobi.pro";
        } else {
            if (f83753c == TradeType.MARGIN) {
                return "pro.huobi.margin";
            }
            if (f83753c == TradeType.SUPERMARGIN) {
                return "pro.huobi.supermargin";
            }
            if (f83753c == TradeType.C2C) {
                return "pro.huobi.c2c";
            }
            return f83753c == TradeType.C2C_LEND ? "pro.huobi.c2clend" : "pro.huobi.contract";
        }
    }

    public static TradeType x() {
        return f83753c;
    }

    public static void y(Activity activity, Intent intent, Intent intent2) {
        if (r.x().F0()) {
            activity.startActivity(intent);
            return;
        }
        c.i().d(activity, new JumpTarget(intent, intent2));
    }

    public static void z(TradeType tradeType) {
        String d11 = i2.a().d(tradeType);
        if (TextUtils.isEmpty(d11)) {
            List<SymbolBean> Z = a1.v().Z(tradeType);
            d11 = (Z == null || Z.isEmpty()) ? "" : Z.get(0).getSymbol();
        }
        i2.a().h(tradeType, d11);
    }
}
