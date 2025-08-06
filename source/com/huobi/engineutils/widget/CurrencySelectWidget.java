package com.huobi.engineutils.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.template.widget.b;
import com.huobi.view.BaseBottomCurrencyDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import jk.o;
import jk.p;
import jk.q;
import rj.n;
import vh.x;

public class CurrencySelectWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f44583h0;

    /* renamed from: i0  reason: collision with root package name */
    public TextView f44584i0;

    /* renamed from: j0  reason: collision with root package name */
    public BaseBottomCurrencyDialogFragment f44585j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44586k0;

    public class a extends b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            ((TextView) view).setText(str);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void a0(View view) {
        d0(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(View view, x xVar, String str) {
        if (TextUtils.equals(str, view.getContext().getString(R$string.n_home_index_earn_more))) {
            e0(view.getContext());
        } else {
            if ("usdt".equals(str) || "btc".equals(str)) {
                LegalCurrencyConfigUtil.d0(str);
            } else {
                LegalCurrencyConfigUtil.c0(str);
            }
            z(this.f44586k0, this.f44154e0);
            f0(str);
        }
        xVar.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(String str) {
        z(this.f44586k0, this.f44154e0);
        gi.a.i(LegalCurrencyConfigUtil.O(str).toUpperCase(Locale.US));
        f0(str);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44583h0 = map.get("text");
        this.f44586k0 = map.get("currencyChange");
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        w(context, this.f44583h0, new a(this.f44584i0), nVar);
        return Q;
    }

    public final void d0(View view) {
        x xVar = new x(view.getContext());
        xVar.l(new q(this, view, xVar));
        xVar.n(view);
        gi.a.m();
    }

    public final void e0(Context context) {
        BaseBottomCurrencyDialogFragment J = AssetModuleConfig.a().J();
        this.f44585j0 = J;
        if (context != null && (context instanceof FragmentActivity)) {
            J.setOnCurrencyMethodChangeCallback(new p(this));
            this.f44585j0.show(((FragmentActivity) context).getSupportFragmentManager(), this.f44585j0.getClass().getName());
            gi.a.p();
        }
    }

    public final void f0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("coin", LegalCurrencyConfigUtil.O(str).toUpperCase(Locale.US));
        BaseModuleConfig.a().w("app_assets_switch_currency_entrance_click", hashMap);
    }

    public View q(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.currency_select, (ViewGroup) null);
        this.f44584i0 = (TextView) inflate.findViewById(R$id.iv_account_currency_method_text);
        inflate.setOnClickListener(new o(this));
        return inflate;
    }
}
