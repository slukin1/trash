package com.huobi.tradingbot.widget;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import bu.a;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.edgeengine.template.widget.Widget;
import i6.d;
import java.util.Map;
import rj.n;

public class DashLineWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f83638h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f83639i0 = PixelUtils.a(2.0f);

    /* renamed from: j0  reason: collision with root package name */
    public int f83640j0 = PixelUtils.a(2.0f);

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(Context context, DashLineView dashLineView, String str) {
        try {
            dashLineView.b(Math.max(1, A(context, Float.parseFloat(this.f44147b))), ContextCompat.getColor(context, context.getResources().getIdentifier(str, "color", context.getPackageName())), (float) this.f83639i0, (float) this.f83640j0);
        } catch (Throwable th2) {
            d.g(th2);
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f83638h0 = map.get("dashColor");
        try {
            this.f83639i0 = A(context, (float) Integer.parseInt(map.get("dashWidth")));
        } catch (Throwable unused) {
        }
        try {
            this.f83640j0 = A(context, (float) Integer.parseInt(map.get("dashGap")));
        } catch (Throwable unused2) {
        }
    }

    public View Q(Context context, n nVar) {
        DashLineView dashLineView = (DashLineView) super.Q(context, nVar);
        u(this.f83638h0, new a(this, context, dashLineView));
        return dashLineView;
    }

    /* renamed from: Y */
    public DashLineView q(Context context) {
        return new DashLineView(context);
    }
}
