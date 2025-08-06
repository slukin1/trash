package com.huobi.feature.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import pro.huobi.R;

public class FutureEarnestMoneyUtils {

    /* renamed from: a  reason: collision with root package name */
    public Context f45065a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f45066b = "0";

    /* renamed from: c  reason: collision with root package name */
    public String f45067c = "0";

    /* renamed from: d  reason: collision with root package name */
    public String f45068d = "0";

    /* renamed from: e  reason: collision with root package name */
    public int f45069e = 4;

    /* renamed from: f  reason: collision with root package name */
    public String f45070f = "";

    /* renamed from: g  reason: collision with root package name */
    public TradeType f45071g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f45072h = "0";

    /* renamed from: i  reason: collision with root package name */
    public String f45073i = "0";

    /* renamed from: j  reason: collision with root package name */
    public String f45074j = "0";

    /* renamed from: k  reason: collision with root package name */
    public String f45075k = "0";

    /* renamed from: l  reason: collision with root package name */
    public boolean f45076l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f45077m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f45078n = true;

    /* renamed from: o  reason: collision with root package name */
    public boolean f45079o = false;

    public class ZeroErr extends Exception {
        public ZeroErr() {
        }

        public ZeroErr(String str) {
            super(str);
        }
    }

    public static String c(String str) {
        return BigDecimal.ZERO.setScale(FuturePrecisionUtil.g(str), 4).toPlainString();
    }

    public static FutureEarnestMoneyUtils f() {
        return new FutureEarnestMoneyUtils();
    }

    public String a(boolean z11, boolean z12) throws ZeroErr {
        String str;
        c(this.f45070f);
        if (z12) {
            this.f45078n = true;
        }
        String d11 = d();
        if (TextUtils.isEmpty(d11) || m.a(d11).compareTo(BigDecimal.ZERO) == 0) {
            throw new ZeroErr();
        }
        try {
            if (this.f45078n) {
                str = FutureUnitUtil.e(this.f45066b, d11, this.f45067c, this.f45071g, 32);
            } else {
                str = this.f45066b;
            }
            this.f45066b = str;
            if (z12) {
                this.f45066b = m.a(str).multiply(m.a(this.f45068d)).toPlainString();
            }
            this.f45066b = m.a(this.f45066b).setScale(0, 1).toPlainString();
            BigDecimal multiply = m.a(d11).multiply(m.a(this.f45068d));
            if (multiply.compareTo(BigDecimal.ZERO) > 0) {
                String plainString = m.a(this.f45066b).multiply(m.a(this.f45067c)).divide(multiply, this.f45069e, RoundingMode.UP).toPlainString();
                return plainString + this.f45070f;
            }
            throw new ZeroErr();
        } catch (Exception unused) {
            throw new ZeroErr();
        }
    }

    public String b(boolean z11, boolean z12) throws ZeroErr {
        c(this.f45070f);
        if (z12) {
            this.f45079o = true;
        }
        try {
            String d11 = d();
            if (TextUtils.isEmpty(d11) || m.a(d11).compareTo(BigDecimal.ZERO) == 0) {
                throw new ZeroErr();
            }
            if (this.f45079o) {
                if (z12) {
                    this.f45066b = m.a(this.f45066b).multiply(m.a(this.f45068d)).divide(m.a(this.f45067c).multiply(m.a(d11)), 0, 1).toPlainString();
                } else {
                    this.f45066b = m.a(this.f45066b).divide(m.a(this.f45067c).multiply(m.a(d11)), 0, 1).toPlainString();
                }
            } else if (this.f45078n) {
                this.f45066b = FutureUnitUtil.e(this.f45066b, d11, this.f45067c, this.f45071g, 0);
            }
            this.f45066b = m.a(this.f45066b).setScale(0, 1).toPlainString();
            if (m.a(this.f45068d).compareTo(BigDecimal.ZERO) != 0) {
                String plainString = m.a(this.f45066b).multiply(m.a(this.f45067c)).multiply(m.a(d11)).divide(m.a(this.f45068d), this.f45069e, RoundingMode.UP).toPlainString();
                return plainString + this.f45065a.getResources().getString(R.string.points_pack_usdt);
            }
            throw new ZeroErr();
        } catch (Exception unused) {
            throw new ZeroErr();
        }
    }

    public final String d() {
        if (this.f45077m || this.f45076l) {
            return this.f45073i;
        }
        return this.f45072h;
    }

    public final void e(String str) throws ZeroErr {
        if (StringUtils.p(str)) {
            throw new ZeroErr();
        }
    }

    public FutureEarnestMoneyUtils g(String str) {
        this.f45075k = str;
        return this;
    }

    public FutureEarnestMoneyUtils h(boolean z11) {
        this.f45078n = z11;
        return this;
    }

    public FutureEarnestMoneyUtils i(Context context) throws ZeroErr {
        this.f45065a = context;
        if (context != null) {
            return this;
        }
        throw new ZeroErr();
    }

    public FutureEarnestMoneyUtils j(String str) {
        this.f45072h = str;
        return this;
    }

    public FutureEarnestMoneyUtils k(String str) throws ZeroErr {
        this.f45067c = str;
        e(str);
        return this;
    }

    public FutureEarnestMoneyUtils l(String str) throws ZeroErr {
        this.f45068d = str;
        e(str);
        return this;
    }

    public FutureEarnestMoneyUtils m(String str) {
        this.f45073i = str;
        return this;
    }

    public FutureEarnestMoneyUtils n(boolean z11) {
        this.f45077m = z11;
        return this;
    }

    public FutureEarnestMoneyUtils o(int i11) throws ZeroErr {
        this.f45069e = i11;
        return this;
    }

    public FutureEarnestMoneyUtils p(String str) {
        this.f45074j = str;
        return this;
    }

    public FutureEarnestMoneyUtils q(View view) {
        this.f45076l = view.getVisibility() == 0 && view.isSelected();
        return this;
    }

    public FutureEarnestMoneyUtils r(TradeType tradeType) throws ZeroErr {
        this.f45071g = tradeType;
        if (tradeType != null) {
            return this;
        }
        throw new ZeroErr();
    }

    public FutureEarnestMoneyUtils s(boolean z11) {
        this.f45079o = z11;
        return this;
    }

    public FutureEarnestMoneyUtils t(String str) throws ZeroErr {
        this.f45066b = str;
        e(str);
        return this;
    }

    public FutureEarnestMoneyUtils u(String str) throws ZeroErr {
        this.f45070f = str;
        if (!StringUtils.p(str)) {
            return this;
        }
        throw new ZeroErr();
    }
}
