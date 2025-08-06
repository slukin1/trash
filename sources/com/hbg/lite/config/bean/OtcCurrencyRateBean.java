package com.hbg.lite.config.bean;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.CurrencyRateBean;

public class OtcCurrencyRateBean {

    /* renamed from: a  reason: collision with root package name */
    public CurrencyRateBean f77065a;

    /* renamed from: b  reason: collision with root package name */
    public String f77066b;

    /* renamed from: c  reason: collision with root package name */
    public String f77067c;

    public boolean a(Object obj) {
        return obj instanceof OtcCurrencyRateBean;
    }

    public String b() {
        return this.f77067c;
    }

    public CurrencyRateBean c() {
        return this.f77065a;
    }

    public String d() {
        return this.f77066b;
    }

    public void e() {
        try {
            String name = c().getName();
            if (!TextUtils.isEmpty(name) && name.contains("_")) {
                String[] split = name.split("_");
                k(split[0]);
                i(split[1]);
            }
        } catch (Exception unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCurrencyRateBean)) {
            return false;
        }
        OtcCurrencyRateBean otcCurrencyRateBean = (OtcCurrencyRateBean) obj;
        if (!otcCurrencyRateBean.a(this)) {
            return false;
        }
        CurrencyRateBean c11 = c();
        CurrencyRateBean c12 = otcCurrencyRateBean.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = otcCurrencyRateBean.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String b11 = b();
        String b12 = otcCurrencyRateBean.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public boolean f() {
        return "usd".equals(this.f77066b) && "cny".equals(this.f77067c);
    }

    public boolean g() {
        return "usd".equals(this.f77066b);
    }

    public boolean h() {
        return "usdt".equals(this.f77066b) && "cny".equals(this.f77067c);
    }

    public int hashCode() {
        CurrencyRateBean c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        String d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String b11 = b();
        int i12 = hashCode2 * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return i12 + i11;
    }

    public void i(String str) {
        this.f77067c = str;
    }

    public void j(CurrencyRateBean currencyRateBean) {
        this.f77065a = currencyRateBean;
    }

    public void k(String str) {
        this.f77066b = str;
    }

    public String toString() {
        return "OtcCurrencyRateBean(currencyRateBean=" + c() + ", pre=" + d() + ", after=" + b() + ")";
    }
}
