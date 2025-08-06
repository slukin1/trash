package com.hbg.lib.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.hbg.lib.core.R$color;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final int f68757a = R$color.color_down;

    /* renamed from: b  reason: collision with root package name */
    public static final int f68758b = R$color.color_rise;

    /* renamed from: c  reason: collision with root package name */
    public static final int f68759c = R$color.color_flat;

    /* renamed from: d  reason: collision with root package name */
    public static final int f68760d = R$color.color_down_0_3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f68761e = R$color.color_down_3_8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f68762f = R$color.color_down_above_8;

    /* renamed from: g  reason: collision with root package name */
    public static final int f68763g = R$color.color_rise_0_3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f68764h = R$color.color_rise_3_8;

    /* renamed from: i  reason: collision with root package name */
    public static final int f68765i = R$color.color_rise_above_8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f68766j = R$color.color_flat_0;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f68767k;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f68768l;

    /* renamed from: m  reason: collision with root package name */
    public static BigDecimal f68769m;

    /* renamed from: n  reason: collision with root package name */
    public static BigDecimal f68770n;

    public static int a(String str) {
        int i11;
        try {
            i11 = m.a(str).compareTo(BigDecimal.ZERO);
        } catch (Exception e11) {
            e11.printStackTrace();
            i11 = 0;
        }
        if (i11 > 0) {
            return h();
        }
        if (i11 < 0) {
            return d();
        }
        return e();
    }

    public static int b() {
        if (l()) {
            return R$color.kline_depth_green;
        }
        return R$color.kline_depth_red;
    }

    public static int c() {
        if (l()) {
            return R$color.kline_depth_red;
        }
        return R$color.kline_depth_green;
    }

    public static int d() {
        if (l()) {
            return f68758b;
        }
        return f68757a;
    }

    public static int e() {
        return f68759c;
    }

    public static int f() {
        if (l()) {
            return R$color.color_rise_not_support_trade;
        }
        return R$color.color_down_not_support_trade;
    }

    public static int g() {
        if (l()) {
            return R$color.color_down_not_support_trade;
        }
        return R$color.color_rise_not_support_trade;
    }

    public static int h() {
        if (l()) {
            return f68757a;
        }
        return f68758b;
    }

    public static int i(Context context, String str) {
        BigDecimal a11 = m.a(str);
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            if (l()) {
                return context.getColor(R$color.kline_handicap_background_red);
            }
            return context.getColor(R$color.kline_handicap_background_green);
        } else if (a11.compareTo(BigDecimal.ZERO) >= 0) {
            return context.getColor(R$color.baseColorInputBackground);
        } else {
            if (l()) {
                return context.getColor(R$color.kline_handicap_background_green);
            }
            return context.getColor(R$color.kline_handicap_background_red);
        }
    }

    public static int j(Context context, String str) {
        BigDecimal a11 = m.a(str);
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            if (l()) {
                return context.getColor(R$color.global_huobi_color);
            }
            return context.getColor(R$color.global_quotation_down_color);
        } else if (a11.compareTo(BigDecimal.ZERO) >= 0) {
            return context.getColor(R$color.global_default_text_color);
        } else {
            if (l()) {
                return context.getColor(R$color.global_quotation_down_color);
            }
            return context.getColor(R$color.global_huobi_color);
        }
    }

    public static int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return f68759c;
        }
        if (f68769m == null) {
            f68769m = new BigDecimal("3");
        }
        if (f68770n == null) {
            f68770n = new BigDecimal("8");
        }
        boolean z11 = true;
        boolean z12 = !str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        String replace = str.replace("+", "").replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").replace("%", "");
        if (!m.a0(replace)) {
            return f68759c;
        }
        if (m.a(replace).compareTo(BigDecimal.ZERO) != 0) {
            z11 = false;
        }
        if (z11) {
            return f68759c;
        }
        if (l()) {
            if (z12) {
                return f68757a;
            }
            return f68758b;
        } else if (z12) {
            return f68758b;
        } else {
            return f68757a;
        }
    }

    public static boolean l() {
        if (!f68768l) {
            f68768l = true;
            f68767k = ConfigPreferences.b("user_config", "RISE_FALL_COLOR_SETTING_KEY");
        }
        return f68767k;
    }

    public static void m(boolean z11) {
        f68767k = z11;
        ConfigPreferences.n("user_config", "RISE_FALL_COLOR_SETTING_KEY", z11);
    }

    public static void n(TextView textView, String str) {
        int i11;
        if (textView != null) {
            Resources resources = textView.getResources();
            int i12 = 0;
            try {
                i12 = m.a(str).compareTo(BigDecimal.ZERO);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (i12 > 0) {
                i11 = h();
            } else if (i12 < 0) {
                i11 = d();
            } else {
                i11 = e();
            }
            textView.setTextColor(resources.getColor(i11));
        }
    }
}
