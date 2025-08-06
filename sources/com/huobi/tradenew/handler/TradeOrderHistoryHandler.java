package com.huobi.tradenew.handler;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.huobi.order.ui.TradeOrderHistoryDetailActivity;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import pro.huobi.R;
import s9.c;

public class TradeOrderHistoryHandler implements c<Object, TradeOrderHistory> {
    @SensorsDataInstrumented
    public static /* synthetic */ void g(Context context, TradeOrderHistory tradeOrderHistory, View view) {
        k0.O(context, tradeOrderHistory.getSymbolId(), tradeOrderHistory.isBuy());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(Context context, TradeOrderHistory tradeOrderHistory, View view) {
        k0.O(context, tradeOrderHistory.getSymbolId(), tradeOrderHistory.isBuy());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(Context context, TradeOrderHistory tradeOrderHistory, View view) {
        Intent intent = new Intent(context, TradeOrderHistoryDetailActivity.class);
        intent.putExtra("symbolId", tradeOrderHistory.getSymbolId());
        intent.putExtra("extra_order_history", tradeOrderHistory);
        context.startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int e(TradeOrderHistory tradeOrderHistory) {
        if (tradeOrderHistory == null) {
            return 0;
        }
        String valueOf = String.valueOf(tradeOrderHistory.getStatus());
        if (valueOf.equals("3")) {
            if (m.i0(tradeOrderHistory.getTamount()) > 0.0f) {
                return 2;
            }
            return 0;
        } else if (valueOf.equals("2")) {
            return 1;
        } else {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x050e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x059e  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(java.lang.Object r26, int r27, com.huobi.trade.bean.TradeOrderHistory r28, android.view.ViewGroup r29) {
        /*
            r25 = this;
            r0 = r26
            r1 = r28
            boolean r2 = r0 instanceof v9.c
            if (r2 == 0) goto L_0x0016
            r2 = r0
            v9.c r2 = (v9.c) r2
            i6.r r3 = r2.e()
            android.view.View r2 = r2.itemView
            android.content.Context r2 = r2.getContext()
            goto L_0x0025
        L_0x0016:
            boolean r2 = r0 instanceof u9.b
            if (r2 == 0) goto L_0x05f8
            r2 = r0
            u9.b r2 = (u9.b) r2
            i6.r r3 = r2.c()
            android.content.Context r2 = r29.getContext()
        L_0x0025:
            r4 = 2131436611(0x7f0b2443, float:1.8495097E38)
            android.view.View r4 = r3.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 2131436606(0x7f0b243e, float:1.8495087E38)
            android.view.View r5 = r3.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131436592(0x7f0b2430, float:1.8495059E38)
            android.view.View r6 = r3.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131436568(0x7f0b2418, float:1.849501E38)
            android.view.View r7 = r3.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131436593(0x7f0b2431, float:1.849506E38)
            android.view.View r8 = r3.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131436569(0x7f0b2419, float:1.8495012E38)
            android.view.View r9 = r3.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131436596(0x7f0b2434, float:1.8495067E38)
            android.view.View r10 = r3.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131433259(0x7f0b172b, float:1.8488299E38)
            android.view.View r11 = r3.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131433700(0x7f0b18e4, float:1.8489193E38)
            android.view.View r12 = r3.b(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r13 = 2131435362(0x7f0b1f62, float:1.8492564E38)
            android.view.View r13 = r3.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r14 = 2131433697(0x7f0b18e1, float:1.8489187E38)
            android.view.View r14 = r3.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r15 = 2131427608(0x7f0b0118, float:1.8476837E38)
            android.view.View r15 = r3.b(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r27 = r10
            r10 = 2131435363(0x7f0b1f63, float:1.8492566E38)
            android.view.View r10 = r3.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            java.lang.String r16 = r28.getType()
            java.lang.String r0 = java.lang.String.valueOf(r16)
            r29 = r10
            r10 = 2131436866(0x7f0b2542, float:1.8495615E38)
            android.view.View r3 = r3.b(r10)
            android.widget.TextView r3 = (android.widget.TextView) r3
            d7.a1 r10 = d7.a1.v()
            r16 = r8
            java.lang.String r8 = r28.getSymbolId()
            r17 = r9
            com.hbg.lib.data.symbol.TradeType r9 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r8 = r10.J(r8, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            if (r8 == 0) goto L_0x00d7
            java.lang.String r18 = r8.getBaseCurrencyDisplayName()
            java.lang.String r8 = r8.getQuoteCurrencyDisplayName()
            r23 = r6
            r22 = r7
            r6 = r18
            goto L_0x013a
        L_0x00d7:
            d7.a1 r8 = d7.a1.v()
            java.util.List r8 = r8.j()
            java.util.Iterator r8 = r8.iterator()
            java.lang.String r18 = ""
            r19 = r18
        L_0x00e7:
            boolean r20 = r8.hasNext()
            if (r20 == 0) goto L_0x0132
            java.lang.Object r20 = r8.next()
            r10 = r20
            java.lang.String r10 = (java.lang.String) r10
            r20 = r8
            java.lang.String r8 = r28.getSymbolId()
            int r8 = r8.lastIndexOf(r10)
            if (r8 <= 0) goto L_0x0127
            d7.k r8 = d7.k.C()
            java.lang.String r18 = r8.z(r10)
            d7.k r8 = d7.k.C()
            r22 = r7
            java.lang.String r7 = r28.getSymbolId()
            r23 = r6
            java.lang.String r6 = r28.getSymbolId()
            int r6 = r6.lastIndexOf(r10)
            r10 = 0
            java.lang.String r6 = r7.substring(r10, r6)
            java.lang.String r19 = r8.z(r6)
            goto L_0x012b
        L_0x0127:
            r23 = r6
            r22 = r7
        L_0x012b:
            r8 = r20
            r7 = r22
            r6 = r23
            goto L_0x00e7
        L_0x0132:
            r23 = r6
            r22 = r7
            r8 = r18
            r6 = r19
        L_0x013a:
            r9.append(r6)
            java.lang.String r7 = "/"
            r9.append(r7)
            r9.append(r8)
            java.lang.String r7 = r9.toString()
            r3.setText(r7)
            pt.n r7 = new pt.n
            r7.<init>(r2, r1)
            r3.setOnClickListener(r7)
            java.lang.String r7 = r28.getSource()
            java.lang.String r9 = r28.getType()
            java.lang.String r7 = com.huobi.trade.bean.TradeOrderType.a(r7, r9, r2)
            r4.setText(r7)
            pt.p r7 = new pt.p
            r7.<init>(r2, r1)
            r4.setOnClickListener(r7)
            boolean r7 = com.huobi.trade.bean.TradeOrderType.c(r0)
            java.lang.String r9 = "sell-market"
            java.lang.String r10 = "buy-market"
            r18 = r3
            java.lang.String r3 = "(%s)"
            if (r7 == 0) goto L_0x0231
            int r7 = com.hbg.lib.core.util.w.h()
            int r7 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r4.setTextColor(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r1 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r1 = r2.getString(r1)
            r7.append(r1)
            r7.append(r3)
            java.lang.String r1 = r7.toString()
            r24 = r5
            r7 = 1
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r21 = 0
            r5[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r5)
            r12.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r5)
            r13.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r5)
            r14.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r21] = r6
            java.lang.String r1 = java.lang.String.format(r1, r5)
            r11.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r3[r21] = r6
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r15.setText(r1)
        L_0x022e:
            r5 = 1
            goto L_0x0462
        L_0x0231:
            r24 = r5
            boolean r1 = com.huobi.trade.bean.TradeOrderType.d(r0)
            if (r1 == 0) goto L_0x02ee
            int r1 = com.hbg.lib.core.util.w.d()
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r4.setTextColor(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r5 = 1
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r21 = 0
            r7[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r12.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r13.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r14.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r21] = r6
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r11.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r21] = r6
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r15.setText(r1)
            goto L_0x022e
        L_0x02ee:
            boolean r1 = r10.equals(r0)
            if (r1 == 0) goto L_0x03a9
            int r1 = com.hbg.lib.core.util.w.h()
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r4.setTextColor(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r5 = 1
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r19 = 0
            r7[r19] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r12.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r19] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r13.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r19] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r14.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021970(0x7f1412d2, float:1.9682346E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r19] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r11.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r19] = r6
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r15.setText(r1)
            goto L_0x022e
        L_0x03a9:
            boolean r1 = r9.equals(r0)
            if (r1 == 0) goto L_0x022e
            int r1 = com.hbg.lib.core.util.w.d()
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r4.setTextColor(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r5 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r5 = r2.getString(r5)
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r5 = 1
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r21 = 0
            r7[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r12.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r13.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r21] = r8
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r14.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r21] = r6
            java.lang.String r1 = java.lang.String.format(r1, r7)
            r11.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r7 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r7 = r2.getString(r7)
            r1.append(r7)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r21] = r6
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r15.setText(r1)
        L_0x0462:
            long r6 = r28.getOrder_time()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r11
            java.lang.String r1 = com.hbg.lib.common.utils.DateTimeUtils.C(r6)
            r3 = r24
            r3.setText(r1)
            boolean r1 = r9.equals(r0)
            if (r1 != 0) goto L_0x04aa
            boolean r1 = r10.equals(r0)
            if (r1 == 0) goto L_0x047f
            goto L_0x04aa
        L_0x047f:
            java.lang.String r0 = r28.getOrder_price()
            java.lang.String r1 = r28.getSymbolId()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.A(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
            r6 = r23
            r6.setText(r0)
            java.lang.String r0 = r28.getOrder_amount()
            java.lang.String r1 = r28.getSymbolId()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
            r7 = r22
            r7.setText(r0)
            goto L_0x04e7
        L_0x04aa:
            r7 = r22
            r6 = r23
            r1 = 2132021960(0x7f1412c8, float:1.9682326E38)
            r6.setText(r1)
            boolean r1 = r10.equals(r0)
            if (r1 == 0) goto L_0x04ce
            java.lang.String r0 = r28.getOrder_tprice()
            java.lang.String r1 = r28.getSymbolId()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.y(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
            r7.setText(r0)
            goto L_0x04e7
        L_0x04ce:
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x04e7
            java.lang.String r0 = r28.getOrder_amount()
            java.lang.String r1 = r28.getSymbolId()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
            r7.setText(r0)
        L_0x04e7:
            java.lang.String r0 = r28.getTamount()
            java.lang.String r1 = r28.getSymbolId()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.z(r1)
            java.lang.String r0 = i6.m.m(r0, r1)
            r9 = r17
            r9.setText(r0)
            java.lang.String r0 = r28.getAprice()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x050e
            java.lang.String r0 = "0"
            r1 = r28
            r1.setAprice(r0)
            goto L_0x0510
        L_0x050e:
            r1 = r28
        L_0x0510:
            java.lang.String r0 = r28.getAprice()
            java.lang.String r8 = r28.getSymbolId()
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.A(r8)
            java.lang.String r0 = i6.m.m(r0, r8)
            r8 = r16
            r8.setText(r0)
            java.lang.String r0 = r28.getTprice()
            java.lang.String r10 = r28.getSymbolId()
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.y(r10)
            java.lang.String r0 = i6.m.m(r0, r10)
            r10 = r29
            r10.setText(r0)
            r0 = r26
            v9.c r0 = (v9.c) r0
            android.view.View r11 = r0.itemView
            pt.o r12 = new pt.o
            r12.<init>(r2, r1)
            r11.setOnClickListener(r12)
            r11 = r25
            int r1 = r11.e(r1)
            r12 = 2131099916(0x7f06010c, float:1.7812199E38)
            r13 = 0
            if (r1 != 0) goto L_0x059e
            r1 = 2132021953(0x7f1412c1, float:1.9682312E38)
            r14 = r27
            r14.setText(r1)
            android.view.View r1 = r0.itemView
            r5 = 0
            r1.setClickable(r5)
            r14.setCompoundDrawablesWithIntrinsicBounds(r13, r13, r13, r13)
            android.view.View r0 = r0.itemView
            android.content.res.Resources r1 = r2.getResources()
            r5 = 2131099898(0x7f0600fa, float:1.7812162E38)
            int r1 = r1.getColor(r5)
            r0.setBackgroundColor(r1)
            r0 = 1056964608(0x3f000000, float:0.5)
            r4.setAlpha(r0)
            android.content.res.Resources r0 = r2.getResources()
            int r0 = r0.getColor(r12)
            r1 = r18
            r1.setTextColor(r0)
            android.content.res.Resources r0 = r2.getResources()
            r1 = 2131099934(0x7f06011e, float:1.7812235E38)
            int r0 = r0.getColor(r1)
            r14.setTextColor(r0)
            android.content.res.Resources r0 = r2.getResources()
            int r0 = r0.getColor(r12)
            goto L_0x05e5
        L_0x059e:
            r14 = r27
            r1 = r18
            android.view.View r15 = r0.itemView
            r15.setClickable(r5)
            r5 = 2132021954(0x7f1412c2, float:1.9682314E38)
            r14.setText(r5)
            r5 = 2131232593(0x7f080751, float:1.80813E38)
            android.graphics.drawable.Drawable r5 = androidx.core.content.ContextCompat.getDrawable(r2, r5)
            r14.setCompoundDrawablesWithIntrinsicBounds(r13, r13, r5, r13)
            android.view.View r0 = r0.itemView
            r5 = 2131234925(0x7f08106d, float:1.808603E38)
            r0.setBackgroundResource(r5)
            r0 = 1065353216(0x3f800000, float:1.0)
            r4.setAlpha(r0)
            android.content.res.Resources r0 = r2.getResources()
            r4 = 2131099907(0x7f060103, float:1.781218E38)
            int r0 = r0.getColor(r4)
            r1.setTextColor(r0)
            android.content.res.Resources r0 = r2.getResources()
            int r0 = r0.getColor(r12)
            r14.setTextColor(r0)
            android.content.res.Resources r0 = r2.getResources()
            int r0 = r0.getColor(r4)
        L_0x05e5:
            r3.setTextColor(r0)
            r6.setTextColor(r0)
            r7.setTextColor(r0)
            r10.setTextColor(r0)
            r8.setTextColor(r0)
            r9.setTextColor(r0)
            return
        L_0x05f8:
            r11 = r25
            java.lang.String r0 = "shoud not be here"
            i6.d.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.handler.TradeOrderHistoryHandler.handleView(java.lang.Object, int, com.huobi.trade.bean.TradeOrderHistory, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.myorder_history_item_parent;
    }
}
