package com.huobi.trade.helper;

import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.MarginTogetherMgtBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import i6.m;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static MarginTogetherMgtBean f82089a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f82090b;

    public static boolean a() {
        return ConfigPreferences.b("user_config", "config_trade_margin_lever");
    }

    public static boolean b() {
        return false;
    }

    public static void c() {
        int i11;
        try {
            f82089a = (MarginTogetherMgtBean) AppConfigManager.c(MgtConfigNumber.MARGIN_TOGETHER.number, MarginTogetherMgtBean.class);
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            boolean z11 = true;
            if (TextUtils.isEmpty(e11)) {
                if (f82089a.getExvalue() != 1) {
                    z11 = false;
                }
                f82090b = z11;
                return;
            }
            if (e11.length() > 2) {
                i11 = m.k0(e11.substring(e11.length() - 2));
            } else {
                i11 = m.k0(e11);
            }
            if (i11 >= f82089a.getUserIdFirNum() && i11 <= f82089a.getUserIdSecNum()) {
                f82090b = true;
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public static void d(boolean z11) {
        ConfigPreferences.n("user_config", "config_trade_margin_lever", z11);
    }
}
