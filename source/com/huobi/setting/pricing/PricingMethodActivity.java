package com.huobi.setting.pricing;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.network.hbg.core.bean.PricingMethodBean;
import com.hbg.lib.router.HbgRouter;
import com.huobi.app.AbstractCommonListActivity;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.litere.helper.LiteReHelper;
import ir.a;
import java.util.List;
import pro.huobi.R;

@Route(path = "/app/price_method")
public class PricingMethodActivity extends AbstractCommonListActivity implements a.C0869a {

    /* renamed from: g  reason: collision with root package name */
    public String f80802g;

    public static void Hh(Context context) {
        HbgRouter.h(context, "/app/price_method");
    }

    public void Bh() {
    }

    public void Ch() {
    }

    public Object G9(String str) {
        return LegalCurrencyConfigUtil.q(this, str);
    }

    public String Qg() {
        return null;
    }

    public boolean Vg(String str) {
        return TextUtils.equals(str, this.f80802g);
    }

    public void j(String str) {
        this.f80802g = str;
        LegalCurrencyConfigUtil.c0(str);
        LegalCurrencyConfigUtil.f0(false);
        Eh();
    }

    public String nc(String str) {
        return LegalCurrencyConfigUtil.r(str, false) + " " + LegalCurrencyConfigUtil.t(getApplicationContext(), str);
    }

    public String oh() {
        return getString(R.string.setting_pricing_method);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f80802g = LegalCurrencyConfigUtil.y();
    }

    public List<s9.a> qh(List<s9.a> list) {
        for (PricingMethodBean next : LegalCurrencyConfigUtil.f43758b) {
            if (!"krw".equals(next.getAbbr()) || !LiteReHelper.a().b()) {
                list.add(new a(next.getAbbr(), this));
            }
        }
        return list;
    }

    public boolean th() {
        return false;
    }

    public boolean uh() {
        return false;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
