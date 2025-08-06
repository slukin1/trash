package com.huobi.trade.bean;

import android.content.Context;
import android.text.TextUtils;
import com.huobi.margin.entity.MarginBalanceQueryData;
import pro.huobi.R;

public class TradeOrderType {
    public static String a(String str, String str2, Context context) {
        if (b(str2)) {
            if (e(str)) {
                return context.getString(R.string.order_system_buy_label);
            }
            return context.getString(R.string.order_buy_label);
        } else if (e(str)) {
            return context.getString(R.string.order_system_sell_label);
        } else {
            return context.getString(R.string.order_sell_label);
        }
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        if ("buy-limit".equals(str) || "buy-market".equals(str) || "buy-stop-limit".equals(str) || "buy-ioc".equals(str) || "buy-limit-maker".equals(str) || "buy-market-grid".equals(str) || "buy-limit-grid".equals(str) || str.contains("buy")) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        if ("buy-limit".equals(str) || "buy-stop-limit".equals(str) || "buy-ioc".equals(str) || "buy-limit-maker".equals(str) || "buy-limit-fok".equals(str) || "buy-stop-limit-fok".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean d(String str) {
        if (str == null) {
            return false;
        }
        if ("sell-limit".equals(str) || "sell-stop-limit".equals(str) || "sell-ioc".equals(str) || "sell-limit-maker".equals(str) || "sell-limit-fok".equals(str) || "sell-stop-limit-fok".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && (str.contains(MarginBalanceQueryData.STATE_FL_MGT) || str.contains(MarginBalanceQueryData.STATE_FL_SYS));
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        return "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok".contains(str);
    }
}
