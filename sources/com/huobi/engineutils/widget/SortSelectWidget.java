package com.huobi.engineutils.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.l;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.template.widget.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.HashMap;
import jk.r;
import jk.s;
import jk.t;
import jk.u;
import rj.n;
import vh.z;
import vk.k;

public class SortSelectWidget extends Widget implements k.a {

    /* renamed from: h0  reason: collision with root package name */
    public int f44588h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44589i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44590j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44591k0;

    /* renamed from: l0  reason: collision with root package name */
    public TextView f44592l0;

    /* renamed from: m0  reason: collision with root package name */
    public ImageView f44593m0;

    /* renamed from: n0  reason: collision with root package name */
    public View f44594n0;

    /* renamed from: o0  reason: collision with root package name */
    public View f44595o0;

    /* renamed from: p0  reason: collision with root package name */
    public z f44596p0;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f44597q0 = true;

    /* renamed from: r0  reason: collision with root package name */
    public int f44598r0 = 0;

    /* renamed from: s0  reason: collision with root package name */
    public int f44599s0 = 1;

    /* renamed from: t0  reason: collision with root package name */
    public String f44600t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f44601u0;

    /* renamed from: v0  reason: collision with root package name */
    public int f44602v0;

    /* renamed from: w0  reason: collision with root package name */
    public int f44603w0 = 8;

