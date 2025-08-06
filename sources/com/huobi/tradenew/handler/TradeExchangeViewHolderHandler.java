package com.huobi.tradenew.handler;

import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ml.d;
import pro.huobi.R;
import s9.c;

public class TradeExchangeViewHolderHandler implements c, View.OnClickListener {
    public final int b(d dVar) {
        return dVar.x() ? R.color.global_default_text_color_night : R.color.global_market_compare_about_light_color;
    }

    public final int c(d dVar) {
        return dVar.x() ? R.color.trade_dialog_divider_color_night : R.color.trade_dialog_divider_color_light;
    }

    public final int d(d dVar) {
        return dVar.x() ? R.color.global_module_focus_bg_night : R.color.global_module_focus_bg_light;
    }

    public final int e(d dVar) {
        return dVar.x() ? R.color.global_main_text_color_night : R.color.global_main_text_color_light;
    }

    public final int f(d dVar) {
        return dVar.x() ? R.drawable.selector_trade_coin_market_bg_night : R.drawable.selector_trade_coin_market_bg_light;
    }

    public final int g(d dVar) {
        return dVar.x() ? R.color.global_sec_text_color_night : R.color.global_sec_text_color_light;
    }

    public int getResId() {
        return R.layout.item_trade_coin_market;
    }

    public final int h(d dVar) {
        return R.drawable.market_st;
    }

