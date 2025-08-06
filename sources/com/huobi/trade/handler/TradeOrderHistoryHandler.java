package com.huobi.trade.handler;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.huobi.order.ui.TradeOrderHistoryDetailActivity;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;
import s9.c;

public class TradeOrderHistoryHandler implements c<Object, TradeOrderHistory> {
    @SensorsDataInstrumented
    public static /* synthetic */ void h(Context context, TradeOrderHistory tradeOrderHistory, View view) {
        k0.O(context, tradeOrderHistory.getSymbolId(), tradeOrderHistory.isBuy());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(Context context, TradeOrderHistory tradeOrderHistory, View view) {
        k0.O(context, tradeOrderHistory.getSymbolId(), tradeOrderHistory.isBuy());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(Context context, TradeOrderHistory tradeOrderHistory, View view) {
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

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0570  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x059b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x05ed  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0634  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x068f  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(java.lang.Object r30, int r31, com.huobi.trade.bean.TradeOrderHistory r32, android.view.ViewGroup r33) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r32
            boolean r3 = r1 instanceof v9.c
            if (r3 == 0) goto L_0x0018
            r3 = r1
            v9.c r3 = (v9.c) r3
            i6.r r4 = r3.e()
            android.view.View r3 = r3.itemView
            android.content.Context r3 = r3.getContext()
            goto L_0x0027
        L_0x0018:
            boolean r3 = r1 instanceof u9.b
            if (r3 == 0) goto L_0x06f3
            r3 = r1
            u9.b r3 = (u9.b) r3
            i6.r r4 = r3.c()
            android.content.Context r3 = r33.getContext()
        L_0x0027:
            r5 = 2131436611(0x7f0b2443, float:1.8495097E38)
            android.view.View r5 = r4.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131436606(0x7f0b243e, float:1.8495087E38)
            android.view.View r6 = r4.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131436592(0x7f0b2430, float:1.8495059E38)
            android.view.View r7 = r4.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131436568(0x7f0b2418, float:1.849501E38)
            android.view.View r8 = r4.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131436593(0x7f0b2431, float:1.849506E38)
            android.view.View r9 = r4.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131436569(0x7f0b2419, float:1.8495012E38)
            android.view.View r10 = r4.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131436596(0x7f0b2434, float:1.8495067E38)
            android.view.View r11 = r4.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131433259(0x7f0b172b, float:1.8488299E38)
            android.view.View r12 = r4.b(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r13 = 2131433700(0x7f0b18e4, float:1.8489193E38)
            android.view.View r13 = r4.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r14 = 2131435362(0x7f0b1f62, float:1.8492564E38)
            android.view.View r14 = r4.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r15 = 2131433697(0x7f0b18e1, float:1.8489187E38)
            android.view.View r15 = r4.b(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r31 = r11
            r11 = 2131427608(0x7f0b0118, float:1.8476837E38)
            android.view.View r11 = r4.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r1 = 2131432237(0x7f0b132d, float:1.8486226E38)
            android.view.View r1 = r4.b(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r33 = r1
            r1 = 2131435814(0x7f0b2126, float:1.849348E38)
            android.view.View r1 = r4.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r16 = r1
            r1 = 2131435363(0x7f0b1f63, float:1.8492566E38)
            android.view.View r1 = r4.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r17 = r1
            r1 = 2131436587(0x7f0b242b, float:1.8495049E38)
            android.view.View r1 = r4.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r18 = r9
            java.lang.String r9 = r32.getSource()
            r19 = r10
            java.lang.String r10 = "fl"
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x00d1
            r9 = 0
            goto L_0x00d3
        L_0x00d1:
            r9 = 8
        L_0x00d3:
            r1.setVisibility(r9)
            java.lang.String r1 = r32.getType()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r9 = 2131436866(0x7f0b2542, float:1.8495615E38)
            android.view.View r4 = r4.b(r9)
            android.widget.TextView r4 = (android.widget.TextView) r4
            d7.a1 r9 = d7.a1.v()
            java.lang.String r10 = r32.getSymbolId()
            r21 = r8
            com.hbg.lib.data.symbol.TradeType r8 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r8 = r9.J(r10, r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            if (r8 == 0) goto L_0x010c
            java.lang.String r10 = r8.getBaseCurrencyDisplayName()
            java.lang.String r8 = r8.getQuoteCurrencyDisplayName()
            r26 = r6
            r25 = r7
            goto L_0x017b
        L_0x010c:
            d7.a1 r8 = d7.a1.v()
            java.util.List r8 = r8.j()
            java.util.Iterator r8 = r8.iterator()
            java.lang.String r10 = ""
            r22 = r10
        L_0x011c:
            boolean r23 = r8.hasNext()
            if (r23 == 0) goto L_0x0171
            java.lang.Object r23 = r8.next()
            r24 = r8
            r8 = r23
            java.lang.String r8 = (java.lang.String) r8
            r23 = r10
            java.lang.String r10 = r32.getSymbolId()
            int r10 = r10.lastIndexOf(r8)
            if (r10 <= 0) goto L_0x0164
            d7.k r10 = d7.k.C()
            java.lang.String r10 = r10.z(r8)
            r22 = r10
            d7.k r10 = d7.k.C()
            r25 = r7
            java.lang.String r7 = r32.getSymbolId()
            r26 = r6
            java.lang.String r6 = r32.getSymbolId()
            int r6 = r6.lastIndexOf(r8)
            r8 = 0
            java.lang.String r6 = r7.substring(r8, r6)
            java.lang.String r6 = r10.z(r6)
            r10 = r22
            r22 = r6
            goto L_0x016a
        L_0x0164:
            r26 = r6
            r25 = r7
            r10 = r23
        L_0x016a:
            r8 = r24
            r7 = r25
            r6 = r26
            goto L_0x011c
        L_0x0171:
            r26 = r6
            r25 = r7
            r23 = r10
            r10 = r22
            r8 = r23
        L_0x017b:
            r9.append(r10)
            java.lang.String r6 = "/"
            r9.append(r6)
            r9.append(r8)
            java.lang.String r6 = r9.toString()
            r4.setText(r6)
            bt.i2 r6 = new bt.i2
            r6.<init>(r3, r2)
            r4.setOnClickListener(r6)
            java.lang.String r6 = r32.getSource()
            java.lang.String r7 = r32.getType()
            java.lang.String r6 = com.huobi.trade.bean.TradeOrderType.a(r6, r7, r3)
            r5.setText(r6)
            bt.h2 r6 = new bt.h2
            r6.<init>(r3, r2)
            r5.setOnClickListener(r6)
            boolean r6 = com.huobi.trade.bean.TradeOrderType.c(r1)
            java.lang.String r7 = "sell-market"
            java.lang.String r9 = "buy-market"
            r22 = r4
            java.lang.String r4 = "(%s)"
            r28 = r7
            if (r6 == 0) goto L_0x0279
            int r6 = com.hbg.lib.core.util.w.h()
            int r6 = androidx.core.content.ContextCompat.getColor(r3, r6)
            r5.setTextColor(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r7 = r3.getString(r7)
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r7 = 1
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r20 = 0
            r0[r20] = r8
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r13.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r14.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r15.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r20] = r10
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r12.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r20] = r10
            java.lang.String r0 = java.lang.String.format(r0, r4)
            r11.setText(r0)
        L_0x026f:
            r0 = r29
        L_0x0271:
            r27 = r9
            r6 = r28
            r28 = r5
            goto L_0x050f
        L_0x0279:
            boolean r0 = com.huobi.trade.bean.TradeOrderType.d(r1)
            if (r0 == 0) goto L_0x0334
            int r0 = com.hbg.lib.core.util.w.d()
            int r0 = androidx.core.content.ContextCompat.getColor(r3, r0)
            r5.setTextColor(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r20 = 0
            r7[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r7)
            r13.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r7 = r3.getString(r7)
            r0.append(r7)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r7)
            r14.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r7 = r3.getString(r7)
            r0.append(r7)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r7)
            r15.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r7 = r3.getString(r7)
            r0.append(r7)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r20] = r10
            java.lang.String r0 = java.lang.String.format(r0, r7)
            r12.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r7 = r3.getString(r7)
            r0.append(r7)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r20] = r10
            java.lang.String r0 = java.lang.String.format(r0, r4)
            r11.setText(r0)
            goto L_0x026f
        L_0x0334:
            boolean r0 = r9.equals(r1)
            if (r0 == 0) goto L_0x041d
            int r0 = com.hbg.lib.core.util.w.h()
            int r0 = androidx.core.content.ContextCompat.getColor(r3, r0)
            r5.setTextColor(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r7 = r3.getString(r7)
            r0.append(r7)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r7 = 1
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r20 = 0
            r6[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r13.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r14.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r6 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r6 = r3.getString(r6)
            r0.append(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r20] = r8
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r15.setText(r0)
            r0 = r29
            boolean r6 = r0.g(r2)
            if (r6 != 0) goto L_0x03d7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 2132021970(0x7f1412d2, float:1.9682346E38)
            java.lang.String r7 = r3.getString(r7)
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r7 = 1
            java.lang.Object[] r13 = new java.lang.Object[r7]
            r14 = 0
            r13[r14] = r8
            java.lang.String r6 = java.lang.String.format(r6, r13)
            r12.setText(r6)
            goto L_0x03fa
        L_0x03d7:
            r7 = 1
            r14 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r8 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r8 = r3.getString(r8)
            r6.append(r8)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r8[r14] = r10
            java.lang.String r6 = java.lang.String.format(r6, r8)
            r12.setText(r6)
        L_0x03fa:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r8 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r8 = r3.getString(r8)
            r6.append(r8)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.Object[] r6 = new java.lang.Object[r7]
            r6[r14] = r10
            java.lang.String r4 = java.lang.String.format(r4, r6)
            r11.setText(r4)
            goto L_0x0271
        L_0x041d:
            r0 = r29
            r6 = r28
            boolean r7 = r6.equals(r1)
            if (r7 == 0) goto L_0x050b
            int r7 = com.hbg.lib.core.util.w.d()
            int r7 = androidx.core.content.ContextCompat.getColor(r3, r7)
            r5.setTextColor(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r28 = r5
            r5 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r5 = r3.getString(r5)
            r7.append(r5)
            r7.append(r4)
            java.lang.String r5 = r7.toString()
            r27 = r9
            r7 = 1
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r20 = 0
            r9[r20] = r8
            java.lang.String r5 = java.lang.String.format(r5, r9)
            r13.setText(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r9 = 2132021964(0x7f1412cc, float:1.9682334E38)
            java.lang.String r9 = r3.getString(r9)
            r5.append(r9)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r9[r20] = r8
            java.lang.String r5 = java.lang.String.format(r5, r9)
            r14.setText(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r9 = 2132021963(0x7f1412cb, float:1.9682332E38)
            java.lang.String r9 = r3.getString(r9)
            r5.append(r9)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r9[r20] = r8
            java.lang.String r5 = java.lang.String.format(r5, r9)
            r15.setText(r5)
            boolean r5 = r0.g(r2)
            if (r5 == 0) goto L_0x04c6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r7 = 2132021970(0x7f1412d2, float:1.9682346E38)
            java.lang.String r7 = r3.getString(r7)
            r5.append(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            r7 = 1
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r13 = 0
            r9[r13] = r8
            java.lang.String r5 = java.lang.String.format(r5, r9)
            r12.setText(r5)
            goto L_0x04e9
        L_0x04c6:
            r7 = 1
            r13 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r8 = 2132021956(0x7f1412c4, float:1.9682318E38)
            java.lang.String r8 = r3.getString(r8)
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r8[r13] = r10
            java.lang.String r5 = java.lang.String.format(r5, r8)
            r12.setText(r5)
        L_0x04e9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r8 = 2132021938(0x7f1412b2, float:1.9682281E38)
            java.lang.String r8 = r3.getString(r8)
            r5.append(r8)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r13] = r10
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r11.setText(r4)
            goto L_0x050f
        L_0x050b:
            r28 = r5
            r27 = r9
        L_0x050f:
            long r4 = r32.getOrder_time()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r7
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.D(r4)
            r5 = r26
            r5.setText(r4)
            boolean r4 = r6.equals(r1)
            if (r4 != 0) goto L_0x055e
            r4 = r27
            boolean r7 = r4.equals(r1)
            if (r7 == 0) goto L_0x0532
            r8 = r21
            r7 = r25
            goto L_0x0564
        L_0x0532:
            java.lang.String r1 = r32.getOrder_price()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.A(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r7 = r25
            r7.setText(r1)
            java.lang.String r1 = r32.getOrder_amount()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.z(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r8 = r21
            r8.setText(r1)
            goto L_0x05ce
        L_0x055e:
            r8 = r21
            r7 = r25
            r4 = r27
        L_0x0564:
            r9 = 2132021960(0x7f1412c8, float:1.9682326E38)
            r7.setText(r9)
            boolean r9 = r0.g(r2)
            if (r9 == 0) goto L_0x059b
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0587
            java.lang.String r1 = r32.getMarketAmount()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.C(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            goto L_0x0597
        L_0x0587:
            java.lang.String r1 = r32.getMarketAmount()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.y(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
        L_0x0597:
            r8.setText(r1)
            goto L_0x05ce
        L_0x059b:
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x05b5
            java.lang.String r1 = r32.getOrder_tprice()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.y(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r8.setText(r1)
            goto L_0x05ce
        L_0x05b5:
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x05ce
            java.lang.String r1 = r32.getOrder_amount()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.C(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r8.setText(r1)
        L_0x05ce:
            java.lang.String r1 = r32.getTamount()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.z(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r10 = r19
            r10.setText(r1)
            java.lang.String r1 = r32.getAprice()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x05f2
            java.lang.String r1 = "0"
            r2.setAprice(r1)
        L_0x05f2:
            java.lang.String r1 = r32.getAprice()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.A(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r9 = r18
            r9.setText(r1)
            java.lang.String r1 = r32.getTprice()
            java.lang.String r4 = r32.getSymbolId()
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.y(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            r4 = r17
            r4.setText(r1)
            r1 = r30
            v9.c r1 = (v9.c) r1
            android.view.View r6 = r1.itemView
            bt.j2 r11 = new bt.j2
            r11.<init>(r3, r2)
            r6.setOnClickListener(r11)
            int r6 = r0.e(r2)
            r11 = 2131099916(0x7f06010c, float:1.7812199E38)
            r12 = 0
            if (r6 != 0) goto L_0x068f
            r6 = 2132021953(0x7f1412c1, float:1.9682312E38)
            r13 = r31
            r13.setText(r6)
            android.view.View r6 = r1.itemView
            r14 = 0
            r6.setClickable(r14)
            r13.setCompoundDrawablesWithIntrinsicBounds(r12, r12, r12, r12)
            android.view.View r1 = r1.itemView
            android.content.res.Resources r6 = r3.getResources()
            r12 = 2131099871(0x7f0600df, float:1.7812107E38)
            int r6 = r6.getColor(r12)
            r1.setBackgroundColor(r6)
            r1 = 1056964608(0x3f000000, float:0.5)
            r6 = r28
            r6.setAlpha(r1)
            android.content.res.Resources r1 = r3.getResources()
            int r1 = r1.getColor(r11)
            r14 = r22
            r14.setTextColor(r1)
            android.content.res.Resources r1 = r3.getResources()
            r6 = 2131099934(0x7f06011e, float:1.7812235E38)
            int r1 = r1.getColor(r6)
            r13.setTextColor(r1)
            android.content.res.Resources r1 = r3.getResources()
            int r1 = r1.getColor(r11)
            r15 = r33
            r3 = 0
            r15.setVisibility(r3)
            java.lang.String r2 = r32.getCanceledSourceDesc()
            r3 = r16
            r3.setText(r2)
            goto L_0x06e0
        L_0x068f:
            r13 = r31
            r15 = r33
            r14 = r22
            r6 = r28
            r2 = 8
            r15.setVisibility(r2)
            android.view.View r2 = r1.itemView
            r15 = 1
            r2.setClickable(r15)
            r2 = 2132021954(0x7f1412c2, float:1.9682314E38)
            r13.setText(r2)
            r2 = 2131232593(0x7f080751, float:1.80813E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r3, r2)
            r13.setCompoundDrawablesWithIntrinsicBounds(r12, r12, r2, r12)
            android.view.View r1 = r1.itemView
            r2 = 2131234925(0x7f08106d, float:1.808603E38)
            r1.setBackgroundResource(r2)
            r1 = 1065353216(0x3f800000, float:1.0)
            r6.setAlpha(r1)
            android.content.res.Resources r1 = r3.getResources()
            r2 = 2131099907(0x7f060103, float:1.781218E38)
            int r1 = r1.getColor(r2)
            r14.setTextColor(r1)
            android.content.res.Resources r1 = r3.getResources()
            int r1 = r1.getColor(r11)
            r13.setTextColor(r1)
            android.content.res.Resources r1 = r3.getResources()
            int r1 = r1.getColor(r2)
        L_0x06e0:
            r5.setTextColor(r1)
            r7.setTextColor(r1)
            r8.setTextColor(r1)
            r4.setTextColor(r1)
            r9.setTextColor(r1)
            r10.setTextColor(r1)
            return
        L_0x06f3:
            java.lang.String r1 = "shoud not be here"
            i6.d.d(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.handler.TradeOrderHistoryHandler.handleView(java.lang.Object, int, com.huobi.trade.bean.TradeOrderHistory, android.view.ViewGroup):void");
    }

    public final boolean g(TradeOrderHistory tradeOrderHistory) {
        return m.a(tradeOrderHistory.getMarketAmount()).compareTo(BigDecimal.ZERO) > 0;
    }

    public int getResId() {
        return R.layout.myorder_history_item_parent;
    }
}
