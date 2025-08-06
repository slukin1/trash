package al;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bc.a;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import d7.a1;

public final class k {
    public static void a(Context context, String str) {
        String t11 = a1.v().t(str);
        if (TextUtils.isEmpty(t11)) {
            HuobiToastUtil.k(context, R$string.n_not_support);
        } else if ((context instanceof Activity) && !TextUtils.isEmpty(t11)) {
            AssetModuleConfig.a().e(context, t11, false, TradeType.PRO);
        }
    }

    public static void b(Context context, String str) {
        String t11 = a1.v().t(str);
        if (TextUtils.isEmpty(t11)) {
            HuobiToastUtil.k(context, R$string.n_not_support);
            return;
        }
        SymbolBean J = a1.v().J(t11, TradeType.PRO);
        if (J != null && AssetModuleConfig.a().z0(t11, J.getSymbolPartition(), J.getState())) {
            AssetModuleConfig.a().e0(context, t11);
        } else {
            AssetModuleConfig.a().D(context, t11, true);
        }
    }

    public static void c(Context context, String str) {
        String t11 = a1.v().t(str);
        if (TextUtils.isEmpty(t11)) {
            HuobiToastUtil.k(context, R$string.n_not_support);
            return;
        }
        SymbolBean J = a1.v().J(t11, TradeType.PRO);
        if (!(J != null && AssetModuleConfig.a().z0(t11, J.getSymbolPartition(), J.getState()))) {
            AssetModuleConfig.a().P0(context, t11, true);
        } else {
            AssetModuleConfig.a().H(context, t11, true);
        }
    }

    public static void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            HuobiToastUtil.k(context, R$string.n_not_support);
        } else if (str.equals("usdt")) {
            a a11 = AssetModuleConfig.a();
            a11.P0(context, "btc" + str, true);
        } else {
            a a12 = AssetModuleConfig.a();
            a12.H(context, str + "usdt", true);
        }
    }

    public static void e(Context context, String str) {
        String t11 = a1.v().t(str);
        if (TextUtils.isEmpty(t11)) {
            HuobiToastUtil.k(context, R$string.n_not_support);
            return;
        }
        SymbolBean J = a1.v().J(t11, TradeType.PRO);
        if (!(J != null && AssetModuleConfig.a().z0(t11, J.getSymbolPartition(), J.getState()))) {
            AssetModuleConfig.a().P0(context, t11, true);
        } else {
            AssetModuleConfig.a().m0(context, t11, true, 1);
        }
    }
}
