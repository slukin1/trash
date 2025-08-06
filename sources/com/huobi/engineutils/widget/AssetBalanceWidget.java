package com.huobi.engineutils.widget;

import android.content.Context;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.l;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.NumAnimTextView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.template.widget.Widget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.Map;
import jk.d;
import jk.e;
import jk.f;
import jk.g;
import jk.h;
import jk.i;
import jk.j;
import jk.k;
import qh.p0;
import rj.n;

public class AssetBalanceWidget extends Widget {
    public int A0;
    public int B0;
    public String C0;
    public String D0;
    public View E0;

    /* renamed from: h0  reason: collision with root package name */
    public int f44546h0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f44547i0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f44548j0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f44549k0;

    /* renamed from: l0  reason: collision with root package name */
    public int f44550l0;

    /* renamed from: m0  reason: collision with root package name */
    public int f44551m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44552n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f44553o0;

    /* renamed from: p0  reason: collision with root package name */
    public String f44554p0;

    /* renamed from: q0  reason: collision with root package name */
    public int f44555q0;

    /* renamed from: r0  reason: collision with root package name */
    public String f44556r0;

    /* renamed from: s0  reason: collision with root package name */
    public String f44557s0;

    /* renamed from: t0  reason: collision with root package name */
    public String f44558t0;

    /* renamed from: u0  reason: collision with root package name */
    public View f44559u0;

    /* renamed from: v0  reason: collision with root package name */
    public NumAnimTextView f44560v0;

    /* renamed from: w0  reason: collision with root package name */
    public TextView f44561w0;

    /* renamed from: x0  reason: collision with root package name */
    public int f44562x0;

    /* renamed from: y0  reason: collision with root package name */
    public int f44563y0;

    /* renamed from: z0  reason: collision with root package name */
    public int f44564z0;

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(Object obj) {
        if (p0.n().k().displayGuideDot()) {
            this.E0.setVisibility(0);
            p0.n().F(this.f44561w0);
            return;
        }
        this.E0.setVisibility(8);
    }

