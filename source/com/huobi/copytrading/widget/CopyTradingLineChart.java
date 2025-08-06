package com.huobi.copytrading.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.blankj.utilcode.util.v;
import com.hbg.module.content.custom.widget.LineChartWidget;
import com.huobi.edgeengine.template.widget.Widget;
import com.xiaomi.mipush.sdk.Constants;
import hj.a;
import hj.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import rd.d;
import rj.n;

public final class CopyTradingLineChart extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f43715h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f43716i0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f43717j0 = true;

    /* renamed from: k0  reason: collision with root package name */
    public Float f43718k0;

    public static final void Z(View view, String str) {
        if (StringsKt__StringsKt.R(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false, 2, (Object) null)) {
            ((LineChartWidget) view).setMode(2);
        } else {
            ((LineChartWidget) view).setMode(1);
        }
    }

    public static final void a0(View view, String str) {
        ArrayList arrayList;
        float f11;
        if (TextUtils.isEmpty(str) || x.b(str, "undefined")) {
            ((LineChartWidget) view).setData(CollectionsKt__CollectionsKt.k());
            return;
        }
        List<String> c11 = d.f23353a.c(str, String.class);
        if (c11 != null) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(c11, 10));
            for (String str2 : c11) {
                if (str2.length() == 0) {
                    f11 = 0.0f;
                } else {
                    f11 = Float.parseFloat(str2);
                }
                arrayList.add(Float.valueOf(f11));
            }
        } else {
            arrayList = null;
        }
        Log.d("CopyTradingLineChart", "dataList : " + arrayList);
        ((LineChartWidget) view).setData(arrayList);
    }

    public void C(Context context, Map<String, String> map) {
        Float k11;
        super.C(context, map);
        Float f11 = null;
        this.f43715h0 = map != null ? map.get("rate") : null;
        this.f43716i0 = map != null ? map.get("data") : null;
        if (map != null) {
            try {
                String str = map.get("lineWidth");
                if (!(str == null || (k11 = StringsKt__StringNumberConversionsJVMKt.k(str)) == null)) {
                    f11 = Float.valueOf((float) v.a(k11.floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        this.f43718k0 = f11;
        if (map != null) {
            try {
                String str2 = map.get("drawGraphBg");
                if (str2 != null) {
                    this.f43717j0 = x.b("true", str2);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        if (Q instanceof LineChartWidget) {
            LineChartWidget lineChartWidget = (LineChartWidget) Q;
            lineChartWidget.setLineWidth(this.f43718k0);
            lineChartWidget.setDrawGraphBg(this.f43717j0);
            w(context, this.f43715h0, new a(Q), nVar);
            w(context, this.f43716i0, new b(Q), nVar);
        }
        return Q;
    }

    public View q(Context context) {
        return new LineChartWidget(context, (AttributeSet) null, 0, 6, (r) null);
    }
}