    /* renamed from: i */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        View view = cVar.itemView;
        j(cVar, dVar, view.getContext());
        view.setTag(R.id.item_data1, dVar);
        view.setOnClickListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x026f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(v9.c r25, ml.d r26, android.content.Context r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            i6.r r4 = r25.e()
            android.view.View r5 = r1.itemView
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131431343(0x7f0b0faf, float:1.8484413E38)
            android.view.View r6 = r4.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131431344(0x7f0b0fb0, float:1.8484415E38)
            android.view.View r7 = r4.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131431274(0x7f0b0f6a, float:1.8484273E38)
            android.view.View r8 = r4.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131431345(0x7f0b0fb1, float:1.8484417E38)
            android.view.View r9 = r4.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131431342(0x7f0b0fae, float:1.848441E38)
            android.view.View r10 = r4.b(r10)
            r11 = 2131433714(0x7f0b18f2, float:1.8489221E38)
            android.view.View r4 = r4.b(r11)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            java.lang.String r11 = r26.o()
            if (r11 != 0) goto L_0x004e
            java.lang.String r11 = ""
        L_0x004e:
            r12 = 1096810496(0x41600000, float:14.0)
            r13 = 1
            r7.setTextSize(r13, r12)
            d7.a1 r12 = d7.a1.v()
            boolean r12 = r12.f(r11)
            r15 = 0
            if (r12 == 0) goto L_0x007e
            d7.a1 r13 = d7.a1.v()
            java.lang.String r14 = r26.o()
            boolean r13 = r13.R(r14)
            if (r13 == 0) goto L_0x0074
            r13 = 2131235927(0x7f081457, float:1.8088062E38)
            r4.setImageResource(r13)
            goto L_0x007a
        L_0x0074:
            r13 = 2131234074(0x7f080d1a, float:1.8084303E38)
            r4.setImageResource(r13)
        L_0x007a:
            r4.setVisibility(r15)
            goto L_0x008e
        L_0x007e:
            boolean r13 = r26.A()
            if (r13 == 0) goto L_0x0091
            int r13 = r0.h(r2)
            r4.setImageResource(r13)
            r4.setVisibility(r15)
        L_0x008e:
            r13 = 8
            goto L_0x0096
        L_0x0091:
            r13 = 8
            r4.setVisibility(r13)
        L_0x0096:
            java.lang.String r4 = r26.j()
            r6.setText(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r14 = "/"
            r4.append(r14)
            d7.a1 r14 = d7.a1.v()
            java.lang.String r14 = r14.F(r11)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            r9.setText(r4)
            int r4 = r0.g(r2)
            int r4 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r9.setTextColor(r4)
            java.lang.String r4 = r26.d()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00f1
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r4 = r26.getSymbolPrice()
            java.lang.Double r4 = r4.getOpen()
            if (r4 == 0) goto L_0x00f1
            java.lang.String r4 = r26.d()
            double r16 = i6.m.h0(r4)
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r4 = r26.getSymbolPrice()
            java.lang.Double r4 = r4.getOpen()
            double r18 = r4.doubleValue()
            double r16 = r16 - r18
            r13 = r16
            goto L_0x00f3
        L_0x00f1:
            r13 = 0
        L_0x00f3:
            boolean r4 = r26.B()
            if (r4 == 0) goto L_0x0107
            android.view.View r1 = r1.itemView
            int r4 = r0.d(r2)
            int r4 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setBackgroundColor(r4)
            goto L_0x0110
        L_0x0107:
            android.view.View r1 = r1.itemView
            int r4 = r0.f(r2)
            r1.setBackgroundResource(r4)
        L_0x0110:
            java.lang.String r1 = r26.d()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r4 = "--"
            if (r1 != 0) goto L_0x012c
            java.lang.String r1 = r26.d()
            int r9 = com.hbg.lib.data.symbol.PrecisionUtil.x(r11)
            java.lang.String r1 = i6.m.m(r1, r9)
            r7.setText(r1)
            goto L_0x012f
        L_0x012c:
            r7.setText(r4)
        L_0x012f:
            java.lang.String r1 = r26.n()
            java.lang.String r9 = "suspend"
            boolean r1 = r9.equals(r1)
            java.lang.String r15 = "transfer-board"
            if (r1 != 0) goto L_0x01cd
            java.lang.String r1 = r26.n()
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x01cd
            java.lang.String r1 = r26.n()
            r19 = r12
            java.lang.String r12 = "fuse"
            boolean r1 = r12.equals(r1)
            if (r1 == 0) goto L_0x0158
            r1 = r8
            goto L_0x01d0
        L_0x0158:
            java.lang.String r1 = r26.n()
            java.lang.String r4 = "pre-online"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x018f
            long r20 = r26.r()
            long r22 = com.hbg.lib.common.utils.DateTimeUtils.v()
            int r1 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r1 <= 0) goto L_0x018f
            int r1 = r0.b(r2)
            int r1 = androidx.core.content.ContextCompat.getColor(r3, r1)
            r6.setTextColor(r1)
            int r1 = r0.b(r2)
            int r1 = androidx.core.content.ContextCompat.getColor(r3, r1)
            r7.setTextColor(r1)
            r1 = 2132027201(0x7f142741, float:1.9692956E38)
            r7.setText(r1)
            r1 = r8
            goto L_0x021e
        L_0x018f:
            int r1 = r0.e(r2)
            int r1 = androidx.core.content.ContextCompat.getColor(r3, r1)
            r6.setTextColor(r1)
            r1 = r8
            r8 = 0
            int r4 = java.lang.Double.compare(r13, r8)
            if (r4 <= 0) goto L_0x01b0
            int r4 = com.hbg.lib.core.util.w.h()
            int r4 = r5.getColor(r4)
            r7.setTextColor(r4)
            goto L_0x021e
        L_0x01b0:
            int r4 = java.lang.Double.compare(r13, r8)
            if (r4 >= 0) goto L_0x01c2
            int r4 = com.hbg.lib.core.util.w.d()
            int r4 = r5.getColor(r4)
            r7.setTextColor(r4)
            goto L_0x021e
        L_0x01c2:
            r4 = 2131100395(0x7f0602eb, float:1.781317E38)
            int r4 = r5.getColor(r4)
            r7.setTextColor(r4)
            goto L_0x021e
        L_0x01cd:
            r1 = r8
            r19 = r12
        L_0x01d0:
            int r5 = r0.b(r2)
            int r5 = androidx.core.content.ContextCompat.getColor(r3, r5)
            r6.setTextColor(r5)
            int r5 = r0.b(r2)
            int r5 = androidx.core.content.ContextCompat.getColor(r3, r5)
            r7.setTextColor(r5)
            java.lang.String r5 = r26.n()
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0207
            com.huobi.utils.HBHTtoHTXManager r5 = com.huobi.utils.HBHTtoHTXManager.f83692a
            java.lang.String r6 = r26.o()
            boolean r5 = r5.f(r6)
            if (r5 == 0) goto L_0x0200
            r7.setText(r4)
            goto L_0x021e
        L_0x0200:
            r4 = 2132027230(0x7f14275e, float:1.9693015E38)
            r7.setText(r4)
            goto L_0x021e
        L_0x0207:
            java.lang.String r4 = r26.n()
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x0218
            r4 = 2132027233(0x7f142761, float:1.9693021E38)
            r7.setText(r4)
            goto L_0x021e
        L_0x0218:
            r4 = 2132027169(0x7f142721, float:1.9692891E38)
            r7.setText(r4)
        L_0x021e:
            int r4 = r0.c(r2)
            int r4 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r10.setBackgroundColor(r4)
            boolean r4 = r26.x()
            d7.a1 r5 = d7.a1.v()
            boolean r5 = r5.p0(r11)
            java.lang.String r6 = r26.g()
            int r4 = com.huobi.trade.helper.f0.f(r4, r5, r6)
            r1.setBackgroundResource(r4)
            d7.a1 r4 = d7.a1.v()
            boolean r4 = r4.p0(r11)
            java.lang.String r5 = r26.g()
            int r3 = com.huobi.trade.helper.f0.g(r3, r4, r5)
            r1.setTextColor(r3)
            java.lang.String r3 = r26.i()
            boolean r4 = r26.A()
            d7.a1 r5 = d7.a1.v()
            boolean r5 = r5.p0(r11)
            java.lang.String r2 = r26.n()
            java.lang.String r6 = "online"
            boolean r2 = r6.equals(r2)
            if (r5 != 0) goto L_0x0271
            if (r2 == 0) goto L_0x027d
        L_0x0271:
            if (r4 != 0) goto L_0x027d
            if (r19 != 0) goto L_0x027d
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x027d
            r13 = 1
            goto L_0x027e
        L_0x027d:
            r13 = 0
        L_0x027e:
            if (r13 == 0) goto L_0x0282
            r14 = 0
            goto L_0x0284
        L_0x0282:
            r14 = 8
        L_0x0284:
            r1.setVisibility(r14)
            r1.setText(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.handler.TradeExchangeViewHolderHandler.j(v9.c, ml.d, android.content.Context):void");
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
