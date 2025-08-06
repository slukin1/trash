package com.huobi.tradenew.handler;

import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ml.d;
import pro.huobi.R;
import s9.c;

public class TradeCompareViewHolderHandler implements c, View.OnClickListener {
    public final int b(d dVar) {
        return dVar.x() ? R.color.global_market_compare_about_night_color : R.color.global_market_compare_about_light_color;
    }

    public final int c(d dVar) {
        return dVar.x() ? R.color.global_main_text_color_night : R.color.global_main_text_color_light;
    }

    public final int d(d dVar) {
        return dVar.x() ? R.color.global_market_compare_about_night_color : R.color.global_market_compare_about_light_color;
    }

    public final int e(d dVar) {
        return dVar.x() ? R.drawable.selector_trade_compare_coin_market_bg_night : R.drawable.selector_trade_compare_coin_market_bg_light;
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        View view = cVar.itemView;
        g(cVar, dVar, view.getContext());
        view.setTag(R.id.item_data1, dVar);
        view.setOnClickListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x033b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(v9.c r23, ml.d r24, android.content.Context r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r2 = r25
            i6.r r3 = r23.e()
            r4 = r23
            android.view.View r4 = r4.itemView
            android.content.res.Resources r4 = r4.getResources()
            r5 = 2131431343(0x7f0b0faf, float:1.8484413E38)
            android.view.View r5 = r3.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131431344(0x7f0b0fb0, float:1.8484415E38)
            android.view.View r6 = r3.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131431274(0x7f0b0f6a, float:1.8484273E38)
            android.view.View r7 = r3.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131431345(0x7f0b0fb1, float:1.8484417E38)
            android.view.View r8 = r3.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131436613(0x7f0b2445, float:1.8495101E38)
            android.view.View r9 = r3.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131436073(0x7f0b2229, float:1.8494006E38)
            android.view.View r10 = r3.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            java.lang.String r11 = r24.o()
            java.lang.String r12 = ""
            if (r11 != 0) goto L_0x0051
            r11 = r12
        L_0x0051:
            d7.a1 r13 = d7.a1.v()
            boolean r13 = r13.f(r11)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = r24.j()
            r14.append(r15)
            java.lang.String r15 = "/"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r5.setText(r14)
            d7.a1 r14 = d7.a1.v()
            java.lang.String r14 = r14.F(r11)
            r8.setText(r14)
            int r14 = r0.c(r1)
            int r14 = androidx.core.content.ContextCompat.getColor(r2, r14)
            r8.setTextColor(r14)
            java.lang.String r8 = r24.d()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x00b4
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r8 = r24.getSymbolPrice()
            java.lang.Double r8 = r8.getOpen()
            if (r8 == 0) goto L_0x00b4
            java.lang.String r8 = r24.d()
            double r16 = i6.m.h0(r8)
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r8 = r24.getSymbolPrice()
            java.lang.Double r8 = r8.getOpen()
            double r18 = r8.doubleValue()
            double r16 = r16 - r18
            r20 = r16
            goto L_0x00b6
        L_0x00b4:
            r20 = 0
        L_0x00b6:
            r8 = 2131432332(0x7f0b138c, float:1.8486418E38)
            android.view.View r3 = r3.b(r8)
            int r8 = r0.e(r1)
            r3.setBackgroundResource(r8)
            int r3 = r0.b(r1)
            int r3 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r10.setTextColor(r3)
            java.lang.String r3 = r24.d()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r8 = "--"
            if (r3 != 0) goto L_0x00eb
            java.lang.String r3 = r24.d()
            int r14 = com.hbg.lib.data.symbol.PrecisionUtil.x(r11)
            java.lang.String r3 = i6.m.m(r3, r14)
            r9.setText(r3)
            goto L_0x00ee
        L_0x00eb:
            r9.setText(r8)
        L_0x00ee:
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r3 = r24.getSymbolPrice()
            java.lang.Double r3 = r3.getClose()
            if (r3 == 0) goto L_0x0159
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r3 = r24.getSymbolPrice()
            java.lang.Double r3 = r3.getClose()
            double r14 = r3.doubleValue()
            r23 = r12
            r3 = r13
            r12 = 0
            int r14 = java.lang.Double.compare(r14, r12)
            if (r14 == 0) goto L_0x0154
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r15 = r7
            r18 = r8
            r7 = r20
            int r19 = java.lang.Double.compare(r7, r12)
            if (r19 <= 0) goto L_0x0122
            java.lang.String r12 = "+"
            goto L_0x0124
        L_0x0122:
            r12 = r23
        L_0x0124:
            r14.append(r12)
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r24.getSymbolPrice()
            java.lang.Double r12 = r12.getOpen()
            double r12 = r12.doubleValue()
            double r20 = r7 / r12
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r12 = r12 * r20
            java.lang.String r19 = r24.o()
            r23 = r15
            int r15 = com.hbg.lib.data.symbol.PrecisionUtil.v(r19)
            java.lang.String r12 = i6.m.i(r12, r15)
            r14.append(r12)
            java.lang.String r12 = "%"
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            goto L_0x0162
        L_0x0154:
            r23 = r7
            r18 = r8
            goto L_0x015e
        L_0x0159:
            r23 = r7
            r18 = r8
            r3 = r13
        L_0x015e:
            r7 = r20
            r12 = r18
        L_0x0162:
            r6.setText(r12)
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r24.getSymbolPrice()
            java.lang.String r12 = r12.getSymbol()
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 != 0) goto L_0x01a1
            d7.a1 r13 = d7.a1.v()
            java.lang.String r13 = r13.D(r12)
            java.lang.String r14 = "usdt"
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x01a1
            java.lang.String r12 = r24.d()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x019e
            td.i r12 = td.i.a()
            td.h r12 = r12.b()
            java.lang.String r13 = r24.d()
            java.lang.String r12 = r12.v(r13)
            goto L_0x01b3
        L_0x019e:
            r12 = r18
            goto L_0x01b3
        L_0x01a1:
            td.i r13 = td.i.a()
            td.h r13 = r13.b()
            java.lang.String r14 = r24.d()
            com.hbg.lib.data.symbol.TradeType r15 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r12 = r13.l(r14, r12, r15)
        L_0x01b3:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "≈"
            r13.append(r14)
            r13.append(r12)
            com.hbg.lib.core.BaseModuleConfig$a r12 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r12 = r12.M()
            java.lang.String r12 = com.hbg.lib.common.utils.StringUtils.i(r12)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r10.setText(r12)
            java.lang.String r10 = r24.n()
            java.lang.String r12 = "suspend"
            boolean r10 = r12.equals(r10)
            java.lang.String r13 = "transfer-board"
            if (r10 != 0) goto L_0x028e
            java.lang.String r10 = r24.n()
            boolean r10 = r13.equals(r10)
            if (r10 != 0) goto L_0x028e
            java.lang.String r10 = r24.n()
            java.lang.String r14 = "fuse"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x01fc
            goto L_0x028e
        L_0x01fc:
            java.lang.String r10 = r24.n()
            java.lang.String r12 = "pre-online"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x0234
            int r4 = r0.c(r1)
            int r4 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r5.setTextColor(r4)
            int r4 = r0.c(r1)
            int r4 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r6.setTextColor(r4)
            r4 = 2132027201(0x7f142741, float:1.9692956E38)
            r6.setText(r4)
            int r5 = r0.c(r1)
            int r5 = androidx.core.content.ContextCompat.getColor(r2, r5)
            r9.setTextColor(r5)
            r9.setText(r4)
            goto L_0x02e0
        L_0x0234:
            int r10 = r0.d(r1)
            int r10 = androidx.core.content.ContextCompat.getColor(r2, r10)
            r5.setTextColor(r10)
            r12 = 0
            int r5 = java.lang.Double.compare(r7, r12)
            if (r5 <= 0) goto L_0x025f
            int r5 = com.hbg.lib.core.util.w.h()
            int r5 = r4.getColor(r5)
            r6.setTextColor(r5)
            int r5 = com.hbg.lib.core.util.w.h()
            int r4 = r4.getColor(r5)
            r9.setTextColor(r4)
            goto L_0x02e0
        L_0x025f:
            int r5 = java.lang.Double.compare(r7, r12)
            if (r5 >= 0) goto L_0x027c
            int r5 = com.hbg.lib.core.util.w.d()
            int r5 = r4.getColor(r5)
            r6.setTextColor(r5)
            int r5 = com.hbg.lib.core.util.w.d()
            int r4 = r4.getColor(r5)
            r9.setTextColor(r4)
            goto L_0x02e0
        L_0x027c:
            r5 = 2131100395(0x7f0602eb, float:1.781317E38)
            int r7 = r4.getColor(r5)
            r6.setTextColor(r7)
            int r4 = r4.getColor(r5)
            r9.setTextColor(r4)
            goto L_0x02e0
        L_0x028e:
            int r4 = r0.c(r1)
            int r4 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r5.setTextColor(r4)
            int r4 = r0.c(r1)
            int r4 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r6.setTextColor(r4)
            int r4 = r0.c(r1)
            int r4 = androidx.core.content.ContextCompat.getColor(r2, r4)
            r9.setTextColor(r4)
            java.lang.String r4 = r24.n()
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x02c3
            r4 = 2132027230(0x7f14275e, float:1.9693015E38)
            r6.setText(r4)
            r9.setText(r4)
            goto L_0x02e0
        L_0x02c3:
            java.lang.String r4 = r24.n()
            boolean r4 = r13.equals(r4)
            if (r4 == 0) goto L_0x02d7
            r4 = 2132027233(0x7f142761, float:1.9693021E38)
            r6.setText(r4)
            r9.setText(r4)
            goto L_0x02e0
        L_0x02d7:
            r4 = 2132027169(0x7f142721, float:1.9692891E38)
            r6.setText(r4)
            r9.setText(r4)
        L_0x02e0:
            boolean r4 = r24.x()
            d7.a1 r5 = d7.a1.v()
            boolean r5 = r5.p0(r11)
            java.lang.String r6 = r24.g()
            int r4 = com.huobi.trade.helper.f0.f(r4, r5, r6)
            r7 = r23
            r7.setBackgroundResource(r4)
            d7.a1 r4 = d7.a1.v()
            boolean r4 = r4.p0(r11)
            java.lang.String r5 = r24.g()
            int r2 = com.huobi.trade.helper.f0.g(r2, r4, r5)
            r7.setTextColor(r2)
            java.lang.String r2 = r24.i()
            boolean r4 = r24.A()
            d7.a1 r5 = d7.a1.v()
            boolean r5 = r5.p0(r11)
            java.lang.String r1 = r24.n()
            java.lang.String r6 = "online"
            boolean r1 = r6.equals(r1)
            r6 = 0
            if (r5 != 0) goto L_0x032b
            if (r1 == 0) goto L_0x0337
        L_0x032b:
            if (r4 != 0) goto L_0x0337
            if (r3 != 0) goto L_0x0337
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0337
            r1 = 1
            goto L_0x0338
        L_0x0337:
            r1 = r6
        L_0x0338:
            if (r1 == 0) goto L_0x033b
            goto L_0x033d
        L_0x033b:
            r6 = 8
        L_0x033d:
            r7.setVisibility(r6)
            r7.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.handler.TradeCompareViewHolderHandler.g(v9.c, ml.d, android.content.Context):void");
    }

    public int getResId() {
        return R.layout.item_trade_compare_coin_market;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        d dVar = (d) view.getTag(R.id.item_data1);
        if (dVar.c() != null) {
            dVar.c().c(dVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