    public static /* synthetic */ String h0(String str) {
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Context context, String str) {
        try {
            this.f44560v0.setTextColor(context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName())));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(String str) {
        String str2 = this.C0;
        this.C0 = str;
        f0();
        if (m.a0(str)) {
            this.f44560v0.setNumber(str);
            if (m.a0(str2)) {
                this.f44560v0.j();
                return;
            }
            return;
        }
        this.f44560v0.g();
        this.f44560v0.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(String str) {
        this.D0 = str;
        f0();
        this.f44561w0.setText(str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l0(n nVar, View view) {
        z(this.f44556r0, nVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m0(n nVar, View view) {
        z(this.f44557s0, nVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(n nVar, String str) {
        if ("1".equals(str)) {
            this.f44559u0.setOnClickListener(new d(this, nVar));
        } else {
            this.f44559u0.setOnClickListener(new e(this, nVar));
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        String str = map.get("width");
        if ("match_parent".equals(str)) {
            this.f44546h0 = -1;
        } else if ("wrap_content".equals(str)) {
            this.f44546h0 = -2;
        } else {
            try {
                this.f44546h0 = A(context, Float.parseFloat(str));
            } catch (Exception unused) {
            }
        }
        this.f44547i0 = "true".equals(map.get("isAnimation"));
        this.f44548j0 = "true".equals(map.get("isStartFiat"));
        this.f44549k0 = "true".equals(map.get("isDiffNumber"));
        try {
            this.f44551m0 = A(context, (float) Integer.parseInt(map.get("decimalTextSize")));
        } catch (Exception unused2) {
        }
        try {
            this.f44550l0 = A(context, (float) Integer.parseInt(map.get("integerTextSize")));
        } catch (Exception unused3) {
        }
        try {
            this.f44555q0 = A(context, (float) Integer.parseInt(map.get("rightTextSize")));
        } catch (Exception unused4) {
        }
        this.f44552n0 = map.get("textColor");
        this.f44553o0 = map.get("text");
        this.f44554p0 = map.get("rightText");
        this.f44556r0 = map.get("analysisEvent");
        this.f44557s0 = map.get("analysisOpenEvent");
        this.f44558t0 = map.get("isAnalysisOpen");
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        w(context, this.f44553o0, new h(this), nVar);
        w(context, this.f44554p0, new g(this), nVar);
        w(context, this.f44558t0, new j(this, nVar), nVar);
        return Q;
    }

    public final void f0() {
        this.f44561w0.setTextSize(0, (float) this.f44555q0);
        this.f44560v0.setTextSize(0, (float) this.f44550l0);
        TextPaint paint = this.f44560v0.getPaint();
        TextPaint paint2 = this.f44561w0.getPaint();
        TextPaint textPaint = new TextPaint(paint);
        TextPaint textPaint2 = new TextPaint(paint2);
        int i11 = this.f44550l0;
        int i12 = this.f44555q0;
        textPaint.setTextSize((float) i11);
        textPaint2.setTextSize((float) i12);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(LegalCurrencyConfigUtil.x());
        String str = this.C0;
        sb2.append(m.c(str, str));
        String sb3 = sb2.toString();
        String str2 = TextUtils.isEmpty(this.D0) ? "" : this.D0;
        l.k(this.f44560v0, 0);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f44561w0.setAutoSizeTextTypeWithDefaults(0);
        } else {
            l.k(this.f44561w0, 0);
        }
        this.f44560v0.getLayoutParams().width = -2;
        this.f44561w0.getLayoutParams().width = -2;
        while (textPaint.measureText(sb3) + textPaint2.measureText(str2) + ((float) this.f44562x0) > ((float) this.f44546h0)) {
            int i13 = this.f44563y0;
            if (i11 > i13 || i12 > i13) {
                if (i11 > i13) {
                    i11--;
                    this.f44560v0.setTextSize(0, (float) i11);
                    textPaint.set(this.f44560v0.getPaint());
                }
                if (i12 > this.f44563y0) {
                    i12--;
                    this.f44561w0.setTextSize(0, (float) i12);
                    textPaint2.set(this.f44561w0.getPaint());
                }
            } else {
                this.f44560v0.getLayoutParams().width = this.f44564z0;
                this.f44559u0.getLayoutParams().width = this.A0;
                this.f44561w0.getLayoutParams().width = this.B0;
                this.f44561w0.setTextSize(0, (float) this.f44555q0);
                this.f44560v0.setTextSize(0, (float) this.f44550l0);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f44561w0.setAutoSizeTextTypeUniformWithConfiguration(this.f44563y0, this.f44555q0, 1, 0);
                } else {
                    l.j(this.f44561w0, this.f44563y0, this.f44555q0, 1, 0);
                }
                l.j(this.f44560v0, this.f44563y0, this.f44550l0, 1, 0);
                return;
            }
        }
    }

    public View q(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.widget_asset_balance, (ViewGroup) null);
        this.f44560v0 = (NumAnimTextView) inflate.findViewById(R$id.widget_balance_view);
        this.f44561w0 = (TextView) inflate.findViewById(R$id.widget_tv_right);
        this.f44559u0 = inflate.findViewById(R$id.widget_ll_analysis);
        this.f44560v0.setTextSize(0, (float) this.f44550l0);
        this.f44561w0.setTextSize(0, (float) this.f44555q0);
        this.E0 = inflate.findViewById(R$id.v_profit_analysis_dot);
        this.f44152d0.v("pageAppear", new k(this));
        this.f44562x0 = PixelUtils.a(34.0f);
        this.f44563y0 = A(context, 8.0f);
        this.f44564z0 = A(context, 183.0f);
        this.A0 = A(context, 103.0f);
        this.B0 = A(context, 78.0f);
        this.f44560v0.setCallback(f.f55967a);
        u(this.f44552n0, new i(this, context));
        return inflate;
    }
}