    /* renamed from: x0  reason: collision with root package name */
    public JSONObject f44604x0 = new JSONObject();

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
    public /* synthetic */ void H(n nVar, View view) {
        boolean z11 = !this.f44597q0;
        this.f44597q0 = z11;
        this.f44604x0.put("sortSequence", (Object) Integer.valueOf(z11 ^ true ? 1 : 0));
        HashMap hashMap = new HashMap();
        if (this.f44597q0) {
            this.f44593m0.setImageResource(R$drawable.market_selected_down_light);
            hashMap.put("rank", "up");
        } else {
            this.f44593m0.setImageResource(R$drawable.market_selected_up_light);
            hashMap.put("rank", "down");
        }
        BaseModuleConfig.a().w("app_assets_spot_sort_arrow_click", hashMap);
        if (this.f44152d0 != null) {
            if ("1".equals(nVar.s("isBot"))) {
                this.f44152d0.I("sortBotEvent('" + this.f44604x0.toJSONString() + "')");
            } else {
                this.f44152d0.I("sortEvent('" + this.f44604x0.toJSONString() + "')");
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(Context context, String str) {
        try {
            this.f44592l0.setTextColor(ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName())));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d0(View view) {
        f0(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(View view, n nVar, String str) {
        if ("0".equals(str)) {
            this.f44594n0.setVisibility(8);
            this.f44595o0.setVisibility(0);
            this.f44592l0.setOnClickListener((View.OnClickListener) null);
            this.f44592l0.getLayoutParams().width = this.f44588h0 - PixelUtils.a(16.0f);
            return;
        }
        this.f44594n0.setVisibility(0);
        this.f44595o0.setVisibility(8);
        this.f44592l0.setOnClickListener(new r(this));
        this.f44592l0.getLayoutParams().width = this.f44588h0 - PixelUtils.a(30.0f);
        view.findViewById(R$id.fl_sort_icon_container).setOnClickListener(new s(this, nVar));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(1:2)(2:3|(1:5)(2:6|7))|8|10|11|12|13|(3:14|15|17)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x007d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C(android.content.Context r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r3 = this;
            super.C(r4, r5)
            java.lang.String r0 = "width"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "match_parent"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0017
            r0 = -1
            r3.f44588h0 = r0
            goto L_0x002d
        L_0x0017:
            java.lang.String r1 = "wrap_content"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0023
            r0 = -2
            r3.f44588h0 = r0
            goto L_0x002d
        L_0x0023:
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x002d }
            int r0 = r3.A(r4, r0)     // Catch:{ Exception -> 0x002d }
            r3.f44588h0 = r0     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            java.lang.String r0 = "text"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3.f44589i0 = r0
            java.lang.String r0 = "textColor"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3.f44590j0 = r0
            java.lang.String r0 = "showSelect"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3.f44591k0 = r0
            java.lang.String r0 = "autoSizeTextType"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3.f44600t0 = r0
            java.lang.String r0 = "textFontWeight"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "textSize"
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "autoSizeMinTextSize"
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0073 }
            r3.f44602v0 = r0     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            float r0 = java.lang.Float.parseFloat(r1)     // Catch:{ Exception -> 0x007d }
            int r0 = r3.A(r4, r0)     // Catch:{ Exception -> 0x007d }
            r3.f44601u0 = r0     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ Exception -> 0x0087 }
            int r4 = r3.A(r4, r5)     // Catch:{ Exception -> 0x0087 }
            r3.f44603w0 = r4     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.engineutils.widget.SortSelectWidget.C(android.content.Context, java.util.Map):void");
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        w(context, this.f44589i0, new a(this.f44592l0), nVar);
        w(context, this.f44591k0, new u(this, Q, nVar), nVar);
        return Q;
    }

    public void a(int i11) {
        this.f44598r0 = i11;
        this.f44599s0 = i11;
        this.f44604x0.put("type", (Object) Integer.valueOf(i11));
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIPoll.PLUGIN_POLL_OPTION_CONTENT, b0(i11));
        BaseModuleConfig.a().w("app_assets_spot_sort_click", hashMap);
        if (this.f44152d0 != null) {
            if ("1".equals(this.f44154e0.s("isBot"))) {
                rj.b bVar = this.f44152d0;
                bVar.I("sortBotEvent('" + this.f44604x0.toJSONString() + "')");
            } else {
                rj.b bVar2 = this.f44152d0;
                bVar2.I("sortEvent('" + this.f44604x0.toJSONString() + "')");
            }
        }
        z zVar = this.f44596p0;
        if (zVar != null) {
            zVar.dismiss();
        }
    }

    public final Object b0(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? "funds" : "PL_rate" : "PL" : "funds";
    }

    public final void f0(View view) {
        this.f44596p0 = new z(view.getContext());
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        arrayList.add(new k(this.f44599s0 == 1, view.getContext().getResources().getString(R$string.n_asset_count_equivalent_sort), 1, this));
        arrayList.add(new k(this.f44599s0 == 2, view.getContext().getResources().getString(R$string.n_asset_profit_sort), 2, this));
        if (this.f44599s0 == 3) {
            z11 = true;
        }
        arrayList.add(new k(z11, view.getContext().getResources().getString(R$string.n_asset_Yield_sort), 3, this));
        this.f44596p0.h(arrayList);
        this.f44596p0.i(view);
    }

    public View q(Context context) {
        this.f44604x0.put("type", (Object) Integer.valueOf(this.f44598r0));
        this.f44604x0.put("sortSequence", (Object) Integer.valueOf(this.f44597q0 ^ true ? 1 : 0));
        View inflate = LayoutInflater.from(context).inflate(R$layout.sort_select, (ViewGroup) null);
        this.f44592l0 = (TextView) inflate.findViewById(R$id.tv_sort_title);
        if ("uniform".equals(this.f44600t0)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f44592l0.setAutoSizeTextTypeUniformWithConfiguration(this.f44603w0, this.f44601u0, 1, 0);
            } else {
                l.j(this.f44592l0, this.f44603w0, this.f44601u0, 1, 0);
            }
        }
        int i11 = this.f44602v0;
        if (i11 > -1 && i11 != 0) {
            Typeface typeface = this.f44592l0.getTypeface();
            if (Build.VERSION.SDK_INT >= 28) {
                this.f44592l0.setTypeface(Typeface.create(typeface, this.f44602v0, false));
            }
        }
        this.f44592l0.getLayoutParams().width = this.f44588h0 - PixelUtils.a(30.0f);
        this.f44593m0 = (ImageView) inflate.findViewById(R$id.iv_sort_icon);
        this.f44594n0 = inflate.findViewById(R$id.fl_sort_icon_container);
        this.f44595o0 = inflate.findViewById(R$id.fl_sort_place_holder);
        u(this.f44590j0, new t(this, context));
        return inflate;
    }
}
