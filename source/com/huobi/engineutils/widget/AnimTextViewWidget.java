package com.huobi.engineutils.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.widgets.NumAnimTextView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.edgeengine.template.widget.Widget;
import i6.m;
import java.util.Map;
import jk.a;
import jk.b;
import jk.c;
import rj.n;

public class AnimTextViewWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public int f44541h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44542i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44543j0;

    /* renamed from: k0  reason: collision with root package name */
    public NumAnimTextView f44544k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44545l0;

    public static /* synthetic */ String a0(String str) {
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(Context context, String str) {
        try {
            this.f44544k0.setTextColor(context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName())));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(String str) {
        String str2 = this.f44545l0;
        this.f44545l0 = str;
        if (m.a0(str)) {
            this.f44544k0.setNumber(str);
            if (m.a0(str2)) {
                this.f44544k0.j();
                return;
            }
            return;
        }
        this.f44544k0.g();
        this.f44544k0.setText(str);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        try {
            this.f44541h0 = A(context, (float) Integer.parseInt(map.get("integerTextSize")));
            this.f44542i0 = map.get("textColor");
            this.f44543j0 = map.get("text");
        } catch (Exception unused) {
        }
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        w(context, this.f44543j0, new b(this), nVar);
        return Q;
    }

    public View q(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.widget_asset_balance_new, (ViewGroup) null);
        NumAnimTextView numAnimTextView = (NumAnimTextView) inflate.findViewById(R$id.widget_balance_view);
        this.f44544k0 = numAnimTextView;
        numAnimTextView.setTextSize(0, (float) this.f44541h0);
        this.f44544k0.setCallback(a.f55959a);
        u(this.f44542i0, new c(this, context));
        return inflate;
    }
}
