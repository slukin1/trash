package com.huobi.zeroswap.engine.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.zeroswap.engine.view.KLineEdgeItemView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import ov.b;
import ov.c;
import ov.d;
import rj.n;

public final class KLineViewWidget extends Widget {

    /* renamed from: i0  reason: collision with root package name */
    public static final a f21216i0 = new a((r) null);

    /* renamed from: j0  reason: collision with root package name */
    public static final Pair<String, Class<? extends Widget>> f21217j0 = new Pair<>("KlineView", KLineViewWidget.class);

    /* renamed from: h0  reason: collision with root package name */
    public final HashMap<String, String> f21218h0 = new HashMap<>();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Pair<String, Class<? extends Widget>> a() {
            return KLineViewWidget.f21217j0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c0(com.huobi.zeroswap.engine.view.KLineEdgeItemView r2, com.huobi.zeroswap.engine.widget.KLineViewWidget r3, java.lang.String r4) {
        /*
            if (r4 == 0) goto L_0x000d
            java.lang.Integer r4 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r4)
            if (r4 == 0) goto L_0x000d
            int r4 = r4.intValue()
            goto L_0x000f
        L_0x000d:
            r4 = 232(0xe8, float:3.25E-43)
        L_0x000f:
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            int r1 = r0.height
            if (r1 == r4) goto L_0x003d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            int r1 = com.hbg.module.libkt.utils.m.a(r1)
            r0.height = r1
            r2.setLayoutParams(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "widgetHeight = "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r4 = " 刷新"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.b0(r2)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.engine.widget.KLineViewWidget.c0(com.huobi.zeroswap.engine.view.KLineEdgeItemView, com.huobi.zeroswap.engine.widget.KLineViewWidget, java.lang.String):void");
    }

    public static final void d0(KLineEdgeItemView kLineEdgeItemView, KLineViewWidget kLineViewWidget, String str) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (str.length() > 0) {
            int s11 = FuturePrecisionUtil.s(str, str, str2);
            int y11 = FuturePrecisionUtil.y(str, str, str2);
            String str3 = kLineEdgeItemView.M;
            if (str3 != null) {
                str2 = str3;
            }
            if (!x.b(str, str2)) {
                kLineEdgeItemView.i(false, TradeType.LINEAR_SWAP.toString(), str, y11, s11);
                kLineViewWidget.b0("symbol = " + str + " 刷新");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r5 = kotlin.text.StringsKt__StringsKt.h1(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void e0(com.huobi.zeroswap.engine.view.KLineEdgeItemView r3, com.huobi.zeroswap.engine.widget.KLineViewWidget r4, java.lang.String r5) {
        /*
            r0 = 1
            if (r5 == 0) goto L_0x000e
            java.lang.Boolean r5 = kotlin.text.StringsKt__StringsKt.h1(r5)
            if (r5 == 0) goto L_0x000e
            boolean r5 = r5.booleanValue()
            goto L_0x000f
        L_0x000e:
            r5 = r0
        L_0x000f:
            java.lang.String r1 = r3.M
            if (r1 != 0) goto L_0x0015
            java.lang.String r1 = ""
        L_0x0015:
            int r1 = r1.length()
            r2 = 0
            if (r1 <= 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "fold 刷新 1"
            r4.b0(r0)
            if (r5 == 0) goto L_0x0039
            boolean r0 = r3.k()
            if (r0 != 0) goto L_0x0039
            java.lang.String r5 = "fold 刷新 2"
            r4.b0(r5)
            r3.setVisibility(r2)
            r3.s()
            goto L_0x0068
        L_0x0039:
            if (r5 != 0) goto L_0x004f
            boolean r0 = r3.k()
            if (r0 == 0) goto L_0x004f
            java.lang.String r5 = "fold 刷新 3"
            r4.b0(r5)
            r4 = 8
            r3.setVisibility(r4)
            r3.r()
            goto L_0x0068
        L_0x004f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "fold = "
            r3.append(r0)
            r3.append(r5)
            java.lang.String r5 = " 刷新 4"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.b0(r3)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.engine.widget.KLineViewWidget.e0(com.huobi.zeroswap.engine.view.KLineEdgeItemView, com.huobi.zeroswap.engine.widget.KLineViewWidget, java.lang.String):void");
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f21218h0.clear();
        HashMap<String, String> hashMap = this.f21218h0;
        if (map == null) {
            map = new HashMap<>();
        }
        hashMap.putAll(map);
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        KLineEdgeItemView kLineEdgeItemView = Q instanceof KLineEdgeItemView ? (KLineEdgeItemView) Q : null;
        b0("View: " + Q);
        if (kLineEdgeItemView != null) {
            b0("参数: " + this.f21218h0);
            String str = this.f21218h0.get("height");
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = this.f21218h0.get("symbol");
            if (str3 == null) {
                str3 = str2;
            }
            String str4 = this.f21218h0.get("fold");
            if (str4 != null) {
                str2 = str4;
            }
            w(context, str, new c(kLineEdgeItemView, this), nVar);
            w(context, str3, new d(kLineEdgeItemView, this), nVar);
            w(context, str2, new b(kLineEdgeItemView, this), nVar);
        }
        return Q;
    }

    public final void b0(String str) {
        Log.d("WidgetKLineView", str);
    }

    public View q(Context context) {
        b0("View: createView()");
        return new KLineEdgeItemView(context);
    }
}
