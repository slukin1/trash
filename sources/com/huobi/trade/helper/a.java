package com.huobi.trade.helper;

import android.content.Context;
import com.hbg.lib.margin.R$color;
import com.hbg.lib.margin.R$drawable;
import com.hbg.lib.margin.R$string;
import com.huobi.margin.entity.MarginBalanceQueryData;
import i6.m;
import java.math.BigDecimal;

public final class a {
    public static String a(String str, String str2) {
        if ("working".equals(str2)) {
            BigDecimal a11 = m.a(str);
            if (a11.compareTo(new BigDecimal("2")) >= 0) {
                return "3";
            }
            if (a11.compareTo(new BigDecimal("2")) < 0 && a11.compareTo(new BigDecimal("1.4")) > 0) {
                return "2";
            }
            if (a11.compareTo(new BigDecimal("1.4")) <= 0) {
                a11.compareTo(new BigDecimal("1.1"));
            }
            return "1";
        } else if (MarginBalanceQueryData.STATE_FL_END.equals(str2) || MarginBalanceQueryData.STATE_FL_MGT.equals(str2) || MarginBalanceQueryData.STATE_FL_SYS.equals(str2)) {
            return "0";
        } else {
            if (MarginBalanceQueryData.STATE_FL_NEGATIVE_ACCOUNT.equals(str2)) {
                return "-1";
            }
            return "3";
        }
    }

    public static int b(String str) {
        if ("0".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("3".equals(str)) {
            return R$color.baseColorPrimaryText;
        }
        if ("2".equals(str)) {
            return R$color.baseColorPrimaryText;
        }
        if ("1".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("-1".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        return R$color.baseColorPrimaryText;
    }

    public static int c(String str) {
        return m.a(str).subtract(new BigDecimal("1.1")).divide(new BigDecimal("0.9"), 2, 3).multiply(new BigDecimal("100")).intValue();
    }

    public static int d(String str) {
        if ("0".equals(str)) {
            return R$drawable.trade_liquidation_high_rate_bar_bg;
        }
        if ("3".equals(str)) {
            return R$drawable.trade_margin_rate_bar_bg;
        }
        if ("2".equals(str)) {
            return R$drawable.trade_margin_rate_bar_bg;
        }
        if ("1".equals(str)) {
            return R$drawable.trade_liquidation_high_rate_bar_bg;
        }
        if ("-1".equals(str)) {
            return R$drawable.trade_liquidation_high_rate_bar_bg;
        }
        return R$drawable.trade_margin_rate_bar_bg;
    }

    public static int e(String str) {
        if ("0".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("3".equals(str)) {
            return R$color.baseColorPrimaryText;
        }
        if ("2".equals(str)) {
            return R$color.baseColorPrimaryText;
        }
        if ("1".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("-1".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        return R$color.baseColorPrimaryText;
    }

    public static int f(String str) {
        if ("0".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("3".equals(str)) {
            return R$color.baseColorSecondaryText;
        }
        if ("2".equals(str)) {
            return R$color.baseColorSecondaryText;
        }
        if ("1".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("-1".equals(str)) {
            return R$color.baseCoinDangerousTip;
        }
        return R$color.baseColorSecondaryText;
    }

    public static String g(String str, Context context) {
        if ("0".equals(str)) {
            return context.getString(R$string.risk_rate_liquidating);
        }
        if ("3".equals(str)) {
            return context.getString(R$string.margin_risk_safe);
        }
        if ("2".equals(str)) {
            return context.getString(R$string.margin_risk_rate_unsafe);
        }
        if ("1".equals(str)) {
            return context.getString(R$string.margin_risk_rate_high_risk);
        }
        if ("-1".equals(str)) {
            return context.getString(R$string.margin_risk_rate_negative);
        }
        return context.getString(R$string.margin_risk_safe);
    }

    public static int h(String str) {
        return m.a(str).subtract(new BigDecimal("1.1")).divide(new BigDecimal("0.9"), 2, 0).multiply(new BigDecimal("100")).intValue();
    }
}
